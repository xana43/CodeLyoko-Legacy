package com.Ultra_Nerd.CodeLyokoRemake15.items.armor;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nonnull;

public class linker extends ArmorItem {
    public linker(ArmorMaterial materialIn, EquipmentSlot slot, Properties builder) {
        super(materialIn, slot, builder);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (stack.getDamageValue() < stack.getMaxDamage() - 1) {
            stack.damageItem(1, player, null);
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, @Nonnull Level worldIn, @Nonnull Entity entityIn, int itemSlot, boolean isSelected) {

        if (stack.getDamageValue() != 0 && itemSlot != EquipmentSlot.CHEST.getIndex()) {
            stack.damageItem(-1, (Player) entityIn, null);
        }

        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }
}
