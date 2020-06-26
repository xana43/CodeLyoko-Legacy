package com.Ultra_Nerd.CodeLyokoRemake15.items.tools;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;

public class ZweihanderWeapon extends SwordItem {
    private final float attackdamage;
    private final float attackspeed;

    public ZweihanderWeapon(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
        this.attackspeed = attackSpeedIn;
        this.attackdamage = (float)attackDamageIn + tier.getAttackDamage();
    }

    @Override
    public float getAttackDamage() {
        return this.attackdamage;
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
