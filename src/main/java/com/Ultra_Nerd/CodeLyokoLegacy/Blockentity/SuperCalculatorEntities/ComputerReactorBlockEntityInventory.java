package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.*;
import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.ReactorScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.MethodUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.blockentity.EnergyStorageBlockEntityInventory;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.storage.base.FilteringStorage;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.*;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.Ultra_Nerd.CodeLyokoLegacy.Util.MethodUtil.HelperMethods.outputFluidToAllSides;

public final class ComputerReactorBlockEntityInventory extends EnergyStorageBlockEntityInventory implements NamedScreenHandlerFactory, RecipeInputProvider {
    private int reactionTime;
private int fuelMass;
private int irradiationTime;
private int irradiationTimeTotal;
private final Object2IntOpenHashMap<Identifier> recipesUsed = new Object2IntOpenHashMap<>();
private final RecipeManager.MatchGetter<Inventory,? extends AbstractCookingRecipe> matchGetter;
    private final SingleVariantStorage<FluidVariant> wasteTank =
            MethodUtil.FluidStorageCreation.createFluidStorage(this, ModFluids.STILL_URANIUM);
    private final Storage<FluidVariant> extractionOfWasteTank = FilteringStorage.extractOnlyOf(wasteTank);
    private final PropertyDelegate energyAmount = new PropertyDelegate() {
        @Override
        public int get(final int index) {
            return switch (index) {
                case 0 -> (int) energyStorage.getAmount();
                case 1 -> reactionTime;
                case 2 -> fuelMass;
                case 3 -> irradiationTime;
                case 4 -> irradiationTimeTotal;
                case 5 -> (int)wasteTank.getAmount();
                case 6 -> (int)wasteTank.getCapacity();
                case 7 -> (int)energyStorage.getCapacity();
                default -> 0;
            };

        }

        @Override
        public void set(final int index, final int value) {
            switch (index) {
             case 0 ->  energyStorage.amount = value;
             case 1 -> reactionTime = value;
             case 2 -> fuelMass = value;
             case 3 -> irradiationTime = value;
             case 4 -> irradiationTimeTotal = value;
             case 5 -> wasteTank.amount = value;
                default -> throw new IllegalArgumentException("unexpected value:"+value+" at index:"+index);
            }
        }

        @Override
        public int size() {
            return 8;
        }
    };
    public Storage<FluidVariant> getWasteTank()
    {
        return extractionOfWasteTank;
    }
    @Override
    protected void writeNbt(final NbtCompound nbt,final RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt,registryLookup);
        nbt.putInt("ReactionTime",reactionTime);
        nbt.putInt("IrradiationTime",irradiationTime);
        nbt.putInt("IrradiationTimeTotal",irradiationTimeTotal);
        nbt.putLong("WasteAmount",wasteTank.amount);
        final NbtCompound nbtCompound = new NbtCompound();
        recipesUsed.forEach((identifier, integer) -> nbtCompound.putInt(identifier.toString(), integer));
        nbt.put("RecipesUsed",nbtCompound);
    }

    @Override
    public void readNbt(final NbtCompound nbt,final RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt,registryLookup);
        wasteTank.amount = nbt.getLong("WasteAmount");
        reactionTime = nbt.getInt("ReactionTime");
        irradiationTime = nbt.getInt("IrradiationTime");
        irradiationTimeTotal = nbt.getInt("IrradiationTimeTotal");
        fuelMass = getFuelTime(itemStacks.getFirst());
        final NbtCompound nbtCompound = nbt.getCompound("RecipesUsed");
        for (final String string : nbtCompound.getKeys()) {
            recipesUsed.put(new Identifier(string), nbtCompound.getInt(string));
        }

    }

    public ComputerReactorBlockEntityInventory(final BlockPos pos, final BlockState state) {
        super(ModBlockEntities.COMPUTER_REACTOR_TILE_ENTITY, pos, state, 2, 400000, Long.valueOf(60), Long.valueOf(200));
        matchGetter = RecipeManager.createCachedMatchGetter(ModRecipes.RecipeTypes.REACTOR_RECIPE_TYPE);
    }

    @Override
    public @NotNull ScreenHandler createMenu(final int syncId, final PlayerInventory inv, final PlayerEntity player) {
        return new ReactorScreenHandler(syncId, inv, this, energyAmount);
    }

    private boolean isReacting()
    {
        return this.reactionTime > 0;
    }
    @Override
    public Text getDisplayName() {
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
    }

    public static boolean canUseAsFuel(final ItemStack stack)
    {
        return ModFuels.FUEL_MAP.containsKey(stack.getItem());
    }

    @Override
    public void tick() {
        outputFluidToAllSides(world,pos,wasteTank);
        boolean reacting2 = false;
        if(isReacting())
        {
            --reactionTime;
        }
        final ItemStack itemStack = getStack(0);
        boolean isCurrentItemStackEmpty = !getStack(0).isEmpty();
        boolean isGottenItemStackEmpty = !itemStack.isEmpty();
        if(isReacting() || isCurrentItemStackEmpty && isGottenItemStackEmpty && wasteTank.amount < wasteTank.getCapacity())
        {
            RecipeEntry<?> recipe;
            if(isCurrentItemStackEmpty)
            {

                recipe = matchGetter.getFirstMatch(this,world).orElse(null);
            }
            else {
                recipe = null;
            }
            final int maxCount = getMaxCountPerStack();



            if(!isReacting() && canAcceptRecipeOutput(world.getRegistryManager(),recipe,itemStacks,maxCount))
            {
                    reactionTime = getFuelTime(itemStack);
                    fuelMass = reactionTime;
                    if (isReacting()) {
                        reacting2 = true;
                        if (isGottenItemStackEmpty) {

                            final Item item = itemStack.getItem();
                            itemStack.decrement(1);
                            if (itemStack.isEmpty()) {
                                final Item item2 = item.getRecipeRemainder();
                                setStack(1, item2 == null ? ItemStack.EMPTY : new ItemStack(item2));
                            }
                        }
                    }

            }
            if(isReacting() && canAcceptRecipeOutput(world.getRegistryManager(),recipe,itemStacks,maxCount))
            {
                ++irradiationTime;
                try(final Transaction transaction = Transaction.openOuter()) {
                    if(getStack(0).getItem() == ModItems.URANIUM_ISOTOPE235) {
                        energyStorage.insert(30, transaction);
                        wasteTank.insert(FluidVariant.of(ModFluids.STILL_URANIUM), 10, transaction);
                    } else if (getStack(0).getItem() == ModBlocks.URANIUM_BLOCK_235.asItem()) {
                        energyStorage.insert(270, transaction);
                        wasteTank.insert(FluidVariant.of(ModFluids.STILL_URANIUM), 90, transaction);
                    }
                    transaction.commit();
                }
                if(irradiationTime == irradiationTimeTotal)
                {
                    irradiationTime = 0;
                    irradiationTimeTotal = getCookTime(world,this);
                    if(craftRecipe(world.getRegistryManager(),recipe,itemStacks,maxCount))
                    {
                        setLastRecipe(recipe);
                    }
                    reacting2 = true;
                }
            }
            else {
                irradiationTime = 0;
            }
        } else if (!isReacting() && irradiationTime > 0) {
            irradiationTime = MathHelper.clamp(irradiationTime - 2, 0,irradiationTimeTotal);
        }
        if(reacting2)
        {
            markDirty();
        }
    }

    @Override
    public boolean canPlayerUse(final PlayerEntity player) {
        return Inventory.canPlayerUse(this,player);
    }

    private static boolean canAcceptRecipeOutput(final DynamicRegistryManager registryManager,
            final @Nullable RecipeEntry<?> recipe,final DefaultedList<ItemStack> slots,final int count) {
        if (!slots.get(0).isEmpty() && recipe != null) {
            final ItemStack itemStack = recipe.value().getResult(registryManager);
            if (itemStack.isEmpty() || (itemStack.isIn(ModTags.ItemTags.URANIUM_BATTERIES) && itemStack.getDamage() == itemStack.getMaxDamage())) {
                return false;
            } else {
                final ItemStack itemStack2 = slots.get(1);
                if (itemStack2.isEmpty()) {
                    return true;
                } else if (!ItemStack.areItemsEqual(itemStack2, itemStack)) {
                    return false;
                } else if (itemStack2.getCount() < count && itemStack2.getCount() < itemStack2.getMaxCount()) {
                    return true;
                } else {
                    return itemStack2.getCount() < itemStack.getMaxCount();
                }
            }
        } else {
            return false;
        }
    }

    private static boolean craftRecipe(final DynamicRegistryManager registryManager,final @Nullable RecipeEntry<?> recipe,
            final DefaultedList<ItemStack> slots,final int count) {
        if (recipe != null && canAcceptRecipeOutput(registryManager, recipe, slots, count)) {
            final ItemStack itemStack = slots.get(0);
            final ItemStack itemStack2 = recipe.value().getResult(registryManager);
            final ItemStack itemStack3 = slots.get(1);
            if (itemStack3.isEmpty()) {
                slots.set(1, itemStack2.copy());
            } else if (itemStack3.isOf(itemStack2.getItem())) {
                itemStack3.increment(1);
            }


            if(itemStack.isIn(ModTags.ItemTags.URANIUM_BATTERIES))
            {

                itemStack.damage(10,Random.createLocal(),null,() -> {});
            }
            else {
                itemStack.decrement(1);
            }
            return true;
        } else {
            return false;
        }
    }
    private static int getFuelTime(final ItemStack fuel)
    {
        if(fuel.isEmpty())
        {
            return  0;
        }else
        {
            final Item item = fuel.getItem();
            return ModFuels.FUEL_MAP.getOrDefault(item, 0);
        }
    }

    @Override
    public boolean canInsert(final int slot, final ItemStack stack, final @Nullable Direction dir) {
        return isValid(slot, stack);
    }



    @Override
    public void setStack(final int slot, final ItemStack stack) {
        final ItemStack itemStack = itemStacks.get(slot);
        final boolean canSet = !stack.isEmpty() && ItemStack.areItemsEqual(itemStack,stack);
        itemStacks.set(slot, stack);
        if(stack.getCount() > getMaxCountPerStack())
        {
            stack.setCount(getMaxCountPerStack());
        }
        if(slot == 0 && !canSet)
        {
            irradiationTimeTotal = getCookTime(world,this);
            irradiationTime = 0;
            markDirty();
        }
    }

    @Override
    public boolean isValid(final int slot, final ItemStack stack) {
        if(slot == 1)
        {
            return false;
        } else if(slot == 0) {
            return true;
        }else {
            return canUseAsFuel(stack) || stack.isOf(ModItems.URANIUM_BATTERY_FINAL) || stack.isOf(ModItems.URANIUM_BATTERY_NOVICE) || stack.isOf(ModItems.URANIUM_BATTERY_STARTER);
        }

    }



    private static int getCookTime(final World world,final ComputerReactorBlockEntityInventory reactorTileEntityInventory)
    {
        return reactorTileEntityInventory.matchGetter.getFirstMatch(reactorTileEntityInventory, world).map(recipeEntry -> recipeEntry.value().getCookingTime()).orElse(200);
    }
    public void setLastRecipe(final RecipeEntry<?> recipe)
    {
        if(recipe != null)
        {
            CodeLyokoMain.LOG.debug("setting last recipe");
            CodeLyokoMain.LOG.info("setting last recipe");
            final Identifier identifier = recipe.id();
            this.recipesUsed.addTo(identifier,1);
        }
    }
    @Override
    public void provideRecipeInputs(final RecipeMatcher finder) {

        for (final ItemStack itemStack : itemStacks) {
            finder.addInput(itemStack);
        }

    }
}
