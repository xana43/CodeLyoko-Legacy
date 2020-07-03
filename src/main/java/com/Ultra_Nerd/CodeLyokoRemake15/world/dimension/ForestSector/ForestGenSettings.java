package com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.ForestSector;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModFluids;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.GenerationSettings;

public class ForestGenSettings extends GenerationSettings {
    public byte BiomeSize(){
        return 4;
    }

    public byte getBiomID()
    {
        return 90;
    }






    @Override
    public BlockState getDefaultBlock() {
        return ModBlocks.DIGITAL_GRASS.get().getDefaultState();
    }



    @Override
    public BlockState getDefaultFluid() {
        return ModFluids.DIO.get().getDefaultState();
    }
}
