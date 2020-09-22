package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntityLaser;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.model.ModelLaserArrow;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class RendLaser<T extends EntityLaser> extends ArrowRenderer<T> {
    private final ModelLaserArrow<T> laserArrow = new ModelLaserArrow<>();
    public RendLaser(EntityRendererManager rendManIn) {
        super(rendManIn);

    }

    @Override
    public void render(@Nonnull T entityIn, float entityYaw, float partialTicks, @Nonnull MatrixStack matrixStackIn, @Nonnull IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.push();
        laserArrow.setRotationAngles(entityIn,0,0,0,0,0);
        IVertexBuilder vertexBuilder = bufferIn.getBuffer(this.laserArrow.getRenderType(this.getEntityTexture(entityIn)));
        laserArrow.render(matrixStackIn,vertexBuilder,packedLightIn, OverlayTexture.NO_OVERLAY,1,1,1,1);
        matrixStackIn.pop();
    }

    @Nonnull
    @Override
    public ResourceLocation getEntityTexture(@Nonnull EntityLaser entity) {
        // TODO Auto-generated method stub
        return new ResourceLocation(Base.MOD_ID + ":textures/entity/laserarrow.png");
    }


}
