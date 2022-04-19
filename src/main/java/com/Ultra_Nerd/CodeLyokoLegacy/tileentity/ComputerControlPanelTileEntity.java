package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.containers.ComputerControlPanelContainer;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class ComputerControlPanelTileEntity extends BlockEntity implements MenuProvider {

    // May be accessed before onLoad
    @OnlyIn(Dist.CLIENT)
    private int PlayersPresent;

    public ComputerControlPanelTileEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        super(ModTileEntities.COMPUTER_CONTROL_PANEL_TILE_ENTITY.get(),pos,state);
    }
/*
    public ComputerControlPanelTileEntity() {
        this(ModTileEntities.COMPUTER_CONTROL_PANEL_TILE_ENTITY.get());
    }*/




    @Override
    public @NotNull AABB getRenderBoundingBox() {
        // This, combined with isGlobalRenderer in the TileEntityRenderer makes it so that the
        // render does not disappear if the player can't see the block
        // This is useful for rendering larger models or dynamically sized models
        return INFINITE_EXTENT_AABB;
    }


    @Override
    public void onDataPacket(Connection net, @NotNull ClientboundBlockEntityDataPacket pkt) {
        CompoundTag tag = pkt.getTag();
    }

    @Override
    public @NotNull CompoundTag getTileData() {
        return super.getTileData();
    }


    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        CompoundTag nbtTag = new CompoundTag();
        return super.getUpdatePacket();//new ClientGamePacketListener(getBlockPos(), -1, nbtTag);
    }




    /**
     * @return display name of the interface
     */
    @Nonnull
    @Override
    public Component getDisplayName() {
        return new TranslatableComponent(ModBlocks.COMPUTER_TOWER_CONTROL_PANEL.get().getName().toString());
    }

    /**
     * Create a containder from interfaceTileEntity
     *
     * @param windowIn     Id of GUI
     * @param playerInv    Inventory of interacting player
     * @param playerEntity PlayerEntity of interacting player
     * @return Gui container
     */
    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int windowIn, @Nonnull Inventory playerInv, @Nonnull Player playerEntity) {
        return new ComputerControlPanelContainer(windowIn, playerInv, this);
    }


    @Override
    public boolean triggerEvent(int id, int type) {
        if (id == 1) {
            this.PlayersPresent = type;
            return true;
        } else {
            return super.triggerEvent(id, type);
        }
    }



}
