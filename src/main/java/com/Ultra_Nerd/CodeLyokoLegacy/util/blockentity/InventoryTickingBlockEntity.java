package com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public abstract class InventoryTickingBlockEntity extends SyncedBlockEntity implements LyokoInventoryBlock,TickingBlockEntity {

    protected DefaultedList<ItemStack> itemStacks;

    public InventoryTickingBlockEntity(final BlockEntityType<?> type, final BlockPos pos, final BlockState state,
            final int inventorySize) {
        super(type, pos, state);
        itemStacks = DefaultedList.ofSize(inventorySize, ItemStack.EMPTY);
    }

    public void setItem(final ItemStack newStack, final int Index) {
        itemStacks.set(Index, newStack);
    }



    @Override
    public void readNbt(final NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, itemStacks);
    }

    @Override
    protected void writeNbt(final NbtCompound nbt) {
        Inventories.writeNbt(nbt, itemStacks);
        super.writeNbt(nbt);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return itemStacks;
    }


}
