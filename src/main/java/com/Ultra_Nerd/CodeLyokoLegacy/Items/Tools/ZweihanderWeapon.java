package com.Ultra_Nerd.CodeLyokoLegacy.Items.Tools;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.MethodUtil;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public final class ZweihanderWeapon extends Item {

    public ZweihanderWeapon(final @NotNull ToolMaterial tier, int attackDamageIn, float attackSpeedIn, final @NotNull Settings settings) {
        super(settings.sword(tier,attackDamageIn,attackSpeedIn));


    }

    @Override
    public boolean hasGlint(final ItemStack stack) {
        return false;
    }


    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        super.inventoryTick(stack, world, entity, slot);
        if (entity instanceof final PlayerEntity player) {
            final ItemStack IStack = player.getStackInHand(Hand.OFF_HAND);
            if (IStack.getItem() == ModItems.ZWEIHANDER) {

                player.getInventory().setStack(player.getInventory().getEmptySlot(), IStack);
            }

        }
        if (stack.hasEnchantments()) {
            return;
        }
        final DynamicRegistryManager registryManager = world.getRegistryManager();
        final RegistryEntry<Enchantment> SWEEPING_EDGE = MethodUtil.HelperMethods.getRegistryEntry(registryManager, RegistryKeys.ENCHANTMENT,Enchantments.SWEEPING_EDGE);
        final RegistryEntry<Enchantment> SHARPNESS = MethodUtil.HelperMethods.getRegistryEntry(registryManager, RegistryKeys.ENCHANTMENT,Enchantments.SHARPNESS);
        stack.addEnchantment(SWEEPING_EDGE,SWEEPING_EDGE.value().getMaxLevel());
        stack.addEnchantment(SHARPNESS, SHARPNESS.value().getMaxLevel());
        //stack.addHideFlag(ItemStack.TooltipSection.ENCHANTMENTS);
    }
}
