package com.Ultra_Nerd.CodeLyokoLegacy.containers;

public final class ComputerInterfaceContainer /*extends AbstractContainerMenu*/ {
    /*
    public final ComputerInterfaceTE ComputerTE;
    //private final IWorldPosCallable canInteractWithCallable;

    public ComputerInterfaceContainer(final int windowid, final Inventory PInventory, final ComputerInterfaceTE computerTE) {
        super(ModContainerTypes.COMPUTER_INTERFACE_CONTAINER.get(), windowid);
        this.ComputerTE = computerTE;
        //this.canInteractWithCallable = Provider(ComputerTE.getWorld(), ComputerTE.getPos());
    }

    public ComputerInterfaceContainer(final int windowid, final @NotNull Inventory inven, final @NotNull FriendlyByteBuf data) {
        this(windowid, inven, getIntrfaceEntity(inven, data));
    }

    private static @NotNull ComputerInterfaceTE getIntrfaceEntity(final @NotNull Inventory inventory, final @NotNull FriendlyByteBuf data) {
        Objects.requireNonNull(inventory, "player inventory can't be null");
        Objects.requireNonNull(data, "data can't be null");
        final BlockEntity tileAtPos = inventory.player.level.getBlockEntity(data.readBlockPos());
        if (tileAtPos instanceof ComputerInterfaceTE) {
            return (ComputerInterfaceTE) tileAtPos;
        } else {
            throw new IllegalStateException("TileEntity isn't correct" + tileAtPos);
        }
    }
/*
    @Override
    public boolean canInteractWith(@Nonnull PlayerEntity playerIn) {
        return isWithinUsableDistance(canInteractWithCallable, playerIn, ModBlocks.COMPUTER_KEYBOARD.get());
    }

    @Override
    public boolean stillValid(Player p_38874_) {
        return true;
    }
    */
}
