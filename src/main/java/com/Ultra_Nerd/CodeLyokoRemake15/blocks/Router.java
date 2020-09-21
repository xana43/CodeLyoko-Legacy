package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nonnull;
import java.util.stream.Stream;

public class Router extends Block {
    private static final VoxelShape N = Stream.of(
            Block.makeCuboidShape(14, 1, 8, 15, 3, 9),
            Block.makeCuboidShape(0, 0, 0, 16, 3, 8),
            Block.makeCuboidShape(0, 0, 8, 1, 3, 9),
            Block.makeCuboidShape(15, 0, 8, 16, 3, 9),
            Block.makeCuboidShape(1, 0, 8, 15, 1, 9),
            Block.makeCuboidShape(1, 2, 8, 4, 3, 9),
            Block.makeCuboidShape(4, 2, 8, 14, 3, 9),
            Block.makeCuboidShape(4, 1, 8, 5, 2, 9),
            Block.makeCuboidShape(6, 1, 8, 7, 2, 9),
            Block.makeCuboidShape(8, 1, 8, 9, 2, 9),
            Block.makeCuboidShape(10, 1, 8, 11, 2, 9),
            Block.makeCuboidShape(12, 1, 8, 13, 2, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape S = Stream.of(
            Block.makeCuboidShape(1.75, 1, 7.25, 2.75, 3, 8.25),
            Block.makeCuboidShape(0.75, 0, 8.25, 16.75, 3, 16.25),
            Block.makeCuboidShape(15.75, 0, 7.25, 16.75, 3, 8.25),
            Block.makeCuboidShape(0.75, 0, 7.25, 1.75, 3, 8.25),
            Block.makeCuboidShape(1.75, 0, 7.25, 15.75, 1, 8.25),
            Block.makeCuboidShape(12.75, 2, 7.25, 15.75, 3, 8.25),
            Block.makeCuboidShape(2.75, 2, 7.25, 12.75, 3, 8.25),
            Block.makeCuboidShape(11.75, 1, 7.25, 12.75, 2, 8.25),
            Block.makeCuboidShape(9.75, 1, 7.25, 10.75, 2, 8.25),
            Block.makeCuboidShape(7.75, 1, 7.25, 8.75, 2, 8.25),
            Block.makeCuboidShape(5.75, 1, 7.25, 6.75, 2, 8.25),
            Block.makeCuboidShape(3.75, 1, 7.25, 4.75, 2, 8.25)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape E = Stream.of(
            Block.makeCuboidShape(7.5, 1, 13.75, 8.5, 3, 14.75),
            Block.makeCuboidShape(8.5, 0, -0.25, 16.5, 3, 15.75),
            Block.makeCuboidShape(7.5, 0, -0.25, 8.5, 3, 0.75),
            Block.makeCuboidShape(7.5, 0, 14.75, 8.5, 3, 15.75),
            Block.makeCuboidShape(7.5, 0, 0.75, 8.5, 1, 14.75),
            Block.makeCuboidShape(7.5, 2, 0.75, 8.5, 3, 3.75),
            Block.makeCuboidShape(7.5, 2, 3.75, 8.5, 3, 13.75),
            Block.makeCuboidShape(7.5, 1, 3.75, 8.5, 2, 4.75),
            Block.makeCuboidShape(7.5, 1, 5.75, 8.5, 2, 6.75),
            Block.makeCuboidShape(7.5, 1, 7.75, 8.5, 2, 8.75),
            Block.makeCuboidShape(7.5, 1, 9.75, 8.5, 2, 10.75),
            Block.makeCuboidShape(7.5, 1, 11.75, 8.5, 2, 12.75)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape W = Stream.of(
            Block.makeCuboidShape(8.25, 1, 1.5, 9.25, 3, 2.5),
            Block.makeCuboidShape(0.25, 0, 0.5, 8.25, 3, 16.5),
            Block.makeCuboidShape(8.25, 0, 15.5, 9.25, 3, 16.5),
            Block.makeCuboidShape(8.25, 0, 0.5, 9.25, 3, 1.5),
            Block.makeCuboidShape(8.25, 0, 1.5, 9.25, 1, 15.5),
            Block.makeCuboidShape(8.25, 2, 12.5, 9.25, 3, 15.5),
            Block.makeCuboidShape(8.25, 2, 2.5, 9.25, 3, 12.5),
            Block.makeCuboidShape(8.25, 1, 11.5, 9.25, 2, 12.5),
            Block.makeCuboidShape(8.25, 1, 9.5, 9.25, 2, 10.5),
            Block.makeCuboidShape(8.25, 1, 7.5, 9.25, 2, 8.5),
            Block.makeCuboidShape(8.25, 1, 5.5, 9.25, 2, 6.5),
            Block.makeCuboidShape(8.25, 1, 3.5, 9.25, 2, 4.5)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();


    public static final DirectionProperty ROUTER_DIRECTION = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty ROUTER_ACTIVE = BooleanProperty.create("ractive");

    public Router(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(ROUTER_DIRECTION, Direction.NORTH).with(ROUTER_ACTIVE,false));
    }

    @Nonnull
    @Override
    public VoxelShape getShape(BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos, @Nonnull ISelectionContext context) {
        switch (state.get(ROUTER_DIRECTION))
        {
            case NORTH: return N;
            case SOUTH: return S;
            case EAST: return E;
            case WEST: return W;
            default: return N;
        }
    }
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        // TODO Auto-generated method stub
        return this.getDefaultState().with(ROUTER_DIRECTION, context.getPlacementHorizontalFacing().getOpposite());
    }
    @Override
    protected void fillStateContainer(@Nonnull StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(ROUTER_ACTIVE).add(ROUTER_DIRECTION);
    }

    //mod compatiability
    @Nonnull
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(ROUTER_DIRECTION, rot.rotate(state.get(ROUTER_DIRECTION)));
    }

    @Nonnull
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(ROUTER_DIRECTION)));
    }
}
