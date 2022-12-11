package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.items.LaptopClass;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.EnergyStorageBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;

public final class LaptopChargerBlockEntity extends EnergyStorageBlockEntity {
    public LaptopChargerBlockEntity(final BlockPos pos, final BlockState state) {
        super(ModTileEntities.LAPTOP_CHARGER_BLOCK_ENTITY_BLOCK_ENTITY, pos, state, 1, 90, 10L, 10L);
    }

    public void setItem(final ItemStack item) {
        setItem(item.copy(), 0);
        item.decrement(1);
        update();
    }

    @Override
    public void tick() {
        if (world.isClient()) {
            return;
        }
        if (getItems().get(0).isOf(ModItems.JEREMY_LAPTOP)) {

            final LaptopClass jeremyLaptop = (LaptopClass) getStack(0).getItem();
            if (jeremyLaptop.getStoredEnergy(
                    getStack(0)) < jeremyLaptop.getEnergyCapacity() && energyStorage.amount > 0) {
                jeremyLaptop.setStoredEnergy(getStack(0), jeremyLaptop.getStoredEnergy(getStack(0)) + 10);
                update();
            }
            energyStorage.amount--;
        }
    }
}
