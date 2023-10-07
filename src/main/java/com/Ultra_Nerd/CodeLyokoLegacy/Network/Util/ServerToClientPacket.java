package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;

public interface ServerToClientPacket {
    void receive(final MinecraftClient client, final ClientPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender responseSender);
}
