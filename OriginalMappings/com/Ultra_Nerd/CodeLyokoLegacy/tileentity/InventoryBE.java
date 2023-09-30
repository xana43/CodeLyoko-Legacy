package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public class InventoryBE extends BlockEntity {
    public InventoryBE(final BlockEntityType<?> type, final BlockPos pos, final BlockState state) {
        super(type, pos, state);
    }
/*
    public final int size;
    protected int timer;
    protected boolean requiresUpdate;

    public final @NotNull ItemStackHandler inventory;
    protected LazyOptional<ItemStackHandler> handler;

    public InventoryBE(@NotNull BlockEntityType<?> type, @NotNull BlockPos pos, @NotNull BlockState state, int size) {
        super(type, pos, state);
        if (size <= 0) {
            size = 1;
        }

        this.size = size;
        this.inventory = createInventory();
        this.handler = LazyOptional.of(() -> this.inventory);
    }

    public ItemStack extractItem(int slot) {
        final int count = getItemInSlot(slot).getCount();
        this.requiresUpdate = true;
        return this.handler.map(inv -> inv.extractItem(slot, count, false)).orElse(ItemStack.EMPTY);
    }

    @Override
    public <T> @NotNull LazyOptional<T> getCapability(@NotNull Capability<T> cap, Direction side) {
        return cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? this.handler.cast()
                : super.getCapability(cap, side);
    }

    public LazyOptional<ItemStackHandler> getHandler() {
        return this.handler;
    }

    public ItemStack getItemInSlot(int slot) {
        return this.handler.map(inv -> inv.getStackInSlot(slot)).orElse(ItemStack.EMPTY);
    }

    @Override
    public @Nullable Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return serializeNBT();
    }

    @Override
    public void handleUpdateTag(@NotNull CompoundTag tag) {
        super.handleUpdateTag(tag);
        load(tag);
    }

    public ItemStack insertItem(int slot, @NotNull ItemStack stack) {
        final ItemStack copy = stack.copy();
        stack.shrink(copy.getCount());
        this.requiresUpdate = true;
        return this.handler.map(inv -> inv.insertItem(slot, copy, false)).orElse(ItemStack.EMPTY);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        this.handler.invalidate();
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.inventory.deserializeNBT(tag.getCompound("Inventory"));
    }

    @Override
    public void onDataPacket(Connection net, @NotNull ClientboundBlockEntityDataPacket pkt) {
        super.onDataPacket(net, pkt);
        handleUpdateTag(pkt.getTag());
    }

    public void tick() {
        this.timer++;
        if (this.requiresUpdate && this.level != null) {
            update();
            this.requiresUpdate = false;
        }
    }

    public void update() {
        requestModelDataUpdate();
        setChanged();
        if (this.level != null) {
            this.level.setBlockAndUpdate(this.worldPosition, getBlockState());
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("Inventory", this.inventory.serializeNBT());
    }

    private @NotNull ItemStackHandler createInventory() {
        return new ItemStackHandler(this.size) {
            @Override
            public @NotNull ItemStack extractItem(int slot, int amount, boolean simulate) {
                InventoryBE.this.update();
                return super.extractItem(slot, amount, simulate);
            }

            @Override
            public @NotNull ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
                InventoryBE.this.update();
                return super.insertItem(slot, stack, simulate);
            }
        };
    }

 */
}
