package com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.flouride.slots;

import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.InfusingChamberTileEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;

public class SlotFuel extends Slot {

    public SlotFuel(Inventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);

    }

    @Override
    public ItemStack safeInsert(ItemStack stack) {
        return InfusingChamberTileEntity.isItemFuel(stack);
    }



    @Override
    public int getItemStackLimit(@Nonnull ItemStack stack) {
        // TODO Auto-generated method stub
        return super.getItemStackLimit(stack);
    }


}
