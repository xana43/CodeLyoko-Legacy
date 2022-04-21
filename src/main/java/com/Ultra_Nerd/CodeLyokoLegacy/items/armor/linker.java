package com.Ultra_Nerd.CodeLyokoLegacy.items.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import org.jetbrains.annotations.NotNull;

public final class linker extends ArmorItem {
    public linker(@NotNull ArmorMaterial materialIn, @NotNull EquipmentSlot slot, @NotNull Settings builder) {
        super(materialIn, slot, builder);
    }
/*
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

 */
}
