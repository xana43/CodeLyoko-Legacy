package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Blocks;
import net.minecraft.util.Pair;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.Arrays;

public record ModFeature() {


    private record ForestFeatures()
    {

        private static final TreeFeatureConfig.Builder FOREST_TREE_CONFIG = new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.DIGITAL_WOOD_FOREST),
                new StraightTrunkPlacer(8,3,0),
                BlockStateProvider.of(Blocks.AIR),
                new BlobFoliagePlacer(ConstantIntProvider.create(2),ConstantIntProvider.create(4),1),
                new TwoLayersFeatureSize(1,0,1)
        ).dirtProvider(BlockStateProvider.of(ModBlocks.DIGITAL_WOOD_FOREST));
        private static final ConfiguredFeature<?,?> FOREST_TREE = new ConfiguredFeature<>(Feature.TREE, FOREST_TREE_CONFIG.build());
    }

    private record OreFeatures()
    {

        //coffinite
        private static final ConfiguredFeature<?,?> OVERWORLD_COFFINITE_ORE_CONFIG = new ConfiguredFeature<>(
                Feature.ORE,new OreFeatureConfig(
                OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                ModBlocks.COFFINITE_ORE.getDefaultState(),
        8));
    }


    public record PlacedFeatures()
    {

        public static final PlacedFeature FOREST_TREE_PLACED = new PlacedFeature(
                RegistryEntry.of(ForestFeatures.FOREST_TREE),
                Arrays.asList(CountPlacementModifier.of(5), SquarePlacementModifier.of(),HeightRangePlacementModifier.uniform(YOffset.TOP,YOffset.TOP))
        );
        public static final PlacedFeature OVERWORLD_COFFINITE_ORE_PLACED = new PlacedFeature(
                RegistryEntry.of(OreFeatures.OVERWORLD_COFFINITE_ORE_CONFIG),
                Arrays.asList(
                        CountPlacementModifier.of(10),
                        SquarePlacementModifier.of(),
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(),YOffset.fixed(40))
                ));
    }


    public static final ImmutableMap<String, Pair<ConfiguredFeature<?,?>, PlacedFeature>> CONFIGURED_TREE_IMMUTABLE_MAP = ImmutableMap.<String,Pair<ConfiguredFeature<?,?>, PlacedFeature>>builder()
            .put("lyoko_forest_tree",new Pair<>(ForestFeatures.FOREST_TREE, PlacedFeatures.FOREST_TREE_PLACED))
            .put("coffinite_ore_overworld",new Pair<>(OreFeatures.OVERWORLD_COFFINITE_ORE_CONFIG,PlacedFeatures.OVERWORLD_COFFINITE_ORE_PLACED))
            .build();
/*
    public static final DeferredRegister<StructureFeature<?>> LYOKOFEATURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, CodeLyokoMain.MOD_ID);

    //public static final RegistryObject<Feature<TreeConfiguration>> DIGITAL_FOREST_TREE = LYOKOFEATURES.register("digital_forest_tree", () -> new DigitalForestTree(TreeConfiguration.CODEC));
    public static Holder<ConfiguredFeature<TreeConfiguration,?>> DIGITAL_FOREST_TREE_FEATURE;
    public static Holder<ConfiguredFeature<TreeConfiguration,?>> DIGITAL_MOUNTAIN_TREE_FEATURE;
    public static final RegistryObject<StructureFeature<?>> TOWER_STRUCTURE = LYOKOFEATURES.register("TowerBase",TowerStructure::new);
    public static Holder<PlacedFeature> DIGITAL_FOREST_PLACED;
    public static Holder<PlacedFeature> DIGITAL_MOUNTAIN_PLACED;

    //configured features
public static void setConfigurations()
{


    DIGITAL_FOREST_TREE_FEATURE = FeatureUtils.register(CodeLyokoMain.CodeLyokoPrefix("digital_forest_tree").toString(),Feature.TREE,new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(ModBlocks.DIGITAL_WOOD_FOREST.get()),
            new GiantTrunkPlacer(24,24,24),
            BlockStateProvider.simple(Blocks.AIR),
            new BlobFoliagePlacer(ConstantInt.of(0),ConstantInt.of(0),0),
            new ThreeLayersFeatureSize(80,8,8,8,8, OptionalInt.of(8))).dirt(BlockStateProvider.simple(ModBlocks.DIGITAL_WOOD_FOREST.get())).build());
    DIGITAL_MOUNTAIN_TREE_FEATURE =

            FeatureUtils.register(CodeLyokoMain.CodeLyokoPrefix("digital_mountain_tree").toString(),Feature.TREE,new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.DIGITAL_WOOD_MOUNTAIN.get()),
                    new ForkingTrunkPlacer(5,2,2),
                    BlockStateProvider.simple(ModBlocks.DIGITAL_LEAF_MOUNTAIN.get()),
                    new AcaciaFoliagePlacer(ConstantInt.of(2),ConstantInt.of(0)),
                    new TwoLayersFeatureSize(1,0,2)).build());
    DIGITAL_FOREST_PLACED = PlacementUtils.register("forest_placed",
            DIGITAL_FOREST_TREE_FEATURE, VegetationPlacements.treePlacement(
                     PlacementUtils.countExtra(3,0.5f,2)
            )
    );

    DIGITAL_MOUNTAIN_PLACED = PlacementUtils.register("mountain_placed",
            DIGITAL_MOUNTAIN_TREE_FEATURE, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1,0.1f,0)
            )
    );
}

 */








}
