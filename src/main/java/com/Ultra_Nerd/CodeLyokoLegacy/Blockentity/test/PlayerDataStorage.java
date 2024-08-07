package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.test;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.TestHandler.ProfileDebugScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public final class PlayerDataStorage extends BlockEntity implements ExtendedScreenHandlerFactory {
    public PlayerDataStorage(final BlockPos pos, final BlockState state) {
        super(ModBlockEntities.PLAYER_DATA_STORAGE_BLOCK_ENTITY_TYPE, pos, state);
    }
    @Override
    public NbtCompound toInitialChunkDataNbt(final RegistryWrapper.WrapperLookup registryLookup) {
        return this.createNbt(registryLookup);
    }

    @Override
    public @NotNull Packet<ClientPlayPacketListener> toUpdatePacket() {
        return  BlockEntityUpdateS2CPacket.create(this);
    }


    @Override
    public Text getDisplayName() {
        return Text.empty();
    }

    @Override
    public @NotNull ScreenHandler createMenu(final int syncId, final PlayerInventory inv, final PlayerEntity player) {
        return new ProfileDebugScreenHandler(syncId,player,player.getWorld().getLevelProperties());
    }

    @Override
    public Object getScreenOpeningData(ServerPlayerEntity player) {
        return null;
    }
}
