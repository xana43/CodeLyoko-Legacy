package com.Ultra_Nerd.CodeLyokoRemake15.items.armor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class linker extends ArmorItem {
    public linker(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
        super(materialIn, slot, builder);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if(stack.getDamage() < stack.getMaxDamage() - 1) {
            stack.damageItem(1, player, null);
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {

        if(stack.getDamage() != 0 && itemSlot != EquipmentSlotType.CHEST.getIndex())
        {
            stack.damageItem(-1,(PlayerEntity)entityIn,null);
        }

        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }
}
