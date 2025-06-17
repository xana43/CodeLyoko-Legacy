package com.Ultra_Nerd.CodeLyokoLegacy.Items;

import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public final class TrustyScrewDriverItem extends Item {
    public TrustyScrewDriverItem(@NotNull Settings properties) {
        super(properties);
    }

    @Override
    public void appendTooltip(final ItemStack stack,final TooltipContext context,final TooltipDisplayComponent displayComponent,final Consumer<Text> textConsumer,final TooltipType type) {
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        textConsumer.accept(Text.of("the most reliable screw driver ever" + '\n' + "don't drop the parts to admire it"));
    }




}
