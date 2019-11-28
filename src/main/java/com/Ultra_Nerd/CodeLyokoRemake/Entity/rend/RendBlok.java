package com.Ultra_Nerd.CodeLyokoRemake.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake.Entity.Entityblok;
import com.Ultra_Nerd.CodeLyokoRemake.Entity.model.ModelBlok;
import com.Ultra_Nerd.CodeLyokoRemake.Util.ref;


import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RendBlok extends RenderLiving<Entityblok> {

	public static final ResourceLocation TEXTURES = new ResourceLocation(ref.MOD_ID + ":textures/entity/blok.png");
	public RendBlok(RenderManager manager) {
		super(manager, new ModelBlok(), 1);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entityblok entity) {
		// TODO Auto-generated method stub
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(Entityblok entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) 
	{
		// TODO Auto-generated method stub
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}

}
