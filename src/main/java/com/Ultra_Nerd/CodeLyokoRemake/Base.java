package com.Ultra_Nerd.CodeLyokoRemake;



import java.io.File;

import com.Ultra_Nerd.CodeLyokoRemake.Util.ref;
import com.Ultra_Nerd.CodeLyokoRemake.Util.cumpat.Oredick;
import com.Ultra_Nerd.CodeLyokoRemake.Util.handlers.Conf;
import com.Ultra_Nerd.CodeLyokoRemake.Util.handlers.Souinds;
import com.Ultra_Nerd.CodeLyokoRemake.Util.handlers.TEH;
import com.Ultra_Nerd.CodeLyokoRemake.Util.handlers.guihandle;
import com.Ultra_Nerd.CodeLyokoRemake.Util.handlers.music;
import com.Ultra_Nerd.CodeLyokoRemake.Util.handlers.registry;
import com.Ultra_Nerd.CodeLyokoRemake.init.ModBiome;
import com.Ultra_Nerd.CodeLyokoRemake.init.ModDimensions;
import com.Ultra_Nerd.CodeLyokoRemake.init.ModEntities;
import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake.init.ModRes;
import com.Ultra_Nerd.CodeLyokoRemake.proxy.Common;
import com.Ultra_Nerd.CodeLyokoRemake.world.ModGen;
import com.Ultra_Nerd.CodeLyokoRemake.world.WorldGenTower;

import net.minecraft.client.audio.SoundHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = ref.MOD_ID, name = ref.NAME, version = ref.VERSION)

public class Base {

	@Instance
	public static Base instance;
	
	@SidedProxy(clientSide = ref.CLIENT_PROXY_CLASS, serverSide = ref.COMMON_PROXY_CLASS)
	public static Common proxy; 
	public static File conf;
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{
		
		GameRegistry.registerWorldGenerator(new ModGen(), 3);
		ModBiome.registerBiomes();
		
		Oredick.registerOres();
		
		GameRegistry.registerWorldGenerator(new WorldGenTower(), 0);
		ModEntities.registerenit();
		Souinds.Regso();
		Conf.RegisCon(event);
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		ModRes.ini();
		
		TEH.regte();
		NetworkRegistry.INSTANCE.registerGuiHandler(Base.instance, new guihandle());
		
	}
	
	@EventHandler
	public static void generia(PlayerTickEvent event)
	{
		music.InDim(event);
	}
	
	
	
	@EventHandler
	public static void Postinit(FMLPostInitializationEvent event)
	{
		ModDimensions.registerDims();
		ModItems.initRecords();
		ModItems.reg();
	}
	@EventHandler
	public static void servertinit(FMLServerStartingEvent event)
	{
		registry.serverRegistries(event);
	}
	

}
