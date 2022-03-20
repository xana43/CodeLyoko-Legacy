package com.Ultra_Nerd.CodeLyokoRemake15.items;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class BlisterCopper extends Item {
    private short I = 500;

    public BlisterCopper(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(@Nonnull ItemStack stack, @Nullable Level worldIn, @Nonnull List<Component> tooltip, @Nonnull TooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(new Component() {
            @Override
            public Style getStyle() {
                return null;
            }

            @Override
            public String getContents() {
                return "this form of copper is usable, but it oxidizes quickly back to cuprous oxide, use electroplating to keep it stable";
            }

            @Override
            public List<Component> getSiblings() {
                return null;
            }

            @Override
            public MutableComponent plainCopy() {
                return null;
            }

            @Override
            public MutableComponent copy() {
                return null;
            }

            @Override
            public FormattedCharSequence getVisualOrderText() {
                return null;
            }
        });

    }



    @Override
    public boolean isDamageable(ItemStack stack) {
        return true;
    }



    @Override
    public void inventoryTick(@Nonnull ItemStack stack, @Nonnull Level worldIn, @Nonnull Entity entityIn, int itemSlot, boolean isSelected) {

        if (worldIn.isClientSide) {
            Base.Log.debug(I);
            if (I-- == 0) {
                if (stack.getDamageValue() != 60) {

                    stack.setDamageValue(stack.getDamageValue() + 1);

                    I = 500;
                }
            }
            if (stack.getDamageValue() == 60) {
                Player playerEntity = (Player) entityIn;
                playerEntity.getInventory().setItem(itemSlot, new ItemStack(ModItems.CUPROUS_OXIDE.get()));

            }
        }


    }
}
