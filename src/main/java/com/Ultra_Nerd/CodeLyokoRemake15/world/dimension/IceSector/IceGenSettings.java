package com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.IceSector;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModFluids;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.GenerationSettings;

public class IceGenSettings extends GenerationSettings {
    public byte BiomeSize(){
        return 4;
    }

    public byte getBiomID()
    {
        return 70;
    }






    @Override
    public BlockState getDefaultBlock() {
        return ModBlocks.DIGITAL_ICE.get().getDefaultState();
    }



    @Override
    public BlockState getDefaultFluid() {
        return ModFluids.DIO.get().getDefaultState();
    }
}
