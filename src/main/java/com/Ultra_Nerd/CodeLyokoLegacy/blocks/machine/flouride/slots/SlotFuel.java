package com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.flouride.slots;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class SlotFuel extends Slot {

    public SlotFuel(@NotNull Inventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);

    }

    @Override
    public @Nullable ItemStack safeInsert(ItemStack stack) {
        return null ;//InfusingChamberTileEntity.isItemFuel(stack);
    }



    @Override
    public int getMaxStackSize(@Nonnull ItemStack stack) {
        // TODO Auto-generated method stub
        return super.getMaxStackSize(stack);
    }


}
