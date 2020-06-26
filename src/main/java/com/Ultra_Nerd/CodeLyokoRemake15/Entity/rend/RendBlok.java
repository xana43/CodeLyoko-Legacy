package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntityBlok;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.model.ModelBlok;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RendBlok extends MobRenderer<EntityBlok, ModelBlok<EntityBlok>>
{

	protected static final ResourceLocation tex = new ResourceLocation(Base.MOD_ID,"textures/entity/blok.png");
	
	public RendBlok(EntityRendererManager rendManIn)
	{
		super(rendManIn,new ModelBlok<EntityBlok>() ,1f);
	}
	
	
    @Override
    public ResourceLocation getEntityTexture(EntityBlok entity) {
		return tex;
	}
    
}