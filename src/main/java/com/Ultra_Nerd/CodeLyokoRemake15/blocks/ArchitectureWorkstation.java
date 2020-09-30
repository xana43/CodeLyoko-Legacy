package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nonnull;

public class ArchitectureWorkstation extends Block {

    public static final DirectionProperty ComputerStation = HorizontalBlock.HORIZONTAL_FACING;
    private static final BooleanProperty on = BooleanProperty.create("active");

    private static final VoxelShape shapeN = Block.makeCuboidShape(4, 0, 0, 12, 16, 16);
    private static final VoxelShape shapeE = Block.makeCuboidShape(0, 0, 4, 16, 16, 12);
    private static final VoxelShape shapeS = Block.makeCuboidShape(4, 0, 0, 12, 16, 16);
    private static final VoxelShape shapeW = Block.makeCuboidShape(0, 0, 4, 16, 16, 12);

    public ArchitectureWorkstation(Properties properties) {
        super(properties);

        this.setDefaultState(this.stateContainer.getBaseState().with(ComputerStation, Direction.NORTH).with(on, false));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder.add(ComputerStation).add(on));
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        // TODO Auto-generated method stub
        return this.getDefaultState().with(ComputerStation, context.getPlacementHorizontalFacing().getOpposite()).with(on, false);
    }

    //mod compatiability
    @Nonnull
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(ComputerStation, rot.rotate(state.get(ComputerStation)));
    }

    @Nonnull
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(ComputerStation)));
    }

    @Nonnull
    @Override
    public VoxelShape getShape(BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos, @Nonnull ISelectionContext context) {
        switch (state.get(ComputerStation)) {
            case NORTH:
                return shapeN;
            case SOUTH:
                return shapeS;
            case EAST:
                return shapeE;
            case WEST:
                return shapeW;
            default:
                return shapeN;
        }
    }
}
