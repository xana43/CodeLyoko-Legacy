package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class RouterTE extends TileEntity implements ITickableTileEntity {
    public RouterTE(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }
    public RouterTE()
    {
        this(ModTileEntities.ROUTER_TILE_ENTITY.get());
    }

    @Override
    public void tick() {

    }
}
