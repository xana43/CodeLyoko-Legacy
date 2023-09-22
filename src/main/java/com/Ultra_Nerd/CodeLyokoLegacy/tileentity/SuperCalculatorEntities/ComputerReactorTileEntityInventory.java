package com.Ultra_Nerd.CodeLyokoLegacy.tileentity.SuperCalculatorEntities;

import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.ReactorScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.init.*;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.EnergyStorageBlockEntityInventory;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.LyokoInventoryBlock;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeMatcher;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ComputerReactorTileEntityInventory extends EnergyStorageBlockEntityInventory implements LyokoInventoryBlock, NamedScreenHandlerFactory {
private static final int REACTION_TIME_INDEX = 1;
private static final int FUEL_MASS_INDEX = 2;
private static final int IRRADIATION_INDEX  = 3;
private static final int IRRADIATION_TOTAL_INDEX = 4;
private static final int PROPERTY_COUNT = 5;
private int reactionTime;
private int fuelMass;
private int irradiationTime;
private int irradiationTimeTotal;
private final Object2IntOpenHashMap<Identifier> recipesUsed = new Object2IntOpenHashMap<>();
private final RecipeManager.MatchGetter<Inventory,? extends AbstractCookingRecipe> matchGetter;
    private final SingleVariantStorage<FluidVariant> wasteTank =
            MethodUtil.FluidStorageCreation.createFluidStorage(this, ModFluids.STILL_URANIUM);

    private final PropertyDelegate energyAmount = new PropertyDelegate() {
        @Override
        public int get(final int index) {
            return switch (index) {
                case 0 -> (int) energyStorage.getAmount();
                case 1 -> reactionTime;
                case 2 -> fuelMass;
                case 3 -> irradiationTime;
                case 4 -> irradiationTimeTotal;
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
            }
        }

        @Override
        public int size() {
            return 5;
        }
    };

    @Override
    protected void writeNbt(final NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("ReactionTime",reactionTime);
        nbt.putInt("IrradiationTime",irradiationTime);
        nbt.putInt("IrradiationTimeTotal",irradiationTimeTotal);
        nbt.putLong("WasteAmount",wasteTank.amount);
        final NbtCompound nbtCompound = new NbtCompound();
        recipesUsed.forEach((identifier, integer) -> nbtCompound.putInt(identifier.toString(),integer));
        nbt.put("RecipesUsed",nbtCompound);
    }

    @Override
    public void readNbt(final NbtCompound nbt) {
        super.readNbt(nbt);
        wasteTank.amount = nbt.getLong("WasteAmount");
        reactionTime = nbt.getInt("ReactionTime");
        irradiationTime = nbt.getInt("IrradiationTime");
        irradiationTimeTotal = nbt.getInt("IrradiationTimeTotal");
        fuelMass = getFuelTime(itemStacks.get(0));
        final NbtCompound nbtCompound = nbt.getCompound("RecipesUsed");
        for (final String string : nbtCompound.getKeys()) {
            recipesUsed.put(new Identifier(string), nbtCompound.getInt(string));
        }

    }

    public ComputerReactorTileEntityInventory(final BlockPos pos, final BlockState state) {
        super(ModBlockEntities.COMPUTER_REACTOR_TILE_ENTITY, pos, state, 2, 400000, 60L, 200L);
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
            Recipe<?> recipe;
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

                            Item item = itemStack.getItem();
                            itemStack.decrement(1);
                            if (itemStack.isEmpty()) {
                                Item item2 = item.getRecipeRemainder();
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
        } else if (irradiationTime > 0) {
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
            final @Nullable Recipe<?> recipe,final DefaultedList<ItemStack> slots,final int count) {
        if (!slots.get(0).isEmpty() && recipe != null) {
            final ItemStack itemStack = recipe.getOutput(registryManager);
            if (itemStack.isEmpty()) {
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

    private static boolean craftRecipe(final DynamicRegistryManager registryManager,final @Nullable Recipe<?> recipe,
            final DefaultedList<ItemStack> slots,final int count) {
        if (recipe != null && canAcceptRecipeOutput(registryManager, recipe, slots, count)) {
            final ItemStack itemStack = slots.get(0);
            final ItemStack itemStack2 = recipe.getOutput(registryManager);
            final ItemStack itemStack3 = slots.get(1);
            if (itemStack3.isEmpty()) {
                slots.set(1, itemStack2.copy());
            } else if (itemStack3.isOf(itemStack2.getItem())) {
                itemStack3.increment(1);
            }



            itemStack.decrement(1);
            return true;
        } else {
            return false;
        }
    }
    private int getFuelTime(final ItemStack fuel)
    {
        if(fuel.isEmpty())
        {
            return  0;
        }else
        {
            final Item item = fuel.getItem();
            return ModFuels.FUEL_MAP.getOrDefault(item,0);
        }
    }

    private static int getCookTime(final World world,final ComputerReactorTileEntityInventory reactorTileEntityInventory)
    {
        return reactorTileEntityInventory.matchGetter.getFirstMatch(reactorTileEntityInventory,world).map(AbstractCookingRecipe::getCookTime).orElse(200);
    }
    public void setLastRecipe(final Recipe<?> recipe)
    {
        if(recipe != null)
        {
            final Identifier identifier = recipe.getId();
            this.recipesUsed.addTo(identifier,1);
        }
    }

    public void provideRecipeInputs(final RecipeMatcher finder) {

        for (final ItemStack itemStack : itemStacks) {
            finder.addInput(itemStack);
        }

    }
}
