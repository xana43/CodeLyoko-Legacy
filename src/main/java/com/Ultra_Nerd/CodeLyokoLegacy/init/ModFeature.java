package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Pair;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.Arrays;

public record ModFeature() {

    public static void bootStrap(Registerable<ConfiguredFeature<?,?>> registerable)
    {

        CONFIGURED_TREE_IMMUTABLE_MAP.forEach((s, configuredFeaturePlacedFeaturePair) -> ConfiguredFeatures.register(registerable,ConfiguredFeatures.of(s),Feature.TREE, configuredFeaturePlacedFeaturePair.getLeft().build()));
    }

    public static final ImmutableMap<String, Pair<TreeFeatureConfig.Builder, PlacedFeature>> CONFIGURED_TREE_IMMUTABLE_MAP = ImmutableMap.<String, Pair<TreeFeatureConfig.Builder, PlacedFeature>>builder()
            .put("lyoko_forest_tree", new Pair<>(ForestFeatures.FOREST_TREE_CONFIG, PlacedFeatures.FOREST_TREE_PLACED))
            .build();
    public static final ImmutableMap<String, Pair<ConfiguredFeature<?, ?>, PlacedFeature>> ORE_IMMUTABLE_MAP =
            ImmutableMap.<String, Pair<ConfiguredFeature<?, ?>, PlacedFeature>>builder()
            .put("coffinite_ore_overworld", new Pair<>(OreFeatures.OVERWORLD_COFFINITE_ORE_CONFIG,
                    PlacedFeatures.OVERWORLD_COFFINITE_ORE_PLACED))
            .build();
    public static final ImmutableMap<String,Pair<ConfiguredFeature<?,?>,PlacedFeature>> MISC_IMMUTABLE_MAP = ImmutableMap.<String, Pair<ConfiguredFeature<?, ?>, PlacedFeature>>builder()
            .put("lyoko_lava_lake",new Pair<>(MiscFeatures.LAVA_LAKE_CONFIG, PlacedFeatures.LAVA_LAKE_VOLCANO_PLACED))
            .build();

    private record ForestFeatures() {

        private static final TreeFeatureConfig.Builder FOREST_TREE_CONFIG = new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.DIGITAL_WOOD_FOREST),
                new StraightTrunkPlacer(32, 24, 24),
                BlockStateProvider.of(Blocks.AIR),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(4), 1),
                new TwoLayersFeatureSize(1, 0, 1)
        ).dirtProvider(BlockStateProvider.of(ModBlocks.DIGITAL_WOOD_FOREST));
        private static final ConfiguredFeature<?, ?> FOREST_TREE = new ConfiguredFeature<>(Feature.TREE,
                FOREST_TREE_CONFIG.build());
    }

    private record OreFeatures() {

        //coffinite
        private static final ConfiguredFeature<?, ?> OVERWORLD_COFFINITE_ORE_CONFIG = new ConfiguredFeature<>(
                Feature.ORE, new OreFeatureConfig(
                new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES),
                ModBlocks.COFFINITE_ORE.getDefaultState(),
                8));
    }
    private record MiscFeatures()
    {
        private static final ConfiguredFeature<?,?> LAVA_LAKE_CONFIG =
                new ConfiguredFeature<>(Feature.LAKE,
                        new LakeFeature.Config(BlockStateProvider.of(ModBlocks.DIGITAL_LAVA_BLOCK.getDefaultState()),
                        BlockStateProvider.of(ModBlocks.VOLCANO_GROUND.getDefaultState())));
    }
    public record PlacedFeatures() {
        public static final RegistryKey<PlacedFeature> LAVA_LAKE_VOLCANO_KEY =
                RegistryKey.of(RegistryKeys.PLACED_FEATURE
                , CodeLyokoMain.codeLyokoPrefix("lyoko_lava_lake"));
        public static final PlacedFeature FOREST_TREE_PLACED = new PlacedFeature(
                RegistryEntry.of(ForestFeatures.FOREST_TREE),
                Arrays.asList(CountPlacementModifier.of(5), SquarePlacementModifier.of(),
                        net.minecraft.world.gen.feature.PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP)
        );
        public static final PlacedFeature OVERWORLD_COFFINITE_ORE_PLACED = new PlacedFeature(
                RegistryEntry.of(OreFeatures.OVERWORLD_COFFINITE_ORE_CONFIG),
                Arrays.asList(
                        CountPlacementModifier.of(10),
                        SquarePlacementModifier.of(),
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(40))
                ));
        public static final PlacedFeature LAVA_LAKE_VOLCANO_PLACED = new PlacedFeature(
                RegistryEntry.of(MiscFeatures.LAVA_LAKE_CONFIG
                ), Arrays.asList(RarityFilterPlacementModifier.of(50),SquarePlacementModifier.of(),
                                net.minecraft.world.gen.feature.PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP)
        );
    }
}
