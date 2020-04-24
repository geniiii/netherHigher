package site.geni.netherhigher.mixins.common.world.biome;

import net.minecraft.world.biome.BasaltDeltasBiome;
import net.minecraft.world.biome.CrimsonForestBiome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import site.geni.netherhigher.NetherHigher;

@Mixin(BasaltDeltasBiome.class)
public class BasaltDeltasBiomeMixin {
    /**
     * Sets the Basalt Deltas biome's features' height limit to 256, depending on the mod's configuration
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
    private static int setHeightLimit(int original) {
        return NetherHigher.getConfig().raiseNetherHeightLimit.getValue() ? 256 : original;
    }
}
