package com.Ultra_Nerd.CodeLyokoLegacy.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class WaferText extends Item {
    public WaferText(@NotNull Settings properties) {
        super(properties);
    }


    @Override
    public void appendTooltip(final ItemStack stack, @org.jetbrains.annotations.Nullable final World world, final List<Text> tooltip, final TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.of("Made by MSMC"));
    }

    @Override
    public boolean isDamageable() {
        return false;
    }
}
