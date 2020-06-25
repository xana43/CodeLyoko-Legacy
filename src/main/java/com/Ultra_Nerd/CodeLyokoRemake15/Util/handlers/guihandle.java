package com.Ultra_Nerd.CodeLyokoRemake15.Util.handlers;

import com.Ultra_Nerd.CodeLyokoRemake15.containers.ContainerInfusing;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.ContainerElectricInfusing;
import com.Ultra_Nerd.CodeLyokoRemake15.screens.ElectricInfusingChamberScreen;
import com.Ultra_Nerd.CodeLyokoRemake15.screens.InfusingChamberScreen;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.ComputerReactorTileEntity;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.InterfaceTileEntity;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.ReactorContainer;
import com.Ultra_Nerd.CodeLyokoRemake15.screens.ReactorGUI;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.ElectricInfusingChamberTileEntity;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.InfusingChamberTileEntity;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.TowerContainer;
import com.Ultra_Nerd.CodeLyokoRemake15.screens.TowerGUI;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class guihandle implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == Conf.INFUSING) return new ContainerInfusing(player.inventory, (InfusingChamberTileEntity)world.getTileEntity(new BlockPos(x, y, z)));
		if(ID == Conf.URANIUM) return new ReactorContainer(player.inventory, (ComputerReactorTileEntity)world.getTileEntity(new BlockPos(x, y, z)));
		if(ID == Conf.INTERFACE) return new TowerContainer(player.inventory, (InterfaceTileEntity)world.getTileEntity(new BlockPos(x, y, z)));
		if(ID == Conf.ELEINFUSING) return new ContainerElectricInfusing(player.inventory, (ElectricInfusingChamberTileEntity)world.getTileEntity(new BlockPos(x, y, z)));
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == Conf.INFUSING) return new InfusingChamberScreen(player.inventory, (InfusingChamberTileEntity)world.getTileEntity(new BlockPos(x, y, z)));
		if(ID == Conf.URANIUM) return new ReactorGUI(player.inventory, (ComputerReactorTileEntity)world.getTileEntity(new BlockPos(x, y, z)));
		if(ID == Conf.INTERFACE) return new TowerGUI((InterfaceTileEntity)world.getTileEntity(new BlockPos(x, y, z)));
		if(ID == Conf.ELEINFUSING) return new ElectricInfusingChamberScreen(player.inventory, (ElectricInfusingChamberTileEntity)world.getTileEntity(new BlockPos(x, y, z)));
		return null;
	}

}
