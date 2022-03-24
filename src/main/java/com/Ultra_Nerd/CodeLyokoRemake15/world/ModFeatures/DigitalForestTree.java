package com.Ultra_Nerd.CodeLyokoRemake15.world.ModFeatures;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.FeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.FeatureSizeType;
import org.jetbrains.annotations.NotNull;

import java.util.OptionalInt;
import java.util.Random;

public class DigitalForestTree extends TreeFeature {
static class size extends FeatureSize
{

    public size(OptionalInt p_68285_) {
        super(p_68285_);
    }

    @Override
    protected FeatureSizeType<?> type() {
        return null;
    }

    @Override
    public int getSizeAtHeight(int p_68287_, int p_68288_) {
        return 0;
    }
}
/*
    public static final TreeConfiguration DIGITAL_TREE_FOREST_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
            (SimpleStateProvider.simple(ModBlocks.DIGITAL_WOOD_FOREST.get().defaultBlockState())), new GiantTrunkPlacer(1, 1, 1),
            SimpleStateProvider.simple(Blocks.AIR.defaultBlockState()), ModPlacers.DIGITAL_TREE_PLACER.get()).build();

            //.setSapling((IPlantable) ModBlocks.DIGITAL_TREE_FOREST_SAPLING.get()).build());
*/




    public DigitalForestTree(Codec<TreeConfiguration> CODEC) {
        super(CODEC);
    }





    @Override
    public @NotNull Codec<ConfiguredFeature<TreeConfiguration, Feature<TreeConfiguration>>> configuredCodec() {
        return TREE.configuredCodec();
    }

    @Override
    public boolean place(TreeConfiguration p_204741_, WorldGenLevel p_204742_, ChunkGenerator p_204743_, Random p_204744_, BlockPos p_204745_) {
        return super.place(p_204741_, p_204742_, p_204743_, p_204744_, p_204745_);
    }





}
