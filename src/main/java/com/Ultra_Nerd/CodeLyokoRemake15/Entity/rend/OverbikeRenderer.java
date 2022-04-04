package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.model.ModelOverbike;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.vehicle.OverbikeEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
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
public class OverbikeRenderer<T extends OverbikeEntity> extends EntityRenderer<T> {

    private final EntityModel<T> BikeModel = new ModelOverbike<T>();

    public OverbikeRenderer(EntityRendererProvider.Context renderManager) {
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
        VertexConsumer vertexBuilder = bufferIn.getBuffer(this.BikeModel.renderType(this.getTextureLocation(entityIn)));
        this.BikeModel.renderToBuffer(matrixStackIn, vertexBuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        matrixStackIn.popPose();
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(@Nonnull OverbikeEntity entity) {
        return CodeLyokoMain.CodeLyokoPrefix("textures/entity/overbike/overbiketexture.png");
    }


}
