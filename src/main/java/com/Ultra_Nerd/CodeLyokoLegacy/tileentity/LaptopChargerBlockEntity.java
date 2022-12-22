package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.items.LaptopClass;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.EnergyStorageBlockEntity;
import net.fabricmc.fabric.api.transfer.v1.context.ContainerItemContext;
import net.fabricmc.fabric.api.transfer.v1.storage.StorageUtil;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleSlotStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.TransactionContext;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.EnergyStorage;
import team.reborn.energy.api.EnergyStorageUtil;

public final class LaptopChargerBlockEntity extends EnergyStorageBlockEntity {
    public LaptopChargerBlockEntity(final BlockPos pos, final BlockState state) {
        super(ModTileEntities.LAPTOP_CHARGER_BLOCK_ENTITY_BLOCK_ENTITY, pos, state, 1, 90, 10L, 10L);
    }

    public void setItem(final ItemStack item) {
        setItem(item.copy(), 0);
        item.decrement(1);
        update();

    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }

    @Override
    public void tick() {
        if (world.isClient()) {
            return;
        }
        world.updateListeners(pos,getCachedState(),getCachedState(), Block.NOTIFY_LISTENERS);
        if (getItems().get(0).isOf(ModItems.JEREMY_LAPTOP)) {
            final LaptopClass jeremyLaptop = (LaptopClass) getStack(0).getItem();
            final long laptopStoredEnergy = jeremyLaptop.getStoredEnergy(getStack(0));
            final long laptopMaxEnergyCapacity = jeremyLaptop.getEnergyCapacity(getStack(0));
            final long laptopEnergyMaxInput = jeremyLaptop.getEnergyMaxInput(getStack(0));
            if (laptopStoredEnergy < laptopMaxEnergyCapacity && energyStorage.amount > 0) {
                jeremyLaptop.setStoredEnergy(getStack(0), laptopStoredEnergy + laptopEnergyMaxInput);
                update();
            }
            energyStorage.amount -= laptopEnergyMaxInput;
        }

    }
}
