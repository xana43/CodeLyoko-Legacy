package com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

public abstract class SidedInventoryTickingBlockEntity extends InventoryTickingBlockEntity implements SidedInventory {
    public SidedInventoryTickingBlockEntity(final BlockEntityType<?> type, final BlockPos pos, final BlockState state, final int inventorySize) {
        super(type, pos, state, inventorySize);
    }

    @Override
    public int[] getAvailableSlots(final Direction side) {
        final int[] result = new int[getItems().size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }
        return result;
    }

    @Override
    public boolean canInsert(final int slot, final ItemStack stack, @Nullable final Direction dir) {
        return dir != Direction.UP;
    }

    @Override
    public boolean canExtract(final int slot, final ItemStack stack, final Direction dir) {
        return true;
    }
}
