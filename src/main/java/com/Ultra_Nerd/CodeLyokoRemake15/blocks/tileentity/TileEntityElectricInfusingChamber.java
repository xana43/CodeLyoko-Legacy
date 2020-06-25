package com.Ultra_Nerd.CodeLyokoRemake15.blocks.tileentity;

import com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.flouride.ElectricFlourideInfuser;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.flouride.FlourideRes;
import com.Ultra_Nerd.CodeLyokoRemake15.RF.EG;

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

public class TileEntityElectricInfusingChamber extends TileEntity implements ITickable
{
	public ItemStackHandler handler = new ItemStackHandler(3);
	private EG internal = new EG(90000);
	private String customName;
	private ItemStack smelting = ItemStack.EMPTY;
	
	
	private int cookTime;
	public int ENER = internal.getEnergyStored();
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) 
	{
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return true;
		if(capability == CapabilityEnergy.ENERGY) return true;
		else return false;
	}
	
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) 
	{
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return (T) this.handler;
		if(capability == CapabilityEnergy.ENERGY) return (T) this.internal;
		return super.getCapability(capability, facing);
	}
	
	
	@Override
	public ITextComponent getDisplayName() 
	{
		return  new TextComponentTranslation("container.electric_flouride_infuser");
	}
	
	
	public int getENER() {
		return this.ENER;
	}
	
	public int maxenergy()
	{
		return this.internal.getMaxEnergyStored();
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		this.handler.deserializeNBT(compound.getCompoundTag("Inventory"));
		this.cookTime = compound.getInteger("CookTime");
		this.customName = compound.getString("CustomName");
		this.internal.RFNBT(compound);
		this.ENER = compound.getInteger("GuiEnergy");
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) 
	{
		super.writeToNBT(compound);
		
		compound.setInteger("CookTime", (short)this.cookTime);
		
		compound.setTag("Inventory", this.handler.serializeNBT());
		compound.setString("CustomName", getDisplayName().toString());
		compound.setInteger("GuiEnergy", this.ENER);
		return compound;
	}
	
	
	
	public void update() 
	{	
		if(world.isBlockPowered(pos)) ENER += 100;
		ItemStack[] Inputs = new ItemStack [] {handler.getStackInSlot(0),handler.getStackInSlot(1)};
		if(ENER >= 80)
		{
			if(cookTime > 0)
			{
				ENER -= 20;
				cookTime++;
				ElectricFlourideInfuser.SetState(true, world, pos);
				if(cookTime == 200)
				{
					if(handler.getStackInSlot(2).getCount() > 0)
					{
						handler.getStackInSlot(2).grow(1);
					}
					else
					{
						handler.insertItem(2, smelting, false);
					}
					smelting = ItemStack.EMPTY;
					cookTime = 0;
					return;
				}
		   }
			else if(!Inputs[0].isEmpty() && !Inputs[1].isEmpty())
			{
				ItemStack out = FlourideRes.getInstance().getInfusingResult(Inputs[0], Inputs[1]);
				if(!out.isEmpty())
				{
					smelting = out;
					cookTime++;
					Inputs[0].shrink(1);
					Inputs[1].shrink(1);
					handler.setStackInSlot(0, Inputs[0]);
					handler.setStackInSlot(1, Inputs[1]);
					ENER -= 20;
				}
			}
		}
	}
	
	private boolean canSmelt() 
	{
		if(((ItemStack)this.handler.getStackInSlot(0)).isEmpty() || ((ItemStack)this.handler.getStackInSlot(1)).isEmpty()) return false;
		else 
		{
			ItemStack result = FlourideRes.getInstance().getInfusingResult((ItemStack)this.handler.getStackInSlot(0), (ItemStack)this.handler.getStackInSlot(1));	
			if(result.isEmpty()) return false;
			else
			{
				ItemStack output = (ItemStack)this.handler.getStackInSlot(3);
				if(output.isEmpty()) return true;
				if(!output.isItemEqual(result)) return false;
				int res = output.getCount() + result.getCount();
				return res <= 64 && res <= output.getMaxStackSize();
			}
		}
	}
	
	
	
	
	public boolean isUsableByPlayer(EntityPlayer player) 
	{
		return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
	}

	public int getField(int id) 
	{
		switch(id) 
		{
		case 0:
			return this.ENER;
		case 1:
			return this.cookTime;
	default:
			return 0;
		}
	}

	public void setField(int id, int value) 
	{
		switch(id) 
		{
		case 0:
			this.ENER = value;
	
			break;
		case 1:
			this.cookTime = value;
			break;
	
		}
	}
}