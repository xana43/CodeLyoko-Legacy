package com.Ultra_Nerd.CodeLyokoRemake15.items.tools;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nonnull;

public class ZweihanderWeapon extends SwordItem {
    private final float attackdamage;
    private final float attackspeed;
    private short Count = 256;

    public ZweihanderWeapon(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
        this.attackspeed = attackSpeedIn;
        this.attackdamage = (float) attackDamageIn + tier.getAttackDamageBonus();
    }



    @Override
    public boolean canDisableShield(ItemStack stack, ItemStack shield, LivingEntity entity, LivingEntity attacker) {
        return super.canDisableShield(stack, shield, entity, attacker);
    }





    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if (stack.getDamageValue() < 3999) {
            Vec3 aim = player.getLookAngle();
            stack.setDamageValue(stack.getDamageValue() + 200);
            entity.setDeltaMovement(aim.x, aim.y, aim.z);
            Count = 256;

        }

        return stack.getDamageValue() >= 3999;

    }

    @Override
    public void inventoryTick(ItemStack stack, @Nonnull Level worldIn, @Nonnull Entity entityIn, int itemSlot, boolean isSelected) {
        if (stack.getDamageValue() > 4000) {
            stack.setDamageValue(3999);
        }
        if (worldIn.isClientSide) {
            Count -= 1;
            if (Count == 0) {
                if (stack.getDamageValue() != 0) {
                    stack.getItem().damageItem(stack,-1, (Player) entityIn, null);

                }

                Count = 256;
            }
        }
        if (entityIn instanceof Player) {
            Player player = (Player) entityIn;
            ItemStack IStack = player.getItemInHand(InteractionHand.OFF_HAND);
            if (player.getItemInHand(InteractionHand.MAIN_HAND).getItem() == ModItems.ZWEIHANDER.get()) {

                player.getInventory().add(player.getInventory().getFreeSlot(), IStack);
            }

        }
        if (!stack.isEnchanted() && stack.getDamageValue() < 1999) {
            stack.enchant(Enchantments.SWEEPING_EDGE, Enchantments.SWEEPING_EDGE.getMaxLevel());
            stack.enchant(Enchantments.SHARPNESS, Enchantments.SHARPNESS.getMaxLevel());

        } else if (stack.getDamageValue() >= 3999) {
            stack.getEnchantmentTags().clear();


        }
    }



    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        Multimap multimap = HashMultimap.create();

        if (slot == EquipmentSlot.MAINHAND) {
            multimap.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", this.attackdamage, AttributeModifier.Operation.ADDITION));
            multimap.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier",  this.attackspeed, AttributeModifier.Operation.ADDITION));
        }
        return multimap;


    }
}
