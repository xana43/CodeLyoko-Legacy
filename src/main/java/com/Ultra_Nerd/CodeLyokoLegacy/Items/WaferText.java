package com.Ultra_Nerd.CodeLyokoLegacy.Items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class WaferText extends Item {
    public WaferText(@NotNull Settings properties) {
        super(properties);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.translatable("silicon.wafer.tooltip"));
    }




}
