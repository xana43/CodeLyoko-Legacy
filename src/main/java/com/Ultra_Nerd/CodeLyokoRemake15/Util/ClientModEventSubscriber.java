package com.Ultra_Nerd.CodeLyokoRemake15.Util;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend.*;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModContainerTypes;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModEntities;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModFluids;
import com.Ultra_Nerd.CodeLyokoRemake15.screens.TowerGUI;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = CodeLyokoMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)

public class ClientModEventSubscriber {

    /*
        @SubscribeEvent
        public static void registerParticles(ParticleFactoryRegisterEvent event) {
            Minecraft.getInstance().particleEngine.register(ModParticles.TOWER_PARTICLE.get(), ColoredParticle.Factory::new);
            Minecraft.getInstance().particles.registerFactory(ModParticles.TOWER_PARTICLE_2.get(), TowerParticleFactory::new);
        }
    */
    @SubscribeEvent
    public static void onFMLClientSetupEvent(final FMLClientSetupEvent event) {
    /*    //makes certain blocks behave properly
        ModItems.TEST_MULTIPLAYER_PHONE.get().overrideOtherStackedOnMe(new ResourceLocation(CodeLyokoMain.MOD_ID,"message"), (stack, world, entityin) ->
        {
            if(stack.isEnchanted())
            {
                return 1;
            }
            else
            {
                return 0;
            }
        });
        ModItems.TEST_MULTIPLAYER_PHONE.get().addPropertyOverride(new ResourceLocation(CodeLyokoMain.MOD_ID,"charge"), (stack,world,entityin) ->
        {
            switch (stack.getDamage())
            {
                case 0:
                    return 0.1f;
                case 1:
                    return 0.2f;
                default:
                    return 0;
            }
        });
        ModItems.JEREMY_LAPTOP.get().addPropertyOverride(new ResourceLocation(CodeLyokoMain.MOD_ID, "state"), (stack, world, entityin) -> {
            switch (stack.getDamage()) {
                case 0:
                    return 0.1f;
                case 1:
                    return 0.2f;
                default:
                    return 0;
            }
        });

        ModItems.RAW_POLYCARBONATE.get().addPropertyOverride(new ResourceLocation(CodeLyokoMain.MOD_ID, "quantity"), (stack, world, entityin) -> {

            if (stack.getCount() > 0 && stack.getCount() < 65) {
                return stack.getCount() / 100f;
            } else {
                return 0f;
            }
        });
        ModItems.SILICON_WAFER.get().addPropertyOverride(new ResourceLocation(CodeLyokoMain.MOD_ID, "quality"), (stack, world, entityin) -> {
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

 */

        //RenderType(ModBlocks.TOWER_INTERFACE.get(), RenderType.getCutoutMipped());
        //RenderType(ModFluids.DIGITAL_SEA_BLOCK.get(), RenderType.cutout());
        final RenderType cutoutMipped = RenderType.cutoutMipped();
        final RenderType cutout = RenderType.cutout();
        final RenderType transluscent = RenderType.translucent();
        final RenderType transluscentMovingBlock = RenderType.translucentMovingBlock();
event.enqueueWork(()-> {

    ItemBlockRenderTypes.setRenderLayer(ModFluids.DIGITAL_OCEAN.get(), transluscent);
    ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_DIGITAL_OCEAN.get(), transluscent);
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.TRANSPARENT.get(), cutoutMipped);
    ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_LIQUID_HELIUM.get(), transluscent);
    ItemBlockRenderTypes.setRenderLayer(ModFluids.STILL_LIQUID_HELIUM.get(), transluscent);
    ItemBlockRenderTypes.setRenderLayer(ModFluids.LIQUID_HELIUM.get(), transluscent);
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHIPLET_FRANZ_BLOCK.get(), transluscent);
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.UV_FOCUS.get(), transluscent);
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.QUANTUM_STEEL_BLOCK.get(), transluscent);
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.PROJECTOR_FOCUS.get(), cutoutMipped);
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.HOLOPROJECTOR.get(), cutoutMipped);
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.FALSE_WATER.get(), transluscent);
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.PROJECTOR_FOCUS.get(), transluscent);
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.LYOKO_CORE.get(), transluscent);
    ItemBlockRenderTypes.setRenderLayer(ModBlocks.FRONTIER_BLOCK.get(), cutoutMipped);


    MenuScreens.register(ModContainerTypes.TOWER_INTERFACE_CONTAINER.get(), TowerGUI::new);
    EntityRenderers.register(ModEntities.BLOK.get(), RendBlok::new);
    EntityRenderers.register(ModEntities.LASER.get(), RendLaser::new);
    //EntityRenderers.register(ModEntities.FAN.get(), RendFan::new);
    //EntityRenderers.register(ModEntities.HORNET.get(), HornetRenderer::new);
    //EntityRenderers.register(ModEntities.MEGATANK.get(), MegaTankRenderer::new);
    //EntityRenderers.register(ModEntities.MANTA.get(), MantaRenderer::new);
    EntityRenderers.register(ModEntities.SKID.get(), RendSkid::new);
    // EntityRenderers.register(ModEntities.KANKRELAT.get(), KankrelatRenderder::new);
    EntityRenderers.register(ModEntities.HOVERBOARD.get(), HoverboardRenderer::new);
    EntityRenderers.register(ModEntities.OVERBOARD.get(), OverboardRenderer::new);
    EntityRenderers.register(ModEntities.GUARDIAN.get(), GuardianRenderer::new);
    EntityRenderers.register(ModEntities.OVERBIKE.get(), OverbikeRenderer::new);
    //BlockEntityRenderers.register(ModTileEntities.QUANTUM_CHIPLET_TILE_ENTITY.get(), QuantumChipletRenderer::new);
});
        /*


        //registers the screens and entities
        MenuScreens.getScreenFactory(ModContainerTypes.CONTAINER_INFUSING.get(), InfusingChamberScreen::new);
        ScreenManager .<ContainerElectricInfusing, ElectricInfusingChamberScreen>registerFactory(ModContainerTypes.CONTAINER_ELECTRIC_INFUSING.get(), ElectricInfusingChamberScreen::new);
        ScreenManager.<TowerInterfaceContainer, TowerGUI>registerFactory(ModContainerTypes.TOWER_INTERFACE_CONTAINER.get(), TowerGUI::new);
        ScreenManager.<QuantumChipletContainer, QuantumChipletScreen>registerFactory(ModContainerTypes.QUANTUM_CHIPLET_CONTAINER.get(), QuantumChipletScreen::new);
        ScreenManager.<ContainerElectroplate, ElectroplatingScreen>registerFactory(ModContainerTypes.ELECTROPLATING_CONTAINER.get(), ElectroplatingScreen::new);
        ScreenManager.<ComputerControlPanelContainer, ComputerControlPanelUI>registerFactory(ModContainerTypes.COMPUTER_CONTROL_PANEL_CONTAINER.get(),
                ComputerControlPanelUI::new);
        ScreenManager.<DataTransferInterfaceContainer, DataTransferInterfaceUI>registerFactory(ModContainerTypes.DATA_TRANSFER_INTERFACE_CONTAINER.get(),
                DataTransferInterfaceUI::new);
                */



    }
}
    




