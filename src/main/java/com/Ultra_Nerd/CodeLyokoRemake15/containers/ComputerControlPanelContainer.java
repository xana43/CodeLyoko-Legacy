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
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.Objects;

public class ComputerControlPanelContainer implements Container {
    public final ComputerControlPanelTileEntity ControlPanelEntity;
    private final IWorldPosCallable canInteractWithCallable;

    public ComputerControlPanelContainer(final int windowid, final Inventory PInventory, final ComputerControlPanelTileEntity PanelEntity) {
        super(ModContainerTypes.COMPUTER_CONTROL_PANEL_CONTAINER.get(), windowid);
        this.ControlPanelEntity = PanelEntity;
        this.canInteractWithCallable = IWorldPosCallable.of(PanelEntity.getWorld(), PanelEntity.getPos());
    }

    public ComputerControlPanelContainer(final int windowid, final Inventory inven, final PacketBuffer data) {
        this(windowid, inven, getControlEntity(inven, data));
    }

    private static ComputerControlPanelTileEntity getControlEntity(final Inventory inventory, final PacketBuffer data) {
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
    public boolean canInteractWith(@Nonnull Player playerIn) {
        return isWithinUsableDistance(canInteractWithCallable, playerIn, ModBlocks.COMPUTER_TOWER_CONTROL_PANEL.get());
    }

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
}
