package com.Ultra_Nerd.CodeLyokoRemake15.Util.enums;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public enum LyokoTiers implements Tier {

    LYOKOFELINE(4, 2000, 900, 8),
    LyokoGuardian(4, 4000, 40, 60),
    LyokoNinja(4, 2000, 9000, 8),
    LyokoSamurai(4, 1000, 10, 25),
    LyokoTool(20, 250, 7.0f, 3.0f),
    LyokoWarrior(4, 4000, 0, 30),
    LyokoArcher(4, 2500, 9200, 8);

    private final int harvest, MaxUses;
    private final float attackdamage, efficiency;


    LyokoTiers(int harvest, int MaxUses, float efficiency, float attackdamage) {
        this.harvest = harvest;
        this.MaxUses = MaxUses;
        this.efficiency = efficiency;
        this.attackdamage = attackdamage;


    }




    @Override
    public int getUses() {
        return this.MaxUses;
    }

    @Override
    public float getSpeed() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.attackdamage;
    }

    @Override
    public int getLevel() {
        return this.harvest;
    }

    @Override
    public int getEnchantmentValue() {
        return 0;
    }


    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return Ingredient.EMPTY;
    }
}
