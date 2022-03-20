package com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.flouride.slots;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;

public class SlotOut extends Slot {

    private final Player player;
    private int rc;

    public SlotOut(Player player, Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
        this.player = player;
    }


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
}
