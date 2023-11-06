package com.Ultra_Nerd.CodeLyokoLegacy;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Renderer.*;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Renderer.ElectricityRenderers.RackChargerRenderer;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Renderer.TestRenderers.ItemProjectorTestRenderer;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.LaserRenderer;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.model.ModelHoverboard;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.model.ModelOverboard;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.rend.*;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle.EntitySkid;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.PacketHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.init.*;
import com.Ultra_Nerd.CodeLyokoLegacy.items.Tools.Buckets.CustomColorBucket;
import com.Ultra_Nerd.CodeLyokoLegacy.items.armor.SuperCalculatorDataLinker;
import com.Ultra_Nerd.CodeLyokoLegacy.particles.LyokoFloatingParticle;
import com.Ultra_Nerd.CodeLyokoLegacy.particles.LyokoRingParticle;
import com.Ultra_Nerd.CodeLyokoLegacy.player.PlayerClassType;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.ClientScreens.ClassScreen;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.*;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.ElectricitySystemScreens.RackChargerScreen;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.SuperCalculatorNetworkScreens.DemarcationPointScreen;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.TestScreens.PlayerProfileDebug;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.TestScreens.VehicleMaterializationTest;
import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import com.Ultra_Nerd.CodeLyokoLegacy.util.GeneralRendererUtils.RendererVariables;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.util.client.itemRenderers.ForceFieldEmitterRenderer;
import com.Ultra_Nerd.CodeLyokoLegacy.util.client.sky.carthage.CustomCarthadgeSky;
import com.Ultra_Nerd.CodeLyokoLegacy.util.client.sky.ice.CustomIceSky;
import com.Ultra_Nerd.CodeLyokoLegacy.util.client.sky.volcano.CustomVolcanoSky;
import com.mojang.blaze3d.systems.RenderSystem;
import dev.felnull.specialmodelloader.api.event.SpecialModelLoaderEvents;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.*;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.mixin.client.rendering.DimensionEffectsAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.DeathScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.DimensionEffects;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public record CodeLyokoClient() implements ClientModInitializer {

    private static String createKeyCategory(final String name)
    {
        return "category."+CodeLyokoMain.MOD_ID+'.'+name;
    }

    private static final String KEY_CATEGORY_MAIN = createKeyCategory("lyoko_controls");
    private static final String KEY_CATEGORY_CREATIVE = createKeyCategory("creative_keys");

    //keybinds
    private static KeyBinding classScreenBinding;

    private static KeyBinding moveVehicleUp;
    private static KeyBinding moveVehicleDown;
    private static KeyBinding classAbility;
    private static KeyBinding testClone;
    private static KeyBinding selectTransportHub;
    private static KeyBinding testPsychic;
    private static KeyBinding testGuardianBuild;
    private static KeyBinding testTowerScan;


    private static void clientEvents() {
        HudRenderCallback.EVENT.register((matrixStack, tickDelta) -> {
            final MinecraftClient mc = MinecraftClient.getInstance();
            //if(mc != null) {
            if (mc.player != null) {
                if (MethodUtil.DimensionCheck.playerNotInVanillaWorld(mc.player)) {
                    RenderSystem.setShaderTexture(0,
                            CodeLyokoMain.codeLyokoPrefix("textures/gui/lyoko_health_bar.png"));
                    final Identifier texture =  CodeLyokoMain.codeLyokoPrefix("textures/gui/lyoko_health_bar.png");
                    if (!mc.player.isCreative() && !mc.player.isSpectator()) {
                       matrixStack.drawTexture( texture, (mc.getWindow().getScaledWidth() >> 7) - 2,
                            mc.getWindow().getScaledHeight() >> 11, 0, 0, 33
                               , 254);

                        matrixStack.drawTexture(texture, mc.getWindow().getScaledWidth() >> 4,
                                mc.getWindow().getScaledHeight() >> 11, 174, 0, 6, 254);
                        int texV = 0;
                        switch (CardinalData.LyokoClass.getLyokoClass(mc.player)) {
                            case 0 -> texV = PlayerClassType.Feline.getTextureIndex();
                            case 1 -> texV = PlayerClassType.Samurai.getTextureIndex();
                            case 2 -> texV = PlayerClassType.Ninja.getTextureIndex();
                            case 3 -> texV = PlayerClassType.Guardian.getTextureIndex();

                        }

                        matrixStack.drawTexture(texture, (mc.getWindow().getScaledWidth() >> 6) - 1,
                                (mc.getWindow().getScaledHeight() >> 11), texV, 0, 25,
                                (int) ((mc.getWindow().getScaledHeight() >> 5) * (mc.player.getHealth() * 1.6f)));
                        matrixStack.drawTexture(texture, mc.getWindow().getScaledWidth() >> 4,
                                mc.getWindow().getScaledHeight() >> 11, 183, 0, 6,
                                (CardinalData.DigitalEnergyComponent.getCurrentEnergy(mc.player)) << 1);

                    }

                   // mc.inGameHud.render(matrixStack,tickDelta);
                }
            }
            // }
        });

    }

    private static void registerParticles() {
        ParticleFactoryRegistry.getInstance()
                .register(ModParticles.TOWER_PARTICLE, LyokoFloatingParticle.TowerParticleNeutral::new);
        ParticleFactoryRegistry.getInstance()
                .register(ModParticles.TOWER_PARTICLE_XANA, LyokoFloatingParticle.TowerParticleXana::new);
        ParticleFactoryRegistry.getInstance()
                .register(ModParticles.TOWER_PARTICLE_JEREMY, LyokoFloatingParticle.TowerParticleJeremy::new);
        ParticleFactoryRegistry.getInstance()
                .register(ModParticles.TOWER_PARTICLE_FRANZ, LyokoFloatingParticle.TowerParticleFranz::new);
        ParticleFactoryRegistry.getInstance()
                .register(ModParticles.RING_PARTICLE, LyokoRingParticle.TestRingParticle::new);
    }

    private static void registerEntityRenderers() {
        EntityRendererRegistry.register(ModEntities.BLOK, RendBlok::new);
        EntityRendererRegistry.register(ModEntities.MEGATANK, MegaTankRenderer::new);
        EntityRendererRegistry.register(ModEntities.LASER_ENTITY_TYPE, LaserRenderer::new);
        EntityRendererRegistry.register(ModEntities.HORNET_ENTITY_ENTITY_TYPE, HornetRenderer::new);
        EntityRendererRegistry.register(ModEntities.FAN_ENTITY_TYPE, RendFan::new);
        EntityRendererRegistry.register(ModEntities.SKID_ENTITY_TYPE,RendSkid::new);
        EntityRendererRegistry.register(ModEntities.TRIPLICATE_ENTITY_TYPE,TriplicateRenderer::new);
        //for entity that need layer locations
        EntityRendererRegistry.register(ModEntities.OVERBOARD, OverboardRenderer::new);
        EntityRendererRegistry.register(ModEntities.HOVERBOARD, HoverboardRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModelOverboard.LAYER_LOCATION, ModelOverboard::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(ModelHoverboard.LAYER_LOCATION, ModelHoverboard::createLayer);

    }

    private static void FluidRenderRegistry() {
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_DIGITAL_OCEAN, ModFluids.FLOWING_DIGITAL_OCEAN,
                new SimpleFluidRenderHandler(CodeLyokoMain.codeLyokoPrefix("block/digital_flowing"),
                        CodeLyokoMain.codeLyokoPrefix("block/digital_flowing")));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_DIGITAL_LAVA, ModFluids.FLOWING_DIGITAL_LAVA,
                new SimpleFluidRenderHandler(CodeLyokoMain.codeLyokoPrefix("block/digital_flowing_lava"),
                        CodeLyokoMain.codeLyokoPrefix("block/digital_flowing_lava")));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_LIQUID_HELIUM, ModFluids.FLOWING_LIQUID_HELIUM,
                new SimpleFluidRenderHandler(CodeLyokoMain.codeLyokoPrefix("block/liquid_helium_still"),
                        CodeLyokoMain.codeLyokoPrefix("block/liquid_helium_flow")));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_URANIUM,ModFluids.FLOWING_URANIUM,
                new SimpleFluidRenderHandler(CodeLyokoMain.codeLyokoPrefix("block/uranium_still"),
                        CodeLyokoMain.codeLyokoPrefix("block/uranium_flow")));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_LIQUID_HELIUM,
                ModFluids.FLOWING_LIQUID_HELIUM, ModFluids.STILL_DIGITAL_OCEAN, ModFluids.FLOWING_DIGITAL_OCEAN);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getSolid(), ModFluids.FLOWING_DIGITAL_LAVA,
                ModFluids.STILL_DIGITAL_LAVA);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), ModBlocks.FALSE_WATER,
                ModBlocks.CHIPLET_FRANZ_BLOCK, ModBlocks.PROJECTOR_FOCUS,ModBlocks.LYOKO_CORE);
        

    }

    private static void registerItemPredicates() {

        //makes certain blocks behave properly

        ModelPredicateProviderRegistry.register(ModItems.TEST_MULTIPLAYER_PHONE,
                CodeLyokoMain.codeLyokoPrefix("message"),
                (stack, world, entityin, integer) -> stack.hasEnchantments() ? 1 : 0);

        ModelPredicateProviderRegistry.register(ModItems.TEST_MULTIPLAYER_PHONE,
                CodeLyokoMain.codeLyokoPrefix("charge"),
                (stack, world, entityin, integer) -> switch (stack.getDamage()) {
                    case 0 -> 0.1f;
                    case 1 -> 0.2f;
                    default -> 0;
                });


        ModelPredicateProviderRegistry.register(ModItems.JEREMY_LAPTOP, CodeLyokoMain.codeLyokoPrefix("state"),
                (stack, world, entity, integer) -> switch (stack.getDamage()) {
                    case 0 -> 0.1f;
                    case 1 -> 0.2f;
                    default -> 0;
                });
        ModelPredicateProviderRegistry.register(ModItems.DIGITAL_SABER, CodeLyokoMain.codeLyokoPrefix("blocking"),
                (stack, world, entity, seed) -> {

                    if (entity == null) {
                        return 0;
                    }
                    return entity.isUsingItem() && entity.getActiveItem() == stack ? 1 : 0;
                });

        ModelPredicateProviderRegistry.register(ModItems.RAW_POLYCARBONATE, CodeLyokoMain.codeLyokoPrefix("quantity"),
                (stack, world, entity, integer) -> {

                    if (stack.getCount() > 0 && stack.getCount() < 65) {
                        return stack.getCount() / 100f;
                    } else {
                        return 0f;
                    }
                });


        ModelPredicateProviderRegistry.register(ModItems.SILICON_WAFER, CodeLyokoMain.codeLyokoPrefix("quality"),
                (stack, world, entity, integer) -> switch (stack.getDamage()) {
                    case 1 -> 0.25f;
                    case 2 -> 0.5f;
                    case 3 -> 0.75f;
                    case 4 -> 1;
                    default -> 0.0f;
                });


    }

    private static void registerModelLoaders()
    {

        ModelLoadingPlugin.register(pluginContext -> pluginContext.addModels(CoreOfLyoko.getLyokoCore(),EntitySkid.getSkidLocation()));
        //ModelLoadingPluginManager.registerPlugin(pluginContext -> pluginContext.addModels(CoreOfLyoko.getLyokoCore(), EntitySkid.getSkidLocation()));

    }

    private static void registerBlockEntityRenderers()
    {
        BlockEntityRendererFactories.register(ModBlockEntities.COMPUTER_FLUID_INTAKE_BLOCK_ENTITY,
                ComputerIntakePumpRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.LYOKO_CORE, CoreOfLyoko::new);
        BlockEntityRendererFactories.register(ModBlockEntities.LAPTOP_CHARGER_BLOCK_ENTITY_BLOCK_ENTITY,
                LaptopChargerRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.HOLOGRAM_PROJECTOR_TILE_ENTITY_BLOCK_ENTITY_TYPE,
                HologramRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.COMPUTER_CIRCULATOR_BLOCK_ENTITY_TYPE,
                ComputerCirculatorRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.ITEM_PROJECTOR_TEST_BLOCK_ENTITY, ItemProjectorTestRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.RACK_CHARGER_BLOCK_ENTITY, RackChargerRenderer::new);

    }

    private static void handledScreenRegistration()
    {
        HandledScreens.register(ModScreenHandlers.TOWER_INTERFACE_SCREEN_HANDLER, TowerGUI::new);
        HandledScreens.register(ModScreenHandlers.CONTROL_PANEL_SCREEN_HANDLER_SCREEN_HANDLER_TYPE,
                ComputerControlPanelUI::new);
        HandledScreens.register(ModScreenHandlers.COMPUTER_REACTOR_SCREEN_HANDLER, ReactorGUI::new);
        HandledScreens.register(ModScreenHandlers.COMPUTER_INTERFACE_SCREEN_SCREEN_HANDLER_TYPE,
                ComputerInterfaceUi::new);
        HandledScreens.register(ModScreenHandlers.PROFILE_DEBUG_SCREEN_HANDLER_SCREEN_HANDLER_TYPE,
                PlayerProfileDebug::new);
        HandledScreens.register(ModScreenHandlers.VEHICLE_MATERIALIZE_TEST_HANDLER_SCREEN_HANDLER_TYPE,
                VehicleMaterializationTest::new);
        HandledScreens.register(ModScreenHandlers.RACK_CHARGER_HANDLER_SCREEN_TYPE, RackChargerScreen::new);
        HandledScreens.register(ModScreenHandlers.DEMARCATION_SCREEN_HANDLER_TYPE, DemarcationPointScreen::new);
        HandledScreens.register(ModScreenHandlers.LITHOGRAPHY_SCREEN_HANDLER_TYPE,LithographyGUI::new);
    }
    private static void registerColorProviders()
    {
        ColorProviderRegistry.ITEM.register((stack, tintIndex) ->


                {
                    return switch (stack.getTranslationKey()) {
                        case "item.codelyoko.story_book" -> 0x00008B;
                        case "item.codelyoko.story_book2" -> ColorHelper.Argb.getArgb(255, 255, 0, 0);
                        default -> 1;
                    };

                    //return 0x00008B;
                }

                , ModItems.STORY_BOOK, ModItems.STORY_BOOK2);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ((CustomColorBucket)stack.getItem()).getFluidColor(tintIndex),ModItems.LIQUID_HELIUM_BUCKET);
    }
    private static String createKeyBindingTranslationKey(final String keyName)
    {
        return "key." + CodeLyokoMain.MOD_ID +'.' +keyName;
    }
    private static void registerKeys()
    {
        classScreenBinding = KeyBindingHelper.registerKeyBinding(
                new KeyBinding(createKeyBindingTranslationKey("class"), InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_RIGHT_ALT,
                        KEY_CATEGORY_MAIN));
        moveVehicleDown = KeyBindingHelper.registerKeyBinding(new KeyBinding(createKeyBindingTranslationKey("vehicle.down"),
                InputUtil.Type.KEYSYM,GLFW.GLFW_KEY_PAGE_DOWN, KEY_CATEGORY_MAIN));
        moveVehicleUp = KeyBindingHelper.registerKeyBinding(new KeyBinding(createKeyBindingTranslationKey("vehicle.up"),
                InputUtil.Type.KEYSYM,GLFW.GLFW_KEY_PAGE_UP, KEY_CATEGORY_MAIN));
        selectTransportHub = KeyBindingHelper.registerKeyBinding(new KeyBinding(createKeyBindingTranslationKey("skidbladnir.selecthub"),
                InputUtil.Type.KEYSYM,GLFW.GLFW_KEY_J, KEY_CATEGORY_MAIN));
        classAbility = KeyBindingHelper.registerKeyBinding(new KeyBinding(createKeyBindingTranslationKey("class_ability"),InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_G,KEY_CATEGORY_MAIN));
        //test
        testClone = KeyBindingHelper.registerKeyBinding(new KeyBinding(createKeyBindingTranslationKey("test_clone"),InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_GRAVE_ACCENT, KEY_CATEGORY_CREATIVE));
        testPsychic = KeyBindingHelper.registerKeyBinding(new KeyBinding(createKeyBindingTranslationKey("test_psychic"),InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_APOSTROPHE, KEY_CATEGORY_CREATIVE));
        testGuardianBuild = KeyBindingHelper.registerKeyBinding(new KeyBinding(createKeyBindingTranslationKey("test_build"), InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_SEMICOLON, KEY_CATEGORY_CREATIVE));
        testTowerScan = KeyBindingHelper.registerKeyBinding(new KeyBinding(createKeyBindingTranslationKey("test_tower"),InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_E,KEY_CATEGORY_MAIN));
    }
    private static final PacketByteBuf keyboardByteBuf = PacketByteBufs.create();
    @Override
    public void onInitializeClient() {
        PacketHandler.clientPacketRegistry();
        SpecialModelLoaderEvents.LOAD_SCOPE.register(location -> CodeLyokoMain.MOD_ID.equals(location.getNamespace()));
        //set key bindings
        registerKeys();
        registerModelLoaders();
        registerBlockEntityRenderers();

        registerEntityRenderers();

        //receiveEntityPacket();
        FluidRenderRegistry();
        handledScreenRegistration();
        //client events
        registerColorProviders();
        registerItemPredicates();
        //effect registry
        DimensionEffectsAccessor.getIdentifierMap().put(CodeLyokoMain.codeLyokoPrefix("codelyoko_effects_general"),
                new DimensionEffects(Float.NaN, true, DimensionEffects.SkyType.NONE, true, false) {
                    @Override
                    public Vec3d adjustFogColor(final Vec3d color, final float sunHeight) {
                        return Vec3d.ZERO;
                    }

                    @Override
                    public boolean useThickFog(final int camX, final int camY) {
                        return false;
                    }

                    @Override
                    public float @Nullable [] getFogColorOverride(final float skyAngle, final float tickDelta) {
                        return null;
                    }


                });
        DimensionRenderingRegistry.registerSkyRenderer(ModDimensions.carthage, new CustomCarthadgeSky());
        DimensionRenderingRegistry.registerSkyRenderer(ModDimensions.iceSectorWorld, new CustomIceSky());
        DimensionRenderingRegistry.registerSkyRenderer(ModDimensions.volcanoWorld, new CustomVolcanoSky());

        //custom key response

        WorldRenderEvents.LAST.register(context -> {
            RendererVariables.setConsumerProvider(context.consumers());
            RendererVariables.populateMatrixStack(context.matrixStack());
        });
        //custom death screen
        ClientTickEvents.START_CLIENT_TICK.register(client -> {

            if (client.player != null) {
                if(client.player.getAbilities().creativeMode) {
                    if(testTowerScan.isPressed())
                    {
                        ClientPlayNetworking.send(PacketHandler.TOWER_SCANNER,PacketByteBufs.empty());
                    }
                    //testing buttons
                    if (testClone.wasPressed()) {
                        keyboardByteBuf.clear();
                        keyboardByteBuf.writeGameProfile(client.player.getGameProfile());
                        ClientPlayNetworking.send(PacketHandler.SPAWN_TRIPLICATE, keyboardByteBuf);
                    }
                    if (testPsychic.isPressed()) {
                        final HitResult hitResult = client.crosshairTarget;
                        final PacketByteBuf buf = PacketByteBufs.create();
                        if (hitResult.getType() == HitResult.Type.BLOCK || hitResult.getType() == HitResult.Type.MISS) {
                            buf.writeBlockHitResult((BlockHitResult) hitResult);
                            ClientPlayNetworking.send(PacketHandler.RAY_CAST, buf);
                        } else {
                            final EntityHitResult entityHitResult = (EntityHitResult) hitResult;
                            final Vec3d entityPosition = entityHitResult.getPos();
                            buf.writeUuid(entityHitResult.getEntity().getUuid());
                            buf.writeVec3d(entityPosition);
                            ClientPlayNetworking.send(PacketHandler.RAY_CAST_ENTITY, buf);
                        }
                    } else if (!testPsychic.isPressed() && testPsychic.wasPressed()) {

                        ClientPlayNetworking.send(PacketHandler.RAY_CAST_DROP, PacketByteBufs.empty());

                    }
                    if (testGuardianBuild.wasPressed()) {
                        final HitResult hitResult = client.crosshairTarget;
                        final PacketByteBuf buf = PacketByteBufs.create();
                        if (hitResult.getType() == HitResult.Type.BLOCK || hitResult.getType() == HitResult.Type.MISS) {
                            buf.writeBlockHitResult((BlockHitResult) hitResult);
                            ClientPlayNetworking.send(PacketHandler.BUILD_HOLOGRAM, buf);
                        }
                    }
                } else {
                    if(classAbility.isPressed())
                    {
                        switch (CardinalData.LyokoClass.getLyokoClass(client.player))
                        {
                            case 0 ->{}
                            case 1 ->{
                                keyboardByteBuf.clear();
                                keyboardByteBuf.writeGameProfile(client.player.getGameProfile());
                                ClientPlayNetworking.send(PacketHandler.SPAWN_TRIPLICATE, keyboardByteBuf);
                            }
                            case 2 ->{
                                final HitResult hitResult = client.crosshairTarget;
                                final PacketByteBuf buf = PacketByteBufs.create();
                                if (hitResult.getType() == HitResult.Type.BLOCK || hitResult.getType() == HitResult.Type.MISS) {
                                    buf.writeBlockHitResult((BlockHitResult) hitResult);
                                    ClientPlayNetworking.send(PacketHandler.RAY_CAST, buf);
                                } else {
                                    final EntityHitResult entityHitResult = (EntityHitResult) hitResult;
                                    final Vec3d entityPosition = entityHitResult.getPos();
                                    buf.writeUuid(entityHitResult.getEntity().getUuid());
                                    buf.writeVec3d(entityPosition);
                                    ClientPlayNetworking.send(PacketHandler.RAY_CAST_ENTITY, buf);
                                }
                            }
                            case 3 -> {
                                final HitResult hitResult = client.crosshairTarget;
                                final PacketByteBuf buf = PacketByteBufs.create();
                                if (hitResult.getType() == HitResult.Type.BLOCK || hitResult.getType() == HitResult.Type.MISS) {
                                    buf.writeBlockHitResult((BlockHitResult) hitResult);
                                    ClientPlayNetworking.send(PacketHandler.BUILD_HOLOGRAM, buf);
                                }
                            }
                        }
                    } else if (!classAbility.isPressed() && classAbility.wasPressed()) {
                        switch (CardinalData.LyokoClass.getLyokoClass(client.player))
                        {
                            case 0 ->{}
                            case 1 ->{}
                            case 2 -> ClientPlayNetworking.send(PacketHandler.RAY_CAST_DROP, PacketByteBufs.empty());
                            case 3 ->{}
                        }
                    }
                }
                //end of testing buttons
                //toggle proctor movement of vehicles
                if (MethodUtil.DimensionCheck.playerNotInVanillaWorld(client.player)) {

                    if(moveVehicleUp.isPressed())
                    {
                        keyboardByteBuf.clear();
                        keyboardByteBuf.writeInt(1);
                        ClientPlayNetworking.send(PacketHandler.KEYBOARD_UPDATE,keyboardByteBuf);
                    } else if (moveVehicleDown.isPressed()) {
                        keyboardByteBuf.clear();
                        keyboardByteBuf.writeInt(0);
                        ClientPlayNetworking.send(PacketHandler.KEYBOARD_UPDATE,keyboardByteBuf);
                    }
                    else if((moveVehicleUp.wasPressed() || moveVehicleDown.wasPressed()) && !moveVehicleUp.isPressed() && !moveVehicleDown.isPressed()){
                        keyboardByteBuf.clear();
                        keyboardByteBuf.writeInt(-1);
                        ClientPlayNetworking.send(PacketHandler.KEYBOARD_UPDATE,keyboardByteBuf);
                    }
                    if(selectTransportHub.isPressed())
                    {
                        ClientPlayNetworking.send(PacketHandler.SKID_BLADNIR_UPDATE,PacketByteBufs.empty());
                    }
                }

                if (MethodUtil.DimensionCheck.playerNotInVanillaWorld(client.player)) {
                        if (client.currentScreen instanceof DeathScreen) {
                            if (client.getServer().isSingleplayer()) {
                                client.setScreen(new Devirtualized(null, client.getServer().isHardcore()));

                            } else {
                                client.setScreen(new Devirtualized(null, client.getServer().isHardcore()));
                            }
                        }
                }


                if (MethodUtil.DimensionCheck.playerInVanilla(client.player) && client.player.getEquippedStack(
                        EquipmentSlot.CHEST).isOf(ModItems.LINKER)) {
                    final ItemStack linkerStack = client.player.getEquippedStack(EquipmentSlot.CHEST);
                    final SuperCalculatorDataLinker SuperCalculatorDataLinker = (SuperCalculatorDataLinker) linkerStack.getItem();
                    final long storedEnergy = SuperCalculatorDataLinker.getStoredEnergy(linkerStack);
                    if (classScreenBinding.isPressed() && (storedEnergy > 0 || client.player.isCreative())) {
                        client.setScreen(new ClassScreen());
                    }
                } else if (classScreenBinding.isPressed()) {
                    client.player.sendMessage(Text.translatable("lyoko.link.unavailable"));
                }
            }
        });
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.FORCE_FIELD_EMITTER, new ForceFieldEmitterRenderer());
        clientEvents();
        registerParticles();
    }
}
