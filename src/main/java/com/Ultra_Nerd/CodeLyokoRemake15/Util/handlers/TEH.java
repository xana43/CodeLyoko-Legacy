package com.Ultra_Nerd.CodeLyokoRemake15.Util.handlers;


import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.machine.HoloProjector.ProjectorTE;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.machine.UniversalStorage.UniversalStore;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.tileentity.ComputerReactor;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.tileentity.Interface;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.tileentity.TileEntityElectricInfusingChamber;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.tileentity.TileEntityInfusingChamber;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TEH {

		

		public static void regte()
		{
			GameRegistry.registerTileEntity(TileEntityInfusingChamber.class, "flouride_infuser");
			GameRegistry.registerTileEntity(ComputerReactor.class, "reactor");
			GameRegistry.registerTileEntity(Interface.class, "tower_interface");
			GameRegistry.registerTileEntity(TileEntityElectricInfusingChamber.class,"electric_flouride_infuser");
			GameRegistry.registerTileEntity(ProjectorTE.class, "projector");
			GameRegistry.registerTileEntity(UniversalStore.class, "universal_storage");
			//GameRegistry.registerTileEntity(InvisRend.class, "invis");
		}
	
}
