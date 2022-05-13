package com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers;


public class ContainerInfusing /*extends AbstractContainerMenu*/ {
    /*protected ContainerInfusing(@Nullable MenuType<?> p_38851_, int p_38852_) {
        super(p_38851_, p_38852_);
    }

    @Override
    public boolean stillValid(Player p_38874_) {
        return false;
    }
/*
    private final ContainerLevelAccess containerLevelAccess;
    private final BlockEntityCapabilit blockEntity;
    private final ContainerData containerdata;

    private int cookTime, totalCookTime, burnTime, currentBurnTime;
    //client
  public ContainerInfusing(int id, Inventory playerInv)
  {
      this(id,playerInv,new ItemStackHandler(4), BlockPos.ZERO,new SimpleContainerData(4));
  }

  //server

   public ContainerInfusing(int id, Inventory playerInv, IItemHandler handler, BlockPos pos, ContainerData data)
   {
       super(id);
       //super(ModContainerTypes.CONTAINER_INFUSING.get(),id);
    this.containerLevelAccess = ContainerLevelAccess.create(playerInv.player.level,pos);
    this.containerdata = data;
       this.addSlot(new SlotItemHandler(handler, 0, 24, 16));
       this.addSlot(new SlotItemHandler(handler, 1, 56, 15));
       this.addSlot(new SlotItemHandler(handler, 2, 58, 59));
       this.addSlot(new SlotItemHandler(handler, 3, 120, 30));

       for (int y = 0; y < 3; y++) {
           for (int x = 0; x < 9; x++) {
               this.addSlot(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
           }
       }

       for (int x = 0; x < 9; x++) {
           this.addSlot(new Slot(playerInv, x, 8 + x * 18, 142));
       }
       addDataSlots(data);

   }

    /**
     * Constructor that uses super
     * @param windowId        the id of the container
     * @param playerInventory the playerInv of the player using this container
     * @param containerLevelAccess
     * @param tileEntity      the tileEntity of this container
     * @param containerdata
     */
/*
    public ContainerInfusing(final int windowId, final Inventory playerInventory, ContainerLevelAccess containerLevelAccess, final InfusingChamberTileEntity tileEntity, ContainerData containerdata) {
        super(ModContainerTypes.CONTAINER_INFUSING.get(), windowId);
        this.containerLevelAccess = containerLevelAccess;

        this.blockEntity = tileEntity;
        this.containerdata = containerdata;
        IItemHandler handler = blockEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, Direction.UP).orElse(null);


    }
/*
   public static MenuConstructor getServerContainer(InfusingChamberTileEntity be,BlockPos pos)
   {
       return (id,playerInv,player) -> new InfusingChamberTileEntity(id,playerInv,be);
   }


    @Override
    @OnlyIn(Dist.CLIENT)
    public void updateProgressBar(int id, int data) {
        this.tileentity.setField(id, data);
    }


    @Override
    public boolean canInteractWith(@Nonnull Player playerIn) {
        return this.use.isUsableByPlayer(playerIn);
    }

 */


/*
    @Nonnull
    @Override
    public ItemStack quickMoveStack(@Nonnull Player playerIn, int index) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot.hasItem()) {
            ItemStack stack1 = slot.getItem();
            stack = stack1.copy();

            if (index == 3) {
                if (!this.moveItemStackTo(stack1, 4, 40, true)) return ItemStack.EMPTY;
                slot.onQuickCraft(stack1, stack);
            } else if (index != 2 && index != 1 && index != 0) {
                Slot slot1 = this.slots.get(index + 1);

                if (!FlourideInfusionResult.getInstance().getInfusingResult(stack1, slot1.getItem()).isEmpty()) {
                    if (!this.moveItemStackTo(stack1, 0, 2, false)) {
                        return ItemStack.EMPTY;
                    } else if (InfusingChamberTileEntity.isItemFuel(stack1)) {
                        if (!this.moveItemStackTo(stack1, 2, 3, false)) return ItemStack.EMPTY;
                    } else if (InfusingChamberTileEntity.isItemFuel(stack1)) {
                        if (!this.moveItemStackTo(stack1, 2, 3, false)) return ItemStack.EMPTY;
                    } else if (InfusingChamberTileEntity.isItemFuel(stack1)) {
                        if (!this.moveItemStackTo(stack1, 2, 3, false)) return ItemStack.EMPTY;
                    } else if (index >= 4 && index < 31) {
                        if (!this.moveItemStackTo(stack1, 31, 40, false)) return ItemStack.EMPTY;
                    } else if (index >= 31 && index < 40 && !this.moveItemStackTo(stack1, 4, 31, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            } else if (!this.moveItemStackTo(stack1, 4, 40, false)) {
                return ItemStack.EMPTY;
            }
            if (stack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();

            }
            if (stack1.getCount() == stack.getCount()) return ItemStack.EMPTY;
            slot.onTake(playerIn, stack1);
        }
        return stack;
    }


    @Override
    public boolean stillValid(Player p_38874_) {
        return stillValid(p_38874_);
    }

 */

}