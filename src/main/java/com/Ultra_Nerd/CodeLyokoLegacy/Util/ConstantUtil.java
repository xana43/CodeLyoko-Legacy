package com.Ultra_Nerd.CodeLyokoLegacy.Util;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.client.gui.screen.ingame.BookScreen;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public record ConstantUtil() {

    public static final PacketCodec<PacketByteBuf, BlockHitResult> HIT_RESULT_PACKET_CODEC = new PacketCodec<>() {
        @Override
        public BlockHitResult decode(PacketByteBuf buf) {
            return buf.readBlockHitResult();
        }

        @Override
        public void encode(PacketByteBuf buf, BlockHitResult value) {
            buf.writeBlockHitResult(value);
        }
    };
    public static final Identifier skytop = CodeLyokoMain.codeLyokoPrefix("textures/skies/volcano/dark.png");
    public static final int STRESS_THRESHOLD = 10;
    public static final Identifier[] RECIPE_IDENTIFIERS = {CodeLyokoMain.codeLyokoPrefix("anode")};

    public enum Styles {
        GUNSHIP("gunship"),
        HUD("lyoko_hud_font");
        private final Style thisStyle;
        Styles(final String styleName) {
            this.thisStyle = Style.EMPTY.withFont(CodeLyokoMain.codeLyokoPrefix(styleName));
        }
        public final Style getThisStyle() {
            return thisStyle;
        }
    }

    public record StoryEntry() {
        private static final String n = System.lineSeparator();
        private static final char page = '¶';

        @FunctionalInterface
        private interface EntryListing {
            BookScreen.Contents getEntries();
        }
        private static List<Text> textArray(@NotNull final String textToDenote) {
            if(textToDenote.isEmpty()) {
                return List.of();
            }
            final List<Text> denotedList = new ObjectArrayList<>();
            int pos = 0, end;
            while ((end = textToDenote.indexOf(page,pos)) >= 0)
            {
                denotedList.add(Text.of(textToDenote.substring(pos,end)));
                pos = end + 1;
            }
            denotedList.add(Text.of(textToDenote.substring(pos)));
            return denotedList;
        }
        private static BookScreen.Contents createContents(final List<Text> texts) {
            return new BookScreen.Contents(texts);

        }
        public enum ENTRY_LIST_EN_US implements EntryListing {
            //english entries
            ENTRY1("Entry 1: " + n +
                    "XXXX/xx/xx" + n +
                    "Jeremy Belpois" + n + "xx:00" + n +
                    "I'm not sure what happened, X.A.N.A. was defeated years ago " + n +
                    "but this time he's done it, he's managed to destroy the world as we know it " + page +
                    "I survived because I tried to save everyone by putting them in lyoko " + n +
                    "I'm not sure how long I have to be here, hopefully someone finds this, and finds the hidden instructions to rebuild the super calculator and reset this mess"
            ),
            ENTRY2("Entry 2:" + n +
                    "xxxx/xx/xx" + n +
                    "Jeremy Belpois" + n + "xx:00" + n +
                    "copper, iron, gold, uranium, steel. The basic ingredients for all things tech. well Uranium is" +
                    n + "part of the reactor's functionality" + page + "enclosed is the recipe for a basic component " +
                    "of a computer"),
            ENTRY3("Entry 3:" +n+
                    "xxxx/xx/xx" +n+
                    "Jeremy Belpois" + n + "xx:00" + n +
                    "while adventuring around the internet, I've discovered something strange about how the super " +
                    "computers all work" + n +
                    "the digital space doesn't appear to exist within the same laws of physics that we do and as " +page+
                    "such, there are nodes that appear to originate from other universes entirely, which by all logic" +
                    " should be impossible. I must do more research.");
            private final BookScreen.Contents thisContents;
            ENTRY_LIST_EN_US(final String thisEntry) {
                this.thisContents = createContents(textArray(thisEntry));
            }


            @Override
            public final BookScreen.Contents getEntries() {
                return thisContents;
            }
        }
        public enum ENTRY_LIST_FR_FR implements EntryListing {
            ENTRY1("Entrée 1: " + n +
                    "XXX/xx/xx" + n +
                    "Jérémie Belpois" + n + "xx:00" + n +
                    "Je ne suis pas sûr de ce qui c'est passé, X.A.N.A. a été vaincu il y a des années " + n +
                    "mais cette fois il l'a fait, il a réussi à détruire le monde tel que nous le connaissons" + page +
                    "J'ai survécu parce que j'ai essayé de sauver tout le monde en les mettant sur lyoko " + n +
                    "Je ne sais pas combien de temps je dois rester ici, j'espère que quelqu'un trouvera cela et trouvera les"+ n +
                    "instructions cachées pour reconstruire la super calculatrice" + page + "et réinitialiser ce gâchis."),
            ENTRY2("Entrée 2:" + n +
                    "xxxx/xx/xx" + n +
                    "Jérémy Belpois" + n + "xx:00" + n +
                    "Le cuivre, le fer, l'or, l'uranium, l'acier. Les ingrédients de base de tout ce qui concerne la technologie. Et bien, l'uranium est" +
                    n + "une partie des fonctionnalités du réacteur" + page + "ci-joint la recette d'un composant de base " +
                    "d'un ordinateur");
            private final BookScreen.Contents thisContents;

            ENTRY_LIST_FR_FR(final String thisEntry) {
                this.thisContents = createContents(textArray(thisEntry));
            }

            @Override
            public final BookScreen.Contents getEntries() {
                return this.thisContents;
            }
        }
    public enum ENTRY_LIST_ZH_CN implements EntryListing {
            ENTRY1("条目 1：" + n +
                    "XXXX/xx/xx" + n +
                            "杰里米·贝尔波亚" + n + "xx:00" + n +
                            "我不确定发生了什么，X.A.N.A. 已经在多年前被打败了 " + n +
                            "但这一次他成功了，他设法摧毁了我们所知的世界 " + page +
                            "我幸存下来是因为我试图通过把他们放入lyoko来拯救每个人 " + n +
                            "我不确定我得在这里呆多久，希望有人能找到这个，并找到重新构建超级计算机并重置这一混乱的隐藏指示"
            ),
            ENTRY2("条目 2：" + n +
                    "xxxx/xx/xx" + n +
                            "杰里米·贝尔波亚" + n + "xx:00" + n +
                            "铜，铁，金，铀，钢。所有科技产品的基本成分。铀是" +
                            n + "反应堆功能的一部分" + page + "附上了计算机基本组件的配方"
            )
            ;
            private final BookScreen.Contents thisContents;
        ENTRY_LIST_ZH_CN(final String entry) {

            this.thisContents = createContents(textArray(entry));
        }

        @Override
        public BookScreen.Contents getEntries() {
            return thisContents;
        }
    }

    }
}
