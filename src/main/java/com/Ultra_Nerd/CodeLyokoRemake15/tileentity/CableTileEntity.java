package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

import javax.annotation.Nonnull;
import java.io.DataOutputStream;
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

    @Override
    public void remove() {
        super.remove();
        ArrayList<TileEntity> toDisconnect = CableTileEntity.CONNECTIONS.get(this);
        this.disconnectToComp();
        this.disconnectToScanner();
        CableTileEntity.CONNECTIONS.remove(this);
        for (TileEntity te : toDisconnect) {
            if(te instanceof CableTileEntity) {
                CableTileEntity.CONNECTIONS.get(te).remove(this);
            }
        }
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
