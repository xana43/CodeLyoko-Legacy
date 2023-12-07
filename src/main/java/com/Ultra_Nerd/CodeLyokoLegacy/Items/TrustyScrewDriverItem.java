package com.Ultra_Nerd.CodeLyokoLegacy.Items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class TrustyScrewDriverItem extends Item {
    public TrustyScrewDriverItem(@NotNull Settings properties) {
        super(properties);
    }


    @Override
    public void appendTooltip(final ItemStack stack, @org.jetbrains.annotations.Nullable final World world, final List<Text> tooltip, final TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.of("the most reliable screw driver ever" + "\n" + "don't drop the parts to admire it"));
    }


}
