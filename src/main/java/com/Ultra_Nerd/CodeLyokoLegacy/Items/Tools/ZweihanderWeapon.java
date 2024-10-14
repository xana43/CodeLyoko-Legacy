package com.Ultra_Nerd.CodeLyokoLegacy.Items.Tools;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.MethodUtil;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Hand;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;


public final class ZweihanderWeapon extends SwordItem {


    private final AttributeModifiersComponent component;
    public ZweihanderWeapon(final @NotNull ToolMaterial tier, int attackDamageIn, float attackSpeedIn, final @NotNull Settings builder) {
        super(tier, builder);

        component = createAttributeModifiers(tier, (int) (attackDamageIn + tier.getAttackDamage()),attackSpeedIn);

    }


    @Override
    public UseAction getUseAction(final ItemStack stack) {
        return UseAction.BLOCK;
    }

    @Override
    public boolean hasGlint(final ItemStack stack) {
        return false;
    }



    @Override
    public void inventoryTick(@NotNull ItemStack stack, final World worldIn, final Entity entityIn, int itemSlot,
            boolean isSelected) {


        if (entityIn instanceof final PlayerEntity player) {
            final ItemStack IStack = player.getStackInHand(Hand.OFF_HAND);
            if (IStack.getItem() == ModItems.ZWEIHANDER) {

                player.getInventory().setStack(player.getInventory().getEmptySlot(), IStack);
            }

        }
        if (!stack.hasEnchantments()) {
            final DynamicRegistryManager registryManager = worldIn.getRegistryManager();
            final RegistryEntry<Enchantment> SWEEPING_EDGE = MethodUtil.HelperMethods.getRegistryEntry(registryManager, RegistryKeys.ENCHANTMENT,Enchantments.SWEEPING_EDGE);
            final RegistryEntry<Enchantment> SHARPNESS = MethodUtil.HelperMethods.getRegistryEntry(registryManager, RegistryKeys.ENCHANTMENT,Enchantments.SHARPNESS);
            stack.addEnchantment(SWEEPING_EDGE,SWEEPING_EDGE.value().getMaxLevel());
            stack.addEnchantment(SHARPNESS, SHARPNESS.value().getMaxLevel());
            //stack.addHideFlag(ItemStack.TooltipSection.ENCHANTMENTS);


        }
    }

    @Override
    public AttributeModifiersComponent getAttributeModifiers() {
        return component;
    }




}
