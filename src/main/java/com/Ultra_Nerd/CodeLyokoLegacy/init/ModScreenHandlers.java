package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.TowerInterfaceScreenHandler;
import com.google.common.collect.ImmutableMap;
import net.minecraft.screen.ScreenHandlerType;

public record ModScreenHandlers() {


    public static final ScreenHandlerType<TowerInterfaceScreenHandler> TOWER_INTERFACE_SCREEN_HANDLER = new ScreenHandlerType<>((syncId, playerInventory) -> new TowerInterfaceScreenHandler(syncId));


    public static final ImmutableMap<String,ScreenHandlerType<?>> screenHandlerMap = ImmutableMap.<String,ScreenHandlerType<?>>builder()
            .put("tower_screen_handler",TOWER_INTERFACE_SCREEN_HANDLER)




            .build();
}
