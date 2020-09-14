package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntitySkid;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.model.ModelSkid;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.IForgeBakedModel;
import net.minecraftforge.client.model.IModelLoader;
import net.minecraftforge.client.model.obj.OBJModel;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class RendSkid extends EntityRenderer<EntitySkid> implements IForgeBakedModel, IModelLoader<OBJModel> {
	private final ModelSkid skid = new ModelSkid();
	private final ResourceLocation skidtex = new ResourceLocation(Base.MOD_ID,"models/entities/skid/95adf18e.png");
	public RendSkid(EntityRendererManager renderManagerIn) {
		super(renderManagerIn);


	}



	@Override
	public void render(@Nonnull EntitySkid entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		matrixStackIn.push();
		matrixStackIn.pop();
	}

	@Nonnull
	@Override
	public ResourceLocation getEntityTexture(@Nonnull EntitySkid entity) {
		return skidtex;
	}


	@Override
	public void onResourceManagerReload(@Nonnull IResourceManager resourceManager) {

	}

	@Nonnull
	@Override
	public OBJModel read(@Nonnull JsonDeserializationContext deserializationContext, @Nonnull JsonObject modelContents) {
		return this.skid.loader.read(deserializationContext,modelContents);
	}
}
