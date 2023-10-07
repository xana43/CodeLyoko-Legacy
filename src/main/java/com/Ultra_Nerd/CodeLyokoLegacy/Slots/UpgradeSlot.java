package com.Ultra_Nerd.CodeLyokoLegacy.Slots;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public final class UpgradeSlot extends Slot {
    private final ItemConvertible[] allowedItem;
    public UpgradeSlot(final Inventory inventory, final int index, final int x, final int y,final ItemConvertible... allowedItem) {
        super(inventory, index, x, y);
        this.allowedItem = allowedItem;
    }

    @Override
    public boolean canInsert(final ItemStack stack) {
        for(final ItemConvertible itemConvertible : allowedItem)
        {
            if(stack.isOf(itemConvertible.asItem()))
            {
                return true;
            }
        }
        return false;
    }
}
