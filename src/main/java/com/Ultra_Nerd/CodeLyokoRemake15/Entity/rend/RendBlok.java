package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.Entityblok;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.model.ModelBlok;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RendBlok extends MobRenderer<Entityblok, ModelBlok<Entityblok>> 
{

	protected static final ResourceLocation tex = new ResourceLocation(Base.MOD_ID,"textures/entity/blok.png");
	
	public RendBlok(EntityRendererManager rendManIn)
	{
		super(rendManIn,new ModelBlok<Entityblok>() ,1f);
	}
	
	
    @Override
    public ResourceLocation getEntityTexture(Entityblok entity) {
		return tex;
	}
    
}
