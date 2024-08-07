package com.Ultra_Nerd.CodeLyokoLegacy.Util.blockentity;

import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public abstract class SyncedBlockEntity extends BlockEntity {
    public SyncedBlockEntity(final BlockEntityType<?> type, final BlockPos pos, final BlockState state) {
        super(type, pos, state);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return this.createNbt(registryLookup);
    }

    @Override
    public @NotNull Packet<ClientPlayPacketListener> toUpdatePacket() {
        return  BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public void markDirty() {
        super.markDirty();
        if(world != null && !world.isClient())
        {
            for (final ServerPlayerEntity serverPlayerEntity : PlayerLookup.tracking(this))
            {
                serverPlayerEntity.networkHandler.sendPacket(this.toUpdatePacket());
            }
            final BlockState state = world.getBlockState(pos);
            world.updateListeners(pos,state,state, Block.NOTIFY_ALL);
        }
    }

    public void update() {
        this.markDirty();
        if (this.world != null) {
            this.world.setBlockState(this.pos, getCachedState());
        }
    }
}
