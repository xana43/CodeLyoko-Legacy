package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.*;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.test.DataTransferInterfaceTileEntity;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.test.TestTE;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModTileEntities {
    public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Base.MOD_ID);

    public static final RegistryObject<BlockEntityType<InfusingChamberTileEntity>> INFUSING_CHAMBER_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("infusing_chamber_tile_entity",
                    () -> BlockEntityType.Builder.of(InfusingChamberTileEntity::new,
                            ModBlocks.FLUORIDE_INFUSER.get()).build(null));

    public static final RegistryObject<BlockEntityType<ElectricInfusingChamberTileEntity>> ELECTRIC_INFUSING_CHAMBER_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("electric_infusing_tile_entity",
                    () -> BlockEntityType.Builder.of(ElectricInfusingChamberTileEntity::new,
                            ModBlocks.ELECTRIC_FLUORIDE_INFUSER.get()).build(null));
    public static final RegistryObject<BlockEntityType<TowerInterfaceTileEntity>> TOWER_INTERFACE_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("tower_interface_tile_entity", () -> BlockEntityType.Builder.of(TowerInterfaceTileEntity::new,
                    ModBlocks.TOWER_INTERFACE.get()).build(null));
    public static final RegistryObject<BlockEntityType<HologramProjectorTileEntity>> HOLOGRAM_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("hologram_tile_entity", () -> BlockEntityType.Builder.create(HologramProjectorTileEntity::new,
                    ModBlocks.HOLOPROJECTOR.get()).build(null));
    public static final RegistryObject<BlockEntityType<QuantumChipletTileEntity>> QUANTUM_CHIPLET_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("quantum_chiplet_tile_entity", () -> BlockEntityType.Builder.create(QuantumChipletTileEntity::new,
                    ModBlocks.CHIPLET_FRANZ_BLOCK.get()).build(null));
    public static final RegistryObject<BlockEntityType<ScannerTileEntity>> SCANNER_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("scanner_tile_entity", () -> BlockEntityType.Builder.create(ScannerTileEntity::new,
                    ModBlocks.SCANNER_BASE.get()).build(null));
    public static final RegistryObject<BlockEntityType<CentralControlUnitTileEntity>> CENTRAL_CONTROL_UNIT_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("central_control_unit_tile_entity", () -> BlockEntityType.Builder.of(CentralControlUnitTileEntity::new
                    , ModBlocks.CENTRAL_CONTROL_UNIT.get()).build(null));
    public static final RegistryObject<BlockEntityType<ElectroplatingTileEntity>> ELECTROPLATING_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("electroplating_tile_entity", () -> BlockEntityType.Builder.of(ElectroplatingTileEntity::new
                    , ModBlocks.ELECTROPLATING_MACHINE.get()).build(null));
    public static final RegistryObject<BlockEntityType<ComputerControlPanelTileEntity>> COMPUTER_CONTROL_PANEL_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("computer_control_panel_tile_entity", () -> BlockEntityType.Builder.create(ComputerControlPanelTileEntity::new
                    , ModBlocks.COMPUTER_TOWER_CONTROL_PANEL.get()).build(null));
    public static final RegistryObject<BlockEntityType<CableTileEntity>> CABLE_TILE_ENTITY = TILE_ENTITY_TYPES.register(
            "cable_tile_entity", () -> BlockEntityType.Builder.create(CableTileEntity::new,
                    ModBlocks.CABLE_BLOCK.get()).build(null));
    public static final RegistryObject<BlockEntityType<RouterTE>> ROUTER_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("router_tile_entity", () -> BlockEntityType.Builder.create(RouterTE::new,
                    ModBlocks.ROUTER.get()).build(null));
    public static final RegistryObject<BlockEntityType<ComputerInterfaceTE>> COMPUTER_INTERFACE_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("computer_interface_tile_entity", () -> BlockEntityType.Builder.create(ComputerInterfaceTE::new,
                    ModBlocks.COMPUTER_KEYBOARD.get()).build(null));
    public static final RegistryObject<BlockEntityType<TestTE>> TEST_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("test_tile_entity", () -> BlockEntityType.Builder.create(TestTE::new,
                    ModBlocks.BLOCK_PATTERN.get()).build(null));
    public static final RegistryObject<BlockEntityType<DataTransferInterfaceTileEntity>> DATA_TRANSFER_INTERFACE_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("data_transfer_interface_tile_entity", () -> BlockEntityType.Builder.create(DataTransferInterfaceTileEntity::new,
                    ModBlocks.DATA_TRANSFER_INTERFACE.get()).build(null));
}
