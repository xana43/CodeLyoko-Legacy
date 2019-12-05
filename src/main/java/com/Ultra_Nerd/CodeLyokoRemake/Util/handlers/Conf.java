package com.Ultra_Nerd.CodeLyokoRemake.Util.handlers;

import java.io.File;

import com.Ultra_Nerd.CodeLyokoRemake.Base;
import com.Ultra_Nerd.CodeLyokoRemake.Util.ref;

import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Conf {
	public static Configuration conf;

	public static int Dim = DimensionManager.getNextFreeDimId();
    public static int Dim2 = DimensionManager.getNextFreeDimId();
    public static int Dim3 = DimensionMangager.getNextFreeDimId();
	public static int INFUSING = 2;
	public static int URANIUM = 190;
	public static int ENTITY_BLOK = 5102;
	public static int INTERFACE = 3245;
	public static boolean spawnLyokoOverWorld = false;
	
	public static void fil(File file)
	{
		conf = new Configuration(file);
		String cat;
		cat = "IDs";
		conf.addCustomCategoryComment(cat, "These are the available mod IDs for GUIs, Entities, and Dimensions");
		Dim = conf.getInt("Forest Sector ID", cat, Dim , 3, 1000000000, "this is the dimension ID for the forest sector");
        Dim2 = conf.getInt("Ice Sector ID", cat, Dim2,4, 1000000000, "this is the dimension ID for the ice sector" );
        Dim3 = conf.getInt("Desert sector ID", cat, Dim3, 5, 1000000000, "this is the dimension ID for the desert sector")
		INFUSING = conf.getInt("this is the GUI ID for the Flouride Infuser", cat, 2, 0, 1000000000, "Make sure this isn't conflicting with another mod");
		URANIUM = conf.getInt("this is the ID for the Uranium Integrated reactor", cat, 190, 0, 1000000000, "Make sure this isn't conflicting with another mod");
		ENTITY_BLOK = conf.getInt("this is the ID for the BLOK mob", cat, 5102, 0, 1000000000, "Make sure this isn't conflicting with another mod");
		INTERFACE = conf.getInt("this is the ID for the Tower Interface", cat, 3245, 0, 1000000000, "Make sure this isn't conflicting with another mod");
		cat = "Biome";
		conf.addCustomCategoryComment(cat, "this allows for control over biome spawning");
		spawnLyokoOverWorld = conf.getBoolean("SpawnForestSectorInOverWorld", cat, false, "this allows you to spawn the forest sector in the overworld");
		conf.save();
	}
	
	public static void RegisCon(FMLPreInitializationEvent event)
	{
		Base.conf = new File(event.getModConfigurationDirectory() + "/" + ref.MOD_ID);
		Base.conf.mkdirs();
		fil(new File(Base.conf.getPath(), ref.MOD_ID + ".cfg"));
	}
}
