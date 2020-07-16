package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.Carthadge.Sector5ModDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.DesertSector.DesertModDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.DigitalOcean.OceanModDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.ForestSector.ForestModDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.IceSector.IceModDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.MountainSector.MountainModDimension;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModDimensions {

    public static final DeferredRegister<ModDimension> MOD_DIMENSION_DEFERRED_REGISTER = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, Base.MOD_ID);


    public static final RegistryObject<ModDimension> FOREST_DIMENSION = MOD_DIMENSION_DEFERRED_REGISTER.register("forest_sector", ForestModDimension::new);
    public static final RegistryObject<ModDimension> SECTOR_5 = MOD_DIMENSION_DEFERRED_REGISTER.register("sector_5", Sector5ModDimension::new);
    public static final RegistryObject<ModDimension> MOUNTAIN_DIMENSION = MOD_DIMENSION_DEFERRED_REGISTER.register("mountain_sector", MountainModDimension::new);
    public static final RegistryObject<ModDimension> OCEAN_DIMENSION = MOD_DIMENSION_DEFERRED_REGISTER.register("digital_ocean", OceanModDimension::new);
    public static final RegistryObject<ModDimension> ICE_DIMENSION = MOD_DIMENSION_DEFERRED_REGISTER.register("ice_sector", IceModDimension::new);
    public static final RegistryObject<ModDimension> DESERT_DIMENSION = MOD_DIMENSION_DEFERRED_REGISTER.register("desert_sector", DesertModDimension::new);
}
