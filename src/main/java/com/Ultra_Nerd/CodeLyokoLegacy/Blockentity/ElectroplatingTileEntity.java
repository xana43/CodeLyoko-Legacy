package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity;

public class ElectroplatingTileEntity /*extends BlockEntity implements InventoryTickingBlockEntity<ElectroplatingTileEntity>//, INamedContainerProvider*/ {
     /*
    private boolean once = false;
    private final int maxSmeltTime = 1000;
    public int currentTime;
    private final @NotNull CustomItemHandler inventory;

    public ElectroplatingTileEntity(@NotNull BlockEntityType<ElectroplatingTileEntity> tileEntityTypeIn, @NotNull BlockPos pos, @NotNull BlockState state) {
        super(tileEntityTypeIn,pos,state);
        this.inventory = new CustomItemHandler(2);
    }
/*
    public ElectroplatingTileEntity(BlockPos pos, BlockState state) {
        this(ModBlockEntities.ELECTROPLATING_TILE_ENTITY.get());
    }*/

/*


     @Nullable
    private TestRecipe getRecipe(@org.jetbrains.annotations.Nullable ItemStack stack) {
        if (stack == null) {
            return null;
        }
        Set<Recipe<?>> recipes = findRecipesByType(ModRecipes.TYPE, this.level);
        for (net.minecraft.world.item.crafting.Recipe<?> Recipe : recipes) {
            TestRecipe recipe = (TestRecipe) Recipe;
            if (recipe.matches(new RecipeWrapper(this.inventory), this.level)) {
                return recipe;
            }
        }
        return null;
    }

    public static @NotNull Set<Recipe<?>> findRecipesByType(RecipeType<?> type, @org.jetbrains.annotations.Nullable Level world) {
        return world != null ? world.getRecipeManager().getRecipes().stream()
                .filter(recipe -> recipe.getType() == type).collect(Collectors.toSet()) : Collections.emptySet();
    }

    @OnlyIn(Dist.CLIENT)
    public static @NotNull Set<Recipe<?>> findRecipesByType(RecipeType<?> type) {
        ClientLevel world = Minecraft.getInstance().level;
        return world != null ? world.getRecipeManager().getRecipes().stream()
                .filter(recipe -> recipe.getType() == type).collect(Collectors.toSet()) : Collections.emptySet();
    }

    public static @NotNull Set<ItemStack> getInputs(RecipeType<?> type, Level world) {
        Set<ItemStack> inputs = new HashSet<ItemStack>();
        Set<Recipe<?>> recipes = findRecipesByType(type, world);
        for (Recipe<?> recipe : recipes) {
            NonNullList<Ingredient> ingredients = recipe.getIngredients();
            ingredients.forEach(ingredient -> {
                inputs.addAll(Arrays.asList(ingredient.getItems()));
            });
        }
        return inputs;
    }



    @Override
    public void tick(Level level, BlockPos pos, BlockState state, ElectroplatingTileEntity BE) {
        boolean dirty = false;
        if (CheckStruct() && !once) {
            activate();
            once = true;
        } else if (!CheckStruct()) {
            once = false;
            deactivate();
        }
        if (this.level != null && this.level.isClientSide) {
            if (this.level.hasNeighborSignal(this.worldPosition)) {
                if (this.getRecipe(this.inventory.getStackInSlot(0)) != null) {
                    if (this.currentTime != this.maxSmeltTime) {
                        this.level.setBlockAndUpdate(this.worldPosition, this.getBlockState().setValue(ElectroplatingMachine.ELECTRO_ACTIVE, true));
                        this.currentTime++;
                        dirty = true;
                    } else {
                        this.level.setBlockAndUpdate(this.worldPosition, this.getBlockState().setValue(ElectroplatingMachine.ELECTRO_ACTIVE, false));
                        this.currentTime = 0;
                        ItemStack output = this.getRecipe(this.inventory.getStackInSlot(0)).getResultItem();
                        this.inventory.insertItem(1, output.copy(), false);
                        this.inventory.decrStackSize(0, 1);
                        dirty = true;
                    }
                }
            }
        }
        if (dirty) {
            this.setChanged();
            this.level.notify();
        }
    }




/*
    @Nullable
    @Override
    public Container createMenu(final int windowID, @Nonnull final PlayerInventory playerInv, @Nonnull final PlayerEntity playerIn) {
        return new ContainerElectroplate(windowID, playerInv, this);
    }
*/
/*

     @Override
    public void load(@Nonnull CompoundTag compound) {

        super.load(compound);
        NonNullList<ItemStack> inv = NonNullList.withSize(this.inventory.getSlots(), ItemStack.EMPTY);
        ///(compound, inv);
        this.inventory.setNonNullList(inv);
        this.currentTime = compound.getInt("currentElectroTime");

    }




    @Nonnull
    @Override
    public void saveAdditional(@Nonnull CompoundTag compound) {
        super.saveAdditional(compound);
        ContainerHelper.saveAllItems(compound, this.inventory.toNonNullList());
        compound.putInt("currentElectroTime", this.currentTime);

    }

    public final @NotNull IItemHandlerModifiable getInventory() {
        return this.inventory;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.orEmpty(cap, LazyOptional.of(() -> this.inventory));
    }


     @Override
     public void handleUpdateTag(@NotNull CompoundTag tag) {
         this.load(tag);

     }

     @org.jetbrains.annotations.Nullable
     @Override
     public Packet<ClientGamePacketListener> getUpdatePacket() {
         CompoundTag nbt = new CompoundTag();
         this.saveAdditional(nbt);
         return super.getUpdatePacket();

    }


     /*

     @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
         CompoundTag nbt = new CompoundTag();
        this.write(nbt);
        return new SUpdateTileEntityPacket(this.pos, 0, nbt);
    }

      */
/*
    @Override
    public void onDataPacket(Connection net, @NotNull ClientboundBlockEntityDataPacket pkt) {
        this.load(Objects.requireNonNull(pkt.getTag()));
    }


    @Nonnull
    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag nbt = new CompoundTag();
        this.handleUpdateTag(nbt);
        return nbt;
    }


    //multiblock stuff
    private boolean CheckStruct() {

        if (this.getBlockState().getValue(ElectroplatingMachine.ELECTRO_FACING) == Direction.NORTH) {
            int[] locationX = {1, 2};
            int[] locationZ = {1, 2, 3};
            for (int I : locationX) {
                if (level.getBlockState(new BlockPos(this.worldPosition.getX() + I, this.worldPosition.getY(), this.getBlockPos().getZ()))
                        == ModBlocks.ELECTROPLATING_MACHINE_FRAME.get().defaultBlockState()) {
                    if (level.getBlockState(new BlockPos(this.getBlockPos().getX() - I, this.getBlockPos().getY(), this.getBlockPos().getZ())) ==
                            ModBlocks.ELECTROPLATING_MACHINE_FRAME.get().defaultBlockState()) {
                        if (level.getBlockState(new BlockPos(this.getBlockPos().getX(), this.getBlockPos().getY(), this.getBlockPos().getZ() + I))
                                == ModBlocks.ELECTROPLATING_MACHINE_FRAME.get().defaultBlockState()) {
                            if (level.getBlockState(new BlockPos(this.getBlockPos().getX(), this.getBlockPos().getY(), this.getBlockPos().getZ() - I)) ==
                                    ModBlocks.ELECTROPLATING_MACHINE_FRAME.get().defaultBlockState()) {
                                CodeLyokoMain.Log.debug("foprmed");
                                return true;
                            }
                        }
                    }
                }
            }
        }
        CodeLyokoMain.Log.debug("dead");
        return false;
    }

    private static void activate() {

    }

    private static void deactivate() {

    }

 */


}
