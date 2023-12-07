package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.test;

import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.ComputerInterfaceScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlockEntities;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public final class ComputerInterfaceTestTE extends BlockEntity implements ExtendedScreenHandlerFactory,
        NamedScreenHandlerFactory {
    public ComputerInterfaceTestTE(final BlockPos pos, final BlockState state) {
        super(ModBlockEntities.COMPUTER_INTERFACE_TEST_TE_BLOCK_ENTITY_TYPE, pos, state);
    }

    @Override
    public void writeScreenOpeningData(final ServerPlayerEntity player, final PacketByteBuf buf) {
        buf.writeBlockPos(pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.empty();
    }



    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return this.createNbt();
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(final int syncId, final PlayerInventory inv, final PlayerEntity player) {
        return new ComputerInterfaceScreenHandler(syncId, player);
    }
}
