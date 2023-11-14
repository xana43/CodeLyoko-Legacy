package com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.Electricity;

import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Eletricity.LaptopChargerBlockEntityInventory;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public final class LaptopCharger extends HorizontalFacingBlock implements BlockEntityProvider {
    public LaptopCharger(final Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return ModBlockEntities.LAPTOP_CHARGER_BLOCK_ENTITY_BLOCK_ENTITY.instantiate(pos, state);
    }


    @Override
    protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(FACING));
    }

    @Override
    public VoxelShape getOutlineShape(final BlockState state, final BlockView world, final BlockPos pos, final ShapeContext context) {
        return Block.createCuboidShape(0, 0, 0, 16, 2, 16);
    }

    @Override
    public ActionResult onUse(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final Hand hand, final BlockHitResult hit) {
        final BlockEntity be = world.getBlockEntity(pos);
        world.updateListeners(pos, state, state, Block.NOTIFY_LISTENERS);

        if (be instanceof final LaptopChargerBlockEntityInventory chargerBlockEntity) {
            chargerBlockEntity.update();
            final ItemStack laptop = player.getStackInHand(hand);
            if (laptop.isOf(ModItems.JEREMY_LAPTOP)) {
                chargerBlockEntity.setItem(laptop);
            } else if (laptop.isOf(ItemStack.EMPTY.getItem())) {
                player.setStackInHand(hand, chargerBlockEntity.getItems().get(0).copy());
                chargerBlockEntity.getItems().get(0).decrement(1);

            }

        }
        return ActionResult.CONSUME;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(final World world, final BlockState state, final BlockEntityType<T> type) {
        return (world1, pos, state1, blockEntity) -> {
            if (blockEntity instanceof final LaptopChargerBlockEntityInventory chargerBlock) {
                chargerBlock.tick();
            }
        };
    }

    @Nullable
    @Override
    public BlockState getPlacementState(final ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing());
    }

    @Override
    public void onBreak(final World world, final BlockPos pos, final BlockState state, final PlayerEntity player) {
        super.onBreak(world, pos, state, player);
        if (world.getBlockEntity(pos) instanceof final LaptopChargerBlockEntityInventory chargerBlockEntity) {
            chargerBlockEntity.getItems().forEach(itemStack -> Block.dropStack(world, pos, itemStack));
        }
    }
}
