package com.Ultra_Nerd.CodeLyokoRemake15.blocks;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.EnumMap;
import java.util.Map;

public class ArchitectureWorkstation extends HorizontalDirectionalBlock {


    private static final BooleanProperty on = BooleanProperty.create("active");

    private static final VoxelShape shapeN = Block.box(4, 0, 0, 12, 16, 16);
    private static final VoxelShape shapeE = Block.box(0, 0, 4, 16, 16, 12);
    private static final VoxelShape shapeS = Block.box(4, 0, 0, 12, 16, 16);
    private static final VoxelShape shapeW = Block.box(0, 0, 4, 16, 16, 12);

    public ArchitectureWorkstation(BlockBehaviour.Properties properties) {
        super(properties);

        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH).setValue(on, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING).add(on);
    }



    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        // TODO Auto-generated method stub
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(on, false);
    }

    //mod compatiability
    @Nonnull
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Nonnull
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }



    @Nonnull
    @Override
    public VoxelShape getShape(BlockState state, @NotNull BlockGetter worldIn, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case NORTH -> shapeN;
            case SOUTH -> shapeS;
            case EAST -> shapeE;
            case WEST -> shapeW;
            default -> shapeN;

        };
    }
}
