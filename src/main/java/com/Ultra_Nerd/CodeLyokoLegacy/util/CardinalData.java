package com.Ultra_Nerd.CodeLyokoLegacy.util;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.Capabilities.SkidBladnirData;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle.EntitySkid;
import com.Ultra_Nerd.CodeLyokoLegacy.player.Capabilities.*;
import com.Ultra_Nerd.CodeLyokoLegacy.player.PlayerProfile;
import com.Ultra_Nerd.CodeLyokoLegacy.util.enums.Capabilities.XanaAttackTypes;
import com.Ultra_Nerd.CodeLyokoLegacy.world.Capabilities.InventorySaveComponent;
import com.Ultra_Nerd.CodeLyokoLegacy.world.Capabilities.PlayerProfileStorage;
import com.Ultra_Nerd.CodeLyokoLegacy.world.Capabilities.PlayerScannerComponent;
import com.Ultra_Nerd.CodeLyokoLegacy.world.Capabilities.XanaDataComponent;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.entity.RespawnCopyStrategy;
import dev.onyxstudios.cca.api.v3.level.LevelComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.level.LevelComponentInitializer;
import dev.onyxstudios.cca.api.v3.level.LevelComponents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldProperties;
import org.jetbrains.annotations.NotNull;

public record CardinalData() implements EntityComponentInitializer, LevelComponentInitializer {


    @Override
    public void registerLevelComponentFactories(final @NotNull LevelComponentFactoryRegistry registry) {
        registry.register(XanaCalculator.XANA_DATA, worldProperties -> new XanaDataComponent());
        registry.register(LyokoInventorySave.LYOKO_INVENTORY_SAVE, worldProperties -> new InventorySaveComponent());
        registry.register(ReturnToScanner.RETURN_TO_SCANNER,worldProperties -> new PlayerScannerComponent());
        registry.register(PlayerSavedProfile.PLAYER_PROFILE_STORAGE_COMPONENT_KEY, worldProperties -> new PlayerProfileStorage());
    }

    @Override
    public void registerEntityComponentFactories(final @NotNull EntityComponentFactoryRegistry registry) {
        registry.registerForPlayers(LyokoClass.LYOKOCLASS, it -> new PlayerClassComponent(),RespawnCopyStrategy.CHARACTER);
        registry.registerForPlayers(MindHelmStress.MINDHELMSTRESS,player -> new MindHelmStressComponent(),RespawnCopyStrategy.NEVER_COPY);
        registry.registerForPlayers(HumanDNAAttribute.HUMAN_DNA_COMPONENT_KEY, HumanDNA::new, RespawnCopyStrategy.CHARACTER);
        registry.registerForPlayers(CellularDamage.DEGENERATION_COMPONENT_KEY,CellularDegeneration::new, RespawnCopyStrategy.CHARACTER);
        registry.registerForPlayers(DigitalEnergyComponent.DIGITAL_ENERGY_COMPONENT_KEY,(player -> new DigitalEnergy()));
        registry.registerFor(EntitySkid.class,SkidBladnirNavData.SKID_BLADNIR_DATA_COMPONENT_KEY,SkidBladnirData::new);
    }
    public record DigitalEnergyComponent()
    {
        private static final ComponentKey<DigitalEnergy> DIGITAL_ENERGY_COMPONENT_KEY =
                ComponentRegistry.getOrCreate(CodeLyokoMain.codeLyokoPrefix("digital_energy"), DigitalEnergy.class);
        public static ComponentKey<DigitalEnergy> getDigitalEnergyComponentKey()
        {
            return DIGITAL_ENERGY_COMPONENT_KEY;
        }
        public static int getCurrentEnergy(final PlayerEntity player)
        {
            return DIGITAL_ENERGY_COMPONENT_KEY.get(player).getCurrentEnergy();
        }
        public static boolean tryUseEnergy(final PlayerEntity player, final int energyUsage)
        {
            final boolean isEnergyUsed = DIGITAL_ENERGY_COMPONENT_KEY.get(player).useEnergy(energyUsage);
            DIGITAL_ENERGY_COMPONENT_KEY.sync(player);
            return isEnergyUsed;
        }
        public static void regenerateEnergy(final PlayerEntity player)
        {
            DIGITAL_ENERGY_COMPONENT_KEY.get(player).regenerateEnergy();
            DIGITAL_ENERGY_COMPONENT_KEY.sync(player);
        }
        public static boolean isUsingEnergy(final PlayerEntity player)
        {
            return DIGITAL_ENERGY_COMPONENT_KEY.get(player).isUsingEnergy();
        }
        public static void setIsUsingEnergy(final PlayerEntity player,final boolean isUsingEnergy)
        {
            DIGITAL_ENERGY_COMPONENT_KEY.get(player).setUsingEnergy(isUsingEnergy);
            DIGITAL_ENERGY_COMPONENT_KEY.sync(player);
        }
    }
    public record SkidBladnirNavData()
    {
        private static final ComponentKey<SkidBladnirData> SKID_BLADNIR_DATA_COMPONENT_KEY =
                ComponentRegistry.getOrCreate(CodeLyokoMain.codeLyokoPrefix("skid_nav_data"), SkidBladnirData.class);
        public static ComponentKey<SkidBladnirData> getComponentKey()
        {
            return SKID_BLADNIR_DATA_COMPONENT_KEY;
        }
        public static void setLyokoPosition(final Entity entity,final BlockPos lyokoPos)
        {
            SKID_BLADNIR_DATA_COMPONENT_KEY.get(entity).setLyokoPosition(lyokoPos);
            SKID_BLADNIR_DATA_COMPONENT_KEY.sync(entity);
        }
        public static void setHubDestination(final Entity entity,final BlockPos hubDestination)
        {
            SKID_BLADNIR_DATA_COMPONENT_KEY.get(entity).setHubDestinationPosition(hubDestination);
            SKID_BLADNIR_DATA_COMPONENT_KEY.sync(entity);
        }

