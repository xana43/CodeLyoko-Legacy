package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntityLaser;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntitySkid;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.Entityblok;
import com.Ultra_Nerd.CodeLyokoRemake15.Util.ref;
import com.Ultra_Nerd.CodeLyokoRemake15.Util.handlers.Conf;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {

	public static void registerenit()
	{
		regen("blok", Entityblok.class, Conf.ENTITY_BLOK, 50,16777102 , 4802816 );
		regen("ski", EntitySkid.class, Conf.SKID, 209, 893790, 983402);
		regare("laser_arrow", EntityLaser.class, Conf.ENTITY_LARROW);
	}
	
	private static void regen(String name, Class<? extends Entity> entity, int id, int range, int c1, int c2)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(ref.MOD_ID + ":" + name), entity, name, id, Base.instance, range, 1, true, c1, c2);
	}
	
	
	private static void regare(String name, Class<? extends Entity> ent, int id)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(ref.MOD_ID + ":" + name), ent, name, id, Base.instance, 64, 30, true);
	}
}
