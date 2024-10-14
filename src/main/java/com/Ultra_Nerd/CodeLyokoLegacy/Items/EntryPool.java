package com.Ultra_Nerd.CodeLyokoLegacy.Items;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.WrittenBookItem;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public record EntryPool() {
    public static class BaseEntry extends WrittenBookItem {
        private final int entryIndex;
        private static final PacketByteBuf buf = PacketByteBufs.create();
        public BaseEntry(@NotNull Settings builder,final int entryIndex) {
            super(builder);
            this.entryIndex = entryIndex;
        }

        @Override
        public boolean hasGlint(final ItemStack stack) {
            return false;
        }

        @Override
        public TypedActionResult<ItemStack> use(final World world, final PlayerEntity user, final Hand hand) {
            if (!world.isClient()) {
                buf.setInt(0,entryIndex);
               // ServerPlayNetworking.send((ServerPlayerEntity) user, PacketHandler.OPEN_BOOK_ON_CLIENT,buf);
            }
            return super.use(world, user, hand);
        }

        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            super.appendTooltip(stack, context, tooltip, type);
            tooltip.add(Text.translatable("lyoko.story.entry"+(entryIndex+1)));
        }


    }



    public static final class JournalEntry2 extends BaseEntry {
        public JournalEntry2() {
            super(new Item.Settings().maxCount(1),1);
        }

        @Override
        public TypedActionResult<ItemStack> use(final World world, final PlayerEntity user, final Hand hand) {
            if(!world.isClient()) {

              //  ModCustomTrackedCriteria.USED_ITEM.trigger((ServerPlayerEntity) user, user.getStackInHand(hand));
              //  user.unlockRecipes(new Identifier[]{ConstantUtil.RECIPE_IDENTIFIERS[0]});
            }

            return super.use(world, user, hand);
        }
    }
}