        public static BlockPos getHubDestination(final Entity entity)
        {
            return SKID_BLADNIR_DATA_COMPONENT_KEY.get(entity).getHubDestinationPosition();
        }
        public static BlockPos getLyokoPosition(final Entity entity)
        {
            return SKID_BLADNIR_DATA_COMPONENT_KEY.get(entity).getLyokoPosition();
        }

    }
    public record CellularDamage()
    {
        private static final ComponentKey<CellularDegeneration> DEGENERATION_COMPONENT_KEY =
                ComponentRegistry.getOrCreate(CodeLyokoMain.codeLyokoPrefix("cellular_degeneration"),
                        CellularDegeneration.class);
        public static ComponentKey<CellularDegeneration> getCellComponentKey()
        {
            return DEGENERATION_COMPONENT_KEY;
        }
        public static void degenerateHealth(final PlayerEntity player)
        {
            DEGENERATION_COMPONENT_KEY.get(player).deteriorateHealth();
            DEGENERATION_COMPONENT_KEY.sync(player);
        }
        public static void regenerateHealth(final PlayerEntity player)
        {
            DEGENERATION_COMPONENT_KEY.get(player).regenerateHealth();
            DEGENERATION_COMPONENT_KEY.sync(player);
        }
        public static boolean isHealthy(final PlayerEntity player)
        {
            return DEGENERATION_COMPONENT_KEY.get(player).isHealthy();
        }
    }
    public record PlayerSavedProfile()
    {
        private static final ComponentKey<PlayerProfileStorage> PLAYER_PROFILE_STORAGE_COMPONENT_KEY =
        ComponentRegistry.getOrCreate(CodeLyokoMain.codeLyokoPrefix("player_profile"), PlayerProfileStorage.class);
        public static ComponentKey<?> getPlayerProfileComponentKey()
        {
            return PLAYER_PROFILE_STORAGE_COMPONENT_KEY;
        }
        public static void saveProfile(final WorldProperties worldProperties,final ServerPlayerEntity player)
        {
            PLAYER_PROFILE_STORAGE_COMPONENT_KEY.get(worldProperties).saveProfile(player);
        }
        public static void updateProfile(final WorldProperties worldProperties,final PlayerProfile profile)
        {
            final PlayerProfile oldProfile = getPlayerProfile(worldProperties, profile.getPlayer());
            if(oldProfile.equals(profile))
            {
                return;
            }
            PLAYER_PROFILE_STORAGE_COMPONENT_KEY.get(worldProperties).updatePlayerProfile(profile);

        }
        public static void removePlayerProfile(final WorldProperties worldProperties,final ServerPlayerEntity player)
        {
            PLAYER_PROFILE_STORAGE_COMPONENT_KEY.get(worldProperties).removePlayerProfile(player);
        }

