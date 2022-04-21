package com.Ultra_Nerd.CodeLyokoLegacy.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.shape.VoxelShape;

public final class ArchitectureWorkstation extends HorizontalFacingBlock {


    private static final BooleanProperty on = BooleanProperty.of("active");

    private static final VoxelShape shapeN = Block.createCuboidShape(4, 0, 0, 12, 16, 16);
    private static final VoxelShape shapeE = Block.createCuboidShape(0, 0, 4, 16, 16, 12);
    private static final VoxelShape shapeS = Block.createCuboidShape(4, 0, 0, 12, 16, 16);
    private static final VoxelShape shapeW = Block.createCuboidShape(0, 0, 4, 16, 16, 12);

    public ArchitectureWorkstation(final Settings settings) {
        super(settings);
    }

/*
    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING).add(on);
    }



    @Override
    public @NotNull BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        // TODO Auto-generated method stub
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(on, false);
    }

    //mod compatiability
    @Nonnull
    @Override
    public BlockState rotate(@NotNull BlockState state, @NotNull Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Nonnull
    @Override
    public BlockState mirror(@NotNull BlockState state, @NotNull Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }



    @Nonnull
    @Override
    public VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter worldIn, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case NORTH -> shapeN;
            case SOUTH -> shapeS;
            case EAST -> shapeE;
            case WEST -> shapeW;
            default -> shapeN;

        };
    }

 */
}
