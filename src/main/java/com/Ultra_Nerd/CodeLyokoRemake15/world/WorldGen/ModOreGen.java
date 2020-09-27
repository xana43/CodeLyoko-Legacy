package com.Ultra_Nerd.CodeLyokoRemake15.world.WorldGen;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class ModOreGen {

    public static void genOre() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            //coffinite, uraninite, gummite,torbernite
            if (biome == Biomes.BADLANDS || biome == Biomes.BADLANDS_PLATEAU || biome == Biomes.ERODED_BADLANDS
                    || biome == Biomes.MODIFIED_BADLANDS_PLATEAU || biome == Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU
                    || biome == Biomes.WOODED_BADLANDS_PLATEAU || biome == Biomes.SWAMP || biome == Biomes.SWAMP_HILLS
                    || biome == Biomes.DEEP_WARM_OCEAN
                    || biome == Biomes.WARM_OCEAN || biome == Biomes.JUNGLE || biome == Biomes.JUNGLE_HILLS
                    || biome == Biomes.JUNGLE_EDGE || biome == Biomes.MODIFIED_JUNGLE || biome == Biomes.MODIFIED_JUNGLE_EDGE
                    || biome == Biomes.BAMBOO_JUNGLE || biome == Biomes.BAMBOO_JUNGLE_HILLS
                    || biome == Biomes.DESERT_LAKES || biome == Biomes.DESERT) {
                ConfiguredPlacement customC = Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 10, 3, 30));
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                        .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                ModBlocks.COFFINITE_ORE.get().getDefaultState(), 10)).withPlacement(customC));
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,Feature.ORE.withConfiguration(new OreFeatureConfig(
                        OreFeatureConfig.FillerBlockType.NATURAL_STONE,ModBlocks.URANINITE_ORE.get().getDefaultState(),10)).withPlacement(customC));
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,Feature.ORE.withConfiguration(new OreFeatureConfig(
                        OreFeatureConfig.FillerBlockType.NATURAL_STONE,ModBlocks.GUMMITE_ORE.get().getDefaultState(),5)).withPlacement(customC));
                if(biome.isHighHumidity())
                {
                    biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,Feature.ORE.withConfiguration(new OreFeatureConfig(
                            OreFeatureConfig.FillerBlockType.NATURAL_STONE,ModBlocks.TORBERNITE_ORE.get().getDefaultState(),5)).withPlacement(customC));
                    biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,Feature.ORE.withConfiguration(new OreFeatureConfig(
                            OreFeatureConfig.FillerBlockType.NATURAL_STONE,ModBlocks.AUTUNITE_ORE.get().getDefaultState(),5)).withPlacement(customC));
                }
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,Feature.ORE.withConfiguration(new OreFeatureConfig(
                        OreFeatureConfig.FillerBlockType.NATURAL_STONE,ModBlocks.METATORBERNITE_ORE.get().getDefaultState(),5)).withPlacement(customC));
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,Feature.ORE.withConfiguration(new OreFeatureConfig(
                        OreFeatureConfig.FillerBlockType.NATURAL_STONE,ModBlocks.METAAUTUNITE_ORE.get().getDefaultState(),5)).withPlacement(customC));
            }


            //carnotite
            if (biome == Biomes.DESERT || biome == Biomes.DESERT_HILLS || biome == Biomes.SAVANNA ||
                    biome == Biomes.SAVANNA_PLATEAU || biome == Biomes.SHATTERED_SAVANNA || biome == Biomes.SHATTERED_SAVANNA_PLATEAU) {
                ConfiguredPlacement customC = Placement.COUNT_RANGE.configure(new CountRangeConfig(9, 7, 7, 40));
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                        .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                ModBlocks.CARNOTITE_ORE.get().getDefaultState(), 20)).withPlacement(customC));
            }

            //tyuyamunite and meta-tyuyamunite
            if (biome == Biomes.MOUNTAINS || biome == Biomes.MOUNTAIN_EDGE) {
                ConfiguredPlacement custom = Placement.COUNT_RANGE.configure(new CountRangeConfig(2, 7, 7, 10));
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                        .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                ModBlocks.TYUYAMUNITE_ORE.get().getDefaultState(), 3)).withPlacement(custom));

            } else {
                ConfiguredPlacement custom2 = Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 14, 14, 20));
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                        .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.
                                NATURAL_STONE, ModBlocks.METATYUYAMUNITE_ORE.get().getDefaultState(), 6))
                        .withPlacement(custom2));
            }
        }
    }


}
