package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.blockentity.LyokoInventory;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.blockentity.SyncedBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public final class QuantumChipletTileEntity extends SyncedBlockEntity implements LyokoInventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(1,ItemStack.EMPTY);
    public QuantumChipletTileEntity(final BlockPos pos, final BlockState state) {
        super(ModBlockEntities.QUANTUM_CHIPLET_TILE_ENTITY_BLOCK_ENTITY_TYPE, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public void readNbt(final NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt,inventory);
    }

    @Override
    protected void writeNbt(final NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt,inventory);
    }
}
