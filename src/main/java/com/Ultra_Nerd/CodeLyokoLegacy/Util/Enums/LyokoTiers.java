package com.Ultra_Nerd.CodeLyokoLegacy.Util.Enums;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public enum LyokoTiers implements ToolMaterial {

    LYOKO_FELINE(4, 2000, 900, 8),
    LyokoGuardian(4, 4000, 40, 30),
    LyokoNinja(4, 2000, 9000, 8),
    LyokoSamurai(4, 1000, 10, 25),
    LyokoTool(20, 250, 7.0f, 3.0f),
    LyokoWarrior(4, 4000, 0, 60),
    LyokoArcher(4, 2500, 9200, 8);

    private final int harvest, MaxUses;
    private final float attackDamage, efficiency;


    LyokoTiers(final int harvest,final int MaxUses,final float efficiency,final float attackDamage) {
        this.harvest = harvest;
        this.MaxUses = MaxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;


    }


    @Override
    public int getDurability() {
        return this.MaxUses;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.harvest;
    }

    @Override
    public int getEnchantability() {
        return Integer.MAX_VALUE;
    }


    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.EMPTY;
    }
}
