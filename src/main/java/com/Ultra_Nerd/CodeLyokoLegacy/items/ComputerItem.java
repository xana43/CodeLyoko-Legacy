package com.Ultra_Nerd.CodeLyokoLegacy.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;


public final class ComputerItem extends Item {


    public ComputerItem(final Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(final ItemStack stack, @org.jetbrains.annotations.Nullable final World world, final List<Text> tooltip, final TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        if(context.isAdvanced())
        {
            tooltip.add(Text.of("a part for a computer" + "\n" + "there are a bunch of tiers" + "\n" + "the color of the item indicates it's tier"));
        }
        else
        {
            tooltip.add(Text.of("Hold " + "\u00A7e" + "Shift " + "\u00A77" + "For more details"));

        }
    }




}
