package com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.DigitalOcean;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModFluids;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.WorldGenSettings;

import javax.annotation.Nonnull;

public class OceanGenSettings extends GenerationSettings {

    public byte BiomeSize() {
        return 4;
    }

    public byte getBiomeID() {
        return 112;
    }

    @Nonnull
    @Override
    public BlockState getDefaultBlock() {
        return ModFluids.DIGITAL_SEA_BLOCK.get().getDefaultState();
    }




    @Nonnull
    @Override
    public BlockState getDefaultFluid() {
        return Blocks.BEDROCK.getDefaultState();
    }

    @Override
    public int getBedrockRoofHeight() {
        return 255;
    }
}
