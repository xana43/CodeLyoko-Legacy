package com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers;


public final class DataTransferInterfaceContainer /*extends AbstractContainerMenu*/ {
/*



    private DataTransferInterfaceTileEntity dataTransferInterfaceTileEntity;
    private @Nullable BlockEntity de2;
    private Player thisplayer;


    public DataTransferInterfaceContainer(int id, @NotNull BlockPos pos, Inventory playerInv, @NotNull Player player)
    {

        super(ModContainerTypes.DATA_TRANSFER_INTERFACE_CONTAINER.get(),id);
        this.thisplayer = player;
        this.de2 = player.getCommandSenderWorld().getBlockEntity(pos);

    }
    public DataTransferInterfaceContainer(final int windowid, final Inventory PInventory, final DataTransferInterfaceTileEntity dataTransferInterfaceTileEntity) {
        super(ModContainerTypes.DATA_TRANSFER_INTERFACE_CONTAINER.get(), windowid);
        this.dataTransferInterfaceTileEntity = dataTransferInterfaceTileEntity;


    }



    public DataTransferInterfaceContainer(final int windowid, final @NotNull Inventory inven, final @NotNull FriendlyByteBuf data) {
        this(windowid, inven, getBlockTE(inven, data));
    }

    private static @NotNull DataTransferInterfaceTileEntity getBlockTE(final @NotNull Inventory inventory, final @NotNull FriendlyByteBuf data) {
        Objects.requireNonNull(inventory, "player inventory can't be null");
        Objects.requireNonNull(data, "data can't be null");
        final BlockEntity tileAtPos = inventory.player.level.getBlockEntity(data.readBlockPos());
        if (tileAtPos instanceof DataTransferInterfaceTileEntity) {
            return (DataTransferInterfaceTileEntity) tileAtPos;
        } else {
            throw new IllegalStateException("TileEntity isn't correct" + tileAtPos);
        }
    }



    public DataTransferInterfaceTileEntity getDataTransferInterfaceTileEntity() {
        return dataTransferInterfaceTileEntity;
    }




    @Override
    public boolean stillValid(@NotNull Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(Objects.requireNonNull(de2.getLevel()),de2.getBlockPos()), thisplayer, ModBlocks.DATA_TRANSFER_INTERFACE.get());
    }

 */
}
