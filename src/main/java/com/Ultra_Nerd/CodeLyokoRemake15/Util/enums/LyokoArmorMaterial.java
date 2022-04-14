package com.Ultra_Nerd.CodeLyokoRemake15.Util.enums;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public  enum LyokoArmorMaterial implements ArmorMaterial {


    WARRIOR(CodeLyokoMain.MOD_ID + ":william", 33, new byte[]{15, 19, 20, 15}, 420, ModSounds.LAZY_WARRIOR.get(), 10F),
    BLANKHELM(CodeLyokoMain.MOD_ID + ":blank", 5, new byte[]{15, 19, 20, 15}, 0, SoundEvents.ARMOR_EQUIP_CHAIN, 20f),
    FELINE(CodeLyokoMain.MOD_ID + ":odd", 25, new byte[]{4, 7, 9, 4}, 420, ModSounds.LAZY_FELINE.get(), 0F),
    NINJA(CodeLyokoMain.MOD_ID + ":yumi", 24, new byte[]{1, 4, 7, 2}, 420, ModSounds.LAZY_NINJA.get(), 0F),
    SAMURAI(CodeLyokoMain.MOD_ID + ":ulrich", 30, new byte[]{3, 6, 8, 3}, 420, ModSounds.LAZY_SAMURAI.get(), 10F),
    GUARDIAN(CodeLyokoMain.MOD_ID + ":aelita", 23, new byte[]{5, 8, 10, 5}, 420, ModSounds.LAZY_GUARDIAN.get(), 10F),
    ARCHER(CodeLyokoMain.MOD_ID + ":jeremy", 15, new byte[]{2, 4, 5, 2}, 420, ModSounds.LAZY_ARCHER.get(), 5),
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
    public int getDurabilityForSlot(@NotNull EquipmentSlot p_40410_) {
        return MAX_DAMAGE_ARRAY[p_40410_.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDefenseForSlot(@NotNull EquipmentSlot p_40411_) {
        return this.damageReduction[p_40411_.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
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


    @OnlyIn(Dist.CLIENT)
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
