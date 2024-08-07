package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ClientToServer;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.CardinalData;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.payloads.ClassScreenPayload;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public record UpdatePlayerClassC2SPacket(){



    public static void receive(final ClassScreenPayload payload,final ServerPlayNetworking.Context context) {
        final int newPlayerClass = payload.classInt();
        CardinalData.LyokoClass.setLyokoClass(context.player(), newPlayerClass);
        final ClassScreenPayload newPayload = new ClassScreenPayload(newPlayerClass);
        ServerPlayNetworking.send(context.player(), newPayload);

    }
}
