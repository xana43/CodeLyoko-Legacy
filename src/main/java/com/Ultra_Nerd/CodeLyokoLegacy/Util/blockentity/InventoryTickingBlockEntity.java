package com.Ultra_Nerd.CodeLyokoLegacy.Util.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public abstract class InventoryTickingBlockEntity extends SyncedBlockEntity implements LyokoInventory,TickingBlockEntity {

    protected final DefaultedList<ItemStack> itemStacks;

    public InventoryTickingBlockEntity(final BlockEntityType<?> type, final BlockPos pos, final BlockState state,
            final int inventorySize) {
        super(type, pos, state);
        itemStacks = DefaultedList.ofSize(inventorySize, ItemStack.EMPTY);
    }

    public void setItem(final ItemStack newStack, final int Index) {
        itemStacks.set(Index, newStack);
        markDirty();
    }



    @Override
    public void readNbt(final NbtCompound nbt,final RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt,registryLookup);
        Inventories.readNbt(nbt, itemStacks,registryLookup);
    }

    @Override
    protected void writeNbt(final NbtCompound nbt,final RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.writeNbt(nbt, itemStacks,registryLookup);
        super.writeNbt(nbt,registryLookup);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return itemStacks;
    }


}
