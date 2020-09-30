package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
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
import javax.annotation.Nullable;
import java.util.stream.Stream;

public class ScannerFrame extends Block {
    public static final DirectionProperty directionPropertyFrame = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty ScannerFrameInvis = BooleanProperty.create("scanner_frame_invis");
    private static final VoxelShape shapeS = Stream.of(
            Block.makeCuboidShape(-4, 0, 5, -3, 15.3, 11),
            Block.makeCuboidShape(19, 0, 5, 20, 15.3, 11),
            Block.makeCuboidShape(5, 0, 19, 11, 15.3, 20),
            Block.makeCuboidShape(-3, 0, 2, -2, 15.3, 5),
            Block.makeCuboidShape(18, 0, 11, 19, 15.3, 14),
            Block.makeCuboidShape(-3, 0, 11, -2, 15.3, 14),
            Block.makeCuboidShape(18, 0, 2, 19, 15.3, 5),
            Block.makeCuboidShape(13, 1, -3, 14, 16.3, -2),
            Block.makeCuboidShape(2, 0, 18, 5, 15.3, 19),
            Block.makeCuboidShape(2, 1, -3, 3, 16.3, -2),
            Block.makeCuboidShape(11, 0, 18, 14, 15.3, 19),
            Block.makeCuboidShape(-2, 0, 1, -1, 15.3, 2),
            Block.makeCuboidShape(17, 0, 14, 18, 15.3, 15),
            Block.makeCuboidShape(1, 0, 17, 2, 15.3, 18),
            Block.makeCuboidShape(14, 0, -2, 15, 15.3, -1),
            Block.makeCuboidShape(-1, 0, 0, 0, 15.3, 1),
            Block.makeCuboidShape(16, 0, 15, 17, 15.3, 16),
            Block.makeCuboidShape(0, 0, 16, 1, 15.3, 17),
            Block.makeCuboidShape(15, 0, -1, 16, 15.3, 0),
            Block.makeCuboidShape(0, 0, -1, 1, 15.3, 0),
            Block.makeCuboidShape(15, 0, 16, 16, 15.3, 17),
            Block.makeCuboidShape(-1, 0, 15, 0, 15.3, 16),
            Block.makeCuboidShape(16, 0, 0, 17, 15.3, 1),
            Block.makeCuboidShape(1, 0, -2, 2, 15.3, -1),
            Block.makeCuboidShape(14, 0, 17, 15, 15.3, 18),
            Block.makeCuboidShape(-2, 0, 14, -1, 15.3, 15),
            Block.makeCuboidShape(17, 0, 1, 18, 15.3, 2)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();
    private static final VoxelShape shapeN = Stream.of(
            Block.makeCuboidShape(19, 0, 5.8518599999999985, 20, 15.3, 11.851859999999999),
            Block.makeCuboidShape(-4.000000000000002, 0, 5.8518599999999985, -3.0000000000000018, 15.3, 11.851859999999999),
            Block.makeCuboidShape(5, 0, -3.1481400000000015, 11, 15.3, -2.1481400000000015),
            Block.makeCuboidShape(18, 0, 11.851859999999999, 19, 15.3, 14.851859999999999),
            Block.makeCuboidShape(-3.0000000000000018, 0, 2.8518599999999985, -2.0000000000000018, 15.3, 5.8518599999999985),
            Block.makeCuboidShape(18, 0, 2.8518599999999985, 19, 15.3, 5.8518599999999985),
            Block.makeCuboidShape(-3.0000000000000018, 0, 11.851859999999999, -2.0000000000000018, 15.3, 14.851859999999999),
            Block.makeCuboidShape(2, 1, 18.851860000000002, 3, 16.3, 19.851860000000002),
            Block.makeCuboidShape(11, 0, -2.1481400000000015, 14, 15.3, -1.1481400000000015),
            Block.makeCuboidShape(13, 1, 18.851860000000002, 14, 16.3, 19.851860000000002),
            Block.makeCuboidShape(2, 0, -2.1481400000000015, 5, 15.3, -1.1481400000000015),
            Block.makeCuboidShape(17, 0, 14.851859999999999, 18, 15.3, 15.851859999999999),
            Block.makeCuboidShape(-2.0000000000000018, 0, 1.8518599999999985, -1.0000000000000018, 15.3, 2.8518599999999985),
            Block.makeCuboidShape(14, 0, -1.1481400000000015, 15, 15.3, -0.1481400000000015),
            Block.makeCuboidShape(1, 0, 17.851860000000002, 2, 15.3, 18.851860000000002),
            Block.makeCuboidShape(16, 0, 15.851859999999999, 17, 15.3, 16.851860000000002),
            Block.makeCuboidShape(-1.0000000000000018, 0, 0.8518599999999985, -1.7763568394002505e-15, 15.3, 1.8518599999999985),
            Block.makeCuboidShape(15, 0, -0.1481400000000015, 16, 15.3, 0.8518599999999985),
            Block.makeCuboidShape(-1.7763568394002505e-15, 0, 16.851860000000002, 1, 15.3, 17.851860000000002),
            Block.makeCuboidShape(15, 0, 16.851860000000002, 16, 15.3, 17.851860000000002),
            Block.makeCuboidShape(-1.7763568394002505e-15, 0, -0.1481400000000015, 1, 15.3, 0.8518599999999985),
            Block.makeCuboidShape(16, 0, 0.8518599999999985, 17, 15.3, 1.8518599999999985),
            Block.makeCuboidShape(-1.0000000000000018, 0, 15.851859999999999, -1.7763568394002505e-15, 15.3, 16.851860000000002),
            Block.makeCuboidShape(14, 0, 17.851860000000002, 15, 15.3, 18.851860000000002),
            Block.makeCuboidShape(1, 0, -1.1481400000000015, 2, 15.3, -0.1481400000000015),
            Block.makeCuboidShape(17, 0, 1.8518599999999985, 18, 15.3, 2.8518599999999985),
            Block.makeCuboidShape(-2.0000000000000018, 0, 14.851859999999999, -1.0000000000000018, 15.3, 15.851859999999999)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();
    private static final VoxelShape shapeW = Stream.of(
            Block.makeCuboidShape(5.425929999999999, 0, -3.5740700000000007, 11.42593, 15.3, -2.5740700000000007),
            Block.makeCuboidShape(5.425929999999999, 0, 19.42593, 11.42593, 15.3, 20.42593),
            Block.makeCuboidShape(-3.5740700000000007, 0, 5.425929999999999, -2.5740700000000007, 15.3, 11.42593),
            Block.makeCuboidShape(11.42593, 0, -2.5740700000000007, 14.42593, 15.3, -1.5740700000000007),
            Block.makeCuboidShape(2.4259299999999993, 0, 18.42593, 5.425929999999999, 15.3, 19.42593),
            Block.makeCuboidShape(2.4259299999999993, 0, -2.5740700000000007, 5.425929999999999, 15.3, -1.5740700000000007),
            Block.makeCuboidShape(11.42593, 0, 18.42593, 14.42593, 15.3, 19.42593),
            Block.makeCuboidShape(18.42593, 1, 13.42593, 19.42593, 16.3, 14.42593),
            Block.makeCuboidShape(-2.5740700000000007, 0, 2.4259299999999993, -1.5740700000000007, 15.3, 5.425929999999999),
            Block.makeCuboidShape(18.42593, 1, 2.4259299999999993, 19.42593, 16.3, 3.4259299999999993),
            Block.makeCuboidShape(-2.5740700000000007, 0, 11.42593, -1.5740700000000007, 15.3, 14.42593),
            Block.makeCuboidShape(14.42593, 0, -1.5740700000000007, 15.42593, 15.3, -0.5740700000000007),
            Block.makeCuboidShape(1.4259299999999993, 0, 17.42593, 2.4259299999999993, 15.3, 18.42593),
            Block.makeCuboidShape(-1.5740700000000007, 0, 1.4259299999999993, -0.5740700000000007, 15.3, 2.4259299999999993),
            Block.makeCuboidShape(17.42593, 0, 14.42593, 18.42593, 15.3, 15.42593),
            Block.makeCuboidShape(15.42593, 0, -0.5740700000000007, 16.42593, 15.3, 0.42592999999999925),
            Block.makeCuboidShape(0.42592999999999925, 0, 16.42593, 1.4259299999999993, 15.3, 17.42593),
            Block.makeCuboidShape(-0.5740700000000007, 0, 0.42592999999999925, 0.42592999999999925, 15.3, 1.4259299999999993),
            Block.makeCuboidShape(16.42593, 0, 15.42593, 17.42593, 15.3, 16.42593),
            Block.makeCuboidShape(16.42593, 0, 0.42592999999999925, 17.42593, 15.3, 1.4259299999999993),
            Block.makeCuboidShape(-0.5740700000000007, 0, 15.42593, 0.42592999999999925, 15.3, 16.42593),
            Block.makeCuboidShape(0.42592999999999925, 0, -0.5740700000000007, 1.4259299999999993, 15.3, 0.42592999999999925),
            Block.makeCuboidShape(15.42593, 0, 16.42593, 16.42593, 15.3, 17.42593),
            Block.makeCuboidShape(17.42593, 0, 1.4259299999999993, 18.42593, 15.3, 2.4259299999999993),
            Block.makeCuboidShape(-1.5740700000000007, 0, 14.42593, -0.5740700000000007, 15.3, 15.42593),
            Block.makeCuboidShape(1.4259299999999993, 0, -1.5740700000000007, 2.4259299999999993, 15.3, -0.5740700000000007),
            Block.makeCuboidShape(14.42593, 0, 17.42593, 15.42593, 15.3, 18.42593)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();
    private static final VoxelShape shapeE = Stream.of(
            Block.makeCuboidShape(4.574070000000001, 0, 19.42593, 10.57407, 15.3, 20.42593),
            Block.makeCuboidShape(4.574070000000001, 0, -3.5740700000000025, 10.57407, 15.3, -2.5740700000000025),
            Block.makeCuboidShape(18.57407, 0, 5.425929999999999, 19.57407, 15.3, 11.42593),
            Block.makeCuboidShape(1.5740700000000007, 0, 18.42593, 4.574070000000001, 15.3, 19.42593),
            Block.makeCuboidShape(10.57407, 0, -2.5740700000000025, 13.57407, 15.3, -1.5740700000000025),
            Block.makeCuboidShape(10.57407, 0, 18.42593, 13.57407, 15.3, 19.42593),
            Block.makeCuboidShape(1.5740700000000007, 0, -2.5740700000000025, 4.574070000000001, 15.3, -1.5740700000000025),
            Block.makeCuboidShape(-3.425930000000003, 1, 2.4259299999999993, -2.425930000000003, 16.3, 3.4259299999999993),
            Block.makeCuboidShape(17.57407, 0, 11.42593, 18.57407, 15.3, 14.42593),
            Block.makeCuboidShape(-3.425930000000003, 1, 13.42593, -2.425930000000003, 16.3, 14.42593),
            Block.makeCuboidShape(17.57407, 0, 2.4259299999999993, 18.57407, 15.3, 5.425929999999999),
            Block.makeCuboidShape(0.5740700000000007, 0, 17.42593, 1.5740700000000007, 15.3, 18.42593),
            Block.makeCuboidShape(13.57407, 0, -1.5740700000000025, 14.57407, 15.3, -0.5740700000000025),
            Block.makeCuboidShape(16.57407, 0, 14.42593, 17.57407, 15.3, 15.42593),
            Block.makeCuboidShape(-2.425930000000003, 0, 1.4259299999999993, -1.4259300000000028, 15.3, 2.4259299999999993),
            Block.makeCuboidShape(-0.4259300000000028, 0, 16.42593, 0.5740700000000007, 15.3, 17.42593),
            Block.makeCuboidShape(14.57407, 0, -0.5740700000000025, 15.57407, 15.3, 0.4259299999999975),
            Block.makeCuboidShape(15.57407, 0, 15.42593, 16.57407, 15.3, 16.42593),
            Block.makeCuboidShape(-1.4259300000000028, 0, 0.4259299999999975, -0.4259300000000028, 15.3, 1.4259299999999993),
            Block.makeCuboidShape(-1.4259300000000028, 0, 15.42593, -0.4259300000000028, 15.3, 16.42593),
            Block.makeCuboidShape(15.57407, 0, 0.4259299999999975, 16.57407, 15.3, 1.4259299999999993),
            Block.makeCuboidShape(14.57407, 0, 16.42593, 15.57407, 15.3, 17.42593),
            Block.makeCuboidShape(-0.4259300000000028, 0, -0.5740700000000025, 0.5740700000000007, 15.3, 0.4259299999999975),
            Block.makeCuboidShape(-2.425930000000003, 0, 14.42593, -1.4259300000000028, 15.3, 15.42593),
            Block.makeCuboidShape(16.57407, 0, 1.4259299999999993, 17.57407, 15.3, 2.4259299999999993),
            Block.makeCuboidShape(13.57407, 0, 17.42593, 14.57407, 15.3, 18.42593),
            Block.makeCuboidShape(0.5740700000000007, 0, -1.5740700000000025, 1.5740700000000007, 15.3, -0.5740700000000025)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();
    private static final VoxelShape blockShape = Block.makeCuboidShape(0, 0, 0, 16, 16, 16);

    public ScannerFrame(Properties properties) {
        super(properties);

        this.setDefaultState(this.getStateContainer().getBaseState().with(ScannerFrameInvis, false)
                .with(directionPropertyFrame, Direction.NORTH));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(directionPropertyFrame, context.getPlacementHorizontalFacing());
    }

    //mod compatiability
    @Nonnull
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(directionPropertyFrame, rot.rotate(state.get(directionPropertyFrame)));
    }

    @Nonnull
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(directionPropertyFrame)));
    }

    @Nonnull
    @Override
    public VoxelShape getShape(BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos, @Nonnull ISelectionContext context) {
        if (state.get(ScannerFrameInvis)) {
            switch (state.get(directionPropertyFrame)) {
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

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(ScannerFrameInvis).add(directionPropertyFrame);
    }

    @Override
    public boolean isSideInvisible(@Nonnull BlockState state, @Nonnull BlockState adjacentBlockState, @Nonnull Direction side) {
        return false;
    }

    @Nonnull
    @Override
    public BlockRenderType getRenderType(@Nonnull BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public boolean isTransparent(@Nonnull BlockState state) {
        return false;
    }

    @Override
    public boolean isViewBlocking(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos) {
        return false;
    }
}
