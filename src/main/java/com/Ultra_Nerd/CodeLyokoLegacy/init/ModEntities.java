package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityBlok;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityLaser;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.MegaTankEntity;
import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Pair;
import org.checkerframework.checker.units.qual.K;

import java.security.KeyPair;

public record ModEntities() {
  //entity type
    public static final EntityType<EntityBlok> BLOK = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER,EntityBlok::new).dimensions(EntityDimensions.fixed(2f,2f)).fireImmune().build();
    public static final EntityType<EntityLaser> LASER_ENTITY_TYPE = FabricEntityTypeBuilder.<EntityLaser>create(SpawnGroup.MISC,EntityLaser::new).build();
  public static final EntityType<MegaTankEntity> MEGATANK = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER,MegaTankEntity::new).dimensions(EntityDimensions.fixed(1,1)).fireImmune()
          .build();

    public static final ImmutableMap<String,EntityType<?>> ENTITY_TYPE_HASH_MAP = ImmutableMap.<String,EntityType<?>>builder()
            .put("blok",BLOK)
            .put("laser",LASER_ENTITY_TYPE)
            .put("megatank",MEGATANK)
            .build();
//entityRenderer






/*
    public static final DeferredRegister<EntityType<?>> Entities = DeferredRegister.create(ForgeRegistries.ENTITIES, CodeLyokoMain.MOD_ID);
    public static final RegistryObject<EntityType<EntityBlok>> BLOK = Entities.register("blok", () ->
            EntityType.Builder.of(EntityBlok::new, ConstantUtil.LYOKO).sized(2f, 2f)
                    .build(new ResourceLocation(CodeLyokoMain.MOD_ID, "blok").toString()));
    public static final RegistryObject<EntityType<EntityLaser>> LASER = Entities.register("laser", () ->
            EntityType.Builder.<EntityLaser>of(EntityLaser::new, MobCategory.MISC).sized(1f, 1f)
                    .build(new ResourceLocation(CodeLyokoMain.MOD_ID, ).toString()));
    public static final RegistryObject<EntityType<EntityFan>> FAN = Entities.register("fan", () ->
            EntityType.Builder.<EntityFan>of(EntityFan::new, MobCategory.MISC).sized(1, 1).build(
                    new ResourceLocation(CodeLyokoMain.MOD_ID, "fan").toString()
            ));
    public static final RegistryObject<EntityType<HornetEntity>> HORNET = Entities.register("hornet", () ->
            EntityType.Builder.of(HornetEntity::new,MobCategory.MONSTER).sized(1, 1)
                    .build(
                            new ResourceLocation(CodeLyokoMain.MOD_ID, "hornet").toString()
                    ));

    public static final RegistryObject<EntityType<MantaEntity>> MANTA = Entities.register("manta", () ->
            EntityType.Builder.of(MantaEntity::new, MobCategory.MONSTER).sized(3, 3)
                    .build(new ResourceLocation(CodeLyokoMain.MOD_ID, "manta").toString()));
    public static final RegistryObject<EntityType<EntitySkid>> SKID = Entities.register("skidbladnir", () ->
            EntityType.Builder.of(EntitySkid::new, MobCategory.MISC).sized(1, 1)
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

    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> entityTypeRegister)
    {

        SpawnPlacements.register(BLOK.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,EntityBlok::canSpawn);
        SpawnPlacements.register(MEGATANK.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE,MegaTankEntity::canSpawn);
    }
@SubscribeEvent
    public static void registerAttributes(@NotNull EntityAttributeCreationEvent event)
{
    event.put(BLOK.get(),EntityBlok.createMonsterAttributes().build());
    event.put(MEGATANK.get(),MegaTankEntity.registerAttributes().build());
    event.put(HORNET.get(),HornetEntity.registerAttributes().build());

}

 */


}
