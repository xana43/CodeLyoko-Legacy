package com.Ultra_Nerd.CodeLyokoLegacy.Util.Enums;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

public enum LyokoTiers {

    LYOKO_FELINE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4000, 900, 8),
    LyokoGuardian(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4000, 40, 30),
    LyokoNinja(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4000, 9000, 8),
    LyokoSamurai(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4000, 10, 25),
    LyokoTool(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 250, 7.0f, 3.0f),
    LyokoWarrior(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 8000, 0, 60),
    LyokoArcher(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4000, 9200, 8);

    private final ToolMaterial material;


    LyokoTiers(final TagKey<Block> harvest,final int MaxUses,final float efficiency,final float attackDamage) {
        this(harvest,MaxUses,efficiency,attackDamage,Integer.MAX_VALUE);
    }
    LyokoTiers(final TagKey<Block> harvest,final int MaxUses,final float efficiency,final float attackDamage,final int enchantability) {
        this(harvest, MaxUses, efficiency, attackDamage,enchantability,null);
    }
    LyokoTiers(final TagKey<Block> harvest,final int MaxUses,final float efficiency,final float attackDamage,final int enchantability,final TagKey<Item> repairItem) {
        material = createMaterial(harvest,MaxUses,efficiency,attackDamage,enchantability,repairItem);
    }
    public ToolMaterial getMaterial() {
        return material;
    }
    private static ToolMaterial createMaterial(final TagKey<Block> harvest, final int durability, final float speed, final float attackDamage, final int enchantability, final TagKey<Item> repairMaterial) {
        return new ToolMaterial(harvest,durability,speed,attackDamage,enchantability,repairMaterial);
    }
}
