package com.Ultra_Nerd.CodeLyokoLegacy.Util;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.minecraft.text.Style;
import net.minecraft.util.Identifier;

public record ConstantUtil() {


    public static final Identifier skytop = CodeLyokoMain.CodeLyokoPrefix("textures/skies/volcano/dark.png");

    //public static final EntityCa LYOKO = MobCategory.create("lyoko","lyoko",10,false,false,128);
    public enum Styles {
        GUNSHIP(Style.EMPTY.withFont(CodeLyokoMain.CodeLyokoPrefix("gunship"))),
        HUD(Style.EMPTY.withFont(CodeLyokoMain.CodeLyokoPrefix("lyoko_hud_font")));


        private final Style thisStyle;

        Styles(final Style style) {
            this.thisStyle = style;
        }

        public Style getThisStyle() {
            return thisStyle;
        }
    }

    public record StoryEntry() {


        private static final String n = "\n";
        private static final String page = "δ";


        public enum EntryList {
            ENTRY1("Entry 1: " + n +
                    "XXXX/xx/xx" + n +
                    "Jeremy Belpois" + n + "xx:00" + n +
                    "I'm not sure what happened, X.A.N.A. was defeated years ago " + n +
                    "but this time he's done it, he's managed to destroy the world as we know it " + page +
                    "I survived because I tried to save everyone by putting  them in lyoko " + n +
                    "I'm not sure how long I have to be here, hopefully someone finds this, and finds the hidden instructions to rebuild the super calculator and reset this mess"
            ),
            ENTRY2("Entry 2:" + n +
                    "xxxx/xx/xx" + n +
                    "Jeremy Belpois" + n + "xx:00" + n +
                    "copper, iron, gold, uranium, steel. The basic ingredients for all things tech. well Uranium is" +
                    n + "part of the reactor's functionality" + page + "enclosed is the recipe for a basic component of a computer");
            final String thisEntry;

            EntryList(final String thisEntry) {
                this.thisEntry = thisEntry;
            }

            public String getThisEntry() {
                return thisEntry;
            }
        }


    }
}
