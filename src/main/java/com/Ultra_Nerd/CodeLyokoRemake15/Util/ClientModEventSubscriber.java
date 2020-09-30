package com.Ultra_Nerd.CodeLyokoRemake15.Util;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend.*;
import com.Ultra_Nerd.CodeLyokoRemake15.Util.client.tileentity.renderer.QuantumChipletRenderer;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.*;
import com.Ultra_Nerd.CodeLyokoRemake15.init.*;
import com.Ultra_Nerd.CodeLyokoRemake15.particles.ColoredParticle;
import com.Ultra_Nerd.CodeLyokoRemake15.particles.TowerParticleFactory;
import com.Ultra_Nerd.CodeLyokoRemake15.screens.*;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.Carthage.Sector5Dimension;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Base.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)

public class ClientModEventSubscriber {
    @SubscribeEvent
    public static void portalevent(BlockEvent.PortalSpawnEvent event) {
        if (event.getWorld().getDimension() instanceof Sector5Dimension) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void registerParticles(ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particles.registerFactory(ModParticles.TOWER_PARTICLE.get(), ColoredParticle.Factory::new);
        Minecraft.getInstance().particles.registerFactory(ModParticles.TOWER_PARTICLE_2.get(), TowerParticleFactory::new);
    }

    @SubscribeEvent
    public static void onFMLClientSetupEvent(final FMLClientSetupEvent event) {
        //makes certain blocks behave properly

        ModItems.JEREMY_LAPTOP.get().addPropertyOverride(new ResourceLocation(Base.MOD_ID, "state"), (stack, world, entityin) -> {
            switch (stack.getDamage()) {
                case 0:
                    return 0.1f;
                case 1:
                    return 0.2f;
                default:
                    return 0;
            }
        });

        ModItems.RAW_POLYCARBONATE.get().addPropertyOverride(new ResourceLocation(Base.MOD_ID, "quantity"), (stack, world, entityin) -> {

            if (stack.getCount() > 0 && stack.getCount() < 65) {
                return stack.getCount() / 100f;
            } else {
                return 0f;
            }
        });
        ModItems.SILICON_WAFER.get().addPropertyOverride(new ResourceLocation(Base.MOD_ID, "quality"), (stack, world, entityin) -> {
            switch (stack.getDamage()) {
                case 1:
                    return 0.25f;
                case 2:
                    return 0.5f;
                case 3:
                    return 0.75f;
                case 4:
                    return 1.0f;
                default:
                    return 0.0f;
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
        RenderTypeLookup.setRenderLayer(ModBlocks.HOLOPROJECTOR.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(ModBlocks.FALSE_WATER.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PROJECTOR_FOCUS.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LYOKO_CORE.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.FRONTIER_BLOCK.get(), RenderType.getCutoutMipped());
        //registers the screens and entities
        ScreenManager.<ContainerInfusing, InfusingChamberScreen>registerFactory(ModContainerTypes.CONTAINER_INFUSING.get(), InfusingChamberScreen::new);
        ScreenManager.<ContainerElectricInfusing, ElectricInfusingChamberScreen>registerFactory(ModContainerTypes.CONTAINER_ELECTRIC_INFUSING.get(), ElectricInfusingChamberScreen::new);
        ScreenManager.<TowerInterfaceContainer, TowerGUI>registerFactory(ModContainerTypes.TOWER_INTERFACE_CONTAINER.get(), TowerGUI::new);
        ScreenManager.<QuantumChipletContainer, QuantumChipletScreen>registerFactory(ModContainerTypes.QUANTUM_CHIPLET_CONTAINER.get(), QuantumChipletScreen::new);
        ScreenManager.<ContainerElectroplate, ElectroplatingScreen>registerFactory(ModContainerTypes.ELECTROPLATING_CONTAINER.get(), ElectroplatingScreen::new);
        ScreenManager.<ComputerControlPanelContainer, ComputerControlPanelUI>registerFactory(ModContainerTypes.COMPUTER_CONTROL_PANEL_CONTAINER.get(),
                ComputerControlPanelUI::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.BLOK.get(), RendBlok::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.LASER.get(), RendLaser::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.FAN.get(), RendFan::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.HORNET.get(), HornetRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.MEGATANK.get(), MegaTankRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.MANTA.get(), MantaRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.SKID.get(), RendSkid::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.KANKRELAT.get(), KankrelatRenderder::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.HOVERBOARD.get(), HoverboardRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.OVERBOARD.get(), OverboardRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.GUARDIAN.get(), GuardianRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.OVERBIKE.get(), OverbikeRenderer::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntities.QUANTUM_CHIPLET_TILE_ENTITY.get(), QuantumChipletRenderer::new);
    }


}
