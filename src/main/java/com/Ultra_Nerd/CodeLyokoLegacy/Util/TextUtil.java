package com.Ultra_Nerd.CodeLyokoLegacy.Util;

import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.TextComponent;
import org.jetbrains.annotations.NotNull;


public final class TextUtil {

    private static final FormattedText[] pages = new FormattedText[100];
    public static FormattedText @NotNull [] textArray(@NotNull String textToDenote)
    {
        final String[] denoted = textToDenote.split("δ");
        final int length = denoted.length;
        for(int i = 0; i < length; i++)
        {
            pages[i]= new TextComponent(denoted[i]);
        }
        return pages;
    }

    public static int textArrayLengthToPage(FormattedText @NotNull [] formattedTexts)
    {
        int length = 0;
        for (FormattedText formattedText : formattedTexts) {
            if (formattedText != null) {
                length++;
            }
        }
        return length;
    }
   
}
