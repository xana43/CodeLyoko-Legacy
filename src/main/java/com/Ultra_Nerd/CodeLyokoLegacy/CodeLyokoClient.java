package com.Ultra_Nerd.CodeLyokoLegacy;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Renderer.*;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Renderer.ElectricityRenderers.RackChargerRenderer;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Renderer.TestRenderers.ItemProjectorTestRenderer;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityModels.ModelHoverboard;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityModels.ModelOverbike;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityModels.ModelOverboard;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityRenderers.Hostile.*;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityRenderers.Misc.TriplicateRenderer;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityRenderers.Projectile.FanRenderer;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityRenderers.Projectile.LaserRenderer;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityRenderers.Vehicle.HoverboardRenderer;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityRenderers.Vehicle.OverbikeRenderer;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityRenderers.Vehicle.OverboardRenderer;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityRenderers.Vehicle.SkidbladnirRenderer;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.VehicleEntities.EntitySkid;
import com.Ultra_Nerd.CodeLyokoLegacy.HookEvents.ClientTickEvent;
import com.Ultra_Nerd.CodeLyokoLegacy.HookEvents.HudRenderCallbackOverride;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Client.ModHandledScreensClientInitializer;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.*;
import com.Ultra_Nerd.CodeLyokoLegacy.Items.Tools.Buckets.CustomColorBucket;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.PacketHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.Particles.LyokoFloatingParticle;
import com.Ultra_Nerd.CodeLyokoLegacy.Particles.LyokoRingParticle;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.Client.itemRenderers.ForceFieldEmitterRenderer;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.Client.sky.carthage.CustomCarthageSky;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.Client.sky.ice.CustomIceSky;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.Client.sky.volcano.CustomVolcanoSky;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.GeneralRendererUtils.RendererVariables;
import dev.felnull.specialmodelloader.api.event.SpecialModelLoaderEvents;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.*;
import net.fabricmc.fabric.mixin.client.rendering.DimensionEffectsAccessor;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.DimensionEffects;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.util.InputUtil;
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
    public static final KeyBinding classScreenBinding;

    public static final KeyBinding moveVehicleUp;
    public static final KeyBinding moveVehicleDown;
    public static final KeyBinding classAbility;
    public static final KeyBinding testClone;
    public static final KeyBinding selectTransportHub;
    public static final KeyBinding testPsychic;
    public static final KeyBinding testGuardianBuild;
    public static final KeyBinding testTowerScan;

    static {
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
    private static void clientEvents() {
        WorldRenderEvents.LAST.register(RendererVariables::consumeRenderSystems);
        HudRenderCallback.EVENT.register(HudRenderCallbackOverride::consume);
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
                .register(ModParticles.RING_PARTICLE, LyokoRingParticle.ScannerRingParticle::new);
    }

    private static void registerEntityRenderers() {
        EntityRendererRegistry.register(ModEntities.KANKRELAT, KankrelatRenderder::new);
        EntityRendererRegistry.register(ModEntities.BLOK, BlokRenderer::new);
        EntityRendererRegistry.register(ModEntities.MEGATANK, MegaTankRenderer::new);
        EntityRendererRegistry.register(ModEntities.LASER_ENTITY_TYPE, LaserRenderer::new);
        EntityRendererRegistry.register(ModEntities.HORNET_ENTITY_ENTITY_TYPE, HornetRenderer::new);
        EntityRendererRegistry.register(ModEntities.FAN_ENTITY_TYPE, FanRenderer::new);
        EntityRendererRegistry.register(ModEntities.SKID_ENTITY_TYPE, SkidbladnirRenderer::new);
        EntityRendererRegistry.register(ModEntities.TRIPLICATE_ENTITY_TYPE, TriplicateRenderer::new);
        //for entity that need layer locations
        EntityRendererRegistry.register(ModEntities.OVERBOARD, OverboardRenderer::new);
        EntityRendererRegistry.register(ModEntities.HOVERBOARD, HoverboardRenderer::new);
        EntityRendererRegistry.register(ModEntities.OVERBIKE, OverbikeRenderer::new);
        EntityRendererRegistry.register(ModEntities.LYOKO_GUARDIAN_ENTITY_TYPE, GuardianRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModelOverboard.LAYER_LOCATION, ModelOverboard::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(ModelHoverboard.LAYER_LOCATION, ModelHoverboard::createLayer);
        EntityModelLayerRegistry.registerModelLayer(ModelOverbike.LAYER_LOCATION,ModelOverbike::getTexturedModelData);
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

    private static void registerModelLoaders() {
        ModelLoadingPlugin.register(pluginContext -> pluginContext.addModels(CoreOfLyoko.getLyokoCore(),EntitySkid.getSkidLocation(),ForceFieldEmitterRenderer.getForceFieldLocation()));
    }

    private static void registerBlockEntityRenderers() {
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

    private static void registerColorProviders() {
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> switch (stack.getTranslationKey()) {
            case "item.codelyoko.story_book" -> 0x00008B;
            case "item.codelyoko.story_book2" -> ColorHelper.Argb.getArgb(255, 255, 0, 0);
            default -> 1;
        }, ModItems.STORY_BOOK, ModItems.STORY_BOOK2);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ((CustomColorBucket)stack.getItem()).getFluidColor(tintIndex),ModItems.LIQUID_HELIUM_BUCKET);
    }
    private static String createKeyBindingTranslationKey(final String keyName) {
        return "key." + CodeLyokoMain.MOD_ID +'.' +keyName;
    }

    private static void registerDimensionalSkyEffects()
    {
        DimensionEffectsAccessor.getIdentifierMap().put(CodeLyokoMain.codeLyokoPrefix("codelyoko_effects_general"),
                new DimensionEffects(Float.NaN, true, DimensionEffects.SkyType.NORMAL, true, false) {
                    @Override
                    public Vec3d adjustFogColor(final Vec3d color, final float sunHeight) {
                        return color;
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
        DimensionRenderingRegistry.registerSkyRenderer(ModDimensions.carthage, new CustomCarthageSky());
        DimensionRenderingRegistry.registerSkyRenderer(ModDimensions.iceSectorWorld, new CustomIceSky());
        DimensionRenderingRegistry.registerSkyRenderer(ModDimensions.volcanoWorld, new CustomVolcanoSky());
    }
    private static void clientTickEventRegister() {
        ClientTickEvents.START_CLIENT_TICK.register(ClientTickEvent::consume);
    }
    @Override
    public void onInitializeClient() {
        SpecialModelLoaderEvents.LOAD_SCOPE.register(location -> CodeLyokoMain.MOD_ID.equals(location.getNamespace()));
        PacketHandler.clientPacketRegistry();
        registerModelLoaders();
        registerBlockEntityRenderers();
        registerEntityRenderers();
        FluidRenderRegistry();
        ModHandledScreensClientInitializer.handledScreenRegistration();
        registerColorProviders();
        registerItemPredicates();
        registerDimensionalSkyEffects();
        clientEvents();
        clientTickEventRegister();
        registerParticles();
    }

}
