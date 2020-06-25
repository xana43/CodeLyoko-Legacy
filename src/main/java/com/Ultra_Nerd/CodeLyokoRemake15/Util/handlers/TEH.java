package com.Ultra_Nerd.CodeLyokoRemake15.Util.handlers;


import com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.holo_projector.ProjectorTileEntity;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.universal_storage.UniversalStore;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.tileentity.ComputerReactor;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.tileentity.Interface;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.tileentity.TileEntityElectricInfusingChamber;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.tileentity.TileEntityInfusingChamber;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TEH {

		

		public static void regte()
		{
			GameRegistry.registerTileEntity(TileEntityInfusingChamber.class, "flouride_infuser");
			GameRegistry.registerTileEntity(ComputerReactor.class, "reactor");
			GameRegistry.registerTileEntity(Interface.class, "tower_interface");
			GameRegistry.registerTileEntity(TileEntityElectricInfusingChamber.class,"electric_flouride_infuser");
			GameRegistry.registerTileEntity(ProjectorTileEntity.class, "projector");
			GameRegistry.registerTileEntity(UniversalStore.class, "universal_storage");
			//GameRegistry.registerTileEntity(InvisRend.class, "invis");
		}
	
}
