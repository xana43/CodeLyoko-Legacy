package com.Ultra_Nerd.CodeLyokoRemake15.world.WorldGen;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBiome;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModWorldFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class StructGen {

    public static void genStruct() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            //towers
            if (biome == ModBiome.DESERT.get() || biome == ModBiome.FOREST.get() || biome == ModBiome.ICE.get() || biome == ModBiome.MOUNTAIN.get() ||
                    biome == ModBiome.VOLCANO.get()) {
                biome.addStructure(ModWorldFeatures.TOWER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
            }
            biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, ModWorldFeatures.TOWER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
                    .withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));


        }
    }


}
