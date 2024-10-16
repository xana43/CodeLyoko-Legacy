package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity;

public final class ElectricInfusingChamberTileEntity /*extends BlockEntity implements InventoryTickingBlockEntity<ElectricInfusingChamberTileEntity>,MenuProvider*/ {
    /*
    public @NotNull ItemStackHandler handler = new ItemStackHandler(3);
   private final EnergyModule internal = new EnergyModule(this,90000);
    private String customName;
    private ItemStack smelting = ItemStack.EMPTY;


    private int cookTime;
    public int ENER = internal.getEnergyStored();

    public ElectricInfusingChamberTileEntity(@NotNull BlockEntityType<?> p_155228_, @NotNull BlockPos p_155229_, @NotNull BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
    }


    /*
        public ElectricInfusingChamberTileEntity() {
            this(ModBlockEntities.ELECTRIC_INFUSING_CHAMBER_TILE_ENTITY.get());
        }

        public ElectricInfusingChamberTileEntity(BlockEntityType<?> tileEntityTypeIn) {
            super(tileEntityTypeIn);
        }
    */
    /*
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
        //if (capability == CapabilityEnergy.ENERGY) return LazyOptional.of(() -> (T) this.internal);
        return super.getCapability(capability, facing);
    }

    @Override
    @Nonnull
    public Component getDisplayName() {
        return new TranslatableComponent("container.electric_flouride_infuser");
    }


    public int getENER() {
        return this.ENER;
    }

    public int maxenergy() {
        return this.internal.getMaxEnergyStored();
    }

    @Override
    public void load(@Nonnull CompoundTag compound) {
        super.load(compound);
        this.handler.deserializeNBT(compound.getCompound("Inventory"));
        this.cookTime = compound.getInt("CookTime");
        this.customName = compound.getString("CustomName");
        //this.internal.RFNBT(compound);
        this.ENER = compound.getInt("GuiEnergy");
    }


    @Override
    public @NotNull BlockPos getBlockPos() {
        return this.worldPosition;
    }

    @Override
    public void saveAdditional(@Nonnull CompoundTag compound) {
        super.saveAdditional(compound);

        compound.putInt("CookTime", (short) this.cookTime);

        compound.put("Inventory", this.handler.serializeNBT());
        compound.putString("CustomName", getDisplayName().toString());
        compound.putInt("GuiEnergy", this.ENER);
    }



    @Override
    public void tick(@NotNull Level worldin, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull ElectricInfusingChamberTileEntity be) {
        assert level != null;
        if (level.hasNeighborSignal(worldPosition)) ENER += 100;
        ItemStack[] Inputs = new ItemStack[]{handler.getStackInSlot(0), handler.getStackInSlot(1)};
        if (ENER >= 80) {
            if (cookTime > 0) {
                ENER -= 20;
                cookTime++;
                ElectricFluorideInfuser.setState(true, level, worldPosition);
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
            } else {
                ItemStack output = this.handler.getStackInSlot(3);
                if (output.isEmpty()) return true;
                if (!output.sameItem(result)) return false;
                int res = output.getCount() + result.getCount();
                return res <= 64 && res <= output.getMaxStackSize();
            }
        }
    }


    public boolean isUsableByPlayer(@NotNull Player player) {
        assert this.level != null;
        return this.level.getBlockEntity(this.worldPosition) == this &&
                player.distanceToSqr((double) this.worldPosition.getX() + 0.5D, (double) this.worldPosition.getY() + 0.5D, (double) this.worldPosition.getZ() + 0.5D) <= 64.0D;
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
    public AbstractContainerMenu createMenu(int windowIn, @Nonnull Inventory playerInventory, @Nonnull Player p_createMenu_3_) {
        return null; //ew ContainerElectricInfusing(windowIn, playerInventory, this);
    }

     */


}