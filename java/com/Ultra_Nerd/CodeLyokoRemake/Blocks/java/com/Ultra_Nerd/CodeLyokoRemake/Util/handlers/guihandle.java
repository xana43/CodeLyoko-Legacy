package com.Ultra_Nerd.CodeLyokoRemake.Util.handlers;

import com.Ultra_Nerd.CodeLyokoRemake.Blocks.machine.flouride.TileEntityInfusingChamber;
import com.Ultra_Nerd.CodeLyokoRemake.Blocks.machine.flouride.containerInfusing;
import com.Ultra_Nerd.CodeLyokoRemake.Blocks.machine.flouride.gui;
import com.Ultra_Nerd.CodeLyokoRemake.Util.ref;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class guihandle implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == ref.INFUSING) return new containerInfusing(player.inventory, (TileEntityInfusingChamber)world.getTileEntity(new BlockPos(x, y, z)));
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == ref.INFUSING) return new gui(player.inventory, (TileEntityInfusingChamber)world.getTileEntity(new BlockPos(x, y, z)));
		return null;
	}

}
