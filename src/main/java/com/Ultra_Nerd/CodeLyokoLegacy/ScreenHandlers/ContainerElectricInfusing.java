package com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers;


public final class ContainerElectricInfusing /* extends AbstractContainerMenu implements Container*/ {
/*

    public final @NotNull ElectricInfusingChamberTileEntity tileentity;
    private final List<ContainerListener> listeners = Lists.newArrayList();
    //private ScriptObjectMirror listeners;
    private int cookTime, energy;

    /**
     * Useful constructor in outside classes
     *
     * @param windowId        the id of the container
     * @param playerInventory the playerInv of the player using this container
     * @param data            the data sent when this container is used.
     */
  /*  public ContainerElectricInfusing(final int windowId, final @NotNull Inventory playerInventory, final @NotNull FriendlyByteBuf data) {
        this(windowId, playerInventory, getTileEntity(playerInventory, data));
    }

    /**
     * Constructor that uses super
     *
     * @param windowId        the id of the container
     * @param playerInventory the playerInv of the player using this container
     * @param tileEntity      the tileEntity of this container
     */
  /*  public ContainerElectricInfusing(final int windowId, final @NotNull Inventory playerInventory, final @NotNull ElectricInfusingChamberTileEntity tileEntity) {
        super(ModContainerTypes.CONTAINER_ELECTRIC_INFUSING.get(), windowId);
        this.tileentity = tileEntity;
        IItemHandler handler = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, Direction.UP).orElse(null);

        this.addSlot(new SlotItemHandler(handler, 0, 25, 15));
        this.addSlot(new SlotItemHandler(handler, 1, 57, 14));
        this.addSlot(new SlotItemHandler(handler, 2, 120, 30));

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 9; x++) {
                this.addSlot(new Slot(playerInventory, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
            }
        }

        for (int x = 0; x < 9; x++) {
            this.addSlot(new Slot(playerInventory, x, 8 + x * 18, 142));
        }
    }

    /**
     * Get tileEntity from playerInv and packet
     *
     * @param playerInven playerInv from which to get the world
     * @param data        Data from which to get the pos
     * @return the tileEntity linked to the blocks used
     */
   /* private static @NotNull ElectricInfusingChamberTileEntity getTileEntity(@NotNull Inventory playerInven, @NotNull FriendlyByteBuf data) {
        Objects.requireNonNull(playerInven, "playerInventory cannot be null!");
        Objects.requireNonNull(data, "data cannot be null!");
        final BlockEntity tileAtPos = playerInven.player.level.getBlockEntity(data.readBlockPos());
        if (tileAtPos instanceof ElectricInfusingChamberTileEntity)
            return (ElectricInfusingChamberTileEntity) tileAtPos;
        throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
    }



    @Override
    public void addSlotListener(@Nonnull ContainerListener listener) {
        if (!this.listeners.contains(listener)) {
            this.listeners.add(listener);
            //listener.sendAllContents(this, this.getInventory());
            this.broadcastChanges();
        }
    }


    @Override
    public void removeSlotListener(@Nonnull ContainerListener listener) {
        this.listeners.remove(listener);
    }


    @Override
    public void broadcastChanges() {
        super.broadcastChanges();

        for (ContainerListener listener : this.listeners) {
            if (this.energy != this.tileentity.getField(0))
                listener.dataChanged(this, 0, this.tileentity.getField(0));
            if (this.cookTime != this.tileentity.getField(1))
                listener.dataChanged(this, 1, this.tileentity.getField(1));

        }

        this.cookTime = this.tileentity.getField(2);
        this.energy = this.tileentity.getField(0);
    }



/*
    @Override
    @OnlyIn(Dist.CLIENT)
    public void updateProgressBar(int id, int data) {
        this.tileentity.setField(id, data);
    }

 */

 /*   @Override
    public int getContainerSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public @Nullable ItemStack getItem(int p_18941_) {
        return null;
    }

    @Override
    public @Nullable ItemStack removeItem(int p_18942_, int p_18943_) {
        return null;
    }

    @Override
    public @Nullable ItemStack removeItemNoUpdate(int p_18951_) {
        return null;
    }

    @Override
    public void setItem(int p_18944_, ItemStack p_18945_) {

    }

    @Override
    public void setChanged() {

    }

    @Override
    public boolean stillValid(@Nonnull Player playerIn) {
        return this.tileentity.isUsableByPlayer(playerIn);
    }


    @Nonnull
    @Override
    public ItemStack quickMoveStack(@Nonnull Player playerIn, int index) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot.hasItem()) {
            ItemStack stack1 = slot.getItem();
            stack = stack1.copy();

            if (index == 3) {
                if (!this.moveItemStackTo(stack1, 4, 40, true)) return ItemStack.EMPTY;
                slot.onQuickCraft(stack1, stack);
            } else if (index != 2 && index != 1 && index != 0) {
                Slot slot1 = this.slots.get(index + 1);

                if (!FlourideInfusionResult.getInstance().getInfusingResult(stack1, slot1.getItem()).isEmpty()) {
                    if (!this.moveItemStackTo(stack1, 0, 2, false)) {
                        return ItemStack.EMPTY;
                    } else if (index >= 4 && index < 31) {
                        if (!this.moveItemStackTo(stack1, 31, 40, false)) return ItemStack.EMPTY;
                    } else if (index >= 31 && index < 40 && !this.moveItemStackTo(stack1, 4, 31, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            } else if (!this.moveItemStackTo(stack1, 4, 40, false)) {
                return ItemStack.EMPTY;
            }
            if (stack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();

            }
            if (stack1.getCount() == stack.getCount()) return ItemStack.EMPTY;
            slot.onTake(playerIn, stack1);
        }
        return stack;
    }


    @Override
    public void clearContent() {

    }

  */
}