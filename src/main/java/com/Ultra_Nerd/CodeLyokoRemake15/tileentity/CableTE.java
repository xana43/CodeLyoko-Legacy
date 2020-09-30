package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class CableTE extends TileEntity implements ITickableTileEntity {
    public CableTE(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public CableTE() {
        this(ModTileEntities.CABLE_TILE_ENTITY.get());
    }

    @Override
    public void tick() {

    }
}
