package com.Ultra_Nerd.CodeLyokoRemake15.Util;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModDimensions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModDimensionTypes;

@Mod.EventBusSubscriber(modid = Base.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventSubscriber {

    @SubscribeEvent
    public static void InitDims(final RegisterDimensionsEvent event)
    {
        if(DimensionType.byName(ModDimensionTypes.DimensionTypeForest) == null)
        {
            DimensionManager.registerDimension(ModDimensionTypes.DimensionTypeForest, ModDimensions.FOREST_DIMENSION.get(),null,true);

        }
        if(DimensionType.byName(ModDimensionTypes.DimensionTypeCarthage) == null)
        {
            DimensionManager.registerDimension(ModDimensionTypes.DimensionTypeCarthage, ModDimensions.SECTOR_5.get(),null,true);
        }
        if(DimensionType.byName(ModDimensionTypes.DimensionTypeMountain) == null)
        {
            DimensionManager.registerDimension(ModDimensionTypes.DimensionTypeMountain, ModDimensions.MOUNTAIN_DIMENSION.get(),null,true);
        }
        if(DimensionType.byName(ModDimensionTypes.DimensionTypeOcean) == null)
        {
            DimensionManager.registerDimension(ModDimensionTypes.DimensionTypeOcean,ModDimensions.OCEAN_DIMENSION.get(),null,true);
        }
        if(DimensionType.byName(ModDimensionTypes.DimensionTypeIce) == null)
        {
            DimensionManager.registerDimension(ModDimensionTypes.DimensionTypeIce,ModDimensions.ICE_DIMENSION.get(),null,true);
        }
        if(DimensionType.byName(ModDimensionTypes.DimensionTypeDesert) == null)
        {
            DimensionManager.registerDimension(ModDimensionTypes.DimensionTypeDesert,ModDimensions.DESERT_DIMENSION.get(),null,true);
        }
        Base.Log.info("All Dimensions loaded");
    }
}
