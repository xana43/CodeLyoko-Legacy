package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.SuperCalculator.ControlPanel;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public record PacketHandlerCommon() {
    public static final Identifier ChannelID = CodeLyokoMain.codeLyokoPrefix("control_panel_packet");
    public static final Identifier TowerChannelID = CodeLyokoMain.codeLyokoPrefix("tower_packet");
    public static final Identifier ComputerUIChannelID = CodeLyokoMain.codeLyokoPrefix("computer_ui_packet");
    public static void commonChannelRegistry() {
        ServerPlayNetworking.registerGlobalReceiver(ChannelID, (server, player, handler, buf, responseSender) -> {
            final BlockPos pos = buf.readBlockPos();
            final boolean active = buf.readBoolean();
            server.execute(() -> player.world.setBlockState(pos,
                    player.world.getBlockState(pos).with(ControlPanel.ScreenOn, active)));
        });
        //TODO:a way for the tower GUI to change the state of the tower
        ServerPlayNetworking.registerGlobalReceiver(TowerChannelID, (server, player, handler, buf, responseSender) -> {
            final BlockPos pos = buf.readBlockPos();
            final boolean active = buf.readBoolean();

        });
        //TODO: once the computer UI is finished make this send information through the cables to the scanners and
        // what not
        ServerPlayNetworking.registerGlobalReceiver(ComputerUIChannelID,(server, player, handler, buf,
                responseSender) -> {
            final BlockPos pos = buf.readBlockPos();
            server.execute(() -> {CodeLyokoMain.LOG.info("blockposition:" + pos);});


        });
    }
}
