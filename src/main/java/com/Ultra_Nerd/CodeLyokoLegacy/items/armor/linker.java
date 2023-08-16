package com.Ultra_Nerd.CodeLyokoLegacy.items.armor;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import team.reborn.energy.api.base.SimpleEnergyItem;

public final class linker extends ArmorItem implements SimpleEnergyItem {
    public linker(final @NotNull ArmorMaterial materialIn,final @NotNull ArmorItem.Type slot,
            final @NotNull Settings builder) {
        super(materialIn, slot, builder);
    }

    @Override
    public long getEnergyCapacity(final ItemStack stack) {
        return 90000;
    }

    @Override
    public long getEnergyMaxInput(final ItemStack stack) {
        return 40;
    }

    @Override
    public long getEnergyMaxOutput(final ItemStack stack) {
        return 0;
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
