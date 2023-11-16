package com.Ultra_Nerd.CodeLyokoLegacy.Slots;

import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.LithographyScreenHandlerT2;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public final class LithographyInputslotT2 extends Slot {
    public LithographyInputslotT2(final Inventory inventory, final int index, final int x, final int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(final ItemStack stack) {
        return LithographyScreenHandlerT2.isValidMaterial(stack);
    }
}
