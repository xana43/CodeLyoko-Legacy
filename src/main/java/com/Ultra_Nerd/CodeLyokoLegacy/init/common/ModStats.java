package com.Ultra_Nerd.CodeLyokoLegacy.init.common;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.stat.StatFormatter;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;

public record ModStats() {

    public static final Identifier ENTERED_LYOKO_IDENTIFIER;
    public static final Identifier DIED_IN_LYOKO_IDENTIFIER;
    public static final Identifier TIME_SPENT_IN_LYOKO_IDENTIFIER;
    static {
        ENTERED_LYOKO_IDENTIFIER = registerCustomStats("entered_lyoko", StatFormatter.DEFAULT);
        DIED_IN_LYOKO_IDENTIFIER = registerCustomStats("died_in_lyoko",StatFormatter.DEFAULT);
        TIME_SPENT_IN_LYOKO_IDENTIFIER = registerCustomStats("time_spent_in_lyoko",StatFormatter.TIME);
    }
    public static void registerStats() {}

    private static Identifier registerCustomStats(final String name, final StatFormatter formatter) {
        final Identifier identifier = CodeLyokoMain.codeLyokoPrefix(name);
        Registry.register(Registries.CUSTOM_STAT, name, identifier);
        Stats.CUSTOM.getOrCreateStat(identifier, formatter);
        return identifier;
    }
}
