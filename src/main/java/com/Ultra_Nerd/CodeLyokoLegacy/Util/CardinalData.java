package com.Ultra_Nerd.CodeLyokoLegacy.Util;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.player.Capabilities.InventorySaveComponent;
import com.Ultra_Nerd.CodeLyokoLegacy.player.Capabilities.PlayerClassComponent;
import com.Ultra_Nerd.CodeLyokoLegacy.player.Capabilities.PlayerScannerComponent;
import com.Ultra_Nerd.CodeLyokoLegacy.player.Capabilities.XanaDataComponent;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.level.LevelComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.level.LevelComponentInitializer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.WorldProperties;
import org.jetbrains.annotations.NotNull;

public record CardinalData() implements EntityComponentInitializer, LevelComponentInitializer {


    @Override
    public void registerLevelComponentFactories(final @NotNull LevelComponentFactoryRegistry registry) {
        registry.register(XanaCalculator.XANA_DATA, worldProperties -> new XanaDataComponent());
        registry.register(LyokoInventorySave.LYOKO_INVENTORY_SAVE, worldProperties -> new InventorySaveComponent());
    }

    @Override
    public void registerEntityComponentFactories(final @NotNull EntityComponentFactoryRegistry registry) {
        registry.registerForPlayers(LyokoClass.LYOKOCLASS, it -> new PlayerClassComponent());
        registry.registerForPlayers(ReturnToScanner.RETURN_TO_SCANNER, PlayerScannerComponent::new);
    }

    public record LyokoClass() {
        public static final ComponentKey<PlayerClassComponent> LYOKOCLASS = ComponentRegistry.getOrCreate(CodeLyokoMain.CodeLyokoPrefix("lyoko_class"), PlayerClassComponent.class);

        public static int getLyokoClass(final PlayerEntity player) {
            return LYOKOCLASS.get(player).getClassID();
        }

        public static void setLyokoclass(final PlayerEntity player, final int ID) {
            LYOKOCLASS.get(player).setClassID(ID);
        }


    }

    public record XanaCalculator() {
        public static final ComponentKey<XanaDataComponent> XANA_DATA = ComponentRegistry.getOrCreate(CodeLyokoMain.CodeLyokoPrefix("xana_data"), XanaDataComponent.class);

        public static void setDangerLevel(final int dangerLevel, final WorldProperties worldProperties) {
            XANA_DATA.get(worldProperties).setDangerLevel(dangerLevel);
        }

        public static int getDangerLevel(final WorldProperties properties) {
            return XANA_DATA.get(properties).getDangerLevel();
        }
    }

    public record LyokoInventorySave() {
        public static final ComponentKey<InventorySaveComponent> LYOKO_INVENTORY_SAVE = ComponentRegistry.getOrCreate(CodeLyokoMain.CodeLyokoPrefix("temp_inventory"), InventorySaveComponent.class);

        public static void savePlayerInventory(final WorldProperties worldProperties, final PlayerEntity playerEntity) {

            LYOKO_INVENTORY_SAVE.get(worldProperties).savePlayerInventory(playerEntity);
        }

        public static void loadPlayerInventory(final WorldProperties worldProperties, final PlayerEntity playerEntity) {
            LYOKO_INVENTORY_SAVE.get(worldProperties).loadPlayerInventory(playerEntity);
        }
    }

    public record ReturnToScanner() {
        public static final ComponentKey<PlayerScannerComponent> RETURN_TO_SCANNER = ComponentRegistry.getOrCreate(CodeLyokoMain.CodeLyokoPrefix("scanner_position"), PlayerScannerComponent.class);

        public static void saveScannerLocation(final PlayerEntity player) {
            RETURN_TO_SCANNER.get(player).savePosition();
        }

        public static void materializeAtScanner(final PlayerEntity player) {
            RETURN_TO_SCANNER.get(player).setPosition();
        }
    }
}
