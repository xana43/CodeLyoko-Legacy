package com.Ultra_Nerd.CodeLyokoRemake15.containers;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;

import javax.annotation.Nullable;

public class ContainerElectricInfusing extends Container
{
	protected ContainerElectricInfusing(@Nullable ContainerType<?> type, int id) {
		super(type, id);
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return false;
	}
	/*
	private final ElectricInfusingChamberTileEntity tileentity;
	private int cookTime, energy;
	/**
	 * Useful constructor in outside classes
	 * @param windowId the id of the container
	 * @param playerInventory the playerInv of the player using this container
	 * @param data the data sent when this container is used.

	public ContainerElectricInfusing(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
		this(windowId, playerInventory, getTileEntity(playerInventory, data));
	}

	/**
	 * Constructor that uses super
	 * @param windowId the id of the container
	 * @param playerInventory the playerInv of the player using this container
	 * @param tileEntity the tileEntity of this container

	public ContainerElectricInfusing(final int windowId, final PlayerInventory playerInventory, final ElectricInfusingChamberTileEntity tileEntity) {
		super(ModContainerTypes.CONTAINER_INFUSING.get(), windowId);
		this.tileentity = tileEntity;
		IItemHandler handler = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, Direction.UP).orElse(null);
		
		this.addSlot(new SlotItemHandler(handler, 0, 25, 15));
		this.addSlot(new SlotItemHandler(handler, 1, 57, 14));
		this.addSlot(new SlotItemHandler(handler, 2, 120, 30));
		
		for(int y = 0; y < 3; y++)
		{
			for(int x = 0; x < 9; x++)
			{
				this.addSlot(new Slot(playerInventory, x + y*9 + 9, 8 + x*18, 84 + y*18));
			}
		}
		
		for(int x = 0; x < 9; x++)
		{
			this.addSlot(new Slot(playerInventory, x, 8 + x * 18, 142));
		}
	}
	
	@Override
	public void detectAndSendChanges() 
	{
		super.detectAndSendChanges();
		
		/*for(int i = 0; i < this.listeners.size(); ++i)
		{
			IContainerListener listener = (IContainerListener)this.listeners.get(i);
			if(this.energy != this.tileentity.getField(0)) listener.sendWindowProperty(this, 0, this.tileentity.getField(0));
			if(this.cookTime != this.tileentity.getField(1)) listener.sendWindowProperty(this, 1, this.tileentity.getField(1));
			
		}
		
		this.cookTime = this.tileentity.getField(2);
		this.energy = this.tileentity.getField(0);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public void updateProgressBar(int id, int data) 
	{
		this.tileentity.setField(id, data);
	}
	
	@Override
	public boolean canInteractWith(PlayerEntity playerIn)
	{
		return this.tileentity.isUsableByPlayer(playerIn);
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
			
			if(index == 3) 
			{
				if(!this.mergeItemStack(stack1, 4, 40, true)) return ItemStack.EMPTY;
				slot.onSlotChange(stack1, stack);
			}
			else if(index != 2 && index != 1 && index != 0) 
			{		
				Slot slot1 = (Slot)this.inventorySlots.get(index + 1);
				
				if(!FlourideInfusionResult.getInstance().getInfusingResult(stack1, slot1.getStack()).isEmpty())
				{
					if(!this.mergeItemStack(stack1, 0, 2, false)) 
					{
						return ItemStack.EMPTY;
					}
					else if(index >= 4 && index < 31)
					{
						if(!this.mergeItemStack(stack1, 31, 40, false)) return ItemStack.EMPTY;
					}
					else if(index >= 31 && index < 40 && !this.mergeItemStack(stack1, 4, 31, false))
					{
						return ItemStack.EMPTY;
					}
				}
			} 
			else if(!this.mergeItemStack(stack1, 4, 40, false)) 
			{
				return ItemStack.EMPTY;
			}
			if(stack1.isEmpty())
			{
				slot.putStack(ItemStack.EMPTY);
			}
			else
			{
				slot.onSlotChanged();

			}
			if(stack1.getCount() == stack.getCount()) return ItemStack.EMPTY;
			slot.onTake(playerIn, stack1);
		}
		return stack;
	}

	/**
	 * Get tileEntity from playerInv and packet
	 * @param playerInventory playerInv from which to get the world
	 * @param data Data from which to get the pos
	 * @return the tileEntity linked to the block used

	private static ElectricInfusingChamberTileEntity getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data) {
		Objects.requireNonNull(playerInventory, "playerInventory cannot be null!");
		Objects.requireNonNull(data, "data cannot be null!");
		final TileEntity tileAtPos = playerInventory.player.world.getTileEntity(data.readBlockPos());
		if (tileAtPos instanceof InfusingChamberTileEntity)
			return (ElectricInfusingChamberTileEntity) tileAtPos;
		throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
	}

	 */
	
}