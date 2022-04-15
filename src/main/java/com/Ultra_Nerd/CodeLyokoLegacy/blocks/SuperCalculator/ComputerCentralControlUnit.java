package com.Ultra_Nerd.CodeLyokoLegacy.blocks.SuperCalculator;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class ComputerCentralControlUnit extends BaseEntityBlock {
    public ComputerCentralControlUnit(@NotNull Properties properties) {
        super(properties);
    }



    @org.jetbrains.annotations.Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return null;// ModTileEntities.CENTRAL_CONTROL_UNIT_TILE_ENTITY.get().create(pos,state);
    }
}
