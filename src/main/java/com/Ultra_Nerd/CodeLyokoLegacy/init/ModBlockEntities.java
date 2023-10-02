package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.*;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Eletricity.LaptopChargerBlockEntityInventory;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Eletricity.RackChargerBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Eletricity.UniversalEnergyStorageTileEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities.*;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities.FluidSystem.CirculatorPipeBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities.FluidSystem.ComputerCirculatorBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities.FluidSystem.ComputerFluidCoolerBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities.FluidSystem.ComputerFluidIntakeBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.test.ComputerInterfaceTestTE;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.test.ItemProjectorTestBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.test.PlayerDataStorage;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.test.VehicleBE;
import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;

public record ModBlockEntities() {
    public static final BlockEntityType<UniversalEnergyStorageTileEntity> UNIVERSAL_ENERGY_STORAGE = FabricBlockEntityTypeBuilder.create(
            UniversalEnergyStorageTileEntity::new, ModBlocks.STORAGE).build();
    public static final BlockEntityType<ScannerTileEntity> SCANNER_TILE_ENTITY = FabricBlockEntityTypeBuilder.create(
            ScannerTileEntity::new, ModBlocks.SCANNER_BASE).build();

    public static final BlockEntityType<LyokoCoreBE> LYOKO_CORE = FabricBlockEntityTypeBuilder.create(LyokoCoreBE::new,
            ModBlocks.LYOKO_CORE).build();
    public static final BlockEntityType<TowerInterfaceTileEntity> TOWER_INTERFACE_TILE_ENTITY = FabricBlockEntityTypeBuilder.create(
            TowerInterfaceTileEntity::new, ModBlocks.TOWER_INTERFACE).build();
    public static final BlockEntityType<ComputerControlPanelTileEntity> COMPUTER_CONTROL_PANEL = FabricBlockEntityTypeBuilder.create(
            ComputerControlPanelTileEntity::new, ModBlocks.COMPUTER_TOWER_CONTROL_PANEL).build();
    public static final BlockEntityType<ComputerReactorTileEntityInventory> COMPUTER_REACTOR_TILE_ENTITY = FabricBlockEntityTypeBuilder.create(
            ComputerReactorTileEntityInventory::new, ModBlocks.URANUM_REACTOR).build();
    public static final BlockEntityType<LaptopChargerBlockEntityInventory> LAPTOP_CHARGER_BLOCK_ENTITY_BLOCK_ENTITY =
            FabricBlockEntityTypeBuilder.create(LaptopChargerBlockEntityInventory::new, ModBlocks.LAPTOP_CHARGER).build();
    public  static final BlockEntityType<RouterTE> ROUTER_BLOCK_ENTITY_TYPE =
            FabricBlockEntityTypeBuilder.create(RouterTE::new,ModBlocks.ROUTER).build();
    public static final BlockEntityType<CableBlockEntity> CABLE_TILE_ENTITY_BLOCK_ENTITY_TYPE =
            FabricBlockEntityTypeBuilder.create(CableBlockEntity::new, ModBlocks.CABLE_BLOCK).build();
    public static final BlockEntityType<ComputerCoreTileEntity> COMPUTER_CORE_TILE_ENTITY_BLOCK_ENTITY_TYPE =
            FabricBlockEntityTypeBuilder.create(ComputerCoreTileEntity::new,ModBlocks.COMPUTER_CORE).build();
    public static final BlockEntityType<KeyBoardInterface> KEYBOARD_BLOCK_ENTITY =
            FabricBlockEntityTypeBuilder.create(KeyBoardInterface::new,ModBlocks.COMPUTER_KEYBOARD).build();
    public static final BlockEntityType<ComputerInterfaceTestTE> COMPUTER_INTERFACE_TEST_TE_BLOCK_ENTITY_TYPE =
            FabricBlockEntityTypeBuilder.create(ComputerInterfaceTestTE::new,ModBlocks.TESTUI).build();
    public static final BlockEntityType<HologramProjectorTileEntity> HOLOGRAM_PROJECTOR_TILE_ENTITY_BLOCK_ENTITY_TYPE =
            FabricBlockEntityTypeBuilder.create(HologramProjectorTileEntity::new,ModBlocks.HOLOPROJECTOR).build();
    //tests
    public static final BlockEntityType<HologramProjectorTileEntity> TEST_PROJECTOR_TILE_ENTITY_BLOCK_ENTITY_TYPE =
            FabricBlockEntityTypeBuilder.create(HologramProjectorTileEntity::new,ModBlocks.TEST_SPHERE).build();
    public static final BlockEntityType<PlayerDataStorage> PLAYER_DATA_STORAGE_BLOCK_ENTITY_TYPE =
            FabricBlockEntityTypeBuilder.create(PlayerDataStorage::new,ModBlocks.TEST_PROFILE).build();
    public static final BlockEntityType<VehicleBE> VEHICLE_BE_BLOCK_ENTITY_TYPE =
            FabricBlockEntityTypeBuilder.create(VehicleBE::new,ModBlocks.TEST_VECHICLE_INTERFACE).build();
    public static final BlockEntityType<ComputerCirculatorBlockEntity> COMPUTER_CIRCULATOR_BLOCK_ENTITY_TYPE =
            FabricBlockEntityTypeBuilder.create(ComputerCirculatorBlockEntity::new,
                    ModBlocks.COMPUTER_LIQUID_CIRCULATOR).build();
    public static final BlockEntityType<CirculatorPipeBlockEntity> CIRCULATOR_PIPE_BLOCK_ENTITY_TYPE =
            FabricBlockEntityTypeBuilder.create(CirculatorPipeBlockEntity::new,ModBlocks.COMPUTER_LIQUID_PIPE).build();

