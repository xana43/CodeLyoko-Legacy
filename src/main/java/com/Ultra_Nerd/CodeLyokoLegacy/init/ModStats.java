package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.minecraft.util.Identifier;

public record ModStats() {
    private static final String ENTERED_LYOKO = "entered_lyoko";
    public static final Identifier ENTERED_LYOKO_IDENTIFIER = CodeLyokoMain.CodeLyokoPrefix(ENTERED_LYOKO);

    public static final String[] statArray = new String[]{
            ENTERED_LYOKO


    };
}
