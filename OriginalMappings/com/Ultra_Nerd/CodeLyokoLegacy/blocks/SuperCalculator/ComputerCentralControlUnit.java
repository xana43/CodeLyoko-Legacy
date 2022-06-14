package com.Ultra_Nerd.CodeLyokoLegacy.blocks.SuperCalculator;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public final class ComputerCentralControlUnit extends Block implements BlockEntityProvider {
    public ComputerCentralControlUnit(final Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return null;
    }
    //public ComputerCentralControlUnit(@NotNull Properties properties) {
     //   super(properties);
    //}



  //  @org.jetbrains.annotations.Nullable
   // @Override
   // public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
   //     return null;// ModTileEntities.CENTRAL_CONTROL_UNIT_TILE_ENTITY.get().create(pos,state);
    //}

    //@Nullable
    //@Override
    //public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
    //    return null;
    //}
}
