package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModFluids;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class UraniumWaste extends FlowingFluidBlock {
    private static final int timer = 200;

    public UraniumWaste(Supplier<? extends FlowingFluid> supplier) {
        super(supplier, Block.Properties.create(Material.LAVA)
                .noDrops()
                .hardnessAndResistance(100, 100)
                .doesNotBlockMovement()
                .lightValue(5)
                .tickRandomly()
        );
    }


    @Override
    public void onBlockAdded(@Nonnull BlockState state, World worldIn, BlockPos pos, @Nonnull BlockState oldState, boolean isMoving) {
        if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())) == Blocks.WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()), ModFluids.URANIUM.get().getDefaultState());
        }
        if (worldIn.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1)) == Blocks.WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1), ModFluids.URANIUM.get().getDefaultState());
        }


    }


    @Override
    public void onEntityCollision(@Nonnull BlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos, @Nonnull Entity entityIn) {
        if (entityIn instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entityIn;
            if (!livingEntity.isPotionActive(Effects.NAUSEA) || !livingEntity.isPotionActive(Effects.POISON)) {
                livingEntity.addPotionEffect(new EffectInstance(Effects.POISON, 10, 3, false, false, false));
                livingEntity.addPotionEffect(new EffectInstance(Effects.NAUSEA, 255, 255, false, false, false));
            }
        }
    }
}
