package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public interface ClientToServerPacket {
    void receive(final MinecraftServer server, final ServerPlayerEntity player, final ServerPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender packetSender);
}
