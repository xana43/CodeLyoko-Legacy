package com.Ultra_Nerd.CodeLyokoLegacy.Init.client;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.common.ModScreenHandlers;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.*;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.ElectricitySystemScreens.RackChargerScreen;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.SuperCalculatorNetworkScreens.DemarcationPointScreen;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.TestScreens.PlayerProfileDebug;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.TestScreens.VehicleMaterializationTest;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public record ModHandledScreensClientInitializer() {
    public static void handledScreenRegistration()
    {
        HandledScreens.register(ModScreenHandlers.TOWER_INTERFACE_SCREEN_HANDLER, TowerGUI::new);
        HandledScreens.register(ModScreenHandlers.CONTROL_PANEL_SCREEN_HANDLER_SCREEN_HANDLER_TYPE,
                ComputerControlPanelUI::new);
        HandledScreens.register(ModScreenHandlers.COMPUTER_REACTOR_SCREEN_HANDLER, ReactorGUI::new);
        HandledScreens.register(ModScreenHandlers.COMPUTER_INTERFACE_SCREEN_SCREEN_HANDLER_TYPE,
                ComputerInterfaceUi::new);
        HandledScreens.register(ModScreenHandlers.PROFILE_DEBUG_SCREEN_HANDLER_SCREEN_HANDLER_TYPE,
                PlayerProfileDebug::new);
        HandledScreens.register(ModScreenHandlers.VEHICLE_MATERIALIZE_TEST_HANDLER_SCREEN_HANDLER_TYPE,
                VehicleMaterializationTest::new);
        HandledScreens.register(ModScreenHandlers.RACK_CHARGER_HANDLER_SCREEN_TYPE, RackChargerScreen::new);
        HandledScreens.register(ModScreenHandlers.DEMARCATION_SCREEN_HANDLER_TYPE, DemarcationPointScreen::new);
        HandledScreens.register(ModScreenHandlers.LITHOGRAPHY_SCREEN_HANDLER_TYPE, LithographyGUI::new);
        HandledScreens.register(ModScreenHandlers.LITHOGRAPHY_SCREEN_HANDLER_TYPE_T2,LithographyT2GUI::new);
    }
}
