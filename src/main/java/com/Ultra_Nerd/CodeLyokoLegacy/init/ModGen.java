package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.google.common.collect.ImmutableMap;
import net.minecraft.util.Pair;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.Arrays;

public record ModGen() {
    //coffinite
    public static final ConfiguredFeature<?,?> OVERWORLD_COFFINITE_ORE_CONFIG = new ConfiguredFeature<>(
            Feature.ORE,new OreFeatureConfig(
            OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
            ModBlocks.COFFINITE_ORE.getDefaultState(),
    8));
    public static final PlacedFeature OVERWORLD_COFFINITE_ORE_PLACED = new PlacedFeature(
            RegistryEntry.of(OVERWORLD_COFFINITE_ORE_CONFIG),
            Arrays.asList(
                    CountPlacementModifier.of(10),
                    SquarePlacementModifier.of(),
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(),YOffset.fixed(40))
            ));

    public static final ImmutableMap<String, Pair<ConfiguredFeature<?,?>, PlacedFeature>> FEATURE_PAIR_MAP = ImmutableMap.<String,Pair<ConfiguredFeature<?,?>,PlacedFeature>>builder()
            .put("overworld_coffinite",new Pair<>(OVERWORLD_COFFINITE_ORE_CONFIG,OVERWORLD_COFFINITE_ORE_PLACED))







            .build();
}
