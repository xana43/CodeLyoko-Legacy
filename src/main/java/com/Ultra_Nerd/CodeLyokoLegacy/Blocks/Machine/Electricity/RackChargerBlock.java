package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Machine.Electricity;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Eletricity.RackChargerBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModBlockEntities;
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
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public final class RackChargerBlock extends HorizontalFacingBlock implements BlockEntityProvider {

    public RackChargerBlock(final Settings settings) {
        super(settings);
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

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(final World world, final BlockState state, final BlockEntityType<T> type) {
        return (world1, pos, state1, blockEntity) -> {
            if(blockEntity instanceof final RackChargerBlockEntity entity)
            {
                entity.tick();
            }
        };
    }

    @Override
    public ActionResult onUse(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final Hand hand, final BlockHitResult hit) {
        if(!world.isClient()) {
            final BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof RackChargerBlockEntity) {
                player.openHandledScreen((NamedScreenHandlerFactory) blockEntity);

            }
        }
        return ActionResult.SUCCESS;
    }
    @Override
    public void onStateReplaced(final BlockState state, final World world, final BlockPos pos, final BlockState newState, final boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            final BlockEntity BE = world.getBlockEntity(pos);
            if (BE instanceof final RackChargerBlockEntity rackChargerBlockEntity) {
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
