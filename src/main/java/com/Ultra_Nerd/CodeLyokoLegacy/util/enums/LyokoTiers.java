package com.Ultra_Nerd.CodeLyokoLegacy.util.enums;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import org.jetbrains.annotations.NotNull;

public enum LyokoTiers implements ToolMaterial {

    LYOKOFELINE(4, 2000, 900, 8),
    LyokoGuardian(4, 4000, 40, 60),
    LyokoNinja(4, 2000, 9000, 8),
    LyokoSamurai(4, 1000, 10, 25),
    LyokoTool(20, 250, 7.0f, 3.0f),
    LyokoWarrior(4, 4000, 0, 30),
    LyokoArcher(4, 2500, 9200, 8);

    private final int harvest, MaxUses;
    private final float attackdamage, efficiency;


    LyokoTiers(final int harvest,final int MaxUses,final float efficiency,final float attackdamage) {
        this.harvest = harvest;
        this.MaxUses = MaxUses;
        this.efficiency = efficiency;
        this.attackdamage = attackdamage;


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
        return this.attackdamage;
    }

    @Override
    public int getMiningLevel() {
        return this.harvest;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }


    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.EMPTY;
    }
}
