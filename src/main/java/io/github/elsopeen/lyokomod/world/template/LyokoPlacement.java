package io.github.elsopeen.lyokomod.world.template;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;

public abstract class LyokoPlacement extends net.minecraftforge.registries.ForgeRegistryEntry<Placement<?>> {

    public static final Placement<FrequencyConfig> TOWER_MIN22 = register("tower_min22", new SurfaceMinus22(FrequencyConfig::deserialize));


    private static <T extends IPlacementConfig, G extends Placement<T>> G register(String key, G placement) {
        return (G)(Registry.<Placement<?>>register(Registry.DECORATOR, key, placement));
    }

}
