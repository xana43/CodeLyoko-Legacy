package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.HashMap;

public class CableTileEntity extends BlockEntity implements BlockEntityTicker<CableTileEntity> {

    public static HashMap<CableTileEntity, ArrayList<BlockEntity>> CONNECTIONS = new HashMap<>();

    private boolean connectedToScanner;
    private boolean connectedToComp;

    public CableTileEntity(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
    }
/*
    public CableTileEntity(BlockEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

 */

    //public CableTileEntity() {
   //     this(ModTileEntities.CABLE_TILE_ENTITY.get());
    //}



    @Override
    public boolean isRemoved() {
        super.setRemoved();
        ArrayList<BlockEntity> toDisconnect = CableTileEntity.CONNECTIONS.get(this);
        this.disconnectToComp();
        this.disconnectToScanner();
        CableTileEntity.CONNECTIONS.remove(this);
        for (BlockEntity te : toDisconnect) {
            if(te instanceof CableTileEntity) {
                CableTileEntity.CONNECTIONS.get(te).remove(this);
            }
        }
        return false;
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
    public void tick(Level p_155253_, BlockPos p_155254_, BlockState p_155255_, CableTileEntity p_155256_) {

    }
}
