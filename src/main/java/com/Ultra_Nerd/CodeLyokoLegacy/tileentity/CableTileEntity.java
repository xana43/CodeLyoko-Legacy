package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.energy.IEnergyStorage;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

public class CableTileEntity extends BlockEntity implements BlockEntityTicker<CableTileEntity>, IEnergyStorage {

    public static @NotNull HashMap<CableTileEntity, ArrayList<BlockEntity>> CONNECTIONS = new HashMap<>();

    private boolean connectedToScanner;
    private boolean connectedToComp;

    public CableTileEntity(@NotNull BlockEntityType<?> p_155228_, @NotNull BlockPos p_155229_, @NotNull BlockState p_155230_) {
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
    public void tick(@NotNull Level p_155253_, @NotNull BlockPos p_155254_, @NotNull BlockState p_155255_, @NotNull CableTileEntity p_155256_) {

    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        return 0;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        return 0;
    }

    @Override
    public int getEnergyStored() {
        return 0;
    }

    @Override
    public int getMaxEnergyStored() {
        return 0;
    }

    @Override
    public boolean canExtract() {
        return false;
    }

    @Override
    public boolean canReceive() {
        return false;
    }
}
