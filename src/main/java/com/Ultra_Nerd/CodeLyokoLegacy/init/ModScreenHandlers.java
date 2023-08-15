package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.*;
import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.TestHandler.ProfileDebugScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.TestHandler.VehicleMaterializeTestHandler;
import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.resource.featuretoggle.FeatureFlags;

import net.minecraft.screen.ScreenHandlerType;

public record ModScreenHandlers() {


    public static final ScreenHandlerType<TowerInterfaceScreenHandler> TOWER_INTERFACE_SCREEN_HANDLER = new ExtendedScreenHandlerType<>(
            (syncId, playerInventory,buf) -> new TowerInterfaceScreenHandler(syncId,playerInventory.player,buf));
    public static final ScreenHandlerType<ComputerControlPanelScreenHandler> CONTROL_PANEL_SCREEN_HANDLER_SCREEN_HANDLER_TYPE = new ExtendedScreenHandlerType<>(
            (syncId, inventory, buf) -> new ComputerControlPanelScreenHandler(syncId, buf));
    public static final ScreenHandlerType<ReactorScreenHandler> COMPUTER_REACTOR_SCREEN_HANDLER = new ScreenHandlerType<>(
            ReactorScreenHandler::new, FeatureFlags.VANILLA_FEATURES);
    public static final ScreenHandlerType<ComputerInterfaceScreenHandler> COMPUTER_INTERFACE_SCREEN_SCREEN_HANDLER_TYPE =
            new ExtendedScreenHandlerType<>((syncId, inventory, buf) -> new ComputerInterfaceScreenHandler(syncId,
                    inventory.player,inventory.player.getWorld().getLevelProperties(),buf));

    //test screens
    public static final ScreenHandlerType<ProfileDebugScreenHandler> PROFILE_DEBUG_SCREEN_HANDLER_SCREEN_HANDLER_TYPE =
            new ExtendedScreenHandlerType<>((syncId, inventory, buf) -> new ProfileDebugScreenHandler(syncId,
                    inventory.player, inventory.player.getWorld().getLevelProperties()));
    public static final ScreenHandlerType<VehicleMaterializeTestHandler> VEHICLE_MATERIALIZE_TEST_HANDLER_SCREEN_HANDLER_TYPE =
            new ScreenHandlerType<>((syncId, playerInventory) -> new VehicleMaterializeTestHandler(syncId),
                    FeatureFlags.VANILLA_FEATURES);
    public static final ImmutableMap<String, ScreenHandlerType<?>> screenHandlerMap = ImmutableMap.<String, ScreenHandlerType<?>>builder()
            .put("tower_screen_handler", TOWER_INTERFACE_SCREEN_HANDLER)
            .put("computer_controlpanel", CONTROL_PANEL_SCREEN_HANDLER_SCREEN_HANDLER_TYPE)
            .put("computer_reactor_screen_handler", COMPUTER_REACTOR_SCREEN_HANDLER)
            .put("computer_interface_screen_handler",COMPUTER_INTERFACE_SCREEN_SCREEN_HANDLER_TYPE)
            .put("profiledebugger",PROFILE_DEBUG_SCREEN_HANDLER_SCREEN_HANDLER_TYPE)
            .put("vehicletest",VEHICLE_MATERIALIZE_TEST_HANDLER_SCREEN_HANDLER_TYPE)
            .build();
}
