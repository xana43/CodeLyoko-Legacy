package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CableTileEntity extends TileEntity implements ITickableTileEntity {

    public static HashMap<CableTileEntity, ArrayList<TileEntity>> CONNECTIONS = new HashMap<>();

    private boolean connectedToScanner;
    private boolean connectedToComp;

    public CableTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public CableTileEntity() {
        this(ModTileEntities.CABLE_TILE_ENTITY.get());
    }

    public void connectToScanner() {
        this.connectedToScanner = true;
    }
    public void disconnectToScanner() {
        this.connectedToScanner = false;
    }
    public void connectToComp() {
        this.connectedToComp = true;
    }
    public void disconnectToComp() {
        this.connectedToComp = false;
    }

    @Override
    public void tick() {

    }
}
