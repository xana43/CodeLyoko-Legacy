package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class ComputerCentralControlUnit extends Block {
    public ComputerCentralControlUnit(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.CENTRAL_CONTROL_UNIT_TILE_ENTITY.get().create();
    }
}
