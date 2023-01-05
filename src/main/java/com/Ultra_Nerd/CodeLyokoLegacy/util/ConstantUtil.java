package com.Ultra_Nerd.CodeLyokoLegacy.util;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.text.Style;
import net.minecraft.util.Identifier;

public record ConstantUtil() {


    public static final Identifier skytop = CodeLyokoMain.codeLyokoPrefix("textures/skies/volcano/dark.png");
    public static final BooleanProperty SCANNER_PROPERTY = BooleanProperty.of("scanner_property");
    public static final int STRESS_THRESHHOLD = 10;
    public static final Identifier[] RECIPIE_IDENTIFIERS = {CodeLyokoMain.codeLyokoPrefix("anode")};

    //public static final EntityCa LYOKO = MobCategory.create("lyoko","lyoko",10,false,false,128);
    public enum Styles {
        GUNSHIP(Style.EMPTY.withFont(CodeLyokoMain.codeLyokoPrefix("gunship"))),
        HUD(Style.EMPTY.withFont(CodeLyokoMain.codeLyokoPrefix("lyoko_hud_font")));


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
        private static final String page = ">δ<";


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
                    n + "part of the reactor's functionality" + page + "enclosed is the recipe for a basic component " +
                    "of a computer"),
            ENTRY3("Entry 3:" +n+
                    "xxx/xx/xx" +n+
                    "Jeremy Belpois" + n + "xx:00" + n +
                    "while adventuring around the internet, I've discovered something strange about how the super " +
                    "computers all work" + n +
                    "the digital space doesn't appear to exist within the same laws of physics that we do and as " +page+
                    "such, there are nodes that appear to originate from other universes entirely, which by all logic" +
                    " should be impossible. I must do more research.");
            private final String thisEntry;

            EntryList(final String thisEntry) {
                this.thisEntry = thisEntry;
            }

            public String getThisEntry() {
                return thisEntry;
            }
        }


    }
}