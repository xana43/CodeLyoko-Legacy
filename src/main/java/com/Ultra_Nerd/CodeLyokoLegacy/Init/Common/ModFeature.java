package com.Ultra_Nerd.CodeLyokoLegacy.Init.Common;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectObjectImmutablePair;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.TagMatchRuleTest;
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
        Object2ObjectMaps.fastForEach(CONFIGURED_TREE_IMMUTABLE_MAP,stringObjectObjectImmutablePairEntry -> ConfiguredFeatures.register(registerable,ConfiguredFeatures.of(stringObjectObjectImmutablePairEntry.getKey()),Feature.TREE, stringObjectObjectImmutablePairEntry.getValue().left().build()));
    }

    public static final Object2ObjectMap<String, ObjectObjectImmutablePair<TreeFeatureConfig.Builder, PlacedFeature>> CONFIGURED_TREE_IMMUTABLE_MAP = Object2ObjectMaps.unmodifiable(
            new Object2ObjectOpenHashMap<>(){{
                    put("lyoko_forest_tree", new ObjectObjectImmutablePair<>(ForestFeatures.FOREST_TREE_CONFIG, PlacedFeatures.FOREST_TREE_PLACED));
                }});
    public static final Object2ObjectMap<String, ObjectObjectImmutablePair<ConfiguredFeature<?, ?>, PlacedFeature>> ORE_IMMUTABLE_MAP =
            Object2ObjectMaps.unmodifiable( new Object2ObjectOpenHashMap<>(){{
            put("autunite_ore_overworld",new ObjectObjectImmutablePair<>(OreFeatures.OVERWORLD_AUTUNITE_ORE_CONFIG,PlacedFeatures.OVERWORLD_AUTUNITE_ORE_PLACED));
            put("bornite_ore_overworld",new ObjectObjectImmutablePair<>(OreFeatures.OVERWORLD_BORNITE_ORE_CONFIG,PlacedFeatures.OVERWORLD_BORNITE_ORE_PLACED));
            put("coffinite_ore_overworld", new ObjectObjectImmutablePair<>(OreFeatures.OVERWORLD_COFFINITE_ORE_CONFIG, PlacedFeatures.OVERWORLD_COFFINITE_ORE_PLACED));

            }});
    public static final Object2ObjectMap<String,ObjectObjectImmutablePair<ConfiguredFeature<?,?>,PlacedFeature>> MISC_IMMUTABLE_MAP =
            Object2ObjectMaps.unmodifiable( new Object2ObjectOpenHashMap<>(){{
            put("lyoko_lava_lake", new ObjectObjectImmutablePair<>(MiscFeatures.LAVA_LAKE_CONFIG, PlacedFeatures.LAVA_LAKE_VOLCANO_PLACED));

            }});

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
        //autunite
        private static final ConfiguredFeature<?, ?> OVERWORLD_AUTUNITE_ORE_CONFIG = new ConfiguredFeature<>(
                Feature.ORE, new OreFeatureConfig(
                new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES),
                ModBlocks.AUTUNITE_ORE.getDefaultState(),
                4));
        private static final ConfiguredFeature<?, ?> OVERWORLD_BORNITE_ORE_CONFIG = new ConfiguredFeature<>(
                Feature.ORE, new OreFeatureConfig(
                new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES),
                ModBlocks.BORNITE_ORE.getDefaultState(),
                2));
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
        //ore placers
        public static final PlacedFeature OVERWORLD_AUTUNITE_ORE_PLACED = new PlacedFeature(
                RegistryEntry.of(OreFeatures.OVERWORLD_AUTUNITE_ORE_CONFIG),
                Arrays.asList(
                        CountPlacementModifier.of(5),
                        SquarePlacementModifier.of(),
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(30))
                ));
        public static final PlacedFeature OVERWORLD_BORNITE_ORE_PLACED = new PlacedFeature(
                RegistryEntry.of(OreFeatures.OVERWORLD_BORNITE_ORE_CONFIG),
                Arrays.asList(
                        CountPlacementModifier.of(2),
                        SquarePlacementModifier.of(),
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(40))
                ));
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
