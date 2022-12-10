package com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public abstract class TickingBlockEntity extends BlockEntity implements LyokoInventoryBlock{

    protected DefaultedList<ItemStack> itemStacks;
    public TickingBlockEntity(final BlockEntityType<?> type, final BlockPos pos, final BlockState state,
            final int inventorySize) {
        super(type, pos, state);
        itemStacks = DefaultedList.ofSize(inventorySize,ItemStack.EMPTY);
    }
    public void setItem(final ItemStack newStack,final int Index)
    {
        itemStacks.set(Index,newStack);
    }
    public void tick(){}
    public void update()
    {
        this.markDirty();
        if(this.world != null)
        {
            this.world.setBlockState(this.pos,getCachedState());
        }
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
