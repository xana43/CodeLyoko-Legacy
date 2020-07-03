package com.Ultra_Nerd.CodeLyokoRemake15.world.biome;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModEntities;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;

public class LyokoForest extends Biome {

	public LyokoForest(Builder builder) {
		super(builder);


	}

	@Override
	public int getSkyColor() {
		// TODO Auto-generated method stub
		return 3145569;
	}
	@Override
	protected void addSpawn(EntityClassification type, SpawnListEntry spawnListEntry) {
		super.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(ModEntities.BLOK.get(),1,1,2));
	}
}
