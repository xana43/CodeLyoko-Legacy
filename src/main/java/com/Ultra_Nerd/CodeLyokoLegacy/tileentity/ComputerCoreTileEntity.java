package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.EnergyStorageBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import team.reborn.energy.api.base.SimpleEnergyStorage;

public final class ComputerCoreTileEntity extends EnergyStorageBlockEntity {
    public ComputerCoreTileEntity(final BlockPos pos, final BlockState state) {
        super(ModBlockEntities.COMPUTER_CORE_TILE_ENTITY_BLOCK_ENTITY_TYPE, pos, state,new SimpleEnergyStorage(90000000,
                10000,0));
    }
    @Override
    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }


    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return this.createNbt();
    }
    @Override
    public void tick() {

    }





}
