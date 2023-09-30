package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.items.LaptopClass;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.EnergyStorageBlockEntityInventory;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;

public final class LaptopChargerBlockEntityInventory extends EnergyStorageBlockEntityInventory {
    public LaptopChargerBlockEntityInventory(final BlockPos pos, final BlockState state) {
        super(ModBlockEntities.LAPTOP_CHARGER_BLOCK_ENTITY_BLOCK_ENTITY, pos, state, 1, 9000, Long.valueOf(10L), Long.valueOf(10L));
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
        world.updateListeners(pos,getCachedState(),getCachedState(), Block.NOTIFY_LISTENERS);
        if (getItems().get(0).isOf(ModItems.JEREMY_LAPTOP)) {
            final LaptopClass jeremyLaptop = (LaptopClass) getStack(0).getItem();

            try(final Transaction transaction = Transaction.openOuter())
            {
                final long extractedEnergy =
                        energyStorage.extract(jeremyLaptop.getEnergyMaxInput(getStack(0)),transaction);

                jeremyLaptop.setStoredEnergy(getStack(0),extractedEnergy);
                transaction.commit();
            }
        }

    }
}
