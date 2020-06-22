package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntityLaser;
import com.Ultra_Nerd.CodeLyokoRemake15.Util.ref;

import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RendLaser extends RenderArrow<EntityLaser> {

	public RendLaser(RenderManager renderManagerIn) {
		super(renderManagerIn);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityLaser entity) {
		// TODO Auto-generated method stub
		return new ResourceLocation(ref.MOD_ID + ":textures/entity/projectiles/laserarrow.png");
	}

}
