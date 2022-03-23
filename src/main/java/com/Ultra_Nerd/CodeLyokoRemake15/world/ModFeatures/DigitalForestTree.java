package com.Ultra_Nerd.CodeLyokoRemake15.world.ModFeatures;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.block.trees.BigTree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeTreeFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;

public class DigitalForestTree extends TreeFeature {

/*
    public static final TreeFeature DIGITAL_TREE_FOREST_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
            (new SimpleBlockStateProvider(ModBlocks.DIGITAL_WOOD_FOREST.get().getDefaultState()), new SimpleBlockStateProvider(Blocks.AIR.getDefaultState())).baseHeight(128)
            .setSapling((IPlantable) ModBlocks.DIGITAL_TREE_FOREST_SAPLING.get()).build()).;

    public DigitalForestTree(Codec<TreeConfiguration> p_67201_) {
        super(p_67201_);
    }


    @Nullable
    @Override
    protected ConfiguredFeature<HugeTreeFeatureConfig, ?> getHugeTreeFeature(@Nonnull Random p_225547_1_) {
        return Feature.MEGA_JUNGLE_TREE.withConfiguration(DIGITAL_TREE_FOREST_CONFIG);
    }


    @Override
    public Codec<ConfiguredFeature<TreeConfiguration, Feature<TreeConfiguration>>> configuredCodec() {
        return super.configuredCodec();
    }

    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfiguration, ?> getTreeFeature(@Nonnull Random randomIn, boolean p_225546_2_) {
        return null;
    }

 */
}
