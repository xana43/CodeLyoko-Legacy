package com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers;


import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities.LithographyBlockEntityInventoryT2;
import com.Ultra_Nerd.CodeLyokoLegacy.Slots.LithographyInputslot;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.common.ModRecipes;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.common.ModScreenHandlers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractRecipeScreenHandler;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.slot.FurnaceOutputSlot;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;

public final class LithographyScreenHandlerT2 extends AbstractRecipeScreenHandler<Inventory> {
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    private final RecipeType<? extends AbstractCookingRecipe> recipeType;

    private final World world;
    public LithographyScreenHandlerT2(final int syncId, final PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(5), new ArrayPropertyDelegate(6));
    }

    public LithographyScreenHandlerT2(final int syncId, final PlayerInventory playerInventory, final Inventory inventory, final PropertyDelegate propertyDelegate) {
        super(ModScreenHandlers.LITHOGRAPHY_SCREEN_HANDLER_TYPE, syncId);
        this.recipeType = ModRecipes.RecipeTypes.LITHOGRAPHY_RECIPE_RECIPE_TYPE;
        checkSize(inventory, 5);
        checkDataCount(propertyDelegate,6);
        this.inventory = inventory;
        this.propertyDelegate = propertyDelegate;
        this.world = playerInventory.player.getWorld();
        int row;
        int column;
        //reactor inventory
        for(int i = 0; i < 3; ++i)
        {
        this.addSlot(new LithographyInputslot(inventory, i, 44, 33 * i));
        }
        this.addSlot(new LithographyInputslot(inventory,3,0,33));

        this.addSlot(new FurnaceOutputSlot(playerInventory.player, inventory, 4, 110, 33));
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
        getSlot(2).setStackNoCallbacks(ItemStack.EMPTY);
        getSlot(3).setStackNoCallbacks(ItemStack.EMPTY);
        //getSlot(3).setStackNoCallbacks(ItemStack.EMPTY);
    }

    public static boolean isValidMaterial(final ItemStack stack)
    {
        return LithographyBlockEntityInventoryT2.slotValidInput(stack.getItem());
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
        return 4;
    }

    @Override
    public RecipeBookCategory getCategory() {
        return null;
    }

    @Override
    public boolean canInsertIntoSlot(final int index) {
        return index != 4;
    }

    public int getEnergyAmount() {
        return propertyDelegate.get(0);
    }
    

    @Override
    public ItemStack quickMove(final PlayerEntity player, final int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        final Slot slot2 = this.slots.get(slot);
        if (slot2.hasStack()) {
            final ItemStack itemStack2 = slot2.getStack();
            itemStack = itemStack2.copy();
            if (slot == 4) {
                if (!this.insertItem(itemStack2, 4, 39, true)) {
                    return ItemStack.EMPTY;
                }
                slot2.onQuickTransfer(itemStack2, itemStack);
            } else if (slot != 0 && slot != 1 && slot != 2 && slot != 3) {
                if (isProcessable(itemStack2)) {
                    if (!this.insertItem(itemStack2, 0, 3, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (slot >= 4 && slot < 30) {
                    if (!this.insertItem(itemStack2, 30, 38, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (slot >= 30 && slot < 39 && !this.insertItem(itemStack2, 4, 30, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(itemStack2, 4, 39, false)) {
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
    private boolean isProcessable(final ItemStack stack)
    {
        return world.getRecipeManager().getFirstMatch(recipeType,new SimpleInventory(stack),world).isPresent();
    }
    public int getReactionProgress()
    {
        final int irradiationTime = propertyDelegate.get(3);
        final int irradiationTimeTotal = propertyDelegate.get(4);
        return irradiationTimeTotal != 0 && irradiationTime != 0 ? irradiationTime * 24 / irradiationTimeTotal : 0;
    }

    public int getEnergyCapacity()
    {
        return propertyDelegate.get(5);
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