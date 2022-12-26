package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.ComputerControlPanelScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.ComputerInterfaceScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.ReactorScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.TowerInterfaceScreenHandler;
import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.screen.ScreenHandlerType;

public record ModScreenHandlers() {


    public static final ScreenHandlerType<TowerInterfaceScreenHandler> TOWER_INTERFACE_SCREEN_HANDLER = new ExtendedScreenHandlerType<>(
            (syncId, playerInventory,buf) -> new TowerInterfaceScreenHandler(syncId,playerInventory.player,buf));
    public static final ScreenHandlerType<ComputerControlPanelScreenHandler> CONTROL_PANEL_SCREEN_HANDLER_SCREEN_HANDLER_TYPE = new ExtendedScreenHandlerType<>(
            (syncId, inventory, buf) -> new ComputerControlPanelScreenHandler(syncId, buf));
    public static final ScreenHandlerType<ReactorScreenHandler> COMPUTER_REACTOR_SCREEN_HANDLER = new ScreenHandlerType<>(
            ReactorScreenHandler::new);
    public static final ScreenHandlerType<ComputerInterfaceScreenHandler> COMPUTER_INTERFACE_SCREEN_SCREEN_HANDLER_TYPE =
            new ExtendedScreenHandlerType<>((syncId, inventory, buf) -> new ComputerInterfaceScreenHandler(syncId,
                    inventory.player,inventory.player.world.getLevelProperties(),buf));
    public static final ImmutableMap<String, ScreenHandlerType<?>> screenHandlerMap = ImmutableMap.<String, ScreenHandlerType<?>>builder()
            .put("tower_screen_handler", TOWER_INTERFACE_SCREEN_HANDLER)
            .put("computer_controlpanel", CONTROL_PANEL_SCREEN_HANDLER_SCREEN_HANDLER_TYPE)
            .put("computer_reactor_screen_handler", COMPUTER_REACTOR_SCREEN_HANDLER)
            .put("computer_interface_screen_handler",COMPUTER_INTERFACE_SCREEN_SCREEN_HANDLER_TYPE)
            .build();
}
