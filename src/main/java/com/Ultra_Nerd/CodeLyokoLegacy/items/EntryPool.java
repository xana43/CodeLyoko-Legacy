package com.Ultra_Nerd.CodeLyokoLegacy.items;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.ConstantUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.MethodUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.ClientScreens.StoryBookGUI;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.WrittenBookItem;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public record EntryPool()  {
    private static abstract class BaseEntry extends WrittenBookItem
    {
        public BaseEntry(@NotNull Settings builder) {
            super(builder);
        }
        @Override
        public boolean hasGlint(final ItemStack stack) {

            return false;
        }
        private StringVisitable[] visitables;
        @Override
        public TypedActionResult<ItemStack> use(final World world, final PlayerEntity user, final Hand hand) {
            if(world.isClient)
            {
                MinecraftClient.getInstance().setScreen(new StoryBookGUI(visitables, MethodUtil.TextUtil.textArrayLengthToPage(visitables)));
            }
            return super.use(world, user, hand);
        }

        protected  void setScreen(final StringVisitable[] entry)
        {
            visitables = entry;
        }
    }
    public static final class Entry1 extends BaseEntry {
        public Entry1(@NotNull Settings builder) {
            super(builder);
            this.setScreen(entry);
        }


        private static final StringVisitable[] entry = MethodUtil.TextUtil.textArray(ConstantUtil.StoryEntry.EntryList.ENTRY1.getThisEntry());
        @Override
        public void appendTooltip(final ItemStack stack, @Nullable final World world, final List<Text> tooltip, final TooltipContext context) {
            super.appendTooltip(stack, world, tooltip, context);
            tooltip.add(new TranslatableText("lyoko.story.entry"));
        }





    }

    public static final class Entry2 extends BaseEntry
    {
        private static final StringVisitable[] entry2 = MethodUtil.TextUtil.textArray(ConstantUtil.StoryEntry.EntryList.ENTRY2.getThisEntry());
        public Entry2(@NotNull final Settings builder) {
            super(builder);
            this.setScreen(entry2);
        }

        @Override
        public void appendTooltip(final ItemStack stack, @Nullable final World world, final List<Text> tooltip, final TooltipContext context) {
            super.appendTooltip(stack, world, tooltip, context);
            tooltip.add(new TranslatableText("lyoko.story.entry2"));
        }



        @Override
        public TypedActionResult<ItemStack> use(final World world, final PlayerEntity user, final Hand hand) {

            return super.use(world, user, hand);
        }
    }
}
