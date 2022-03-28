package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {


    public static final DeferredRegister<EntityType<?>> Entities = DeferredRegister.create(ForgeRegistries.ENTITIES, CodeLyokoMain.MOD_ID);

    public static final RegistryObject<EntityType<EntityBlok>> BLOK = Entities.register("blok", () ->
            EntityType.Builder.of(EntityBlok::new, MobCategory.MONSTER).sized(2f, 2f)
                    .build(new ResourceLocation(CodeLyokoMain.MOD_ID, "blok").toString()));
    public static final RegistryObject<EntityType<EntityLaser>> LASER = Entities.register("laser", () ->
            EntityType.Builder.<EntityLaser>of(EntityLaser::new, MobCategory.MISC).sized(1f, 1f)
                    .build(new ResourceLocation(CodeLyokoMain.MOD_ID, "laser").toString()));
    public static final RegistryObject<EntityType<EntityFan>> FAN = Entities.register("fan", () ->
            EntityType.Builder.<EntityFan>of(EntityFan::new, MobCategory.MISC).sized(1, 1).build(
                    new ResourceLocation(CodeLyokoMain.MOD_ID, "fan").toString()
            ));
    public static final RegistryObject<EntityType<HornetEntity>> HORNET = Entities.register("hornet", () ->
            EntityType.Builder.of(HornetEntity::new,MobCategory.MONSTER).sized(1, 1)
                    .build(
                            new ResourceLocation(CodeLyokoMain.MOD_ID, "hornet").toString()
                    ));
    public static final RegistryObject<EntityType<MegaTankEntity>> MEGATANK = Entities.register("megatank", () ->
            EntityType.Builder.of(MegaTankEntity::new, MobCategory.MONSTER).sized(3, 3)
                    .build(new ResourceLocation(CodeLyokoMain.MOD_ID, "megatank").toString()));
    public static final RegistryObject<EntityType<MantaEntity>> MANTA = Entities.register("manta", () ->
            EntityType.Builder.of(MantaEntity::new, MobCategory.MONSTER).sized(3, 3)
                    .build(new ResourceLocation(CodeLyokoMain.MOD_ID, "manta").toString()));
    public static final RegistryObject<EntityType<EntitySkid>> SKID = Entities.register("skidbladnir", () ->
            EntityType.Builder.<EntitySkid>of(EntitySkid::new, MobCategory.AMBIENT).sized(1, 1)
                    .build(new ResourceLocation(CodeLyokoMain.MOD_ID, "skid").toString()));
    public static final RegistryObject<EntityType<KankrelatEntity>> KANKRELAT = Entities.register("kankrelat", () ->
            EntityType.Builder.of(KankrelatEntity::new, MobCategory.MONSTER).sized(1, 1)
                    .build(new ResourceLocation(CodeLyokoMain.MOD_ID, "kankrelat").toString()));
    public static final RegistryObject<EntityType<HoverboardEntity>> HOVERBOARD = Entities.register("hoverboard", () ->
            EntityType.Builder.of(HoverboardEntity::new, MobCategory.MISC).sized(1, 1)
                    .build(new ResourceLocation(CodeLyokoMain.MOD_ID, "hoverboard").toString()));
    public static final RegistryObject<EntityType<OverboardEntity>> OVERBOARD = Entities.register("overboard", () ->
            EntityType.Builder.of(OverboardEntity::new, MobCategory.MISC).sized(2, 1)
                    .build(new ResourceLocation(CodeLyokoMain.MOD_ID, "overboard").toString()));
    public static final RegistryObject<EntityType<OverbikeEntity>> OVERBIKE = Entities.register("overbike", () ->
            EntityType.Builder.of(OverbikeEntity::new, MobCategory.MISC).sized(2, 1)
                    .build(new ResourceLocation(CodeLyokoMain.MOD_ID, "overbike").toString()));
    public static final RegistryObject<EntityType<GuardianEntity>> GUARDIAN = Entities.register("guardian", () ->
            EntityType.Builder.of(GuardianEntity::new, MobCategory.MONSTER).sized(8, 8)
                    .build(new ResourceLocation(CodeLyokoMain.MOD_ID, "guardian").toString()));


}
