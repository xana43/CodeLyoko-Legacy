package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntitySkid;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.model.ModelSkid;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.model.BakedQuad;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ILightReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.IForgeBakedModel;
import net.minecraftforge.client.model.data.IModelData;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

@OnlyIn(Dist.CLIENT)
public class RendSkid extends EntityRenderer<EntitySkid>  {
	private final ModelSkid skid = new ModelSkid();
	IForgeBakedModel wrapper;
	private final ResourceLocation skidtex = new ResourceLocation(Base.MOD_ID,"models/entities/skid/95adf18e.png");
	public RendSkid(EntityRendererManager renderManagerIn) {
		super(renderManagerIn);
		wrapper = new IForgeBakedModel() {
			@Override
			public IBakedModel getBakedModel() {
				return skid.getBakedModel();
			}

			@Nonnull
			@Override
			public IModelData getModelData(@Nonnull ILightReader world, @Nonnull BlockPos pos, @Nonnull BlockState state, @Nonnull IModelData tileData) {
				return skid.getModelData(world,pos,state,tileData);
			}

			@Nonnull
			@Override
			public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @Nonnull Random rand, @Nonnull IModelData extraData) {
				return skid.getQuads(state, side, rand, extraData);
			}
		};


	}


	@Override
	public void render(@Nonnull EntitySkid entityIn, float entityYaw, float partialTicks, @Nonnull MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {

		matrixStackIn.push();
		matrixStackIn.pop();


		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Nonnull
	@Override
	public ResourceLocation getEntityTexture(@Nonnull EntitySkid entity) {
		return skidtex;
	}



}
