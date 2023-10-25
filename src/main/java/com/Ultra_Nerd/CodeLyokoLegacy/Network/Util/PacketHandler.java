package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ClientToServer.*;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ClientToServer.TestPackets.ClonePlayerC2SPacket;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ClientToServer.TestPackets.TestCloneC2SPacket;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ServerToClient.*;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.TestScreens.VehicleMaterializationTest;
import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public record PacketHandler() {
    public static final Identifier ChannelID = CodeLyokoMain.codeLyokoPrefix("control_panel_packet");
    public static final Identifier TowerChannelID = CodeLyokoMain.codeLyokoPrefix("tower_packet");
    public static final Identifier ComputerUIChannelID = CodeLyokoMain.codeLyokoPrefix("computer_ui_packet");
    public static final Identifier ClassScreenID = CodeLyokoMain.codeLyokoPrefix("class_screen");
    public static final Identifier PRIMARY_CLASS_ABILITY = CodeLyokoMain.codeLyokoPrefix("class_ability_primary");
    public static final Identifier SECONDARY_CLASS_ABILITY = CodeLyokoMain.codeLyokoPrefix("class_ability_secondary");
    public static final Identifier REFRESH = CodeLyokoMain.codeLyokoPrefix("refresh_data");
    public static final Identifier PLAYER_QUERY = CodeLyokoMain.codeLyokoPrefix("query_players");
    public static final Identifier PLAYER_QUERY_SERVER = CodeLyokoMain.codeLyokoPrefix("send_query_to_server");
    public static final Identifier KEYBOARD_UPDATE = CodeLyokoMain.codeLyokoPrefix("keyboard_update");
    public static final Identifier SKID_BLADNIR_UPDATE = CodeLyokoMain.codeLyokoPrefix("skidbladnir_update");
    public static final Identifier RENAME_BLOCK_ENTITY = CodeLyokoMain.codeLyokoPrefix("rename_block_entity");
    public static final Identifier SPAWN_TRIPLICATE = CodeLyokoMain.codeLyokoPrefix("spawn_triplicate");
    public static final Identifier SYNC_SCANNER_PARTICLES = CodeLyokoMain.codeLyokoPrefix("scanner_particles");
    public static final Identifier TEST_TRIPILCATE_CLIENT_SPAWN = CodeLyokoMain.codeLyokoPrefix("triplicate");
    public static final Identifier OPEN_BOOK_ON_CLIENT = CodeLyokoMain.codeLyokoPrefix("open_book_on_client");
    public static final Identifier OPEN_LAPTOP_ON_CLIENT = CodeLyokoMain.codeLyokoPrefix("open_laptop_on_client");
    public static final Identifier TEST = CodeLyokoMain.codeLyokoPrefix("test");
    public static void commonChannelRegistry() {


        CodeLyokoMain.LOG.error("loading server receivers");
        ServerPlayNetworking.registerGlobalReceiver(ChannelID, AuxiliaryControlPanelActivationC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(TowerChannelID, TowerActivationC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(RENAME_BLOCK_ENTITY, ChangeNameC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(SPAWN_TRIPLICATE, ClonePlayerC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(TEST_TRIPILCATE_CLIENT_SPAWN, TestCloneC2SPacket::receive);
        //TODO: once the computer UI is finished make this send information through the cables to the scanners and
        // what not
        ServerPlayNetworking.registerGlobalReceiver(SKID_BLADNIR_UPDATE, SkidBladnirC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(ComputerUIChannelID,
                (server, player, handler, buf, responseSender) -> server.execute(() -> CardinalData.PlayerSavedProfile.getPlayerProfile(
                        server.getSaveProperties().getMainWorldProperties(), player).refreshPlayerClass()));
        ServerPlayNetworking.registerGlobalReceiver(ClassScreenID, UpdatePlayerClassC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(PRIMARY_CLASS_ABILITY, ClassEffectC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(SECONDARY_CLASS_ABILITY, ClassEffectC2SPacket::receiveSecondary);
        ServerPlayNetworking.registerGlobalReceiver(KEYBOARD_UPDATE, CustomUpAndDownKeybindingC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(PLAYER_QUERY_SERVER,(server, player, handler, buf,
                responseSender) -> server.execute(() -> ServerPlayNetworking.send(player,PLAYER_QUERY,
                    PacketByteBufs.empty())));
        ServerPlayNetworking.registerGlobalReceiver(SYNC_SCANNER_PARTICLES, SpawnScannerParticlesC2SPacket::receive);
    }
    @Environment(EnvType.CLIENT)
    public static void clientPacketRegistry() {
        CodeLyokoMain.LOG.error("loading client receivers");
        ClientPlayNetworking.registerGlobalReceiver(OPEN_LAPTOP_ON_CLIENT,OpenLaptopScreenS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(OPEN_BOOK_ON_CLIENT, OpenBookS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(REFRESH, RenamableBlockEntityNameUpdateS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(ClassScreenID, ClassScreenS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(SYNC_SCANNER_PARTICLES, SpawnScannerParticlesS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(PLAYER_QUERY,(client, handler, buf,
                                                                  responseSender) -> client.execute(() -> {
                    if(client.currentScreen instanceof VehicleMaterializationTest test)
                    {
                        VehicleMaterializationTest.setPlayerList(handler.getPlayerList().stream().toList());
                    }
                }));

    }
}