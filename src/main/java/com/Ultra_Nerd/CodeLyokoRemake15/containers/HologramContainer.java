package com.Ultra_Nerd.CodeLyokoRemake15.containers;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModContainerTypes;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.HologramProjectorTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

import javax.annotation.Nonnull;
import java.util.Objects;

public class HologramContainer extends Container {
    private TileEntity te;
    private final IWorldPosCallable canInteractWithCallable;

    public HologramContainer(int windowid, PlayerInventory inventory, HologramProjectorTileEntity te) {
        super(ModContainerTypes.HOLOGRAM_CONTAINER.get(), windowid);
        this.te = te;
        this.canInteractWithCallable = IWorldPosCallable.of(te.getWorld(), te.getPos());
    }

    @Override
    public boolean canInteractWith(@Nonnull PlayerEntity playerIn) {
        return isWithinUsableDistance(canInteractWithCallable, playerIn, ModBlocks.HOLOPROJECTOR.get());
    }


    public HologramContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
        this(windowId, playerInventory, getHoloEntity(playerInventory, data));
    }

    private static HologramProjectorTileEntity getHoloEntity(final PlayerInventory inventory, final PacketBuffer data) {
        Objects.requireNonNull(inventory, "player inventory can't be null");
        Objects.requireNonNull(data, "data can't be null");
        final TileEntity tileAtPos = inventory.player.world.getTileEntity(data.readBlockPos());
        if (tileAtPos instanceof HologramProjectorTileEntity) {
            return (HologramProjectorTileEntity) tileAtPos;
        } else {
            throw new IllegalStateException("TileEntity isn't correct" + tileAtPos);
        }
    }

}