        public static PlayerProfile getPlayerProfile(final WorldProperties worldProperties, final PlayerEntity player)
        {
            //LevelComponents.sync(PLAYER_PROFILE_STORAGE_COMPONENT_KEY,Objects.requireNonNull(player.getServer()));
                return PLAYER_PROFILE_STORAGE_COMPONENT_KEY.get(worldProperties).getPlayerProfile(player);
        }
    }
    public record HumanDNAAttribute()
    {
        private static final ComponentKey<HumanDNA> HUMAN_DNA_COMPONENT_KEY =
                ComponentRegistry.getOrCreate(CodeLyokoMain.codeLyokoPrefix("human_dna"), HumanDNA.class);
        public static ComponentKey<HumanDNA> getHumanDnaComponentKey()
        {
            return HUMAN_DNA_COMPONENT_KEY;
        }
        public static void setHasDna(final PlayerEntity player, final boolean hasDna)
        {
            HUMAN_DNA_COMPONENT_KEY.get(player).setHasDNA(hasDna);
            //HUMAN_DNA_COMPONENT_KEY.sync(player);
        }
        public static boolean getHasDna(final PlayerEntity player)
        {
            return HUMAN_DNA_COMPONENT_KEY.get(player).getHasDna();
        }
        public static String getDna(final PlayerEntity player)
        {
            return HUMAN_DNA_COMPONENT_KEY.get(player).getDNA();
        }
    }
    public record MindHelmStress()
    {
        private static final ComponentKey<MindHelmStressComponent> MINDHELMSTRESS = ComponentRegistry.getOrCreate(
                CodeLyokoMain.codeLyokoPrefix("mind_stress"),MindHelmStressComponent.class);
        public static ComponentKey<MindHelmStressComponent> getMindhelmStressKey()
        {
            return MINDHELMSTRESS;
        }
        public static void increaseStress(final int stressor, final PlayerEntity player)
        {
            MINDHELMSTRESS.get(player).addToStressLevel(stressor);
            MINDHELMSTRESS.sync(player);
        }
        public static void decreaseStress(final PlayerEntity player)
        {
            MINDHELMSTRESS.get(player).decreaseStressLevel();
            MINDHELMSTRESS.sync(player);
        }
        public static int getStressLevel(final PlayerEntity player)
        {
            return MINDHELMSTRESS.get(player).getStressLevel();
        }
    }
    public record LyokoClass() {
        private static final ComponentKey<PlayerClassComponent> LYOKOCLASS = ComponentRegistry.getOrCreate(
                CodeLyokoMain.codeLyokoPrefix("lyoko_class"), PlayerClassComponent.class);
        public static ComponentKey<PlayerClassComponent> getLyokoClassComponent()
        {
            return LYOKOCLASS;
        }
        public static int getLyokoClass(final PlayerEntity player) {
            return LYOKOCLASS.get(player).getClassID();
        }

        public static void setLyokoClass(final PlayerEntity player, final int ID) {
            LYOKOCLASS.get(player).setClassID(ID);

            LYOKOCLASS.sync(player);
        }


    }

    public record XanaCalculator() {
        private static final ComponentKey<XanaDataComponent> XANA_DATA = ComponentRegistry.getOrCreate(
                CodeLyokoMain.codeLyokoPrefix("xana_data"), XanaDataComponent.class);

