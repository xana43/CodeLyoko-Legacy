package com.Ultra_Nerd.CodeLyokoLegacy.Util.Enums;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModSounds;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;



public enum LyokoArmorMaterial implements ArmorMaterial {


    WARRIOR("william", 33, new byte[]{15, 19, 20, 15}, 420, ModSounds.LAZY_WARRIOR, 10F,0),
    BLANK_HELM("blank", 5, new byte[]{15, 19, 20, 15}, 0, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 20f,0),
    FELINE("odd", 25, new byte[]{4, 7, 9, 4}, 420, ModSounds.LAZY_FELINE, 0F,0),
    NINJA("yumi", 24, new byte[]{1, 4, 7, 2}, 420, ModSounds.LAZY_NINJA, 0F,0),
    SAMURAI("ulrich", 30, new byte[]{3, 6, 8, 3}, 420, ModSounds.LAZY_SAMURAI, 10F,0),
    GUARDIAN("aelita", 23, new byte[]{5, 8, 10, 5}, 420, ModSounds.LAZY_GUARDIAN, 10F,0),
    ARCHER("jeremy", 15, new byte[]{2, 4, 5, 2}, 420, ModSounds.LAZY_ARCHER, 5,0),
    LINKER("linker", 10, new byte[]{1, 3, 4, 1}, 9000, null, 4,0);
    private static final byte[] MAX_DAMAGE_ARRAY = new byte[]{16, 16, 16, 16};
    private final String name;
    private final int maxDamageFactor;
    private final byte[] damageReduction;
    private final int enchant;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float knockBackResistance;


    LyokoArmorMaterial(final String nameIn, final int maxDamageFactor, final byte[] damageReductionIn, final int enchant, final SoundEvent soundsIn,
            final float toughnessIn,final float knockBackResistance) {
        this.name = nameIn;
        this.damageReduction = damageReductionIn;
        this.enchant = enchant;
        this.soundEvent = soundsIn;
        this.toughness = toughnessIn;
        this.knockBackResistance = knockBackResistance;
        this.maxDamageFactor = maxDamageFactor;
    }


    @Override
    public final int getDurability(final @NotNull ArmorItem.Type equipmentSlot) {
        return MAX_DAMAGE_ARRAY[equipmentSlot.getEquipmentSlot().getEntitySlotId()] * this.maxDamageFactor;
    }

    @Override
    public final int getProtection(final @NotNull ArmorItem.Type equipmentSlot) {
        return this.damageReduction[equipmentSlot.getEquipmentSlot().getEntitySlotId()];
    }

    @Override
    public final int getEnchantability() {
        return this.enchant;
    }

    @Override
    public final SoundEvent getEquipSound() {
        return this.soundEvent;
    }


    @Override
    public final @Nullable Ingredient getRepairIngredient() {
        return null;
    }



    @Override
    public final String getName() {
        return this.name;
    }

    @Override
    public final float getToughness() {
        return this.toughness;
    }

    @Override
    public final float getKnockbackResistance() {
        return knockBackResistance;
    }
}
