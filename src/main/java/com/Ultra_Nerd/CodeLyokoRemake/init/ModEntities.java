package com.Ultra_Nerd.CodeLyokoRemake.init;

import com.Ultra_Nerd.CodeLyokoRemake.Base;
import com.Ultra_Nerd.CodeLyokoRemake.Entity.Entityblok;
import com.Ultra_Nerd.CodeLyokoRemake.Util.ref;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {

	public static void registerenit()
	{
		regen("blok", Entityblok.class, ref.ENTITY_BLOK, 50,16777102 , 4802816 );
	}
	
	private static void regen(String name, Class<? extends Entity> entity, int id, int range, int c1, int c2)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(ref.MOD_ID + ":" + name), entity, name, id, Base.instance, range, 1, true, c1, c2);
	}
}
