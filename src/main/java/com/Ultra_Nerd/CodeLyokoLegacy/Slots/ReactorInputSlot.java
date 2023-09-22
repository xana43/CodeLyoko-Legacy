package com.Ultra_Nerd.CodeLyokoLegacy.Slots;

import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.ReactorScreenHandler;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public final class ReactorInputSlot extends Slot {
    private final ReactorScreenHandler handler;
    public ReactorInputSlot(final ReactorScreenHandler handler,final Inventory inventory, final int index, final int x,
            final int y) {
        super(inventory, index, x, y);
        this.handler = handler;
    }
    public boolean canInsert(final ItemStack stack)
    {
        return this.handler.isFuel(stack);
    }


}
