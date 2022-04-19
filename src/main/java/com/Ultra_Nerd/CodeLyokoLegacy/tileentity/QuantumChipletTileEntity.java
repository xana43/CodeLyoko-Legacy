package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Clearable;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public final class QuantumChipletTileEntity extends InventoryBE implements MenuProvider, Clearable {

    private NonNullList<ItemStack> items = NonNullList.withSize(1, ItemStack.EMPTY);

    public QuantumChipletTileEntity(@NotNull BlockEntityType<?> TileEntityIn, @NotNull BlockPos pos, @NotNull BlockState state, int size) {
        super(TileEntityIn,pos,state,1);
    }
/*
    public QuantumChipletTileEntity() {
        this(ModTileEntities.QUANTUM_CHIPLET_TILE_ENTITY.get());
    }*/

    @Override
    public void load(@Nonnull CompoundTag compound) {
        super.load(compound);
        this.items = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(compound, this.items);
    }


    @Override
    public void saveAdditional(@Nonnull CompoundTag compound) {
        super.saveAdditional(compound);
        ContainerHelper.saveAllItems(compound, this.items);

    }

    public NonNullList<ItemStack> getItems() {
        return this.items;
    }

    public void setItems(NonNullList<ItemStack> items) {
        this.items = items;
    }

    @Override
    public void setChanged() {
        super.setChanged();
        this.level.sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 2);
    }



    @Nonnull
    @Override
    public Component getDisplayName() {
        return new TranslatableComponent("container." + CodeLyokoMain.MOD_ID + ".quantum_chiplet");
    }





    @Override
    public AbstractContainerMenu createMenu(int id, @Nonnull Inventory playerInventory, Player player) {
        return null;//new QuantumChipletContainer(id, player, this);
    }



    public int getSizeInventory() {
        return this.items.size();
    }




    @Override
    public boolean isRemoved() {
        for (ItemStack itemstack : this.items) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }
        return true;
    }


    @Nonnull
    @Override
    public ItemStack getItemInSlot(int index) {
        return this.items.get(index);
    }

   /*

    @Nonnull
    @Override
    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(this.items, index, count);
    }



    @Nonnull
    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.items, index);
    }*/


    @Override
    public ItemStack insertItem(int slot, @NotNull ItemStack stack) {
        ItemStack Istack = this.items.get(slot);
        boolean flag = !stack.isEmpty() && stack.equals(Istack) && ItemStack.isSame(stack, Istack);
        this.items.set(slot, stack);
        if (stack.getCount() > this.getSizeInventory()) {
            stack.setCount(this.getSizeInventory());
        }
        if (!flag) {
            this.setChanged();
        }
        return super.insertItem(slot, stack);
    }

    /*

    @Override
    public boolean isUsableByPlayer(@Nonnull PlayerEntity player) {
        assert this.world != null;
        if (this.world.getTileEntity(pos) != this) {
            return false;
        } else {
            return player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64D;
        }
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return !stack.isDamaged();
    }


*/


    @Override
    public void setRemoved() {
        super.setRemoved();
        this.items.clear();
    }



    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        CompoundTag nbt = new CompoundTag();
        this.saveAdditional(nbt);

        return super.getUpdatePacket();

    }



    @Override
    public void onDataPacket(Connection net, @NotNull ClientboundBlockEntityDataPacket pkt) {
        this.load(pkt.getTag());
    }

    @Nonnull
    @Override
    public CompoundTag getUpdateTag() {
        this.saveAdditional(new CompoundTag());
        return super.getUpdateTag();
    }

    @Override
    public void handleUpdateTag(@NotNull CompoundTag tag) {
        super.handleUpdateTag(tag);
        this.load(tag);
    }



    @Override
    public void clearContent() {

    }



}
