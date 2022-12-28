package com.Ultra_Nerd.CodeLyokoLegacy.screens.ClientScreens;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.BookScreen;
import net.minecraft.text.StringVisitable;
@Environment(EnvType.CLIENT)
public final class StoryBookGUI extends BookScreen {

    public StoryBookGUI(final StringVisitable[] story, final int pages) {
        super(new Contents() {
            @Override
            public int getPageCount() {
                return pages;
            }

            @Override
            public StringVisitable getPageUnchecked(final int index) {
                return story[index];
            }
        });
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
