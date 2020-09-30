package com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.Frontier;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.GenerationSettings;

import javax.annotation.Nonnull;

public class FrontierGenSettings extends GenerationSettings {

    public byte BiomeSize(){
        return 4;
    }

    public byte getBiomeID()
    {
        return 112;
    }

    @Nonnull
    @Override
    public BlockState getDefaultBlock() {
        return ModBlocks.FRONTIER_BLOCK.get().getDefaultState();
    }

    @Nonnull
    @Override
    public BlockState getDefaultFluid() {
        return Blocks.BEDROCK.getDefaultState();
    }


}
