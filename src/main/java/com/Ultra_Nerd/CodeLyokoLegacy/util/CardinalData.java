package com.Ultra_Nerd.CodeLyokoLegacy.util;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.player.Capabilities.*;
import com.Ultra_Nerd.CodeLyokoLegacy.player.PlayerProfile;
import com.Ultra_Nerd.CodeLyokoLegacy.world.Capabilities.PlayerProfileStorage;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.level.LevelComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.level.LevelComponentInitializer;
import dev.onyxstudios.cca.api.v3.level.LevelComponents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.WorldProperties;
import org.jetbrains.annotations.NotNull;

public record CardinalData() implements EntityComponentInitializer, LevelComponentInitializer {


    @Override
    public void registerLevelComponentFactories(final @NotNull LevelComponentFactoryRegistry registry) {
        registry.register(XanaCalculator.XANA_DATA, worldProperties -> new XanaDataComponent());
        registry.register(LyokoInventorySave.LYOKO_INVENTORY_SAVE, worldProperties -> new InventorySaveComponent());
        registry.register(PlayerSavedProfile.PLAYER_PROFILE_STORAGE_COMPONENT_KEY,worldProperties -> new PlayerProfileStorage());
    }

    @Override
    public void registerEntityComponentFactories(final @NotNull EntityComponentFactoryRegistry registry) {
        registry.registerForPlayers(LyokoClass.LYOKOCLASS, it -> new PlayerClassComponent());
        registry.registerForPlayers(MindHelmStress.MINDHELMSTRESS,player -> new MindHelmStressComponent());
        registry.registerForPlayers(ReturnToScanner.RETURN_TO_SCANNER, PlayerScannerComponent::new);
        registry.registerForPlayers(HumanDNAAttribute.HUMAN_DNA_COMPONENT_KEY, HumanDNA::new);
        registry.registerForPlayers(CellularDamage.DEGENERATION_COMPONENT_KEY,CellularDegeneration::new);
    }
    public record CellularDamage()
    {
        private static final ComponentKey<CellularDegeneration> DEGENERATION_COMPONENT_KEY =
                ComponentRegistry.getOrCreate(CodeLyokoMain.codeLyokoPrefix("cellular_degeneration"),
                        CellularDegeneration.class);
        public static void degenerateHealth(final PlayerEntity player)
        {
            DEGENERATION_COMPONENT_KEY.get(player).deteriorateHealth();
        }
        public static void regenerateHealth(final PlayerEntity player)
        {
            DEGENERATION_COMPONENT_KEY.get(player).regenerateHealth();
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
        public static void saveProfile(final WorldProperties worldProperties,final PlayerEntity player)
        {
            PLAYER_PROFILE_STORAGE_COMPONENT_KEY.get(worldProperties).saveProfile(player);
        }
        public static PlayerProfile getPlayerProfile(final WorldProperties worldProperties,final PlayerEntity player)
        {
                return PLAYER_PROFILE_STORAGE_COMPONENT_KEY.get(worldProperties).getPlayerProfile(player);
        }
    }
    public record HumanDNAAttribute()
    {
        private static final ComponentKey<HumanDNA> HUMAN_DNA_COMPONENT_KEY =
                ComponentRegistry.getOrCreate(CodeLyokoMain.codeLyokoPrefix("human_dna"), HumanDNA.class);
        public static void setHasDna(final PlayerEntity player, final boolean hasDna)
        {
            HUMAN_DNA_COMPONENT_KEY.get(player).setHasDNA(hasDna);
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
        public static void increaseStress(final int stressor, final PlayerEntity player)
        {
            MINDHELMSTRESS.get(player).addToStressLevel(stressor);
        }
        public static void decreaseStress(final PlayerEntity player)
        {
            MINDHELMSTRESS.get(player).decreaseStressLevel();
        }
        public static int getStressLevel(final PlayerEntity player)
        {
            return MINDHELMSTRESS.get(player).getStressLevel();
        }
    }
    public record LyokoClass() {
        private static final ComponentKey<PlayerClassComponent> LYOKOCLASS = ComponentRegistry.getOrCreate(
                CodeLyokoMain.codeLyokoPrefix("lyoko_class"), PlayerClassComponent.class);

        public static int getLyokoClass(final PlayerEntity player) {
            return LYOKOCLASS.get(player).getClassID();
        }

        public static void setLyokoclass(final PlayerEntity player, final int ID) {
            LYOKOCLASS.get(player).setClassID(ID);
        }


    }

    public record XanaCalculator() {
        private static final ComponentKey<XanaDataComponent> XANA_DATA = ComponentRegistry.getOrCreate(
                CodeLyokoMain.codeLyokoPrefix("xana_data"), XanaDataComponent.class);

        public static void setDangerLevel(final int dangerLevel, final WorldProperties worldProperties) {
            XANA_DATA.get(worldProperties).setDangerLevel(dangerLevel);
        }

        public static int getDangerLevel(final WorldProperties properties) {
            return XANA_DATA.get(properties).getDangerLevel();
        }
    }

    public record LyokoInventorySave() {
        private static final ComponentKey<InventorySaveComponent> LYOKO_INVENTORY_SAVE = ComponentRegistry.getOrCreate(
                CodeLyokoMain.codeLyokoPrefix("temp_inventory"), InventorySaveComponent.class);

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

        public static void saveScannerLocation(final PlayerEntity player) {
            RETURN_TO_SCANNER.get(player).savePosition();
        }

        public static void materializeAtScanner(final PlayerEntity player) {
            RETURN_TO_SCANNER.get(player).setPosition();
        }
    }
}
