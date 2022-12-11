package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.minecraft.stat.StatFormatter;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public record ModStats() {

    public static Identifier ENTERED_LYOKO_IDENTIFIER;

    public static void registerStats() {
        ENTERED_LYOKO_IDENTIFIER = registerCustomStats("entered_lyoko", StatFormatter.DEFAULT);
    }

    private static Identifier registerCustomStats(final String name, final StatFormatter formatter) {
        final Identifier identifier = CodeLyokoMain.codeLyokoPrefix(name);
        Registry.register(Registry.CUSTOM_STAT, name, identifier);
        Stats.CUSTOM.getOrCreateStat(identifier, formatter);
        return identifier;
    }
}
