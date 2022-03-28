package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModFeature {

    //public static final DeferredRegister<Feature<?>> LYOKOFEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, CodeLyokoMain.MOD_ID);

    //public static final RegistryObject<Feature<TreeConfiguration>> DIGITAL_FOREST_TREE = LYOKOFEATURES.register("digital_forest_tree", () -> new DigitalForestTree(TreeConfiguration.CODEC));

//configured features


public static final Holder<ConfiguredFeature<TreeConfiguration,?>> DIGITAL_FOREST_TREE_FEATURE =
        FeatureUtils.register(CodeLyokoMain.CodeLyokoPrefix("digital_forest_tree").toString(),Feature.TREE,new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.DIGITAL_WOOD_FOREST.get()),
                new StraightTrunkPlacer(319,319,319),
                BlockStateProvider.simple(Blocks.AIR),
                new BlobFoliagePlacer(ConstantInt.of(0),ConstantInt.of(0),0),
                new TwoLayersFeatureSize(81,16,16)).build());

public static final Holder<ConfiguredFeature<TreeConfiguration,?>> DIGITAL_MOUNTAIN_TREE_FEATURE =
        FeatureUtils.register(CodeLyokoMain.CodeLyokoPrefix("digital_mountain_tree").toString(),Feature.TREE,new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.DIGITAL_WOOD_MOUNTAIN.get()),
                    new BendingTrunkPlacer(10,10,10,10,ConstantInt.of(5)),
                    BlockStateProvider.simple(ModBlocks.DIGITAL_LEAF_MOUNTAIN.get()),
                    new BlobFoliagePlacer(ConstantInt.of(1),ConstantInt.of(2),3),
                    new TwoLayersFeatureSize(5,10,10)).build());

public static final Holder<PlacedFeature> DIGITAL_FOREST_PLACED = PlacementUtils.register("forest_placed",
        DIGITAL_FOREST_TREE_FEATURE, VegetationPlacements.treePlacement(
                PlacementUtils.countExtra(3,0.1f,2)
        )
        );
    public static final Holder<PlacedFeature> DIGITAL_MOUNTAIN_PLACED = PlacementUtils.register("mountain_placed",
            DIGITAL_FOREST_TREE_FEATURE, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3,0.1f,2)
            )
    );
}
