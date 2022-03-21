package com.Ultra_Nerd.CodeLyokoRemake15.Util;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModDimensionTypes;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModDimensions;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.Carthage.Sector5Dimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.DesertSector.DesertDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.DigitalOcean.OceanDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.ForestSector.ForestDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.IceSector.IceDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.VolcanoSector.VolcanoDimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Base.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventSubscriber {

    @SubscribeEvent
    public static void explosions(final ExplosionEvent world) {
        if (world.getWorld().dimension instanceof ForestDimension || world.getWorld().dimension instanceof Sector5Dimension ||
                world.getWorld().dimension instanceof VolcanoDimension || world.getWorld().dimension instanceof DesertDimension ||
                world.getWorld().dimension instanceof IceDimension ||
                world.getWorld().dimension instanceof OceanDimension) {
            world.getExplosion().clearAffectedBlockPositions();
        }
    }


    @SubscribeEvent
    public static void InitDims(final RegisterDimensionsEvent event) {
        if (DimensionType.byName(ModDimensionTypes.DimensionTypeForest) == null) {
            DimensionManager.registerDimension(ModDimensionTypes.DimensionTypeForest, ModDimensions.FOREST_DIMENSION.get(), null, true);
        }
        if (DimensionType.byName(ModDimensionTypes.DimensionTypeCarthage) == null) {
            DimensionManager.registerDimension(ModDimensionTypes.DimensionTypeCarthage, ModDimensions.SECTOR_5.get(), null, true);
        }
        if (DimensionType.byName(ModDimensionTypes.DimensionTypeMountain) == null) {
            DimensionManager.registerDimension(ModDimensionTypes.DimensionTypeMountain, ModDimensions.MOUNTAIN_DIMENSION.get(), null, true);
        }
        if (DimensionType.byName(ModDimensionTypes.DimensionTypeOcean) == null) {
            DimensionManager.registerDimension(ModDimensionTypes.DimensionTypeOcean, ModDimensions.OCEAN_DIMENSION.get(), null, true);
        }
        if (DimensionType.byName(ModDimensionTypes.DimensionTypeIce) == null) {
            DimensionManager.registerDimension(ModDimensionTypes.DimensionTypeIce, ModDimensions.ICE_DIMENSION.get(), null, true);
        }
        if (DimensionType.byName(ModDimensionTypes.DimensionTypeDesert) == null) {
            DimensionManager.registerDimension(ModDimensionTypes.DimensionTypeDesert, ModDimensions.DESERT_DIMENSION.get(), null, true);
        }
        if (DimensionType.byName(ModDimensionTypes.DimensionTypeFrontier) == null) {
            DimensionManager.registerDimension(ModDimensionTypes.DimensionTypeFrontier, ModDimensions.FRONTIER_DIMENSION.get(), null, true);
        }
        if (DimensionType.byName(ModDimensionTypes.DimensionTypeVolcano) == null) {
            DimensionManager.registerDimension(ModDimensionTypes.DimensionTypeVolcano, ModDimensions.VOLCANO_DIMENSION.get(), null, true);
        }
        Base.Log.info("All Dimensions loaded");
    }
}
