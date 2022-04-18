package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.MultiBlock.MasterEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.MultiBlock.MultiBlockPartCallback;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
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

public final class ScannerFrame extends Block implements MultiBlockPartCallback {
    public static final DirectionProperty directionPropertyFrame = BlockStateProperties.HORIZONTAL_FACING;
    private static final VoxelShape shapeS = Stream.of(
            Block.box(-4, 0, 5, -3, 15.3, 11),
            Block.box(19, 0, 5, 20, 15.3, 11),
            Block.box(5, 0, 19, 11, 15.3, 20),
            Block.box(-3, 0, 2, -2, 15.3, 5),
            Block.box(18, 0, 11, 19, 15.3, 14),
            Block.box(-3, 0, 11, -2, 15.3, 14),
            Block.box(18, 0, 2, 19, 15.3, 5),
            Block.box(13, 1, -3, 14, 16.3, -2),
            Block.box(2, 0, 18, 5, 15.3, 19),
            Block.box(2, 1, -3, 3, 16.3, -2),
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
            Block.box(17, 0, 1, 18, 15.3, 2)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape shapeN = Stream.of(
            Block.box(19, 0, 5.8518599999999985, 20, 15.3, 11.851859999999999),
            Block.box(-4.000000000000002, 0, 5.8518599999999985, -3.0000000000000018, 15.3, 11.851859999999999),
            Block.box(5, 0, -3.1481400000000015, 11, 15.3, -2.1481400000000015),
            Block.box(18, 0, 11.851859999999999, 19, 15.3, 14.851859999999999),
            Block.box(-3.0000000000000018, 0, 2.8518599999999985, -2.0000000000000018, 15.3, 5.8518599999999985),
            Block.box(18, 0, 2.8518599999999985, 19, 15.3, 5.8518599999999985),
            Block.box(-3.0000000000000018, 0, 11.851859999999999, -2.0000000000000018, 15.3, 14.851859999999999),
            Block.box(2, 1, 18.851860000000002, 3, 16.3, 19.851860000000002),
            Block.box(11, 0, -2.1481400000000015, 14, 15.3, -1.1481400000000015),
            Block.box(13, 1, 18.851860000000002, 14, 16.3, 19.851860000000002),
            Block.box(2, 0, -2.1481400000000015, 5, 15.3, -1.1481400000000015),
            Block.box(17, 0, 14.851859999999999, 18, 15.3, 15.851859999999999),
            Block.box(-2.0000000000000018, 0, 1.8518599999999985, -1.0000000000000018, 15.3, 2.8518599999999985),
            Block.box(14, 0, -1.1481400000000015, 15, 15.3, -0.1481400000000015),
            Block.box(1, 0, 17.851860000000002, 2, 15.3, 18.851860000000002),
            Block.box(16, 0, 15.851859999999999, 17, 15.3, 16.851860000000002),
            Block.box(-1.0000000000000018, 0, 0.8518599999999985, -1.7763568394002505e-15, 15.3, 1.8518599999999985),
            Block.box(15, 0, -0.1481400000000015, 16, 15.3, 0.8518599999999985),
            Block.box(-1.7763568394002505e-15, 0, 16.851860000000002, 1, 15.3, 17.851860000000002),
            Block.box(15, 0, 16.851860000000002, 16, 15.3, 17.851860000000002),
            Block.box(-1.7763568394002505e-15, 0, -0.1481400000000015, 1, 15.3, 0.8518599999999985),
            Block.box(16, 0, 0.8518599999999985, 17, 15.3, 1.8518599999999985),
            Block.box(-1.0000000000000018, 0, 15.851859999999999, -1.7763568394002505e-15, 15.3, 16.851860000000002),
            Block.box(14, 0, 17.851860000000002, 15, 15.3, 18.851860000000002),
            Block.box(1, 0, -1.1481400000000015, 2, 15.3, -0.1481400000000015),
            Block.box(17, 0, 1.8518599999999985, 18, 15.3, 2.8518599999999985),
            Block.box(-2.0000000000000018, 0, 14.851859999999999, -1.0000000000000018, 15.3, 15.851859999999999)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape shapeW = Stream.of(
            Block.box(5.425929999999999, 0, -3.5740700000000007, 11.42593, 15.3, -2.5740700000000007),
            Block.box(5.425929999999999, 0, 19.42593, 11.42593, 15.3, 20.42593),
            Block.box(-3.5740700000000007, 0, 5.425929999999999, -2.5740700000000007, 15.3, 11.42593),
            Block.box(11.42593, 0, -2.5740700000000007, 14.42593, 15.3, -1.5740700000000007),
            Block.box(2.4259299999999993, 0, 18.42593, 5.425929999999999, 15.3, 19.42593),
            Block.box(2.4259299999999993, 0, -2.5740700000000007, 5.425929999999999, 15.3, -1.5740700000000007),
            Block.box(11.42593, 0, 18.42593, 14.42593, 15.3, 19.42593),
            Block.box(18.42593, 1, 13.42593, 19.42593, 16.3, 14.42593),
            Block.box(-2.5740700000000007, 0, 2.4259299999999993, -1.5740700000000007, 15.3, 5.425929999999999),
            Block.box(18.42593, 1, 2.4259299999999993, 19.42593, 16.3, 3.4259299999999993),
            Block.box(-2.5740700000000007, 0, 11.42593, -1.5740700000000007, 15.3, 14.42593),
            Block.box(14.42593, 0, -1.5740700000000007, 15.42593, 15.3, -0.5740700000000007),
            Block.box(1.4259299999999993, 0, 17.42593, 2.4259299999999993, 15.3, 18.42593),
            Block.box(-1.5740700000000007, 0, 1.4259299999999993, -0.5740700000000007, 15.3, 2.4259299999999993),
            Block.box(17.42593, 0, 14.42593, 18.42593, 15.3, 15.42593),
            Block.box(15.42593, 0, -0.5740700000000007, 16.42593, 15.3, 0.42592999999999925),
            Block.box(0.42592999999999925, 0, 16.42593, 1.4259299999999993, 15.3, 17.42593),
            Block.box(-0.5740700000000007, 0, 0.42592999999999925, 0.42592999999999925, 15.3, 1.4259299999999993),
            Block.box(16.42593, 0, 15.42593, 17.42593, 15.3, 16.42593),
            Block.box(16.42593, 0, 0.42592999999999925, 17.42593, 15.3, 1.4259299999999993),
            Block.box(-0.5740700000000007, 0, 15.42593, 0.42592999999999925, 15.3, 16.42593),
            Block.box(0.42592999999999925, 0, -0.5740700000000007, 1.4259299999999993, 15.3, 0.42592999999999925),
            Block.box(15.42593, 0, 16.42593, 16.42593, 15.3, 17.42593),
            Block.box(17.42593, 0, 1.4259299999999993, 18.42593, 15.3, 2.4259299999999993),
            Block.box(-1.5740700000000007, 0, 14.42593, -0.5740700000000007, 15.3, 15.42593),
            Block.box(1.4259299999999993, 0, -1.5740700000000007, 2.4259299999999993, 15.3, -0.5740700000000007),
            Block.box(14.42593, 0, 17.42593, 15.42593, 15.3, 18.42593)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape shapeE = Stream.of(
            Block.box(4.574070000000001, 0, 19.42593, 10.57407, 15.3, 20.42593),
            Block.box(4.574070000000001, 0, -3.5740700000000025, 10.57407, 15.3, -2.5740700000000025),
            Block.box(18.57407, 0, 5.425929999999999, 19.57407, 15.3, 11.42593),
            Block.box(1.5740700000000007, 0, 18.42593, 4.574070000000001, 15.3, 19.42593),
            Block.box(10.57407, 0, -2.5740700000000025, 13.57407, 15.3, -1.5740700000000025),
            Block.box(10.57407, 0, 18.42593, 13.57407, 15.3, 19.42593),
            Block.box(1.5740700000000007, 0, -2.5740700000000025, 4.574070000000001, 15.3, -1.5740700000000025),
            Block.box(-3.425930000000003, 1, 2.4259299999999993, -2.425930000000003, 16.3, 3.4259299999999993),
            Block.box(17.57407, 0, 11.42593, 18.57407, 15.3, 14.42593),
            Block.box(-3.425930000000003, 1, 13.42593, -2.425930000000003, 16.3, 14.42593),
            Block.box(17.57407, 0, 2.4259299999999993, 18.57407, 15.3, 5.425929999999999),
            Block.box(0.5740700000000007, 0, 17.42593, 1.5740700000000007, 15.3, 18.42593),
            Block.box(13.57407, 0, -1.5740700000000025, 14.57407, 15.3, -0.5740700000000025),
            Block.box(16.57407, 0, 14.42593, 17.57407, 15.3, 15.42593),
            Block.box(-2.425930000000003, 0, 1.4259299999999993, -1.4259300000000028, 15.3, 2.4259299999999993),
            Block.box(-0.4259300000000028, 0, 16.42593, 0.5740700000000007, 15.3, 17.42593),
            Block.box(14.57407, 0, -0.5740700000000025, 15.57407, 15.3, 0.4259299999999975),
            Block.box(15.57407, 0, 15.42593, 16.57407, 15.3, 16.42593),
            Block.box(-1.4259300000000028, 0, 0.4259299999999975, -0.4259300000000028, 15.3, 1.4259299999999993),
            Block.box(-1.4259300000000028, 0, 15.42593, -0.4259300000000028, 15.3, 16.42593),
            Block.box(15.57407, 0, 0.4259299999999975, 16.57407, 15.3, 1.4259299999999993),
            Block.box(14.57407, 0, 16.42593, 15.57407, 15.3, 17.42593),
            Block.box(-0.4259300000000028, 0, -0.5740700000000025, 0.5740700000000007, 15.3, 0.4259299999999975),
            Block.box(-2.425930000000003, 0, 14.42593, -1.4259300000000028, 15.3, 15.42593),
            Block.box(16.57407, 0, 1.4259299999999993, 17.57407, 15.3, 2.4259299999999993),
            Block.box(13.57407, 0, 17.42593, 14.57407, 15.3, 18.42593),
            Block.box(0.5740700000000007, 0, -1.5740700000000025, 1.5740700000000007, 15.3, -0.5740700000000025)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape blockShape = Block.box(0, 0, 0, 16, 16, 16);


    public static final BooleanProperty ScannerFrameInvis = BooleanProperty.create("scanner_frame_invis");



    @Override
    public void destroy(final LevelAccessor pLevel, final BlockPos pPos, final BlockState pState) {
        super.destroy(pLevel, pPos, pState);
        final BlockPos masterpos = new BlockPos(pPos.getX(),pPos.getY() - 1, pPos.getZ());

        if(pLevel.getBlockEntity(masterpos) instanceof MasterEntity masterEntity)
        {

            masterEntity.invalidateEntity();
            //level.getCapability(CapabilityRegistration.BLOCK_ENTITY_CAP).ifPresent(cap -> cap.removePos(scannerTile));
        }
    }

    @Override
    public void onPlace(final BlockState pState, final Level pLevel, final @NotNull BlockPos pPos, final @NotNull BlockState pOldState, final boolean pIsMoving) {
        super.onPlace(pState, pLevel, pPos, pOldState, pIsMoving);
        this.checkAreaNegative(pLevel,1,2,1,pPos);
    }





    public ScannerFrame(@NotNull Properties properties) {
        super(properties);

        this.registerDefaultState(this.defaultBlockState().setValue(ScannerFrameInvis, false)
                .setValue(directionPropertyFrame, Direction.NORTH));
    }

    @Override
    public @NotNull BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        return this.defaultBlockState().setValue(directionPropertyFrame, context.getHorizontalDirection());
    }

    //mod compatiability
    @Nonnull
    @Override
    public BlockState rotate(@NotNull BlockState state, @NotNull Rotation rot) {
        return state.setValue(directionPropertyFrame, rot.rotate(state.getValue(directionPropertyFrame)));
    }

    @Nonnull
    @Override
    public BlockState mirror(@NotNull BlockState state, @NotNull Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(directionPropertyFrame)));
    }

    @Override
    public @NotNull VoxelShape getVisualShape(@NotNull BlockState state, BlockGetter p_60480_, BlockPos p_60481_, CollisionContext p_60482_) {

            switch (state.getValue(directionPropertyFrame)) {
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

    @Override
    public @NotNull VoxelShape getOcclusionShape(@NotNull BlockState state, BlockGetter pLevel, BlockPos pPos) {
        switch (state.getValue(directionPropertyFrame)) {
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
        if (state.getValue(ScannerFrameInvis)) {
            switch (state.getValue(directionPropertyFrame)) {
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
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(ScannerFrameInvis).add(directionPropertyFrame);
    }



    @Override
    public @NotNull RenderShape getRenderShape(BlockState p_60550_) {
        return RenderShape.MODEL;
    }


}
