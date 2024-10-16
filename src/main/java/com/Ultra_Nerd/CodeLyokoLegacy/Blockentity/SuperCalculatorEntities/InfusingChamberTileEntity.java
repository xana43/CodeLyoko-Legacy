package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.blockentity.EnergyStorageBlockEntityInventory;
import it.unimi.dsi.fastutil.objects.Object2IntMaps;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.RecipeInputProvider;
import net.minecraft.recipe.RecipeMatcher;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public final class InfusingChamberTileEntity extends EnergyStorageBlockEntityInventory implements NamedScreenHandlerFactory, RecipeInputProvider {
    private int infusingTime,currentInfusingTime,currentInfusingTimeTotal;
    private final Object2IntOpenHashMap<Identifier> recipesUsed = new Object2IntOpenHashMap<>();
    private final PropertyDelegate cookProperties = new PropertyDelegate() {
        @Override
        public int get(final int index) {
            return switch (index) {
                case 0 -> (int) energyStorage.getAmount();
                case 1 -> infusingTime;
                case 2 -> currentInfusingTime;
                case 3 -> currentInfusingTimeTotal;
                case 4 -> (int) energyStorage.getCapacity();
                default -> 0;
            };
        }

        @Override
        public void set(final int index, final int value) {
            switch (index) {
                case 0 -> energyStorage.amount = value;
                case 1 -> infusingTime = value;
                case 2 -> currentInfusingTime = value;
                case 3 -> currentInfusingTimeTotal = value;
                default -> throw new IllegalArgumentException("unexpected value:"+value+" at index:"+index);
            }
        }

        @Override
        public int size() {
            return 5;
        }
    };
    public InfusingChamberTileEntity(final BlockEntityType<?> type, final BlockPos pos, final BlockState state, final int inventorySize, final long capacity, final long maxInsert, final long maxExtract) {
        super(type, pos, state, inventorySize, capacity, maxInsert, maxExtract);
    }

    @Override
    public void tick() {

    }

    @Override
    public void provideRecipeInputs(final RecipeMatcher finder) {

    }

    @Override
    public Text getDisplayName() {
        return null;
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(final int syncId, final PlayerInventory playerInventory, final PlayerEntity player) {
        return null;
    }
    private static final String InfusingTime = "InfusingTime", CurrentInfusingTime = "CurrentInfusingTime", CurrentInfusingTimeTotal = "CurrentInfusingTimeTotal",RecipesUsed = "RecipesUsed";
    @Override
    protected void writeNbt(final NbtCompound nbt,final RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt,registryLookup);
        nbt.putInt(InfusingTime,infusingTime);
        nbt.putInt(CurrentInfusingTime,currentInfusingTime);
        nbt.putInt(CurrentInfusingTimeTotal,currentInfusingTimeTotal);
        final NbtCompound nbtCompound = new NbtCompound();
        Object2IntMaps.fastForEach(recipesUsed,identifierEntry -> nbtCompound.putInt(identifierEntry.getKey().toString(),identifierEntry.getIntValue()));
        nbt.put(RecipesUsed,nbtCompound);
    }

    @Override
    public void readNbt(final NbtCompound nbt,final RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt,registryLookup);
        infusingTime = nbt.getInt(InfusingTime);
        currentInfusingTime = nbt.getInt(CurrentInfusingTime);
        currentInfusingTimeTotal = nbt.getInt(CurrentInfusingTimeTotal);
        final NbtCompound compound = nbt.getCompound(RecipesUsed);
        for(final String string : compound.getKeys()) {
            recipesUsed.put(Identifier.of(string),compound.getInt(string));

        }
    }
    /*
    public @NotNull ItemStackHandler handler = new ItemStackHandler(4);
    private String customName;
    private ItemStack smelting = ItemStack.EMPTY;
    public static final Component TITLE = new TranslatableComponent("container." + CodeLyokoMain.MOD_ID + ".infusing_chamber");
    private int burnTime;
    private int currentBurnTime;
    private int cookTime;
    private int totalCookTime = 400;

   /* public InfusingChamberTileEntity() {
        this(ModBlockEntities.INFUSING_CHAMBER_TILE_ENTITY.get());
    }*/
/*
    public InfusingChamberTileEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        super(ModBlockEntities.INFUSING_CHAMBER_TILE_ENTITY.get(),pos,state,4);
    }

    public boolean hasCapability(Capability<?> capability, Direction facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;
    }

    @Nonnull
    @Override
    public <T> @NotNull LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
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





    @Nonnull
    @Override
    public Component getDisplayName() {
        return this.hasCustomName() ? new TextComponent(this.customName) : new TranslatableComponent("container.flouride_infuser");
    }


    @Override
    public void invalidateCaps() {
        super.invalidateCaps();

    }

    @Override
    public void load(@Nonnull CompoundTag compound) {
        super.load(compound);
        this.handler.deserializeNBT(compound.getCompound("Inventory"));
        this.burnTime = compound.getInt("BurnTime");
        this.cookTime = compound.getInt("CookTime");
        this.totalCookTime = compound.getInt("CookTimeTotal");
        this.currentBurnTime = getItemBurnTime((ItemStack) this.handler.getStackInSlot(2));

        if (compound.contains("CustomName", 8)) this.setCustomName(compound.getString("CustomName"));
    }




    @Override
    public void saveAdditional(@Nonnull CompoundTag compound) {
        super.saveAdditional(compound);
        compound.putInt("BurnTime", (short) this.burnTime);
        compound.putInt("CookTime", (short) this.cookTime);
        compound.putInt("CookTimeTotal", (short) this.totalCookTime);
        compound.put("Inventory", this.handler.serializeNBT());

        if (this.hasCustomName()) compound.putString("CustomName", this.customName);

    }

    public boolean isBurning() {
        return this.burnTime > 0;
    }

    @OnlyIn(Dist.CLIENT)
    public static boolean isBurning(@NotNull InfusingChamberTileEntity te) {
        return te.getField(0) > 0;
    }




    @Override
    public void tick(Level world, BlockPos pos, BlockState state, InfusingChamberTileEntity blockEntity) {
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

    @Override
    public void tick() {
        super.tick();
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
                if (!output.equals(result)) return false;
                int res = output.getCount() + result.getCount();
                return res <= 64 && res <= output.getMaxStackSize();
            }
        }
    }

    public static int getItemBurnTime(@NotNull ItemStack fuel) {
        if (!fuel.isEmpty()) {
            Item item = fuel.getItem();

            if (item instanceof BlockItem && Block.byItem(item) != Blocks.AIR) {
                Block blocks = Block.byItem(item);


                if (blocks == ModBlocks.FLUORITE_BLOCK.get()) return 40000;
            }


            if (item == ModItems.FLUORIDE.get()) return 20000;


        }
        return 0;
    }

    public static boolean isItemFuel(@NotNull ItemStack fuel) {

        return getItemBurnTime(fuel) > 0;
    }

    public boolean isUsableByPlayer(@NotNull Player player) {
        assert this.level != null;
        return this.level.getBlockEntity(this.getBlockPos()) == this &&
                player.distanceToSqr((double) this.getBlockPos().getX() + 0.5D, (double) this.getBlockPos().getY() + 0.5D, (double) this.getBlockPos().getZ() + 0.5D) <= 64.0D;
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
    public AbstractContainerMenu createMenu(int windowIn, @Nonnull Inventory playerInventory, @Nonnull Player playerEntity) {
        return null;// new ContainerInfusing(windowIn, playerInventory, this);
    }

 */


}