package com.Ultra_Nerd.CodeLyokoLegacy.items;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModCustomTrackedCriteria;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.ClientScreens.StoryBookGUI;
import com.Ultra_Nerd.CodeLyokoLegacy.util.ConstantUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.util.enums.TranslatedLocale;
import com.Ultra_Nerd.CodeLyokoLegacy.util.event.Client.ClientEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
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
        addEntryToList(TranslatedLocale.EN_US,MethodUtil.TextUtil.textArray(ConstantUtil.StoryEntry.EntryList.ENTRY1.getThisEntry()));
        addEntryToList(TranslatedLocale.EN_US,MethodUtil.TextUtil.textArray(ConstantUtil.StoryEntry.EntryList.ENTRY2.getThisEntry()));
    }
    private static abstract class BaseEntry extends WrittenBookItem {
        private StringVisitable[] visitable;

        public BaseEntry(@NotNull Settings builder) {
            super(builder);
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
                MinecraftClient.getInstance().setScreen(new StoryBookGUI(visitable, MethodUtil.TextUtil.textArrayLengthToPage(visitable)));

            }
            return super.use(world, user, hand);
        }

        protected void setScreen(final StringVisitable[] entry) {
            visitable = entry;
        }
    }

    public static final class Entry1 extends BaseEntry {



        public Entry1(@NotNull Settings builder) {
            super(builder);

            updateTranslation();
            ClientEvents.ON_LANGUAGE_CHANGED_EVENT.register(this::updateTranslation);

        }
        private void updateTranslation()
        {
            final StringVisitable[] langArray = MethodUtil.HelperMethods.testLocale(ENTRIES_EN_US.get(0),ENTRIES_EN_US.get(0));
            if(langArray != null)
            {
                CodeLyokoMain.LOG.error("regenerating entry");
                setScreen(langArray);
            }
        }
        @Override
        public TypedActionResult<ItemStack> use(final World world, final PlayerEntity user, final Hand hand) {
            if(!hasEntry())
            {
                CodeLyokoMain.LOG.error("generating first time entry");
                updateTranslation();
            }
            return super.use(world, user, hand);
        }

        @Override
        public void appendTooltip(final ItemStack stack, @Nullable final World world, final List<Text> tooltip, final TooltipContext context) {
            super.appendTooltip(stack, world, tooltip, context);
            tooltip.add(Text.translatable("lyoko.story.entry"));
        }


    }

    public static final class Entry2 extends BaseEntry {


        public Entry2(@NotNull final Settings builder) {
            super(builder);
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
            else
            {
                final StringVisitable[] languageEntry = MethodUtil.HelperMethods.testLocale(ENTRIES_EN_US.get(1), ENTRIES_FR_FR.get(1));
                if(languageEntry != null) {
                    this.setScreen(languageEntry);
                }
            }
            user.unlockRecipes(new Identifier[]{ConstantUtil.RECIPE_IDENTIFIERS[0]});
            return super.use(world, user, hand);
        }
    }
}
