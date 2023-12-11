package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ClientToServer.*;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ServerToClient.*;
import com.Ultra_Nerd.CodeLyokoLegacy.Screens.TestScreens.VehicleMaterializationTest;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.CardinalData;
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

    public static final Identifier REFRESH = CodeLyokoMain.codeLyokoPrefix("refresh_data");
    public static final Identifier PLAYER_QUERY = CodeLyokoMain.codeLyokoPrefix("query_players");
    public static final Identifier PLAYER_QUERY_SERVER = CodeLyokoMain.codeLyokoPrefix("send_query_to_server");
    public static final Identifier KEYBOARD_UPDATE = CodeLyokoMain.codeLyokoPrefix("keyboard_update");
    public static final Identifier VEHICLE_HOVER = CodeLyokoMain.codeLyokoPrefix("vehicle_hover");
    public static final Identifier SKID_BLADNIR_UPDATE = CodeLyokoMain.codeLyokoPrefix("skidbladnir_update");
    public static final Identifier RENAME_BLOCK_ENTITY = CodeLyokoMain.codeLyokoPrefix("rename_block_entity");
    public static final Identifier SPAWN_TRIPLICATE = CodeLyokoMain.codeLyokoPrefix("spawn_triplicate");
    public static final Identifier SYNC_SCANNER_PARTICLES = CodeLyokoMain.codeLyokoPrefix("scanner_particles");
    public static final Identifier OPEN_BOOK_ON_CLIENT = CodeLyokoMain.codeLyokoPrefix("open_book_on_client");
    public static final Identifier OPEN_LAPTOP_ON_CLIENT = CodeLyokoMain.codeLyokoPrefix("open_laptop_on_client");
    public static final Identifier RAY_CAST = CodeLyokoMain.codeLyokoPrefix("ray_cast");
    public static final Identifier RAY_CAST_DROP = CodeLyokoMain.codeLyokoPrefix("ray_cast_drop");
    public static final Identifier RAY_CAST_ENTITY = CodeLyokoMain.codeLyokoPrefix("ray_cast_entity");
    public static final Identifier BUILD_HOLOGRAM = CodeLyokoMain.codeLyokoPrefix("build_hologram");
    public static final Identifier TOWER_SCANNER = CodeLyokoMain.codeLyokoPrefix("scan_towers");
    public static void commonChannelRegistry() {

        ServerPlayNetworking.registerGlobalReceiver(ChannelID, AuxiliaryControlPanelActivationC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(TowerChannelID, TowerActivationC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(RENAME_BLOCK_ENTITY, ChangeNameC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(SPAWN_TRIPLICATE, SpawnPlayerTriplicateC2SPacket::receive);
        //TODO: once the computer UI is finished make this send information through the cables to the scanners and
        // what not
        ServerPlayNetworking.registerGlobalReceiver(SKID_BLADNIR_UPDATE, SkidBladnirC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(ComputerUIChannelID,
                (server, player, handler, buf, responseSender) -> server.execute(() -> CardinalData.PlayerSavedProfile.getPlayerProfile(
                        server.getSaveProperties().getMainWorldProperties(), player).refreshPlayerClass()));
        ServerPlayNetworking.registerGlobalReceiver(ClassScreenID, UpdatePlayerClassC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(KEYBOARD_UPDATE, CustomVehicleKeybindingsC2SPacket::vehicleVerticalMovement);
        ServerPlayNetworking.registerGlobalReceiver(PLAYER_QUERY_SERVER,(server, player, handler, buf,
                responseSender) -> server.execute(() -> ServerPlayNetworking.send(player,PLAYER_QUERY,
                    PacketByteBufs.empty())));
        ServerPlayNetworking.registerGlobalReceiver(RAY_CAST,NinjaRayCastC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(RAY_CAST_DROP,NinjaRayCastC2SPacket::receive2);
        ServerPlayNetworking.registerGlobalReceiver(RAY_CAST_ENTITY,NinjaRayCastC2SPacket::receive3);
        ServerPlayNetworking.registerGlobalReceiver(BUILD_HOLOGRAM,TriggerServerBuildAreaCalculationC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(TOWER_SCANNER,ScanForActiveXanaTowersC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(VEHICLE_HOVER,CustomVehicleKeybindingsC2SPacket::vehicleHover);
    }
    @Environment(EnvType.CLIENT)
    public static void clientPacketRegistry() {
        ClientPlayNetworking.registerGlobalReceiver(BUILD_HOLOGRAM,RenderBuildAreaS2CPacket::receive);
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
