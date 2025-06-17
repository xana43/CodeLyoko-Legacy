package com.Ultra_Nerd.CodeLyokoLegacy.Init.Common;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.DecorationEntities.XanaSymbolEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.HostileEntities.*;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.ProjectileEntities.FanEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.ProjectileEntities.LaserEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.SamuraiClass.ServerTriplicateCloneEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.VehicleEntities.HoverboardEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.VehicleEntities.OverbikeEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.VehicleEntities.OverboardEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.VehicleEntities.SkidbladnirEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public record ModEntities() {
    //entity type
    public static final EntityType<KankrelatEntity> KANKRELAT = registerEntities("kankrelat",EntityType.Builder.create(KankrelatEntity::new,SpawnGroup.MONSTER)
            .dimensions(1,1));
    public static final EntityType<BlokEntity> BLOK = registerEntities("blok",EntityType.Builder.create(BlokEntity::new,SpawnGroup.MONSTER)
            .dimensions(2, 2));
    public static final EntityType<LaserEntity> LASER_ENTITY_TYPE = registerEntities("laser",EntityType.Builder.create(
            LaserEntity::new,SpawnGroup.MISC));
    public static final EntityType<MegaTankEntity> MEGATANK = registerEntities("megatank",EntityType.Builder.create(
                    MegaTankEntity::new,SpawnGroup.MONSTER)
            .dimensions(1, 1)
            .makeFireImmune());
    public static final EntityType<HornetEntity> HORNET_ENTITY_ENTITY_TYPE = registerEntities("hornet",EntityType.Builder
            .create(HornetEntity::new,SpawnGroup.MONSTER)
            .dimensions(1, 1));
    public static final EntityType<OverboardEntity> OVERBOARD = registerEntities("overboard",EntityType.Builder.create(
            OverboardEntity::new,SpawnGroup.MISC)
            .dimensions(2, 1));

    public static final EntityType<OverbikeEntity> OVERBIKE = registerEntities("overbike",EntityType.Builder.create(
            OverbikeEntity::new,SpawnGroup.MISC
    ));
    public static final EntityType<LyokoGuardianEntity> LYOKO_GUARDIAN_ENTITY_TYPE = registerEntities("lyoko_guardian",
            EntityType.Builder.create(LyokoGuardianEntity::new,SpawnGroup.MONSTER)
            .dimensions(4,4)
                    .makeFireImmune()
    );
    public static final EntityType<HoverboardEntity> HOVERBOARD =
            registerEntities("hoverboard",EntityType.Builder.create(HoverboardEntity::new,SpawnGroup.MISC)
                    .dimensions(1, 1));
    public static final EntityType<FanEntity> FAN_ENTITY_TYPE =
            registerEntities("fan",EntityType.Builder.create(FanEntity::new,SpawnGroup.MISC));

    public static final EntityType<SkidbladnirEntity> SKID_ENTITY_TYPE =
            registerEntities("skidbladnir",EntityType.Builder.create(SkidbladnirEntity::new,SpawnGroup.MISC));
    //decoration entities
    public static final EntityType<XanaSymbolEntity> XANA_SYMBOL_ENTITY_TYPE =
            registerEntities("xana_symbol",EntityType.Builder.create(XanaSymbolEntity::new,SpawnGroup.MISC));
    public static final EntityType<ServerTriplicateCloneEntity> TRIPLICATE_ENTITY_TYPE = registerEntities("triplicate_entity",EntityType.Builder.create(ServerTriplicateCloneEntity::new,SpawnGroup.MISC)
            .disableSaving()
            .dimensions(0.6f,1.8f)
            .maxTrackingRange(32).trackingTickInterval(2));

    public static void registerEntities()
    {

    }
    private static RegistryKey<EntityType<?>> keyOf(final String id)
    {
        return RegistryKey.of(RegistryKeys.ENTITY_TYPE,CodeLyokoMain.codeLyokoPrefix(id));
    }
    private static <T extends Entity> EntityType<T> registerEntities(final String name, final EntityType.Builder<T> type)
    {
        return registerEntities(keyOf(name), type);
    }
    private static <T extends Entity> EntityType<T> registerEntities(final RegistryKey<EntityType<?>> key, final EntityType.Builder<T> type)
    {
        return Registry.register(Registries.ENTITY_TYPE, key, type.build(key));
    }


}
