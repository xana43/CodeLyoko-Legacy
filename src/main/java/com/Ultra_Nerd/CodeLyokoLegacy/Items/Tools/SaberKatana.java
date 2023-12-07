package com.Ultra_Nerd.CodeLyokoLegacy.Items.Tools;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModSounds;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public final class SaberKatana extends SwordItem {
    private final float attackDamage;
    private final float attackSpeed;
    private boolean selectedOnce;

    public SaberKatana(final ToolMaterial toolMaterial, final int attackDamage, final float attackSpeed, final Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.attackSpeed = attackSpeed;
        this.attackDamage = attackDamage + toolMaterial.getAttackDamage();


    }

    @Override
    public UseAction getUseAction(final ItemStack stack) {


        return UseAction.BLOCK;
    }


    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(final ItemStack stack, final EquipmentSlot slot) {
        final Multimap<EntityAttribute, EntityAttributeModifier> multimap = HashMultimap.create();
        if (slot == EquipmentSlot.MAINHAND) {
            multimap.put(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                    new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon damage modifier", this.attackDamage,
                            EntityAttributeModifier.Operation.ADDITION));
            multimap.put(EntityAttributes.GENERIC_ATTACK_SPEED,
                    new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon speed modifier", this.attackSpeed,
                            EntityAttributeModifier.Operation.ADDITION));
        }
        return multimap;

    }


    @Override
    public void inventoryTick(final ItemStack stack, final World world, final Entity entity, final int slot, final boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if(!world.isClient()) {
            if (selected && !selectedOnce) {
                entity.playSound(ModSounds.SWORDDRAW, 1, 1);
                selectedOnce = true;
            } else if (!selected) {
                selectedOnce = false;
            }
            if (!stack.hasEnchantments()) {
                stack.addEnchantment(Enchantments.SWEEPING, Enchantments.SWEEPING.getMaxLevel());
                stack.addHideFlag(ItemStack.TooltipSection.ENCHANTMENTS);

            }
        }
    }



    @Override
    public TypedActionResult<ItemStack> use(final World world, final PlayerEntity user, final Hand hand) {
        user.setCurrentHand(hand);

        return TypedActionResult.pass(user.getStackInHand(hand));
    }

    @Override
    public boolean isDamageable() {
        return false;
    }

    @Override
    public boolean hasGlint(final ItemStack stack) {
        return false;
    }

}
