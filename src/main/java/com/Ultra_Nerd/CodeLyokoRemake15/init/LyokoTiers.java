package com.Ultra_Nerd.CodeLyokoRemake15.init;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

public enum LyokoTiers implements IItemTier{
	
	LYOKOFELINE(4, 2000, 900, 6, 90, () -> {
		return Ingredient.fromItems(ModItems.SOLID_QUANTUM.get());
	}),
	LyokoGuardian(4, 4000, 40, 60, 100, () ->{
		return Ingredient.fromItems(ModItems.SOLID_QUANTUM.get());
	}),
	LyokoNinja(4, 2000, 9000, 6, 90, () ->{
		return Ingredient.fromItems(ModItems.SOLID_QUANTUM.get());
	}),
	LyokoSamurai(4 ,1000, 10, 25, 80, () -> {
		return Ingredient.fromItems(ModItems.SOLID_QUANTUM.get());
	}),
	LyokoTool(20, 250, 7.0f, 3.0f, 900, () -> {
		return Ingredient.fromItems(ModItems.SOLID_QUANTUM.get());
	}),
	LyokoWarrior(4, 4000, 20, 30, 9000, () ->{
		return Ingredient.fromItems(ModItems.SOLID_QUANTUM.get());
	});
	private final int harvest,MaxUses,enchantability;
	private final float attackdamage,efficiency;
	private final LazyValue<Ingredient> anvilmat;
	
	private LyokoTiers(int harvest, int MaxUses,float efficiency,float attackdamage,int enchantability, Supplier<Ingredient> anvilmat)
	{
		this.harvest = harvest;
		this.MaxUses = MaxUses;
		this.efficiency = efficiency;
		this .anvilmat = new LazyValue<>(anvilmat);
		this.attackdamage = attackdamage;
		this.enchantability = enchantability;
	}
	
    
	
	


	@Override
	public int getMaxUses() {
		// TODO Auto-generated method stub
		return this.MaxUses;
	}

	@Override
	public float getEfficiency() {
		// TODO Auto-generated method stub
		return this.efficiency;
	}

	@Override
	public float getAttackDamage() {
		// TODO Auto-generated method stub
		return this.attackdamage;
	}

	@Override
	public int getHarvestLevel() {
		// TODO Auto-generated method stub
		return this.harvest;
	}

	@Override
	public int getEnchantability() {
		// TODO Auto-generated method stub
		return this.enchantability;
	}

	@Override
	public Ingredient getRepairMaterial() {
		// TODO Auto-generated method stub
		return this.anvilmat.getValue();
	}
}
