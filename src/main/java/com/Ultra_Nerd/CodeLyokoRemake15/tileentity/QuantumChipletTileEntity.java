package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.QuantumChipletContainer;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IClearable;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.LockableTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.util.Constants;

public class QuantumChipletTileEntity extends LockableTileEntity implements INamedContainerProvider, IClearable {

   protected NonNullList<ItemStack> items = NonNullList.withSize(1,ItemStack.EMPTY);

    public QuantumChipletTileEntity(TileEntityType<?> TileEntityIn)
   {
       super (TileEntityIn);
   }
   public QuantumChipletTileEntity()
   {
       this(ModTileEntities.QUANTUM_CHIPLET_TILE_ENTITY.get());
   }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        this.items = NonNullList.withSize(this.getSizeInventory(),ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound,this.items);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        ItemStackHelper.saveAllItems(compound,this.items);
        return compound;
    }

    public NonNullList<ItemStack> getItems() {
        return this.items;
    }

    public void setItems(NonNullList<ItemStack> items) {
        this.items = items;
    }

    @Override
    public void markDirty() {
        super.markDirty();
        this.world.notifyBlockUpdate(this.getPos(),this.getBlockState(),this.getBlockState(), Constants.BlockFlags.BLOCK_UPDATE);
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container." + Base.MOD_ID + ".quantum_chiplet");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new QuantumChipletContainer(id,player,this);
    }

    @Override
    public int getSizeInventory() {
        return this.items.size();
    }

    @Override
    public boolean isEmpty() {
        for(ItemStack itemstack : this.items)
        {
            if(!itemstack.isEmpty())
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return this.items.get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(this.items,index,count);
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.items,index);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        ItemStack Istack = this.items.get(index);
        boolean flag = !stack.isEmpty() && stack.isItemEqual(Istack) && ItemStack.areItemStackTagsEqual(stack,Istack);
        this.items.set(index,stack);
        if(stack.getCount() > this.getInventoryStackLimit())
        {
            stack.setCount(this.getInventoryStackLimit());
        }
        if(!flag)
        {
            this.markDirty();
        }
    }

    @Override
    public boolean isUsableByPlayer(PlayerEntity player) {
        assert this.world != null;
        if(this.world.getTileEntity(pos) != this)
        {
            return false;
        }
        else{
            return player.getDistanceSq((double)this.pos.getX() + 0.5D,(double)this.pos.getY() + 0.5D,(double)this.pos.getZ() + 0.5D) <= 64D;
        }
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return !stack.isDamaged() ;
    }

    @Override
    public void clear() {
        this.items.clear();
    }


    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        CompoundNBT nbt = new CompoundNBT();
        this.write(nbt);

        return new SUpdateTileEntityPacket(this.pos,1,nbt);

    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        this.read(pkt.getNbtCompound());
    }

    @Override
    public CompoundNBT getUpdateTag() {
        return this.write(new CompoundNBT());
    }

    @Override
    public void handleUpdateTag(CompoundNBT tag) {
        this.read(tag);
    }
}
