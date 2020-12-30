package site.geni.netherhigher.mixins.common.world.gen.feature;

import net.minecraft.world.gen.feature.ConfiguredFeatures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import site.geni.netherhigher.NetherHigher;

@Mixin(ConfiguredFeatures.class)
public abstract class ConfiguredFeaturesMixin {
	/**
	 * Sets the default height limit for all features that are at 128 to 256, depending on the mod's configuration
	 *
	 * FIXME: This is not an optional way of doing this as this also changes coal ore generation along with all the nether-specific stuff.
	 *  Given the data-driven nature that Mojang has been pushing, it may be possible that this can be replaced with a datapack, or at least not be as low-level hacky.
	 *
	 * @param original Original integer value of 128
	 * @return Either 256 or the default of 128, depending on the mod's configuration
	 * @author KJP12
	 */
	@SuppressWarnings("UnresolvedMixinReference")
	@ModifyConstant(
		constant = @Constant(
			intValue = 128
		),
		method = "<clinit>"
	)
	private static int setHeightLimit(int original) {
		return NetherHigher.getConfig().raiseNetherHeightLimit.getValue() ? 256 : original;
	}
}
