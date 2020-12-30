package site.geni.netherhigher.mixins.common.generators;

import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import site.geni.netherhigher.NetherHigher;

@SuppressWarnings("unused")
@Mixin(ChunkGeneratorSettings.class)
public abstract class ChunkGeneratorSettingsMixin {
	/**
	 * Sets Buffet's Caves'/The Nether's chunk generator type's height limit to the one set in the mod's configuration
	 *
	 * @param original Original integer value of 128
	 * @return Either the default of 128 or 256, depending on the mod's configuration
	 * @author geni
	 */
	@ModifyConstant(
		constant = @Constant(
			intValue = 128
		),
		method = "createUndergroundSettings"
	)
	private static int setHeightLimitConstructor(int original) {
		return NetherHigher.getConfig().raiseNetherHeightLimit.getValue() ? 256 : original;
	}

	/**
	 * Sets Buffet's Floating Islands'/The End's chunk generator type's maximum Y to 256, depending on the mod's configuration
	 *
	 * @param original Original integer value of 128
	 * @return Either 256 or the default of 128, depending on the mod's configuration
	 * @author geni
	 */
	@ModifyConstant(
			constant = @Constant(
					intValue = 128
			),
			method = "createIslandSettings"
	)
	private static int setMaxY(int original) {
		return NetherHigher.getConfig().raiseEndHeightLimit.getValue() ? 256 : original;
	}
}
