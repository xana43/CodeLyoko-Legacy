package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;


public class UniversalEnergyStorageTileEntity extends BlockEntity {
    public UniversalEnergyStorageTileEntity(@NotNull BlockEntityType<?> p_155228_, @NotNull BlockPos p_155229_, @NotNull BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
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
