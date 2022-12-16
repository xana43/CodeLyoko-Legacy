package com.Ultra_Nerd.CodeLyokoLegacy.Entity.rend;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle.EntitySkid;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;


public final class RendSkid extends EntityRenderer<EntitySkid> {
    //private static final BakedModel SkidBladnir;

    static {
        //SkidBladnir = Myron.getModel(CodeLyokoMain.codeLyokoPrefix("entity/skid/skid"));
    }


    private RendSkid(final EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(final EntitySkid entity) {
        return SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE;
    }

    @Override
    public void render(final EntitySkid entity, final float yaw, final float tickDelta, final MatrixStack matrices, final VertexConsumerProvider vertexConsumers, final int light) {
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
        matrices.push();
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(360 - yaw));
        //MinecraftClient.getInstance().getBlockRenderManager().getModelRenderer()
        //      .render(entity.world, SkidBladnir, Blocks.AIR.getDefaultState(), entity.getBlockPos(), matrices,
        //            vertexConsumers.getBuffer(RenderLayer.getSolid()),
        //          false, entity.world.random, 0, 0);
        matrices.pop();
    }


    @Override
    public boolean shouldRender(EntitySkid pLivingEntity, Frustum pCamera, double pCamX, double pCamY, double pCamZ) {
        return true;
    }


}
