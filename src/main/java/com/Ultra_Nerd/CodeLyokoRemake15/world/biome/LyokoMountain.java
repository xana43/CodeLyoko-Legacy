package com.Ultra_Nerd.CodeLyokoRemake15.world.biome;

import com.Ultra_Nerd.CodeLyokoRemake15.world.ModFeatures.DigitalMountainTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;

public class LyokoMountain extends Biome {
	public LyokoMountain(Builder biomeBuilder) {
		super(biomeBuilder);

		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.ACACIA_TREE.withConfiguration(DigitalMountainTree.DIGITAL_TREE_MOUNATIN_CONFIG)
				.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1,0.1f,0))));

	}

	

}
