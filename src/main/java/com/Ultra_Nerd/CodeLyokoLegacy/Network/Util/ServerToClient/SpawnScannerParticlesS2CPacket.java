package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ServerToClient;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.common.ModParticles;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.math.BlockPos;

public record SpawnScannerParticlesS2CPacket() {


    public static void receive(final MinecraftClient client, final ClientPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender responseSender) {
        final BlockPos pos = buf.readBlockPos();
        final float offset = buf.readFloat();
        client.execute(() -> {
            final ClientWorld world = client.world;
            if(world != null) {
                switch (client.options.getParticles().getValue()) {
                    case ALL -> {
                        for (int i = 0; i < 200; i++) {
                            world.addParticle(ModParticles.RING_PARTICLE, pos.getX(), pos.getY() + offset,
                                    pos.getZ() + 0.5f, 0, 0, 0);

                        }
                    }
                    case DECREASED -> {
                        for (byte i = 0; i < 100; i++) {
                            world.addParticle(ModParticles.RING_PARTICLE, pos.getX(), pos.getY() + offset,
                                    pos.getZ() + 0.5f, 0, 0, 0);
                        }

                    }
                    case MINIMAL -> {
                        for (byte i = 0; i < 50; i++) {
                            world.addParticle(ModParticles.RING_PARTICLE, pos.getX(), pos.getY() + offset,
                                    pos.getZ() + 0.5f, 0, 0, 0);
                        }
                    }
                }
            }
        });
    }
}
