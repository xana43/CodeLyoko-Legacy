package com.Ultra_Nerd.CodeLyokoLegacy.screens.ElectricitySystemScreens;

import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.ElectricitySystemHandlers.RackChargerHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public final class RackChargerScreen extends HandledScreen<RackChargerHandler> {
    public RackChargerScreen(final RackChargerHandler handler, final PlayerInventory inventory, final Text title) {
        super(handler, inventory, title);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }

    @Override
    protected void drawBackground(final DrawContext context, final float delta, final int mouseX, final int mouseY) {

    }
}
