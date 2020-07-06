package com.Ultra_Nerd.CodeLyokoRemake15.world;

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

public static void genOre()
{
    for(Biome biome : ForgeRegistries.BIOMES)
    {
        if(biome == Biomes.MOUNTAINS)
        {
            ConfiguredPlacement custom = Placement.COUNT_RANGE.configure(new CountRangeConfig(2,7,7,20));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                    .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                    ModBlocks.TYUYAMUNITE_ORE.get().getDefaultState(),3)).withPlacement(custom));

        }
        else
        {
            ConfiguredPlacement custom2 = Placement.COUNT_RANGE.configure(new CountRangeConfig(4,14,14,20));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,Feature.ORE
                    .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,ModBlocks.METATYUYAMUNITE_ORE.get().getDefaultState(),6))
            .withPlacement(custom2));
        }
    }
}
	
	

}
