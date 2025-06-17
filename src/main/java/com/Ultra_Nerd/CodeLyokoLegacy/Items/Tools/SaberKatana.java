package com.Ultra_Nerd.CodeLyokoLegacy.Items.Tools;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModSounds;
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
import org.jetbrains.annotations.Nullable;

public final class SaberKatana extends Item {

    private boolean selectedOnce;
    public SaberKatana(final ToolMaterial toolMaterial, final int attackDamage, final float attackSpeed, final Settings settings) {
        super(settings.sword(toolMaterial,attackDamage,attackSpeed));

    }


    public int getMaxUseTime(final ItemStack stack) {
        return 72000;
    }


    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        super.inventoryTick(stack, world, entity, slot);
        if (world.isClient()) {
            return;
        }
        if(entity instanceof final PlayerEntity player) {
            final boolean isCurrentlySelected = player.getWeaponStack().isOf(this);
                if (isCurrentlySelected && !selectedOnce) {
                    entity.playSound(ModSounds.SWORDDRAW, 1, 1);
                    selectedOnce = true;
                } else if (!isCurrentlySelected) {
                    selectedOnce = false;
                }
        }
        if (!stack.hasEnchantments()) {
            final DynamicRegistryManager registryManager = world.getRegistryManager();
            final RegistryEntry<Enchantment> SWEEPING_EDGE = MethodUtil.HelperMethods.getRegistryEntry(registryManager, RegistryKeys.ENCHANTMENT, Enchantments.SWEEPING_EDGE);
            stack.addEnchantment(SWEEPING_EDGE, SWEEPING_EDGE.value().getMaxLevel());
            //stack.addHideFlag(ItemStack.TooltipSection.ENCHANTMENTS);
        }
    }

    @Override
    public boolean hasGlint(final ItemStack stack) {
        return false;
    }

}
