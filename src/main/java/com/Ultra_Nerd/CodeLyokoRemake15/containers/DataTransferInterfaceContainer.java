package com.Ultra_Nerd.CodeLyokoRemake15.containers;


import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.util.ITeleporter;

public class DataTransferInterfaceContainer implements ITeleporter, Container {
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
    public boolean stillValid(Player p_18946_) {
        return false;
    }

    @Override
    public void clearContent() {

    }
    /*
    private final DataTransferInterfaceTileEntity dataTransferInterfaceTileEntity;
    private final IWorldPosCallable canInteractWithCallable;
    private final PlayerEntity playerEntity;

    public DataTransferInterfaceContainer(final int windowid, final PlayerInventory PInventory, final DataTransferInterfaceTileEntity dataTransferInterfaceTileEntity) {
        super(ModContainerTypes.DATA_TRANSFER_INTERFACE_CONTAINER.get(), windowid);
        this.dataTransferInterfaceTileEntity = dataTransferInterfaceTileEntity;
        this.playerEntity = PInventory.player;
        this.canInteractWithCallable = IWorldPosCallable.of(dataTransferInterfaceTileEntity.getWorld(), dataTransferInterfaceTileEntity.getPos());
    }

    public DataTransferInterfaceContainer(final int windowid, final PlayerInventory inven, final PacketBuffer data) {
        this(windowid, inven, getBlockTE(inven, data));
    }

    private static DataTransferInterfaceTileEntity getBlockTE(final PlayerInventory inventory, final PacketBuffer data) {
        Objects.requireNonNull(inventory, "player inventory can't be null");
        Objects.requireNonNull(data, "data can't be null");
        final TileEntity tileAtPos = inventory.player.world.getTileEntity(data.readBlockPos());
        if (tileAtPos instanceof DataTransferInterfaceTileEntity) {
            return (DataTransferInterfaceTileEntity) tileAtPos;
        } else {
            throw new IllegalStateException("TileEntity isn't correct" + tileAtPos);
        }
    }

    @Override
    public boolean canInteractWith(@Nonnull PlayerEntity playerIn) {
        return isWithinUsableDistance(canInteractWithCallable, playerIn, ModBlocks.DATA_TRANSFER_INTERFACE.get());
    }

    public DataTransferInterfaceTileEntity getDataTransferInterfaceTileEntity() {
        return dataTransferInterfaceTileEntity;
    }
*/
}
