package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

import com.Ultra_Nerd.CodeLyokoRemake15.RF.EG;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.flouride.ElectricFlourideInfuser;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.flouride.FlourideInfusionResult;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.ContainerElectricInfusing;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ElectricInfusingChamberTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider {
    public ItemStackHandler handler = new ItemStackHandler(3);
    private final EG internal = new EG(90000);
    private String customName;
    private ItemStack smelting = ItemStack.EMPTY;


    private int cookTime;
    public int ENER = internal.getEnergyStored();

    public ElectricInfusingChamberTileEntity() {
        this(ModTileEntities.ELECTRIC_INFUSING_CHAMBER_TILE_ENTITY.get());
    }

    public ElectricInfusingChamberTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public boolean hasCapability(Capability<?> capability, Direction facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return true;
        } else if (capability == CapabilityEnergy.ENERGY) {
            return true;
        } else {
            return false;
        }
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, Direction facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return LazyOptional.of(() -> (T) this.handler);
        if (capability == CapabilityEnergy.ENERGY) return LazyOptional.of(() -> (T) this.internal);
        return super.getCapability(capability, facing);
    }

    @Nonnull
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent("container.electric_flouride_infuser");
    }


    public int getENER() {
        return this.ENER;
    }

    public int maxenergy() {
        return this.internal.getMaxEnergyStored();
    }

    @Override
    public void read(@Nonnull CompoundNBT compound) {
        super.read(compound);
        this.handler.deserializeNBT(compound.getCompound("Inventory"));
        this.cookTime = compound.getInt("CookTime");
        this.customName = compound.getString("CustomName");
        this.internal.RFNBT(compound);
        this.ENER = compound.getInt("GuiEnergy");
    }

    @Nonnull
    @Override
    public CompoundNBT write(@Nonnull CompoundNBT compound) {
        super.write(compound);

        compound.putInt("CookTime", (short) this.cookTime);

        compound.put("Inventory", this.handler.serializeNBT());
        compound.putString("CustomName", getDisplayName().toString());
        compound.putInt("GuiEnergy", this.ENER);
        return compound;
    }

    @Override
    public void tick() {
        if (world.isBlockPowered(pos)) ENER += 100;
        ItemStack[] Inputs = new ItemStack[]{handler.getStackInSlot(0), handler.getStackInSlot(1)};
        if (ENER >= 80) {
            if (cookTime > 0) {
                ENER -= 20;
                cookTime++;
                ElectricFlourideInfuser.setState(true, world, pos);
                if (cookTime == 200) {
                    if (handler.getStackInSlot(2).getCount() > 0) {
                        handler.getStackInSlot(2).grow(1);
                    } else {
                        handler.insertItem(2, smelting, false);
                    }
                    smelting = ItemStack.EMPTY;
                    cookTime = 0;
                }
            } else if (!Inputs[0].isEmpty() && !Inputs[1].isEmpty()) {
                ItemStack out = FlourideInfusionResult.getInstance().getInfusingResult(Inputs[0], Inputs[1]);
                if (!out.isEmpty()) {
                    smelting = out;
                    cookTime++;
                    Inputs[0].shrink(1);
                    Inputs[1].shrink(1);
                    handler.setStackInSlot(0, Inputs[0]);
                    handler.setStackInSlot(1, Inputs[1]);
                    ENER -= 20;
                }
            }
        }
    }

    private boolean canSmelt() {
        if (this.handler.getStackInSlot(0).isEmpty() || this.handler.getStackInSlot(1).isEmpty())
            return false;
        else {
            ItemStack result = FlourideInfusionResult.getInstance().getInfusingResult(this.handler.getStackInSlot(0), this.handler.getStackInSlot(1));
            if (result.isEmpty()) {
                return false;
            }
            else {
                ItemStack output = this.handler.getStackInSlot(3);
                if (output.isEmpty()) return true;
                if (!output.isItemEqual(result)) return false;
                int res = output.getCount() + result.getCount();
                return res <= 64 && res <= output.getMaxStackSize();
            }
        }
    }


    public boolean isUsableByPlayer(PlayerEntity player) {
        assert this.world != null;
        return this.world.getTileEntity(this.pos) == this && player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
    }

    public int getField(int id) {
        switch (id) {
            case 0:
                return this.ENER;
            case 1:
                return this.cookTime;
            default:
                return 0;
        }
    }

    public void setField(int id, int value) {
        switch (id) {
            case 0:
                this.ENER = value;

                break;
            case 1:
                this.cookTime = value;
                break;

        }
    }

    @Nullable
    @Override
    public Container createMenu(int windowIn, @Nonnull PlayerInventory playerInventory, @Nonnull PlayerEntity p_createMenu_3_) {
        return new ContainerElectricInfusing(windowIn, playerInventory, this);
    }
}