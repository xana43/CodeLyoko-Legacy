package io.github.elsopeen.lyokomod.world;

import io.github.elsopeen.lyokomod.init.ModBiomes;
import io.github.elsopeen.lyokomod.init.ModBlocks;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class LyokoOreGen {
    public static void generateOre() {
        ForgeRegistries.BIOMES.iterator().forEachRemaining(
            (biome) -> {
                if(!(biome == ModBiomes.FOREST.get() || biome == ModBiomes.MOUNTAIN.get() ||
                    biome == ModBiomes.BANQUISE.get() || biome == ModBiomes.DESERT.get())) {
                    ConfiguredPlacement<?> customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(8,
                        1,0, 30));
                    biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(
                        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.SALEEITE_ORE.get().getDefaultState(),
                            10)).withPlacement(customConfig));
                }

                }
        );
    }
}
