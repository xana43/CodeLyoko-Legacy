package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public final class ScannerTop extends HorizontalFacingBlock {

    private static final VoxelShape shapeS = Stream.of(Block.createCuboidShape(-4, 0, 5, -3, 15.3, 11),
                    Block.createCuboidShape(19, 0, 5, 20, 15.3, 11), Block.createCuboidShape(5, 0, 19, 11, 15.3, 20),
                    Block.createCuboidShape(-3, 0, 2, -2, 15.3, 5), Block.createCuboidShape(18, 0, 11, 19, 15.3, 14),
                    Block.createCuboidShape(-3, 0, 11, -2, 15.3, 14), Block.createCuboidShape(18, 0, 2, 19, 15.3, 5),
                    Block.createCuboidShape(13, 1, -3, 14, 14.25, -2), Block.createCuboidShape(2, 0, 18, 5, 15.3, 19),
                    Block.createCuboidShape(2, 1, -3, 3, 14.25, -2), Block.createCuboidShape(11, 0, 18, 14, 15.3, 19),
                    Block.createCuboidShape(-2, 0, 1, -1, 15.3, 2), Block.createCuboidShape(17, 0, 14, 18, 15.3, 15),
                    Block.createCuboidShape(1, 0, 17, 2, 15.3, 18), Block.createCuboidShape(14, 0, -2, 15, 15.3, -1),
                    Block.createCuboidShape(-1, 0, 0, 0, 15.3, 1), Block.createCuboidShape(16, 0, 15, 17, 15.3, 16),
                    Block.createCuboidShape(0, 0, 16, 1, 15.3, 17), Block.createCuboidShape(15, 0, -1, 16, 15.3, 0),
                    Block.createCuboidShape(0, 0, -1, 1, 15.3, 0), Block.createCuboidShape(15, 0, 16, 16, 15.3, 17),
                    Block.createCuboidShape(-1, 0, 15, 0, 15.3, 16), Block.createCuboidShape(16, 0, 0, 17, 15.3, 1),
                    Block.createCuboidShape(1, 0, -2, 2, 15.3, -1), Block.createCuboidShape(14, 0, 17, 15, 15.3, 18),
                    Block.createCuboidShape(-2, 0, 14, -1, 15.3, 15), Block.createCuboidShape(17, 0, 1, 18, 15.3, 2),
                    Block.createCuboidShape(18, 14.25, 5, 19, 15.25, 11), Block.createCuboidShape(17, 14.25, 2, 18, 15.25, 14),
                    Block.createCuboidShape(16, 14.25, 1, 17, 15.25, 15), Block.createCuboidShape(15, 14.25, 0, 16, 15.25, 16),
                    Block.createCuboidShape(14, 14.25, -1, 15, 15.25, 17), Block.createCuboidShape(2, 14.25, -2, 14, 15.25, 18),
                    Block.createCuboidShape(5, 14.25, 18, 11, 15.25, 19), Block.createCuboidShape(1, 14.25, -1, 2, 15.25, 17),
                    Block.createCuboidShape(0, 14.25, 0, 1, 15.25, 16), Block.createCuboidShape(-2, 14.25, 2, -1, 15.25, 14),
                    Block.createCuboidShape(-1, 14.25, 1, 0, 15.25, 15), Block.createCuboidShape(5, 14.25, -3, 11, 15.25, -2),
                    Block.createCuboidShape(-3, 14.25, 5, -2, 15.25, 11), Block.createCuboidShape(11, 14.25, -3, 14, 15.25, -2),
                    Block.createCuboidShape(2, 14.25, -3, 5, 15.25, -2))
            .reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape shapeN = Stream.of(
                    Block.createCuboidShape(19, 0, 4.54762, 20, 15.3, 10.547620000000002),
                    Block.createCuboidShape(-4, 0, 4.54762, -3, 15.3, 10.547620000000002),
                    Block.createCuboidShape(4.999999999999999, 0, -4.452379999999999, 11, 15.3, -3.452379999999999),
                    Block.createCuboidShape(18, 0, 10.547620000000002, 19, 15.3, 13.547620000000002),
                    Block.createCuboidShape(-3, 0, 1.5476200000000002, -2, 15.3, 4.54762),
                    Block.createCuboidShape(18, 0, 1.5476200000000002, 19, 15.3, 4.54762),
                    Block.createCuboidShape(-3, 0, 10.547620000000002, -2, 15.3, 13.547620000000002),
                    Block.createCuboidShape(1.9999999999999991, 1, 17.547620000000002, 2.999999999999999, 14.25,
                            18.547620000000002),
                    Block.createCuboidShape(11, 0, -3.452379999999999, 14, 15.3, -2.452379999999999),
                    Block.createCuboidShape(13, 1, 17.547620000000002, 14, 14.25, 18.547620000000002),
                    Block.createCuboidShape(1.9999999999999991, 0, -3.452379999999999, 4.999999999999999, 15.3,
                            -2.452379999999999),
                    Block.createCuboidShape(17, 0, 13.547620000000002, 18, 15.3, 14.547620000000002),
                    Block.createCuboidShape(-2, 0, 0.5476200000000002, -1, 15.3, 1.5476200000000002),
                    Block.createCuboidShape(14, 0, -2.452379999999999, 15, 15.3, -1.452379999999999),
                    Block.createCuboidShape(0.9999999999999991, 0, 16.547620000000002, 1.9999999999999991, 15.3,
                            17.547620000000002),
                    Block.createCuboidShape(16, 0, 14.547620000000002, 17, 15.3, 15.547620000000002),
                    Block.createCuboidShape(-1, 0, -0.4523799999999989, 0, 15.3, 0.5476200000000002),
                    Block.createCuboidShape(15, 0, -1.452379999999999, 16, 15.3, -0.4523799999999989),
                    Block.createCuboidShape(0, 0, 15.547620000000002, 0.9999999999999991, 15.3, 16.547620000000002),
                    Block.createCuboidShape(15, 0, 15.547620000000002, 16, 15.3, 16.547620000000002),
                    Block.createCuboidShape(0, 0, -1.452379999999999, 0.9999999999999991, 15.3, -0.4523799999999989),
                    Block.createCuboidShape(16, 0, -0.4523799999999989, 17, 15.3, 0.5476200000000002),
                    Block.createCuboidShape(-1, 0, 14.547620000000002, 0, 15.3, 15.547620000000002),
                    Block.createCuboidShape(14, 0, 16.547620000000002, 15, 15.3, 17.547620000000002),
                    Block.createCuboidShape(0.9999999999999991, 0, -2.452379999999999, 1.9999999999999991, 15.3,
                            -1.452379999999999),
                    Block.createCuboidShape(17, 0, 0.5476200000000002, 18, 15.3, 1.5476200000000002),
                    Block.createCuboidShape(-2, 0, 13.547620000000002, -1, 15.3, 14.547620000000002),
                    Block.createCuboidShape(-3, 14.25, 4.54762, -2, 15.25, 10.547620000000002),
                    Block.createCuboidShape(-2, 14.25, 1.5476200000000002, -1, 15.25, 13.547620000000002),
                    Block.createCuboidShape(-1, 14.25, 0.5476200000000002, 0, 15.25, 14.547620000000002),
                    Block.createCuboidShape(0, 14.25, -0.4523799999999989, 0.9999999999999991, 15.25, 15.547620000000002),
                    Block.createCuboidShape(0.9999999999999991, 14.25, -1.452379999999999, 1.9999999999999991, 15.25,
                            16.547620000000002),
                    Block.createCuboidShape(1.9999999999999991, 14.25, -2.452379999999999, 14, 15.25, 17.547620000000002),
                    Block.createCuboidShape(4.999999999999999, 14.25, -3.452379999999999, 11, 15.25, -2.452379999999999),
                    Block.createCuboidShape(14, 14.25, -1.452379999999999, 15, 15.25, 16.547620000000002),
                    Block.createCuboidShape(15, 14.25, -0.4523799999999989, 16, 15.25, 15.547620000000002),
                    Block.createCuboidShape(17, 14.25, 1.5476200000000002, 18, 15.25, 13.547620000000002),
                    Block.createCuboidShape(16, 14.25, 0.5476200000000002, 17, 15.25, 14.547620000000002),
                    Block.createCuboidShape(4.999999999999999, 14.25, 17.547620000000002, 11, 15.25, 18.547620000000002),
                    Block.createCuboidShape(18, 14.25, 4.54762, 19, 15.25, 10.547620000000002),
                    Block.createCuboidShape(1.9999999999999991, 14.25, 17.547620000000002, 4.999999999999999, 15.25,
                            18.547620000000002),
                    Block.createCuboidShape(11, 14.25, 17.547620000000002, 14, 15.25, 18.547620000000002))
            .reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape shapeW = Stream.of(
                    Block.createCuboidShape(4.77381, 0, -4.22619, 10.773810000000001, 15.3, -3.22619),
                    Block.createCuboidShape(4.77381, 0, 18.77381, 10.773810000000001, 15.3, 19.77381),
                    Block.createCuboidShape(-4.226189999999999, 0, 4.77381, -3.226189999999999, 15.3, 10.773810000000001),
                    Block.createCuboidShape(10.773810000000001, 0, -3.22619, 13.773810000000001, 15.3, -2.22619),
                    Block.createCuboidShape(1.77381, 0, 17.77381, 4.77381, 15.3, 18.77381),
                    Block.createCuboidShape(1.77381, 0, -3.22619, 4.77381, 15.3, -2.22619),
                    Block.createCuboidShape(10.773810000000001, 0, 17.77381, 13.773810000000001, 15.3, 18.77381),
                    Block.createCuboidShape(17.77381, 1, 12.773810000000001, 18.77381, 14.25, 13.773810000000001),
                    Block.createCuboidShape(-3.226189999999999, 0, 1.77381, -2.226189999999999, 15.3, 4.77381),
                    Block.createCuboidShape(17.77381, 1, 1.77381, 18.77381, 14.25, 2.77381),
                    Block.createCuboidShape(-3.226189999999999, 0, 10.773810000000001, -2.226189999999999, 15.3,
                            13.773810000000001),
                    Block.createCuboidShape(13.773810000000001, 0, -2.22619, 14.773810000000001, 15.3, -1.22619),
                    Block.createCuboidShape(0.7738100000000001, 0, 16.77381, 1.77381, 15.3, 17.77381),
                    Block.createCuboidShape(-2.226189999999999, 0, 0.7738100000000001, -1.226189999999999, 15.3, 1.77381),
                    Block.createCuboidShape(16.77381, 0, 13.773810000000001, 17.77381, 15.3, 14.773810000000001),
                    Block.createCuboidShape(14.773810000000001, 0, -1.22619, 15.773810000000001, 15.3, -0.2261899999999999),
                    Block.createCuboidShape(-0.226189999999999, 0, 15.773810000000001, 0.7738100000000001, 15.3, 16.77381),
                    Block.createCuboidShape(-1.226189999999999, 0, -0.2261899999999999, -0.226189999999999, 15.3,
                            0.7738100000000001),
                    Block.createCuboidShape(15.773810000000001, 0, 14.773810000000001, 16.77381, 15.3, 15.773810000000001),
                    Block.createCuboidShape(15.773810000000001, 0, -0.2261899999999999, 16.77381, 15.3, 0.7738100000000001),
                    Block.createCuboidShape(-1.226189999999999, 0, 14.773810000000001, -0.226189999999999, 15.3,
                            15.773810000000001),
                    Block.createCuboidShape(-0.226189999999999, 0, -1.22619, 0.7738100000000001, 15.3, -0.2261899999999999),
                    Block.createCuboidShape(14.773810000000001, 0, 15.773810000000001, 15.773810000000001, 15.3, 16.77381),
                    Block.createCuboidShape(16.77381, 0, 0.7738100000000001, 17.77381, 15.3, 1.77381),
                    Block.createCuboidShape(-2.226189999999999, 0, 13.773810000000001, -1.226189999999999, 15.3,
                            14.773810000000001),
                    Block.createCuboidShape(0.7738100000000001, 0, -2.22619, 1.77381, 15.3, -1.22619),
                    Block.createCuboidShape(13.773810000000001, 0, 16.77381, 14.773810000000001, 15.3, 17.77381),
                    Block.createCuboidShape(4.77381, 14.25, 17.77381, 10.773810000000001, 15.25, 18.77381),
                    Block.createCuboidShape(1.77381, 14.25, 16.77381, 13.773810000000001, 15.25, 17.77381),
                    Block.createCuboidShape(0.7738100000000001, 14.25, 15.773810000000001, 14.773810000000001, 15.25, 16.77381),
                    Block.createCuboidShape(-0.226189999999999, 14.25, 14.773810000000001, 15.773810000000001, 15.25,
                            15.773810000000001),
                    Block.createCuboidShape(-1.226189999999999, 14.25, 13.773810000000001, 16.77381, 15.25, 14.773810000000001),
                    Block.createCuboidShape(-2.226189999999999, 14.25, 1.77381, 17.77381, 15.25, 13.773810000000001),
                    Block.createCuboidShape(-3.226189999999999, 14.25, 4.77381, -2.226189999999999, 15.25, 10.773810000000001),
                    Block.createCuboidShape(-1.226189999999999, 14.25, 0.7738100000000001, 16.77381, 15.25, 1.77381),
                    Block.createCuboidShape(-0.226189999999999, 14.25, -0.2261899999999999, 15.773810000000001, 15.25,
                            0.7738100000000001),
                    Block.createCuboidShape(1.77381, 14.25, -2.22619, 13.773810000000001, 15.25, -1.22619),
                    Block.createCuboidShape(0.7738100000000001, 14.25, -1.22619, 14.773810000000001, 15.25,
                            -0.2261899999999999),
                    Block.createCuboidShape(17.77381, 14.25, 4.77381, 18.77381, 15.25, 10.773810000000001),
                    Block.createCuboidShape(4.77381, 14.25, -3.22619, 10.773810000000001, 15.25, -2.22619),
                    Block.createCuboidShape(17.77381, 14.25, 10.773810000000001, 18.77381, 15.25, 13.773810000000001),
                    Block.createCuboidShape(17.77381, 14.25, 1.77381, 18.77381, 15.25, 4.77381))
            .reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape shapeE = Stream.of(
                    Block.createCuboidShape(5.226189999999998, 0, 18.77381, 11.226189999999999, 15.3, 19.77381),
                    Block.createCuboidShape(5.226189999999998, 0, -4.22619, 11.226189999999999, 15.3, -3.22619),
                    Block.createCuboidShape(19.22619, 0, 4.773809999999999, 20.22619, 15.3, 10.773810000000001),
                    Block.createCuboidShape(2.226189999999998, 0, 17.77381, 5.226189999999998, 15.3, 18.77381),
                    Block.createCuboidShape(11.226189999999999, 0, -3.22619, 14.226189999999999, 15.3, -2.22619),
                    Block.createCuboidShape(11.226189999999999, 0, 17.77381, 14.226189999999999, 15.3, 18.77381),
                    Block.createCuboidShape(2.226189999999998, 0, -3.22619, 5.226189999999998, 15.3, -2.22619),
                    Block.createCuboidShape(-2.773810000000001, 1, 1.7738099999999992, -1.773810000000001, 14.25,
                            2.773809999999999),
                    Block.createCuboidShape(18.22619, 0, 10.773810000000001, 19.22619, 15.3, 13.773810000000001),
                    Block.createCuboidShape(-2.773810000000001, 1, 12.773810000000001, -1.773810000000001, 14.25,
                            13.773810000000001),
                    Block.createCuboidShape(18.22619, 0, 1.7738099999999992, 19.22619, 15.3, 4.773809999999999),
                    Block.createCuboidShape(1.2261899999999981, 0, 16.77381, 2.226189999999998, 15.3, 17.77381),
                    Block.createCuboidShape(14.226189999999999, 0, -2.22619, 15.226189999999999, 15.3, -1.22619),
                    Block.createCuboidShape(17.22619, 0, 13.773810000000001, 18.22619, 15.3, 14.773810000000001),
                    Block.createCuboidShape(-1.773810000000001, 0, 0.7738099999999992, -0.773810000000001, 15.3,
                            1.7738099999999992),
                    Block.createCuboidShape(0.22618999999999811, 0, 15.773810000000001, 1.2261899999999981, 15.3, 16.77381),
                    Block.createCuboidShape(15.226189999999999, 0, -1.22619, 16.22619, 15.3, -0.2261899999999999),
                    Block.createCuboidShape(16.22619, 0, 14.773810000000001, 17.22619, 15.3, 15.773810000000001),
                    Block.createCuboidShape(-0.773810000000001, 0, -0.2261899999999999, 0.22618999999999811, 15.3,
                            0.7738099999999992),
                    Block.createCuboidShape(-0.773810000000001, 0, 14.773810000000001, 0.22618999999999811, 15.3,
                            15.773810000000001),
                    Block.createCuboidShape(16.22619, 0, -0.2261899999999999, 17.22619, 15.3, 0.7738099999999992),
                    Block.createCuboidShape(15.226189999999999, 0, 15.773810000000001, 16.22619, 15.3, 16.77381),
                    Block.createCuboidShape(0.22618999999999811, 0, -1.22619, 1.2261899999999981, 15.3, -0.2261899999999999),
                    Block.createCuboidShape(-1.773810000000001, 0, 13.773810000000001, -0.773810000000001, 15.3,
                            14.773810000000001),
                    Block.createCuboidShape(17.22619, 0, 0.7738099999999992, 18.22619, 15.3, 1.7738099999999992),
                    Block.createCuboidShape(14.226189999999999, 0, 16.77381, 15.226189999999999, 15.3, 17.77381),
                    Block.createCuboidShape(1.2261899999999981, 0, -2.22619, 2.226189999999998, 15.3, -1.22619),
                    Block.createCuboidShape(5.226189999999998, 14.25, -3.22619, 11.226189999999999, 15.25, -2.22619),
                    Block.createCuboidShape(2.226189999999998, 14.25, -2.22619, 14.226189999999999, 15.25, -1.22619),
                    Block.createCuboidShape(1.2261899999999981, 14.25, -1.22619, 15.226189999999999, 15.25,
                            -0.2261899999999999),
                    Block.createCuboidShape(0.22618999999999811, 14.25, -0.2261899999999999, 16.22619, 15.25,
                            0.7738099999999992),
                    Block.createCuboidShape(-0.773810000000001, 14.25, 0.7738099999999992, 17.22619, 15.25, 1.7738099999999992),
                    Block.createCuboidShape(-1.773810000000001, 14.25, 1.7738099999999992, 18.22619, 15.25, 13.773810000000001),
                    Block.createCuboidShape(18.22619, 14.25, 4.773809999999999, 19.22619, 15.25, 10.773810000000001),
                    Block.createCuboidShape(-0.773810000000001, 14.25, 13.773810000000001, 17.22619, 15.25, 14.773810000000001),
                    Block.createCuboidShape(0.22618999999999811, 14.25, 14.773810000000001, 16.22619, 15.25,
                            15.773810000000001),
                    Block.createCuboidShape(2.226189999999998, 14.25, 16.77381, 14.226189999999999, 15.25, 17.77381),
                    Block.createCuboidShape(1.2261899999999981, 14.25, 15.773810000000001, 15.226189999999999, 15.25, 16.77381),
                    Block.createCuboidShape(-2.773810000000001, 14.25, 4.773809999999999, -1.773810000000001, 15.25,
                            10.773810000000001),
                    Block.createCuboidShape(5.226189999999998, 14.25, 17.77381, 11.226189999999999, 15.25, 18.77381),
                    Block.createCuboidShape(-2.773810000000001, 14.25, 1.7738099999999992, -1.773810000000001, 15.25,
                            4.773809999999999),
                    Block.createCuboidShape(-2.773810000000001, 14.25, 10.773810000000001, -1.773810000000001, 15.25,
                            13.773810000000001))
            .reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape blockShape = Block.createCuboidShape(0, 0, 0, 16, 16, 16);


    public ScannerTop(@NotNull final Settings properties) {
        super(properties);

        this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH)
                .with(Scanner.SCANNER_PROPERTY, Boolean.FALSE));
    }


    @Nullable
    @Override
    public BlockState getPlacementState(final ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing()).with(Scanner.SCANNER_PROPERTY, Boolean.FALSE);
    }

    @Override
    protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(Scanner.SCANNER_PROPERTY).add(FACING));
    }

    @Override
    public VoxelShape getOutlineShape(final BlockState state, final BlockView world, final BlockPos pos, final ShapeContext context) {
        if (state.<Boolean>get(Scanner.SCANNER_PROPERTY).booleanValue()) {
            return switch (state.get(FACING)) {
                case SOUTH -> shapeS;
                case EAST -> shapeE;
                case WEST -> shapeW;
                default -> shapeN;
            };
        } else {
            return blockShape;
        }
    }
}
