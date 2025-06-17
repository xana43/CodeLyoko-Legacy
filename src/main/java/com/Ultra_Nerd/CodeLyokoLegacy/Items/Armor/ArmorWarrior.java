package com.Ultra_Nerd.CodeLyokoLegacy.Items.Armor;

import net.minecraft.item.equipment.EquipmentType;

public final class ArmorWarrior extends LyokoArmor {

    private static final double movement_modifier = -0.1D;
    private static final double attack_modifier = 0.7D;
    private static final double attack_speed = -0.2D;

    public ArmorWarrior(net.minecraft.item.equipment.ArmorMaterial material, EquipmentType type, Settings settings) {
        super(material, type, settings);
    }

/*    @Override
    public AttributeModifiersComponent getAttributeModifiers() {
       final List<AttributeModifiersComponent.Entry> entries = new ArrayList<>();
       entries.add(new AttributeModifiersComponent.Entry(
               EntityAttributes.GENERIC_MOVEMENT_SPEED,new EntityAttributeModifier(Identifier.of("speed_modifier"),movement_modifier, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL), AttributeModifierSlot.FEET));
       entries.add(new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE,new EntityAttributeModifier(Identifier.of("attack_modifier"),attack_modifier, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),AttributeModifierSlot.CHEST));
       entries.add(new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED,new EntityAttributeModifier(Identifier.of("attack_speed"),attack_speed, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),AttributeModifierSlot.CHEST));
       return new AttributeModifiersComponent(entries,true);
    }*/


}
