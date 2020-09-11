package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntitySkid;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
@OnlyIn(Dist.CLIENT)
public class RendSkid extends EntityRenderer<EntitySkid> {


	public RendSkid(EntityRendererManager renderManagerIn) {
		super(renderManagerIn);
	}

	@Nonnull
	@Override
	public ResourceLocation getEntityTexture(@Nonnull EntitySkid entity) {
		return null;
	}
}
