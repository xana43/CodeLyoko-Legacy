package com.Ultra_Nerd.CodeLyokoLegacy.Items.Armor;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public final class ArmorNinja extends LyokoArmor {
    private static final float SPEED_MODIFIER = 0.4f;
    public ArmorNinja(@NotNull ArmorMaterial materialIn, @NotNull ArmorItem.Type slot, @NotNull Settings builder) {
        super(materialIn, slot, builder);
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(final ItemStack stack, final EquipmentSlot slot) {
        final Multimap<EntityAttribute,EntityAttributeModifier> modifierMultimap = HashMultimap.create();
        if(slot == EquipmentSlot.FEET)
        {
            modifierMultimap.put(EntityAttributes.GENERIC_MOVEMENT_SPEED,new EntityAttributeModifier("speed_modifier",
                    SPEED_MODIFIER,EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
        }

        return modifierMultimap;
    }

    @Override
    public void onArmorTick(final PlayerEntity player, final World world, final Item armorItem,final int slot) {
        if(player.fallDistance > player.getSafeFallDistance()) {
            player.fallDistance = player.fallDistance / 2;
        }
        super.onArmorTick(player, world, armorItem,slot);
    }


}
