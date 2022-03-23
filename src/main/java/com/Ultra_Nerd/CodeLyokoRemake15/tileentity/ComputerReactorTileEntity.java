package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

import com.Ultra_Nerd.CodeLyokoRemake15.RF.EG;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityDispatcher;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

public class ComputerReactorTileEntity extends BlockEntity implements Nameable, BlockEntityTicker<ComputerReactorTileEntity> {
    public ComputerReactorTileEntity(BlockEntityType<?> tileEntityTypeIn, BlockPos pos, BlockState state) {
        super(tileEntityTypeIn,pos,state);
    }



	public ItemStackHandler handle = new ItemStackHandler(1);
	private EG store = new EG(1000000000);
	private String Cust;
	public int Fission;
	public int energy = store.getEnergyStored();




    @Override
	public void tick(Level worldIn, BlockPos pos, BlockState state, ComputerReactorTileEntity tileEntity) {
		if(!handle.getStackInSlot(0).isEmpty() && isItemFuel(handle.getStackInSlot(0)));
		{
			if(handle.getStackInSlot(0).getItem() == ModItems.URANIUM_ISOTOPE238.get() || handle.getStackInSlot(0).getItem() == ModItems.URANIUM_ISOTOPE235.get())
			{
				Fission++;
					if(Fission == 40)
					{
			
					
						energy += getFuelValue(handle.getStackInSlot(0));
						handle.getStackInSlot(0).shrink(1);
						Fission = 0;
					}
			}
			else
			{
				Fission = 0;
			}
				
		}
		
	}
	
	private boolean isItemFuel(ItemStack stackInSlot) {
		// TODO Auto-generated method stub
		return getFuelValue(stackInSlot) > 0;
	}

	private int getFuelValue(ItemStack stackInSlot) {
			if(stackInSlot.getItem() == ModItems.URANIUM_ISOTOPE235.get())
			{
			return 20000;
			}
			else if(stackInSlot.getItem() == ModItems.URANIUM_ISOTOPE238.get())
			{
			return 10000;
			}
			else 
			{
			return 0;
			}
		
			
		
	}



    @Override
	public <T> LazyOptional<T> getCapability(@NotNull Capability<T> capability, Direction facing) {
        CapabilityDispatcher disp = getCapabilities();

        if(capability == CapabilityEnergy.ENERGY)
			{

			return disp == null ? LazyOptional.empty() : disp.getCapability(capability, facing);
			}
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			{
			return disp == null ? LazyOptional.empty() : disp.getCapability(capability, facing);
			}
		return super.getCapability(capability, facing);
	}


/*
    @Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {

		if(capability == CapabilityEnergy.ENERGY) 
		{
			return true;
		}
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			{
			return true;
			}
		return super.hasCapability(capability, facing);
	}

  */

    @Override
	public void saveAdditional(CompoundTag compound) {
		// TODO Auto-generated method stub
		super.saveAdditional(compound);
		compound.put("Inventory", this.handle.serializeNBT());
		compound.putInt("Fission", this.Fission);
		compound.putInt("GUIEN", this.energy);
		compound.putString("name", getDisplayName().toString());
		this.store.WRTNBT(compound);

	}
	
	@Override
	public void load(CompoundTag compound) {
		// TODO Auto-generated method stub
		super.load(compound);
		this.handle.deserializeNBT(compound.getCompound("Inventory"));
		this.Fission = compound.getInt("Fission");
		this.energy = compound.getInt("GUIEN");
		this.Cust = compound.getString("name");
		this.store.RFNBT(compound);
		
	}

    @Override
    public Component getName() {
        return getDisplayName();
    }

    @Override
	public Component getDisplayName()
	{
		return new TranslatableComponent("container.Reactor");
	}


	public int getEnergy()
	{
		return this.energy;
	}
	public int Maxen()
	{
		return this.store.getMaxEnergyStored();
	}
	
	public int get(int id)
	{
		switch(id)
		{
		case 0:
		return this.energy;
		case 1:
		return this.Fission;
		default:
			return 0;
		}
	}
	public void set(int id, int val)
	{
		switch(id)
		{
		case 0:
			this.energy = val;
			
		case 1:
			this.Fission = val;
			
			
		}
	}
	public boolean isUsableByPlayer(Player player)
	{
        assert this.level != null;
        return this.level.getBlockEntity(this.getBlockPos()) == this && player.distanceToSqr((double) this.getBlockPos().getX() + 0.5D, (double) this.getBlockPos().getY() + 0.5D, (double) this.getBlockPos().getZ() + 0.5D) <= 64.0D;
	}


}
