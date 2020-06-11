package elsopeen.lyokomod.container;

import elsopeen.lyokomod.init.ModContainerTypes;
import elsopeen.lyokomod.tileentity.InterfaceTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;

import java.util.Objects;

/**
 * Interface Container to get custom screen with text and all
 * Mainly inspired of Cadiboo's example mod
 */
public class InterfaceContainer extends Container {

    public final InterfaceTileEntity interfaceTileEntity;

    /**
     * Useful constructor in outside classes
     * @param windowId
     * @param playerInventory
     * @param data
     */
    public InterfaceContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
        this(windowId, playerInventory, getTileEntity(playerInventory, data));
    }

    /**
     * Constructor that uses super
     * @param windowId
     * @param playerInventory
     * @param tileEntity
     */
    public InterfaceContainer(final int windowId, final PlayerInventory playerInventory, final InterfaceTileEntity tileEntity) {
        super(ModContainerTypes.INTERFACE_CONTAINER.get(), windowId);
        this.interfaceTileEntity = tileEntity;
    }

    /**
     * Get tileEntity from playerInv and packet
     * @param playerInventory
     * @param data
     * @return
     */
    private static InterfaceTileEntity getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data) {
        Objects.requireNonNull(playerInventory, "playerInventory cannot be null!");
        Objects.requireNonNull(data, "data cannot be null!");
        final TileEntity tileAtPos = playerInventory.player.world.getTileEntity(data.readBlockPos());
        if (tileAtPos instanceof InterfaceTileEntity)
            return (InterfaceTileEntity) tileAtPos;
        throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
    }



    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return true;
    }
}
