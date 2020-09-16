package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.HoverboardEntity;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.model.ModelHoverboard;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class HoverboardRenderer<T extends HoverboardEntity> extends EntityRenderer<T> {
    ResourceLocation boardtexture = new ResourceLocation(Base.MOD_ID,"textures/entity/hoverboard/hoverboard.png");
    protected final EntityModel<T> BoardModel = new ModelHoverboard<>();
    public HoverboardRenderer(EntityRendererManager renderManager) {
        super(renderManager);
        this.shadowSize = 1f;

    }

    @Override
    public void render(@Nonnull T entityIn, float entityYaw, float partialTicks, @Nonnull MatrixStack matrixStackIn, @Nonnull IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.push();
        matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
        matrixStackIn.translate(0,-1.5f,0);
        this.BoardModel.setRotationAngles(entityIn,0,0,0,0,0);
        IVertexBuilder vertexBuilder = bufferIn.getBuffer(this.BoardModel.getRenderType(this.getEntityTexture(entityIn)));
        this.BoardModel.render(matrixStackIn,vertexBuilder,packedLightIn, OverlayTexture.getPackedUV(64,64),1,1,1,1);
        matrixStackIn.pop();
    }

    @Nonnull
    @Override
    public ResourceLocation getEntityTexture(@Nonnull HoverboardEntity entity) {
        return boardtexture;
    }


}
