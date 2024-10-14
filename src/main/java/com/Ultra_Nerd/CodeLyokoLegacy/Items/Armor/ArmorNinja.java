package com.Ultra_Nerd.CodeLyokoLegacy.Items.Armor;

import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public final class ArmorNinja extends LyokoArmor {
    private static final float SPEED_MODIFIER = 0.4f;

    public ArmorNinja(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public AttributeModifiersComponent getAttributeModifiers() {
        final List<AttributeModifiersComponent.Entry> entries = new ArrayList<>();
        entries.add(new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_MOVEMENT_SPEED,new EntityAttributeModifier(Identifier.of("speed_modifier"),SPEED_MODIFIER, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL), AttributeModifierSlot.FEET));
        return new AttributeModifiersComponent(entries,true);
    }



    @Override
    public void onArmorTick(final PlayerEntity player, final World world, final Item armorItem,final int slot) {
        if(player.fallDistance > player.getSafeFallDistance()) {
            player.fallDistance = player.fallDistance / 2;
        }
        super.onArmorTick(player, world, armorItem,slot);
    }


}
