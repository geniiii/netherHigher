package site.geni.netherhigher.mixins.common.generators;

import net.minecraft.world.gen.chunk.FloatingIslandsChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import site.geni.netherhigher.NetherHigher;

@SuppressWarnings("unused")
@Mixin(FloatingIslandsChunkGenerator.class)
public abstract class FloatingIslandsChunkGeneratorMixin {
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
		method = "<init>"
	)
	private static int setMaxY(int original) {
		return NetherHigher.getConfig().raiseEndHeightLimit.getValue() ? 256 : original;
	}
}
