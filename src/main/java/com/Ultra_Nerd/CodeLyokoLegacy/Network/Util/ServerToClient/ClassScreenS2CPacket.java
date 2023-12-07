package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ServerToClient;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.CardinalData;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;

public record ClassScreenS2CPacket() {


    public static void receive(final MinecraftClient client, final ClientPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender responseSender)
    {
        final int clientPlayerClass = buf.readInt();
        client.execute(() -> CardinalData.LyokoClass.setLyokoClass(client.player, clientPlayerClass));
    }
}
