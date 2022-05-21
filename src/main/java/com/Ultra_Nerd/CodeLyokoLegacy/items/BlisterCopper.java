package com.Ultra_Nerd.CodeLyokoLegacy.items;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.List;

public final class BlisterCopper extends Item {
    private short I = 500;

    public BlisterCopper(@NotNull Settings properties) {
        super(properties);
    }


    @Override
    public void appendTooltip(final ItemStack stack, @org.jetbrains.annotations.Nullable final World world, final List<Text> tooltip, final TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.of("this form of copper is usable, but it oxidizes quickly back to cuprous oxide, use electroplating to keep it stable"));
    }

    @Override
    public boolean hasGlint(final ItemStack stack) {
        return true;
    }



    @Override
    public boolean isDamageable() {
        return true;
    }



    @Override
    public void inventoryTick(@Nonnull ItemStack stack, @Nonnull World worldIn, @Nonnull Entity entityIn, int itemSlot, boolean isSelected) {

        if (worldIn.isClient) {
            //CodeLyokoMain.Log.debug(I);
            if (I-- == 0) {
                if (stack.getDamage() != 60) {

                    stack.setDamage(stack.getDamage() + 1);

                    I = 500;
                }
            }
            if (stack.getDamage() == 60) {

                if(entityIn instanceof PlayerEntity playerEntity)
                {
                   playerEntity.getInventory().setStack(itemSlot, new ItemStack(ModItems.CUPROUS_OXIDE));
                }


            }
        }


    }
}
