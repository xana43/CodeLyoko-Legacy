package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.*;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, Base.MOD_ID);

    public static final RegistryObject<TileEntityType<InfusingChamberTileEntity>> INFUSING_CHAMBER_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("infusing_chamber_tile_entity",
                    () -> TileEntityType.Builder.create(InfusingChamberTileEntity::new,
                    ModBlocks.FLOURIDE_INFUSER.get()).build(null));

    public static final RegistryObject<TileEntityType<ElectricInfusingChamberTileEntity>> ELECTRIC_INFUSING_CHAMBER_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("electric_infusing_tile_entity",
                    ()-> TileEntityType.Builder.create(ElectricInfusingChamberTileEntity::new,
                            ModBlocks.ELECTRICFLOURIDE_INFUSER.get()).build(null));
    public static final RegistryObject<TileEntityType<TowerInterfaceTileEntity>> TOWER_INTERFACE_TILE_ENTITY =
    TILE_ENTITY_TYPES.register("tower_interface_tile_entity",() -> TileEntityType.Builder.create(TowerInterfaceTileEntity::new,
            ModBlocks.TOWER_INTERFACE.get()).build(null));
    public static final RegistryObject<TileEntityType<HologramProjectorTileEntity>> HOLOGRAM_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("hologram_tile_entity", () -> TileEntityType.Builder.create(HologramProjectorTileEntity::new,
                    ModBlocks.HOLOPROJECTOR.get()).build(null));
    public static final RegistryObject<TileEntityType<QuantumChipletTileEntity>> QUANTUM_CHIPLET_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("quantum_chiplet_tile_entity", () -> TileEntityType.Builder.create(QuantumChipletTileEntity::new,
                    ModBlocks.CHIPLET_FRANZ_BLOCK.get()).build(null));
}
