package com.Ultra_Nerd.CodeLyokoRemake15.items.tools;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

import javax.annotation.Nonnull;

public class SaberKatana extends SwordItem {
    private final float attackdamage;
    private final float attackspeed;
    private byte timer = 127;

    public SaberKatana(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
        this.attackspeed = attackSpeedIn;
        this.attackdamage = (float) attackDamageIn + tier.getAttackDamageBonus();
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        return stack.getDamageValue() >= stack.getMaxDamage();
    }

    @Override
    public void inventoryTick(@Nonnull ItemStack stack, @Nonnull Level worldIn, @Nonnull Entity entityIn, int itemSlot, boolean isSelected) {

        if (entityIn instanceof Player) {
            Player player = (Player) entityIn;
            ItemStack IStack = player.getItemInHand(InteractionHand.OFF_HAND);
            if (player.getItemInHand(InteractionHand.MAIN_HAND).getItem() == ModItems.DIGITAL_SABER.get()) {

                player.getInventory().add(player.getInventory().getFreeSlot(), IStack);

            }
            player.setMainArm(HumanoidArm.RIGHT);
        }
        if (stack.getDamageValue() >= this.getMaxDamage(stack)) {
            stack.setDamageValue(this.getMaxDamage(stack));
        }

        if (timer-- == 0 && stack.getDamageValue() != 0) {
            stack.getItem().damageItem(stack,-1, (Player) entityIn, null);
            timer = 127;
        }

        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
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
