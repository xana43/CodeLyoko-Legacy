package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.blockentity.LyokoInventory;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.blockentity.SyncedBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
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
    public void readNbt(final NbtCompound nbt,final  RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt,registryLookup);
        Inventories.readNbt(nbt,inventory,registryLookup);
    }

    @Override
    protected void writeNbt(final NbtCompound nbt,final  RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt,registryLookup);
        Inventories.writeNbt(nbt,inventory,registryLookup);
    }
}
