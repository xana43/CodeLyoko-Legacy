package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ServerToClient;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.CardinalData;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.payloads.ClassScreenPayload;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public record ClassScreenS2CPacket() {


    public static void receive(final ClassScreenPayload handler, final ClientPlayNetworking.Context context)
    {
        final int clientPlayerClass = handler.classInt();

        context.client().execute(() -> CardinalData.LyokoClass.setLyokoClass(context.player(), clientPlayerClass));
    }
}
