package com.Ultra_Nerd.CodeLyokoLegacy.tileentity.SuperCalculatorEntities;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlockEntities;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

import static com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil.FluidStorageCreation.createFluidStorage;

public final class CirculatorPipeBlockEntity extends BlockEntity {

    public final SingleVariantStorage<FluidVariant> fluidStorage = createFluidStorage(this,Fluids.WATER);

    public CirculatorPipeBlockEntity(final BlockPos pos, final BlockState state) {
        super(ModBlockEntities.CIRCULATOR_PIPE_BLOCK_ENTITY_TYPE, pos, state);
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
}
