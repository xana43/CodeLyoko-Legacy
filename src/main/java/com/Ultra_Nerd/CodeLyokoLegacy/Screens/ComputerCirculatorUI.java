package com.Ultra_Nerd.CodeLyokoLegacy.Screens;

import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.ComputerCirculatorScreenHandler;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public final class ComputerCirculatorUI extends HandledScreen<ComputerCirculatorScreenHandler> {
    public ComputerCirculatorUI(final ComputerCirculatorScreenHandler handler, final PlayerInventory inventory, final Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(final DrawContext context, final float delta, final int mouseX, final int mouseY) {

    }
}
