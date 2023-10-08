package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ClientToServer;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle.LyokoVehicleEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ClientToServerPacket;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public class CustomUpAndDownKeybindingC2SPacket implements ClientToServerPacket {
    public static final CustomUpAndDownKeybindingC2SPacket INSTANCE = new CustomUpAndDownKeybindingC2SPacket();
    @Override
    public void receive(final MinecraftServer server, final ServerPlayerEntity player, final ServerPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender packetSender) {
                final int upDown = buf.readInt();
                server.execute(() -> {
                if(player.getVehicle() instanceof final LyokoVehicleEntity lyokoVehicleEntity)
                {
                        if(upDown == 1)
                        {
                            lyokoVehicleEntity.setMovingUp(true);
                            lyokoVehicleEntity.setMovingDown(false);
                        }
                        else if(upDown == 0) {
                            lyokoVehicleEntity.setMovingDown(true);
                            lyokoVehicleEntity.setMovingUp(false);
                        }

                }

            });
    }
}
