package com.Ultra_Nerd.CodeLyokoLegacy.Init.common;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Eletricity.LaptopChargerBlockEntityInventory;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Eletricity.RackChargerBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Eletricity.UniversalEnergyStorageTileEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.*;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities.*;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities.FluidSystem.CirculatorPipeBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities.FluidSystem.ComputerCirculatorBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities.FluidSystem.ComputerFluidCoolerBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities.FluidSystem.ComputerFluidIntakeBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperComputerNetwork.CableBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperComputerNetwork.DemarcationBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.test.ComputerInterfaceTestTE;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.test.ItemProjectorTestBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.test.PlayerDataStorage;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.test.VehicleBE;
import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public record ModBlockEntities() {
    public static final BlockEntityType<CableBlockEntity> CABLE_TILE_ENTITY_BLOCK_ENTITY_TYPE;
    public static final BlockEntityType<CirculatorPipeBlockEntity> CIRCULATOR_PIPE_BLOCK_ENTITY_TYPE;
    public static final BlockEntityType<ComputerCirculatorBlockEntity> COMPUTER_CIRCULATOR_BLOCK_ENTITY_TYPE;
    public static final BlockEntityType<ComputerControlPanelTileEntity> COMPUTER_CONTROL_PANEL;
    public static final BlockEntityType<ComputerCoreTileEntity> COMPUTER_CORE_TILE_ENTITY_BLOCK_ENTITY_TYPE;
    public static final BlockEntityType<ComputerFluidIntakeBlockEntity> COMPUTER_FLUID_INTAKE_BLOCK_ENTITY;
    public static final BlockEntityType<ComputerInterfaceTestTE> COMPUTER_INTERFACE_TEST_TE_BLOCK_ENTITY_TYPE;
    public static final BlockEntityType<ComputerReactorBlockEntityInventory> COMPUTER_REACTOR_TILE_ENTITY;
    public static final BlockEntityType<ComputerFluidCoolerBlockEntity> COOLER_BLOCK_ENTITY_TYPE;
    public static final BlockEntityType<DemarcationBlockEntity> DEMARCATION_BLOCK_ENTITY_TYPE;
    public static final BlockEntityType<HologramProjectorTileEntity> HOLOGRAM_PROJECTOR_TILE_ENTITY_BLOCK_ENTITY_TYPE;
    public static final BlockEntityType<ItemProjectorTestBlockEntity> ITEM_PROJECTOR_TEST_BLOCK_ENTITY;
    public static final BlockEntityType<KeyBoardInterface> KEYBOARD_BLOCK_ENTITY;
    public static final BlockEntityType<LaptopChargerBlockEntityInventory> LAPTOP_CHARGER_BLOCK_ENTITY_BLOCK_ENTITY;
    public static final BlockEntityType<LyokoCoreBE> LYOKO_CORE;
    public static final BlockEntityType<LithographyBlockEntityInventory> LITHOGRAPHY_BLOCK_ENTITY_TYPE;
    public static final BlockEntityType<LithographyBlockEntityInventoryT2> LITHOGRAPHY_BLOCK_ENTITY_TYPE_T2;
    public static final BlockEntityType<PlayerDataStorage> PLAYER_DATA_STORAGE_BLOCK_ENTITY_TYPE;
    public static final BlockEntityType<QuantumChipletTileEntity> QUANTUM_CHIPLET_TILE_ENTITY_BLOCK_ENTITY_TYPE;
    public static final BlockEntityType<RackChargerBlockEntity> RACK_CHARGER_BLOCK_ENTITY;
    public static final BlockEntityType<RouterTE> ROUTER_BLOCK_ENTITY_TYPE;
    public static final BlockEntityType<ScannerTileEntity> SCANNER_TILE_ENTITY;
    //tests
    public static final BlockEntityType<HologramProjectorTileEntity> TEST_PROJECTOR_TILE_ENTITY_BLOCK_ENTITY_TYPE;
    public static final BlockEntityType<TowerInterfaceTileEntity> TOWER_INTERFACE_TILE_ENTITY;
    public static final BlockEntityType<UniversalEnergyStorageTileEntity> UNIVERSAL_ENERGY_STORAGE;
    public static final BlockEntityType<VehicleBE> VEHICLE_BE_BLOCK_ENTITY_TYPE;

    static {
        LYOKO_CORE = registerModBlockEntity("lyoko_core", FabricBlockEntityTypeBuilder.create(LyokoCoreBE::new,
                ModBlocks.LYOKO_CORE));
        LITHOGRAPHY_BLOCK_ENTITY_TYPE = registerModBlockEntity("lithography_block_entity",FabricBlockEntityTypeBuilder.create(LithographyBlockEntityInventory::new,ModBlocks.LITHOGRAPHY_MACHINE));
        LITHOGRAPHY_BLOCK_ENTITY_TYPE_T2 = registerModBlockEntity("lithography_block_entity_t2",FabricBlockEntityTypeBuilder.create(LithographyBlockEntityInventoryT2::new,ModBlocks.LITHOGRAPHY_MACHINET2));
        UNIVERSAL_ENERGY_STORAGE = registerModBlockEntity("universal_energy_block_entity", FabricBlockEntityTypeBuilder.create(
                UniversalEnergyStorageTileEntity::new, ModBlocks.STORAGE));
        TOWER_INTERFACE_TILE_ENTITY = registerModBlockEntity("tower_interface_block_entity", FabricBlockEntityTypeBuilder.create(
                TowerInterfaceTileEntity::new, ModBlocks.TOWER_INTERFACE));
        SCANNER_TILE_ENTITY = registerModBlockEntity("scanner_block_entity", FabricBlockEntityTypeBuilder.create(
                ScannerTileEntity::new, ModBlocks.SCANNER_BASE));
        COMPUTER_CONTROL_PANEL = registerModBlockEntity("computer_control_panel_block_entity", FabricBlockEntityTypeBuilder.create(
                ComputerControlPanelTileEntity::new, ModBlocks.COMPUTER_TOWER_CONTROL_PANEL));
        COMPUTER_REACTOR_TILE_ENTITY = registerModBlockEntity("computer_integrated_reactor_block_entity", FabricBlockEntityTypeBuilder.create(
                ComputerReactorBlockEntityInventory::new, ModBlocks.URANIUM_REACTOR));
        LAPTOP_CHARGER_BLOCK_ENTITY_BLOCK_ENTITY = registerModBlockEntity("laptop_charger_block_entity", FabricBlockEntityTypeBuilder.create(LaptopChargerBlockEntityInventory::new, ModBlocks.LAPTOP_CHARGER));
        ROUTER_BLOCK_ENTITY_TYPE = registerModBlockEntity("router_block_entity", FabricBlockEntityTypeBuilder.create(RouterTE::new, ModBlocks.ROUTER));
        CABLE_TILE_ENTITY_BLOCK_ENTITY_TYPE = registerModBlockEntity("cable_block_entity", FabricBlockEntityTypeBuilder.create(CableBlockEntity::new, ModBlocks.CABLE_BLOCK));
        COMPUTER_CORE_TILE_ENTITY_BLOCK_ENTITY_TYPE = registerModBlockEntity("computer_core_block_entity", FabricBlockEntityTypeBuilder.create(ComputerCoreTileEntity::new, ModBlocks.COMPUTER_CORE));
        KEYBOARD_BLOCK_ENTITY = registerModBlockEntity("keyboard_block_entity", FabricBlockEntityTypeBuilder.create(KeyBoardInterface::new, ModBlocks.COMPUTER_KEYBOARD));
        COMPUTER_INTERFACE_TEST_TE_BLOCK_ENTITY_TYPE = registerModBlockEntity("test_ui_block_entity", FabricBlockEntityTypeBuilder.create(ComputerInterfaceTestTE::new, ModBlocks.TESTUI));
        HOLOGRAM_PROJECTOR_TILE_ENTITY_BLOCK_ENTITY_TYPE = registerModBlockEntity("hologram_projector_block_entity", FabricBlockEntityTypeBuilder.create(HologramProjectorTileEntity::new, ModBlocks.HOLOPROJECTOR));
        PLAYER_DATA_STORAGE_BLOCK_ENTITY_TYPE = registerModBlockEntity("player_data_test_block_entity", FabricBlockEntityTypeBuilder.create(PlayerDataStorage::new, ModBlocks.TEST_PROFILE));
        VEHICLE_BE_BLOCK_ENTITY_TYPE = registerModBlockEntity("vehicle_matter_test_block_entity", FabricBlockEntityTypeBuilder.create(VehicleBE::new, ModBlocks.TEST_VEHICLE_INTERFACE));
        COMPUTER_CIRCULATOR_BLOCK_ENTITY_TYPE = registerModBlockEntity("computer_circulator_block_entity",FabricBlockEntityTypeBuilder.create(ComputerCirculatorBlockEntity::new,
                ModBlocks.COMPUTER_LIQUID_CIRCULATOR));
        CIRCULATOR_PIPE_BLOCK_ENTITY_TYPE = registerModBlockEntity("computer_circulator_pipe_block_entity",FabricBlockEntityTypeBuilder.create(CirculatorPipeBlockEntity::new, ModBlocks.COMPUTER_LIQUID_PIPE));
        COMPUTER_FLUID_INTAKE_BLOCK_ENTITY = registerModBlockEntity("computer_fluid_intake_block_entity",FabricBlockEntityTypeBuilder.create(ComputerFluidIntakeBlockEntity::new,
                ModBlocks.COMPUTER_LIQUID_INTAKE_PUMP));
        COOLER_BLOCK_ENTITY_TYPE = registerModBlockEntity("computer_fluid_cooler_block_entity",FabricBlockEntityTypeBuilder.create(ComputerFluidCoolerBlockEntity::new, ModBlocks.COMPUTER_FLUID_COOLER));
        ITEM_PROJECTOR_TEST_BLOCK_ENTITY = registerModBlockEntity("test_item_projector_block_entity",FabricBlockEntityTypeBuilder.create(ItemProjectorTestBlockEntity::new, ModBlocks.TEST_ITEM_PROJECTOR));
        RACK_CHARGER_BLOCK_ENTITY = registerModBlockEntity("rack_charger_block_entity",FabricBlockEntityTypeBuilder.create(RackChargerBlockEntity::new,
                ModBlocks.RACK_CHARGER_BLOCK));
        QUANTUM_CHIPLET_TILE_ENTITY_BLOCK_ENTITY_TYPE = registerModBlockEntity("quantum_chiplet_block_entity",FabricBlockEntityTypeBuilder.create(QuantumChipletTileEntity::new,
                ModBlocks.CHIPLET_FRANZ_BLOCK));
        TEST_PROJECTOR_TILE_ENTITY_BLOCK_ENTITY_TYPE = registerModBlockEntity("test_hologram_projector",FabricBlockEntityTypeBuilder.create(HologramProjectorTileEntity::new, ModBlocks.TEST_SPHERE));
        DEMARCATION_BLOCK_ENTITY_TYPE = registerModBlockEntity("demarcation_block_entity",FabricBlockEntityTypeBuilder.create(DemarcationBlockEntity::new,
                ModBlocks.DEMARCATION_POINT));
    }

    private static <T extends BlockEntity> BlockEntityType<T> registerModBlockEntity(final String name, final FabricBlockEntityTypeBuilder<T> builder) {
        //TODO: when fabric writes the documentation on how to do datafixers, make this work
        //Type<?> type = Util.getChoiceType(TypeReferences.BLOCK_ENTITY, name);
        //return Registry.register(Registries.BLOCK_ENTITY_TYPE, CodeLyokoMain.codeLyokoPrefix(name), builder.build(type));
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, CodeLyokoMain.codeLyokoPrefix(name), builder.build());
    }
    public static void registerBlockEntities() {}

}
