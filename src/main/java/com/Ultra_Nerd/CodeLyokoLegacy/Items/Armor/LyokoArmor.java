package com.Ultra_Nerd.CodeLyokoLegacy.Items.Armor;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.ArmorTicker;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.MethodUtil;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class LyokoArmor extends Item implements ArmorTicker {


    public LyokoArmor(ArmorMaterial material, EquipmentType type,Settings settings) {
        super(settings.armor(material,type));
    }

    @Override
    public boolean hasGlint(final ItemStack stack) {
        return false;
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        super.inventoryTick(stack, world, entity, slot);
        if (!stack.hasEnchantments()) {
            final RegistryEntry<Enchantment> bindingCurse = MethodUtil.HelperMethods.getRegistryEntry(world.getRegistryManager(), RegistryKeys.ENCHANTMENT,Enchantments.BINDING_CURSE);
            stack.addEnchantment(bindingCurse, bindingCurse.value().getMaxLevel());
            stack.apply(DataComponentTypes.ENCHANTMENTS, ItemEnchantmentsComponent.DEFAULT,itemEnchantmentsComponent -> null);
        }
    }

    @Override
    public void onArmorTick(PlayerEntity player, World world, Item armorItem, EquipmentSlot slot) {
        ArmorTicker.super.onArmorTick(player, world, armorItem, slot);
        if (MethodUtil.DimensionCheck.isPlayerInLyoko(player)) {
            return;
        }
        if (player.getInventory().getStack(EquipmentSlot.CHEST.getEntitySlotId()).isOf(armorItem)) {
            player.getInventory().getStack(EquipmentSlot.CHEST.getEntitySlotId()).setCount(0);

            if (player.getInventory().getStack(EquipmentSlot.HEAD.getEntitySlotId())
                    .isOf(ModItems.BLANK_HELMET)) {
                player.getInventory().getStack(EquipmentSlot.HEAD.getEntitySlotId()).setCount(0);
            }
        }
        if (player.getInventory().getStack(EquipmentSlot.LEGS.getEntitySlotId()).isOf(armorItem)) {
            player.getInventory().getStack(EquipmentSlot.LEGS.getEntitySlotId()).setCount(0);
            if (player.getInventory().getStack(EquipmentSlot.HEAD.getEntitySlotId())
                    .isOf(ModItems.BLANK_HELMET)) {
                player.getInventory().getStack(EquipmentSlot.HEAD.getEntitySlotId()).setCount(0);
            }
        }
        if (player.getInventory().getStack(EquipmentSlot.FEET.getEntitySlotId()).isOf(armorItem)) {
            player.getInventory().getStack(EquipmentSlot.FEET.getEntitySlotId()).setCount(0);
            if (player.getInventory().getStack(EquipmentSlot.HEAD.getEntitySlotId())
                    .isOf(ModItems.BLANK_HELMET)) {
                player.getInventory().getStack(EquipmentSlot.HEAD.getEntitySlotId()).setCount(0);
            }
        }

    }

}
