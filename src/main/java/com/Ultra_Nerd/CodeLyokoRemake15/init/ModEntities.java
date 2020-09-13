package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.*;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntities {


    public static final DeferredRegister<EntityType<?>> Entities = DeferredRegister.create(ForgeRegistries.ENTITIES, Base.MOD_ID);

    public static final RegistryObject<EntityType<EntityBlok>> BLOK = Entities.register("blok", () ->
            EntityType.Builder.<EntityBlok>create(EntityBlok::new, EntityClassification.MONSTER).size(2f, 2f)
                    .build(new ResourceLocation(Base.MOD_ID, "blok").toString()));
    public static final RegistryObject<EntityType<EntityLaser>> LASER = Entities.register("laser", () ->
            EntityType.Builder.<EntityLaser>create(EntityLaser::new, EntityClassification.MISC).size(1f, 1f)
                    .build(new ResourceLocation(Base.MOD_ID, "laser").toString()));
    public static final RegistryObject<EntityType<EntityFan>> FAN = Entities.register("fan", () ->
            EntityType.Builder.<EntityFan>create(EntityFan::new, EntityClassification.MISC).size(1, 1).build(
                    new ResourceLocation(Base.MOD_ID, "fan").toString()
            ));
    public static final RegistryObject<EntityType<HornetEntity>> HORNET = Entities.register("hornet", () ->
            EntityType.Builder.<HornetEntity>create(HornetEntity::new, EntityClassification.MONSTER).size(1, 1)
                    .build(
                            new ResourceLocation(Base.MOD_ID, "hornet").toString()
                    ));
    public static final RegistryObject<EntityType<MegaTankEntity>> MEGATANK = Entities.register("megatank", () ->
            EntityType.Builder.<MegaTankEntity>create(MegaTankEntity::new,EntityClassification.MONSTER).size(3,3)
    .build(new ResourceLocation(Base.MOD_ID,"megatank").toString()));
    public static final RegistryObject<EntityType<MantaEntity>> MANTA = Entities.register("manta",() ->
            EntityType.Builder.<MantaEntity>create(MantaEntity::new,EntityClassification.MONSTER).size(3,3)
    .build(new ResourceLocation(Base.MOD_ID,"manta").toString()));
    public static final RegistryObject<EntityType<EntitySkid>> SKID = Entities.register("skidbladnir",() ->
            EntityType.Builder.<EntitySkid>create(EntitySkid::new,EntityClassification.AMBIENT).size(1,1)
    .build(new ResourceLocation(Base.MOD_ID,"skid").toString()));
    public static final RegistryObject<EntityType<KankrelatEntity>> KANKRELAT = Entities.register("kankrelat",() ->
            EntityType.Builder.<KankrelatEntity>create(KankrelatEntity::new,EntityClassification.MONSTER).size(1,1)
    .build(new ResourceLocation(Base.MOD_ID,"kankrelat").toString()));
    public static final RegistryObject<EntityType<HoverboardEntity>> HOVERBOARD = Entities.register("hoverboard", () ->
            EntityType.Builder.<HoverboardEntity>create(HoverboardEntity::new,EntityClassification.MISC).size(1,1)
    .build(new ResourceLocation(Base.MOD_ID,"hoverboard").toString()));
}
