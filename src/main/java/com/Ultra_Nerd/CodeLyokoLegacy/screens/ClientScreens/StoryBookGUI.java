package com.Ultra_Nerd.CodeLyokoLegacy.screens.ClientScreens;

import net.minecraft.client.gui.screen.ingame.BookScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.StringVisitable;

public final class StoryBookGUI extends BookScreen {

    public StoryBookGUI(final StringVisitable[] story,final int pages)
    {
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


    /*
    public StoryBookGUI(FormattedText[] story, int AmountOfPages) {
        super(new BookAccess() {
            @Override
            public int getPageCount() {
                return AmountOfPages;
            }

            @Override
            public @NotNull FormattedText getPageRaw(int pIndex) {
                return story[pIndex];
            }



        });
    }




    @Override
    public boolean isPauseScreen() {
        return false;
    }

 */


}
