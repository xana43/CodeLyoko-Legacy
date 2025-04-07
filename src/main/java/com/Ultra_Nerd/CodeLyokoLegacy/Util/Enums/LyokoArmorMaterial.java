package com.Ultra_Nerd.CodeLyokoLegacy.Util.Enums;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModSounds;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;


public enum LyokoArmorMaterial {

    WARRIOR("william", Util.make(new EnumMap<>(ArmorItem.Type.class), enumMap -> {
        enumMap.put(ArmorItem.Type.BOOTS,15);
        enumMap.put(ArmorItem.Type.LEGGINGS,20);
        enumMap.put(ArmorItem.Type.CHESTPLATE,19);
        enumMap.put(ArmorItem.Type.HELMET,15);
        enumMap.put(ArmorItem.Type.BODY,19);
    }),420,ModSounds.LAZY_WARRIOR,33,10f, Ingredient::ofItems),
    BLANK_HELM("blank", Util.make(new EnumMap<>(ArmorItem.Type.class),
            typeIntegerEnumMap -> {
                typeIntegerEnumMap.put(ArmorItem.Type.BOOTS,15);
                typeIntegerEnumMap.put(ArmorItem.Type.LEGGINGS,20);
                typeIntegerEnumMap.put(ArmorItem.Type.CHESTPLATE,19);
                typeIntegerEnumMap.put(ArmorItem.Type.HELMET,15);
                typeIntegerEnumMap.put(ArmorItem.Type.BODY,19);
            }), 0, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,20, 0,Ingredient::ofItems),
    FELINE("odd", Util.make(new EnumMap<>(ArmorItem.Type.class),
            typeIntegerEnumMap -> {
                typeIntegerEnumMap.put(ArmorItem.Type.BOOTS,15);
                typeIntegerEnumMap.put(ArmorItem.Type.LEGGINGS,20);
                typeIntegerEnumMap.put(ArmorItem.Type.CHESTPLATE,19);
                typeIntegerEnumMap.put(ArmorItem.Type.HELMET,15);
                typeIntegerEnumMap.put(ArmorItem.Type.BODY,19);
            }), 0, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,20, 0,Ingredient::ofItems),
    NINJA("yumi", Util.make(new EnumMap<>(ArmorItem.Type.class),
            typeIntegerEnumMap -> {
                typeIntegerEnumMap.put(ArmorItem.Type.BOOTS,15);
                typeIntegerEnumMap.put(ArmorItem.Type.LEGGINGS,20);
                typeIntegerEnumMap.put(ArmorItem.Type.CHESTPLATE,19);
                typeIntegerEnumMap.put(ArmorItem.Type.HELMET,15);
                typeIntegerEnumMap.put(ArmorItem.Type.BODY,19);
            }), 0, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,20, 0,Ingredient::ofItems),
    SAMURAI("ulrich", Util.make(new EnumMap<>(ArmorItem.Type.class),
            typeIntegerEnumMap -> {
                typeIntegerEnumMap.put(ArmorItem.Type.BOOTS,15);
                typeIntegerEnumMap.put(ArmorItem.Type.LEGGINGS,20);
                typeIntegerEnumMap.put(ArmorItem.Type.CHESTPLATE,19);
                typeIntegerEnumMap.put(ArmorItem.Type.HELMET,15);
                typeIntegerEnumMap.put(ArmorItem.Type.BODY,19);
            }), 0, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,20, 0,Ingredient::ofItems),
    GUARDIAN("aelita", Util.make(new EnumMap<>(ArmorItem.Type.class),
            typeIntegerEnumMap -> {
                typeIntegerEnumMap.put(ArmorItem.Type.BOOTS,15);
                typeIntegerEnumMap.put(ArmorItem.Type.LEGGINGS,20);
                typeIntegerEnumMap.put(ArmorItem.Type.CHESTPLATE,19);
                typeIntegerEnumMap.put(ArmorItem.Type.HELMET,15);
                typeIntegerEnumMap.put(ArmorItem.Type.BODY,19);
            }), 0, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,20, 0,Ingredient::ofItems),
    ARCHER("jeremy", Util.make(new EnumMap<>(ArmorItem.Type.class),
            typeIntegerEnumMap -> {
                typeIntegerEnumMap.put(ArmorItem.Type.BOOTS,15);
                typeIntegerEnumMap.put(ArmorItem.Type.LEGGINGS,20);
                typeIntegerEnumMap.put(ArmorItem.Type.CHESTPLATE,19);
                typeIntegerEnumMap.put(ArmorItem.Type.HELMET,15);
                typeIntegerEnumMap.put(ArmorItem.Type.BODY,19);
            }), 0, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,20, 0,Ingredient::ofItems),
    LINKER("linker", Util.make(new EnumMap<>(ArmorItem.Type.class),
            typeIntegerEnumMap -> {
                typeIntegerEnumMap.put(ArmorItem.Type.BOOTS,15);
                typeIntegerEnumMap.put(ArmorItem.Type.LEGGINGS,20);
                typeIntegerEnumMap.put(ArmorItem.Type.CHESTPLATE,19);
                typeIntegerEnumMap.put(ArmorItem.Type.HELMET,15);
                typeIntegerEnumMap.put(ArmorItem.Type.BODY,19);
            }), 0, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,20, 0,Ingredient::ofItems),
    ;

