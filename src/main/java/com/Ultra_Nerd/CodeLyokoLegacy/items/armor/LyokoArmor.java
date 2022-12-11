package com.Ultra_Nerd.CodeLyokoLegacy.items.armor;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LyokoArmor extends ArmorItem {
    public LyokoArmor(final ArmorMaterial material, final EquipmentSlot slot, final Settings settings) {
        super(material, slot, settings);

    }

    @Override
    public boolean isDamageable() {
        return false;
    }

    @Override
    public boolean canRepair(final ItemStack stack, final ItemStack ingredient) {
        return false;
    }

    @Override
    public boolean hasGlint(final ItemStack stack) {
        return false;
    }

    @Override
    public void inventoryTick(final ItemStack stack, final World world, final Entity entity, final int slot, final boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        if (!stack.hasEnchantments()) {
            stack.addEnchantment(Enchantments.BINDING_CURSE, Enchantments.BINDING_CURSE.getMaxLevel());
            stack.addHideFlag(ItemStack.TooltipSection.ENCHANTMENTS);
        }
        if (entity instanceof final PlayerEntity player) {
            onArmorTick(player, stack.getItem());
        }
    }

    protected boolean onArmorTick(final PlayerEntity player, final Item armorItem) {
        if (!MethodUtil.DimensionCheck.playerNotInVanillaWorld(player)) {
            if (player.getInventory().getArmorStack(EquipmentSlot.CHEST.getEntitySlotId()).isOf(armorItem)) {
                player.getInventory().getArmorStack(EquipmentSlot.CHEST.getEntitySlotId()).setCount(0);

                if (player.getInventory().getArmorStack(EquipmentSlot.HEAD.getEntitySlotId())
                        .isOf(ModItems.BLANKHELMET)) {
                    player.getInventory().getArmorStack(EquipmentSlot.HEAD.getEntitySlotId()).setCount(0);
                }
            }
            if (player.getInventory().getArmorStack(EquipmentSlot.LEGS.getEntitySlotId()).isOf(armorItem)) {
                player.getInventory().getArmorStack(EquipmentSlot.LEGS.getEntitySlotId()).setCount(0);
                if (player.getInventory().getArmorStack(EquipmentSlot.HEAD.getEntitySlotId())
                        .isOf(ModItems.BLANKHELMET)) {
                    player.getInventory().getArmorStack(EquipmentSlot.HEAD.getEntitySlotId()).setCount(0);
                }
            }
            if (player.getInventory().getArmorStack(EquipmentSlot.FEET.getEntitySlotId()).isOf(armorItem)) {
                player.getInventory().getArmorStack(EquipmentSlot.FEET.getEntitySlotId()).setCount(0);
                if (player.getInventory().getArmorStack(EquipmentSlot.HEAD.getEntitySlotId())
                        .isOf(ModItems.BLANKHELMET)) {
                    player.getInventory().getArmorStack(EquipmentSlot.HEAD.getEntitySlotId()).setCount(0);
                }
            }
            return false;
        }

        return true;
    }

}
