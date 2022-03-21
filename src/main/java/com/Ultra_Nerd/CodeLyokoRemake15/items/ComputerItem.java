package com.Ultra_Nerd.CodeLyokoRemake15.items;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;


public class ComputerItem extends Item {


    public ComputerItem(Properties properties) {
        super(properties);
    }




    @Override
    public void appendHoverText(@Nonnull ItemStack stack, @Nullable Level worldIn, @Nonnull List<Component> tooltip, @Nonnull TooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);

        assert Minecraft.getInstance().player != null;
        if (Minecraft.getInstance().player.isShiftKeyDown()) {
            tooltip.add(new TranslatableComponent("a part for a computer" + "\n" + "there are a bunch of tiers" + "\n" + "the color of the item indicates it's tier"));
        } else {
            tooltip.add(new TranslatableComponent("Hold " + "\u00A7e" + "Shift " + "\u00A77" + "For more details"));
        }
    }


}
