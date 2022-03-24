package com.Ultra_Nerd.CodeLyokoRemake15.Util.handlers;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.google.gson.Gson;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(bus= Bus.MOD, modid = CodeLyokoMain.MOD_ID)
public class ModConfiguration {

    protected static final Gson gson = new Gson();

    public static class Common {

        //private final String data = gson.toJson(CableTileEntity.CONNECTIONS);

        public Common(ForgeConfigSpec.Builder builder) {
            builder.comment("Code Lyoko : Legacy \n Mod configuration")
                    .push("CL:L");
            /*builder.comment(data)
                    .translation("cm.cable_network")
                    .worldRestart();*/
            builder.pop();
        }
    }

    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;
    static {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }

    @SubscribeEvent
    public static void onLoad(final ModConfigEvent.Loading event) {
        //gson.fromJson();
    }

    @SubscribeEvent
    public static void onFileChange(final ModConfigEvent.Reloading event) {

    }
}


/*
	public static Configuration conf;
	public static int SKID = 5678546;
	public static int Dim = DimensionManager.getNextFreeDimId();
    public static int Dim2 = DimensionManager.getNextFreeDimId();
    public static int Dim3 = DimensionManager.getNextFreeDimId();
    public static int Dim4 = DimensionManager.getNextFreeDimId();
    public static int Dim5 = DimensionManager.getNextFreeDimId();
    public static int Dim6 = DimensionManager.getNextFreeDimId();
	public static int INFUSING = 2;
	public static int URANIUM = 190;
	public static int ENTITY_BLOK = 5102;
	public static int INTERFACE = 3245;
	public static int ELEINFUSING = 124879;
	public static int ENTITY_LARROW = 3406743;
	public static boolean spawnLyokoOverWorld = false;

	public static void fil(File file)
	{
		conf = new Configuration(file);
		String cat;
		cat = "IDs";
		conf.addCustomCategoryComment(cat, "These are the available mod IDs for GUIs, Entities, and Dimensions");
		Dim6 = conf.getInt("Sector 5 ID", cat, Dim6, 0, 1000000000, "this is the dimension ID for secto5");
		Dim = conf.getInt("Forest Sector ID", cat, Dim , 0, 1000000000, "this is the dimension ID for the forest sector");
        Dim2 = conf.getInt("Ice Sector ID", cat, Dim2,0, 1000000000, "this is the dimension ID for the ice sector" );
        Dim3 = conf.getInt("Desert sector ID", cat, Dim3, 0, 1000000000, "this is the dimension ID for the desert sector");
        Dim4 = conf.getInt("Digital Ocean ID", cat, Dim4, 0, 1000000000, "this is the dimension ID for the digital ocean");
        Dim5 = conf.getInt("Mountain Sector ID", cat, Dim5, 0, 1000000000, "this is the dimension ID for the mountain sector");
		INFUSING = conf.getInt("this is the GUI ID for the Flouride Infuser", cat, 2, 0, 1000000000, "Make sure this isn't conflicting with another mod");
		URANIUM = conf.getInt("this is the ID for the Uranium Integrated reactor", cat, 190, 0, 1000000000, "Make sure this isn't conflicting with another mod");
		ENTITY_BLOK = conf.getInt("this is the ID for the BLOK mob", cat, 5102, 0, 1000000000, "Make sure this isn't conflicting with another mod");
		INTERFACE = conf.getInt("this is the ID for the Tower Interface", cat, 3245, 0, 1000000000, "Make sure this isn't conflicting with another mod");
		ENTITY_LARROW = conf.getInt("this is the ID for the laser arrow", cat, 3406743, 0, 1000000000, "Make sure this isn't conflicting with another mod");
		cat = "Biome";
		conf.addCustomCategoryComment(cat, "this allows for control over biome spawning");
		spawnLyokoOverWorld = conf.getBoolean("Spawnall the sectors in the overworld", cat, false, "this allows you to spawn the forest sector in the overworld");
		conf.save();
	}

	public static void RegisCon(FMLPreInitializationEvent event)
	{
		CodeLyokoMain.conf = new File(event.getModConfigurationDirectory() + "/" + ref.MOD_ID);
		CodeLyokoMain.conf.mkdirs();
		fil(new File(CodeLyokoMain.conf.getPath(), ref.MOD_ID + ".cfg"));
	}

 */
