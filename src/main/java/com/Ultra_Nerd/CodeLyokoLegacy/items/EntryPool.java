package com.Ultra_Nerd.CodeLyokoLegacy.items;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModCustomTrackedCriteria;
import com.Ultra_Nerd.CodeLyokoLegacy.util.ConstantUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.util.enums.TranslatedLocale;
import com.Ultra_Nerd.CodeLyokoLegacy.util.event.Client.ClientEvents;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.WrittenBookItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public record EntryPool() {
    private static final List<StringVisitable[]> ENTRIES_EN_US = new ArrayList<>(2);
    private static final List<StringVisitable[]> ENTRIES_FR_FR = new ArrayList<>(2);
    private static void addEntryToList(final TranslatedLocale locale, final StringVisitable[] visitable)
    {
        switch (locale)
        {

            case EN_US -> ENTRIES_EN_US.add(visitable);
            case FR_FR -> ENTRIES_FR_FR.add(visitable);
        }
    }
    public static void init()
    {
        //entry1
        addEntryToList(TranslatedLocale.EN_US,MethodUtil.TextUtil.textArray(ConstantUtil.StoryEntry.EntryList.ENTRY1.getThisEntry()));
        addEntryToList(TranslatedLocale.FR_FR,MethodUtil.TextUtil.textArray(ConstantUtil.StoryEntry.EntryList.ENTRY1FR.getThisEntry()));
        //entry2
        addEntryToList(TranslatedLocale.EN_US,MethodUtil.TextUtil.textArray(ConstantUtil.StoryEntry.EntryList.ENTRY2.getThisEntry()));
    }
    private static abstract class BaseEntry extends WrittenBookItem {
       // @Environment(EnvType.CLIENT)
       // private static final MinecraftClient minecraftClientInstance = MinecraftClient.getInstance();
        private StringVisitable[] visitable;
        private final int englishIndex;
        private final int frenchIndex;
        public BaseEntry(@NotNull Settings builder,final int englishIndex,final int frenchIndex) {
            super(builder);
            this.englishIndex = englishIndex;
            this.frenchIndex = frenchIndex;
            ClientEvents.ON_LANGUAGE_CHANGED_EVENT.register(this::updateTranslation);
        }
        public boolean hasEntry()
        {
            return visitable != null;
        }
        @Override
        public boolean hasGlint(final ItemStack stack) {
            return false;
        }

        @Override
        public TypedActionResult<ItemStack> use(final World world, final PlayerEntity user, final Hand hand) {
            if (world.isClient) {
                if(!hasEntry())
                {
                    updateTranslation();
                }
                //minecraftClientInstance.setScreen(new StoryBookGUI(visitable,visitable.length));
                //user.useBook();
            }
            return super.use(world, user, hand);
        }

        private void updateTranslation()
        {
            final StringVisitable[] langArray = MethodUtil.HelperMethods.testLocale(ENTRIES_EN_US.get(englishIndex),ENTRIES_FR_FR.get(frenchIndex));
            if(langArray != null)
            {
                visitable = langArray;
            }
        }
    }
    public static final class JournalEntry1 extends BaseEntry {

        public JournalEntry1() {
            super(new Item.Settings().maxCount(1),0,0);
        }


        @Override
        public void appendTooltip(final ItemStack stack, @Nullable final World world, final List<Text> tooltip, final TooltipContext context) {
            super.appendTooltip(stack, world, tooltip, context);
            tooltip.add(Text.translatable("lyoko.story.entry"));
        }


    }

    public static final class JournalEntry2 extends BaseEntry {


        public JournalEntry2() {
            super(new Item.Settings().maxCount(1),1,0);
        }

        @Override
        public void appendTooltip(final ItemStack stack, @Nullable final World world, final List<Text> tooltip, final TooltipContext context) {
            super.appendTooltip(stack, world, tooltip, context);
            tooltip.add(Text.translatable("lyoko.story.entry2"));
        }


        @Override
        public TypedActionResult<ItemStack> use(final World world, final PlayerEntity user, final Hand hand) {
            if(!world.isClient) {

                ModCustomTrackedCriteria.USED_ITEM.trigger((ServerPlayerEntity) user, user.getStackInHand(hand));
            }
            user.unlockRecipes(new Identifier[]{ConstantUtil.RECIPE_IDENTIFIERS[0]});
            return super.use(world, user, hand);
        }
    }
}
