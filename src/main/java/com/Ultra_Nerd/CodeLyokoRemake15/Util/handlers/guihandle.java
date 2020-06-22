package com.Ultra_Nerd.CodeLyokoRemake15.Util.handlers;

import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.machine.flouride.containerInfusing;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.machine.flouride.containerelectricinfusing;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.machine.flouride.electricgui;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.machine.flouride.gui;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.tileentity.ComputerReactor;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.tileentity.Interface;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.tileentity.ReactorContainer;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.tileentity.ReactorGUI;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.tileentity.TileEntityElectricInfusingChamber;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.tileentity.TileEntityInfusingChamber;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.tileentity.TowerContainer;
import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.tileentity.TowerGUI;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class guihandle implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == Conf.INFUSING) return new containerInfusing(player.inventory, (TileEntityInfusingChamber)world.getTileEntity(new BlockPos(x, y, z)));
		if(ID == Conf.URANIUM) return new ReactorContainer(player.inventory, (ComputerReactor)world.getTileEntity(new BlockPos(x, y, z)));
		if(ID == Conf.INTERFACE) return new TowerContainer(player.inventory, (Interface)world.getTileEntity(new BlockPos(x, y, z)));
		if(ID == Conf.ELEINFUSING) return new containerelectricinfusing(player.inventory, (TileEntityElectricInfusingChamber)world.getTileEntity(new BlockPos(x, y, z)));
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == Conf.INFUSING) return new gui(player.inventory, (TileEntityInfusingChamber)world.getTileEntity(new BlockPos(x, y, z)));
		if(ID == Conf.URANIUM) return new ReactorGUI(player.inventory, (ComputerReactor)world.getTileEntity(new BlockPos(x, y, z)));
		if(ID == Conf.INTERFACE) return new TowerGUI((Interface)world.getTileEntity(new BlockPos(x, y, z)));
		if(ID == Conf.ELEINFUSING) return new electricgui(player.inventory, (TileEntityElectricInfusingChamber)world.getTileEntity(new BlockPos(x, y, z)));
		return null;
	}

}
