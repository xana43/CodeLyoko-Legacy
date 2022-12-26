package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.EnergyStorageBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import team.reborn.energy.api.base.SimpleEnergyStorage;

public final class ComputerCoreTileEntity extends EnergyStorageBlockEntity {
    public ComputerCoreTileEntity(final BlockPos pos, final BlockState state) {
        super(ModTileEntities.COMPUTER_CORE_TILE_ENTITY_BLOCK_ENTITY_TYPE, pos, state,new SimpleEnergyStorage(90000000,
                10000,0));
    }

    @Override
    public void tick() {

    }





}
