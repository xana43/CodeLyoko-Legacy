package com.Ultra_Nerd.CodeLyokoRemake15.Util;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend.HornetRenderer;
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
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Base.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)

public class ClientModEventSubscriber {


    @SubscribeEvent
    public static void registerParticles(ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particles.registerFactory(ModParticles.TOWER_PARTICLE.get(), ColoredParticle.Factory::new);
    }

    @SubscribeEvent
    public static void onFMLClientSetupEvent(final FMLClientSetupEvent event) {
        //makes certain blocks behave properly

        ModItems.RAW_POLYCARBONATE.get().addPropertyOverride(new ResourceLocation(Base.MOD_ID, "quantity"), (stack,world,entityin) ->{

                        switch(stack.getCount())
                        {
                            case 1: return 0.1f;
                            case 2: return 0.2f;
                            case 3: return 0.3f;
                            case 4: return 0.4f;
                            case 5: return 0.5f;
                            case 6: return 0.6f;
                            case 7: return 0.7f;
                            case 8: return 0.8f;
                            case 9: return 0.9f;
                            case 10: return 0.10f;
                            case 11: return 0.11f;
                            case 12: return 0.12f;
                            case 13: return 0.13f;
                            case 14: return 0.14f;
                            case 15: return 0.15f;
                            case 16: return 0.16f;
                            case 17: return 0.17f;
                            case 18: return 0.18f;
                            case 19: return 0.19f;
                            case 20: return 0.20f;
                            case 21: return 0.21f;
                            case 22: return 0.22f;
                            case 23: return 0.23f;
                            case 24: return 0.24f;
                            case 25: return 0.25f;
                            case 26: return 0.26f;
                            case 27: return 0.27f;
                            case 28: return 0.28f;
                            case 29: return 0.29f;
                            case 30: return 0.30f;
                            case 31: return 0.31f;
                            case 32: return 0.32f;
                            case 33: return 0.33f;
                            case 34: return 0.34f;
                            case 35: return 0.35f;
                            case 36: return 0.36f;
                            case 37: return 0.37f;
                            case 38: return 0.38f;
                            case 39: return 0.39f;
                            case 40: return 0.40f;
                            case 41: return 0.41f;
                            case 42: return 0.42f;
                            case 43: return 0.43f;
                            case 44: return 0.44f;
                            case 45: return 0.45f;
                            case 46: return 0.46f;
                            case 47: return 0.47f;
                            case 48: return 0.48f;
                            case 49: return 0.49f;
                            case 50: return 0.50f;
                            case 51: return 0.51f;
                            case 52: return 0.52f;
                            case 53: return 0.53f;
                            case 54: return 0.54f;
                            case 55: return 0.55f;
                            case 56: return 0.56f;
                            case 57: return 0.57f;
                            case 58: return 0.58f;
                            case 59: return 0.59f;
                            case 60: return 0.60f;
                            case 61: return 0.61f;
                            case 62: return 0.62f;
                            case 63: return 0.63f;
                            case 64: return 0.64f;
                            default: return 0.0f;
                        }




        });
        ModItems.SILICON_WAFER.get().addPropertyOverride(new ResourceLocation(Base.MOD_ID, "quality"), (stack, world, entityin) -> {
            switch (stack.getDamage())
            {
                case 1: return 0.25f;
                case 2: return 0.5f;
                case 3: return 0.75f;
                case 4: return 1.0f;
                default: return 0.0f;
            }
        });
        RenderTypeLookup.setRenderLayer(ModBlocks.TOWER_INTERFACE.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(ModFluids.DIGITAL_SEA_BLOCK.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModFluids.DIGITAL_OCEAN.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModFluids.FLOWING_DIGITAL_OCEAN.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.TRANSPARENT.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(ModFluids.FLOWING_LIQUID_HELIUM.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModFluids.STILL_LIQUID_HELIUM.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModFluids.LIQUID_HELIUM.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.CHIPLET_FRANZ_BLOCK.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.UV_FOCUS.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.QUANTUM_STEEL_BLOCK.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(ModBlocks.PROJECTOR_FOCUS.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.HOLOPROJECTOR.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.FALSE_WATER.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PROJECTOR_FOCUS.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LYOKO_CORE.get(),RenderType.getTranslucent());
        //registers the screens and entities
        ScreenManager.<ContainerInfusing, InfusingChamberScreen>registerFactory(ModContainerTypes.CONTAINER_INFUSING.get(), InfusingChamberScreen::new);
        ScreenManager.<TowerInterfaceContainer, TowerGUI>registerFactory(ModContainerTypes.TOWER_INTERFACE_CONTAINER.get(), TowerGUI::new);
        ScreenManager.<QuantumChipletContainer, QuantumChipletScreen>registerFactory(ModContainerTypes.QUANTUM_CHIPLET_CONTAINER.get(), QuantumChipletScreen::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.BLOK.get(), RendBlok::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.LASER.get(), RendLaser::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.FAN.get(), RendFan::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.HORNET.get(), HornetRenderer::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntities.QUANTUM_CHIPLET_TILE_ENTITY.get(), QuantumChipletRenderer::new);
    }


}
