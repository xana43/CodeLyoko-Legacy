package com.Ultra_Nerd.CodeLyokoLegacy.items.armor;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public final class ArmorWarrior extends LyokoArmor {

    private static final double movement_modifier = -0.1D;
    private static final double attack_modifier = 0.7D;
    private static final double attack_speed = -0.2D;

    public ArmorWarrior(final @NotNull ArmorMaterial materialIn,final @NotNull ArmorItem.Type slot,
            final @NotNull Settings builder) {
        super(materialIn, slot, builder);


    }

    @Override
    public @NotNull Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(ItemStack stack,
            EquipmentSlot slot) {
        Multimap<EntityAttribute,EntityAttributeModifier> multimap = HashMultimap.create();

        if(slot == EquipmentSlot.FEET)
        {
            multimap.put(EntityAttributes.GENERIC_MOVEMENT_SPEED,new EntityAttributeModifier(UUID.fromString(
                    "91AEAA56-376B-4498-935B-2F7F68070635"),"speed_modifier",movement_modifier,
                        EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
        }
        if(slot == EquipmentSlot.CHEST)
        {
            multimap.put(EntityAttributes.GENERIC_ATTACK_DAMAGE,new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID,
                    "attack_modifier",attack_modifier, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
            multimap.put(EntityAttributes.GENERIC_ATTACK_SPEED,new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID,
                    "attack_speed",attack_speed,
                    EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
        }
        return multimap;
    }
    /*


    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public boolean isFoil(final @NotNull ItemStack pStack) {
        return false;
    }

    @Override
    public int getDefaultTooltipHideFlags(@NotNull final ItemStack stack) {
        return ItemStack.TooltipPart.ENCHANTMENTS.getMask();
    }

    @Override
    public void inventoryTick(final @NotNull ItemStack pStack, final @NotNull Level pLevel, final @NotNull Entity pEntity, final int pSlotId, final boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
        if(!pStack.isEnchanted())
        {
            pStack.enchant(Enchantments.BINDING_CURSE,Enchantments.BINDING_CURSE.getMaxLevel());
        }
    }


*/
}
