package com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers;


import com.Ultra_Nerd.CodeLyokoLegacy.Slots.ReactorInputSlot;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModRecipes;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModScreenHandlers;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities.ComputerReactorTileEntityInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.FurnaceOutputSlot;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;

public final class ReactorScreenHandler extends AbstractRecipeScreenHandler<Inventory> {
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    private final RecipeType<? extends AbstractCookingRecipe> recipeType;

    private final World world;
    public ReactorScreenHandler(final int syncId, final PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(2), new ArrayPropertyDelegate(8));
    }

    public ReactorScreenHandler(final int syncId, final PlayerInventory playerInventory, final Inventory inventory, final PropertyDelegate propertyDelegate) {
        super(ModScreenHandlers.COMPUTER_REACTOR_SCREEN_HANDLER, syncId);
        this.recipeType = ModRecipes.RecipeTypes.REACTOR_RECIPE_TYPE;
        checkSize(inventory, 2);
        checkDataCount(propertyDelegate,8);
        this.inventory = inventory;
        this.propertyDelegate = propertyDelegate;
        this.world = playerInventory.player.getWorld();
        int row;
        int column;
        //reactor inventory
        this.addSlot(new ReactorInputSlot(inventory, 0, 44, 33));
        this.addSlot(new FurnaceOutputSlot(playerInventory.player, inventory, 1, 110, 33));
        //player inventory
        for (row = 0; row < 3; ++row) {
            for (column = 0; column < 9; ++column) {
                this.addSlot(new Slot(playerInventory, column + row * 9 + 9, 8 + column * 18, 84 + row * 18));
            }
        }
        //player hotbar
        for (row = 0; row < 9; ++row) {
            this.addSlot(new Slot(playerInventory, row, 8 + row * 18, 142));
        }
        addProperties(propertyDelegate);
    }
    @Override
    public void clearCraftingSlots()
    {
        getSlot(0).setStackNoCallbacks(ItemStack.EMPTY);
        getSlot(1).setStackNoCallbacks(ItemStack.EMPTY);
    }



    @Override
    public void populateRecipeFinder(final RecipeMatcher finder) {
        if(inventory instanceof final RecipeInputProvider recipeInputProvider)
        {
            recipeInputProvider.provideRecipeInputs(finder);
        }
    }


    @Override
    public boolean matches(final RecipeEntry<? extends Recipe<Inventory>> recipe) {
        return recipe.value().matches(inventory,world);
    }


    @Override
    public int getCraftingResultSlotIndex()
    {
        return 1;
    }
    @Override
    public int getCraftingWidth()
    {
        return 1;
    }
    @Override
    public int getCraftingHeight()
    {
        return 1;
    }
    @Override
    public int getCraftingSlotCount()
    {
        return 2;
    }

    @Override
    public RecipeBookCategory getCategory() {
        return null;
    }

    @Override
    public boolean canInsertIntoSlot(final int index) {
        return index != 1;
    }

    public int getEnergyAmount() {
        return propertyDelegate.get(0);
    }
    public static boolean isFuel(final ItemStack stack)
    {
        return ComputerReactorTileEntityInventory.canUseAsFuel(stack);
    }

    @Override
    public ItemStack quickMove(final PlayerEntity player, final int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        final Slot slot2 = this.slots.get(slot);
        if (slot2.hasStack()) {
            final ItemStack itemStack2 = slot2.getStack();
            itemStack = itemStack2.copy();
            if (slot == 2) {
                if (!this.insertItem(itemStack2, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }

                slot2.onQuickTransfer(itemStack2, itemStack);
            } else if (slot != 1 && slot != 0) {
                if (isReactable(itemStack2)) {
                    if (!this.insertItem(itemStack2, 0, 2, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (ReactorScreenHandler.isFuel(itemStack2)) {
                    if (!this.insertItem(itemStack2, 0, 2, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (slot >= 3 && slot < 30) {
                    if (!this.insertItem(itemStack2, 30, 38, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (slot >= 30 && slot < 39 && !this.insertItem(itemStack2, 3, 30, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(itemStack2, 3, 39, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot2.setStack(ItemStack.EMPTY);
            } else {
                slot2.markDirty();
            }

            if (itemStack2.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot2.onTakeItem(player, itemStack2);
        }

        return itemStack;
    }
    private boolean isReactable(final ItemStack stack)
    {
        return world.getRecipeManager().getFirstMatch(recipeType,new SimpleInventory(stack),world).isPresent();
    }
    public int getReactionProgress()
    {
        final int irradiationTime = propertyDelegate.get(3);
        final int irradiationTimeTotal = propertyDelegate.get(4);
        return irradiationTimeTotal != 0 && irradiationTime != 0 ? irradiationTime * 24 / irradiationTimeTotal : 0;
    }
    public int getWasteAmount()
    {
        return propertyDelegate.get(5);
    }
    public int getWasteCapacity()
    {
        return propertyDelegate.get(6);
    }
    public int getEnergyCapacity()
    {
        return propertyDelegate.get(7);
    }
    public int getUraniumProgress()
    {
        int fuelMass = propertyDelegate.get(2);
        if(fuelMass == 0)
        {
            fuelMass = 200;
        }
        return propertyDelegate.get(1) * 13 / fuelMass;
    }
    public boolean isReacting()
    {
        return propertyDelegate.get(1) > 0;
    }
    @Override
    public boolean canUse(final PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }


}