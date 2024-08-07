package com.Ultra_Nerd.CodeLyokoLegacy.Util.Enums;

import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

public enum LyokoTiers implements ToolMaterial {

    LYOKO_FELINE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4000, 900, 8),
    LyokoGuardian(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4000, 40, 30),
    LyokoNinja(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4000, 9000, 8),
    LyokoSamurai(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4000, 10, 25),
    LyokoTool(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 250, 7.0f, 3.0f),
    LyokoWarrior(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 8000, 0, 60),
    LyokoArcher(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4000, 9200, 8);

    private final int MaxUses;
    private final TagKey<Block> harvest;
    private final float attackDamage, efficiency;


    LyokoTiers(final TagKey<Block> harvest,final int MaxUses,final float efficiency,final float attackDamage) {
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
    public TagKey<Block> getInverseTag() {
        return harvest;
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
