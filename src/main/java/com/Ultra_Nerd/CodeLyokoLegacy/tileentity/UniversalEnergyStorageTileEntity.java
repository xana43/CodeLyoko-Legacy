package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import team.reborn.energy.api.base.SimpleEnergyStorage;


public final class UniversalEnergyStorageTileEntity extends BlockEntity {

    public final SimpleEnergyStorage simpleEnergyStorage = new SimpleEnergyStorage(900,10,10){


        @Override
        protected void onFinalCommit() {
            markDirty();
        }
    };


private static final String energykey = "lyoko_universal_energy_storeage";

    public UniversalEnergyStorageTileEntity(final BlockPos pos, final BlockState state) {
        super(ModTileEntities.UNIVERSAL_ENERGY_STORAGE, pos, state);
    }

    @Override
    protected void writeNbt(final NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putLong(energykey,simpleEnergyStorage.amount);
    }

    @Override
    public void readNbt(final NbtCompound nbt) {
        super.readNbt(nbt);
        simpleEnergyStorage.amount = nbt.getLong(energykey);
    }
    /*
    public UniversalEnergyStorageTileEntity(BlockEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    private final CapabilityEnergy energy = new CapabilityEnergy();

    private final EG store = new EG(90000);
    public int UNIRF = store.getEnergyStored();
    private String name;


    @Override
    public void updateContainingBlockInfo() {
        if (world.isBlockPowered(this.pos)) {
            //System.out.println(Integer.toString(UNIRF));
            UNIRF += 100;
        }
    }


    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityEnergy.ENERGY) return LazyOptional.of(() -> (T) this.energy);
        return super.getCapability(cap, side);

    }


    @Nonnull
    @Override
    public CompoundNBT write(@Nonnull CompoundNBT compound) {
        // TODO Auto-generated method stub
        super.write(compound);
        compound.putInt("Chat", this.UNIRF);
        compound.putString("name", this.getName());
        this.store.WRTNBT(compound);
        return compound;
    }

    @Override
    public void read(@Nonnull CompoundNBT compound) {
        // TODO Auto-generated method stub
        super.read(compound);
        this.UNIRF = compound.getInt("Chat");
        this.name = compound.getString("name");

    }

    public String getName() {
        return "container.universal";
    }

    //@Override
//	public ITextComponent getDisplayName() {
//		// TODO Auto-generated method stub
    //	return new TextComponentTranslation("container.universal");
    //}
    public int getStore() {
        return UNIRF;
    }

    public int getStoreMax() {
        return this.store.getMaxEnergyStored();
    }

    public int getall(int id) {
        switch (id) {
            case 0:
                return this.UNIRF;
            default:
                return 0;
        }
    }

    public void setall(int cal) {
        switch (cal) {
            case 0:
                this.UNIRF = cal;

        }
    }

    public boolean useable(PlayerEntity player) {
        assert this.world != null;
        return this.world.getTileEntity(pos) == this && player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) >= 64D;
    }
*/

}
