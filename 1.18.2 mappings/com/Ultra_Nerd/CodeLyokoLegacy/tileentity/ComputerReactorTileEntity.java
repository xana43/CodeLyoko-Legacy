package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public final class ComputerReactorTileEntity extends InventoryBE  {
	public ComputerReactorTileEntity(final BlockEntityType<?> type, final BlockPos pos, final BlockState state) {
		super(type, pos, state);
	}


/*
	private static final Component thisTitle = new TranslatableComponent("container." + CodeLyokoMain.MOD_ID, ".computer_reactor");
	public final @NotNull EG thisStoreage;
	private int progess,totalProgress = 0,capacity = 4000,maxEnergyTake = 200;
	private LazyOptional<EG> energy;

	public ComputerReactorTileEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
		super(ModTileEntities.REACTOR_BLOCK_ENTITY.get(), pos, state, 1);
		this.thisStoreage = createStorage();
		this.energy = LazyOptional.of(() -> this.thisStoreage);
	}

	@Override
	public <T> @NotNull LazyOptional<T> getCapability(@NotNull Capability<T> cap, Direction side) {
		return cap == CapabilityEnergy.ENERGY ? this.energy.cast() : super.getCapability(cap, side);
	}

	@Override
	public void invalidateCaps() {
		super.invalidateCaps();
		this.energy.invalidate();
	}

	@Override
	protected void saveAdditional(CompoundTag tag) {
		super.saveAdditional(tag);
		tag.putInt("GenerationProgress",this.progess);
		tag.putInt("Energy",this.thisStoreage.getEnergyStored());
	}

	@Override
	public void load(CompoundTag tag) {
		super.load(tag);
		this.progess = tag.getInt("GenerationProgress");
		this.thisStoreage.setThisEnergy(tag.getInt("Energy"));
	}

	public int getEnergyForStack(@NotNull ItemStack stack)
	{
		return ForgeHooks.getBurnTime(stack, RecipeType.SMELTING);
	}

	@Override
	public void tick() {
		if(this.thisStoreage.getEnergyStored() <= this.thisStoreage.getMaxEnergyStored() - 100)
		{
			if(!getItemInSlot(0).isEmpty() && (this.progess <= 0 || this.progess > this.totalProgress))
			{
				this.totalProgress = getEnergyForStack(getItemInSlot(0));
				this.inventory.extractItem(0,1,false);
				this.progess++;
			}
			else if(this.progess > 0)
			{
				this.progess++;
				if(this.progess >= this.totalProgress)
				{
					this.progess = 0;
					this.thisStoreage.setThisEnergy(this.thisStoreage.getEnergyStored() + this.totalProgress);
				}
			}
			else
			{
				this.progess =0;
				this.totalProgress = 0;
			}
		}
		outputEnergy();
		super.tick();
	}
	public void outputEnergy()
	{
		if (this.thisStoreage.getEnergyStored() >= this.maxEnergyTake && this.thisStoreage.canExtract())
		{
			for(int i =0; i < Direction.values().length;i++)
			{
				final BlockEntity be = this.level.getBlockEntity(this.worldPosition.relative(Direction.values()[i]));
				if(be == null)
				{
					continue;
				}
				be.getCapability(CapabilityEnergy.ENERGY,Direction.values()[i].getOpposite()).ifPresent(iEnergyStorage -> {
					if(be != this && iEnergyStorage.getEnergyStored() < iEnergyStorage.getMaxEnergyStored())
					{
						final int senTo = this.thisStoreage.extractEnergy(this.maxEnergyTake,false);
						CodeLyokoMain.Log.info("sending: {}",senTo);
						final int got = iEnergyStorage.receiveEnergy(senTo,false);
						CodeLyokoMain.Log.info("gotten: {}",got);
						this.thisStoreage.setThisEnergy(
								this.thisStoreage.getEnergyStored() + senTo - got);
					}

				});
			}
		}
	}
	private @NotNull EG createStorage()
	{
		return new EG(this,this.capacity,0,this.maxEnergyTake);
	}

 */



}
