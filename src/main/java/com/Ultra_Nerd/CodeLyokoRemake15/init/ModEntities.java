package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntityBlok;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntityFan;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntityLaser;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntities {


	public static final DeferredRegister<EntityType<?>> Entities = new DeferredRegister<>(ForgeRegistries.ENTITIES, Base.MOD_ID);
	public static final RegistryObject<EntityType<EntityBlok>> BLOK = Entities.register("blok", () ->
	EntityType.Builder.<EntityBlok>create(EntityBlok::new, EntityClassification.MONSTER).size(2f,2f)
	.build(new ResourceLocation(Base.MOD_ID,"blok").toString()));
	public static final RegistryObject<EntityType<EntityLaser>> LASER = Entities.register("laser", () ->
			EntityType.Builder.<EntityLaser>create(EntityLaser::new, EntityClassification.MISC).size(1f,1f)
					.build(new ResourceLocation(Base.MOD_ID,"laserarrow").toString()));
	public static final RegistryObject<EntityType<EntityFan>> FAN = Entities.register("fan",() ->
			EntityType.Builder.<EntityFan>create(EntityFan::new,EntityClassification.MISC).size(1,1).build(
					new ResourceLocation(Base.MOD_ID,"fan").toString()
			));

	/*public static void registerenit()
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
	}*/
}
