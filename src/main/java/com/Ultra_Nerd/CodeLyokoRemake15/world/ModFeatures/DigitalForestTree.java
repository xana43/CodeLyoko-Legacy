package com.Ultra_Nerd.CodeLyokoRemake15.world.ModFeatures;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.block.trees.BigTree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeTreeFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;

public class DigitalForestTree extends BigTree {
   public static final HugeTreeFeatureConfig DIGITAL_TREE_FOREST_CONFIG = (new HugeTreeFeatureConfig.Builder
           (new SimpleBlockStateProvider(ModBlocks.DIGITAL_WOOD_FOREST.get().getDefaultState()),new SimpleBlockStateProvider(Blocks.AIR.getDefaultState())).baseHeight(128)
           .setSapling((IPlantable)ModBlocks.DIGITAL_TREE_FOREST_SAPLING.get()).build());



    @Nullable
    @Override
    protected ConfiguredFeature<HugeTreeFeatureConfig, ?> getHugeTreeFeature(@Nonnull Random p_225547_1_) {
         return Feature.MEGA_JUNGLE_TREE.withConfiguration(DIGITAL_TREE_FOREST_CONFIG);
    }

    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(@Nonnull Random randomIn, boolean p_225546_2_) {
        return null;
    }
}
