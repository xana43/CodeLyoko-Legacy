package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;


public final class HologramProjectorTileEntity extends BlockEntity
{


    public HologramProjectorTileEntity(final BlockPos pos, final BlockState state) {
        super(ModBlockEntities.HOLOGRAM_PROJECTOR_TILE_ENTITY_BLOCK_ENTITY_TYPE, pos, state);
    }
}
