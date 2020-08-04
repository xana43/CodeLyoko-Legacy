package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nonnull;

public class ScannerFrame extends Block {
    public static final BooleanProperty ScannerFrameInvis = BooleanProperty.create("scanner_frame_invis");
    public ScannerFrame(Properties properties) {
        super(properties);

    this.setDefaultState(this.getStateContainer().getBaseState().with(ScannerFrameInvis,false));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(ScannerFrameInvis);
    }

    @Override
    public boolean isSideInvisible(@Nonnull BlockState state, @Nonnull BlockState adjacentBlockState, @Nonnull Direction side) {
        return state.get(ScannerFrameInvis);
    }



    @Nonnull
    @Override
    public BlockRenderType getRenderType(@Nonnull BlockState state) {
        if(state.get(ScannerFrameInvis))
            return BlockRenderType.INVISIBLE;
        else
            return BlockRenderType.MODEL;
    }

    @Override
    public boolean isTransparent(BlockState state) {
        return state.get(ScannerFrameInvis);
    }

    @Override
    public boolean isViewBlocking(BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos) {
        return !state.get(ScannerFrameInvis);
    }
}
