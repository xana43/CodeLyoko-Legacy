package com.Ultra_Nerd.CodeLyokoLegacy.screens.ClientScreens;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.BookScreen;
@Environment(EnvType.CLIENT)
public final class StoryBookGUI extends BookScreen {

    public StoryBookGUI(final Contents story) {
        super(story);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
