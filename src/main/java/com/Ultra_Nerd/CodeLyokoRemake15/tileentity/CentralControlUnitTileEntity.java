package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class CentralControlUnitTileEntity extends TileEntity implements ITickableTileEntity {
    public CentralControlUnitTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }
    public CentralControlUnitTileEntity() {
        this(ModTileEntities.CENTRAL_CONTROL_UNIT_TILE_ENTITY.get());
    }

    @Override
    public void tick() {

    }
}
