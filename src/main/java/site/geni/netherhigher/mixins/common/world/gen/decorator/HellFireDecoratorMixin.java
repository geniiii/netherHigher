package site.geni.netherhigher.mixins.common.world.gen.decorator;

import net.minecraft.world.gen.decorator.FireDecorator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import site.geni.netherhigher.NetherHigher;

@Mixin(FireDecorator.class)
public abstract class HellFireDecoratorMixin {
	/**
	 * Sets the height limit for fire generation to 120 (+ 4), depending on the mod's configuration
	 *
	 * @param original The original integer value of 120
	 * @return Either 248 or the default of 120, depending on the mod's configuration
	 * @author geni
	 */
	@ModifyConstant(
		constant = @Constant(
			intValue = 120
		),
		method = "getPositions"
	)
	private static int setHeightLimit(int original) {
		return NetherHigher.getConfig().raiseNetherHeightLimit.getValue() ? 248 : original;
	}
}
