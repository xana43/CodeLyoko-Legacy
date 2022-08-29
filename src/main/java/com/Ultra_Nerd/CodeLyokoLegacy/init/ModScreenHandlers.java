package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.ComputerControlPanelScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.TowerInterfaceScreenHandler;
import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.screen.ScreenHandlerType;

public record ModScreenHandlers() {


    public static final ScreenHandlerType<TowerInterfaceScreenHandler> TOWER_INTERFACE_SCREEN_HANDLER = new ScreenHandlerType<>((syncId, playerInventory) -> new TowerInterfaceScreenHandler(syncId));
    public static final ScreenHandlerType<ComputerControlPanelScreenHandler> CONTROL_PANEL_SCREEN_HANDLER_SCREEN_HANDLER_TYPE = new ExtendedScreenHandlerType<>((syncId, inventory, buf) -> new ComputerControlPanelScreenHandler(syncId,buf));

    public static final ImmutableMap<String,ScreenHandlerType<?>> screenHandlerMap = ImmutableMap.<String,ScreenHandlerType<?>>builder()
            .put("tower_screen_handler",TOWER_INTERFACE_SCREEN_HANDLER)
            .put("computer_controlpanel",CONTROL_PANEL_SCREEN_HANDLER_SCREEN_HANDLER_TYPE)



            .build();
}
