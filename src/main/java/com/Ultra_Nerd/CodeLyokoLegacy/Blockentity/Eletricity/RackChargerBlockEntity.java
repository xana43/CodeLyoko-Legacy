package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Eletricity;

import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.ElectricitySystemHandlers.RackChargerHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.EnergyStorageBlockEntityInventory;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.EnergyStorageUtil;
import team.reborn.energy.api.base.SimpleEnergyItem;

public final class RackChargerBlockEntity extends EnergyStorageBlockEntityInventory implements NamedScreenHandlerFactory {
    private int[] tierArray = {0,0,0};
    private final PropertyDelegate propertyDelegate = new PropertyDelegate() {
        @Override
        public int get(final int index) {
            return switch (index)
            {
                case 0 -> tierArray[0];
                case 1 -> tierArray[1];
                case 2 -> tierArray[2];

                default -> throw new IllegalStateException("Unexpected value: " + index);
            };
        }

        @Override
        public void set(final int index, final int value) {
            switch (index)
            {
                case 0 -> tierArray[0] = value;
                case 1 -> tierArray[1] = value;
                case 2 -> tierArray[2] = value;
            }
        }

        @Override
        public int size() {
            return 3;
        }
    };
    private static final String TIER_ARRAY = "tier_array";
    public RackChargerBlockEntity(final BlockPos pos, final BlockState state) {
        super(ModBlockEntities.RACK_CHARGER_BLOCK_ENTITY, pos, state,6,9000, 1000, 1000);
    }

    @Override
    protected void writeNbt(final NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putIntArray(TIER_ARRAY,tierArray);
    }

    @Override
    public void readNbt(final NbtCompound nbt) {
        super.readNbt(nbt);
        tierArray = nbt.getIntArray(TIER_ARRAY);
    }
    public void changeSlotTier(final int slot,final int tier)
    {
        tierArray[slot] = tier;
    }

    @Override
    public void tick() {
        if(!itemStacks.isEmpty())
        {
            for(final ItemStack stack : itemStacks)
            {
                if(!stack.isEmpty() && EnergyStorageUtil.isEnergyStorage(stack))
                {
                    final SimpleEnergyItem energyItem = (SimpleEnergyItem) stack.getItem();
                    try(final Transaction transaction = Transaction.openOuter()) {
                        final long extractedEnergy = energyStorage.extract(energyItem.getEnergyMaxInput(stack),transaction);
                        long energyToInsert = energyItem.getStoredEnergy(stack) + extractedEnergy;
                        if(energyToInsert >=0 && energyToInsert <= energyItem.getEnergyCapacity(stack)) {
                            energyItem.setStoredEnergy(stack, energyToInsert);
                        } else if (energyToInsert > energyItem.getEnergyCapacity(stack)) {
                            energyToInsert = energyItem.getEnergyCapacity(stack);
                            energyItem.setStoredEnergy(stack,energyToInsert);
                        }
                        transaction.commit();
                    }

                }
            }
        }
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(final int syncId, final PlayerInventory playerInventory, final PlayerEntity player) {
        return new RackChargerHandler(syncId,playerInventory,this,propertyDelegate);
    }
}
