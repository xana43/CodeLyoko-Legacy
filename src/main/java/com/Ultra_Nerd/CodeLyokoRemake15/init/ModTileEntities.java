package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.*;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.test.TestTE;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Base.MOD_ID);

    public static final RegistryObject<TileEntityType<InfusingChamberTileEntity>> INFUSING_CHAMBER_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("infusing_chamber_tile_entity",
                    () -> TileEntityType.Builder.create(InfusingChamberTileEntity::new,
                            ModBlocks.FLUORIDE_INFUSER.get()).build(null));

    public static final RegistryObject<TileEntityType<ElectricInfusingChamberTileEntity>> ELECTRIC_INFUSING_CHAMBER_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("electric_infusing_tile_entity",
                    () -> TileEntityType.Builder.create(ElectricInfusingChamberTileEntity::new,
                            ModBlocks.ELECTRIC_FLUORIDE_INFUSER.get()).build(null));
    public static final RegistryObject<TileEntityType<TowerInterfaceTileEntity>> TOWER_INTERFACE_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("tower_interface_tile_entity", () -> TileEntityType.Builder.create(TowerInterfaceTileEntity::new,
                    ModBlocks.TOWER_INTERFACE.get()).build(null));
    public static final RegistryObject<TileEntityType<HologramProjectorTileEntity>> HOLOGRAM_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("hologram_tile_entity", () -> TileEntityType.Builder.create(HologramProjectorTileEntity::new,
                    ModBlocks.HOLOPROJECTOR.get()).build(null));
    public static final RegistryObject<TileEntityType<QuantumChipletTileEntity>> QUANTUM_CHIPLET_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("quantum_chiplet_tile_entity", () -> TileEntityType.Builder.create(QuantumChipletTileEntity::new,
                    ModBlocks.CHIPLET_FRANZ_BLOCK.get()).build(null));
    public static final RegistryObject<TileEntityType<ScannerTileEntity>> SCANNER_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("scanner_tile_entity", () -> TileEntityType.Builder.create(ScannerTileEntity::new,
                    ModBlocks.SCANNER_BASE.get()).build(null));
    public static final RegistryObject<TileEntityType<CentralControlUnitTileEntity>> CENTRAL_CONTROL_UNIT_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("central_control_unit_tile_entity", () -> TileEntityType.Builder.create(CentralControlUnitTileEntity::new
                    , ModBlocks.CENTRAL_CONTROL_UNIT.get()).build(null));
    public static final RegistryObject<TileEntityType<ElectroplatingTileEntity>> ELECTROPLATING_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("electroplating_tile_entity", () -> TileEntityType.Builder.create(ElectroplatingTileEntity::new
                    , ModBlocks.ELECTROPLATING_MACHINE.get()).build(null));
    public static final RegistryObject<TileEntityType<ComputerControlPanelTileEntity>> COMPUTER_CONTROL_PANEL_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("computer_control_panel_tile_entity", () -> TileEntityType.Builder.create(ComputerControlPanelTileEntity::new
                    , ModBlocks.COMPUTER_TOWER_CONTROL_PANEL.get()).build(null));
    public static final RegistryObject<TileEntityType<CableTileEntity>> CABLE_TILE_ENTITY = TILE_ENTITY_TYPES.register(
            "cable_tile_entity", () -> TileEntityType.Builder.create(CableTileEntity::new,
                    ModBlocks.CABLE_BLOCK.get()).build(null));
    public static final RegistryObject<TileEntityType<RouterTE>> ROUTER_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("router_tile_entity", () -> TileEntityType.Builder.create(RouterTE::new,
                    ModBlocks.ROUTER.get()).build(null));
    public static final RegistryObject<TileEntityType<ComputerInterfaceTE>> COMPUTER_INTERFACE_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("computer_interface_tile_entity", () -> TileEntityType.Builder.create(ComputerInterfaceTE::new,
                    ModBlocks.COMPUTER_KEYBOARD.get()).build(null));
    public static final RegistryObject<TileEntityType<TestTE>> TEST_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("test_tile_entity", () -> TileEntityType.Builder.create(TestTE::new,
                    ModBlocks.BLOCK_PATTERN.get()).build(null));
}
