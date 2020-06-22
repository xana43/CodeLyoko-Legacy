package com.Ultra_Nerd.CodeLyokoRemake.commands;

import java.util.ArrayList;

import com.Ultra_Nerd.CodeLyokoRemake.Util.ref;
import com.google.common.collect.Lists;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class ComTel extends CommandBase {

	
	private final ArrayList<String> coms = Lists.newArrayList(ref.MOD_ID, "tp", "tpdim","tpdimension","teleporteddimension", "teleport");
	@Override
	public void execute(MinecraftServer arg0, ICommandSender arg1, String[] arg2) throws CommandException {
		if(arg2.length < 1) return;
		
		String s = arg2[0];
		int dimensionID;
		
		try
		{
			dimensionID = Integer.parseInt(s);
		}catch(NumberFormatException e)
		{
			arg1.sendMessage(new TextComponentString(TextFormatting.RED + "Dimension ID not found"));
			return;
		}
		
		if(arg1 instanceof EntityPlayer)
		{
			tele.teleportToDim((EntityPlayer)arg1, dimensionID, arg1.getPosition().getX(),  arg1.getPosition().getY() + 5, arg1.getPosition().getZ());
		}
		
		
	}

	@Override
	public String getName() {
		
		return "ForceVirtualize";
	}

	@Override
	public String getUsage(ICommandSender arg0) {
		
		return "Virtualize <id>";
	}
	
	@Override
	public java.util.List<String> getAliases() {
		// TODO Auto-generated method stub
		return coms;
	}
	
	@Override
	public boolean checkPermission(MinecraftServer p_checkPermission_1_, ICommandSender p_checkPermission_2_) {
		// TODO Auto-generated method stub
		return true;
	}

}
