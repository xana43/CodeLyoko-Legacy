package com.Ultra_Nerd.CodeLyokoRemake15.containers;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModContainerTypes;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.QuantumChipletTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

import java.util.Objects;

public class QuantumChipletContainer extends Container {
    public final QuantumChipletTileEntity QuantumTE;
    private final IWorldPosCallable callable;
    public QuantumChipletContainer(final int windowID, final PlayerInventory PI,final QuantumChipletTileEntity TEIN)
    {
        super(ModContainerTypes.QUANTUM_CHIPLET_CONTAINER.get(),windowID);
        this.QuantumTE = TEIN;
        this.callable = IWorldPosCallable.of(TEIN.getWorld(),TEIN.getPos());
        this.addSlot(new Slot(TEIN,0,81,36));
        //main inventory
        int startX = 8;
        int startY = 84;
        int slotSizePlus2 = 18;
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                this.addSlot(new Slot(PI, 9 + (row * 9) + column, startX + (column * slotSizePlus2),
                        startY + (row * slotSizePlus2)));
            }
        }
        //hotbor

        for(int colum = 0; colum < 9; colum++)
        {
            this.addSlot(new Slot(PI,colum,startX + (colum * slotSizePlus2),142));
        }
    }


    public QuantumChipletContainer(final int windowID,final PlayerInventory PI, final PacketBuffer dat)
    {
        this(windowID,PI,getQuantumTE(PI,dat));
    }


    private static QuantumChipletTileEntity getQuantumTE(final PlayerInventory PINV, final PacketBuffer dat)
    {
        Objects.requireNonNull(PINV,"Player's inventory can't be null");
        Objects.requireNonNull(dat,"data can't be null");
        final TileEntity TileAtLoc = PINV.player.world.getTileEntity(dat.readBlockPos());
        if(TileAtLoc instanceof QuantumChipletTileEntity)
        {
            return (QuantumChipletTileEntity) TileAtLoc;
        }
        throw new IllegalStateException("this tile entity died" + TileAtLoc);
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(callable,playerIn, ModBlocks.CHIPLET_FRANZ_BLOCK.get());
    }

    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack IStack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if(slot != null && slot.getHasStack())
        {
            ItemStack IStack1 = slot.getStack();
            IStack = IStack1.copy();
            if(index < 1)
            {
                if(!this.mergeItemStack(IStack1,1,this.inventorySlots.size(),true))
                {
                    return ItemStack.EMPTY;
                }




            }
            else if(!this.mergeItemStack(IStack,0,1,false))
            {
                return ItemStack.EMPTY;
            }
            if(IStack1.isEmpty())
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }
        }
        return IStack;
    }
}
