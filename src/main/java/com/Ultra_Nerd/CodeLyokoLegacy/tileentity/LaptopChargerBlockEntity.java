package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.items.LaptopClass;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.EnergyStorageBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;

public class LaptopChargerBlockEntity extends EnergyStorageBlockEntity {

    public LaptopChargerBlockEntity(final BlockPos pos, final BlockState state) {
        super(ModTileEntities.LAPTOP_CHARGER_BLOCK_ENTITY_BLOCK_ENTITY, pos, state,1,90,10L,10L);
    }

    public void setItem(final ItemStack item)
    {
        setItem(item.copy(),0);
        item.decrement(1);

    }

    @Override
    public void tick() {
        if(world.isClient())
        {
            return;
        }
        if(getItems().get(0).isOf(ModItems.JEREMY_LAPTOP) && energyStorage.amount > 0)
        {
            final LaptopClass jeremyLaptop = (LaptopClass)getItems().get(0).getItem();
            if(jeremyLaptop.getStoredEnergy(getItems().get(0)) < jeremyLaptop.getEnergyCapacity()) {
                jeremyLaptop.setStoredEnergy(getItems().get(0), jeremyLaptop.getStoredEnergy(getItems().get(0)) + 1);
            }
            energyStorage.amount--;
        }
    }
}
