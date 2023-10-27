package com.Ultra_Nerd.CodeLyokoLegacy.items;

import java.util.List;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public final class ComputerItem extends Item {


    public ComputerItem(final Settings settings) {
        super(settings);
    }


    @Override
    public void appendTooltip(final ItemStack stack, @Nullable final World world, final List<Text> tooltip, final TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        if (Screen.hasShiftDown()) {
            tooltip.add(
                    Text.translatable("computer.item.tooltip.shift"));
        } else {
            tooltip.add(Text.translatable("computer.item.tooltip"));


        }
    }


}
