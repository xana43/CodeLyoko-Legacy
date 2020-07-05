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
        if(DimensionType.byName(Base.DimensionType) == null)
        {
            DimensionManager.registerDimension(Base.DimensionType, ModDimensions.FOREST_DIMENSION.get(),null,true);
        }
        Base.Log.info("All Dimensions loaded");
    }
}
