package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.world.ModFeatures.structures.Tower.TowerStructure;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.OptionalInt;

public final class ModFeature {

    public static final DeferredRegister<StructureFeature<?>> LYOKOFEATURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, CodeLyokoMain.MOD_ID);

    //public static final RegistryObject<Feature<TreeConfiguration>> DIGITAL_FOREST_TREE = LYOKOFEATURES.register("digital_forest_tree", () -> new DigitalForestTree(TreeConfiguration.CODEC));
    public static Holder<ConfiguredFeature<TreeConfiguration,?>> DIGITAL_FOREST_TREE_FEATURE;
    public static Holder<ConfiguredFeature<TreeConfiguration,?>> DIGITAL_MOUNTAIN_TREE_FEATURE;
    public static final RegistryObject<StructureFeature<?>> TOWER_STRUCTURE = LYOKOFEATURES.register("tower",TowerStructure::new);
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








}
