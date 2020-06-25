package io.github.elsopeen.lyokomod.Entity.Renderer;

import io.github.elsopeen.lyokomod.LyokoMod;
import io.github.elsopeen.lyokomod.Entity.Entityblok;
import io.github.elsopeen.lyokomod.Entity.Model.ModelBlok;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RendBlok extends MobRenderer<Entityblok, ModelBlok<Entityblok>> 
{

	protected static final ResourceLocation tex = new ResourceLocation(LyokoMod.MOD_ID,"textures/entity/blok.png");
	
	public RendBlok(EntityRendererManager rendManIn)
	{
		super(rendManIn,new ModelBlok<Entityblok>() ,1f);
	}
	
	
    @Override
    public ResourceLocation getEntityTexture(Entityblok entity) {
		return tex;
	}
    
}
