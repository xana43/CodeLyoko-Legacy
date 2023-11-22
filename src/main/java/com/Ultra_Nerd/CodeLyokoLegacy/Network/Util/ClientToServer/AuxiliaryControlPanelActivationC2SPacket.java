package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ClientToServer;

import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.SuperCalculator.ControlPanel;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;

public record AuxiliaryControlPanelActivationC2SPacket() {

    public static void receive(final MinecraftServer server, final ServerPlayerEntity player, final ServerPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender packetSender) {
        final BlockPos pos = buf.readBlockPos();
        final boolean active = buf.readBoolean();
        server.execute(() -> player.getWorld().setBlockState(pos,
                player.getWorld().getBlockState(pos).with(ControlPanel.ScreenOn, active)));
    }
}
