package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ClientToServer.TestPackets;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.SamuraiClass.ServerTriplicateCloneEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModEntities;
import com.mojang.authlib.GameProfile;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public record ClonePlayerC2SPacket() {


    public static void receive(final MinecraftServer server, final ServerPlayerEntity player, final ServerPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender packetSender) {

            final GameProfile profile = buf.readGameProfile();
            server.execute(() -> {
                if(ModEntities.TRIPLICATE_ENTITY_TYPE != null) {
                    final ServerTriplicateCloneEntity clone = ModEntities.TRIPLICATE_ENTITY_TYPE.create(player.getWorld());
                    if (clone != null) {
                        clone.setOwner(profile, server);
                    }
                    player.getWorld().spawnEntity(clone);
                }
            });
    }
}
