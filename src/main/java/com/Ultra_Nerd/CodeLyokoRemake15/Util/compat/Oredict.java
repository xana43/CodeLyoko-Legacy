package com.Ultra_Nerd.CodeLyokoRemake15.Util.compat;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake15.init.Modblocks;

import net.minecraftforge.oredict.OreDictionary;

public class Oredict {
	public static void registerOres()
	{
		OreDictionary.registerOre("oreUranium", Modblocks.URANINITE_ORE);
		OreDictionary.registerOre("oreUranium", Modblocks.COFFINITE_ORE);
		OreDictionary.registerOre("dustUranium", ModItems.URANIUM_DIOXIDE);
		OreDictionary.registerOre("oreUranium", ModItems.URANIUM_MELT);
		OreDictionary.registerOre("ingotUranium", ModItems.URANIUM_ISOTOPE235);
		OreDictionary.registerOre("dustUranium", ModItems.URANIUM_SILACATE);
		OreDictionary.registerOre("ingotTitanium", ModItems.TITANIUM);
		OreDictionary.registerOre("oreUranium", Modblocks.CARNOTITE_ORE);
		OreDictionary.registerOre("oreUranium", Modblocks.AUTUNITE_ORE);
		OreDictionary.registerOre("oreUranium", Modblocks.GUMMITE_ORE);
		OreDictionary.registerOre("oreUranium", Modblocks.SALEEITE_ORE);
	}

}
