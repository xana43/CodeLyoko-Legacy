package com.Ultra_Nerd.CodeLyokoRemake.world.biome;

import com.Ultra_Nerd.CodeLyokoRemake.init.Modblocks;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class Lyoko5 extends Biome {

	public Lyoko5() {
		super(new BiomeProperties("Sector 5").setBaseHeight(0).setHeightVariation(0.5f).setRainDisabled().setWaterColor(159).setTemperature(0));
		
		
	
		topBlock = Modblocks.SECTOR_5.getDefaultState();
		fillerBlock = Blocks.AIR.getDefaultState();
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		
		
	
		
		// TODO Auto-generated constructor stub
	}
	
	
}
