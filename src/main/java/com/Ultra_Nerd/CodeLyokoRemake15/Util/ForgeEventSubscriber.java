package com.Ultra_Nerd.CodeLyokoRemake15.Util;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModDimensions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = Base.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventSubscriber {

    @SubscribeEvent
    public static void InitDims(final RegisterDimensionsEvent event)
    {
        if(DimensionType.byName(Base.DimensionTypeForest) == null)
        {
            DimensionManager.registerDimension(Base.DimensionTypeForest, ModDimensions.FOREST_DIMENSION.get(),null,true);

        }
        if(DimensionType.byName(Base.DimenstionTypeCarthage) == null)
        {
            DimensionManager.registerDimension(Base.DimenstionTypeCarthage, ModDimensions.SECTOR_5.get(),null,true);
        }
        Base.Log.info("All Dimensions loaded");
    }
}
