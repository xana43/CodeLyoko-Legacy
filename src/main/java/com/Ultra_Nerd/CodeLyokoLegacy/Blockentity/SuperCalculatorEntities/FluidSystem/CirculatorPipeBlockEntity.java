package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities.FluidSystem;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.common.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.SyncedBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.TickingBlockEntity;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.storage.base.FilteringStorage;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluids;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.Objects;

import static com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil.FluidStorageCreation.createFluidStorage;

public final class CirculatorPipeBlockEntity extends SyncedBlockEntity implements TickingBlockEntity {

    private final SingleVariantStorage<FluidVariant> fluidStorage = createFluidStorage(this,Fluids.WATER);
    private final Storage<FluidVariant> input = FilteringStorage.insertOnlyOf(fluidStorage);
    private final Storage<FluidVariant> output = FilteringStorage.extractOnlyOf(fluidStorage);
    public CirculatorPipeBlockEntity(final BlockPos pos, final BlockState state) {
        super(ModBlockEntities.CIRCULATOR_PIPE_BLOCK_ENTITY_TYPE, pos, state);
    }
    public Storage<FluidVariant> getInput()
    {
        return input;
    }

    public Storage<FluidVariant> getOutput() {
        return output;
    }





    @Override
    protected void writeNbt(final NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.put("fluid_type",fluidStorage.variant.toNbt());
        nbt.putLong("amount",fluidStorage.amount);
    }

    @Override
    public void readNbt(final NbtCompound nbt) {
        super.readNbt(nbt);
        fluidStorage.variant = FluidVariant.fromNbt(nbt.getCompound("fluid_type"));
        fluidStorage.amount = nbt.getLong("amount");
    }

    @Override
    public void tick() {
            for(final Direction dir : Direction.values())
            {
                if(!Objects.requireNonNull(world).isClient) {
                    if (world.getBlockEntity(
                            pos.offset(dir)) instanceof final CirculatorPipeBlockEntity pipeBlockEntity) {
                        try (final Transaction transaction = Transaction.openOuter()) {
                            final long extract = fluidStorage.extract(fluidStorage.variant,
                                    FluidConstants.BLOCK, transaction);
                            pipeBlockEntity.input.insert(fluidStorage.variant,extract,transaction);
                            transaction.commit();
                        }
                    }
                }
            }
    }
}
