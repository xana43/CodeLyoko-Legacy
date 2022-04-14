package com.Ultra_Nerd.CodeLyokoRemake15.Util;

import io.netty.util.internal.StringUtil;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.TextComponent;
import org.jetbrains.annotations.NotNull;


public final class TextUtil {

    public static final TextComponent EMPTY_TEXT_COMPONENT = new TextComponent(StringUtil.EMPTY_STRING);
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
