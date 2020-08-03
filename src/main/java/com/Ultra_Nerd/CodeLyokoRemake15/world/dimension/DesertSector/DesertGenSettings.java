package com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.DesertSector;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModFluids;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.GenerationSettings;

public class DesertGenSettings extends GenerationSettings {
    public byte BiomeSize(){
        return 4;
    }

    public byte getBiomID()
    {
        return 109;
    }






    @Override
    public BlockState getDefaultBlock() {
        return ModBlocks.DIGITAL_SAND.get().getDefaultState();
    }



    @Override
    public BlockState getDefaultFluid() {
        return ModFluids.DIGITAL_SEA_BLOCK.get().getDefaultState();
    }
}
