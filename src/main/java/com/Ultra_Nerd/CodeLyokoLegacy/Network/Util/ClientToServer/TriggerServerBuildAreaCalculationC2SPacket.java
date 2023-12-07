package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ClientToServer;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.CardinalData;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.BlockHitResult;

public record TriggerServerBuildAreaCalculationC2SPacket() {


    public static void receive(final MinecraftServer server, final ServerPlayerEntity player, final ServerPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender packetSender) {
        final BlockHitResult hitResult = buf.readBlockHitResult();
        server.execute(() -> CardinalData.LyokoClass.ExtraClassData.GuardianData.calculatePlacementLocation(player,hitResult));
    }
}
