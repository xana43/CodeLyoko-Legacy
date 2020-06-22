package com.Ultra_Nerd.CodeLyokoRemake15.world.biome;

import com.Ultra_Nerd.CodeLyokoRemake15.init.Modblocks;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class LyokoDES extends Biome {

	public LyokoDES() {
		super(new BiomeProperties("Lyoko Desert sector").setBaseHeight(0).setHeightVariation(0.5f).setRainDisabled().setWaterColor(159).setTemperature(900));
		
		
	
		topBlock = Modblocks.DIGITA_SAND.getDefaultState();
		fillerBlock = Modblocks.URANINITE_ORE.getDefaultState();
		this.decorator.ironGen = new WorldGenMinable(Modblocks.SILICA_SAND.getDefaultState(), 10);
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		
	
		
		// TODO Auto-generated constructor stub
	}
	
	
}
