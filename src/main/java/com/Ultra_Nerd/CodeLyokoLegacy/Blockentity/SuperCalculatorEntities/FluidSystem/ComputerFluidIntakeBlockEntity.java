package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities.FluidSystem;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.SyncedBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.TickingBlockEntity;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.storage.base.FilteringStorage;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public final class ComputerFluidIntakeBlockEntity extends SyncedBlockEntity implements TickingBlockEntity{

    private final SingleVariantStorage<FluidVariant> internalTank =
            MethodUtil.FluidStorageCreation.createFluidStorage(this, Fluids.WATER);
    public final Storage<FluidVariant> output = FilteringStorage.extractOnlyOf(internalTank);
    public final Storage<FluidVariant> input = FilteringStorage.insertOnlyOf(internalTank);
    public ComputerFluidIntakeBlockEntity(final BlockPos pos, final BlockState state) {
        super(ModBlockEntities.COMPUTER_FLUID_INTAKE_BLOCK_ENTITY, pos, state);
    }
    public long getStoredFluid()
    {
        return internalTank.amount;
    }
    public Fluid getStoredFluidVariant()
    {
        return internalTank.variant.getFluid();
    }



    @Override
    public void tick() {
            if(world.getFluidState(pos.offset(Direction.DOWN)).getBlockState().getBlock() == Fluids.WATER.getDefaultState().getBlockState().getBlock() && !world.isClient)
            {

                try(final Transaction transaction = Transaction.openOuter()) {

                    final long insertedAmount = input.insert(FluidVariant.of(Fluids.WATER),
                            FluidConstants.BLOCK,transaction);
                    if(insertedAmount == FluidConstants.BLOCK)
                    {
                        world.setBlockState(pos.offset(Direction.DOWN), Blocks.AIR.getDefaultState());
                        transaction.commit();
                    }
                }
            }
    }

    @Override
    protected void writeNbt(final NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.put("fluid_type",internalTank.variant.toNbt());
        nbt.putLong("amount",internalTank.amount);
    }

    @Override
    public void readNbt(final NbtCompound nbt) {
        super.readNbt(nbt);
        internalTank.variant = FluidVariant.fromNbt(nbt.getCompound("fluid_type"));
        internalTank.amount = nbt.getLong("amount");
    }
}
