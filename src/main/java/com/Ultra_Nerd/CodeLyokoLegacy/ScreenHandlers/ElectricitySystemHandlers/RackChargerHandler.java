package com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.ElectricitySystemHandlers;

import com.Ultra_Nerd.CodeLyokoLegacy.Slots.UpgradeSlot;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModScreenHandlers;
import com.Ultra_Nerd.CodeLyokoLegacy.items.MachineItems.ChargeUpgrade;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public final class RackChargerHandler extends ScreenHandler {

    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    @SuppressWarnings("ObjectAllocationInLoop")
    public RackChargerHandler(final int syncId, final PlayerInventory player, final Inventory inventory, final PropertyDelegate propertyDelegate) {
        super(ModScreenHandlers.RACK_CHARGER_HANDLER_SCREEN_TYPE, syncId);
        checkSize(inventory,6);
        this.inventory = inventory;
        this.propertyDelegate = propertyDelegate;
        inventory.onOpen(player.player);
        int x,y;
        for(x = 0; x < 3; ++x)
        {
            this.addSlot(new Slot(inventory,x,65 * x,35));
        }
        this.addSlot(new UpgradeSlot(inventory,3,0,55,ModItems.HOVERBOARD_SPAWN_ITEM));
        this.addSlot(new UpgradeSlot(inventory,4,65,55,ModItems.HOVERBOARD_SPAWN_ITEM));
        this.addSlot(new UpgradeSlot(inventory,5,65*2,55,ModItems.HOVERBOARD_SPAWN_ITEM));
        for(x = 0; x < 3; ++x)
        {
            for(y = 0; y < 9; ++y)
            {
                this.addSlot(new Slot(player,y+x*9+9,8+y*18,84+x*18));
            }
        }
        for(x = 0; x < 9; ++x)
        {
            this.addSlot(new Slot(player,x,8+x*18,142));
        }
        addProperties(propertyDelegate);
    }
    public RackChargerHandler(final int syncId, final PlayerInventory player)
    {
        this(syncId,player,new SimpleInventory(6),new ArrayPropertyDelegate(4));
    }
    public int getEnergy()
    {
        return propertyDelegate.get(3);
    }
    public int getCapacity()
    {
        return propertyDelegate.get(4);
    }
    public void setEnergy(final int energy)
    {
        propertyDelegate.set(3,energy);
    }
    @Override
    public ItemStack quickMove(final PlayerEntity player, final int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        final Slot slot = this.slots.get(invSlot);
        if (slot.hasStack()) {
            final ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size() && (originalStack.isOf(ModItems.LINKER) || originalStack.isOf(ModItems.MIND_HELMET))) {
                if (!this.insertItem(originalStack, 0, 2, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (invSlot < this.inventory.size() && ChargeUpgrade.getUpgradeTierFromItem(originalStack.getItem()) > -1) {
                if (!this.insertItem(originalStack, 3, 5, true)) {
                    return ItemStack.EMPTY;
                }
                setSlotTier(invSlot, ChargeUpgrade.getUpgradeTierFromItem(newStack.getItem()));

            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }



    public void setSlotTier(final int slot, final int slotTier)
    {
        switch (slot)
        {
            case 3 -> propertyDelegate.set(0,slotTier);
            case 4 -> propertyDelegate.set(1,slotTier);
            case 5 -> propertyDelegate.set(2,slotTier);
        }
    }
    public int getSlotTier(final int slot)
    {
        return switch (slot)
        {
            case 3 -> propertyDelegate.get(0);
            case 4 -> propertyDelegate.get(1);
            case 5 -> propertyDelegate.get(2);
            default -> throw new IllegalStateException("Unexpected value: " + slot);
        };
    }
    @Override
    public boolean canUse(final PlayerEntity player) {
        return inventory.canPlayerUse(player);
    }
}
