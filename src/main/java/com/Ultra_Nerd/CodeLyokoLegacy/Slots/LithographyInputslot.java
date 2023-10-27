package com.Ultra_Nerd.CodeLyokoLegacy.Slots;

import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.LithographyScreenHandler;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public final class LithographyInputslot extends Slot {
    public LithographyInputslot(final Inventory inventory, final int index, final int x, final int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(final ItemStack stack) {
        return LithographyScreenHandler.isValidMaterial(stack);
    }
}
