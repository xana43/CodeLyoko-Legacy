package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nonnull;
import java.util.stream.Stream;

public class ScannerFrame extends Block {
    public static final DirectionProperty directionPropertyFrame = HorizontalBlock.HORIZONTAL_FACING;
    private static final VoxelShape shapeN = Stream.of(
            Block.makeCuboidShape(-4, 0, 5, -3, 15.3, 11),
            Block.makeCuboidShape(19, 0, 5, 20, 15.3, 11),
            Block.makeCuboidShape(5, 0, 19, 11, 15.3, 20),
            Block.makeCuboidShape(-3, 0, 2, -2, 15.3, 5),
            Block.makeCuboidShape(18, 0, 11, 19, 15.3, 14),
            Block.makeCuboidShape(-3, 0, 11, -2, 15.3, 14),
            Block.makeCuboidShape(18, 0, 2, 19, 15.3, 5),
            Block.makeCuboidShape(12, 1, -3, 14, 16.3, -2),
            Block.makeCuboidShape(2, 0, 18, 5, 15.3, 19),
            Block.makeCuboidShape(2, 1, -3, 4, 16.3, -2),
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
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape shapeS = Stream.of(
            Block.makeCuboidShape(19, 0, 5.851851851851851, 20, 15.3, 11.851851851851851),
            Block.makeCuboidShape(-3.9999999999999982, 0, 5.851851851851851, -2.9999999999999982, 15.3, 11.851851851851851),
            Block.makeCuboidShape(5, 0, -3.148148148148149, 11, 15.3, -2.148148148148149),
            Block.makeCuboidShape(18, 0, 11.851851851851851, 19, 15.3, 14.851851851851851),
            Block.makeCuboidShape(-2.9999999999999982, 0, 2.851851851851851, -1.9999999999999982, 15.3, 5.851851851851851),
            Block.makeCuboidShape(18, 0, 2.851851851851851, 19, 15.3, 5.851851851851851),
            Block.makeCuboidShape(-2.9999999999999982, 0, 11.851851851851851, -1.9999999999999982, 15.3, 14.851851851851851),
            Block.makeCuboidShape(2, 1, 18.851851851851848, 4, 16.3, 19.851851851851848),
            Block.makeCuboidShape(11, 0, -2.148148148148149, 14, 15.3, -1.1481481481481488),
            Block.makeCuboidShape(12, 1, 18.851851851851848, 14, 16.3, 19.851851851851848),
            Block.makeCuboidShape(2, 0, -2.148148148148149, 5, 15.3, -1.1481481481481488),
            Block.makeCuboidShape(17, 0, 14.851851851851851, 18, 15.3, 15.851851851851851),
            Block.makeCuboidShape(-1.9999999999999982, 0, 1.8518518518518512, -0.9999999999999982, 15.3, 2.851851851851851),
            Block.makeCuboidShape(14, 0, -1.1481481481481488, 15, 15.3, -0.1481481481481488),
            Block.makeCuboidShape(1, 0, 17.851851851851848, 2, 15.3, 18.851851851851848),
            Block.makeCuboidShape(16, 0, 15.851851851851851, 17, 15.3, 16.851851851851848),
            Block.makeCuboidShape(-0.9999999999999982, 0, 0.8518518518518512, 1.7763568394002505e-15, 15.3, 1.8518518518518512),
            Block.makeCuboidShape(15, 0, -0.1481481481481488, 16, 15.3, 0.8518518518518512),
            Block.makeCuboidShape(1.7763568394002505e-15, 0, 16.851851851851848, 1, 15.3, 17.851851851851848),
            Block.makeCuboidShape(15, 0, 16.851851851851848, 16, 15.3, 17.851851851851848),
            Block.makeCuboidShape(1.7763568394002505e-15, 0, -0.1481481481481488, 1, 15.3, 0.8518518518518512),
            Block.makeCuboidShape(16, 0, 0.8518518518518512, 17, 15.3, 1.8518518518518512),
            Block.makeCuboidShape(-0.9999999999999982, 0, 15.851851851851851, 1.7763568394002505e-15, 15.3, 16.851851851851848),
            Block.makeCuboidShape(14, 0, 17.851851851851848, 15, 15.3, 18.851851851851848),
            Block.makeCuboidShape(1, 0, -1.1481481481481488, 2, 15.3, -0.1481481481481488),
            Block.makeCuboidShape(17, 0, 1.8518518518518512, 18, 15.3, 2.851851851851851),
            Block.makeCuboidShape(-1.9999999999999982, 0, 14.851851851851851, -0.9999999999999982, 15.3, 15.851851851851851)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape shapeE =Stream.of(
            Block.makeCuboidShape(5.425925925925926, 0, -3.5740740740740744, 11.425925925925926, 15.3, -2.5740740740740744),
            Block.makeCuboidShape(5.425925925925926, 0, 19.425925925925924, 11.425925925925926, 15.3, 20.425925925925924),
            Block.makeCuboidShape(-3.5740740740740744, 0, 5.425925925925926, -2.5740740740740744, 15.3, 11.425925925925926),
            Block.makeCuboidShape(11.425925925925926, 0, -2.5740740740740744, 14.425925925925926, 15.3, -1.5740740740740744),
            Block.makeCuboidShape(2.4259259259259256, 0, 18.425925925925924, 5.425925925925926, 15.3, 19.425925925925924),
            Block.makeCuboidShape(2.4259259259259256, 0, -2.5740740740740744, 5.425925925925926, 15.3, -1.5740740740740744),
            Block.makeCuboidShape(11.425925925925926, 0, 18.425925925925924, 14.425925925925926, 15.3, 19.425925925925924),
            Block.makeCuboidShape(18.425925925925924, 1, 12.425925925925926, 19.425925925925924, 16.3, 14.425925925925926),
            Block.makeCuboidShape(-2.5740740740740744, 0, 2.4259259259259256, -1.5740740740740744, 15.3, 5.425925925925926),
            Block.makeCuboidShape(18.425925925925924, 1, 2.4259259259259256, 19.425925925925924, 16.3, 4.425925925925926),
            Block.makeCuboidShape(-2.5740740740740744, 0, 11.425925925925926, -1.5740740740740744, 15.3, 14.425925925925926),
            Block.makeCuboidShape(14.425925925925926, 0, -1.5740740740740744, 15.425925925925926, 15.3, -0.5740740740740744),
            Block.makeCuboidShape(1.4259259259259256, 0, 17.425925925925924, 2.4259259259259256, 15.3, 18.425925925925924),
            Block.makeCuboidShape(-1.5740740740740744, 0, 1.4259259259259256, -0.5740740740740744, 15.3, 2.4259259259259256),
            Block.makeCuboidShape(17.425925925925924, 0, 14.425925925925926, 18.425925925925924, 15.3, 15.425925925925926),
            Block.makeCuboidShape(15.425925925925926, 0, -0.5740740740740744, 16.425925925925924, 15.3, 0.4259259259259256),
            Block.makeCuboidShape(0.4259259259259256, 0, 16.425925925925924, 1.4259259259259256, 15.3, 17.425925925925924),
            Block.makeCuboidShape(-0.5740740740740744, 0, 0.4259259259259256, 0.4259259259259256, 15.3, 1.4259259259259256),
            Block.makeCuboidShape(16.425925925925924, 0, 15.425925925925926, 17.425925925925924, 15.3, 16.425925925925924),
            Block.makeCuboidShape(16.425925925925924, 0, 0.4259259259259256, 17.425925925925924, 15.3, 1.4259259259259256),
            Block.makeCuboidShape(-0.5740740740740744, 0, 15.425925925925926, 0.4259259259259256, 15.3, 16.425925925925924),
            Block.makeCuboidShape(0.4259259259259256, 0, -0.5740740740740744, 1.4259259259259256, 15.3, 0.4259259259259256),
            Block.makeCuboidShape(15.425925925925926, 0, 16.425925925925924, 16.425925925925924, 15.3, 17.425925925925924),
            Block.makeCuboidShape(17.425925925925924, 0, 1.4259259259259256, 18.425925925925924, 15.3, 2.4259259259259256),
            Block.makeCuboidShape(-1.5740740740740744, 0, 14.425925925925926, -0.5740740740740744, 15.3, 15.425925925925926),
            Block.makeCuboidShape(1.4259259259259256, 0, -1.5740740740740744, 2.4259259259259256, 15.3, -0.5740740740740744),
            Block.makeCuboidShape(14.425925925925926, 0, 17.425925925925924, 15.425925925925926, 15.3, 18.425925925925924)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape shapeW =Stream.of(
            Block.makeCuboidShape(4.574074074074074, 0, 19.425925925925924, 10.574074074074074, 15.3, 20.425925925925924),
            Block.makeCuboidShape(4.574074074074074, 0, -3.5740740740740726, 10.574074074074074, 15.3, -2.5740740740740726),
            Block.makeCuboidShape(18.574074074074076, 0, 5.425925925925926, 19.574074074074076, 15.3, 11.425925925925926),
            Block.makeCuboidShape(1.5740740740740744, 0, 18.425925925925924, 4.574074074074074, 15.3, 19.425925925925924),
            Block.makeCuboidShape(10.574074074074074, 0, -2.5740740740740726, 13.574074074074074, 15.3, -1.5740740740740726),
            Block.makeCuboidShape(10.574074074074074, 0, 18.425925925925924, 13.574074074074074, 15.3, 19.425925925925924),
            Block.makeCuboidShape(1.5740740740740744, 0, -2.5740740740740726, 4.574074074074074, 15.3, -1.5740740740740726),
            Block.makeCuboidShape(-3.425925925925922, 1, 2.4259259259259256, -2.425925925925922, 16.3, 4.425925925925926),
            Block.makeCuboidShape(17.574074074074076, 0, 11.425925925925926, 18.574074074074076, 15.3, 14.425925925925926),
            Block.makeCuboidShape(-3.425925925925922, 1, 12.425925925925926, -2.425925925925922, 16.3, 14.425925925925926),
            Block.makeCuboidShape(17.574074074074076, 0, 2.4259259259259256, 18.574074074074076, 15.3, 5.425925925925926),
            Block.makeCuboidShape(0.5740740740740744, 0, 17.425925925925924, 1.5740740740740744, 15.3, 18.425925925925924),
            Block.makeCuboidShape(13.574074074074074, 0, -1.5740740740740726, 14.574074074074074, 15.3, -0.5740740740740726),
            Block.makeCuboidShape(16.574074074074076, 0, 14.425925925925926, 17.574074074074076, 15.3, 15.425925925925926),
            Block.makeCuboidShape(-2.425925925925922, 0, 1.4259259259259256, -1.425925925925922, 15.3, 2.4259259259259256),
            Block.makeCuboidShape(-0.42592592592592204, 0, 16.425925925925924, 0.5740740740740744, 15.3, 17.425925925925924),
            Block.makeCuboidShape(14.574074074074074, 0, -0.5740740740740726, 15.574074074074074, 15.3, 0.4259259259259274),
            Block.makeCuboidShape(15.574074074074074, 0, 15.425925925925926, 16.574074074074076, 15.3, 16.425925925925924),
            Block.makeCuboidShape(-1.425925925925922, 0, 0.4259259259259274, -0.42592592592592204, 15.3, 1.4259259259259256),
            Block.makeCuboidShape(-1.425925925925922, 0, 15.425925925925926, -0.42592592592592204, 15.3, 16.425925925925924),
            Block.makeCuboidShape(15.574074074074074, 0, 0.4259259259259274, 16.574074074074076, 15.3, 1.4259259259259256),
            Block.makeCuboidShape(14.574074074074074, 0, 16.425925925925924, 15.574074074074074, 15.3, 17.425925925925924),
            Block.makeCuboidShape(-0.42592592592592204, 0, -0.5740740740740726, 0.5740740740740744, 15.3, 0.4259259259259274),
            Block.makeCuboidShape(-2.425925925925922, 0, 14.425925925925926, -1.425925925925922, 15.3, 15.425925925925926),
            Block.makeCuboidShape(16.574074074074076, 0, 1.4259259259259256, 17.574074074074076, 15.3, 2.4259259259259256),
            Block.makeCuboidShape(13.574074074074074, 0, 17.425925925925924, 14.574074074074074, 15.3, 18.425925925925924),
            Block.makeCuboidShape(0.5740740740740744, 0, -1.5740740740740726, 1.5740740740740744, 15.3, -0.5740740740740726)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();



    public static final BooleanProperty ScannerFrameInvis = BooleanProperty.create("scanner_frame_invis");
    public ScannerFrame(Properties properties) {
        super(properties);

    this.setDefaultState(this.getStateContainer().getBaseState().with(ScannerFrameInvis,false).with(directionPropertyFrame,Direction.NORTH));
    }


    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.get(directionPropertyFrame))
        {
            case NORTH:
                return shapeN;
            case SOUTH:
                return shapeS;
            case EAST:
                return  shapeE;
            case WEST:
                return shapeW;
            default:
                return  shapeN;
        }
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(ScannerFrameInvis).add(directionPropertyFrame);
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
