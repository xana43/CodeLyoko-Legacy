package com.Ultra_Nerd.CodeLyokoRemake15.containers;

import com.Ultra_Nerd.CodeLyokoRemake15.Util.FunctionalVariableReferenceHolder;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.flouride.FlourideInfusionResult;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModContainerTypes;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.ElectroplatingTileEntity;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.InfusingChamberTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;
import java.util.Objects;

public class ContainerElectroplate extends Container {

    private final IWorldPosCallable canInteractWithCallable;
    private ElectroplatingTileEntity tileEntity;
    public FunctionalVariableReferenceHolder currentTime;
    public ContainerElectroplate(final int WindowID, final PlayerInventory plinv, final ElectroplatingTileEntity tile){
        super(ModContainerTypes.ELECTROPLATING_CONTAINER.get(),WindowID);
        this.tileEntity = tile;
        this.canInteractWithCallable = IWorldPosCallable.of(tile.getWorld(),tile.getPos());
        final int slotSizePlus2 = 18;
        final int startX = 8;

        //hotbar gui
        int Hotbary = 142;
        for(int colum = 0; colum < 9; colum++)
        {
            this.addSlot(new Slot(plinv,colum,startX + (colum * slotSizePlus2),Hotbary));
        }
        //main gui
        final int startY = 84;
        for(int row = 0; row < 3; row++)
        {
            for(int colum = 0; colum < 9; colum++)
            {
                this.addSlot(new Slot(plinv,9 + (row * 9) + colum,startX + (colum * slotSizePlus2),startY + (row * slotSizePlus2)));
            }
        }

        //plater slots
        for(int inputslotsrow = 0; inputslotsrow < 5; inputslotsrow++) {
            for(int inputslotscolum = 0; inputslotscolum < 6; inputslotscolum++) {
                this.addSlot(new SlotItemHandler(tile.getInventory(), 6 + (inputslotsrow * 6), (inputslotscolum * slotSizePlus2), (inputslotsrow * slotSizePlus2)));
            }
        }
        for(int outslotsrow = 0; outslotsrow < 5; outslotsrow++) {
            for(int outslotscolum = 0; outslotscolum < 6; outslotscolum++) {
                this.addSlot(new SlotItemHandler(tile.getInventory(), 6 + (outslotsrow * 6), 10 + (outslotscolum * slotSizePlus2),10 + (outslotsrow * slotSizePlus2)));
            }
        }
        this.trackInt(new FunctionalVariableReferenceHolder(() -> this.tileEntity.currentTime,value -> this.tileEntity.currentTime = value));
    }
    public ContainerElectroplate(final int WindowID, final PlayerInventory plinv, final PacketBuffer data){
        this(WindowID,plinv,getTileEntity(plinv,data));
    }


    private static ElectroplatingTileEntity getTileEntity(PlayerInventory playerInven, PacketBuffer data) {
        Objects.requireNonNull(playerInven, "playerInventory cannot be null!");
        Objects.requireNonNull(data, "data cannot be null!");
        final TileEntity tileAtPos = playerInven.player.world.getTileEntity(data.readBlockPos());
        if (tileAtPos instanceof ElectroplatingTileEntity)
            return (ElectroplatingTileEntity) tileAtPos;
        throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
    }
    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(canInteractWithCallable,playerIn, ModBlocks.ELECTROPLATING_MACHINE.get());
    }

    @Nonnull
    @Override
    public ItemStack transferStackInSlot(@Nonnull PlayerEntity playerIn, int index) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = (Slot) this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack stack1 = slot.getStack();
            stack = stack1.copy();

            if (index == 3) {
                if (!this.mergeItemStack(stack1, 4, 40, true)) return ItemStack.EMPTY;
                slot.onSlotChange(stack1, stack);
            } else if (index != 2 && index != 1 && index != 0) {
                Slot slot1 = (Slot) this.inventorySlots.get(index + 1);

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
}
