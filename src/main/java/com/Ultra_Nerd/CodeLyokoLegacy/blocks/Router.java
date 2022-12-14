package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.stream.Stream;

public final class Router extends HorizontalFacingBlock implements BlockEntityProvider {
    public static final BooleanProperty ROUTER_ACTIVE = BooleanProperty.of("ractive");
    private static final VoxelShape N = Stream.of(
            Block.createCuboidShape(14, 1, 8, 15, 3, 9),
            Block.createCuboidShape(0, 0, 0, 16, 3, 8),
            Block.createCuboidShape(0, 0, 8, 1, 3, 9),
            Block.createCuboidShape(15, 0, 8, 16, 3, 9),
            Block.createCuboidShape(1, 0, 8, 15, 1, 9),
            Block.createCuboidShape(1, 2, 8, 4, 3, 9),
            Block.createCuboidShape(4, 2, 8, 14, 3, 9),
            Block.createCuboidShape(4, 1, 8, 5, 2, 9),
            Block.createCuboidShape(6, 1, 8, 7, 2, 9),
            Block.createCuboidShape(8, 1, 8, 9, 2, 9),
            Block.createCuboidShape(10, 1, 8, 11, 2, 9),
            Block.createCuboidShape(12, 1, 8, 13, 2, 9)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape S = Stream.of(
            Block.createCuboidShape(1.75, 1, 7.25, 2.75, 3, 8.25),
            Block.createCuboidShape(0.75, 0, 8.25, 16.75, 3, 16.25),
            Block.createCuboidShape(15.75, 0, 7.25, 16.75, 3, 8.25),
            Block.createCuboidShape(0.75, 0, 7.25, 1.75, 3, 8.25),
            Block.createCuboidShape(1.75, 0, 7.25, 15.75, 1, 8.25),
            Block.createCuboidShape(12.75, 2, 7.25, 15.75, 3, 8.25),
            Block.createCuboidShape(2.75, 2, 7.25, 12.75, 3, 8.25),
            Block.createCuboidShape(11.75, 1, 7.25, 12.75, 2, 8.25),
            Block.createCuboidShape(9.75, 1, 7.25, 10.75, 2, 8.25),
            Block.createCuboidShape(7.75, 1, 7.25, 8.75, 2, 8.25),
            Block.createCuboidShape(5.75, 1, 7.25, 6.75, 2, 8.25),
            Block.createCuboidShape(3.75, 1, 7.25, 4.75, 2, 8.25)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape E = Stream.of(
            Block.createCuboidShape(7.5, 1, 13.75, 8.5, 3, 14.75),
            Block.createCuboidShape(8.5, 0, -0.25, 16.5, 3, 15.75),
            Block.createCuboidShape(7.5, 0, -0.25, 8.5, 3, 0.75),
            Block.createCuboidShape(7.5, 0, 14.75, 8.5, 3, 15.75),
            Block.createCuboidShape(7.5, 0, 0.75, 8.5, 1, 14.75),
            Block.createCuboidShape(7.5, 2, 0.75, 8.5, 3, 3.75),
            Block.createCuboidShape(7.5, 2, 3.75, 8.5, 3, 13.75),
            Block.createCuboidShape(7.5, 1, 3.75, 8.5, 2, 4.75),
            Block.createCuboidShape(7.5, 1, 5.75, 8.5, 2, 6.75),
            Block.createCuboidShape(7.5, 1, 7.75, 8.5, 2, 8.75),
            Block.createCuboidShape(7.5, 1, 9.75, 8.5, 2, 10.75),
            Block.createCuboidShape(7.5, 1, 11.75, 8.5, 2, 12.75)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape W = Stream.of(
            Block.createCuboidShape(8.25, 1, 1.5, 9.25, 3, 2.5),
            Block.createCuboidShape(0.25, 0, 0.5, 8.25, 3, 16.5),
            Block.createCuboidShape(8.25, 0, 15.5, 9.25, 3, 16.5),
            Block.createCuboidShape(8.25, 0, 0.5, 9.25, 3, 1.5),
            Block.createCuboidShape(8.25, 0, 1.5, 9.25, 1, 15.5),
            Block.createCuboidShape(8.25, 2, 12.5, 9.25, 3, 15.5),
            Block.createCuboidShape(8.25, 2, 2.5, 9.25, 3, 12.5),
            Block.createCuboidShape(8.25, 1, 11.5, 9.25, 2, 12.5),
            Block.createCuboidShape(8.25, 1, 9.5, 9.25, 2, 10.5),
            Block.createCuboidShape(8.25, 1, 7.5, 9.25, 2, 8.5),
            Block.createCuboidShape(8.25, 1, 5.5, 9.25, 2, 6.5),
            Block.createCuboidShape(8.25, 1, 3.5, 9.25, 2, 4.5)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public Router(@NotNull FabricBlockSettings properties) {
        super(properties);
        this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH).with(ROUTER_ACTIVE, false));
    }


    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return ModTileEntities.ROUTER_BLOCK_ENTITY_TYPE.instantiate(pos, state);
    }

    @Nonnull
    @Override
    public VoxelShape getOutlineShape(@NotNull BlockState state, @Nonnull BlockView worldIn, @Nonnull BlockPos pos,
            @Nonnull ShapeContext context) {
        return switch (state.get(FACING)) {
            case SOUTH -> S;
            case EAST -> E;
            case WEST -> W;
            default -> N;
        };
    }

    @Override
    public VoxelShape getCollisionShape(final BlockState state, final BlockView world, final BlockPos pos, final ShapeContext context) {
        return switch (state.get(FACING)) {
            case SOUTH -> S;
            case EAST -> E;
            case WEST -> W;
            default -> N;
        };
    }

    @Override
    public @NotNull BlockState getPlacementState(@NotNull ItemPlacementContext context) {
        // TODO Auto-generated method stub
        return this.getDefaultState().with(FACING, context.getPlayerFacing().getOpposite()).with(ROUTER_ACTIVE, false);
    }

    @Override
    protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(ROUTER_ACTIVE).add(FACING));
    }


}
