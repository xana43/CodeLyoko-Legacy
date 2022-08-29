package com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers;


public class ReactorContainer /*extends AbstractContainerMenu implements Container*/ {
	/*public ReactorContainer(@Nullable MenuType<?> type, int id) {
        super(type, id);
    }

	@Override
	public boolean stillValid(Player p_38874_) {
		return false;
	}

	@Override
	public int getContainerSize() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public @org.jetbrains.annotations.Nullable ItemStack getItem(int p_18941_) {
		return null;
	}

	@Override
	public @org.jetbrains.annotations.Nullable ItemStack removeItem(int p_18942_, int p_18943_) {
		return null;
	}

	@Override
	public @org.jetbrains.annotations.Nullable ItemStack removeItemNoUpdate(int p_18951_) {
		return null;
	}

	@Override
	public void setItem(int p_18944_, ItemStack p_18945_) {

	}

	@Override
	public void setChanged() {

	}

	@Override
	public void clearContent() {

	}



/*
    @Override
    public boolean canInteractWith(@Nonnull Player playerIn) {
        return false;
    }
    //protected ReactorContainer(Properties builder) {
    //	super(builder);
//	}



	private final ComputerReactorTileEntity tileentity;
	private int energy, Fission;
	
	public ReactorContainer(final int windowID, final Inventory player, final ComputerReactorTileEntity tileentity)
	{
		super(ModContainerTypes.COMPUTER_REACTOR_CONTAINER.get(),windowID);
		this.tileentity = tileentity;
		IItemHandler handler = tileentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).resolve().get();
		
		this.addSlot(new SlotItemHandler(handler, 0, 80, 33));
		
		for(int y = 0; y < 3; y++)
		{
			for(int x = 0; x < 9; x++)
			{
				this.addSlot(new Slot(player, x + y*9 + 9, 8 + x*18, 84 + y*18));
			}
		}
		
		for(int x = 0; x < 9; x++)
		{
			this.addSlot(new Slot(player, x, 8 + x * 18, 142));
		}
	}

	@Override
	public int getContainerSize() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public ItemStack getItem(int p_18941_) {
		return null;
	}

	@Override
	public ItemStack removeItem(int p_18942_, int p_18943_) {
		return null;
	}

	@Override
	public ItemStack removeItemNoUpdate(int p_18951_) {
		return null;
	}

	@Override
	public void setItem(int p_18944_, ItemStack p_18945_) {

	}

	@Override
	public void setChanged() {

	}

	@Override
	public boolean stillValid(Player playerIn)
	{
		return this.tileentity.isUsableByPlayer(playerIn);
	}

	@Override
	public void clearContent() {

	}
	/*
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