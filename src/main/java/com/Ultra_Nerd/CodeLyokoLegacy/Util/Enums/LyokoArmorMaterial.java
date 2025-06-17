package com.Ultra_Nerd.CodeLyokoLegacy.Util.Enums;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModSounds;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Util;

import java.util.EnumMap;


public enum LyokoArmorMaterial {

    WARRIOR("william",10, Util.make(new EnumMap<>(EquipmentType.class), enumMap -> {
        enumMap.put(EquipmentType.BOOTS,15);
        enumMap.put(EquipmentType.LEGGINGS,20);
        enumMap.put(EquipmentType.CHESTPLATE,19);
        enumMap.put(EquipmentType.HELMET,15);
        enumMap.put(EquipmentType.BODY,19);
    }),420,ModSounds.LAZY_WARRIOR,33,10f, null),
    BLANK_HELM("blank",90 ,Util.make(new EnumMap<>(EquipmentType.class),
            typeIntegerEnumMap -> {
                typeIntegerEnumMap.put(EquipmentType.BOOTS,15);
                typeIntegerEnumMap.put(EquipmentType.LEGGINGS,20);
                typeIntegerEnumMap.put(EquipmentType.CHESTPLATE,19);
                typeIntegerEnumMap.put(EquipmentType.HELMET,15);
                typeIntegerEnumMap.put(EquipmentType.BODY,19);
            }), 1, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,20, 0,null),
    FELINE("odd",10, Util.make(new EnumMap<>(EquipmentType.class),
            typeIntegerEnumMap -> {
                typeIntegerEnumMap.put(EquipmentType.BOOTS,15);
                typeIntegerEnumMap.put(EquipmentType.LEGGINGS,20);
                typeIntegerEnumMap.put(EquipmentType.CHESTPLATE,19);
                typeIntegerEnumMap.put(EquipmentType.HELMET,15);
                typeIntegerEnumMap.put(EquipmentType.BODY,19);
            }), 1, ModSounds.LAZY_FELINE,20, 0,null),
    NINJA("yumi",10, Util.make(new EnumMap<>(EquipmentType.class),
            typeIntegerEnumMap -> {
                typeIntegerEnumMap.put(EquipmentType.BOOTS,15);
                typeIntegerEnumMap.put(EquipmentType.LEGGINGS,20);
                typeIntegerEnumMap.put(EquipmentType.CHESTPLATE,19);
                typeIntegerEnumMap.put(EquipmentType.HELMET,15);
                typeIntegerEnumMap.put(EquipmentType.BODY,19);
            }), 1, ModSounds.LAZY_NINJA,20, 0,null),
    SAMURAI("ulrich",10, Util.make(new EnumMap<>(EquipmentType.class),
            typeIntegerEnumMap -> {
                typeIntegerEnumMap.put(EquipmentType.BOOTS,15);
                typeIntegerEnumMap.put(EquipmentType.LEGGINGS,20);
                typeIntegerEnumMap.put(EquipmentType.CHESTPLATE,19);
                typeIntegerEnumMap.put(EquipmentType.HELMET,15);
                typeIntegerEnumMap.put(EquipmentType.BODY,19);
            }), 1, ModSounds.LAZY_SAMURAI,20, 0,null),
    GUARDIAN("aelita",10, Util.make(new EnumMap<>(EquipmentType.class),
            typeIntegerEnumMap -> {
                typeIntegerEnumMap.put(EquipmentType.BOOTS,15);
                typeIntegerEnumMap.put(EquipmentType.LEGGINGS,20);
                typeIntegerEnumMap.put(EquipmentType.CHESTPLATE,19);
                typeIntegerEnumMap.put(EquipmentType.HELMET,15);
                typeIntegerEnumMap.put(EquipmentType.BODY,19);
            }), 1, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,20, 0,null),
    ARCHER("jeremy",10, Util.make(new EnumMap<>(EquipmentType.class),
            typeIntegerEnumMap -> {
                typeIntegerEnumMap.put(EquipmentType.BOOTS,15);
                typeIntegerEnumMap.put(EquipmentType.LEGGINGS,20);
                typeIntegerEnumMap.put(EquipmentType.CHESTPLATE,19);
                typeIntegerEnumMap.put(EquipmentType.HELMET,15);
                typeIntegerEnumMap.put(EquipmentType.BODY,19);
            }), 1, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,20, 0,null),
    LINKER("linker",10, Util.make(new EnumMap<>(EquipmentType.class),
            typeIntegerEnumMap -> {
                typeIntegerEnumMap.put(EquipmentType.BOOTS,15);
                typeIntegerEnumMap.put(EquipmentType.LEGGINGS,20);
                typeIntegerEnumMap.put(EquipmentType.CHESTPLATE,19);
                typeIntegerEnumMap.put(EquipmentType.HELMET,15);
                typeIntegerEnumMap.put(EquipmentType.BODY,19);
            }), 1, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,20, 0,null),
    ;

    private final ArmorMaterial materialEntry;

    LyokoArmorMaterial(final String nameIn,final int baseDurability, final EnumMap<EquipmentType,Integer>defense , final int enchant, final RegistryEntry<SoundEvent> soundsIn, final float toughnessIn,final float knockBackResistance,final TagKey<Item> repairMaterialSupplier) {

        materialEntry = create(nameIn,baseDurability,defense,enchant,soundsIn,toughnessIn,knockBackResistance,repairMaterialSupplier);
    }

    LyokoArmorMaterial(final String nameIn,final int baseDurability,final EnumMap<EquipmentType,Integer>defense , final int enchant, final RegistryEntry<SoundEvent> soundsIn, final float toughnessIn,final float knockBackResistance,final TagKey<Item> repairMaterialSupplier,final RegistryKey<EquipmentAsset> layers) {

        materialEntry = create(nameIn,baseDurability,defense,enchant,soundsIn,toughnessIn,knockBackResistance,repairMaterialSupplier,layers);
    }

    public ArmorMaterial getMaterial() {
        return materialEntry;
    }

    private static ArmorMaterial create(final String id,final int baseDurability ,final EnumMap<EquipmentType,Integer> defense, final int enchantibility, final RegistryEntry<SoundEvent> equipSound, final float toughness, final float knockBackResistance, final TagKey<Item> repairIngredient) {
        RegistryKey<EquipmentAsset> equipmentAssetRegistryKey = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY,CodeLyokoMain.codeLyokoPrefix(id));
        return create(id,baseDurability,defense,enchantibility,equipSound,toughness,knockBackResistance,repairIngredient,equipmentAssetRegistryKey);
    }
    private static ArmorMaterial create(final String id, final int baseDurability, final EnumMap<EquipmentType,Integer> defense, final int enchantability, final RegistryEntry<SoundEvent> equipSound, final float toughness, final float knockBackResistance, final TagKey<Item> repairIngredient, final RegistryKey<EquipmentAsset> asset) {
        final EnumMap<EquipmentType,Integer> map = new EnumMap<>(EquipmentType.class);
        final EquipmentType[] values = EquipmentType.values();
        for (final EquipmentType typeValue : values) {
            map.put(typeValue, defense.get(typeValue));
        }
        return new ArmorMaterial(baseDurability,map,enchantability,equipSound,toughness,knockBackResistance,repairIngredient,asset);
    }


}
