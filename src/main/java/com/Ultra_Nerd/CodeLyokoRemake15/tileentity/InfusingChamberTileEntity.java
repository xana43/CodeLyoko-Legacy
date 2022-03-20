package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

import com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.flouride.FlourideInfusionResult;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.flouride.FluorideInfuser;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.ContainerInfusing;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import net.minecraft.core.Direction;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class InfusingChamberTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider {


    public ItemStackHandler handler = new ItemStackHandler(4);
    private String customName;
    private ItemStack smelting = ItemStack.EMPTY;

    private int burnTime;
    private int currentBurnTime;
    private int cookTime;
    private int totalCookTime = 400;

    public InfusingChamberTileEntity() {
        this(ModTileEntities.INFUSING_CHAMBER_TILE_ENTITY.get());
    }

    public InfusingChamberTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public boolean hasCapability(Capability<?> capability, Direction facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return LazyOptional.of(() -> (T) this.handler);
        }
        return super.getCapability(cap, side);
    }

    public boolean hasCustomName() {
        return this.customName != null && !this.customName.isEmpty();
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    @Override
    @Nonnull
    public ITextComponent getDisplayName() {
        return this.hasCustomName() ? new StringTextComponent(this.customName) : new TranslationTextComponent("container.flouride_infuser");
    }

    @Override
    public void read(@Nonnull CompoundTag compound) {
        super.read(compound);
        this.handler.deserializeNBT(compound.getCompound("Inventory"));
        this.burnTime = compound.getInt("BurnTime");
        this.cookTime = compound.getInt("CookTime");
        this.totalCookTime = compound.getInt("CookTimeTotal");
        this.currentBurnTime = getItemBurnTime((ItemStack) this.handler.getStackInSlot(2));

        if (compound.contains("CustomName", 8)) this.setCustomName(compound.getString("CustomName"));
    }

    @Nonnull
    @Override
    public CompoundTag write(@Nonnull CompoundTag compound) {
        super.write(compound);
        compound.putInt("BurnTime", (short) this.burnTime);
        compound.putInt("CookTime", (short) this.cookTime);
        compound.putInt("CookTimeTotal", (short) this.totalCookTime);
        compound.put("Inventory", this.handler.serializeNBT());

        if (this.hasCustomName()) compound.putString("CustomName", this.customName);
        return compound;
    }

    public boolean isBurning() {
        return this.burnTime > 0;
    }

    @OnlyIn(Dist.CLIENT)
    public static boolean isBurning(InfusingChamberTileEntity te) {
        return te.getField(0) > 0;
    }


    @Override
    public void tick() {
        if (this.isBurning()) {
            --this.burnTime;
            FluorideInfuser.setState(true, world, pos);
        }

        ItemStack[] inputs = new ItemStack[]{handler.getStackInSlot(0), handler.getStackInSlot(1)};
        ItemStack fuel = this.handler.getStackInSlot(2);


        if (this.isBurning() || !fuel.isEmpty() && !this.handler.getStackInSlot(0).isEmpty() || this.handler.getStackInSlot(1).isEmpty()) {
            if (!this.isBurning() && this.canSmelt()) {
                this.burnTime = getItemBurnTime(fuel);
                this.currentBurnTime = burnTime;

                if (this.isBurning() && !fuel.isEmpty()) {
                    Item item = fuel.getItem();
                    fuel.shrink(1);

                    if (fuel.isEmpty()) {
                        ItemStack item1 = item.getContainerItem(fuel);
                        this.handler.setStackInSlot(2, item1);
                    }
                }
            }
        }

        if (this.isBurning() && this.canSmelt() && cookTime > 0) {
            cookTime++;
            if (cookTime == totalCookTime) {
                if (handler.getStackInSlot(3).getCount() > 0) {
                    handler.getStackInSlot(3).grow(1);
                } else {
                    handler.insertItem(3, smelting, false);
                }

                smelting = ItemStack.EMPTY;
                cookTime = 0;
            }
        } else {
            if (this.canSmelt() && this.isBurning()) {
                ItemStack output = FlourideInfusionResult.getInstance().getInfusingResult(inputs[0], inputs[1]);
                if (!output.isEmpty()) {
                    smelting = output;
                    cookTime++;
                    inputs[0].shrink(1);
                    inputs[1].shrink(1);
                    handler.setStackInSlot(0, inputs[0]);
                    handler.setStackInSlot(1, inputs[1]);
                }
            }
        }
    }

    private boolean canSmelt() {
        if (((ItemStack) this.handler.getStackInSlot(0)).isEmpty() || ((ItemStack) this.handler.getStackInSlot(1)).isEmpty())
            return false;
        else {
            ItemStack result = FlourideInfusionResult.getInstance().getInfusingResult((ItemStack) this.handler.getStackInSlot(0), (ItemStack) this.handler.getStackInSlot(1));
            if (result.isEmpty()) return false;
            else {
                ItemStack output = (ItemStack) this.handler.getStackInSlot(3);
                if (output.isEmpty()) return true;
                if (!output.isItemEqual(result)) return false;
                int res = output.getCount() + result.getCount();
                return res <= 64 && res <= output.getMaxStackSize();
            }
        }
    }

    public static int getItemBurnTime(ItemStack fuel) {
        if (!fuel.isEmpty()) {
            Item item = fuel.getItem();

            if (item instanceof BlockItem && Block.getBlockFromItem(item) != Blocks.AIR) {
                Block block = Block.getBlockFromItem(item);


                if (block == ModBlocks.FLUORITE_BLOCK.get()) return 40000;
            }


            if (item == ModItems.FLUORIDE.get()) return 20000;


        }
        return 0;
    }

    public static boolean isItemFuel(ItemStack fuel) {

        return getItemBurnTime(fuel) > 0;
    }

    public boolean isUsableByPlayer(Player player) {
        assert this.level != null;
        return this.world.getTileEntity(this.pos) == this &&
                player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
    }

    public int getField(int id) {
        switch (id) {
            case 0:
                return this.burnTime;
            case 1:
                return this.currentBurnTime;
            case 2:
                return this.cookTime;
            case 3:
                return this.totalCookTime;
            default:
                return 0;
        }
    }

    public void setField(int id, int value) {
        switch (id) {
            case 0:
                this.burnTime = value;
                break;
            case 1:
                this.currentBurnTime = value;
                break;
            case 2:
                this.cookTime = value;
                break;
            case 3:
                this.totalCookTime = value;
        }
    }


    @Nullable
    @Override
    public Container createMenu(int windowIn, @Nonnull PlayerInventory playerInventory, @Nonnull PlayerEntity playerEntity) {
        return new ContainerInfusing(windowIn, playerInventory, this);
    }


}