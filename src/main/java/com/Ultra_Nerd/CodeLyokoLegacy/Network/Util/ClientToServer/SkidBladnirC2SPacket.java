package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ClientToServer;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle.EntitySkid;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ClientToServerPacket;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public record SkidBladnirC2SPacket() implements ClientToServerPacket {
    public static final SkidBladnirC2SPacket INSTANCE = new SkidBladnirC2SPacket();
    @Override
    public void receive(final MinecraftServer server, final ServerPlayerEntity player, final ServerPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender packetSender) {
          server.execute(() -> {
              if(player.getVehicle() instanceof final EntitySkid skidbladnir)
              {
                  skidbladnir.selectHub();
              }
          });
    }
}
