package com.Ultra_Nerd.CodeLyokoRemake.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRes {
	public static void ini()
	{
		GameRegistry.addSmelting(Modblocks.URANINITE_ORE, new ItemStack(ModItems.URANIUM_MELT, 1), .5f);
		GameRegistry.addSmelting(ModItems.URANIUM_DIOXIDE,new ItemStack(ModItems.TRIURANIUM_OCTAOXIDE,1) , 0.9f);
		GameRegistry.addSmelting(ModItems.RAW_SILICADUST,new ItemStack(ModItems.URANIUM_SILACATE), 0.2f);
		
	}
}
