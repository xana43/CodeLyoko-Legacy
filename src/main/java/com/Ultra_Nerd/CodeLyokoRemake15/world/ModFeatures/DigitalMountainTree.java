package com.Ultra_Nerd.CodeLyokoRemake15.world.ModFeatures;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;

import static com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks.DIGITAL_MOUNTAIN_SAPPLING;

public class DigitalMountainTree extends TreeFeature {


/*
    public static final ConfiguredFeature<TreeConfiguration,Feature<TreeConfiguration>> DIGITAL_TREE_MOUNATIN_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder()
            (new (ModBlocks.DIGITAL_WOOD_MOUNTAIN.get().defaultBlockState()), new SimpleBlockStateProvider(ModBlocks.DIGITAL_LEAF_MOUNTAIN.get().getDefaultState())
                    , new BlobFoliagePlacer(4, 4))).baseHeight(5)
            .setSapling((IPlantable) ModBlocks.DIGITAL_MOUNTAIN_SAPPLING.get()).build();

    public DigitalMountainTree(Codec<TreeConfiguration> p_67201_) {
        super(p_67201_);
    }

    @Nullable
    @Override
    public Codec<ConfiguredFeature<TreeConfiguration, Feature<TreeConfiguration>>> configuredCodec() {
        return TreeFeature.TREE.configuredCodec(DIGITAL_TREE_MOUNATIN_CONFIG);
    }
    
 */
}
