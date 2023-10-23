package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ServerToClient;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;

public record SyncTriplicateEntityS2CPacket() {


    public static void receive(final MinecraftClient client, final ClientPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender responseSender) {
        CodeLyokoMain.LOG.error("something");
        client.execute(() -> {
            CodeLyokoMain.LOG.error("sent something to the client");
        });
    }
}
