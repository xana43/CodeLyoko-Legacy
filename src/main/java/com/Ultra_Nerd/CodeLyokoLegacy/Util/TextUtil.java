package com.Ultra_Nerd.CodeLyokoLegacy.Util;

import net.minecraft.text.StringVisitable;
import net.minecraft.text.TranslatableText;
import org.jetbrains.annotations.NotNull;

public record TextUtil() {





    private static final StringVisitable[] pages = new StringVisitable[100];
    public static StringVisitable @NotNull [] textArray(@NotNull String textToDenote)
    {
        final String[] denoted = textToDenote.split("δ");
        final int length = denoted.length;
        for(int i = 0; i < length; i++)
        {
            pages[i] = new TranslatableText(denoted[i]);
        }
        return pages;
    }

    public static int textArrayLengthToPage(StringVisitable @NotNull [] formattedTexts)
    {
        int length = 0;

        for (final StringVisitable formattedText : formattedTexts) {
            if (formattedText != null) {
                length++;
            }
        }
        return length;
    }


   
}
