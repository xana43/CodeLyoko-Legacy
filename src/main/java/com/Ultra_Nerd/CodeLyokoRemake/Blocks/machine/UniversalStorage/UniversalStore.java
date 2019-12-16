package com.Ultra_Nerd.CodeLyokoRemake.Blocks.machine.UniversalStorage;

import com.Ultra_Nerd.CodeLyokoRemake.RF.EG;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;

public class UniversalStore extends TileEntity implements ITickable {

	
	private EG store = new EG(9000000);
	public  int UNIRF = store.getEnergyStored();
	private String name;
	@Override
	public void update() {
		if(world.isBlockPowered(pos)) UNIRF += 100;
		
	}
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if(capability == CapabilityEnergy.ENERGY) return true;// TODO Auto-generated method stub
		return super.hasCapability(capability, facing);
	}
	
	
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if(capability == CapabilityEnergy.ENERGY) return (T)this.store;
		return super.getCapability(capability, facing);
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		super.writeToNBT(compound);
		compound.setInteger("Chat", this.UNIRF);
		compound.setString("name", this.getDisplayName().toString());
		this.store.WRTNBT(compound);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		super.readFromNBT(compound);
		this.UNIRF = compound.getInteger("Chat");
		this.name = compound.getString("name");
		
	}
	
	
	@Override
	public ITextComponent getDisplayName() {
		// TODO Auto-generated method stub
		return new TextComponentTranslation("container.universal");
	}
	public int getStore() {
		return UNIRF;
	}
	
	public int getStoreMax() {
		return this.store.getMaxEnergyStored();
	}
	
	public int getall(int id)
	{
		switch(id)
		{
		case 0:
			return this.UNIRF;
		default:
				return 0;
		}
	}
	
	public void setall(int cal)
	{
		switch(cal)
		{
		case 0:
			this.UNIRF = cal;
		
		}
	}
	
	public boolean useable(EntityPlayer player)
	{
		return this.world.getTileEntity(pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) >= 64D;
	}
}
