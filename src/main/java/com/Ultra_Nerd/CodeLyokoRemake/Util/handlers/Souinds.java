package com.Ultra_Nerd.CodeLyokoRemake.Util.handlers;

import com.Ultra_Nerd.CodeLyokoRemake.Util.ref;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class Souinds 
{
	public static SoundEvent ENTITY_BLOK_AMBIENT,ENTITY_BLOK_HURT,ENTITY_BLOK_DEATH,THEME,SHOOT,FOREST,ICE;
	
	public static void Regso()
	{	
		
		ENTITY_BLOK_AMBIENT = ReEs("entity.blok.ambient");
		ENTITY_BLOK_HURT = ReEs("entity.blok.hurt");
		THEME = ReEs("lyoko");
		SHOOT = ReEs("laser");
		FOREST = ReEs("forestsector");
		ICE = ReEs("icesector");
		
	}
	private static SoundEvent ReEs(String name)
	{
		ResourceLocation loc = new ResourceLocation(ref.MOD_ID, name);
		SoundEvent event = new SoundEvent(loc);
		event.setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		
		return event;
	}
}
