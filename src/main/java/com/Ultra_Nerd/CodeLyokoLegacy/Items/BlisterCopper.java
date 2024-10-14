package com.Ultra_Nerd.CodeLyokoLegacy.Items;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModItems;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class BlisterCopper extends Item {
    private static final String NBT_TAG_ACCESSOR = "timer";

    public BlisterCopper(@NotNull Settings properties) {
        super(properties);
    }



    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(
                Text.of("this form of copper is usable, but it oxidizes quickly back to cuprous oxide, use electroplating to keep it stable"));
    }

    @Override
    public boolean hasGlint(final ItemStack stack) {
        return true;
    }



    @Override
    public void inventoryTick(final ItemStack stack, final World worldIn, final Entity entityIn, int itemSlot,
            boolean isSelected) {

        if (!worldIn.isClient) {
            NbtCompound timerTag = stack.get(DataComponentTypes.CUSTOM_DATA).getNbt();
            if (timerTag == null) {
                timerTag = new NbtCompound();
                timerTag.putInt(NBT_TAG_ACCESSOR, 500);
                NbtComponent.set(DataComponentTypes.CUSTOM_DATA,stack,timerTag);
            }
            timerTag.putInt(NBT_TAG_ACCESSOR, timerTag.getInt(NBT_TAG_ACCESSOR) - 1);
            if (timerTag.getInt(NBT_TAG_ACCESSOR) <= 0) {
                if (stack.getDamage() != 60) {

                    stack.setDamage(stack.getDamage() + 1);

                    timerTag.putInt(NBT_TAG_ACCESSOR, 500);
                }
            }
            if (stack.getDamage() == 60) {

                if (entityIn instanceof final PlayerEntity playerEntity) {
                    playerEntity.getInventory().setStack(itemSlot, new ItemStack(ModItems.CUPROUS_OXIDE));
                }


            }
        }


    }
}
