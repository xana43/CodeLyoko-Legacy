package com.Ultra_Nerd.CodeLyokoRemake15.Util;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend.RendBlok;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend.RendFan;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend.RendLaser;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.ContainerInfusing;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.TowerInterfaceContainer;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModContainerTypes;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModEntities;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModFluids;
import com.Ultra_Nerd.CodeLyokoRemake15.screens.InfusingChamberScreen;
import com.Ultra_Nerd.CodeLyokoRemake15.screens.TowerGUI;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Base.MOD_ID, value = Dist.CLIENT)
public class ClientModEventSubscriber {



    @SubscribeEvent
    public static void onFMLClientSetupEvent(final FMLClientSetupEvent event) {
        //makes certain blocks behave properly
        RenderTypeLookup.setRenderLayer(ModBlocks.TOWER_INTERFACE.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(ModFluids.DIO.get(),RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModFluids.DIGITAL_OCEAN.get(),RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModFluids.FLOWING_DIGITAL_OCEAN.get(),RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.TRANSPARENT.get(),RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(ModFluids.FLOWING_LIQUIDHELIUM.get(),RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModFluids.STILL_LIQUIDHELIUM.get(),RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModFluids.LIQUIDHELIUM.get(),RenderType.getTranslucent());

        //registers the screens and entities
        ScreenManager.<ContainerInfusing, InfusingChamberScreen>registerFactory(ModContainerTypes.CONTAINER_INFUSING.get(), InfusingChamberScreen::new);
        ScreenManager.<TowerInterfaceContainer, TowerGUI>registerFactory(ModContainerTypes.TOWER_INTERFACE_CONTAINER.get(), TowerGUI::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.BLOK.get(), RendBlok::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.LASER.get(), RendLaser::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.FAN.get(), RendFan::new);





    }
}
