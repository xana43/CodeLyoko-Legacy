package com.Ultra_Nerd.CodeLyokoLegacy.items;

import com.Ultra_Nerd.CodeLyokoLegacy.util.ConstantUtil;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public final class ComputerItem extends Item {


    public ComputerItem(final Settings settings) {
        super(settings);
    }



    @Override
    public void appendTooltip(final ItemStack stack, @Nullable final World world, final List<Text> tooltip, final TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        if(Screen.hasShiftDown())
        {
            tooltip.add(new TranslatableText("computer.item.tooltip.shift").setStyle(ConstantUtil.Styles.HUD.getThisStyle()));
        }
        else
        {
            tooltip.add(new TranslatableText("computer.item.tooltip"));



        }
    }




}
