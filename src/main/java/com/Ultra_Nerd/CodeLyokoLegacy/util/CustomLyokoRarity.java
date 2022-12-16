package com.Ultra_Nerd.CodeLyokoLegacy.util;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import net.minecraft.util.Rarity;

public record CustomLyokoRarity() {

    @SuppressFBWarnings("UUF_UNUSED_PUBLIC_OR_PROTECTED_FIELD")
    public static Rarity FRANZ_STARTER;
    @SuppressFBWarnings("UUF_UNUSED_PUBLIC_OR_PROTECTED_FIELD")
    public static Rarity FRANZ_NOVICE;
    @SuppressFBWarnings("UUF_UNUSED_PUBLIC_OR_PROTECTED_FIELD")
    public static Rarity FRANZ_HOPPER;
    public static Rarity COMMONPART;
    @SuppressFBWarnings("UUF_UNUSED_PUBLIC_OR_PROTECTED_FIELD")
    public static Rarity CONSUMER;
    @SuppressFBWarnings("UUF_UNUSED_PUBLIC_OR_PROTECTED_FIELD")
    public static Rarity PROSUMER;
    @SuppressFBWarnings("UUF_UNUSED_PUBLIC_OR_PROTECTED_FIELD")
    public static Rarity ENTHUSIAST;
    @SuppressFBWarnings("UUF_UNUSED_PUBLIC_OR_PROTECTED_FIELD")
    public static Rarity SERVER_CONSUMER;
    @SuppressFBWarnings("UUF_UNUSED_PUBLIC_OR_PROTECTED_FIELD")
    public static Rarity SERVER_BETA;
    @SuppressFBWarnings("UUF_UNUSED_PUBLIC_OR_PROTECTED_FIELD")
    public static Rarity SERVER_PROSUMER;
    @SuppressFBWarnings("UUF_UNUSED_PUBLIC_OR_PROTECTED_FIELD")
    public static Rarity SERVER_MATURE;
    @SuppressFBWarnings("UUF_UNUSED_PUBLIC_OR_PROTECTED_FIELD")
    public static Rarity DATACENTER;
    @SuppressFBWarnings("UUF_UNUSED_PUBLIC_OR_PROTECTED_FIELD")
    public static Rarity MAINFRAME;

    static {
        Rarity.values();
    }

}
