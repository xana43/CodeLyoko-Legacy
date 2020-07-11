package com.Ultra_Nerd.CodeLyokoRemake15.world.ModFeatures;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nullable;
import java.util.Random;

public class DigitalMountainTree extends Tree {
   public static final TreeFeatureConfig DIGITAL_TREE_MOUNATIN_CONFIG = (new TreeFeatureConfig.Builder
           (new SimpleBlockStateProvider(ModBlocks.DIGITAL_WOOD_MOUNTAIN.get().getDefaultState()),new SimpleBlockStateProvider(ModBlocks.DIGITAL_LEAF_MOUNTAIN.get().getDefaultState())
           ,new BlobFoliagePlacer(4,1))).baseHeight(5)
           .setSapling((IPlantable)ModBlocks.DIGITAL_MOUNTAIN_SAPPLING.get()).build();





    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
        return Feature.ACACIA_TREE.withConfiguration(DIGITAL_TREE_MOUNATIN_CONFIG);
    }
}
