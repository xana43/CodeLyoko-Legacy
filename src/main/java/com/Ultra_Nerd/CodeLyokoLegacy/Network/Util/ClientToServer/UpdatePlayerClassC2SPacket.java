package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ClientToServer;

import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

import static com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.PacketHandler.ClassScreenID;

public record UpdatePlayerClassC2SPacket(){



    public static void receive(final MinecraftServer server, final ServerPlayerEntity player, final ServerPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender packetSender) {
        final int newPlayerClass = buf.readInt();
        server.execute(() -> {
            CardinalData.LyokoClass.setLyokoClass(player, newPlayerClass);
            final PacketByteBuf ByteBuf = PacketByteBufs.create();
            ByteBuf.writeInt(newPlayerClass);
            ServerPlayNetworking.send(player, ClassScreenID, ByteBuf);
        });
    }
}
