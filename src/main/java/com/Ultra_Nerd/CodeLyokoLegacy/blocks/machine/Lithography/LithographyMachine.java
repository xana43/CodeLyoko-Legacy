package com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.Lithography;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities.LithographyBlockEntityInventory;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlockEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public final class LithographyMachine extends Block implements BlockEntityProvider {
    public LithographyMachine(final Settings settings) {
        super(settings);
    }
    @Override
    public BlockRenderType getRenderType(final BlockState state) {
        return BlockRenderType.MODEL;
    }


    @Override
    public ActionResult onUse(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final Hand hand, final BlockHitResult hit) {
        if(world.isClient)
        {
            return ActionResult.SUCCESS;
        } else {
            LithographyMachine.openScreen(world, pos, player);
            return ActionResult.CONSUME;
        }
    }

    private static void openScreen(final World world, final BlockPos pos, final PlayerEntity player) {
        final BlockEntity blockEntity = world.getBlockEntity(pos);
        if(blockEntity instanceof LithographyBlockEntityInventory)
        {
            player.openHandledScreen((NamedScreenHandlerFactory) blockEntity);

        }
    }

    @Nullable
    @Override
    public NamedScreenHandlerFactory createScreenHandlerFactory(final BlockState state, final World world, final BlockPos pos) {
        final BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity instanceof NamedScreenHandlerFactory ? (NamedScreenHandlerFactory)blockEntity : null;
    }
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(final World world, final BlockState state, final BlockEntityType<T> type) {
        return (world1, pos, state1, blockEntity) -> {
            if (blockEntity instanceof final LithographyBlockEntityInventory lithographyBlockEntityInventory) {
                lithographyBlockEntityInventory.tick();
            }
        };
    }

    @Override
    public void onStateReplaced(final BlockState state, final World world, final BlockPos pos, final BlockState newState, final boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            final BlockEntity BE = world.getBlockEntity(pos);
            if (BE instanceof final LithographyBlockEntityInventory lithographyTile) {
                ItemScatterer.spawn(world, pos, lithographyTile);
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }
    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
    return ModBlockEntities.LITHOGRAPHY_BLOCK_ENTITY_TYPE.instantiate(pos, state);
    }
}