        public static void setDangerLevel(final MinecraftServer server,final int dangerLevel, final WorldProperties worldProperties) {
            XANA_DATA.get(worldProperties).setDangerLevel(dangerLevel);
            LevelComponents.sync(XANA_DATA,server);
        }
        public static void setCheckRadius(final MinecraftServer server,final WorldProperties properties, final int radius)
        {
            XANA_DATA.get(properties).setRadius(radius);
            LevelComponents.sync(XANA_DATA,server);
        }
        public static XanaAttackTypes getAttackTypes(final WorldProperties worldProperties)
        {
            return XANA_DATA.get(worldProperties).getAttackType();
        }
        public static int getRadius(final WorldProperties properties)
        {
            return XANA_DATA.get(properties).getRadius();
        }
        public static int getDangerLevel(final WorldProperties properties) {
            return XANA_DATA.get(properties).getDangerLevel();
        }
        public static void increaseDangerLevel(final MinecraftServer server,final WorldProperties properties, final int dangerLevelIncrease)
        {
            XANA_DATA.get(properties).increaseDangerLevel(dangerLevelIncrease);
            LevelComponents.sync(XANA_DATA,server);
        }
        public static void decreaseDangerLevel(final MinecraftServer server,final WorldProperties properties,final int dangerLevelDecrease)
        {
            XANA_DATA.get(properties).decreaseDangerLevel(dangerLevelDecrease);
            LevelComponents.sync(XANA_DATA,server);
        }
        public static void clearValidAttackPositions(final MinecraftServer server,final WorldProperties properties)
        {
            XANA_DATA.get(properties).clearAllAttackPositions();
            LevelComponents.sync(XANA_DATA,server);
        }
        public static BlockPos getActiveFactoryPosition(final WorldProperties properties)
        {
           return XANA_DATA.get(properties).getActiveFactoryPosition();
        }
        public static void setActiveFactoryPosition(final MinecraftServer server,final WorldProperties properties,final BlockPos activeFactoryPosition)
        {
            XANA_DATA.get(properties).setActiveFactoryPosition(activeFactoryPosition);
            LevelComponents.sync(XANA_DATA,server);
        }
        public static void removeValidAttackPosition(final MinecraftServer server,final WorldProperties properties,final BlockPos validAttackPosition)
        {
            XANA_DATA.get(properties).removeValidAttackPosition(validAttackPosition);
            LevelComponents.sync(XANA_DATA,server);
        }
        public static void addValidAttackPosition(final MinecraftServer server,final WorldProperties properties,final BlockPos validAttackPosition)
        {
            XANA_DATA.get(properties).addValidAttackPositions(validAttackPosition);
            LevelComponents.sync(XANA_DATA,server);
        }
        public static void setAttackType(final MinecraftServer server,final WorldProperties properties,final XanaAttackTypes attackType)
        {
            XANA_DATA.get(properties).setAttackType(attackType);
            LevelComponents.sync(XANA_DATA,server);
        }
    }

    public record LyokoInventorySave() {
        private static final ComponentKey<InventorySaveComponent> LYOKO_INVENTORY_SAVE = ComponentRegistry.getOrCreate(
                CodeLyokoMain.codeLyokoPrefix("temp_inventory"), InventorySaveComponent.class);

        public static ComponentKey<InventorySaveComponent> getLyokoInventorySave()
        {
            return LYOKO_INVENTORY_SAVE;
        }
        public static void savePlayerInventory(final WorldProperties worldProperties, final PlayerEntity playerEntity) {

            LYOKO_INVENTORY_SAVE.get(worldProperties).savePlayerInventory(playerEntity);

        }

        public static void loadPlayerInventory(final WorldProperties worldProperties, final PlayerEntity playerEntity) {
            LYOKO_INVENTORY_SAVE.get(worldProperties).loadPlayerInventory(playerEntity);
        }
    }

    public record ReturnToScanner() {
        private static final ComponentKey<PlayerScannerComponent> RETURN_TO_SCANNER = ComponentRegistry.getOrCreate(
                CodeLyokoMain.codeLyokoPrefix("scanner_position"), PlayerScannerComponent.class);

        public static ComponentKey<PlayerScannerComponent> getReturnToScanner()
        {
            return RETURN_TO_SCANNER;
        }
        public static void saveScannerLocation(final WorldProperties worldProperties,final PlayerEntity player) {
            RETURN_TO_SCANNER.get(worldProperties).savePosition(player);
        }

        public static void materializeAtScanner(final WorldProperties worldProperties,final PlayerEntity player) {
            RETURN_TO_SCANNER.get(worldProperties).setPosition(player);
        }
    }
}
