package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.ElectricInfusingChamberTileEntity;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.InfusingChamberTileEntity;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.TowerInterfaceTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Base.MOD_ID);

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

}
