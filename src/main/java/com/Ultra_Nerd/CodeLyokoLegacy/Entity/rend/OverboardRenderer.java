package com.Ultra_Nerd.CodeLyokoLegacy.Entity.rend;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle.OverboardEntity;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;


public final class OverboardRenderer<T extends OverboardEntity> extends EntityRenderer<T> {
    private OverboardRenderer(final EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(final T entity) {
        return null;
    }
/*
    private final @NotNull EntityModel<T> OverBoardModel;




    public OverboardRenderer(EntityRendererProvider.@NotNull Context renderManager) {
        super(renderManager);
        this.shadowRadius = 1f;
        this.OverBoardModel = new ModelOverboard<>(renderManager.bakeLayer(ModelOverboard.LAYER_LOCATION));
    }

    @Override
    public void render(@Nonnull T entityIn, float entityYaw, float partialTicks, @Nonnull PoseStack matrixStackIn, @Nonnull MultiBufferSource bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.pushPose();
        matrixStackIn.scale(-2F, -2F, 2.0F);
        matrixStackIn.translate(0, -1.5f, 0);
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(360 + entityYaw));
        assert Minecraft.getInstance().player != null;
        this.OverBoardModel.setupAnim(entityIn, 0, 0, 0, 0, 0);
        final VertexConsumer vertexBuilder = bufferIn.getBuffer(this.OverBoardModel.renderType(this.getTextureLocation(entityIn)));
        this.OverBoardModel.renderToBuffer(matrixStackIn, vertexBuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        matrixStackIn.popPose();
    }
private static final ResourceLocation OVERBOARD_TEX = CodeLyokoMain.CodeLyokoPrefix("textures/entity/overboard/overboarduv.png");
    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(@Nonnull OverboardEntity entity) {
        return OVERBOARD_TEX;
    }

 */


}
