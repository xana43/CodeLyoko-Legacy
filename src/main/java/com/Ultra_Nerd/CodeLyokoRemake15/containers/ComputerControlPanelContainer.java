package com.Ultra_Nerd.CodeLyokoRemake15.containers;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModContainerTypes;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.ComputerControlPanelTileEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.block.entity.BlockEntity;

import javax.annotation.Nonnull;
import java.util.Objects;

public class ComputerControlPanelContainer extends AbstractContainerMenu  {
    public final ComputerControlPanelTileEntity ControlPanelEntity;
    //private final BlockEntityType.BlockEntitySupplier canInteractWithCallable;

    public ComputerControlPanelContainer(final int windowid, final Inventory PInventory, final ComputerControlPanelTileEntity PanelEntity) {
        super(ModContainerTypes.COMPUTER_CONTROL_PANEL_CONTAINER.get(), windowid);
        this.ControlPanelEntity = PanelEntity;
        //this.canInteractWithCallable = (PanelEntity.getBlockPos(), PanelEntity.getBlockState());
    }

    public ComputerControlPanelContainer(final int windowid, final Inventory inven, final FriendlyByteBuf data) {
        this(windowid, inven, getControlEntity(inven, data));
    }

    private static ComputerControlPanelTileEntity getControlEntity(final Inventory inventory, final FriendlyByteBuf data) {
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
* */
    @Override
    public boolean stillValid(@Nonnull Player playerIn) {
        return stillValid(ContainerLevelAccess.create(Objects.requireNonNull(ControlPanelEntity.getLevel()),ControlPanelEntity.getBlockPos()), playerIn, ModBlocks.COMPUTER_TOWER_CONTROL_PANEL.get());
    }


}
