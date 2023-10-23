package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ServerToClient;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;

import java.util.Objects;

public record RenamableBlockEntityNameUpdateS2CPacket() {


    public static void receive(final MinecraftClient client, final ClientPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender responseSender) {
            client.execute(() -> Objects.requireNonNull(client.currentScreen).close());
    }
}
