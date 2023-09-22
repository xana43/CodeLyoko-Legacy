package com.Ultra_Nerd.CodeLyokoLegacy.Entity.rend;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle.EntitySkid;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;


public final class RendSkid extends EntityRenderer<EntitySkid> {
    private static final Identifier TEXTURE = CodeLyokoMain.codeLyokoPrefix("textures/entity/skid/da4cdc01.png");
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    private static BakedModel SkidBlanirModel;

    public RendSkid(final EntityRendererFactory.Context ctx) {
        super(ctx);
        SkidBlanirModel = mc.getBakedModelManager().getModel(EntitySkid.getSkidLocation());
    }

    @Override
    public Identifier getTexture(final EntitySkid entity) {
        return TEXTURE;
    }

    @Override
    public void render(final EntitySkid entity, final float yaw, final float tickDelta, final MatrixStack matrices, final VertexConsumerProvider vertexConsumers, final int light) {
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
        matrices.push();
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(360 - yaw));
        mc.getBlockRenderManager().getModelRenderer().render(matrices.peek(),
                vertexConsumers.getBuffer(RenderLayer.getSolid()),Blocks.AIR.getDefaultState(),SkidBlanirModel,1,1,1,
                light,0);
        matrices.pop();
    }


    @Override
    public boolean shouldRender(EntitySkid pLivingEntity, Frustum pCamera, double pCamX, double pCamY, double pCamZ) {
        return true;
    }


}
