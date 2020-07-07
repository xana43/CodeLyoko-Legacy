package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntityLaser;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class RendLaser extends ArrowRenderer<EntityLaser> {


	public RendLaser(EntityRendererManager rendManIn)
	{
		super(rendManIn);

	}

	@Override
	public ResourceLocation getEntityTexture(EntityLaser entity) {
		// TODO Auto-generated method stub
		return new ResourceLocation(Base.MOD_ID + ":textures/entity/laserarrow.png");
	}



}
