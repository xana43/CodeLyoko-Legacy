package com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.flouride.slots;

import net.minecraft.inventory.Inventory;
import net.minecraft.screen.slot.Slot;

public class SlotOut extends Slot {
    public SlotOut(final Inventory inventory, final int index, final int x, final int y) {
        super(inventory, index, x, y);
    }
/*
    private final Player player;
    private int rc;

    public SlotOut(Player player, @NotNull Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
        this.player = player;
    }

/*
    @Override
    public boolean isItemValid(@Nonnull ItemStack stack) {
        // TODO Auto-generated method stub
        return false;
    }

    @Nonnull
    @Override
    public ItemStack onTake(@Nonnull Player thePlayer, @Nonnull ItemStack stack) {
        // TODO Auto-generated method stub
        this.onCrafting(stack);
        super.onTake(thePlayer, stack);
        return stack;
    }

    @Nonnull
    @Override
    public ItemStack decrStackSize(int amount) {
        // TODO Auto-generated method stub
        if (this.getHasStack()) this.rc += Math.min(amount, this.getStack().getCount());
        return super.decrStackSize(amount);
    }

 */
}
