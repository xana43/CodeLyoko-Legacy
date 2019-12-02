package com.Ultra_Nerd.CodeLyokoRemake.Util.compat;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake.init.Modblocks;

import net.minecraftforge.oredict.OreDictionary;

public class Oredict {
	public static void registerOres()
	{
		OreDictionary.registerOre("oreUranium", Modblocks.URANINITE_ORE);
		OreDictionary.registerOre("oreUranium", Modblocks.COFFINITE_ORE);
		OreDictionary.registerOre("dustUranium", ModItems.URANIUM_DIOXIDE);
		OreDictionary.registerOre("oreUranium", ModItems.URANIUM_MELT);
		OreDictionary.registerOre("ingotUranium", ModItems.URANIUM_ISOTOPE235U);
		OreDictionary.registerOre("ingotUranium", ModItems.URANIUM_ISOTOPE238);
		OreDictionary.registerOre("ingotUranium", ModItems.URANIUM_ISOTOPE23S5);
		OreDictionary.registerOre("dustUranium", ModItems.URANIUM_SILACATE);
	}

}
