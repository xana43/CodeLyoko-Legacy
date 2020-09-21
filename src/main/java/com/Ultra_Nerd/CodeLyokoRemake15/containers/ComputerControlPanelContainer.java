package com.Ultra_Nerd.CodeLyokoRemake15.containers;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModContainerTypes;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.ComputerControlPanelTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

import javax.annotation.Nonnull;
import java.util.Objects;

public class ComputerControlPanelContainer extends Container {
    public final ComputerControlPanelTileEntity ControlPanelEntity;
    private final IWorldPosCallable canInteractWithCallable;

    public ComputerControlPanelContainer(final int windowid, final PlayerInventory PInventory, final ComputerControlPanelTileEntity PanelEntity) {
        super(ModContainerTypes.COMPUTER_CONTROL_PANEL_CONTAINER.get(), windowid);
        this.ControlPanelEntity = PanelEntity;
        this.canInteractWithCallable = IWorldPosCallable.of(PanelEntity.getWorld(), PanelEntity.getPos());
    }

    public ComputerControlPanelContainer(final int windowid, final PlayerInventory inven, final PacketBuffer data) {
        this(windowid, inven, getControlEntity(inven, data));
    }

    private static ComputerControlPanelTileEntity getControlEntity(final PlayerInventory inventory, final PacketBuffer data) {
        Objects.requireNonNull(inventory, "player inventory can't be null");
        Objects.requireNonNull(data, "data can't be null");
        final TileEntity tileAtPos = inventory.player.world.getTileEntity(data.readBlockPos());
        if (tileAtPos instanceof ComputerControlPanelTileEntity) {
            return (ComputerControlPanelTileEntity) tileAtPos;
        } else {
            throw new IllegalStateException("TileEntity isn't correct" + tileAtPos);
        }
    }

    @Override
    public boolean canInteractWith(@Nonnull PlayerEntity playerIn) {
        return isWithinUsableDistance(canInteractWithCallable, playerIn, ModBlocks.COMPUTER_TOWER_CONTROL_PANEL.get());
    }

}
