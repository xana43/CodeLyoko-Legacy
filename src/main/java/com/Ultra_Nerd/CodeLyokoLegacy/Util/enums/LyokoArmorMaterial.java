package com.Ultra_Nerd.CodeLyokoLegacy.Util.enums;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModSounds;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public enum LyokoArmorMaterial implements ArmorMaterial {


    WARRIOR(CodeLyokoMain.MOD_ID + ":william", 33, new byte[]{15, 19, 20, 15}, 420, ModSounds.LAZY_WARRIOR, 10F),
    BLANKHELM(CodeLyokoMain.MOD_ID + ":blank", 5, new byte[]{15, 19, 20, 15}, 0, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 20f),
    FELINE(CodeLyokoMain.MOD_ID + ":odd", 25, new byte[]{4, 7, 9, 4}, 420, ModSounds.LAZY_FELINE, 0F),
    NINJA(CodeLyokoMain.MOD_ID + ":yumi", 24, new byte[]{1, 4, 7, 2}, 420, ModSounds.LAZY_NINJA, 0F),
    SAMURAI(CodeLyokoMain.MOD_ID + ":ulrich", 30, new byte[]{3, 6, 8, 3}, 420, ModSounds.LAZY_SAMURAI, 10F),
    GUARDIAN(CodeLyokoMain.MOD_ID + ":aelita", 23, new byte[]{5, 8, 10, 5}, 420, ModSounds.LAZY_GUARDIAN, 10F),
    ARCHER(CodeLyokoMain.MOD_ID + ":jeremy", 15, new byte[]{2, 4, 5, 2}, 420, ModSounds.LAZY_ARCHER, 5),
    LINKER(CodeLyokoMain.MOD_ID + ":linker", 10, new byte[]{1, 3, 4, 1}, 9000, null, 4);
    private static final byte[] MAX_DAMAGE_ARRAY = new byte[]{16, 16, 16, 16};
    private final String name;
    private final int maxDamageFactor;
    private final byte[] damageReduction;
    private final int enchant;
    private final SoundEvent soundEvent;
    private final float toughness;


    LyokoArmorMaterial(String nameIn, int maxDamageFactor, byte[] damageReduction, int enchant, SoundEvent soundsIn,
                       float toughnessIn) {
        this.name = nameIn;
        this.damageReduction = damageReduction;
        this.enchant = enchant;
        this.soundEvent = soundsIn;
        this.toughness = toughnessIn;

        this.maxDamageFactor = maxDamageFactor;
    }




    @Override
    public int getDurability(@NotNull EquipmentSlot equipmentSlot) {
        return MAX_DAMAGE_ARRAY[equipmentSlot.getEntitySlotId()] * this.maxDamageFactor;
    }

    @Override
    public int getProtectionAmount(@NotNull EquipmentSlot p_40411_) {
        return this.damageReduction[p_40411_.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return this.enchant;
    }

    @Override
    public @NotNull SoundEvent getEquipSound() {
        return this.soundEvent;
    }


    @Override
    public @Nullable Ingredient getRepairIngredient() {
        return null;
    }



    @Nonnull
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