    public static final BlockEntityType<ComputerFluidIntakeBlockEntity> COMPUTER_FLUID_INTAKE_BLOCK_ENTITY =
            FabricBlockEntityTypeBuilder.create(ComputerFluidIntakeBlockEntity::new,
                    ModBlocks.COMPUTER_LIQUID_INTAKE_PUMP).build();

    public static final BlockEntityType<ComputerFluidCoolerBlockEntity> COOLER_BLOCK_ENTITY_TYPE =
            FabricBlockEntityTypeBuilder.create(ComputerFluidCoolerBlockEntity::new,ModBlocks.COMPUTER_FLUID_COOLER).build();

    public static final BlockEntityType<ItemProjectorTestBlockEntity> ITEM_PROJECTOR_TEST_BLOCK_ENTITY =
            FabricBlockEntityTypeBuilder.create(ItemProjectorTestBlockEntity::new,ModBlocks.TEST_ITEM_PROJECTOR).build();
    public static final BlockEntityType<RackChargerBlockEntity> RACK_CHARGER_BLOCK_ENTITY = FabricBlockEntityTypeBuilder.create(RackChargerBlockEntity::new,
            ModBlocks.RACK_CHARGER_BLOCK).build();
    public static final ImmutableMap<String, BlockEntityType<?>> BLOCKENTITY_MAP = ImmutableMap.<String, BlockEntityType<?>>builder()

            .put("lyoko_core", LYOKO_CORE)
            .put("tower_interface_block_entity", TOWER_INTERFACE_TILE_ENTITY)
            .put("scanner_block_entity", SCANNER_TILE_ENTITY)
            .put("universal_energy_block_entity", UNIVERSAL_ENERGY_STORAGE)
            .put("computer_control_panel_block_entity", COMPUTER_CONTROL_PANEL)
            .put("computer_integrated_reactor_block_entity", COMPUTER_REACTOR_TILE_ENTITY)
            .put("laptop_charger_block_entity", LAPTOP_CHARGER_BLOCK_ENTITY_BLOCK_ENTITY)
            .put("router_block_entity",ROUTER_BLOCK_ENTITY_TYPE)
            .put("cable_block_entity",CABLE_TILE_ENTITY_BLOCK_ENTITY_TYPE)
            .put("computer_core_block_entity",COMPUTER_CORE_TILE_ENTITY_BLOCK_ENTITY_TYPE)
            .put("keyboard_block_entity",KEYBOARD_BLOCK_ENTITY)
            .put("test_ui_block_entity",COMPUTER_INTERFACE_TEST_TE_BLOCK_ENTITY_TYPE)
            .put("hologram_projector_block_entity",HOLOGRAM_PROJECTOR_TILE_ENTITY_BLOCK_ENTITY_TYPE)
            .put("player_data_test_block_entity",PLAYER_DATA_STORAGE_BLOCK_ENTITY_TYPE)
            .put("vehicle_matter_test_block_entity",VEHICLE_BE_BLOCK_ENTITY_TYPE)
            .put("computer_circulator_block_entity",COMPUTER_CIRCULATOR_BLOCK_ENTITY_TYPE)
            .put("computer_circulator_pipe_block_entity",CIRCULATOR_PIPE_BLOCK_ENTITY_TYPE)
            .put("computer_fluid_intake_block_entity",COMPUTER_FLUID_INTAKE_BLOCK_ENTITY)
            .put("computer_fluid_cooler_block_entity",COOLER_BLOCK_ENTITY_TYPE)
            .put("test_item_projector_block_entity", ITEM_PROJECTOR_TEST_BLOCK_ENTITY)
            .put("rack_charger_block_entity",RACK_CHARGER_BLOCK_ENTITY)
            .build();

}
