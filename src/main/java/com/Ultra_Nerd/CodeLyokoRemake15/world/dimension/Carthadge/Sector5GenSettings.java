package com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.Carthadge;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModFluids;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.GenerationSettings;

public class Sector5GenSettings extends GenerationSettings {
    public byte BiomeSize(){
        return 4;
    }

    public byte getBiomID()
    {
        return 91;
    }






    @Override
    public BlockState getDefaultBlock() {
        return ModBlocks.SECTOR_5.get().getDefaultState();
    }



    @Override
    public BlockState getDefaultFluid() {
        return ModFluids.DIO.get().getDefaultState();
    }
}
