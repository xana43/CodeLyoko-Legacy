package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ClientToServer.ClassEffectC2SPacket;
import com.Ultra_Nerd.CodeLyokoLegacy.blocks.SuperCalculator.ControlPanel;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
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
    public static final Identifier PRIMARY_CLASS_ABILITY = CodeLyokoMain.codeLyokoPrefix("class_ability_primary");
    public static final Identifier SECONDARY_CLASS_ABILITY = CodeLyokoMain.codeLyokoPrefix("class_ability_secondary");
    public static final Identifier REFRESH = CodeLyokoMain.codeLyokoPrefix("refresh_data");
    public static final Identifier PLAYER_QUERY = CodeLyokoMain.codeLyokoPrefix("query_players");
    public static final Identifier PLAYER_QUERY_SERVER = CodeLyokoMain.codeLyokoPrefix("send_query_to_server");
    public static final Identifier FLUID_UPDATE = CodeLyokoMain.codeLyokoPrefix("fluid_update");
    public static void commonChannelRegistry() {



        ServerPlayNetworking.registerGlobalReceiver(ChannelID, (server, player, handler, buf, responseSender) -> {
            final BlockPos pos = buf.readBlockPos();
            final boolean active = buf.readBoolean();
            server.execute(() -> player.getWorld().setBlockState(pos,
                    player.getWorld().getBlockState(pos).with(ControlPanel.ScreenOn, Boolean.valueOf(active))));
        });
        ServerPlayNetworking.registerGlobalReceiver(TowerChannelID, (server, player, handler, buf, responseSender) -> {
            final BlockPos pos = buf.readBlockPos();
            final int activationState = buf.readInt();
            server.execute(() -> player.getWorld().getBlockEntity(pos, ModBlockEntities.TOWER_INTERFACE_TILE_ENTITY).get()
                    .calculateTowerActivation(activationState));

        });
        //TODO: once the computer UI is finished make this send information through the cables to the scanners and
        // what not
        ServerPlayNetworking.registerGlobalReceiver(ComputerUIChannelID,
                (server, player, handler, buf, responseSender) -> {
                    server.execute(() -> {
                        CardinalData.PlayerSavedProfile.getPlayerProfile(
                                server.getSaveProperties().getMainWorldProperties(), player).refreshPlayerClass();
                    });


                });
        ServerPlayNetworking.registerGlobalReceiver(ClassScreenID, (server, player, handler, buf, responseSender) -> {
            final int newPlayerClass = buf.readInt();
            server.execute(() -> {
                CardinalData.LyokoClass.setLyokoClass(player, newPlayerClass);
                final PacketByteBuf ByteBuf = PacketByteBufs.create();
                ByteBuf.writeInt(newPlayerClass);
                ServerPlayNetworking.send(player, ClassScreenIDClient, ByteBuf);
            });
        });
        ServerPlayNetworking.registerGlobalReceiver(PRIMARY_CLASS_ABILITY, ClassEffectC2SPacket.INSTANCE::receive);

        ServerPlayNetworking.registerGlobalReceiver(SECONDARY_CLASS_ABILITY,
                (server, player, handler, buf, responseSender) -> {
                    CodeLyokoMain.LOG.info("secondary used");
                });
        ServerPlayNetworking.registerGlobalReceiver(PLAYER_QUERY_SERVER,(server, player, handler, buf,
                responseSender) -> server.execute(() -> ServerPlayNetworking.send(player,PLAYER_QUERY,
                    PacketByteBufs.empty())));

    }
}
