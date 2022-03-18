package com.Ultra_Nerd.CodeLyokoRemake15.world.ModFeatures;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraftforge.common.IPlantable;
import net.minecraft.world.level.levelgen.feature.Feature;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;

public class DigitalMountainTree extends TreeFeature {

    public static final TreeFeatureConfig DIGITAL_TREE_MOUNATIN_CONFIG = (new TreeFeatureConfig.Builder
            (new SimpleBlockStateProvider(ModBlocks.DIGITAL_WOOD_MOUNTAIN.get().getDefaultState()), new SimpleBlockStateProvider(ModBlocks.DIGITAL_LEAF_MOUNTAIN.get().getDefaultState())
                    , new BlobFoliagePlacer(4, 4))).baseHeight(5)
            .setSapling((IPlantable) ModBlocks.DIGITAL_MOUNTAIN_SAPPLING.get()).build();

    public DigitalMountainTree(Codec<TreeConfiguration> p_67201_) {
        super(p_67201_);
    }

    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(@Nonnull Random randomIn, boolean p_225546_2_) {
        return Feature.ACACIA_TREE.withConfiguration(DIGITAL_TREE_MOUNATIN_CONFIG);
    }
}
