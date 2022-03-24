package com.Ultra_Nerd.CodeLyokoRemake15.world.ModFeatures;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public class DigitalMountainTree extends TreeFeature {
    public DigitalMountainTree(Codec<TreeConfiguration> p_67201_) {
        super(p_67201_);
    }


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
