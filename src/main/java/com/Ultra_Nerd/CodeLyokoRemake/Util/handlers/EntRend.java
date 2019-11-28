package com.Ultra_Nerd.CodeLyokoRemake.Util.handlers;


import com.Ultra_Nerd.CodeLyokoRemake.Entity.Entityblok;
import com.Ultra_Nerd.CodeLyokoRemake.Entity.rend.RendBlok;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class EntRend
{

	
	public static void registerEntityRenderers()
	{
		RenderingRegistry.registerEntityRenderingHandler(Entityblok.class, new IRenderFactory<Entityblok>()
				{

					@Override
					public Render<? super Entityblok> createRenderFor(RenderManager manager)
					{
						
						return new RendBlok(manager);
					}
					});
	}
}

