package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.ReactorScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.EnergyStorageBlockEntityInventory;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.LyokoInventoryBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public final class ComputerReactorTileEntityInventory extends EnergyStorageBlockEntityInventory implements LyokoInventoryBlock, NamedScreenHandlerFactory {


    private final PropertyDelegate energyAmount = new PropertyDelegate() {
        @Override
        public int get(final int index) {
            return switch (index) {
                case 0 -> (int) energyStorage.getAmount();
                default -> throw new IllegalStateException("Unexpected value: " + index);
            };
        }

        @edu.umd.cs.findbugs.annotations.SuppressFBWarnings("SF_SWITCH_NO_DEFAULT")
        @Override
        public void set(final int index, final int value) {
            if (index == 0) {
                energyStorage.amount = value;
            }
        }

        @Override
        public int size() {
            return 1;
        }
    };


    public ComputerReactorTileEntityInventory(final BlockPos pos, final BlockState state) {
        super(ModBlockEntities.COMPUTER_REACTOR_TILE_ENTITY, pos, state, 2, 4000, null, null);

    }

    @Override
    public void tick() {
        if (world.isClient()) {
            return;
        }
        final ItemStack uraniumFuel = getStack(0);
        final ItemStack uraniumWaste = getStack(1);
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
    public @NotNull ScreenHandler createMenu(final int syncId, final PlayerInventory inv, final PlayerEntity player) {
        return new ReactorScreenHandler(syncId, inv, this, energyAmount);
    }


    @Override
    public Text getDisplayName() {
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
    }


}
