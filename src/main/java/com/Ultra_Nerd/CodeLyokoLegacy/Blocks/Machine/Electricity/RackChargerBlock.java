package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Machine.Electricity;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Eletricity.RackChargerEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlockEntities;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class RackChargerBlock extends HorizontalFacingBlock implements BlockEntityProvider {

    public RackChargerBlock(final Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return null;
    }

    private static final VoxelShape VOXEL_SHAPE = makeShape();
    private static VoxelShape makeShape(){
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.875, 0, 0, 1, 1, 1));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.5625, 0.875, 0, 0.875, 1, 0.125));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.5625, 0.875, 0.875, 0.875, 1, 1));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.5625, 0.875, 0.4375, 0.875, 1, 0.5625));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.1875, 0.8125, 0.4375, 0.5625, 0.9375, 0.5625));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.1875, 0.8125, 0, 0.5625, 0.9375, 0.125));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.1875, 0.8125, 0.875, 0.5625, 0.9375, 1));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.5625, 0, 0, 0.875, 0.4375, 0.5625));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0625, 0.875, 0.4375, 0.1875, 1, 0.5625));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0625, 0.875, 0, 0.1875, 1, 0.125));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0625, 0.875, 0.875, 0.1875, 1, 1));
        return shape;
    }

    @Override
    public boolean isCullingShapeFullCube(final BlockState state, final BlockView world, final BlockPos pos) {
        return false;
    }

    @Override
    public VoxelShape getCullingShape(final BlockState state, final BlockView world, final BlockPos pos) {
        return VOXEL_SHAPE;
    }

    @Override
    protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(FACING));
    }

    @Nullable
    @Override
    public BlockState getPlacementState(final ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING,ctx.getHorizontalPlayerFacing().rotateYCounterclockwise());
    }

    @Override
    public <T extends BlockEntity> @NotNull BlockEntityTicker<T> getTicker(final World world, final BlockState state, final BlockEntityType<T> type) {
        return (world1, pos, state1, blockEntity) -> {
            if(blockEntity instanceof final RackChargerEntity entity)
            {
                entity.tick();
            }
        };
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if(!world.isClient()) {
            final BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof RackChargerEntity) {
                player.openHandledScreen((NamedScreenHandlerFactory) blockEntity);

            }
        }
        return ActionResult.SUCCESS;
    }


    @Override
    public void onStateReplaced(final BlockState state, final World world, final BlockPos pos, final BlockState newState, final boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            final BlockEntity BE = world.getBlockEntity(pos);
            if (BE instanceof final RackChargerEntity rackChargerBlockEntity) {
                ItemScatterer.spawn(world, pos, rackChargerBlockEntity);
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }
    @Nullable
    @Override
    public NamedScreenHandlerFactory createScreenHandlerFactory(final BlockState state, final World world, final BlockPos pos) {
        final BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity instanceof NamedScreenHandlerFactory ? (NamedScreenHandlerFactory)blockEntity : null;
    }
    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return ModBlockEntities.RACK_CHARGER_BLOCK_ENTITY.instantiate(pos, state);
    }
}
