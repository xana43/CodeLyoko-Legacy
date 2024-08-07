package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public final class CentralControlUnitTileEntity extends BlockEntity {

    public CentralControlUnitTileEntity(@NotNull BlockEntityType<?> tileEntityTypeIn, @NotNull BlockPos pos, @NotNull BlockState state) {
        super(tileEntityTypeIn, pos, state);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return this.createNbt(registryLookup);
    }



    @Override
    public @NotNull Packet<ClientPlayPacketListener> toUpdatePacket() {
        return  BlockEntityUpdateS2CPacket.create(this);
    }
    /*public CentralControlUnitTileEntity() {
        this(ModBlockEntities.CENTRAL_CONTROL_UNIT_TILE_ENTITY.get());
    }*/


}
