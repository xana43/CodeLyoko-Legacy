package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util;

import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ServerToClient.ClassScreenS2CPacket;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ServerToClient.FluidS2CPacket;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.TestScreens.VehicleMaterializationTest;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public record PacketHandlerClient() {


    public static void clientPacketRegistry() {
        ClientPlayNetworking.registerGlobalReceiver(PacketHandlerCommon.ClassScreenIDClient, ClassScreenS2CPacket.INSTANCE::receive);
        ClientPlayNetworking.registerGlobalReceiver(PacketHandlerCommon.PLAYER_QUERY,(client, handler, buf,
                responseSender) -> client.execute(() -> {
                    if(client.currentScreen instanceof VehicleMaterializationTest test)
                    {
                        VehicleMaterializationTest.setPlayerList(handler.getPlayerList().stream().toList());
                    }
                }));
        ClientPlayNetworking.registerGlobalReceiver(PacketHandlerCommon.FLUID_UPDATE, FluidS2CPacket.INSTANCE::receive);
    }

}
