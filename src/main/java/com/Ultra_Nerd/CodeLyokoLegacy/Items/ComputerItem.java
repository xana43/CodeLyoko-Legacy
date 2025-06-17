package com.Ultra_Nerd.CodeLyokoLegacy.Items;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.function.Consumer;

public final class ComputerItem extends Item {


    public ComputerItem(final Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(final ItemStack stack,final TooltipContext context,final TooltipDisplayComponent displayComponent,final Consumer<Text> textConsumer,final TooltipType type) {
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        if (Screen.hasShiftDown()) {
            textConsumer.accept(Text.translatable("computer.item.tooltip.shift"));
            return;
        }
        textConsumer.accept(Text.translatable("computer.item.tooltip"));
    }



}
