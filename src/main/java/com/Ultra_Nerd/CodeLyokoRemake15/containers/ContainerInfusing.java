package com.Ultra_Nerd.CodeLyokoRemake15.containers;


import com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.flouride.FlourideInfusionResult;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModContainerTypes;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.InfusingChamberTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;

public class ContainerInfusing extends AbstractContainerMenu {
    /*
    public final ContainerData ContainerData;
    private final ContainerLevelAccess containerLevelAccess;
    private int cookTime, totalCookTime, burnTime, currentBurnTime;
    //client
  public ContainerInfusing(int id, Inventory playerInv)
  {
      this(id,playerInv,new ItemStackHandler(4), BlockPos.ZERO,new SimpleContainerData(4));
  }

  //server
   public ContainerInfusing(int id, Inventory playerInv, IItemHandler handler, BlockPos pos, ContainerData data)
   {
       super(ModContainerTypes.CONTAINER_INFUSING.get(),id);
    this.containerLevelAccess = ContainerLevelAccess.create(playerInv.player.level,pos);
       this.addSlot(new SlotItemHandler(handler, 0, 24, 16));
       this.addSlot(new SlotItemHandler(handler, 1, 56, 15));
       this.addSlot(new SlotItemHandler(handler, 2, 58, 59));
       this.addSlot(new SlotItemHandler(handler, 3, 120, 30));

       for (int y = 0; y < 3; y++) {
           for (int x = 0; x < 9; x++) {
               this.addSlot(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
           }
       }

       for (int x = 0; x < 9; x++) {
           this.addSlot(new Slot(playerInv, x, 8 + x * 18, 142));
       }
       addDataSlots(data);

   }

    /**
     * Constructor that uses super
     *
     * @param windowId        the id of the container
     * @param playerInventory the playerInv of the player using this container
     * @param tileEntity      the tileEntity of this container
     */
    /*
    public ContainerInfusing(final int windowId, final Inventory playerInventory, final InfusingChamberTileEntity tileEntity) {
        super(ModContainerTypes.CONTAINER_INFUSING.get(), windowId);

        this.tileentity = tileEntity;
        IItemHandler handler = tileentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, Direction.UP).orElse(null);


    }

   public static MenuConstructor getServerContainer(InfusingChamberTileEntity be,BlockPos pos)
   {
       return (id,playerInv,player) -> new InfusingChamberTileEntity(id,playerInv,be);
   }


    @Override
    @OnlyIn(Dist.CLIENT)
    public void updateProgressBar(int id, int data) {
        this.tileentity.setField(id, data);
    }

    @Override
    public boolean canInteractWith(@Nonnull PlayerEntity playerIn) {
        return this.tileentity.isUsableByPlayer(playerIn);
    }

    @Nonnull
    @Override
    public ItemStack transferStackInSlot(@Nonnull PlayerEntity playerIn, int index) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack stack1 = slot.getStack();
            stack = stack1.copy();

            if (index == 3) {
                if (!this.mergeItemStack(stack1, 4, 40, true)) return ItemStack.EMPTY;
                slot.onSlotChange(stack1, stack);
            } else if (index != 2 && index != 1 && index != 0) {
                Slot slot1 = this.inventorySlots.get(index + 1);

                if (!FlourideInfusionResult.getInstance().getInfusingResult(stack1, slot1.getStack()).isEmpty()) {
                    if (!this.mergeItemStack(stack1, 0, 2, false)) {
                        return ItemStack.EMPTY;
                    } else if (InfusingChamberTileEntity.isItemFuel(stack1)) {
                        if (!this.mergeItemStack(stack1, 2, 3, false)) return ItemStack.EMPTY;
                    } else if (InfusingChamberTileEntity.isItemFuel(stack1)) {
                        if (!this.mergeItemStack(stack1, 2, 3, false)) return ItemStack.EMPTY;
                    } else if (InfusingChamberTileEntity.isItemFuel(stack1)) {
                        if (!this.mergeItemStack(stack1, 2, 3, false)) return ItemStack.EMPTY;
                    } else if (index >= 4 && index < 31) {
                        if (!this.mergeItemStack(stack1, 31, 40, false)) return ItemStack.EMPTY;
                    } else if (index >= 31 && index < 40 && !this.mergeItemStack(stack1, 4, 31, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            } else if (!this.mergeItemStack(stack1, 4, 40, false)) {
                return ItemStack.EMPTY;
            }
            if (stack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();

            }
            if (stack1.getCount() == stack.getCount()) return ItemStack.EMPTY;
            slot.onTake(playerIn, stack1);
        }
        return stack;
    }


    @Override
    public boolean stillValid(Player p_38874_) {
        return stillValid(this.);
    }
    */
}