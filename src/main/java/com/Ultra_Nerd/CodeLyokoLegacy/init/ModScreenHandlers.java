package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.ComputerControlPanelScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.TowerInterfaceScreenHandler;
import com.google.common.collect.ImmutableMap;
import net.minecraft.screen.ScreenHandlerType;

public record ModScreenHandlers() {


    public static final ScreenHandlerType<TowerInterfaceScreenHandler> TOWER_INTERFACE_SCREEN_HANDLER = new ScreenHandlerType<>((syncId, playerInventory) -> new TowerInterfaceScreenHandler(syncId));
    public static final ScreenHandlerType<ComputerControlPanelScreenHandler> CONTROL_PANEL_SCREEN_HANDLER_SCREEN_HANDLER_TYPE = new ScreenHandlerType<>((syncId, inventory) -> new ComputerControlPanelScreenHandler(syncId));

    public static final ImmutableMap<String, ScreenHandlerType<?>> screenHandlerMap = ImmutableMap.<String, ScreenHandlerType<?>>builder()
            .put("tower_screen_handler", TOWER_INTERFACE_SCREEN_HANDLER)
            .put("computer_controlpanel", CONTROL_PANEL_SCREEN_HANDLER_SCREEN_HANDLER_TYPE)


            .build();
}
