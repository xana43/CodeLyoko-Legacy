package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util;

import com.Ultra_Nerd.CodeLyokoLegacy.screens.TestScreens.VehicleMaterializationTest;
import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.minecraft.util.math.BlockPos;

public record PacketHandlerClient() {


    public static void clientPacketRegistry() {
        ClientPlayNetworking.registerGlobalReceiver(PacketHandlerCommon.ClassScreenIDClient,(client, handler, buf,
                responseSender) -> {
            final int clientPlayerClass = buf.readInt();
            client.execute(() -> {
                CardinalData.LyokoClass.setLyokoclass(client.player, clientPlayerClass);
            });
        });
        ClientPlayNetworking.registerGlobalReceiver(PacketHandlerCommon.PLAYER_QUERY,(client, handler, buf,
                responseSender) -> client.execute(() -> {
                    if(client.currentScreen instanceof VehicleMaterializationTest test)
                    {
                        VehicleMaterializationTest.setPlayerList(handler.getPlayerList().stream().toList());
                    }
                }));
        ClientPlayNetworking.registerGlobalReceiver(PacketHandlerCommon.FLUID_UPDATE,(client, handler, buf,
                responseSender) -> {
            final FluidVariant variant = FluidVariant.fromPacket(buf);
            final long fluidLevel = buf.readLong();
            final BlockPos pos = buf.readBlockPos();

        });
    }

}
