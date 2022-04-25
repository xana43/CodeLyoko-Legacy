package com.Ultra_Nerd.CodeLyokoLegacy;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.LaserRenderer;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.rend.RendBlok;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.PacketHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModFluids;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModParticles;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.tileentity.Renderer.CoreOfLyoko;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.particle.SpellParticle;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;

import java.util.UUID;

@Environment(EnvType.CLIENT)
public record CodeLyokoClient() implements ClientModInitializer {
    public static final Identifier PacketID = CodeLyokoMain.CodeLyokoPrefix("spawn_packet");
    @Override
    public void onInitializeClient() {
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
        registerParticle();
    }
    private static void registerParticle()
    {
        ParticleFactoryRegistry.getInstance().register(ModParticles.TOWER_PARTICLE, SpellParticle.DefaultFactory::new);
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
}
