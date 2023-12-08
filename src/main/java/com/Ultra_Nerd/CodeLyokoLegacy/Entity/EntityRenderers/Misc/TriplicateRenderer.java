package com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityRenderers.Misc;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.SamuraiClass.ClientTriplicateCloneEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.SamuraiClass.ServerTriplicateCloneEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.util.SkinTextures;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public final class TriplicateRenderer<T extends ServerTriplicateCloneEntity> extends EntityRenderer<T> {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    private final EntityRendererFactory.Context ctx;
    public TriplicateRenderer(final EntityRendererFactory.Context ctx) {
        super(ctx);
        this.ctx = ctx;
    }
    private PlayerEntityRenderer entityRenderer;
    private ClientTriplicateCloneEntity clientTriplicateCloneEntity;
    @Override
    public void render(final T entity, final float yaw, final float tickDelta, final MatrixStack matrices, final VertexConsumerProvider vertexConsumers, final int light) {
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);

        if(mc.player != null) {
            if (entityRenderer == null) {
                if (mc.player.getSkinTextures().model().getName().equals(SkinTextures.Model.WIDE.getName())) {
                    entityRenderer = new PlayerEntityRenderer(ctx, false);
                } else {
                    entityRenderer = new PlayerEntityRenderer(ctx, true);
                }
            }
            if (clientTriplicateCloneEntity == null) {
                clientTriplicateCloneEntity = new ClientTriplicateCloneEntity(mc.world, mc.getGameProfile());

            }
            clientTriplicateCloneEntity.setTriplicateClone(entity);
            clientTriplicateCloneEntity.setEntityOwner(mc.player);
            entityRenderer.render(clientTriplicateCloneEntity, entity.getBodyYaw(), tickDelta, matrices, vertexConsumers, light);
        }
    }

    @Override
    protected boolean hasLabel(final T entity) {
        return entity.shouldRenderName() && super.hasLabel(entity);
    }

    @Override
    public Identifier getTexture(final T entity) {
        if(mc.player != null) {
            return mc.player.getSkinTextures().texture();
        }
        return null;
    }
}