    private final RegistryEntry<ArmorMaterial> materialRegistryEntry;

    LyokoArmorMaterial(final String nameIn, final EnumMap<ArmorItem.Type,Integer>defense , final int enchant, final RegistryEntry<SoundEvent> soundsIn, final float toughnessIn,final float knockBackResistance,final Supplier<Ingredient> repairMaterialSupplier) {

        materialRegistryEntry = create(nameIn,defense,enchant,soundsIn,toughnessIn,knockBackResistance,repairMaterialSupplier);
    }

    LyokoArmorMaterial(final String nameIn, final EnumMap<ArmorItem.Type,Integer>defense , final int enchant, final RegistryEntry<SoundEvent> soundsIn, final float toughnessIn,final float knockBackResistance,final Supplier<Ingredient> repairMaterialSupplier,final List<ArmorMaterial.Layer> layers) {

        materialRegistryEntry = create(nameIn,defense,enchant,soundsIn,toughnessIn,knockBackResistance,repairMaterialSupplier,layers);
    }

    public RegistryEntry<ArmorMaterial> getMaterialRegistryEntry() {
        return materialRegistryEntry;
    }

    private static RegistryEntry<ArmorMaterial> create(final String id, final EnumMap<ArmorItem.Type,Integer> defense, final int enchantibility, final RegistryEntry<SoundEvent> equipSound, final float toughness, final float knockBackResistance, final Supplier<Ingredient> repairIngredient) {
        final List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(CodeLyokoMain.codeLyokoPrefix(id)));
        return create(id,defense,enchantibility,equipSound,toughness,knockBackResistance,repairIngredient,list);
    }
    private static RegistryEntry<ArmorMaterial> create(final String id,final EnumMap<ArmorItem.Type,Integer> defense,final int enchantability,final RegistryEntry<SoundEvent> equipSound,final float toughness,final float knockBackResistance,final Supplier<Ingredient> repairIngredient,final List<ArmorMaterial.Layer> layers) {
        final EnumMap<ArmorItem.Type,Integer> map = new EnumMap<>(ArmorItem.Type.class);
        final ArmorItem.Type[] values = ArmorItem.Type.values();
        for (final ArmorItem.Type typeValue : values) {
            map.put(typeValue, defense.get(typeValue));
        }
        return Registry.registerReference(Registries.ARMOR_MATERIAL, CodeLyokoMain.codeLyokoPrefix(id),new ArmorMaterial(map,enchantability,equipSound,repairIngredient,layers,toughness,knockBackResistance));
    }


}
