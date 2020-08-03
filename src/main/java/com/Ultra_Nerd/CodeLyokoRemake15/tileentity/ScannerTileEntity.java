package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class ScannerTileEntity extends TileEntity  {

   public int x,y,z,tick;
   boolean inited = false;
    public ScannerTileEntity(final TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public ScannerTileEntity(){
        this(ModTileEntities.SCANNER_TILE_ENTITY.get());
    }

}
