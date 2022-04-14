package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.stream.Stream;

public final class ScannerTop extends Block {
    public static final DirectionProperty directionPropertyTop = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty scannerFormedTop = BooleanProperty.create("scanner_formed_top");
    private static final VoxelShape shapeS = Stream.of(
            Block.box(-4, 0, 5, -3, 15.3, 11),
            Block.box(19, 0, 5, 20, 15.3, 11),
            Block.box(5, 0, 19, 11, 15.3, 20),
            Block.box(-3, 0, 2, -2, 15.3, 5),
            Block.box(18, 0, 11, 19, 15.3, 14),
            Block.box(-3, 0, 11, -2, 15.3, 14),
            Block.box(18, 0, 2, 19, 15.3, 5),
            Block.box(13, 1, -3, 14, 14.25, -2),
            Block.box(2, 0, 18, 5, 15.3, 19),
            Block.box(2, 1, -3, 3, 14.25, -2),
            Block.box(11, 0, 18, 14, 15.3, 19),
            Block.box(-2, 0, 1, -1, 15.3, 2),
            Block.box(17, 0, 14, 18, 15.3, 15),
            Block.box(1, 0, 17, 2, 15.3, 18),
            Block.box(14, 0, -2, 15, 15.3, -1),
            Block.box(-1, 0, 0, 0, 15.3, 1),
            Block.box(16, 0, 15, 17, 15.3, 16),
            Block.box(0, 0, 16, 1, 15.3, 17),
            Block.box(15, 0, -1, 16, 15.3, 0),
            Block.box(0, 0, -1, 1, 15.3, 0),
            Block.box(15, 0, 16, 16, 15.3, 17),
            Block.box(-1, 0, 15, 0, 15.3, 16),
            Block.box(16, 0, 0, 17, 15.3, 1),
            Block.box(1, 0, -2, 2, 15.3, -1),
            Block.box(14, 0, 17, 15, 15.3, 18),
            Block.box(-2, 0, 14, -1, 15.3, 15),
            Block.box(17, 0, 1, 18, 15.3, 2),
            Block.box(18, 14.25, 5, 19, 15.25, 11),
            Block.box(17, 14.25, 2, 18, 15.25, 14),
            Block.box(16, 14.25, 1, 17, 15.25, 15),
            Block.box(15, 14.25, 0, 16, 15.25, 16),
            Block.box(14, 14.25, -1, 15, 15.25, 17),
            Block.box(2, 14.25, -2, 14, 15.25, 18),
            Block.box(5, 14.25, 18, 11, 15.25, 19),
            Block.box(1, 14.25, -1, 2, 15.25, 17),
            Block.box(0, 14.25, 0, 1, 15.25, 16),
            Block.box(-2, 14.25, 2, -1, 15.25, 14),
            Block.box(-1, 14.25, 1, 0, 15.25, 15),
            Block.box(5, 14.25, -3, 11, 15.25, -2),
            Block.box(-3, 14.25, 5, -2, 15.25, 11),
            Block.box(11, 14.25, -3, 14, 15.25, -2),
            Block.box(2, 14.25, -3, 5, 15.25, -2)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape shapeN = Stream.of(
            Block.box(19, 0, 4.54762, 20, 15.3, 10.547620000000002),
            Block.box(-4, 0, 4.54762, -3, 15.3, 10.547620000000002),
            Block.box(4.999999999999999, 0, -4.452379999999999, 11, 15.3, -3.452379999999999),
            Block.box(18, 0, 10.547620000000002, 19, 15.3, 13.547620000000002),
            Block.box(-3, 0, 1.5476200000000002, -2, 15.3, 4.54762),
            Block.box(18, 0, 1.5476200000000002, 19, 15.3, 4.54762),
            Block.box(-3, 0, 10.547620000000002, -2, 15.3, 13.547620000000002),
            Block.box(1.9999999999999991, 1, 17.547620000000002, 2.999999999999999, 14.25, 18.547620000000002),
            Block.box(11, 0, -3.452379999999999, 14, 15.3, -2.452379999999999),
            Block.box(13, 1, 17.547620000000002, 14, 14.25, 18.547620000000002),
            Block.box(1.9999999999999991, 0, -3.452379999999999, 4.999999999999999, 15.3, -2.452379999999999),
            Block.box(17, 0, 13.547620000000002, 18, 15.3, 14.547620000000002),
            Block.box(-2, 0, 0.5476200000000002, -1, 15.3, 1.5476200000000002),
            Block.box(14, 0, -2.452379999999999, 15, 15.3, -1.452379999999999),
            Block.box(0.9999999999999991, 0, 16.547620000000002, 1.9999999999999991, 15.3, 17.547620000000002),
            Block.box(16, 0, 14.547620000000002, 17, 15.3, 15.547620000000002),
            Block.box(-1, 0, -0.4523799999999989, 0, 15.3, 0.5476200000000002),
            Block.box(15, 0, -1.452379999999999, 16, 15.3, -0.4523799999999989),
            Block.box(0, 0, 15.547620000000002, 0.9999999999999991, 15.3, 16.547620000000002),
            Block.box(15, 0, 15.547620000000002, 16, 15.3, 16.547620000000002),
            Block.box(0, 0, -1.452379999999999, 0.9999999999999991, 15.3, -0.4523799999999989),
            Block.box(16, 0, -0.4523799999999989, 17, 15.3, 0.5476200000000002),
            Block.box(-1, 0, 14.547620000000002, 0, 15.3, 15.547620000000002),
            Block.box(14, 0, 16.547620000000002, 15, 15.3, 17.547620000000002),
            Block.box(0.9999999999999991, 0, -2.452379999999999, 1.9999999999999991, 15.3, -1.452379999999999),
            Block.box(17, 0, 0.5476200000000002, 18, 15.3, 1.5476200000000002),
            Block.box(-2, 0, 13.547620000000002, -1, 15.3, 14.547620000000002),
            Block.box(-3, 14.25, 4.54762, -2, 15.25, 10.547620000000002),
            Block.box(-2, 14.25, 1.5476200000000002, -1, 15.25, 13.547620000000002),
            Block.box(-1, 14.25, 0.5476200000000002, 0, 15.25, 14.547620000000002),
            Block.box(0, 14.25, -0.4523799999999989, 0.9999999999999991, 15.25, 15.547620000000002),
            Block.box(0.9999999999999991, 14.25, -1.452379999999999, 1.9999999999999991, 15.25, 16.547620000000002),
            Block.box(1.9999999999999991, 14.25, -2.452379999999999, 14, 15.25, 17.547620000000002),
            Block.box(4.999999999999999, 14.25, -3.452379999999999, 11, 15.25, -2.452379999999999),
            Block.box(14, 14.25, -1.452379999999999, 15, 15.25, 16.547620000000002),
            Block.box(15, 14.25, -0.4523799999999989, 16, 15.25, 15.547620000000002),
            Block.box(17, 14.25, 1.5476200000000002, 18, 15.25, 13.547620000000002),
            Block.box(16, 14.25, 0.5476200000000002, 17, 15.25, 14.547620000000002),
            Block.box(4.999999999999999, 14.25, 17.547620000000002, 11, 15.25, 18.547620000000002),
            Block.box(18, 14.25, 4.54762, 19, 15.25, 10.547620000000002),
            Block.box(1.9999999999999991, 14.25, 17.547620000000002, 4.999999999999999, 15.25, 18.547620000000002),
            Block.box(11, 14.25, 17.547620000000002, 14, 15.25, 18.547620000000002)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape shapeW = Stream.of(
            Block.box(4.77381, 0, -4.22619, 10.773810000000001, 15.3, -3.22619),
            Block.box(4.77381, 0, 18.77381, 10.773810000000001, 15.3, 19.77381),
            Block.box(-4.226189999999999, 0, 4.77381, -3.226189999999999, 15.3, 10.773810000000001),
            Block.box(10.773810000000001, 0, -3.22619, 13.773810000000001, 15.3, -2.22619),
            Block.box(1.77381, 0, 17.77381, 4.77381, 15.3, 18.77381),
            Block.box(1.77381, 0, -3.22619, 4.77381, 15.3, -2.22619),
            Block.box(10.773810000000001, 0, 17.77381, 13.773810000000001, 15.3, 18.77381),
            Block.box(17.77381, 1, 12.773810000000001, 18.77381, 14.25, 13.773810000000001),
            Block.box(-3.226189999999999, 0, 1.77381, -2.226189999999999, 15.3, 4.77381),
            Block.box(17.77381, 1, 1.77381, 18.77381, 14.25, 2.77381),
            Block.box(-3.226189999999999, 0, 10.773810000000001, -2.226189999999999, 15.3, 13.773810000000001),
            Block.box(13.773810000000001, 0, -2.22619, 14.773810000000001, 15.3, -1.22619),
            Block.box(0.7738100000000001, 0, 16.77381, 1.77381, 15.3, 17.77381),
            Block.box(-2.226189999999999, 0, 0.7738100000000001, -1.226189999999999, 15.3, 1.77381),
            Block.box(16.77381, 0, 13.773810000000001, 17.77381, 15.3, 14.773810000000001),
            Block.box(14.773810000000001, 0, -1.22619, 15.773810000000001, 15.3, -0.2261899999999999),
            Block.box(-0.226189999999999, 0, 15.773810000000001, 0.7738100000000001, 15.3, 16.77381),
            Block.box(-1.226189999999999, 0, -0.2261899999999999, -0.226189999999999, 15.3, 0.7738100000000001),
            Block.box(15.773810000000001, 0, 14.773810000000001, 16.77381, 15.3, 15.773810000000001),
            Block.box(15.773810000000001, 0, -0.2261899999999999, 16.77381, 15.3, 0.7738100000000001),
            Block.box(-1.226189999999999, 0, 14.773810000000001, -0.226189999999999, 15.3, 15.773810000000001),
            Block.box(-0.226189999999999, 0, -1.22619, 0.7738100000000001, 15.3, -0.2261899999999999),
            Block.box(14.773810000000001, 0, 15.773810000000001, 15.773810000000001, 15.3, 16.77381),
            Block.box(16.77381, 0, 0.7738100000000001, 17.77381, 15.3, 1.77381),
            Block.box(-2.226189999999999, 0, 13.773810000000001, -1.226189999999999, 15.3, 14.773810000000001),
            Block.box(0.7738100000000001, 0, -2.22619, 1.77381, 15.3, -1.22619),
            Block.box(13.773810000000001, 0, 16.77381, 14.773810000000001, 15.3, 17.77381),
            Block.box(4.77381, 14.25, 17.77381, 10.773810000000001, 15.25, 18.77381),
            Block.box(1.77381, 14.25, 16.77381, 13.773810000000001, 15.25, 17.77381),
            Block.box(0.7738100000000001, 14.25, 15.773810000000001, 14.773810000000001, 15.25, 16.77381),
            Block.box(-0.226189999999999, 14.25, 14.773810000000001, 15.773810000000001, 15.25, 15.773810000000001),
            Block.box(-1.226189999999999, 14.25, 13.773810000000001, 16.77381, 15.25, 14.773810000000001),
            Block.box(-2.226189999999999, 14.25, 1.77381, 17.77381, 15.25, 13.773810000000001),
            Block.box(-3.226189999999999, 14.25, 4.77381, -2.226189999999999, 15.25, 10.773810000000001),
            Block.box(-1.226189999999999, 14.25, 0.7738100000000001, 16.77381, 15.25, 1.77381),
            Block.box(-0.226189999999999, 14.25, -0.2261899999999999, 15.773810000000001, 15.25, 0.7738100000000001),
            Block.box(1.77381, 14.25, -2.22619, 13.773810000000001, 15.25, -1.22619),
            Block.box(0.7738100000000001, 14.25, -1.22619, 14.773810000000001, 15.25, -0.2261899999999999),
            Block.box(17.77381, 14.25, 4.77381, 18.77381, 15.25, 10.773810000000001),
            Block.box(4.77381, 14.25, -3.22619, 10.773810000000001, 15.25, -2.22619),
            Block.box(17.77381, 14.25, 10.773810000000001, 18.77381, 15.25, 13.773810000000001),
            Block.box(17.77381, 14.25, 1.77381, 18.77381, 15.25, 4.77381)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape shapeE = Stream.of(
            Block.box(5.226189999999998, 0, 18.77381, 11.226189999999999, 15.3, 19.77381),
            Block.box(5.226189999999998, 0, -4.22619, 11.226189999999999, 15.3, -3.22619),
            Block.box(19.22619, 0, 4.773809999999999, 20.22619, 15.3, 10.773810000000001),
            Block.box(2.226189999999998, 0, 17.77381, 5.226189999999998, 15.3, 18.77381),
            Block.box(11.226189999999999, 0, -3.22619, 14.226189999999999, 15.3, -2.22619),
            Block.box(11.226189999999999, 0, 17.77381, 14.226189999999999, 15.3, 18.77381),
            Block.box(2.226189999999998, 0, -3.22619, 5.226189999999998, 15.3, -2.22619),
            Block.box(-2.773810000000001, 1, 1.7738099999999992, -1.773810000000001, 14.25, 2.773809999999999),
            Block.box(18.22619, 0, 10.773810000000001, 19.22619, 15.3, 13.773810000000001),
            Block.box(-2.773810000000001, 1, 12.773810000000001, -1.773810000000001, 14.25, 13.773810000000001),
            Block.box(18.22619, 0, 1.7738099999999992, 19.22619, 15.3, 4.773809999999999),
            Block.box(1.2261899999999981, 0, 16.77381, 2.226189999999998, 15.3, 17.77381),
            Block.box(14.226189999999999, 0, -2.22619, 15.226189999999999, 15.3, -1.22619),
            Block.box(17.22619, 0, 13.773810000000001, 18.22619, 15.3, 14.773810000000001),
            Block.box(-1.773810000000001, 0, 0.7738099999999992, -0.773810000000001, 15.3, 1.7738099999999992),
            Block.box(0.22618999999999811, 0, 15.773810000000001, 1.2261899999999981, 15.3, 16.77381),
            Block.box(15.226189999999999, 0, -1.22619, 16.22619, 15.3, -0.2261899999999999),
            Block.box(16.22619, 0, 14.773810000000001, 17.22619, 15.3, 15.773810000000001),
            Block.box(-0.773810000000001, 0, -0.2261899999999999, 0.22618999999999811, 15.3, 0.7738099999999992),
            Block.box(-0.773810000000001, 0, 14.773810000000001, 0.22618999999999811, 15.3, 15.773810000000001),
            Block.box(16.22619, 0, -0.2261899999999999, 17.22619, 15.3, 0.7738099999999992),
            Block.box(15.226189999999999, 0, 15.773810000000001, 16.22619, 15.3, 16.77381),
            Block.box(0.22618999999999811, 0, -1.22619, 1.2261899999999981, 15.3, -0.2261899999999999),
            Block.box(-1.773810000000001, 0, 13.773810000000001, -0.773810000000001, 15.3, 14.773810000000001),
            Block.box(17.22619, 0, 0.7738099999999992, 18.22619, 15.3, 1.7738099999999992),
            Block.box(14.226189999999999, 0, 16.77381, 15.226189999999999, 15.3, 17.77381),
            Block.box(1.2261899999999981, 0, -2.22619, 2.226189999999998, 15.3, -1.22619),
            Block.box(5.226189999999998, 14.25, -3.22619, 11.226189999999999, 15.25, -2.22619),
            Block.box(2.226189999999998, 14.25, -2.22619, 14.226189999999999, 15.25, -1.22619),
            Block.box(1.2261899999999981, 14.25, -1.22619, 15.226189999999999, 15.25, -0.2261899999999999),
            Block.box(0.22618999999999811, 14.25, -0.2261899999999999, 16.22619, 15.25, 0.7738099999999992),
            Block.box(-0.773810000000001, 14.25, 0.7738099999999992, 17.22619, 15.25, 1.7738099999999992),
            Block.box(-1.773810000000001, 14.25, 1.7738099999999992, 18.22619, 15.25, 13.773810000000001),
            Block.box(18.22619, 14.25, 4.773809999999999, 19.22619, 15.25, 10.773810000000001),
            Block.box(-0.773810000000001, 14.25, 13.773810000000001, 17.22619, 15.25, 14.773810000000001),
            Block.box(0.22618999999999811, 14.25, 14.773810000000001, 16.22619, 15.25, 15.773810000000001),
            Block.box(2.226189999999998, 14.25, 16.77381, 14.226189999999999, 15.25, 17.77381),
            Block.box(1.2261899999999981, 14.25, 15.773810000000001, 15.226189999999999, 15.25, 16.77381),
            Block.box(-2.773810000000001, 14.25, 4.773809999999999, -1.773810000000001, 15.25, 10.773810000000001),
            Block.box(5.226189999999998, 14.25, 17.77381, 11.226189999999999, 15.25, 18.77381),
            Block.box(-2.773810000000001, 14.25, 1.7738099999999992, -1.773810000000001, 15.25, 4.773809999999999),
            Block.box(-2.773810000000001, 14.25, 10.773810000000001, -1.773810000000001, 15.25, 13.773810000000001)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape blockShape = Block.box(0, 0, 0, 16, 16, 16);


    public ScannerTop(@NotNull Properties properties) {
        super(properties);

        this.registerDefaultState(this.defaultBlockState().setValue(directionPropertyTop, Direction.NORTH).setValue(scannerFormedTop, false));
    }

    @Override
    public @NotNull BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        return this.defaultBlockState().setValue(directionPropertyTop, context.getHorizontalDirection());
    }

    //mod compatiability
    @Nonnull
    @Override
    public BlockState rotate(@NotNull BlockState state, @NotNull Rotation rot) {
        return state.setValue(directionPropertyTop, rot.rotate(state.getValue(directionPropertyTop)));
    }

    @Nonnull
    @Override
    public BlockState mirror(@NotNull BlockState state, @NotNull Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(directionPropertyTop)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(directionPropertyTop).add(scannerFormedTop);
    }

    @Override
    public @NotNull VoxelShape getOcclusionShape(@NotNull BlockState state, BlockGetter pLevel, BlockPos pPos) {
        switch (state.getValue(directionPropertyTop)) {
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

    @Nonnull
    @Override
    public VoxelShape getShape(@NotNull BlockState state, @Nonnull BlockGetter worldIn, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        if (state.getValue(scannerFormedTop)) {
            switch (state.getValue(directionPropertyTop)) {
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
        } else {
            return blockShape;
        }
    }
}
