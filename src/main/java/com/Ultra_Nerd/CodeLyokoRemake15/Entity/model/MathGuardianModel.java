package com.Ultra_Nerd.CodeLyokoRemake15.Entity.model;

import com.Ultra_Nerd.CodeLyokoRemake15.Entity.GuardianEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.model.ModelRenderer;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class MathGuardianModel extends EntityModel<GuardianEntity> implements EntityRendererProvider {
    /*
    private final EntityModel guardian;
    private final int textureHeight;
    private final int textureWidth;
    private final EntityRenderer thisRenderer;
    public MathGuardianModel() {
        textureHeight = 32;
        textureWidth = 32;
        guardian = new EntityRenderer<GuardianEntity>(this.create(new EntityRendererProvider.Context())) {

        };
        guardian(7.0F, 24.0F, -3.0F);
        for (float x = -32.F; x <= 32.F; x++) {
            for (float z = -32.F; z <= 32.F; z++) {
                //if (Math.pow(x, 2.F) + Math.pow(y - 32F, 2F) + Math.pow(z, 2.F) - Math.pow(32.F, 2.F) == 0F)
                float y = (float) Math.sqrt(Math.pow(32, 2) - Math.pow(z, 2) - Math.pow(x, 2));
                guardian.(0, 0).addBox(x, y - 32, z, 1, -2 * y, 1, false);
                //guardian.setTextureOffset(0, 0).addBox(x,  -y, z, 1, y, 1, false);

            }
        }
    }


    @Override
    public void setupAnim(@Nonnull GuardianEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
                                  float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(@Nonnull PoseStack matrixStackIn, @Nonnull VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn,
                               float red, float green, float blue, float alpha) {
        guardian.renderToBuffer(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }

    @Override
    public @NotNull EntityRenderer create(Context p_174010_) {
        return thisRenderer;
    }
    *
     */
}
