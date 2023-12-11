package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ClientToServer;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.VehicleEntities.LyokoVehicleEntity;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public record CustomVehicleKeybindingsC2SPacket() {

    public static void vehicleVerticalMovement(final MinecraftServer server, final ServerPlayerEntity player, final ServerPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender packetSender) {
                final int upDown = buf.readInt();
                server.execute(() -> {
                if(player.getVehicle() instanceof final LyokoVehicleEntity lyokoVehicleEntity) {
                        if(upDown == 1) {
                            lyokoVehicleEntity.moveUp();
                        }
                        else if(upDown == 0) {
                            lyokoVehicleEntity.moveDown();
                        }

                }

            });
    }
    public static void vehicleHover(final MinecraftServer server, final ServerPlayerEntity player, final ServerPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender packetSender) {

        server.execute(() -> {
            if(player.getVehicle() instanceof final LyokoVehicleEntity lyokoVehicleEntity) {
               lyokoVehicleEntity.toggleHover();
            }

        });
    }
}
