package com.Ultra_Nerd.CodeLyokoRemake15.Util;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend.RendBlok;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend.RendFan;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend.RendLaser;
import com.Ultra_Nerd.CodeLyokoRemake15.Util.client.tileentity.renderer.QuantumChipletRenderer;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.ContainerInfusing;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.QuantumChipletContainer;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.TowerInterfaceContainer;
import com.Ultra_Nerd.CodeLyokoRemake15.init.*;
import com.Ultra_Nerd.CodeLyokoRemake15.particles.ColoredParticle;
import com.Ultra_Nerd.CodeLyokoRemake15.screens.InfusingChamberScreen;
import com.Ultra_Nerd.CodeLyokoRemake15.screens.QuantumChipletScreen;
import com.Ultra_Nerd.CodeLyokoRemake15.screens.TowerGUI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Base.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)

public class ClientModEventSubscriber {


@SubscribeEvent
public static void registerParticles(ParticleFactoryRegisterEvent event)
{
    Minecraft.getInstance().particles.registerFactory(ModParticles.TOWER_PARTICLE.get(), ColoredParticle.Factory::new);
}

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
        RenderTypeLookup.setRenderLayer(ModBlocks.CHIPLET_FRANZ_BLOCK.get(),RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.UV_FOCUS.get(),RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.HOLOPROJECTOR_PROJECTION.get(),RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PROJECTOR_FOCUS.get(),RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(ModBlocks.HOLOPROJECTOR.get(),RenderType.getTranslucent());
        //registers the screens and entities
        ScreenManager.<ContainerInfusing, InfusingChamberScreen>registerFactory(ModContainerTypes.CONTAINER_INFUSING.get(), InfusingChamberScreen::new);
        ScreenManager.<TowerInterfaceContainer, TowerGUI>registerFactory(ModContainerTypes.TOWER_INTERFACE_CONTAINER.get(), TowerGUI::new);
        ScreenManager.<QuantumChipletContainer,QuantumChipletScreen>registerFactory(ModContainerTypes.QUANTUM_CHIPLET_CONTAINER.get(), QuantumChipletScreen::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.BLOK.get(), RendBlok::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.LASER.get(), RendLaser::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.FAN.get(), RendFan::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntities.QUANTUM_CHIPLET_TILE_ENTITY.get(), QuantumChipletRenderer::new);
    }


}
