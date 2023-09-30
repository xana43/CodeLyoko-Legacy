package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.test;

import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.TestHandler.VehicleMaterializeTestHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerFactory;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class VehicleBE extends BlockEntity implements ScreenHandlerFactory {
    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return this.createNbt();
    }

    @Override
    public @NotNull Packet<ClientPlayPacketListener> toUpdatePacket() {
        return  BlockEntityUpdateS2CPacket.create(this);
    }

    public VehicleBE(final BlockPos pos, final BlockState state) {
        super(ModBlockEntities.VEHICLE_BE_BLOCK_ENTITY_TYPE, pos, state);
    }



    @Nullable
    @Override
    public ScreenHandler createMenu(final int syncId, final PlayerInventory inv, final PlayerEntity player) {
        return new VehicleMaterializeTestHandler(syncId);
    }
}
