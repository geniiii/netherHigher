package site.geni.netherhigher.mixins.common.world.gen.surfacebuilder;

import net.minecraft.world.gen.surfacebuilder.SoulSandValleySurfaceBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import site.geni.netherhigher.NetherHigher;

@Mixin(SoulSandValleySurfaceBuilder.class)
public abstract class SoulSandValleySurfaceBuilderMixin {
	/**
	 * Sets the height limit to 255, depending on the mod's configuration
	 *
	 * @param original The original integer value of 127
	 * @return Either 255 or the default of 127, depending on the mod's configuration
	 * @author geni
	 */
	@ModifyConstant(
		constant = @Constant(
			intValue = 127
		),
		method = "generate"
	)
	private static int setHeightLimit(int original) {
		return NetherHigher.getConfig().raiseNetherHeightLimit.getValue() ? 255 : original;
	}
}
