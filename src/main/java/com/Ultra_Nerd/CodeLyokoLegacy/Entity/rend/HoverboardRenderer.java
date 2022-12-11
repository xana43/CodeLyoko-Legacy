package com.Ultra_Nerd.CodeLyokoLegacy.Entity.rend;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle.HoverboardEntity;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;


public final class HoverboardRenderer<T extends HoverboardEntity> extends EntityRenderer<T> {
    private HoverboardRenderer(final EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(final T entity) {
        return null;
    }
/*
    private final @NotNull ModelHoverboard <T> BoardModel;
    public HoverboardRenderer(EntityRendererProvider.@NotNull Context manager) {
        super(manager);
        this.BoardModel = new ModelHoverboard<>(manager.bakeLayer(ModelHoverboard.LAYER_LOCATION));
    }
   private static final ResourceLocation HoverboardTex = CodeLyokoMain.CodeLyokoPrefix("textures/entity/hoverboard/hoverboard.png");
    @Override
    public void render(@Nonnull T entityIn, float entityYaw, float partialTicks, @Nonnull PoseStack matrixStackIn, @Nonnull MultiBufferSource bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.pushPose();
        matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
        matrixStackIn.translate(0, -1.5f, 0);
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(360 + entityYaw));
        this.BoardModel.setupAnim(entityIn, 0, 0, 0, 0, 0);
        final VertexConsumer vertexBuilder = bufferIn.getBuffer(this.BoardModel.renderType(this.getTextureResource(entityIn)));
        this.BoardModel.renderToBuffer(matrixStackIn, vertexBuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        matrixStackIn.popPose();
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureResource(@Nonnull HoverboardEntity entity) {
        return HoverboardTex;
    }

 */


}
