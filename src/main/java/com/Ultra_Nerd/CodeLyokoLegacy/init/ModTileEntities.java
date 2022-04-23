package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.tileentity.LyokoCoreBE;
import com.Ultra_Nerd.CodeLyokoLegacy.tileentity.TowerInterfaceTileEntity;
import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;

import java.util.HashMap;
import java.util.Map;

public final class ModTileEntities {





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

*/
    public static final BlockEntityType<LyokoCoreBE> LYOKO_CORE = FabricBlockEntityTypeBuilder.create(LyokoCoreBE::new,ModBlocks.LYOKO_CORE).build();
    public static final ImmutableMap<String, BlockEntityType<?>> BLOCKENTITY_MAP = ImmutableMap.<String,BlockEntityType<?>>builder()

            .put("lyoko_core",LYOKO_CORE)

            .build();
  //  public static final RegistryObject<BlockEntityType<TowerInterfaceTileEntity>> TOWER_INTERFACE_TILE_ENTITY =
    //        TILE_ENTITY_TYPES.register("tower_interface_tile_entity", () -> BlockEntityType.Builder.of(TowerInterfaceTileEntity::new,
      //              ModBlocks.TOWER_INTERFACE.get()).build(null));
    /*
    public static final RegistryObject<BlockEntityType<HologramProjectorTileEntity>> HOLOGRAM_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("hologram_tile_entity", () -> BlockEntityType.Builder.of(HologramProjectorTileEntity::new,
                    ModBlocks.HOLOPROJECTOR.get()).build(null));

    //public static final RegistryObject<BlockEntityType<QuantumChipletTileEntity>> QUANTUM_CHIPLET_TILE_ENTITY =
      //      TILE_ENTITY_TYPES.register("quantum_chiplet_tile_entity", () -> BlockEntityType.Builder.of(QuantumChipletTileEntity::new,
        //            ModBlocks.CHIPLET_FRANZ_BLOCK.get()).build(null));

    public static final RegistryObject<BlockEntityType<ScannerTileEntity>> SCANNER_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("scanner_tile_entity", () -> BlockEntityType.Builder.of(ScannerTileEntity::new,
                    ModBlocks.SCANNER_BASE.get()).build(null));
                    /*
    public static final RegistryObject<BlockEntityType<CentralControlUnitTileEntity>> CENTRAL_CONTROL_UNIT_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("central_control_unit_tile_entity", () -> BlockEntityType.Builder.of(CentralControlUnitTileEntity::new
                    , ModBlocks.CENTRAL_CONTROL_UNIT.get()).build(null));
    public static final RegistryObject<BlockEntityType<ElectroplatingTileEntity>> ELECTROPLATING_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("electroplating_tile_entity", () -> BlockEntityType.Builder.of(ElectroplatingTileEntity::new
                    , ModBlocks.ELECTROPLATING_MACHINE.get()).build(null));

    public static final RegistryObject<BlockEntityType<ComputerControlPanelTileEntity>> COMPUTER_CONTROL_PANEL_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("computer_control_panel_tile_entity", () -> BlockEntityType.Builder.of(ComputerControlPanelTileEntity::new
                    , ModBlocks.COMPUTER_TOWER_CONTROL_PANEL.get()).build(null));

    public static final RegistryObject<BlockEntityType<CableTileEntity>> CABLE_TILE_ENTITY = TILE_ENTITY_TYPES.register(
            "cable_tile_entity", () -> BlockEntityType.Builder.of(CableTileEntity::new,
                    ModBlocks.CABLE_BLOCK.get()).build(null));
    public static final RegistryObject<BlockEntityType<RouterTE>> ROUTER_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("router_tile_entity", () -> BlockEntityType.Builder.of(RouterTE::new,
                    ModBlocks.ROUTER.get()).build(null));
    public static final RegistryObject<BlockEntityType<ComputerInterfaceTE>> COMPUTER_INTERFACE_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("computer_interface_tile_entity", () -> BlockEntityType.Builder.of(ComputerInterfaceTE::new,
                    ModBlocks.COMPUTER_KEYBOARD.get()).build(null));
    public static final RegistryObject<BlockEntityType<TestTE>> TEST_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("test_tile_entity", () -> BlockEntityType.Builder.of(TestTE::new,
                    ModBlocks.BLOCK_PATTERN.get()).build(null));


    public static final RegistryObject<BlockEntityType<DataTransferInterfaceTileEntity>> DATA_TRANSFER_INTERFACE_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("data_transfer_interface_tile_entity", () -> BlockEntityType.Builder.of(DataTransferInterfaceTileEntity::new,
                    ModBlocks.DATA_TRANSFER_INTERFACE.get()).build(null));
    public static final RegistryObject<BlockEntityType<ComputerReactorTileEntity>> REACTOR_BLOCK_ENTITY =
            TILE_ENTITY_TYPES.register("computer_reactor_tile_entity",() -> BlockEntityType.Builder.of(ComputerReactorTileEntity::new,
                    ModBlocks.URANUM_REACTOR.get()).build(null));
*/

}
