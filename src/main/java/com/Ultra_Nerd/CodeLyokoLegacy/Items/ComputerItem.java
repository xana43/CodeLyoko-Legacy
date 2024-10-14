package com.Ultra_Nerd.CodeLyokoLegacy.Items;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public final class ComputerItem extends Item {


    public ComputerItem(final Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        if (Screen.hasShiftDown()) {
            tooltip.add(
                    Text.translatable("computer.item.tooltip.shift"));
        } else {
            tooltip.add(Text.translatable("computer.item.tooltip"));


        }
    }



}
