package com.Ultra_Nerd.CodeLyokoRemake.world.biome;

import com.Ultra_Nerd.CodeLyokoRemake.init.Modblocks;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class LyokoFS extends Biome {

	public LyokoFS() {
		super(new BiomeProperties("Lyoko").setBaseHeight(0).setHeightVariation(0.5f).setRainDisabled().setWaterColor(3997440));
		topBlock = Modblocks.DIGITAL_BLOCK.getDefaultState();
		fillerBlock = Modblocks.URANINITE_ORE.getDefaultState();
		this.decorator.ironGen = new WorldGenMinable(Modblocks.SILICA_SAND.getDefaultState(), 10);
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		
		// TODO Auto-generated constructor stub
	}

}
