package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.util.NBT.NBTEntries;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.EnergyStorageBlockEntity;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.storage.base.FilteringStorage;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluids;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

public final class ComputerCoreTileEntity extends EnergyStorageBlockEntity {
    private final SingleVariantStorage<FluidVariant> core_tank_chilled =
            MethodUtil.FluidStorageCreation.createFluidStorage(this, Fluids.WATER, NBTEntries.chilled);
    private final SingleVariantStorage<FluidVariant> core_tank_hot =
            MethodUtil.FluidStorageCreation.createFluidStorage(this,Fluids.WATER);
    public final Storage<FluidVariant> chilled_intake = FilteringStorage.insertOnlyOf(core_tank_chilled);
    public final Storage<FluidVariant> hot_outlet = FilteringStorage.extractOnlyOf(core_tank_hot);




    private boolean poweredOn;

    public ComputerCoreTileEntity(final BlockPos pos, final BlockState state) {
        super(ModBlockEntities.COMPUTER_CORE_TILE_ENTITY_BLOCK_ENTITY_TYPE, pos, state,90000000,
                10000,0);
    }

    public boolean isActive()
    {
        return poweredOn;
    }



    private void exchangeHeat()
    {
        try(final Transaction transaction = Transaction.openOuter()) {
            final long hotWater = core_tank_hot.insert(FluidVariant.of(Fluids.WATER), core_tank_chilled.amount,
                    transaction);
            core_tank_chilled.extract(FluidVariant.of(Fluids.WATER),hotWater,transaction);
            transaction.commit();
        }
    }

    public long getHotWaterAmount()
    {
        return core_tank_hot.amount;
    }

    public long getColdWaterAmount()
    {
        return core_tank_chilled.amount;
    }


    @Override
    public void tick() {
        if(!world.isClient)
        {
            if(poweredOn) {

                exchangeHeat();
            }
        }
    }


    @Override
    protected void writeNbt(final NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putLong("chilled_amount",core_tank_chilled.amount);
        nbt.putLong("hot_amount",core_tank_hot.amount);
        nbt.put("chilled_variant",core_tank_chilled.variant.toNbt());
        nbt.put("hot_variant",core_tank_hot.variant.toNbt());
        nbt.putBoolean("is_powered_on",poweredOn);
    }

    @Override
    public void readNbt(final NbtCompound nbt) {
        super.readNbt(nbt);
        core_tank_chilled.amount = nbt.getLong("chilled_amount");
        core_tank_hot.amount = nbt.getLong("hot_amount");
        core_tank_chilled.variant = FluidVariant.fromNbt(nbt.getCompound("chilled_variant"));
        core_tank_hot.variant = FluidVariant.fromNbt(nbt.getCompound("hot_variant"));
        poweredOn = nbt.getBoolean("is_powered_on");
    }
}
