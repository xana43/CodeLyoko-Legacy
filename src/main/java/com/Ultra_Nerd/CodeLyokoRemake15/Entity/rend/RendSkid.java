package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntitySkid;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.model.ModelSkid;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class RendSkid extends EntityRenderer<EntitySkid>{
	private final ModelSkid skid = new ModelSkid();
	private final ResourceLocation skidtex = new ResourceLocation(Base.MOD_ID,"models/entities/skid/95adf18e.png");
	public RendSkid(EntityRendererManager renderManagerIn) {
		super(renderManagerIn);


	}



	@Override
	public void render(@Nonnull EntitySkid entityIn, float entityYaw, float partialTicks, @Nonnull MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		matrixStackIn.push();
		

		matrixStackIn.pop();
	}

	@Nonnull
	@Override
	public ResourceLocation getEntityTexture(@Nonnull EntitySkid entity) {
		return skidtex;
	}





}
