package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntityFan;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.model.ModelFan;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.model.provider.GeoModelProvider;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class RendFan extends GeoLayerRenderer<EntityFan> implements IGeoRenderer<EntityFan> {
    public RendFan(IGeoRenderer<EntityFan> fan) {
        super(fan);

    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, EntityFan entityLivingBaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        matrixStackIn.pushPose();
        //matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90.0F));
        //matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch) + 90.0F));
        //VertexConsumer ivertexbuilder = ItemRenderer.getBuffer(bufferIn, this.FanModel.(this.getEntityTexture(entityIn)), false, entityIn.func_226572_w_());
        //this.FanModel.(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.popPose();
    }



    private final ModelFan FanModel = new ModelFan();


    @Override
    public GeoModelProvider<EntityFan> getGeoModelProvider() {
        return null;
    }

    /**
     * Returns the location of an entity's texture.
     */
    @Override
    @Nonnull
    public ResourceLocation getTextureLocation(@Nonnull EntityFan entity) {
        return CodeLyokoMain.CodeLyokoPrefix("textures/entity/projectiles/fan/fan.png");
    }
}
