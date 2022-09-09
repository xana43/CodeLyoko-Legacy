package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.ReactorScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.LyokoInventoryBlock;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.base.SimpleEnergyStorage;

public final class ComputerReactorTileEntity extends BlockEntity implements LyokoInventoryBlock, SidedInventory, NamedScreenHandlerFactory {
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(2, ItemStack.EMPTY);

    public final SimpleEnergyStorage energyStorage = new SimpleEnergyStorage(4000, 100, 100) {
        @Override
        protected void onFinalCommit() {
            markDirty();
        }
    };
    private final PropertyDelegate energyAmount = new PropertyDelegate() {
        @Override
        public int get(final int index) {
            return switch (index) {
                case 0 -> (int) energyStorage.getAmount();
                default -> throw new IllegalStateException("Unexpected value: " + index);
            };
        }

        @Override
        public void set(final int index, final int value) {
            switch (index) {
                case 0 -> energyStorage.amount = value;
            }
        }

        @Override
        public int size() {
            return 1;
        }
    };
    ;

    public ComputerReactorTileEntity(final BlockPos pos, final BlockState state) {
        super(ModTileEntities.COMPUTER_REACTOR_TILE_ENTITY, pos, state);

    }

    public void tick() {

        if (world.isClient) {
            return;
        }
        final ItemStack uraniumFuel = getItems().get(0);
        final ItemStack uraniumWaste = getItems().get(1);
        if (uraniumFuel.isOf(ModItems.URANIUM_ISOTOPE235) && uraniumWaste.getCount() < 64) {
            uraniumFuel.decrement(1);

            if (uraniumWaste.isOf(Items.AIR)) {
                getItems().set(1, new ItemStack(ModItems.URANIUM_ISOTOPE238));
                energyStorage.amount += 2;
            } else if (uraniumWaste.isOf(ModItems.URANIUM_ISOTOPE238)) {
                uraniumWaste.increment(1);
                energyStorage.amount += 2;
            }
        } else if (uraniumFuel.isOf(ModBlocks.URANIUM_BLOCK_235.asItem()) && uraniumWaste.getCount() < 64) {
            uraniumFuel.decrement(1);

            if (uraniumWaste.isOf(Items.AIR)) {
                getItems().set(1, new ItemStack(ModItems.URANIUM_ISOTOPE238, 9));
                energyStorage.amount += 9;
            } else if (uraniumWaste.isOf(ModItems.URANIUM_ISOTOPE238)) {
                energyStorage.amount += 9;
                for (int i = 0; i < 9; i++) {
                    if (uraniumWaste.getCount() != 64) {
                        uraniumWaste.increment(1);
                    }
                }


            }
        }
        markDirty();
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(final int syncId, final PlayerInventory inv, final PlayerEntity player) {
        return new ReactorScreenHandler(syncId, inv, this, energyAmount);
    }

    @Override
    public void readNbt(final NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, items);
        energyStorage.amount = nbt.getLong("energy");
    }

    @Override
    protected void writeNbt(final NbtCompound nbt) {
        Inventories.writeNbt(nbt, items);
        nbt.putLong("energy", energyStorage.getAmount());
        super.writeNbt(nbt);
    }

    @Override
    public int[] getAvailableSlots(final Direction side) {
        return new int[0];
    }

    @Override
    public boolean canInsert(final int slot, final ItemStack stack, @Nullable final Direction dir) {
        return false;
    }

    @Override
    public boolean canExtract(final int slot, final ItemStack stack, final Direction dir) {
        return false;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
    }


}
