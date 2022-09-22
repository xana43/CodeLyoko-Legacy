package com.Ultra_Nerd.CodeLyokoLegacy.util;

import net.minecraft.util.Rarity;

public record CustomLyokoRarity() {

    static {
        Rarity.values();
    }

    public static Rarity FRANZ_STARTER;
    public static Rarity FRANZ_NOVICE;
    public static Rarity FRANZ_HOPPER;
    public static Rarity COMMONPART;
    public static Rarity CONSUMER;
    public static Rarity PROSUMER;
    public static Rarity ENTHUSIAST;
    public static Rarity SERVER_CONSUMER;
    public static Rarity SERVER_BETA;
    public static Rarity SERVER_PROSUMER;
    public static Rarity SERVER_MATURE;
    public static Rarity DATACENTER;
    public static Rarity MAINFRAME;

}
