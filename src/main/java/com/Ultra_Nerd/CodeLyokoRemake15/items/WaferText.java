package com.Ultra_Nerd.CodeLyokoRemake15.items;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class WaferText extends Item {
    public WaferText(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(@Nonnull ItemStack stack, @Nullable Level worldIn, @Nonnull List<Component> tooltip, @Nonnull TooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TextComponent("Made by MSMC"));
    }


    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }
}
