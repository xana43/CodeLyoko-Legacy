package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ServerToClient;

import com.Ultra_Nerd.CodeLyokoLegacy.Screens.ClientScreens.LapTopHeirarichy.MainLaptopScreen;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;

public record OpenLaptopScreenS2CPacket() {


    public static void receive(final MinecraftClient client, final ClientPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender responseSender) {
        final boolean closeOrOpen = buf.readBoolean();
        client.execute(() -> {
            if(closeOrOpen) {
                client.setScreen(new MainLaptopScreen());
            } else {
                if(client.currentScreen instanceof MainLaptopScreen)
                {
                    client.currentScreen.close();
                }
            }
        });
    }
}
