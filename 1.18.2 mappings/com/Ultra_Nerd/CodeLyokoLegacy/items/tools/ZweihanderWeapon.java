package com.Ultra_Nerd.CodeLyokoLegacy.items.Tools;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public final class ZweihanderWeapon extends SwordItem {

     private final float attackdamage;
    private final float attackspeed;

    public ZweihanderWeapon(final @NotNull ToolMaterial tier, int attackDamageIn, float attackSpeedIn, final @NotNull Settings builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
        this.attackspeed = attackSpeedIn;
        this.attackdamage = (float) attackDamageIn + tier.getAttackDamage();

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
    public boolean isDamageable() {
        return false;
    }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, @Nonnull World worldIn, @Nonnull Entity entityIn, int itemSlot, boolean isSelected) {


        if (entityIn instanceof PlayerEntity player) {
            final ItemStack IStack = player.getStackInHand(Hand.OFF_HAND);
            if (IStack.getItem() == ModItems.ZWEIHANDER) {

                player.getInventory().setStack(player.getInventory().getEmptySlot(), IStack);
            }

        }
        if (!stack.hasEnchantments()) {
            stack.addEnchantment(Enchantments.SWEEPING, Enchantments.SWEEPING.getMaxLevel());
            stack.addEnchantment(Enchantments.SHARPNESS, Enchantments.SHARPNESS.getMaxLevel());
            stack.addHideFlag(ItemStack.TooltipSection.ENCHANTMENTS);
            //stack.getEnchantmentTags().clear();

        }
    }


    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(final ItemStack stack, final EquipmentSlot slot) {
        final Multimap<EntityAttribute,EntityAttributeModifier> multimap = HashMultimap.create();

        if (slot == EquipmentSlot.MAINHAND) {
            multimap.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID ,"Weapon modifier", this.attackdamage, EntityAttributeModifier.Operation.ADDITION));
            multimap.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier",  this.attackspeed, EntityAttributeModifier.Operation.ADDITION));
            multimap.put(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,new EntityAttributeModifier("Zweihander Knockback",this.attackdamage / 16, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
        }
        return multimap;

    }




}
