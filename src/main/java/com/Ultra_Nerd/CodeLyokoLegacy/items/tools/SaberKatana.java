package com.Ultra_Nerd.CodeLyokoLegacy.items.tools;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
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
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public final class SaberKatana extends SwordItem {
    private final float attackdamage;
    private final float attackspeed;


    public SaberKatana(@NotNull Tier tier, int attackDamageIn, float attackSpeedIn, @NotNull Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
        this.attackspeed = attackSpeedIn;
        this.attackdamage = (float) attackDamageIn + tier.getAttackDamageBonus();
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public void inventoryTick(@Nonnull ItemStack stack, @Nonnull Level worldIn, @Nonnull Entity entityIn, int itemSlot, boolean isSelected) {

        if (entityIn instanceof final @NotNull Player player) {
            final ItemStack IStack = player.getItemInHand(InteractionHand.OFF_HAND);
            if (IStack.getItem() == ModItems.DIGITAL_SABER.get()) {

                player.getInventory().add(player.getInventory().getFreeSlot(), IStack);

            }
            player.setMainArm(HumanoidArm.RIGHT);
        }




        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @Override
    public @NotNull Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        Multimap<Attribute,AttributeModifier> multimap = HashMultimap.create();

        if (slot == EquipmentSlot.MAINHAND) {
            multimap.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", this.attackdamage, AttributeModifier.Operation.ADDITION));
            multimap.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier",  this.attackspeed, AttributeModifier.Operation.ADDITION));
        }
        return multimap;


    }
}
