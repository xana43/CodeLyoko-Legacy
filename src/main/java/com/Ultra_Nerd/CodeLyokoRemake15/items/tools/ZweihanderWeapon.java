package com.Ultra_Nerd.CodeLyokoRemake15.items.tools;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class ZweihanderWeapon extends SwordItem {
    private final float attackdamage;
    private final float attackspeed;
    private short Count = 256;

    public ZweihanderWeapon(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
        this.attackspeed = attackSpeedIn;
        this.attackdamage = (float) attackDamageIn + tier.getAttackDamage();
    }

    @Override
    public float getAttackDamage() {
        return this.attackdamage;
    }


    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (stack.getDamage() < 3999) {
            Vec3d aim = player.getLookVec();
            stack.setDamage(stack.getDamage() + 200);
            entity.addVelocity(aim.x, aim.y, aim.z);
            Count = 256;

        }

        return stack.getDamage() >= 3999;

    }

    @Override
    public void inventoryTick(ItemStack stack, @Nonnull World worldIn, @Nonnull Entity entityIn, int itemSlot, boolean isSelected) {
        if (stack.getDamage() > 4000) {
            stack.setDamage(3999);
        }
        if (!worldIn.isRemote()) {
            Count -= 1;
            if (Count == 0) {
                if (stack.getDamage() != 0) {
                    stack.damageItem(-1, (PlayerEntity) entityIn, null);
                }

                Count = 256;
            }
        }
        if (entityIn instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entityIn;
            ItemStack IStack = player.getHeldItem(Hand.OFF_HAND).getStack();
            if (player.getHeldItem(Hand.MAIN_HAND).getItem() == ModItems.ZWEIHANDER.get()) {

                player.inventory.add(player.inventory.getFirstEmptyStack(), IStack);
            }

        }
        if (!stack.isEnchanted() && stack.getDamage() < 1999) {
            stack.addEnchantment(Enchantments.SWEEPING, Enchantments.SWEEPING.getMaxLevel());
            stack.addEnchantment(Enchantments.SHARPNESS, Enchantments.SHARPNESS.getMaxLevel());

        } else if (stack.getDamage() >= 3999) {
            stack.getEnchantmentTagList().clear();


        }
    }

    @Override
    public boolean hasEffect(@Nonnull ItemStack stack) {
        return false;
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot, ItemStack stack) {
        Multimap multimap = HashMultimap.create();

        if (slot == EquipmentSlotType.MAINHAND) {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double) this.attackdamage, AttributeModifier.Operation.ADDITION));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", (double) this.attackspeed, AttributeModifier.Operation.ADDITION));
        }
        return multimap;


    }
}
