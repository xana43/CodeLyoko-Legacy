package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ServerToClient;

import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ServerToClientPacket;
import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;

public record ClassScreenS2CPacket() implements ServerToClientPacket {
    public static final ClassScreenS2CPacket INSTANCE = new ClassScreenS2CPacket();
    @Override
    public void receive(final MinecraftClient client, final ClientPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender responseSender)
    {

        final int clientPlayerClass = buf.readInt();
        client.execute(() -> CardinalData.LyokoClass.setLyokoClass(client.player, clientPlayerClass));
    }
}
