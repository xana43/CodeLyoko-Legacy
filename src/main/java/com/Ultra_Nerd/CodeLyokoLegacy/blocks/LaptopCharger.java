package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.tileentity.LaptopChargerBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LaptopCharger extends HorizontalFacingBlock implements BlockEntityProvider {
    public LaptopCharger(final Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return ModTileEntities.LAPTOP_CHARGER_BLOCK_ENTITY_BLOCK_ENTITY.instantiate(pos, state);
    }

    @Override
    public ActionResult onUse(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final Hand hand, final BlockHitResult hit) {
        final BlockEntity be = world.getBlockEntity(pos);

        if (be instanceof LaptopChargerBlockEntity chargerBlockEntity && !world.isClient()) {
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

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(final World world, final BlockState state, final BlockEntityType<T> type) {
        return (world1, pos, state1, blockEntity) -> {
            if (blockEntity instanceof LaptopChargerBlockEntity) {
                ((LaptopChargerBlockEntity) blockEntity).tick();
            }
        };
    }

    @Nullable
    @Override
    public BlockState getPlacementState(final ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    }

    @Override
    public void onBreak(final World world, final BlockPos pos, final BlockState state, final PlayerEntity player) {
        super.onBreak(world, pos, state, player);
        if (world.getBlockEntity(pos) instanceof LaptopChargerBlockEntity chargerBlockEntity) {
            chargerBlockEntity.getItems().forEach(itemStack -> Block.dropStack(world, pos, itemStack));
        }
    }
}
