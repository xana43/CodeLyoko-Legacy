package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.SuperCalculator.ControlPanel;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public record PacketHandlerCommon() {
    public static final Identifier ChannelID = CodeLyokoMain.CodeLyokoPrefix("control_panel_packet");

    public static void CommonChannelRegistry() {
        ServerPlayNetworking.registerGlobalReceiver(ChannelID, (server, player, handler, buf, responseSender) -> {


            final BlockPos pos = buf.readBlockPos();
            final boolean active = buf.readBoolean();

            server.execute(() -> player.world.setBlockState(pos, player.world.getBlockState(pos).with(ControlPanel.ScreenOn, active)));

        });
    }
}
