package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities.FluidSystem;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.MethodUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.NBT.NBTEntries;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.blockentity.EnergyStorageBlockEntity;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.storage.base.FilteringStorage;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.component.ComponentChanges;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.fluid.Fluids;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public final class ComputerFluidCoolerBlockEntity extends EnergyStorageBlockEntity {
    private final SingleVariantStorage<FluidVariant> hot_tank = MethodUtil.FluidStorageCreation.createFluidStorage(this,Fluids.WATER);
    private final SingleVariantStorage<FluidVariant> cold_tank =
            MethodUtil.FluidStorageCreation.createFluidStorage(this,FluidVariant.of(Fluids.WATER, ComponentChanges.builder().add(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(NBTEntries.chilled)).build()));
    private double temperature = 27;
    private final Storage<FluidVariant> hot_outlet = FilteringStorage.insertOnlyOf(hot_tank);
    private final Storage<FluidVariant> cold_intake = FilteringStorage.extractOnlyOf(cold_tank);
    public ComputerFluidCoolerBlockEntity(final BlockPos pos, final BlockState state) {
        super(ModBlockEntities.COOLER_BLOCK_ENTITY_TYPE, pos, state, 1000,100,100);
    }

    public Storage<FluidVariant> getCold_intake() {
        return cold_intake;
    }

    public Storage<FluidVariant> getHot_outlet() {
        return hot_outlet;
    }
    private void cool()
    {
        if(temperature > -273)
        {
            final double Ta = world.getBiome(pos).value().getTemperature() + 273.15;
            final double Tin = temperature+273.15;
            final double result = Ta+(Tin - Ta)*Math.exp(-900 * 100);
            temperature -= (result - 273.15);
            useEnergy((long)(result - 273.15));
            //CodeLyokoMain.LOG.debug("cooled:" + (result - 273.15));
            //CodeLyokoMain.LOG.info("cooled:" + (result - 273.15));
        }
    }

    @Override
    protected void writeNbt(final NbtCompound nbt,final RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt,registryLookup);
        SingleVariantStorage.writeNbt(hot_tank,FluidVariant.CODEC,nbt,registryLookup);
        SingleVariantStorage.writeNbt(cold_tank,FluidVariant.CODEC,nbt,registryLookup);
        nbt.putDouble("temperature",temperature);

    }

    @Override
    public void readNbt(final NbtCompound nbt,RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt,registryLookup);
        SingleVariantStorage.readNbt(hot_tank,FluidVariant.CODEC,FluidVariant::blank,nbt,registryLookup);
        SingleVariantStorage.readNbt(cold_tank,FluidVariant.CODEC,FluidVariant::blank,nbt,registryLookup);
        temperature = nbt.getDouble("temperature");
    }

    @Override
    public void tick() {
        if(energyStorage.amount > 0) {
            for (final Direction dir : Direction.values()) {
                if (world.getBlockState(pos.offset(dir)).getBlock() == ModBlocks.COMPUTER_COOLING_BLOCK) {
                    cool();
                }
            }
            if (temperature > 100 && temperature < 1000) {
                world.addParticle(ParticleTypes.SMOKE, pos.getX(), pos.getY() + 0.7, pos.getZ(), 0, 0, 0);
            } else if (temperature > 1000 && temperature < 3000) {
                world.addParticle(ParticleTypes.LARGE_SMOKE, pos.getX(), pos.getY() + 0.7, pos.getZ(), 0, 0, 0);
            } else if (temperature > 3000) {
                for (final Direction dir : Direction.values()) {
                    if (world.getBlockState(pos.offset(dir)).getBlock() == Blocks.AIR) {
                        world.setBlockState(pos.offset(dir), Blocks.FIRE.getDefaultState());
                    }
                }
            }
            try (final Transaction transaction = Transaction.openOuter()) {
                final long hotWaterCooled = hot_tank.extract(FluidVariant.of(Fluids.WATER), FluidConstants.BLOCK,
                        transaction);
                cold_tank.insert(FluidVariant.of(Fluids.WATER, ComponentChanges.builder().add(DataComponentTypes.CUSTOM_DATA,NbtComponent.of(NBTEntries.chilled)).build()), hotWaterCooled, transaction);
                if (hotWaterCooled > 0) {
                    temperature += 100;
                }
                transaction.commit();
            }

        }
    }
}
