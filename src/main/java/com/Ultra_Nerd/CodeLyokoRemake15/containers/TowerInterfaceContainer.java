package com.Ultra_Nerd.CodeLyokoRemake15.containers;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModContainerTypes;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.TowerInterfaceTileEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.Position;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.PacketBuffer;
import net.minecraft.server.WorldStem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.world.Container;
import net.minecraft.world.WorldlyContainerHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.storage.WorldData;

import java.util.Objects;

public class TowerInterfaceContainer extends AbstractContainerMenu {
    public final TowerInterfaceTileEntity TowerEntity;


    public TowerInterfaceContainer(final int windowid, final Inventory PInventory, final TowerInterfaceTileEntity TowerEntity) {
        super(ModContainerTypes.TOWER_INTERFACE_CONTAINER.get(), windowid);
        this.TowerEntity = TowerEntity;

    }

    public TowerInterfaceContainer(final int windowid, final Inventory inven, final FriendlyByteBuf data, TowerInterfaceTileEntity towerEntity) {
        this(windowid, inven, getTowerEntity(inven, data));
    }

    private static TowerInterfaceTileEntity getTowerEntity(final Inventory inventory, final FriendlyByteBuf data) {
        Objects.requireNonNull(inventory, "player inventory can't be null");
        Objects.requireNonNull(data, "data can't be null");
        final BlockEntity tileAtPos = inventory.player.level.getBlockEntity(data.readBlockPos());
        if (tileAtPos instanceof TowerInterfaceTileEntity) {
            return (TowerInterfaceTileEntity) tileAtPos;
        } else {
            throw new IllegalStateException("TileEntity isn't correct" + tileAtPos);
        }
    }


    @Override
    public boolean stillValid(Player p_38874_) {
        return false;
    }
}

