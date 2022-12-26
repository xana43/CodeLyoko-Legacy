package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.SuperCalculator.ControlPanel;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import dev.onyxstudios.cca.api.v3.level.LevelComponents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public record PacketHandlerCommon() {
    public static final Identifier ChannelID = CodeLyokoMain.codeLyokoPrefix("control_panel_packet");
    public static final Identifier TowerChannelID = CodeLyokoMain.codeLyokoPrefix("tower_packet");
    public static final Identifier ComputerUIChannelID = CodeLyokoMain.codeLyokoPrefix("computer_ui_packet");
    public static final Identifier ClassScreenID = CodeLyokoMain.codeLyokoPrefix("class_screen");
    public static final Identifier ClassScreenIDClient = CodeLyokoMain.codeLyokoPrefix("class_screen_to_client");
    public static final Identifier REFRESH = CodeLyokoMain.codeLyokoPrefix("refresh_data");
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
            final int activationState = buf.readInt();
            server.execute(() -> player.world.getBlockEntity(pos, ModTileEntities.TOWER_INTERFACE_TILE_ENTITY).get().calculateTowerActivation(activationState));

        });
        //TODO: once the computer UI is finished make this send information through the cables to the scanners and
        // what not
        ServerPlayNetworking.registerGlobalReceiver(ComputerUIChannelID,(server, player, handler, buf,
                responseSender) -> {
            //final BlockPos pos = buf.readBlockPos();
            server.execute(() -> {
                CardinalData.PlayerSavedProfile.saveProfile(server.getSaveProperties().getMainWorldProperties(),
                        player);
                CardinalData.PlayerSavedProfile.getPlayerProfile(server.getSaveProperties().getMainWorldProperties(),
                        player).refreshPlayerClass();
            });


        });
        ServerPlayNetworking.registerGlobalReceiver(ClassScreenID,(server, player, handler, buf, responseSender) -> {
            final int newPlayerClass = buf.readInt();
            server.execute(() -> {
                CodeLyokoMain.LOG.info("setting new class on server");
                CardinalData.LyokoClass.setLyokoclass(player,newPlayerClass);
                final PacketByteBuf ByteBuf = PacketByteBufs.create();
                ByteBuf.writeInt(newPlayerClass);
                ServerPlayNetworking.send(player,ClassScreenIDClient,ByteBuf);
            });
        });


    }
}
