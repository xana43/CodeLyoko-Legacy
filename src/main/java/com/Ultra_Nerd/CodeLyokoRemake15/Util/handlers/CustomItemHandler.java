package com.Ultra_Nerd.CodeLyokoRemake15.Util.handlers;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

public final class CustomItemHandler extends ItemStackHandler {
    public CustomItemHandler(int size, ItemStack @NotNull ... stacks) {
        super(size);
        for (int i = 0; i < stacks.length; i++) {
            this.stacks.set(i, stacks[i]);
        }
    }

    public void clear() {
        for (int i = 0; i < this.getSlots(); i++) {
            this.stacks.set(i, ItemStack.EMPTY);
            this.onContentsChanged(i);
        }
    }

    public boolean isEmpty() {
        for (ItemStack stack : this.stacks) {
            if (stack.isEmpty() || stack.getItem() == Items.AIR) {
                return true;
            }
        }
        return false;
    }

    public @NotNull ItemStack decrStackSize(int index, int count) {
        ItemStack stack = getStackInSlot(index);
        stack.shrink(count);
        this.onContentsChanged(index);
        return stack;
    }

    public void removeStackFromSlot(int index) {
        this.stacks.set(index, ItemStack.EMPTY);
        this.onContentsChanged(index);
    }

    public @NotNull NonNullList<ItemStack> toNonNullList() {
        NonNullList<ItemStack> items = NonNullList.create();
        for (ItemStack stack : this.stacks) {
            items.add(stack);
        }
        return items;
    }

    public void setNonNullList(@NotNull NonNullList<ItemStack> items) {
        if (items.size() == 0)
            return;
        if (items.size() != this.getSlots())
            throw new IndexOutOfBoundsException("NonNullList must be same size as ItemStackHandler!");
        for (int index = 0; index < items.size(); index++) {
            this.stacks.set(index, items.get(index));
        }
    }

    @Override
    public String toString() {
        return this.stacks.toString();
    }
}
