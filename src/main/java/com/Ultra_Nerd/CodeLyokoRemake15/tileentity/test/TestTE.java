package com.Ultra_Nerd.CodeLyokoRemake15.tileentity.test;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;

public class TestTE extends TileEntity implements ITickableTileEntity {
    private boolean testonce = false;
    public TestTE(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }
    public TestTE()
    {
        this(ModTileEntities.TEST_TILE_ENTITY.get());
    }
    private BlockPos core = this.pos;
    @Override
    public void tick() {
/*
        if(!CheckStructure() && ! testonce)
        {
            CheckStructure();
            testonce = true;
        }
        Base.Log.info("formed");


 */

    }

/*    private boolean CheckStructure()
    {
        int x;
        if(x++ < 5)
        {

        }



    }

 */



}
