package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModFluids;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.data.SoundDefinition;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class UraniumWaste extends LiquidBlock {


    public UraniumWaste(Supplier<? extends FlowingFluid> supplier) {
        super(supplier, BlockBehaviour.Properties.of(Material.LAVA)
                .noDrops()
                .strength(100, 100)
                .noCollission()

        );
    }


    @Override
    public void onPlace(@Nonnull BlockState state, Level worldIn, BlockPos pos, @Nonnull BlockState oldState, boolean isMoving) {
        if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())) == Blocks.WATER.defaultBlockState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()), ModFluids.URANIUM.get().defaultBlockState());
        }
        if (worldIn.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1)) == Blocks.WATER.defaultBlockState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1), ModFluids.URANIUM.get().defaultBlockState());
        }


    }





    @Override
    public void entityInside(@Nonnull BlockState state, @Nonnull Level worldIn, @Nonnull BlockPos pos, @Nonnull Entity entityIn) {
        if (entityIn instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entityIn;
            if (!livingEntity.hasEffect(MobEffects.CONFUSION) || !livingEntity.hasEffect(MobEffects.POISON)) {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 10, 3, false, false, false));
                livingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 255, 255, false, false, false));
            }
        }
    }
}
