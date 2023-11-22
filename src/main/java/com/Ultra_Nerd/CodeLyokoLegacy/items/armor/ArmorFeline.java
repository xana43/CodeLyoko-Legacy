package com.Ultra_Nerd.CodeLyokoLegacy.items.armor;

import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModItems;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public final class ArmorFeline extends LyokoArmor {


    private static final double movement_modifier = 0.6;
    private static final StatusEffectInstance JUMPEFFECT = new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1, 3,
            true, false, false);


    public ArmorFeline(@NotNull ArmorMaterial materialIn, @NotNull ArmorItem.Type slot, @NotNull Settings builder) {
        super(materialIn, slot, builder);


    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(final ItemStack stack, final EquipmentSlot slot) {
        Multimap<EntityAttribute, EntityAttributeModifier> multimap = HashMultimap.create();
        if (slot == EquipmentSlot.FEET) {
            multimap.put(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                    new EntityAttributeModifier(UUID.fromString("91AEAA56-376B-4498-935B-2F7F68070635"),
                            "speed_modifier", movement_modifier, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
        }


        return multimap;
    }

    @Override
    public void inventoryTick(final ItemStack stack, final World pLevel, final Entity pEntity, final int pSlotId, final boolean pIsSelected) {
        super.inventoryTick(stack, pLevel, pEntity, pSlotId, pIsSelected);


    }



    @Override
    public void onArmorTick(final PlayerEntity player, final World world, final Item armorItem,final int slot) {
        super.onArmorTick(player,world,armorItem,slot);
        if (player.getInventory().getArmorStack(EquipmentSlot.FEET.getEntitySlotId())
                .getItem() == ModItems.ODD_BOOTS && player.getInventory()
                .getArmorStack(EquipmentSlot.LEGS.getEntitySlotId()).getItem() == ModItems.ODD_LEGGINGS) {
            if (!player.hasStatusEffect(StatusEffects.JUMP_BOOST)) {

                player.addStatusEffect(JUMPEFFECT);


            }
            player.fallDistance = 0;
        }


    }


}
