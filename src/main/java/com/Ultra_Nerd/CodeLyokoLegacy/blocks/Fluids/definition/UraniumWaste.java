package com.Ultra_Nerd.CodeLyokoLegacy.blocks.Fluids.definition;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModFluids;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public final class UraniumWaste extends FluidBlock {
    public UraniumWaste() {
        super(ModFluids.STILL_URANIUM, FabricBlockSettings.copy(Blocks.LAVA));
    }


    @Override
    public void onPlaced(final World world, final BlockPos pos, final BlockState state, @Nullable final LivingEntity placer, final ItemStack itemStack) {
        if (world.getBlockState(
                new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())) == Blocks.WATER.getDefaultState()) {
            world.setBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()),
                    ModFluids.STILL_URANIUM.getDefaultState().getBlockState());
        }
        if (world.getBlockState(
                new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1)) == Blocks.WATER.getDefaultState()) {
            world.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1),
                    ModFluids.STILL_URANIUM.getDefaultState().getBlockState());
        }
    }


    @Override
    public void onEntityCollision(final BlockState state, final World world, final BlockPos pos, final Entity entity) {
        if (entity instanceof LivingEntity livingEntity) {
            if (!livingEntity.hasStatusEffect(StatusEffects.NAUSEA) || !livingEntity.hasStatusEffect(
                    StatusEffects.POISON)) {
                livingEntity.addStatusEffect(
                        new StatusEffectInstance(StatusEffects.POISON, 10, 3, false, false, false));
                livingEntity.addStatusEffect(
                        new StatusEffectInstance(StatusEffects.NAUSEA, 255, 255, false, false, false));
            }
        }
    }


}
