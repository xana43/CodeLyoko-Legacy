package com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.ElectricitySystemHandlers;

import com.Ultra_Nerd.CodeLyokoLegacy.Slots.UpgradeSlot;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModScreenHandlers;
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
    public RackChargerHandler(final int syncId,final PlayerInventory player,final Inventory inventory,final PropertyDelegate propertyDelegate) {
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
        this.addSlot(new UpgradeSlot(inventory,4,65,35*2,ModItems.HOVERBOARD_SPAWN_ITEM));
        this.addSlot(new UpgradeSlot(inventory,5,65*2,35*2,ModItems.HOVERBOARD_SPAWN_ITEM));
        this.addSlot(new UpgradeSlot(inventory,6,65*3,35*2,ModItems.HOVERBOARD_SPAWN_ITEM));
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
        this(syncId,player,new SimpleInventory(6),new ArrayPropertyDelegate(3));
    }

    @Override
    public ItemStack quickMove(final PlayerEntity player, final int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        final Slot slot = this.slots.get(invSlot);
        if (slot.hasStack()) {
            final ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size() && (originalStack.isOf(ModItems.LINKER) || originalStack.isOf(ModItems.MIND_HELMET))) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
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
        propertyDelegate.set(slot,slotTier);
    }
    public int getSlotTier(final int slot)
    {
        return propertyDelegate.get(slot);
    }
    @Override
    public boolean canUse(final PlayerEntity player) {
        return inventory.canPlayerUse(player);
    }
}
