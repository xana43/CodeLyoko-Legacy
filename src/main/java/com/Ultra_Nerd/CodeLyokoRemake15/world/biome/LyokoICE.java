package com.Ultra_Nerd.CodeLyokoRemake15.world.biome;

import com.Ultra_Nerd.CodeLyokoRemake15.init.Modblocks;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class LyokoICE extends Biome {

	public LyokoICE() {
		super(new BiomeProperties("Lyoko Ice Sector").setBaseHeight(0).setHeightVariation(0.5f).setRainDisabled().setWaterColor(159).setTemperature(0));
		
		
	
		topBlock = Modblocks.DIGITAL_ICE.getDefaultState();
		fillerBlock = Modblocks.URANINITE_ORE.getDefaultState();
		this.decorator.ironGen = new WorldGenMinable(Modblocks.SILICA_SAND.getDefaultState(), 10);
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		
	
		
		// TODO Auto-generated constructor stub
	}
	
	
}
