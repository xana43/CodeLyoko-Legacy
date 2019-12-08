package com.Ultra_Nerd.CodeLyokoRemake.Blocks.tileentity;

import com.Ultra_Nerd.CodeLyokoRemake.RF.EG;
import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class Interface extends TileEntity implements ITickable
{
	
	public boolean isUsableByPlayer(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
