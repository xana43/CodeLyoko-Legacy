package com.Ultra_Nerd.CodeLyokoLegacy.Util;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.model.ModelHoverboard;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.model.ModelOverboard;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.rend.*;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.client.sky.carthage.CarthageEffects;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.client.sky.ice.IceEffects;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.client.sky.volcano.VolcanoEffects;
import com.Ultra_Nerd.CodeLyokoLegacy.init.*;
import com.Ultra_Nerd.CodeLyokoLegacy.mixin.client.DimensionEffectAccesor;
import com.Ultra_Nerd.CodeLyokoLegacy.particles.ColoredParticle;
import com.Ultra_Nerd.CodeLyokoLegacy.particles.TowerParticleFactory;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.ComputerControlPanelUI;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.DataTransferInterfaceUI;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.TowerGUI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.ICloudRenderHandler;
import net.minecraftforge.client.IWeatherParticleRenderHandler;
import net.minecraftforge.client.IWeatherRenderHandler;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.client.model.ForgeModelBakery;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;


public record ClientModEventSubscriber() {

public static void ClientSetup()
    {
        //for data generation
        if(Minecraft.getInstance() != null) {
            final IEventBus ModEventBus = FMLJavaModLoadingContext.get().getModEventBus();
            final IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;
            ModEventBus.addListener(ClientModEventSubscriber::onFMLClientSetupEvent);
            ModEventBus.addListener(ClientModEventSubscriber::registerParticleFactories);
            ModEventBus.addListener(ClientModEventSubscriber::registerEntityLayers);
            forgeEventBus.addListener(LyokoControls::customInput);
            ClientRegistry.registerKeyBinding(LyokoControls.KEY_MAPPING_VEHICLES_UP);
            ClientRegistry.registerKeyBinding(LyokoControls.KEY_MAPPING_VEHICLES_DOWN);
            ClientRegistry.registerKeyBinding(LyokoControls.KEY_MAPPING_CLASS_SELECT);
            ForgeModelBakery.addSpecialModel(CodeLyokoMain.CodeLyokoPrefix("entity/skid/skid"));
        }
    }




    public static void onFMLClientSetupEvent(final @NotNull FMLClientSetupEvent event) {












        setItemProperties();
        //BlockEntityRenderers.register(ModTileEntities.QUANTUM_CHIPLET_TILE_ENTITY.get(), QuantumChipletRenderer::new);

event.enqueueWork(()-> {
registerRenderLayers();
registerScreens();
registerDimensionEffects();
registerEntityRenderers();
});





        /*


        //registers the screens and entities
        MenuScreens.getScreenFactory(ModContainerTypes.CONTAINER_INFUSING.get(), InfusingChamberScreen::new);
        ScreenManager .<ContainerElectricInfusing, ElectricInfusingChamberScreen>registerFactory(ModContainerTypes.CONTAINER_ELECTRIC_INFUSING.get(), ElectricInfusingChamberScreen::new);
        ScreenManager.<TowerInterfaceContainer, TowerGUI>registerFactory(ModContainerTypes.TOWER_INTERFACE_CONTAINER.get(), TowerGUI::new);
        ScreenManager.<QuantumChipletContainer, QuantumChipletScreen>registerFactory(ModContainerTypes.QUANTUM_CHIPLET_CONTAINER.get(), QuantumChipletScreen::new);
        ScreenManager.<ContainerElectroplate, ElectroplatingScreen>registerFactory(ModContainerTypes.ELECTROPLATING_CONTAINER.get(), ElectroplatingScreen::new);


                */



    }

    private static void registerEntityLayers(final EntityRenderersEvent.@NotNull RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(ModelHoverboard.LAYER_LOCATION,ModelHoverboard::createLayer);
        event.registerLayerDefinition(ModelOverboard.LAYER_LOCATION,ModelOverboard::createBodyLayer);
       // event.registerLayerDefinition(ModModelLayers.FELINE_LAYER_LOCATION_INNER,() -> LayerDefinition.create(FelineChestPlate.createBodyLayer(LayerDefinitions.INNER_ARMOR_DEFORMATION),32,32));
        //event.registerLayerDefinition(ModModelLayers.FELINE_LAYER_LOCATION_OUTER,() -> LayerDefinition.create(FelineChestPlate.createBodyLayer(LayerDefinitions.OUTER_ARMOR_DEFORMATION),32,32));
    }



