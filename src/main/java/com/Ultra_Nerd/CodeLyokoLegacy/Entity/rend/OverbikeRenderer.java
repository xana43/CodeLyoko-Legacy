package com.Ultra_Nerd.CodeLyokoLegacy.Entity.rend;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle.OverbikeEntity;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;


public final class OverbikeRenderer<T extends OverbikeEntity> extends EntityRenderer<T> {
    protected OverbikeRenderer(final EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(final T entity) {
        return null;
    }
/*
    private final EntityModel<T> BikeModel = new ModelOverbike<T>();

    public OverbikeRenderer(EntityRendererProvider.@NotNull Context renderManager) {
        super(renderManager);
        this.shadowRadius = 1f;

    }

    @Override
    public void render(@Nonnull T entityIn, float entityYaw, float partialTicks, @Nonnull PoseStack matrixStackIn, @Nonnull MultiBufferSource bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.pushPose();
        matrixStackIn.scale(-.5F, -.5F, .5F);
        matrixStackIn.translate(0, -1.5f, 0);
        this.BikeModel.setupAnim(entityIn, 0, 0, 0, 0, 0);
        VertexConsumer vertexBuilder = bufferIn.getBuffer(this.BikeModel.renderType(this.getTextureResource(entityIn)));
        this.BikeModel.renderToBuffer(matrixStackIn, vertexBuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        matrixStackIn.popPose();
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureResource(@Nonnull OverbikeEntity entity) {
        return CodeLyokoMain.CodeLyokoPrefix("textures/entity/overbike/overbiketexture.png");
    }

 */


}
