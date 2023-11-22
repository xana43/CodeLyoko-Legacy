package com.Ultra_Nerd.CodeLyokoLegacy.Blocks;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public final class ArchitectureWorkstation extends HorizontalFacingBlock {


    private static final BooleanProperty on = BooleanProperty.of("active");

    private static final VoxelShape shapeN = Block.createCuboidShape(4, 0, 0, 12, 16, 16);
    private static final VoxelShape shapeE = Block.createCuboidShape(0, 0, 4, 16, 16, 12);
    private static final VoxelShape shapeS = Block.createCuboidShape(4, 0, 0, 12, 16, 16);
    private static final VoxelShape shapeW = Block.createCuboidShape(0, 0, 4, 16, 16, 12);

    public ArchitectureWorkstation(final Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(on).add(FACING));
    }


    @Nullable
    @Override
    public BlockState getPlacementState(final ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite()).with(on, Boolean.FALSE);
    }


    @Override
    public VoxelShape getOutlineShape(final BlockState state, final BlockView world, final BlockPos pos, final ShapeContext context) {
        return switch (state.get(FACING)) {
            case SOUTH -> shapeS;
            case EAST -> shapeE;
            case WEST -> shapeW;
            default -> shapeN;

        };
    }


}
