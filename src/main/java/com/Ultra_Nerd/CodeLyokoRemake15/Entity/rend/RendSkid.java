package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntitySkid;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

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
