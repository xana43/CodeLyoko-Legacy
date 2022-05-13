package com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers;

public final class ComputerControlPanelContainer /*extends Container*/  {
    /*public final ComputerControlPanelTileEntity ControlPanelEntity;
    //private final BlockEntityType.BlockEntitySupplier canInteractWithCallable;

    public ComputerControlPanelContainer(final int windowid, final Inventory PInventory, final ComputerControlPanelTileEntity PanelEntity) {
        super(ModContainerTypes.COMPUTER_CONTROL_PANEL_CONTAINER.get(), windowid);
        this.ControlPanelEntity = PanelEntity;
        //this.canInteractWithCallable = (PanelEntity.getBlockPos(), PanelEntity.getBlockState());
    }

    public ComputerControlPanelContainer(final int windowid, final @NotNull Inventory inven, final @NotNull FriendlyByteBuf data) {
        this(windowid, inven, getControlEntity(inven, data));
    }

    private static @NotNull ComputerControlPanelTileEntity getControlEntity(final @NotNull Inventory inventory, final @NotNull FriendlyByteBuf data) {
        Objects.requireNonNull(inventory, "player inventory can't be null");
        Objects.requireNonNull(data, "data can't be null");
        final BlockEntity tileAtPos = inventory.player.level.getBlockEntity(data.readBlockPos());
        if (tileAtPos instanceof ComputerControlPanelTileEntity) {
            return (ComputerControlPanelTileEntity) tileAtPos;
        } else {
            throw new IllegalStateException("TileEntity isn't correct" + tileAtPos);
        }
    }
/*
(canInteractWithCallable, playerIn, ModBlocks.COMPUTER_TOWER_CONTROL_PANEL.get());

    @Override
    public boolean stillValid(@Nonnull Player playerIn) {
        return stillValid(ContainerLevelAccess.create(Objects.requireNonNull(ControlPanelEntity.getLevel()),ControlPanelEntity.getBlockPos()), playerIn, ModBlocks.COMPUTER_TOWER_CONTROL_PANEL.get());
    }
*/

}
