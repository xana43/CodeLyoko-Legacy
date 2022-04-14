package com.Ultra_Nerd.CodeLyokoRemake15.items.armor;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class linker extends ArmorItem {
    public linker(@NotNull ArmorMaterial materialIn, @NotNull EquipmentSlot slot, @NotNull Properties builder) {
        super(materialIn, slot, builder);
    }

    @Override
    public void onArmorTick(@NotNull ItemStack stack, Level world, Player player) {
        if (stack.getDamageValue() < stack.getMaxDamage() - 1) {
            stack.getItem().damageItem(stack,1, player, null);
        }
    }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, @Nonnull Level worldIn, @Nonnull Entity entityIn, int itemSlot, boolean isSelected) {

        if (stack.getDamageValue() != 0 && itemSlot != EquipmentSlot.CHEST.getIndex()) {
            stack.getItem().damageItem(stack,-1, (Player) entityIn, null);
        }

        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }
}
