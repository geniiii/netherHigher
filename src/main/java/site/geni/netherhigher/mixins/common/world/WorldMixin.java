package site.geni.netherhigher.mixins.common.world;

import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import site.geni.netherhigher.NetherHigher;

@SuppressWarnings("unused")
@Mixin(World.class)
public abstract class WorldMixin {
	/**
	 * Sets the effective height to 256, depending on the mod's configuration
	 *
	 * @param original Original integer value of 128
	 * @return Either 256 or the default of 128, depending on the mod's configuration
	 * @author geni
	 */
	@ModifyConstant(
		constant = @Constant(
			intValue = 128
		),
		method = "getEffectiveHeight"
	)
	private static int getEffectiveHeightNew(int original) {
		return NetherHigher.getConfig().raiseNetherHeightLimit.getValue() ? 256 : original;
	}
}
