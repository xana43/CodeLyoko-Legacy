package com.Ultra_Nerd.CodeLyokoRemake.Util.handlers;


import com.Ultra_Nerd.CodeLyokoRemake.Entity.EntitySkid;
import com.Ultra_Nerd.CodeLyokoRemake.Entity.Entityblok;
import com.Ultra_Nerd.CodeLyokoRemake.Entity.rend.RendBlok;
import com.Ultra_Nerd.CodeLyokoRemake.Entity.rend.Rendskid;
import com.Ultra_Nerd.CodeLyokoRemake.Util.ref;
import com.Ultra_Nerd.CodeLyokoRemake.init.Modblocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
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
		RenderingRegistry.registerEntityRenderingHandler(EntitySkid.class, new IRenderFactory<EntitySkid>() {
			
			@Override
			public Render<? super EntitySkid> createRenderFor(RenderManager manager) {
				// TODO Auto-generated method stub
				return new Rendskid(manager);
			}
		});
		
	}
	
	public static void RegisterCustomMeshesAndStates()
	{
		ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(Modblocks.DIGITAL_OCEAN), new ItemMeshDefinition() {
			
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				// TODO Auto-generated method stub
				return new ModelResourceLocation(ref.MOD_ID + ":digital_ocean", "fluid");
			}
		});
		
		ModelLoader.setCustomStateMapper(Modblocks.DIGITAL_OCEAN, new StateMapperBase() {
			
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				// TODO Auto-generated method stub
				return new ModelResourceLocation(ref.MOD_ID + ":digital_ocean", "fluid");
			}
		});
		
		
	}
}

