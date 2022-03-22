package com.Ultra_Nerd.CodeLyokoRemake15.items;

import com.Ultra_Nerd.CodeLyokoRemake15.screens.StoryBookGUI;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.WrittenBookItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class StoryBook extends WrittenBookItem {
    public StoryBook(Properties builder) {
        super(builder);
    }

    @Nonnull
    @Override
    public Component getName(@Nonnull ItemStack stack) {
        return new TranslatableComponent("Entry 1");
    }



    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }





    @Nonnull
    @Override
    public InteractionResultHolder<ItemStack> use(Level worldIn, @Nonnull Player playerIn, @Nonnull InteractionHand handIn) {
        if (worldIn.isClientSide) {
            Minecraft.getInstance().setScreen(new StoryBookGUI());
        }


        ItemStack stack = playerIn.getItemInHand(handIn);
        playerIn.openItemGui(stack, handIn);
        playerIn.sendMessage(new TranslatableComponent("doesn't work properly yet"), playerIn.getUUID());
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, playerIn.getItemInHand(handIn));
    }
    @Override
    public void appendHoverText(@Nonnull ItemStack stack, @Nullable Level worldIn, @Nonnull List<Component> tooltip, @Nonnull TooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslatableComponent("a mysterious journal you found while traveling to this land"));
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return false;
    }

    @Override
    public boolean isEnchantable(ItemStack p_41456_) {
        return false;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return false;
    }

    @Override
    public boolean isFoil(ItemStack p_43476_) {
        return true;
    }




}
