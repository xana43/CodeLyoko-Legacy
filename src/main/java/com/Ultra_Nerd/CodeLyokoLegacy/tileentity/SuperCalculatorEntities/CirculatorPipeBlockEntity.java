package com.Ultra_Nerd.CodeLyokoLegacy.tileentity.SuperCalculatorEntities;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.TickingBlockEntity;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.storage.base.FilteringStorage;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.NotNull;

import static com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil.FluidStorageCreation.createFluidStorage;

public final class CirculatorPipeBlockEntity extends BlockEntity implements TickingBlockEntity {

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
    public NbtCompound toInitialChunkDataNbt() {
        return this.createNbt();
    }
    @Override
    public @NotNull Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
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
                if(!world.isClient) {
                    if (world.getBlockEntity(
                            pos.offset(dir)) instanceof final CirculatorPipeBlockEntity pipeBlockEntity) {
                        try (final Transaction transaction = Transaction.openOuter()) {
                            final long extract = fluidStorage.extract(fluidStorage.variant,
                                    FluidConstants.BLOCK, transaction);
                            pipeBlockEntity.getInput().insert(fluidStorage.variant,extract,transaction);
                            transaction.commit();
                        }
                    }
                }
            }
    }
}
