package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ClientToServer;

import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.PacketHandler;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;

public record SpawnScannerParticlesC2SPacket() {


    public static void receive(final MinecraftServer server, final ServerPlayerEntity player, final ServerPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender packetSender) {
        final BlockPos pos = buf.readBlockPos();
        final float offset = buf.readFloat();
        server.execute(() -> {
            final PacketByteBuf clientBuf = PacketByteBufs.create();
            clientBuf.writeBlockPos(pos);
            clientBuf.writeFloat(offset);
            ServerPlayNetworking.send(player, PacketHandler.SYNC_SCANNER_PARTICLES,clientBuf);
        });
    }
}
