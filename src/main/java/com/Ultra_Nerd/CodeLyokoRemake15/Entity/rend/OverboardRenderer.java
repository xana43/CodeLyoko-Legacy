package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.model.ModelOverboard;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.vehicle.OverboardEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class OverboardRenderer<T extends OverboardEntity> extends EntityRenderer<T> {

    private final EntityModel<T> OverBoardModel;

    public OverboardRenderer(EntityRendererProvider.Context renderManager) {
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
        VertexConsumer vertexBuilder = bufferIn.getBuffer(this.OverBoardModel.renderType(this.getTextureLocation(entityIn)));
        this.OverBoardModel.renderToBuffer(matrixStackIn, vertexBuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        matrixStackIn.popPose();
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(@Nonnull OverboardEntity entity) {
        return CodeLyokoMain.CodeLyokoPrefix("textures/entity/overboard/overboarduv.png");
    }


}
