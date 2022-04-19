package com.Ultra_Nerd.CodeLyokoLegacy.Util;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import io.netty.util.internal.StringUtil;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.MobCategory;

public record ConstantUtil() {


    public static final Style GUNSHIP = Style.EMPTY.withFont(CodeLyokoMain.CodeLyokoPrefix("gunship"));
    public static final Style HUD = Style.EMPTY.withFont(CodeLyokoMain.CodeLyokoPrefix("lyoko_hud_font"));
    public static final MobCategory LYOKO = MobCategory.create("lyoko","lyoko",10,false,false,128);
    public static final TextComponent EMPTY_TEXT_COMPONENT = new TextComponent(StringUtil.EMPTY_STRING);

    public record StoryEntry()
    {
        private static final String n = System.lineSeparator();
        private static final String page = "δ";
        public static final String Entry1 =
                "Entry 1: " + n +
                        "XXXX/xx/xx" + n +
                        "Jeremy Belpois" + n + "xx:00" + n +
                        "I'm not sure what happened, X.A.N.A. was defeated years ago " + n +
                        "but this time he's done it, he's managed to destroy the world as we know it " + page +
                        "I survived because I tried to save everyone by putting  them in lyoko " + n +
                        "I'm not sure how long I have to be here, hopefully someone finds this, and finds the hidden instructions to rebuild the super calculator and reset this mess";





        public static final String Entry2 =
                        "Entry 2:" + n +
                                "xxxx/xx/xx" + n +
                                "Jeremy Belpois" + n + "xx:00" + n +
                        "copper, iron, gold, uranium, steel. The basic ingredients for all things tech. well Uranium is" +
                        n + "part of the reactor's functionality" + page + "enclosed is the recipe for a basic component of a computer";







    }
}