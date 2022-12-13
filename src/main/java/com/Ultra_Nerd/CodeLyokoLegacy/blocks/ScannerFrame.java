package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import com.Ultra_Nerd.CodeLyokoLegacy.util.ConstantUtil;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
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

public final class ScannerFrame extends HorizontalFacingBlock {


    private static final VoxelShape shapeS = Stream.of(Block.createCuboidShape(-4, 0, 5, -3, 15.3, 11),
                    Block.createCuboidShape(19, 0, 5, 20, 15.3, 11), Block.createCuboidShape(5, 0, 19, 11, 15.3, 20),
                    Block.createCuboidShape(-3, 0, 2, -2, 15.3, 5), Block.createCuboidShape(18, 0, 11, 19, 15.3, 14),
                    Block.createCuboidShape(-3, 0, 11, -2, 15.3, 14), Block.createCuboidShape(18, 0, 2, 19, 15.3, 5),
                    Block.createCuboidShape(13, 1, -3, 14, 16.3, -2), Block.createCuboidShape(2, 0, 18, 5, 15.3, 19),
                    Block.createCuboidShape(2, 1, -3, 3, 16.3, -2), Block.createCuboidShape(11, 0, 18, 14, 15.3, 19),
                    Block.createCuboidShape(-2, 0, 1, -1, 15.3, 2), Block.createCuboidShape(17, 0, 14, 18, 15.3, 15),
                    Block.createCuboidShape(1, 0, 17, 2, 15.3, 18), Block.createCuboidShape(14, 0, -2, 15, 15.3, -1),
                    Block.createCuboidShape(-1, 0, 0, 0, 15.3, 1), Block.createCuboidShape(16, 0, 15, 17, 15.3, 16),
                    Block.createCuboidShape(0, 0, 16, 1, 15.3, 17), Block.createCuboidShape(15, 0, -1, 16, 15.3, 0),
                    Block.createCuboidShape(0, 0, -1, 1, 15.3, 0), Block.createCuboidShape(15, 0, 16, 16, 15.3, 17),
                    Block.createCuboidShape(-1, 0, 15, 0, 15.3, 16), Block.createCuboidShape(16, 0, 0, 17, 15.3, 1),
                    Block.createCuboidShape(1, 0, -2, 2, 15.3, -1), Block.createCuboidShape(14, 0, 17, 15, 15.3, 18),
                    Block.createCuboidShape(-2, 0, 14, -1, 15.3, 15), Block.createCuboidShape(17, 0, 1, 18, 15.3, 2))
            .reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape shapeN = Stream.of(
                    Block.createCuboidShape(19, 0, 5.8518599999999985, 20, 15.3, 11.851859999999999),
                    Block.createCuboidShape(-4.000000000000002, 0, 5.8518599999999985, -3.0000000000000018, 15.3,
                            11.851859999999999),
                    Block.createCuboidShape(5, 0, -3.1481400000000015, 11, 15.3, -2.1481400000000015),
                    Block.createCuboidShape(18, 0, 11.851859999999999, 19, 15.3, 14.851859999999999),
                    Block.createCuboidShape(-3.0000000000000018, 0, 2.8518599999999985, -2.0000000000000018, 15.3,
                            5.8518599999999985),
                    Block.createCuboidShape(18, 0, 2.8518599999999985, 19, 15.3, 5.8518599999999985),
                    Block.createCuboidShape(-3.0000000000000018, 0, 11.851859999999999, -2.0000000000000018, 15.3,
                            14.851859999999999), Block.createCuboidShape(2, 1, 18.851860000000002, 3, 16.3, 19.851860000000002),
                    Block.createCuboidShape(11, 0, -2.1481400000000015, 14, 15.3, -1.1481400000000015),
                    Block.createCuboidShape(13, 1, 18.851860000000002, 14, 16.3, 19.851860000000002),
                    Block.createCuboidShape(2, 0, -2.1481400000000015, 5, 15.3, -1.1481400000000015),
                    Block.createCuboidShape(17, 0, 14.851859999999999, 18, 15.3, 15.851859999999999),
                    Block.createCuboidShape(-2.0000000000000018, 0, 1.8518599999999985, -1.0000000000000018, 15.3,
                            2.8518599999999985),
                    Block.createCuboidShape(14, 0, -1.1481400000000015, 15, 15.3, -0.1481400000000015),
                    Block.createCuboidShape(1, 0, 17.851860000000002, 2, 15.3, 18.851860000000002),
                    Block.createCuboidShape(16, 0, 15.851859999999999, 17, 15.3, 16.851860000000002),
                    Block.createCuboidShape(-1.0000000000000018, 0, 0.8518599999999985, -1.7763568394002505e-15, 15.3,
                            1.8518599999999985),
                    Block.createCuboidShape(15, 0, -0.1481400000000015, 16, 15.3, 0.8518599999999985),
                    Block.createCuboidShape(-1.7763568394002505e-15, 0, 16.851860000000002, 1, 15.3, 17.851860000000002),
                    Block.createCuboidShape(15, 0, 16.851860000000002, 16, 15.3, 17.851860000000002),
                    Block.createCuboidShape(-1.7763568394002505e-15, 0, -0.1481400000000015, 1, 15.3, 0.8518599999999985),
                    Block.createCuboidShape(16, 0, 0.8518599999999985, 17, 15.3, 1.8518599999999985),
                    Block.createCuboidShape(-1.0000000000000018, 0, 15.851859999999999, -1.7763568394002505e-15, 15.3,
                            16.851860000000002),
                    Block.createCuboidShape(14, 0, 17.851860000000002, 15, 15.3, 18.851860000000002),
                    Block.createCuboidShape(1, 0, -1.1481400000000015, 2, 15.3, -0.1481400000000015),
                    Block.createCuboidShape(17, 0, 1.8518599999999985, 18, 15.3, 2.8518599999999985),
                    Block.createCuboidShape(-2.0000000000000018, 0, 14.851859999999999, -1.0000000000000018, 15.3,
                            15.851859999999999))
            .reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape shapeW = Stream.of(
                    Block.createCuboidShape(5.425929999999999, 0, -3.5740700000000007, 11.42593, 15.3, -2.5740700000000007),
                    Block.createCuboidShape(5.425929999999999, 0, 19.42593, 11.42593, 15.3, 20.42593),
                    Block.createCuboidShape(-3.5740700000000007, 0, 5.425929999999999, -2.5740700000000007, 15.3, 11.42593),
                    Block.createCuboidShape(11.42593, 0, -2.5740700000000007, 14.42593, 15.3, -1.5740700000000007),
                    Block.createCuboidShape(2.4259299999999993, 0, 18.42593, 5.425929999999999, 15.3, 19.42593),
                    Block.createCuboidShape(2.4259299999999993, 0, -2.5740700000000007, 5.425929999999999, 15.3,
                            -1.5740700000000007), Block.createCuboidShape(11.42593, 0, 18.42593, 14.42593, 15.3, 19.42593),
                    Block.createCuboidShape(18.42593, 1, 13.42593, 19.42593, 16.3, 14.42593),
                    Block.createCuboidShape(-2.5740700000000007, 0, 2.4259299999999993, -1.5740700000000007, 15.3,
                            5.425929999999999),
                    Block.createCuboidShape(18.42593, 1, 2.4259299999999993, 19.42593, 16.3, 3.4259299999999993),
                    Block.createCuboidShape(-2.5740700000000007, 0, 11.42593, -1.5740700000000007, 15.3, 14.42593),
                    Block.createCuboidShape(14.42593, 0, -1.5740700000000007, 15.42593, 15.3, -0.5740700000000007),
                    Block.createCuboidShape(1.4259299999999993, 0, 17.42593, 2.4259299999999993, 15.3, 18.42593),
                    Block.createCuboidShape(-1.5740700000000007, 0, 1.4259299999999993, -0.5740700000000007, 15.3,
                            2.4259299999999993), Block.createCuboidShape(17.42593, 0, 14.42593, 18.42593, 15.3, 15.42593),
                    Block.createCuboidShape(15.42593, 0, -0.5740700000000007, 16.42593, 15.3, 0.42592999999999925),
                    Block.createCuboidShape(0.42592999999999925, 0, 16.42593, 1.4259299999999993, 15.3, 17.42593),
                    Block.createCuboidShape(-0.5740700000000007, 0, 0.42592999999999925, 0.42592999999999925, 15.3,
                            1.4259299999999993), Block.createCuboidShape(16.42593, 0, 15.42593, 17.42593, 15.3, 16.42593),
                    Block.createCuboidShape(16.42593, 0, 0.42592999999999925, 17.42593, 15.3, 1.4259299999999993),
                    Block.createCuboidShape(-0.5740700000000007, 0, 15.42593, 0.42592999999999925, 15.3, 16.42593),
                    Block.createCuboidShape(0.42592999999999925, 0, -0.5740700000000007, 1.4259299999999993, 15.3,
                            0.42592999999999925), Block.createCuboidShape(15.42593, 0, 16.42593, 16.42593, 15.3, 17.42593),
                    Block.createCuboidShape(17.42593, 0, 1.4259299999999993, 18.42593, 15.3, 2.4259299999999993),
                    Block.createCuboidShape(-1.5740700000000007, 0, 14.42593, -0.5740700000000007, 15.3, 15.42593),
                    Block.createCuboidShape(1.4259299999999993, 0, -1.5740700000000007, 2.4259299999999993, 15.3,
                            -0.5740700000000007), Block.createCuboidShape(14.42593, 0, 17.42593, 15.42593, 15.3, 18.42593))
            .reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape shapeE = Stream.of(
                    Block.createCuboidShape(4.574070000000001, 0, 19.42593, 10.57407, 15.3, 20.42593),
                    Block.createCuboidShape(4.574070000000001, 0, -3.5740700000000025, 10.57407, 15.3, -2.5740700000000025),
                    Block.createCuboidShape(18.57407, 0, 5.425929999999999, 19.57407, 15.3, 11.42593),
                    Block.createCuboidShape(1.5740700000000007, 0, 18.42593, 4.574070000000001, 15.3, 19.42593),
                    Block.createCuboidShape(10.57407, 0, -2.5740700000000025, 13.57407, 15.3, -1.5740700000000025),
                    Block.createCuboidShape(10.57407, 0, 18.42593, 13.57407, 15.3, 19.42593),
                    Block.createCuboidShape(1.5740700000000007, 0, -2.5740700000000025, 4.574070000000001, 15.3,
                            -1.5740700000000025),
                    Block.createCuboidShape(-3.425930000000003, 1, 2.4259299999999993, -2.425930000000003, 16.3,
                            3.4259299999999993), Block.createCuboidShape(17.57407, 0, 11.42593, 18.57407, 15.3, 14.42593),
                    Block.createCuboidShape(-3.425930000000003, 1, 13.42593, -2.425930000000003, 16.3, 14.42593),
                    Block.createCuboidShape(17.57407, 0, 2.4259299999999993, 18.57407, 15.3, 5.425929999999999),
                    Block.createCuboidShape(0.5740700000000007, 0, 17.42593, 1.5740700000000007, 15.3, 18.42593),
                    Block.createCuboidShape(13.57407, 0, -1.5740700000000025, 14.57407, 15.3, -0.5740700000000025),
                    Block.createCuboidShape(16.57407, 0, 14.42593, 17.57407, 15.3, 15.42593),
                    Block.createCuboidShape(-2.425930000000003, 0, 1.4259299999999993, -1.4259300000000028, 15.3,
                            2.4259299999999993),
                    Block.createCuboidShape(-0.4259300000000028, 0, 16.42593, 0.5740700000000007, 15.3, 17.42593),
                    Block.createCuboidShape(14.57407, 0, -0.5740700000000025, 15.57407, 15.3, 0.4259299999999975),
                    Block.createCuboidShape(15.57407, 0, 15.42593, 16.57407, 15.3, 16.42593),
                    Block.createCuboidShape(-1.4259300000000028, 0, 0.4259299999999975, -0.4259300000000028, 15.3,
                            1.4259299999999993),
                    Block.createCuboidShape(-1.4259300000000028, 0, 15.42593, -0.4259300000000028, 15.3, 16.42593),
                    Block.createCuboidShape(15.57407, 0, 0.4259299999999975, 16.57407, 15.3, 1.4259299999999993),
                    Block.createCuboidShape(14.57407, 0, 16.42593, 15.57407, 15.3, 17.42593),
                    Block.createCuboidShape(-0.4259300000000028, 0, -0.5740700000000025, 0.5740700000000007, 15.3,
                            0.4259299999999975),
                    Block.createCuboidShape(-2.425930000000003, 0, 14.42593, -1.4259300000000028, 15.3, 15.42593),
                    Block.createCuboidShape(16.57407, 0, 1.4259299999999993, 17.57407, 15.3, 2.4259299999999993),
                    Block.createCuboidShape(13.57407, 0, 17.42593, 14.57407, 15.3, 18.42593),
                    Block.createCuboidShape(0.5740700000000007, 0, -1.5740700000000025, 1.5740700000000007, 15.3,
                            -0.5740700000000025))
            .reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape blockShape = Block.createCuboidShape(0, 0, 0, 16, 16, 16);


    public ScannerFrame(@NotNull FabricBlockSettings properties) {
        super(properties);

        this.setDefaultState(this.getDefaultState().with(ConstantUtil.SCANNER_PROPERTY, false)
                .with(FACING, Direction.NORTH));
    }


    @Nullable
    @Override
    public BlockState getPlacementState(final ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    }


    @Override
    public VoxelShape getOutlineShape(final BlockState state, final BlockView world, final BlockPos pos, final ShapeContext context) {
        if (state.get(ConstantUtil.SCANNER_PROPERTY)) {
            return switch (state.get(FACING)) {
                case NORTH -> shapeN;
                case SOUTH -> shapeS;
                case EAST -> shapeE;
                case WEST -> shapeW;
                default -> shapeN;
            };
        } else {
            return blockShape;
        }
    }


    @Override
    protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(ConstantUtil.SCANNER_PROPERTY));
    }
}
