package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum  LyokoArmorMaterial implements IArmorMaterial {



     WARRIOR(Base.MOD_ID + ":william",33 , new int[]{11,14,16,11}, 420 , ModSounds.LAZY_WARRIOR.get(), 10F, () -> {
        return Ingredient.fromItems(ModItems.PETABYTE.get());
    }),
    BLANKHELM(Base.MOD_ID + ":blank",5 , new int[]{8,9,10,8}, 0 , SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 10F, () -> {
        return Ingredient.fromItems(ModItems.PETABYTE.get());
    }),
    FELNINE(Base.MOD_ID + ":odd",25 , new int[]{4,7,9,4}, 420 , ModSounds.LAZY_FELINE.get(), 0F, () -> {
        return Ingredient.fromItems(ModItems.GIGABYTE.get());
    }),
    NINJA(Base.MOD_ID + ":yumi",24 , new int[]{1,4,7,2}, 420 , ModSounds.LAZY_NINJA.get(), 0F, () -> {
        return Ingredient.fromItems(ModItems.MEGABYTE.get());
    }),
    SAMURAI(Base.MOD_ID + ":ulrich",30 , new int[]{3,6,8,3}, 420 , ModSounds.LAZY_SAMURAI.get(), 10F, () -> {
        return Ingredient.fromItems(ModItems.GIGABYTE.get());
    }),
    GUARDIAN(Base.MOD_ID + ":aelita",23 , new int[]{5,8,10,5}, 420 , ModSounds.LAZY_GUARDIAN.get(), 10F, () -> {
        return Ingredient.fromItems(ModItems.TERABYTE.get());
    });

    private static final int[] MAX_DAMAGE_ARRAY = new int[] {16,16,16,16};
    private final String name;
    private final int maxDamageFactor;
    private  final int[] damageReduction;
    private final int enchant;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final LazyValue<Ingredient> redigitizeMaterial;

    private LyokoArmorMaterial(String nameIn, int maxDamageFactor, int[] damageReduction, int enchant, SoundEvent soundsIn,
                               float toughnessIn, Supplier<Ingredient> redigitizeMaterialIn)
    {
        this.name = nameIn;
        this.damageReduction = damageReduction;
        this.enchant = enchant;
        this.soundEvent = soundsIn;
        this.toughness = toughnessIn;
        this.redigitizeMaterial = new LazyValue<>(redigitizeMaterialIn);
        this.maxDamageFactor = maxDamageFactor;
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReduction[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchant;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.redigitizeMaterial.getValue();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }
}
