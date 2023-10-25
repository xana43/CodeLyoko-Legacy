package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities.FluidSystem;

import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class FluidTankBlockEntity extends BlockEntity {
    private final SingleVariantStorage<FluidVariant> internalStorage =
            MethodUtil.FluidStorageCreation.createFluidStorage(this);
    private final List<FluidTankBlockEntity> fluidTankBlockEntities = new ObjectArrayList<>();
    public FluidTankBlockEntity(final BlockEntityType<?> type, final BlockPos pos, final BlockState state) {
        super(type, pos, state);
    }

    private void appendStorage()
    {

        for(int i = 0; i < world.getHeight(); ++i)
        {
            if(world.getBlockEntity(pos.offset(Direction.UP)) instanceof final FluidTankBlockEntity blockEntity)
            {
                fluidTankBlockEntities.add(blockEntity);
            }
            else {
                break;
            }
        }
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return this.createNbt();
    }

    @Override
    public @NotNull Packet<ClientPlayPacketListener> toUpdatePacket() {
        return  BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    protected void writeNbt(final NbtCompound nbt) {
        super.writeNbt(nbt);
    }

    @Override
    public void readNbt(final NbtCompound nbt) {
        super.readNbt(nbt);
    }
}
