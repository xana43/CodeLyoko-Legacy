package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nonnull;

public class CableBlock extends FenceBlock {

    public static final DirectionProperty DIR = HorizontalBlock.HORIZONTAL_FACING;

    public CableBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(DIR, Direction.NORTH));
    }


    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(DIR);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        // TODO Auto-generated method stub
        return this.getDefaultState().with(DIR, context.getPlacementHorizontalFacing().getOpposite());
    }

    //mod compatibility
    @Nonnull
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(DIR, rot.rotate(state.get(DIR)));
    }

    @Nonnull
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(DIR)));
    }
    //

    @Override
    public boolean isNormalCube(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isTransparent(@Nonnull BlockState state) {
        // TODO Auto-generated method stub
        return true;
    }


}