    private static void registerEntityRenderers()
    {
        EntityRenderers.register(ModEntities.BLOK.get(), RendBlok::new);
        EntityRenderers.register(ModEntities.LASER.get(), RendLaser::new);
        EntityRenderers.register(ModEntities.FAN.get(), RendFan::new);
        //EntityRenderers.register(ModEntities.HORNET.get(), HornetRenderer::new);
        EntityRenderers.register(ModEntities.MEGATANK.get(), MegaTankRenderer::new);
        //EntityRenderers.register(ModEntities.MANTA.get(), MantaRenderer::new);
        EntityRenderers.register(ModEntities.SKID.get(), RendSkid::new);
        //EntityRenderers.register(ModEntities.KANKRELAT.get(), KankrelatRenderder::new);
        EntityRenderers.register(ModEntities.HOVERBOARD.get(), HoverboardRenderer::new);
        EntityRenderers.register(ModEntities.OVERBOARD.get(), OverboardRenderer::new);
        EntityRenderers.register(ModEntities.GUARDIAN.get(), GuardianRenderer::new);
        EntityRenderers.register(ModEntities.OVERBIKE.get(), OverbikeRenderer::new);
    }
    private static void setItemProperties()
    {
        //makes certain blocks behave properly
        ItemProperties.register(ModItems.TEST_MULTIPLAYER_PHONE.get(),CodeLyokoMain.CodeLyokoPrefix("message"),
                (stack, world, entityin,integer) ->
                {
                    if(stack.isEnchanted())
                    {
                        return 1;
                    }
                    else
                    {
                        return 0;
                    }
                }
        );

        ItemProperties.register(ModItems.TEST_MULTIPLAYER_PHONE.get(),CodeLyokoMain.CodeLyokoPrefix("charge"),
                (stack,world,entityin,integer) ->
                        switch (stack.getDamageValue()) {
                            case 0 -> 0.1f;
                            case 1 -> 0.2f;
                            default -> 0;
                        });

        ItemProperties.register(ModItems.JEREMY_LAPTOP.get(), CodeLyokoMain.CodeLyokoPrefix("state"),
                (stack, world, entityin, integer) ->
                        switch (stack.getDamageValue()) {
                    case 0 -> 0.1f;
                    case 1 -> 0.2f;
                    default -> 0;
                });

        ItemProperties.register(ModItems.RAW_POLYCARBONATE.get(), CodeLyokoMain.CodeLyokoPrefix("quantity"),
                (stack, world, entityin,integer) -> {

                    if (stack.getCount() > 0 && stack.getCount() < 65) {
                        return stack.getCount() / 100f;
                    } else {
                        return 0f;
                    }
                });


        ItemProperties.register(ModItems.SILICON_WAFER.get(), CodeLyokoMain.CodeLyokoPrefix("quality"),
                (stack, world, entityin, integer) ->
                        switch (stack.getDamageValue()) {
                    case 1 -> 0.25f;
                    case 2 -> 0.5f;
                    case 3 -> 0.75f;
                    case 4 -> 1.0f;
                    default -> 0.0f;
                });
    }



    private static void registerDimensionEffects()
    {
        DimensionEffectAccesor.LyokoDimensionEffects().put(CodeLyokoMain.CodeLyokoPrefix("carthage_effects"),new CarthageEffects());
        DimensionEffectAccesor.LyokoDimensionEffects().put(CodeLyokoMain.CodeLyokoPrefix("ice_effects"),new IceEffects());
        DimensionEffectAccesor.LyokoDimensionEffects().put(CodeLyokoMain.CodeLyokoPrefix("volcano_effects"),new VolcanoEffects());
        DimensionEffectAccesor.LyokoDimensionEffects().put(CodeLyokoMain.CodeLyokoPrefix("codelyoko_effects_general"), new DimensionSpecialEffects(Float.NaN,false,
                DimensionSpecialEffects.SkyType.NONE,true,true) {
            @Override
            public @NotNull Vec3 getBrightnessDependentFogColor(@NotNull Vec3 pFogColor, float pBrightness) {
                return pFogColor;
            }

            @Override
            public boolean isFoggyAt(int pX, int pY) {
                return false;
            }

            @Nullable
            @Override
            public ICloudRenderHandler getCloudRenderHandler() {
                return null;
            }

            @Override
            public boolean constantAmbientLight() {
                return true;
            }

            @Override
            public float[] getSunriseColor(float pTimeOfDay, float pPartialTicks) {
                return null;
            }

            @Nullable
            @Override
            public IWeatherParticleRenderHandler getWeatherParticleRenderHandler() {
                return null;
            }

            @Nullable
            @Override
            public IWeatherRenderHandler getWeatherRenderHandler() {
                return null;
            }
        });
        DimensionEffectAccesor.LyokoDimensionEffects().put(CodeLyokoMain.CodeLyokoPrefix("frontier_effects"), new DimensionSpecialEffects(Float.NaN,true,
                DimensionSpecialEffects.SkyType.NONE,true,true) {
            @Override
            public @NotNull Vec3 getBrightnessDependentFogColor(final @NotNull Vec3 pFogColor, final float pBrightness) {
                return new Vec3(Color.WHITE.getRed(),Color.WHITE.getBlue(),Color.WHITE.getGreen());
            }

            @Override
            public boolean isFoggyAt(final int pX, final int pY) {
                return false;
            }

            @Nullable
            @Override
            public IWeatherRenderHandler getWeatherRenderHandler() {
                return null;
            }

            @Override
            public float[] getSunriseColor(final float pTimeOfDay, final float pPartialTicks) {
                return null;
            }

            @Nullable
            @Override
            public ICloudRenderHandler getCloudRenderHandler() {
                return null;
            }

        });
    }

    private static void registerScreens()
    {
        MenuScreens.register(ModContainerTypes.DATA_TRANSFER_INTERFACE_CONTAINER.get(), DataTransferInterfaceUI::new);
        MenuScreens.register(ModContainerTypes.TOWER_INTERFACE_CONTAINER.get(), TowerGUI::new);
        MenuScreens.register(ModContainerTypes.COMPUTER_CONTROL_PANEL_CONTAINER.get(), ComputerControlPanelUI::new);

    }



    private static void registerRenderLayers()
    {
        final RenderType cutoutMipped = RenderType.cutoutMipped();
        final RenderType cutout = RenderType.cutout();
        final RenderType transluscent = RenderType.translucent();
        final RenderType transluscentMovingBlock = RenderType.translucentMovingBlock();
        ItemBlockRenderTypes.setRenderLayer(ModFluids.DIGITAL_SEA_BLOCK.get(),transluscent);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TOWER_INTERFACE.get(), cutoutMipped);
        ItemBlockRenderTypes.setRenderLayer(ModFluids.DIGITAL_LAVA_BLOCK.get(), transluscent);
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
    }

    public static void registerParticleFactories(ParticleFactoryRegisterEvent event)
    {

        Minecraft.getInstance().particleEngine.register(ModParticles.TOWER_PARTICLE.get(), ColoredParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.TOWER_PARTICLE_2.get(), TowerParticleFactory::new);

    }

}
    




