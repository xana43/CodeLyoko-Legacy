package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.stream.Stream;

public class Router extends BaseEntityBlock {
    public static final DirectionProperty ROUTER_DIRECTION = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty ROUTER_ACTIVE = BooleanProperty.create("ractive");
    private static final VoxelShape N = Stream.of(
            Block.box(14, 1, 8, 15, 3, 9),
            Block.box(0, 0, 0, 16, 3, 8),
            Block.box(0, 0, 8, 1, 3, 9),
            Block.box(15, 0, 8, 16, 3, 9),
            Block.box(1, 0, 8, 15, 1, 9),
            Block.box(1, 2, 8, 4, 3, 9),
            Block.box(4, 2, 8, 14, 3, 9),
            Block.box(4, 1, 8, 5, 2, 9),
            Block.box(6, 1, 8, 7, 2, 9),
            Block.box(8, 1, 8, 9, 2, 9),
            Block.box(10, 1, 8, 11, 2, 9),
            Block.box(12, 1, 8, 13, 2, 9)
    ).reduce((v1, v2) -> {
        return Shapes.join(v1, v2, BooleanOp.OR);
    }).get();
    private static final VoxelShape S = Stream.of(
            Block.box(1.75, 1, 7.25, 2.75, 3, 8.25),
            Block.box(0.75, 0, 8.25, 16.75, 3, 16.25),
            Block.box(15.75, 0, 7.25, 16.75, 3, 8.25),
            Block.box(0.75, 0, 7.25, 1.75, 3, 8.25),
            Block.box(1.75, 0, 7.25, 15.75, 1, 8.25),
            Block.box(12.75, 2, 7.25, 15.75, 3, 8.25),
            Block.box(2.75, 2, 7.25, 12.75, 3, 8.25),
            Block.box(11.75, 1, 7.25, 12.75, 2, 8.25),
            Block.box(9.75, 1, 7.25, 10.75, 2, 8.25),
            Block.box(7.75, 1, 7.25, 8.75, 2, 8.25),
            Block.box(5.75, 1, 7.25, 6.75, 2, 8.25),
            Block.box(3.75, 1, 7.25, 4.75, 2, 8.25)
    ).reduce((v1, v2) -> {
        return Shapes.join(v1, v2, BooleanOp.OR);
    }).get();
    private static final VoxelShape E = Stream.of(
            Block.box(7.5, 1, 13.75, 8.5, 3, 14.75),
            Block.box(8.5, 0, -0.25, 16.5, 3, 15.75),
            Block.box(7.5, 0, -0.25, 8.5, 3, 0.75),
            Block.box(7.5, 0, 14.75, 8.5, 3, 15.75),
            Block.box(7.5, 0, 0.75, 8.5, 1, 14.75),
            Block.box(7.5, 2, 0.75, 8.5, 3, 3.75),
            Block.box(7.5, 2, 3.75, 8.5, 3, 13.75),
            Block.box(7.5, 1, 3.75, 8.5, 2, 4.75),
            Block.box(7.5, 1, 5.75, 8.5, 2, 6.75),
            Block.box(7.5, 1, 7.75, 8.5, 2, 8.75),
            Block.box(7.5, 1, 9.75, 8.5, 2, 10.75),
            Block.box(7.5, 1, 11.75, 8.5, 2, 12.75)
    ).reduce((v1, v2) -> {
        return Shapes.join(v1, v2, BooleanOp.OR);
    }).get();
    private static final VoxelShape W = Stream.of(
            Block.box(8.25, 1, 1.5, 9.25, 3, 2.5),
            Block.box(0.25, 0, 0.5, 8.25, 3, 16.5),
            Block.box(8.25, 0, 15.5, 9.25, 3, 16.5),
            Block.box(8.25, 0, 0.5, 9.25, 3, 1.5),
            Block.box(8.25, 0, 1.5, 9.25, 1, 15.5),
            Block.box(8.25, 2, 12.5, 9.25, 3, 15.5),
            Block.box(8.25, 2, 2.5, 9.25, 3, 12.5),
            Block.box(8.25, 1, 11.5, 9.25, 2, 12.5),
            Block.box(8.25, 1, 9.5, 9.25, 2, 10.5),
            Block.box(8.25, 1, 7.5, 9.25, 2, 8.5),
            Block.box(8.25, 1, 5.5, 9.25, 2, 6.5),
            Block.box(8.25, 1, 3.5, 9.25, 2, 4.5)
    ).reduce((v1, v2) -> {
        return Shapes.join(v1, v2, BooleanOp.OR);
    }).get();

    public Router(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(ROUTER_DIRECTION, Direction.NORTH).setValue(ROUTER_ACTIVE, false));
    }





    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos,BlockState state) {
        return null; //ModTileEntities.ROUTER_TILE_ENTITY.get().create(pos, state);
    }

    @Nonnull
    @Override
    public VoxelShape getShape(BlockState state, @Nonnull BlockGetter worldIn, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        switch (state.getValue(ROUTER_DIRECTION)) {
            case NORTH:
                return N;
            case SOUTH:
                return S;
            case EAST:
                return E;
            case WEST:
                return W;
            default:
                return N;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        // TODO Auto-generated method stub
        return this.defaultBlockState().setValue(ROUTER_DIRECTION, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(@Nonnull StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(ROUTER_ACTIVE).add(ROUTER_DIRECTION);
    }

    //mod compatiability
    @Nonnull
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(ROUTER_DIRECTION, rot.rotate(state.getValue(ROUTER_DIRECTION)));
    }

    @Nonnull
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(ROUTER_DIRECTION)));
    }
}
