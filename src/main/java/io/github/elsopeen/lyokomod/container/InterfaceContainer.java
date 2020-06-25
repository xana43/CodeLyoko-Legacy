package io.github.elsopeen.lyokomod.container;

import io.github.elsopeen.lyokomod.init.ModContainerTypes;
import io.github.elsopeen.lyokomod.tileentity.InterfaceTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;

import javax.annotation.Nonnull;
import java.util.Objects;

/**
 * Interface Container to get custom screen with text and all
 * Mainly inspired of Cadiboo's example mod
 */
public class InterfaceContainer extends Container {

    public final InterfaceTileEntity interfaceTileEntity;

    /**
     * Useful constructor in outside classes
     * @param windowId the id of the container
     * @param playerInventory the playerInv of the player using this container
     * @param data the data sent when this container is used.
     */
    public InterfaceContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
        this(windowId, playerInventory, getTileEntity(playerInventory, data));
    }

    /**
     * Constructor that uses super
     * @param windowId the id of the container
     * @param playerInventory the playerInv of the player using this container
     * @param tileEntity the tileEntity of this container
     */
    public InterfaceContainer(final int windowId, final PlayerInventory playerInventory, final InterfaceTileEntity tileEntity) {
        super(ModContainerTypes.INTERFACE_CONTAINER.get(), windowId);
        this.interfaceTileEntity = tileEntity;
    }

    /**
     * Get tileEntity from playerInv and packet
     * @param playerInventory playerInv from which to get the world
     * @param data Data from which to get the pos
     * @return the tileEntity linked to the block used
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
    public boolean canInteractWith(@Nonnull PlayerEntity playerIn) {
        return true;
    }
}
