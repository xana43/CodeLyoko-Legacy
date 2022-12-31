package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.screens.TestScreens.PlayerProfileDebug;
import com.Ultra_Nerd.CodeLyokoLegacy.tileentity.*;
import com.Ultra_Nerd.CodeLyokoLegacy.tileentity.test.ComputerInterfaceTestTE;
import com.Ultra_Nerd.CodeLyokoLegacy.tileentity.test.PlayerDataStorage;
import com.Ultra_Nerd.CodeLyokoLegacy.tileentity.test.VehicleBE;
import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;

public record ModBlockEntities() {


    /*
        public static final RegistryObject<BlockEntityType<InfusingChamberTileEntity>> INFUSING_CHAMBER_TILE_ENTITY =
                TILE_ENTITY_TYPES.register("infusing_chamber_tile_entity",
                        () -> BlockEntityType.Builder.of(InfusingChamberTileEntity::new,
                                ModBlocks.FLUORIDE_INFUSER.get()).build(null));
    /*
        public static final RegistryObject<BlockEntityType<ElectricInfusingChamberTileEntity>> ELECTRIC_INFUSING_CHAMBER_TILE_ENTITY =
                TILE_ENTITY_TYPES.register("electric_infusing_tile_entity",
                        () -> BlockEntityType.Builder.of(ElectricInfusingChamberTileEntity::new,
                                ModBlocks.ELECTRIC_FLUORIDE_INFUSER.get()).build(null));

    */public static final BlockEntityType<UniversalEnergyStorageTileEntity> UNIVERSAL_ENERGY_STORAGE = FabricBlockEntityTypeBuilder.create(
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
    public static final BlockEntityType<CableTileEntity> CABLE_TILE_ENTITY_BLOCK_ENTITY_TYPE =
            FabricBlockEntityTypeBuilder.create(CableTileEntity::new, ModBlocks.CABLE_BLOCK).build();
    public static final BlockEntityType<ComputerCoreTileEntity> COMPUTER_CORE_TILE_ENTITY_BLOCK_ENTITY_TYPE =
            FabricBlockEntityTypeBuilder.create(ComputerCoreTileEntity::new,ModBlocks.COMPUTER_CORE).build();
    public static final BlockEntityType<KeyBoardInterface> KEYBOARD_BLOCK_ENTITY =
            FabricBlockEntityTypeBuilder.create(KeyBoardInterface::new,ModBlocks.COMPUTER_KEYBOARD).build();
    public static final BlockEntityType<ComputerInterfaceTestTE> COMPUTER_INTERFACE_TEST_TE_BLOCK_ENTITY_TYPE =
            FabricBlockEntityTypeBuilder.create(ComputerInterfaceTestTE::new,ModBlocks.TESTUI).build();
    public static final BlockEntityType<HologramProjectorTileEntity> HOLOGRAM_PROJECTOR_TILE_ENTITY_BLOCK_ENTITY_TYPE =
            FabricBlockEntityTypeBuilder.create(HologramProjectorTileEntity::new,ModBlocks.TEST_SPHERE).build();
    //tests
    public static final BlockEntityType<PlayerDataStorage> PLAYER_DATA_STORAGE_BLOCK_ENTITY_TYPE =
            FabricBlockEntityTypeBuilder.create(PlayerDataStorage::new,ModBlocks.TEST_PROFILE).build();
    public static final BlockEntityType<VehicleBE> VEHICLE_BE_BLOCK_ENTITY_TYPE =
            FabricBlockEntityTypeBuilder.create(VehicleBE::new,ModBlocks.TEST_VECHICLE_INTERFACE).build();
    public static final ImmutableMap<String, BlockEntityType<?>> BLOCKENTITY_MAP = ImmutableMap.<String, BlockEntityType<?>>builder()

            .put("lyoko_core", LYOKO_CORE).put("tower_interface_tile_entity", TOWER_INTERFACE_TILE_ENTITY)
            .put("scanner_tile_entity", SCANNER_TILE_ENTITY)
            .put("universal_energy_tile_entity", UNIVERSAL_ENERGY_STORAGE)
            .put("computer_control_panel_tile_entity", COMPUTER_CONTROL_PANEL)
            .put("computer_integrated_reactor", COMPUTER_REACTOR_TILE_ENTITY)
            .put("laptop_charger_blockentity", LAPTOP_CHARGER_BLOCK_ENTITY_BLOCK_ENTITY)
            .put("router_blockentity",ROUTER_BLOCK_ENTITY_TYPE)
            .put("cable_blockentity",CABLE_TILE_ENTITY_BLOCK_ENTITY_TYPE)
            .put("computer_core_blockentity",COMPUTER_CORE_TILE_ENTITY_BLOCK_ENTITY_TYPE)
            .put("keyboard_blockentity",KEYBOARD_BLOCK_ENTITY)
            .put("test_ui",COMPUTER_INTERFACE_TEST_TE_BLOCK_ENTITY_TYPE)
            .put("hologram_projector",HOLOGRAM_PROJECTOR_TILE_ENTITY_BLOCK_ENTITY_TYPE)
            .put("player_data_test",PLAYER_DATA_STORAGE_BLOCK_ENTITY_TYPE)
            .put("vehicle_matter_test",VEHICLE_BE_BLOCK_ENTITY_TYPE).build();


    //
    /*
    public static final RegistryObject<BlockEntityType<HologramProjectorTileEntity>> HOLOGRAM_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("hologram_tile_entity", () -> BlockEntityType.Builder.of(HologramProjectorTileEntity::new,
                    ModBlocks.HOLOPROJECTOR.get()).build(null));

    //public static final RegistryObject<BlockEntityType<QuantumChipletTileEntity>> QUANTUM_CHIPLET_TILE_ENTITY =
      //      TILE_ENTITY_TYPES.register("quantum_chiplet_tile_entity", () -> BlockEntityType.Builder.of(QuantumChipletTileEntity::new,
        //            ModBlocks.CHIPLET_FRANZ_BLOCK.get()).build(null));


                    /*
    public static final RegistryObject<BlockEntityType<CentralControlUnitTileEntity>> CENTRAL_CONTROL_UNIT_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("central_control_unit_tile_entity", () -> BlockEntityType.Builder.of(CentralControlUnitTileEntity::new
                    , ModBlocks.CENTRAL_CONTROL_UNIT.get()).build(null));
    public static final RegistryObject<BlockEntityType<ElectroplatingTileEntity>> ELECTROPLATING_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("electroplating_tile_entity", () -> BlockEntityType.Builder.of(ElectroplatingTileEntity::new
                    , ModBlocks.ELECTROPLATING_MACHINE.get()).build(null));

    public static final RegistryObject<BlockEntityType<ComputerControlPanelTileEntity>> COMPUTER_CONTROL_PANEL_TILE_ENTITY =
            TILE_ENTITY_TYPES.register(, () -> BlockEntityType.Builder.of(ComputerControlPanelTileEntity::new
                    , ModBlocks.COMPUTER_TOWER_CONTROL_PANEL.get()).build(null));

    public static final RegistryObject<BlockEntityType<CableTileEntity>> CABLE_TILE_ENTITY = TILE_ENTITY_TYPES.register(
            "cable_tile_entity", () -> BlockEntityType.Builder.of(CableTileEntity::new,
                    ModBlocks.CABLE_BLOCK.get()).build(null));
    public static final RegistryObject<BlockEntityType<RouterTE>> ROUTER_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("router_tile_entity", () -> BlockEntityType.Builder.of(RouterTE::new,
                    ModBlocks.ROUTER.get()).build(null));
    public static final RegistryObject<BlockEntityType<ComputerInterfaceTestTE>> COMPUTER_INTERFACE_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("computer_interface_tile_entity", () -> BlockEntityType.Builder.of(ComputerInterfaceTestTE::new,
                    ModBlocks.COMPUTER_KEYBOARD.get()).build(null));
    public static final RegistryObject<BlockEntityType<TestTE>> TEST_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("test_tile_entity", () -> BlockEntityType.Builder.of(TestTE::new,
                    ModBlocks.BLOCK_PATTERN.get()).build(null));


    public static final RegistryObject<BlockEntityType<DataTransferInterfaceTileEntity>> DATA_TRANSFER_INTERFACE_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("data_transfer_interface_tile_entity", () -> BlockEntityType.Builder.of(DataTransferInterfaceTileEntity::new,
                    ModBlocks.DATA_TRANSFER_INTERFACE.get()).build(null));
    public static final RegistryObject<BlockEntityType<ComputerReactorTileEntityInventory>> REACTOR_BLOCK_ENTITY =
            TILE_ENTITY_TYPES.register("computer_reactor_tile_entity",() -> BlockEntityType.Builder.of(ComputerReactorTileEntityInventory::new,
                    ModBlocks.URANUM_REACTOR.get()).build(null));
*/

}
