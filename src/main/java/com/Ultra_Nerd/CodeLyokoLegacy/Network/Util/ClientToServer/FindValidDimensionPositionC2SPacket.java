package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ClientToServer;

import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public record FindValidDimensionPositionC2SPacket() {


    public static void receive(final MinecraftServer server, final ServerPlayerEntity player, final ServerPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender packetSender) {
        final RegistryKey<World> recievedRegistryKey = buf.readRegistryKey(RegistryKeys.WORLD);
        server.execute(() -> {


            final ServerWorld serverWorld = server.getWorld(recievedRegistryKey);
            final BlockPos validPosition = MethodUtil.HelperMethods.getValidPosition(serverWorld, player.getHeight());
            if(validPosition != null && serverWorld != null) {
                player.teleport(serverWorld, validPosition.getX(), validPosition.getY(), validPosition.getZ(), player.getYaw(), player.getPitch());

            }

        });
    }

}
