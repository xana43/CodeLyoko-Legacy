package com.Ultra_Nerd.CodeLyokoLegacy.Init.Common;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.DecorationEntities.XanaSymbolEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.HostileEntities.*;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.ProjectileEntities.EntityFan;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.ProjectileEntities.EntityLaser;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.SamuraiClass.ServerTriplicateCloneEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.VehicleEntities.EntitySkid;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.VehicleEntities.HoverboardEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.VehicleEntities.OverbikeEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.VehicleEntities.OverboardEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.Heightmap;

public record ModEntities() {
    //entity type
    public static final EntityType<KankrelatEntity> KANKRELAT = registerEntities("kankrelat",FabricEntityTypeBuilder.createMob()
            .entityFactory(KankrelatEntity::new)
            .spawnGroup(SpawnGroup.MONSTER)
            .defaultAttributes(EntityBlok::createMonsterAttributes)
            .dimensions(EntityDimensions.fixed(1,1))
            .spawnRestriction(SpawnRestriction.Location.ON_GROUND,Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,EntityBlok::canMobSpawn));
    public static final EntityType<EntityBlok> BLOK = registerEntities("blok",FabricEntityTypeBuilder.createMob()
            .entityFactory(EntityBlok::new)
            .spawnGroup(SpawnGroup.MONSTER)
            .defaultAttributes(EntityBlok::createMonsterAttributes)
            .dimensions(EntityDimensions.fixed(2, 2))
            .spawnRestriction(SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                    EntityBlok::canSpawn)
            .fireImmune());
    public static final EntityType<EntityLaser> LASER_ENTITY_TYPE = registerEntities("laser",FabricEntityTypeBuilder.create(
            SpawnGroup.MISC, EntityLaser::new));
    public static final EntityType<MegaTankEntity> MEGATANK = registerEntities("megatank",FabricEntityTypeBuilder.create(SpawnGroup.MONSTER,
                    MegaTankEntity::new).dimensions(EntityDimensions.fixed(1, 1)).fireImmune());
    public static final EntityType<HornetEntity> HORNET_ENTITY_ENTITY_TYPE = registerEntities("hornet",FabricEntityTypeBuilder.createMob()
            .entityFactory(HornetEntity::new)
            .spawnGroup(SpawnGroup.MONSTER)
            .defaultAttributes(HornetEntity::registerAttributes)
            .dimensions(EntityDimensions.fixed(1, 1))
            .spawnRestriction(SpawnRestriction.Location.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                    (type, world, spawnReason, pos, random) -> HornetEntity.isValidSpawn(world.getBiomeAccess(), pos,
                            world)));
    public static final EntityType<OverboardEntity> OVERBOARD = registerEntities("overboard",FabricEntityTypeBuilder.create(
                    SpawnGroup.MISC, OverboardEntity::new)

            .dimensions(EntityDimensions.fixed(2, 1)));

    public static final EntityType<OverbikeEntity> OVERBIKE = registerEntities("overbike",FabricEntityTypeBuilder.create(
            SpawnGroup.MISC,OverbikeEntity::new
    ));
    public static final EntityType<LyokoGuardianEntity> LYOKO_GUARDIAN_ENTITY_TYPE = registerEntities("lyoko_guardian",FabricEntityTypeBuilder.createMob().entityFactory(LyokoGuardianEntity::new)
            .spawnGroup(SpawnGroup.MONSTER)
            .defaultAttributes(LyokoGuardianEntity::createGuardianAttributes)
            .dimensions(EntityDimensions.fixed(4,4))
            .spawnRestriction(SpawnRestriction.Location.NO_RESTRICTIONS,Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,(type, world, spawnReason, pos, random) -> true)
            .fireImmune()
    );
    public static final EntityType<HoverboardEntity> HOVERBOARD =
            registerEntities("hoverboard",FabricEntityTypeBuilder.create(SpawnGroup.MISC, HoverboardEntity::new).dimensions(EntityDimensions.fixed(1
                    , 1)));
    public static final EntityType<EntityFan> FAN_ENTITY_TYPE =
            registerEntities("fan",FabricEntityTypeBuilder.create(SpawnGroup.MISC, EntityFan::new));

    public static final EntityType<EntitySkid> SKID_ENTITY_TYPE =
            registerEntities("skidbladnir",FabricEntityTypeBuilder.create(SpawnGroup.MISC,EntitySkid::new));
    //decoration entities
    public static final EntityType<XanaSymbolEntity> XANA_SYMBOL_ENTITY_TYPE =
            registerEntities("xana_symbol",FabricEntityTypeBuilder.create(SpawnGroup.MISC,XanaSymbolEntity::new));
    public static final EntityType<ServerTriplicateCloneEntity> TRIPLICATE_ENTITY_TYPE = registerEntities("triplicate_entity",FabricEntityTypeBuilder.createLiving().spawnGroup(SpawnGroup.MISC).entityFactory(ServerTriplicateCloneEntity::new)
            .disableSaving()
            .defaultAttributes(ServerTriplicateCloneEntity::createPlayerAttributes)
            .dimensions(EntityDimensions.fixed(0.6f,1.8f))
            .trackRangeBlocks(32).trackedUpdateRate(2));

    public static void registerEntities()
    {

    }
    private static <T extends Entity> EntityType<T> registerEntities(final String name, final FabricEntityTypeBuilder<T> type)
    {
        return Registry.register(Registries.ENTITY_TYPE, CodeLyokoMain.codeLyokoPrefix(name), type.build());
    }


}
