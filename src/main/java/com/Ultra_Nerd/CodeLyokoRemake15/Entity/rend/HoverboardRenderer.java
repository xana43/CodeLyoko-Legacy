package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.HoverboardEntity;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.model.ModelHoverboard;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class HoverboardRenderer<T extends HoverboardEntity> extends EntityRenderer<T> {

    private final EntityModel<T> BoardModel = new ModelHoverboard<>();

    public HoverboardRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager);
        this.shadowRadius = 1f;


    }

    @Override
    public void render(@Nonnull T entityIn, float entityYaw, float partialTicks, @Nonnull PoseStack matrixStackIn, @Nonnull MultiBufferSource bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.pushPose();
        matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
        matrixStackIn.translate(0, -1.5f, 0);
        if (entityIn.getFirstPassenger() != null) {
            matrixStackIn.mulPose(Vector3f.YP.rotation(Mth.clamp(entityIn.getFirstPassenger().getYRot(), 0, 90)));
        }
        this.BoardModel.setupAnim(entityIn, 0, 0, 0, 0, 0);
        VertexConsumer vertexBuilder = bufferIn.getBuffer(this.BoardModel.renderType(this.getTextureLocation(entityIn)));
        this.BoardModel.renderToBuffer(matrixStackIn, vertexBuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        matrixStackIn.popPose();
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(@Nonnull HoverboardEntity entity) {
        return CodeLyokoMain.CodeLyokoPrefix("textures/entity/hoverboard/hoverboard.png");
    }


}
