package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ClientToServer;

import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Vec3d;

import java.util.UUID;

public record NinjaRayCastC2SPacket() {


    public static void receive(final MinecraftServer server, final ServerPlayerEntity player, final ServerPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender packetSender) {
        final BlockHitResult result = buf.readBlockHitResult();
        server.execute(() -> CardinalData.LyokoClass.ExtraClassData.NinjaData.pickTargetedBlock(player,result));
    }
    public static void receive2(final MinecraftServer server, final ServerPlayerEntity player, final ServerPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender packetSender) {
        server.execute(() -> CardinalData.LyokoClass.ExtraClassData.NinjaData.onDropped(player));
    }
    public static void receive3(final MinecraftServer server, final ServerPlayerEntity player, final ServerPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender packetSender) {
        final UUID entityUUID = buf.readUuid();
        final Vec3d entityPosition = buf.readVec3d();
        server.execute(() -> CardinalData.LyokoClass.ExtraClassData.NinjaData.pickTargetedEntity(player,entityUUID,entityPosition));
    }

}
