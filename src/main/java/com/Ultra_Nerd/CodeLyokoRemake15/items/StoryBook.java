package com.Ultra_Nerd.CodeLyokoRemake15.items;

import com.Ultra_Nerd.CodeLyokoRemake15.screens.StoryBookGUI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.item.WrittenBookItem;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class StoryBook extends WrittenBookItem {
    public StoryBook(Properties builder) {
        super(builder);
    }

    @Nonnull
    @Override
    public ITextComponent getDisplayName(@Nonnull ItemStack stack) {
        return new StringTextComponent("Entry 1");
    }


    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }


    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, @Nonnull PlayerEntity playerIn, @Nonnull Hand handIn) {
        if (!worldIn.isRemote) {
            Minecraft.getInstance().displayGuiScreen(new StoryBookGUI());
        }


        ItemStack stack = playerIn.getHeldItem(handIn);
        playerIn.openBook(stack, handIn);
        playerIn.sendMessage(new StringTextComponent("doesn't work properly yet"));
        return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
    }


    @Override
    public void addInformation(@Nonnull ItemStack stack, @Nullable World worldIn, @Nonnull List<ITextComponent> tooltip, @Nonnull ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(new StringTextComponent("a mysterious journal you found while traveling to this land"));
    }

    @Override
    public boolean hasEffect(@Nonnull ItemStack stack) {
        return false;
    }


}
