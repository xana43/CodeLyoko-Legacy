package com.Ultra_Nerd.CodeLyokoRemake15.world.biome;

import com.Ultra_Nerd.CodeLyokoRemake15.world.ModFeatures.DigitalForestTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;

public class LyokoForest extends Biome {

	public LyokoForest(Builder builder) {
		super(builder);
		//this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(ModEntities.BLOK.get(),20,1,4));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.MEGA_JUNGLE_TREE.withConfiguration(DigitalForestTree.DIGITAL_TREE_FOREST_CONFIG)
		.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(9,1,1))));
	}



}
