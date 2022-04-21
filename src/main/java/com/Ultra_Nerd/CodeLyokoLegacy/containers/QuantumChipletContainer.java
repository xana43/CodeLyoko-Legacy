package com.Ultra_Nerd.CodeLyokoLegacy.containers;

public class QuantumChipletContainer/* extends AbstractContainerMenu*/  {
    /*public final QuantumChipletTileEntity QuantumTE;
    //private final IWorldPosCallable callable;

    public QuantumChipletContainer(final int windowID, final @NotNull Inventory PI, final QuantumChipletTileEntity TEIN) {
        super(ModContainerTypes.QUANTUM_CHIPLET_CONTAINER.get(), windowID);
        this.QuantumTE = TEIN;
        //this.callable = IWorldPosCallable.of(TEIN.getWorld(), TEIN.getPos());
        //this.addSlot(new Slot(TEIN, 0, 81, 36));
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

        for (int colum = 0; colum < 9; colum++) {
            this.addSlot(new Slot(PI, colum, startX + (colum * slotSizePlus2), 142));
        }
    }


    public QuantumChipletContainer(final int windowID, final @NotNull Inventory PI, final @NotNull FriendlyByteBuf dat) {
        this(windowID, PI, getQuantumTE(PI, dat));
    }


    private static @NotNull QuantumChipletTileEntity getQuantumTE(final @NotNull Inventory PINV, final @NotNull FriendlyByteBuf dat) {
        Objects.requireNonNull(PINV, "Player's inventory can't be null");
        Objects.requireNonNull(dat, "data can't be null");
        final BlockEntity TileAtLoc = PINV.player.level.getBlockEntity(dat.readBlockPos());
        if (TileAtLoc instanceof QuantumChipletTileEntity) {
            return (QuantumChipletTileEntity) TileAtLoc;
        }
        throw new IllegalStateException("this tile entity died" + TileAtLoc);
    }
/*
    @Override
    public boolean canInteractWith(@Nonnull PlayerEntity playerIn) {
        return isWithinUsableDistance(callable, playerIn, ModBlocks.CHIPLET_FRANZ_BLOCK.get());
    }*/
 /*   @Nonnull
    @Override
    public ItemStack quickMoveStack(@Nonnull Player playerIn, int index) {
        ItemStack IStack = ItemStack.EMPTY;
        Slot slot = this.getSlot(index);
        if (slot.hasItem()) {
            ItemStack IStack1 = slot.getItem();
            IStack = IStack1.copy();
            if (index < 1) {
                if (!this.moveItemStackTo(IStack1, 1, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }


            } else if (!this.moveItemStackTo(IStack, 0, 1, false)) {
                return ItemStack.EMPTY;
            }
            if (IStack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return IStack;
    }

    @Override
    public boolean stillValid(Player p_38874_) {
        return false;
    }

  */
}
