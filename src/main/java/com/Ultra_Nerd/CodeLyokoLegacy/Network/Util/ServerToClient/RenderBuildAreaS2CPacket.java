package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ServerToClient;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.hit.BlockHitResult;

public record RenderBuildAreaS2CPacket() {
//TODO: figure out how to create a holographic like area to show where the guardian's build ability is going to go
    public static void receive(final MinecraftClient client, final ClientPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender responseSender) {
        final BlockHitResult hitResult = buf.readBlockHitResult();
        final int width = buf.readInt();
        final int length = buf.readInt();

        client.execute(() -> {


        });
    }



}
