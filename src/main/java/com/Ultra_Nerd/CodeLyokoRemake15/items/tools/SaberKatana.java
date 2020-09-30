package com.Ultra_Nerd.CodeLyokoRemake15.items.tools;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Hand;
import net.minecraft.util.HandSide;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class SaberKatana extends SwordItem {
    private final float attackdamage;
    private final float attackspeed;
    private byte timer = 127;

    public SaberKatana(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
        this.attackspeed = attackSpeedIn;
        this.attackdamage = (float) attackDamageIn + tier.getAttackDamage();
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        return stack.getDamage() >= stack.getMaxDamage();
    }

    @Override
    public void inventoryTick(@Nonnull ItemStack stack, @Nonnull World worldIn, @Nonnull Entity entityIn, int itemSlot, boolean isSelected) {

        if (entityIn instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entityIn;
            if (player.getHeldItem(Hand.OFF_HAND).getItem() instanceof Item) {
                ItemStack IStack = player.getHeldItem(Hand.OFF_HAND).getStack();
                if (player.getHeldItem(Hand.MAIN_HAND).getItem() == ModItems.DIGITAL_SABER.get()) {

                    player.inventory.add(player.inventory.getFirstEmptyStack(), IStack);

                }

            }
            player.setPrimaryHand(HandSide.RIGHT);
        }
        if (stack.getDamage() >= this.getMaxDamage(stack)) {
            stack.setDamage(this.getMaxDamage(stack));
        }

        if (timer-- == 0 && stack.getDamage() != 0) {
            stack.damageItem(-1, (PlayerEntity) entityIn, null);
            timer = 127;
        }

        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot, ItemStack stack) {
        Multimap multimap = HashMultimap.create();

        if (slot == EquipmentSlotType.MAINHAND) {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", this.attackdamage, AttributeModifier.Operation.ADDITION));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", this.attackspeed, AttributeModifier.Operation.ADDITION));
        }
        return multimap;


    }
}
