package com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityRenderers.Vehicle;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.VehicleEntities.SkidbladnirEntity;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;


public final class SkidbladnirRenderer extends EntityRenderer<SkidbladnirEntity> {
    private static final Identifier TEXTURE = CodeLyokoMain.codeLyokoPrefix("textures/entity/skid/da4cdc01.png");
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    private static BakedModel SkidBlanirModel;
    private final EntityRendererFactory.Context context;

    public SkidbladnirRenderer(final EntityRendererFactory.Context ctx) {
        super(ctx);
        context = ctx;
        SkidBlanirModel = mc.getBakedModelManager().getModel(SkidbladnirEntity.getSkidLocation());
    }

    @Override
    public Identifier getTexture(final SkidbladnirEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(final SkidbladnirEntity entity, final float yaw, final float tickDelta, final MatrixStack matrices, final VertexConsumerProvider vertexConsumers, final int light) {
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
        if(SkidBlanirModel != null) {
            matrices.push();
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(360 - yaw));
            context.getBlockRenderManager().getModelRenderer().render(matrices.peek(),
                    vertexConsumers.getBuffer(RenderLayer.getSolid()), Blocks.AIR.getDefaultState(), SkidBlanirModel, 1, 1, 1,
                    light, 0);
            matrices.pop();
        }

    }


    @Override
    public boolean shouldRender(SkidbladnirEntity pLivingEntity, Frustum pCamera, double pCamX, double pCamY, double pCamZ) {
        return true;
    }


}
