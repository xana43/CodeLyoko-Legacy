package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities;

import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.LithographyScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModRecipes;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.EnergyStorageBlockEntityInventory;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.LyokoInventoryBlock;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.*;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LithographyBlockEntityInventoryT2 extends EnergyStorageBlockEntityInventory implements LyokoInventoryBlock, NamedScreenHandlerFactory, RecipeInputProvider {
    private int lithographyTime;
private int fuelMass;
private int manufacturingTime;
private int manufacturingTimeTotal;
private final Object2IntOpenHashMap<Identifier> recipesUsed = new Object2IntOpenHashMap<>();
private final RecipeManager.MatchGetter<Inventory,? extends AbstractCookingRecipe> matchGetter;


    private final PropertyDelegate energyAmount = new PropertyDelegate() {
        @Override
        public int get(final int index) {
            return switch (index) {
                case 0 -> (int) energyStorage.getAmount();
                case 1 -> lithographyTime;
                case 2 -> fuelMass;
                case 3 -> manufacturingTime;
                case 4 -> manufacturingTimeTotal;
                case 5 -> (int)energyStorage.getCapacity();
                default -> 0;
            };

        }

        @Override
        public void set(final int index, final int value) {
            switch (index) {
             case 0 ->  energyStorage.amount = value;
             case 1 -> lithographyTime = value;
             case 2 -> fuelMass = value;
             case 3 -> manufacturingTime = value;
             case 4 -> manufacturingTimeTotal = value;
                default -> throw new IllegalArgumentException("unexpected value:"+value+" at index:"+index);
            }
        }

        @Override
        public int size() {
            return 6;
        }
    };

    @Override
    protected void writeNbt(final NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("LithographyTime", lithographyTime);
        nbt.putInt("ManufacturingTime", manufacturingTime);
        nbt.putInt("ManufacturingTimeTotal", manufacturingTimeTotal);
        final NbtCompound nbtCompound = new NbtCompound();
        recipesUsed.forEach((identifier, integer) -> nbtCompound.putInt(identifier.toString(), integer));
        nbt.put("RecipesUsed",nbtCompound);
    }

    @Override
    public void readNbt(final NbtCompound nbt) {
        super.readNbt(nbt);
        lithographyTime = nbt.getInt("LithographyTime");
        manufacturingTime = nbt.getInt("ManufacturingTime");
        manufacturingTimeTotal = nbt.getInt("ManufacturingTimeTotal");
        fuelMass = getFuelTime();
        final NbtCompound nbtCompound = nbt.getCompound("RecipesUsed");
        for (final String string : nbtCompound.getKeys()) {
            recipesUsed.put(new Identifier(string), nbtCompound.getInt(string));
        }

    }

    public LithographyBlockEntityInventoryT2(final BlockPos pos, final BlockState state) {
        super(ModBlockEntities.LITHOGRAPHY_BLOCK_ENTITY_TYPE, pos, state, 5, 400000, 300L, 0L);
        matchGetter = RecipeManager.createCachedMatchGetter(ModRecipes.RecipeTypes.LITHOGRAPHY_RECIPE_RECIPE_TYPE);
    }

    @Override
    public @NotNull ScreenHandler createMenu(final int syncId, final PlayerInventory inv, final PlayerEntity player) {
    return new LithographyScreenHandler(syncId, inv, this, energyAmount);
    }

    private boolean isManufacturing()
    {
        return this.lithographyTime > 0;
    }
    @Override
    public Text getDisplayName() {
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
    }


    @Override
    public void tick() {
        boolean manufacturing = false;
        if(isManufacturing())
        {
            --lithographyTime;
        }
        final ItemStack itemStack1 = getStack(0);
        boolean isCurrentItemStackEmpty1 = !getStack(0).isEmpty();
        boolean isGottenItemStackEmpty1 = !itemStack1.isEmpty();
        final ItemStack itemStack2 = getStack(1);
        boolean isCurrentItemStackEmpty2 = !getStack(1).isEmpty();
        boolean isGottenItemStackEmpty2 = !itemStack2.isEmpty();
        final ItemStack itemStack3 = getStack(2);
        boolean isCurrentItemStackEmpty3 = !getStack(2).isEmpty();
        boolean isGottenItemStackEmpty3 = !itemStack3.isEmpty();
        final ItemStack itemStack4 = getStack(3);
        boolean isCurrentItemStackEmpty4 = !getStack(3).isEmpty();
        boolean isGottenItemStackEmpty4 = !itemStack4.isEmpty();
        if(isManufacturing() || isCurrentItemStackEmpty4 && isGottenItemStackEmpty4 && isCurrentItemStackEmpty1 && isGottenItemStackEmpty1 && isCurrentItemStackEmpty2 && isGottenItemStackEmpty2 && isCurrentItemStackEmpty3 && isGottenItemStackEmpty3/*&& energyStorage.amount > 0*/)
        {
            RecipeEntry<?> recipe;
            if(isCurrentItemStackEmpty1 && isCurrentItemStackEmpty2 && isCurrentItemStackEmpty3 && isCurrentItemStackEmpty4)
            {
                recipe = matchGetter.getFirstMatch(this,world).orElse(null);
            }
            else {
                recipe = null;
            }



            final int maxCount = getMaxCountPerStack();
            if(!isManufacturing() && canAcceptRecipeOutput(world.getRegistryManager(),recipe,itemStacks,maxCount))
            {
                    lithographyTime = getFuelTime();
                    fuelMass = lithographyTime;
                    if (isManufacturing()) {
                        manufacturing = true;
                        /*if (isGottenItemStackEmpty1 && isGottenItemStackEmpty2 && isGottenItemStackEmpty3) {
                            final Item item = itemStack1.getItem();
                            final Item item2 = itemStack2.getItem();
                            final Item item3 = itemStack3.getItem();
                            itemStack1.decrement(1);
                            itemStack2.decrement(1);
                            itemStack3.decrement(1);
                            if (itemStack1.isEmpty() && itemStack2.isEmpty() && itemStack3.isEmpty()) {

                                final Item remainderItem = item.getRecipeRemainder();
                                final Item remainderItem2 = item2.getRecipeRemainder();
                                final Item remainderItem3 = item3.getRecipeRemainder();
                                if (remainderItem != null && remainderItem2 != null && remainderItem3 != null) {
                                    setStack(3, new ItemStack(remainderItem));
                                }
                                else {
                                    setStack(3,ItemStack.EMPTY);
                                 }

                            }
                        }*/
                    }

            }
            if(isManufacturing() && canAcceptRecipeOutput(world.getRegistryManager(),recipe,itemStacks,maxCount))
            {
                ++manufacturingTime;
                try(final Transaction transaction = Transaction.openOuter()) {
                    if(slotValidInput(getStack(0).getItem()) && slotValidInput(getStack(1).getItem()) && slotValidInput(getStack(2).getItem())) {
                       energyStorage.extract(30, transaction);
                   }
                   transaction.commit();
                }
                if(manufacturingTime == manufacturingTimeTotal)
                {
                    manufacturingTime = 0;
                    manufacturingTimeTotal = getCookTime(world,this);
                    if(craftRecipe(world.getRegistryManager(),recipe,itemStacks,maxCount))
                    {
                        setLastRecipe(recipe);
                    }
                    manufacturing = true;
                }
            }
            else {
                manufacturingTime = 0;
            }
        } else if (manufacturingTime > 0) {
            manufacturingTime = MathHelper.clamp(manufacturingTime - 2, 0, manufacturingTimeTotal);
        }
        if(manufacturing)
        {
            markDirty();
        }
    }
    public static boolean slotValidInput(final Item item)
    {
        return item == ModItems.SILICON_WAFER || item == Items.GOLD_INGOT || item == ModItems.CPU_DIE_ARM || item == ModItems.CPU_DIE_x86 || item == ModItems.URANIUM_SILICON_PLATE || item == Items.COPPER_INGOT || item == Items.GOLD_NUGGET;
    }
    @Override
    public boolean canPlayerUse(final PlayerEntity player) {
        return Inventory.canPlayerUse(this,player);
    }

    private static boolean canAcceptRecipeOutput(final DynamicRegistryManager registryManager,
            final @Nullable RecipeEntry<?> recipe,final DefaultedList<ItemStack> slots,final int count) {
        if (!slots.get(0).isEmpty() && !slots.get(1).isEmpty() && !slots.get(2).isEmpty()  && !slots.get(3).isEmpty()&& recipe != null) {
            final ItemStack itemStack = recipe.value().getResult(registryManager);
            if (itemStack.isEmpty()) {
                return false;
            } else {
                final ItemStack itemStack2 = slots.get(4);
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
            final ItemStack itemStack2 = recipe.value().getResult(registryManager);
            final ItemStack itemStack3 = slots.get(4);
            if (itemStack3.isEmpty()) {
                slots.set(4, itemStack2.copy());
            } else if (itemStack3.isOf(itemStack2.getItem())) {
                itemStack3.increment(1);
            }
            final ItemStack[] inputItemSlots = {slots.get(0), slots.get(1),slots.get(2),slots.get(3)};
            for(final ItemStack stack : inputItemSlots)
            {
                if(stack.isOf(Items.GOLD_NUGGET))
                {
                    stack.decrement(2);
                } else {
                    stack.decrement(1);
                }
            }
            return true;
        } else {
            return false;
        }
    }
    private static int getFuelTime()
    {
        return MethodUtil.TickConversion.secondsToTicks(120);
    }
    
    @Override
    public boolean canInsert(final int slot, final ItemStack stack, final @Nullable Direction dir) {
        return isValid(slot, stack);
    }



    @Override
    public void setStack(final int slot, final ItemStack stack) {
        final ItemStack itemStack = itemStacks.get(slot);
        final boolean canSet = !stack.isEmpty() && ItemStack.canCombine(itemStack,stack);
        itemStacks.set(slot, stack);
        if(stack.getCount() > getMaxCountPerStack())
        {
            stack.setCount(getMaxCountPerStack());
        }
        if((slot == 0 || slot == 1 || slot == 2 || slot == 3) && !canSet)
        {
            manufacturingTimeTotal = getCookTime(world,this);
            manufacturingTime = 0;
            markDirty();
        }
    }

    @Override
    public boolean isValid(final int slot, final ItemStack stack) {
        if(slot == 4)
        {
            return false;
        } else return slotValidInput(stack.getItem());
    }



    private static int getCookTime(final World world,final LithographyBlockEntityInventoryT2 reactorTileEntityInventory)
    {
        return reactorTileEntityInventory.matchGetter.getFirstMatch(reactorTileEntityInventory, world).map(recipeEntry -> recipeEntry.value().getCookingTime()).orElse(200);
    }
    public void setLastRecipe(final RecipeEntry<?> recipe)
    {
        if(recipe != null)
        {
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
