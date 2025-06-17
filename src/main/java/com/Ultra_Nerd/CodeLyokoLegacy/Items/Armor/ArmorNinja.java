package com.Ultra_Nerd.CodeLyokoLegacy.Items.Armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.world.World;

public final class ArmorNinja extends LyokoArmor {
    private static final float SPEED_MODIFIER = 0.4f;

    public ArmorNinja(net.minecraft.item.equipment.ArmorMaterial material, EquipmentType type, Settings settings) {
        super(material, type, settings);
    }


/*    @Override
    public AttributeModifiersComponent getAttributeModifiers() {
        final List<AttributeModifiersComponent.Entry> entries = new ArrayList<>();
        entries.add(new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_MOVEMENT_SPEED,new EntityAttributeModifier(Identifier.of("speed_modifier"),SPEED_MODIFIER, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL), AttributeModifierSlot.FEET));
        return new AttributeModifiersComponent(entries,true);
    }*/


    @Override
    public void onArmorTick(PlayerEntity player, World world, Item armorItem, EquipmentSlot slot) {
        super.onArmorTick(player, world, armorItem, slot);
        if(player.fallDistance > player.getSafeFallDistance()) {
            player.fallDistance = player.fallDistance / 2;
        }
    }


}
