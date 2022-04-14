package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntityLaser;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix3f;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;


public final class RendLaser<T extends EntityLaser> extends ArrowRenderer<T> {


    public RendLaser(EntityRendererProvider.@NotNull Context rendManIn) {
        super(rendManIn);

    }

    @Override
    public void render(@Nonnull T pEntity, float pEntityYaw, float pPartialTicks, @Nonnull PoseStack pMatrixStack, @Nonnull MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose();
        pMatrixStack.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.yRotO, pEntity.getYRot()) - 90.0F));
        pMatrixStack.mulPose(Vector3f.ZP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot())));
        int i = 0;
        float f = 0.0F;
        float f1 = 0.5F;
        float f2 = 0.0F;
        float f3 = 0.15625F;
        float f4 = 0.0F;
        float f5 = 0.15625F;
        float f6 = 0.15625F;
        float f7 = 0.3125F;
        float f8 = 0.05625F;
        float f9 = (float)pEntity.shakeTime - pPartialTicks;
        if (f9 > 0.0F) {
            float f10 = -Mth.sin(f9 * 3.0F) * f9;
            pMatrixStack.mulPose(Vector3f.ZP.rotationDegrees(f10));
        }

        pMatrixStack.mulPose(Vector3f.XP.rotationDegrees(45.0F));
        pMatrixStack.scale(0.05625F, 0.05625F, 0.05625F);
        pMatrixStack.translate(-4.0D, 0.0D, 0.0D);
        final VertexConsumer vertexconsumer = pBuffer.getBuffer(RenderType.entityCutout(this.getTextureLocation(pEntity)));
        final PoseStack.Pose posestack$pose = pMatrixStack.last();
        final Matrix4f matrix4f = posestack$pose.pose();
        final Matrix3f matrix3f = posestack$pose.normal();
        this.vertex(matrix4f, matrix3f, vertexconsumer, -7, -2, -2, 0.0F, 0.15625F, -1, 0, 0, pPackedLight);
        this.vertex(matrix4f, matrix3f, vertexconsumer, -7, -2, 2, 0.15625F, 0.15625F, -1, 0, 0, pPackedLight);
        this.vertex(matrix4f, matrix3f, vertexconsumer, -7, 2, 2, 0.15625F, 0.3125F, -1, 0, 0, pPackedLight);
        this.vertex(matrix4f, matrix3f, vertexconsumer, -7, 2, -2, 0.0F, 0.3125F, -1, 0, 0, pPackedLight);
        this.vertex(matrix4f, matrix3f, vertexconsumer, -7, 2, -2, 0.0F, 0.15625F, 1, 0, 0, pPackedLight);
        this.vertex(matrix4f, matrix3f, vertexconsumer, -7, 2, 2, 0.15625F, 0.15625F, 1, 0, 0, pPackedLight);
        this.vertex(matrix4f, matrix3f, vertexconsumer, -7, -2, 2, 0.15625F, 0.3125F, 1, 0, 0, pPackedLight);
        this.vertex(matrix4f, matrix3f, vertexconsumer, -7, -2, -2, 0.0F, 0.3125F, 1, 0, 0, pPackedLight);

        for(int j = 0; j < 4; ++j) {
            pMatrixStack.mulPose(Vector3f.XP.rotationDegrees(90.0F));
            this.vertex(matrix4f, matrix3f, vertexconsumer, -8, -2, 0, 0.0F, 0.0F, 0, 1, 0, pPackedLight);
            this.vertex(matrix4f, matrix3f, vertexconsumer, 8, -2, 0, 0.5F, 0.0F, 0, 1, 0, pPackedLight);
            this.vertex(matrix4f, matrix3f, vertexconsumer, 8, 2, 0, 0.5F, 0.15625F, 0, 1, 0, pPackedLight);
            this.vertex(matrix4f, matrix3f, vertexconsumer, -8, 2, 0, 0.0F, 0.15625F, 0, 1, 0, pPackedLight);
        }

        pMatrixStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }


    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(@Nonnull EntityLaser entity) {
        // TODO Auto-generated method stub
        return CodeLyokoMain.CodeLyokoPrefix("textures/entity/laserarrow.png");
    }


}
