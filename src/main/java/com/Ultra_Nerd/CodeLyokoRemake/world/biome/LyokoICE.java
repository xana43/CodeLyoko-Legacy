package com.Ultra_Nerd.CodeLyokoRemake.world.biome;

import com.Ultra_Nerd.CodeLyokoRemake.Entity.Entityblok;
import com.Ultra_Nerd.CodeLyokoRemake.Util.handlers.Conf;
import com.Ultra_Nerd.CodeLyokoRemake.Util.handlers.Souinds;
import com.Ultra_Nerd.CodeLyokoRemake.init.ModDimensions;
import com.Ultra_Nerd.CodeLyokoRemake.init.Modblocks;
import com.Ultra_Nerd.CodeLyokoRemake.world.dimension.Lyoko;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.fml.relauncher.Side;

public class LyokoICE extends Biome {

	public LyokoICE() {
		super(new BiomeProperties("Lyoko Ice Sector").setBaseHeight(0).setHeightVariation(0.5f).setRainDisabled().setWaterColor(159).setTemperature(0));
		
		
		getSkyColorByTemp(0);
	
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
