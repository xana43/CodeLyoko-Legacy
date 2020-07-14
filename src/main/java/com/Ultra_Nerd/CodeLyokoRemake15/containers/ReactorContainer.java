package com.Ultra_Nerd.CodeLyokoRemake15.containers;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;

import javax.annotation.Nullable;

public class ReactorContainer extends Container
{
	public ReactorContainer(@Nullable ContainerType<?> type, int id) {
		super(type, id);
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return false;
	}
	//protected ReactorContainer(Properties builder) {
	//	super(builder);
//	}

	/*

	private final ComputerReactorTileEntity tileentity;
	private int energy, Fission;
	
	public ReactorContainer(final int windowID,final PlayerInventory player,final ComputerReactorTileEntity tileentity)
	{
		super(ModContainerTypes.COMPUTER_REACTOR_CONTAINER.get(),windowID);
		this.tileentity = tileentity;
		IItemHandler handler = tileentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		
		this.addSlotToContainer(new SlotItemHandler(handler, 0, 80, 33));
		
		for(int y = 0; y < 3; y++)
		{
			for(int x = 0; x < 9; x++)
			{
				this.addSlotToContainer(new Slot(player, x + y*9 + 9, 8 + x*18, 84 + y*18));
			}
		}
		
		for(int x = 0; x < 9; x++)
		{
			this.addSlotToContainer(new Slot(player, x, 8 + x * 18, 142));
		}
	}
	
	@Override
	public boolean canInteractWith(PlayerEntity playerIn)
	{
		return this.tileentity.isUsableByPlayer(playerIn);
	}
	
	@Override
	public void updateProgressBar(int id, int data) 
	{
		this.tileentity.set(id, data);
	}
	
	@Override
	public void detectAndSendChanges() 
	{
		super.detectAndSendChanges();
		
		for(int i = 0; i < this.listeners.size(); ++i) 
		{
			IContainerListener listener = (IContainerListener)this.listeners.get(i);
			if(this.energy != this.tileentity.get(0)) listener.sendWindowProperty(this, 0, this.tileentity.get(0));
			if(this.Fission != this.tileentity.get(1)) listener.sendWindowProperty(this, 1, this.tileentity.get(1));
		}
		
		this.energy = this.tileentity.get(0);
		this.Fission = this.tileentity.get(1);
	}
	
	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index)
	{
		ItemStack stack = ItemStack.EMPTY;
		Slot slot = (Slot)this.inventorySlots.get(index);
		
		if(slot != null && slot.getHasStack())
		{
			ItemStack stack1 = slot.getStack();
			stack = stack1.copy();
			
			if(index >= 0 && index < 27)
			{
				if(!this.mergeItemStack(stack1, 27, 36, false)) return ItemStack.EMPTY;
			}
			else if(index >= 27 && index < 36)
			{
				if(!this.mergeItemStack(stack1, 0, 27, false)) return ItemStack.EMPTY;
			}
			else if(!this.mergeItemStack(stack1, 0, 36, false))
			{
				return ItemStack.EMPTY;
			}
			
			if(stack1.isEmpty()) slot.putStack(ItemStack.EMPTY);
			else slot.onSlotChanged();
			
			if(stack1.getCount() == stack.getCount()) return ItemStack.EMPTY;
			slot.onTake(playerIn, stack1);
		}
		
		return stack;
	}

	 */
}