package com.Ultra_Nerd.CodeLyokoLegacy;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.LaserRenderer;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.rend.RendBlok;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.PacketHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.DimensionCheck;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.client.sky.carthage.CustomCarthadgeSky;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.client.sky.ice.CustomIceSky;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.client.sky.volcano.CustomVolcanoSky;
import com.Ultra_Nerd.CodeLyokoLegacy.init.*;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.ClientScreens.ClassScreen;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.Devirtualized;
import com.Ultra_Nerd.CodeLyokoLegacy.tileentity.Renderer.CoreOfLyoko;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.DimensionRenderingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.fabricmc.fabric.mixin.client.rendering.DimensionEffectsAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.DeathScreen;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.particle.SpellParticle;
import net.minecraft.client.render.DimensionEffects;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.glfw.GLFW;

import javax.swing.text.JTextComponent;
import java.util.UUID;

@Environment(EnvType.CLIENT)
public record CodeLyokoClient() implements ClientModInitializer {

    public static final Identifier PacketID = CodeLyokoMain.CodeLyokoPrefix("spawn_packet");
    //keybinds
    private static KeyBinding classCreenBinding;
    private static final String keyCategory = "category." + CodeLyokoMain.MOD_ID+".lyoko_controls";
    @Override
    public void onInitializeClient() {
        //set key bindings
        classCreenBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key." + CodeLyokoMain.MOD_ID + ".class",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_ALT,
                keyCategory



        ));
        //Renderers

        BlockEntityRendererRegistry.register(ModTileEntities.LYOKO_CORE, context -> new CoreOfLyoko());
        EntityRendererRegistry.register(ModEntities.BLOK, RendBlok::new);
        EntityRendererRegistry.register(ModEntities.LASER_ENTITY_TYPE, LaserRenderer::new);
        receiveEntityPacket();
        FluidRenderRegistry();

        //Custom Sprites
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(CodeLyokoMain.CodeLyokoPrefix("block/digital_flowing"));
            registry.register(CodeLyokoMain.CodeLyokoPrefix("block/digital_flowing_lava"));
            registry.register(CodeLyokoMain.CodeLyokoPrefix("entity/laserarrow"));
            registry.register(CodeLyokoMain.CodeLyokoPrefix("particle/tower_particle_2"));

        });
        //client events
        registerItemPredicates();


        //effect registry
        DimensionEffectsAccessor.getIdentifierMap().put(CodeLyokoMain.CodeLyokoPrefix("codelyoko_effects_general"), new DimensionEffects(Float.NaN,false, DimensionEffects.SkyType.NONE,true,false) {
            @Override
            public Vec3d adjustFogColor(final Vec3d color, final float sunHeight) {
                return new Vec3d(0,0,0);
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
        DimensionRenderingRegistry.registerSkyRenderer(ModDimensions.carthage,new CustomCarthadgeSky());
        DimensionRenderingRegistry.registerSkyRenderer(ModDimensions.iceSectorWorld,new CustomIceSky());
        DimensionRenderingRegistry.registerSkyRenderer(ModDimensions.volcanoWorld,new CustomVolcanoSky());
        ParticleFactoryRegistry.getInstance().register(ModParticles.TOWER_PARTICLE, SpellParticle.DefaultFactory::new);
        //custom hud
        ClientTickEvents.START_CLIENT_TICK.register(client -> {

if(client.player != null) {
    if(DimensionCheck.playerNotInVanillaWorld(client.player)) {
        if (client.currentScreen instanceof DeathScreen) {

            client.setScreen(new Devirtualized(null, client.player.getServer().isHardcore()));
        }
    }
    if(DimensionCheck.playerInVanilla(client.player))
    {
        if(classCreenBinding.isPressed())
        {
            client.setScreen(new ClassScreen());
        }
    }
}
        });



        HudRenderCallback.EVENT.register((matrixStack, tickDelta) -> {
            final MinecraftClient mc = MinecraftClient.getInstance();
            //if(mc != null) {
                if(mc.player != null) {
                    if(DimensionCheck.playerNotInVanillaWorld(mc.player)) {
                        RenderSystem.setShaderTexture(0, CodeLyokoMain.CodeLyokoPrefix("textures/gui/lyoko_health_bar.png"));
                        matrixStack.push();

                        if(!mc.player.isCreative() && !mc.player.isSpectator()) {
                            mc.inGameHud.drawTexture(matrixStack, (mc.getWindow().getScaledWidth() >> 7) - 2, mc.getWindow().getScaledHeight() >> 11, 0, 0, 33, 254);
                            mc.inGameHud.drawTexture(matrixStack, (mc.getWindow().getScaledWidth() >> 6) - 1, (mc.getWindow().getScaledHeight() >> 11), 90, 0, 25, (int) ((12.7) * mc.player.getHealth()));

                        }

                        matrixStack.pop();
                    }
                }
           // }
        });


    }





    public void receiveEntityPacket() {
        ClientSidePacketRegistry.INSTANCE.register(PacketID, (ctx, byteBuf) -> {
            final EntityType<?> et = Registry.ENTITY_TYPE.get(byteBuf.readVarInt());
            final UUID uuid = byteBuf.readUuid();
            final int entityId = byteBuf.readVarInt();
            final Vec3d pos = PacketHandler.PacketBufUtil.readVec3d(byteBuf);
            final float pitch = PacketHandler.PacketBufUtil.readAngle(byteBuf);
            final float yaw = PacketHandler.PacketBufUtil.readAngle(byteBuf);
            ctx.getTaskQueue().execute(() -> {
                if (MinecraftClient.getInstance().world == null)
                    throw new IllegalStateException("Tried to spawn entity in a null world!");
                final Entity e = et.create(MinecraftClient.getInstance().world);
                if (e == null)
                    throw new IllegalStateException("Failed to create instance of entity \"" + Registry.ENTITY_TYPE.getId(et) + "\"!");
                e.updateTrackedPosition(pos);
                e.setPos(pos.x, pos.y, pos.z);
                e.setPitch(pitch);
                e.setYaw(yaw);
                e.setId(entityId);
                e.setUuid(uuid);
                MinecraftClient.getInstance().world.addEntity(entityId, e);
            });
        });
    }
    private static void FluidRenderRegistry()
    {
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_DIGITAL_OCEAN,ModFluids.FLOWING_DIGITAL_OCEAN,new SimpleFluidRenderHandler(CodeLyokoMain.CodeLyokoPrefix("block/digital_flowing"),CodeLyokoMain.CodeLyokoPrefix("block/digital_flowing")));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_DIGITAL_LAVA,ModFluids.FLOWING_DIGITAL_LAVA,new SimpleFluidRenderHandler(
                CodeLyokoMain.CodeLyokoPrefix("block/digital_flowing_lava"),
                CodeLyokoMain.CodeLyokoPrefix("block/digital_flowing_lava")
        ));
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),ModFluids.STILL_DIGITAL_OCEAN,ModFluids.FLOWING_DIGITAL_OCEAN);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getSolid(),ModFluids.FLOWING_DIGITAL_LAVA,ModFluids.STILL_DIGITAL_LAVA);

    }

    private static void registerItemPredicates()
    {
        //makes certain blocks behave properly
        /*
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

         */

        ModelPredicateProviderRegistry.register(ModItems.JEREMY_LAPTOP, CodeLyokoMain.CodeLyokoPrefix("state"),
                (stack, world, entity, integer) ->
                        switch (stack.getDamage()) {
                            case 0 -> 0.1f;
                            case 1 -> 0.2f;
                            default -> 0;
                        });
/*
        ItemProperties.register(ModItems.RAW_POLYCARBONATE.get(), CodeLyokoMain.CodeLyokoPrefix("quantity"),
                (stack, world, entityin,integer) -> {

                    if (stack.getCount() > 0 && stack.getCount() < 65) {
                        return stack.getCount() / 100f;
                    } else {
                        return 0f;
                    }
                });
*/

        ModelPredicateProviderRegistry.register(ModItems.SILICON_WAFER, CodeLyokoMain.CodeLyokoPrefix("quality"),
                (stack, world, entityin, integer) ->
                        switch (stack.getDamage()) {
                            case 1 -> 0.25f;
                            case 2 -> 0.5f;
                            case 3 -> 0.75f;
                            case 4 -> 1.0f;
                            default -> 0.0f;
                        });


    }
}
