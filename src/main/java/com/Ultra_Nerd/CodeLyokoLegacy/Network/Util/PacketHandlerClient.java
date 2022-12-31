package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.TestScreens.VehicleMaterializationTest;
import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.network.ClientPlayNetworkHandler;

public record PacketHandlerClient() {


    public static void clientPacketRegistry() {
        ClientPlayNetworking.registerGlobalReceiver(PacketHandlerCommon.ClassScreenIDClient,(client, handler, buf,
                responseSender) -> {
            final int clientPlayerClass = buf.readInt();
            client.execute(() -> {
                CodeLyokoMain.LOG.info("setting new class on client");
                CardinalData.LyokoClass.setLyokoclass(client.player, clientPlayerClass);
            });
        });
        ClientPlayNetworking.registerGlobalReceiver(PacketHandlerCommon.PLAYER_QUERY,(client, handler, buf,
                responseSender) -> client.execute(() -> {
                    if(client.currentScreen instanceof VehicleMaterializationTest test)
                    {
                        test.setPlayerList(handler.getPlayerList().stream().toList());
                    }
                }));
    }

}
