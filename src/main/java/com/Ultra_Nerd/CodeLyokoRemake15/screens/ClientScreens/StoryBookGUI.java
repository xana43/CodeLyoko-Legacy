package com.Ultra_Nerd.CodeLyokoRemake15.screens.ClientScreens;

import net.minecraft.client.gui.screens.inventory.BookViewScreen;
import net.minecraft.network.chat.FormattedText;
import org.jetbrains.annotations.NotNull;


public final class StoryBookGUI extends BookViewScreen {

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


}
