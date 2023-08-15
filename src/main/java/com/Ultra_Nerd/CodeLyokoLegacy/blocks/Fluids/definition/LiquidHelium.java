package com.Ultra_Nerd.CodeLyokoLegacy.blocks.Fluids.definition;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModFluids;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.security.SecureRandom;
import java.util.Random;

public final class LiquidHelium extends FluidBlock {
    public LiquidHelium() {
        super(ModFluids.STILL_LIQUID_HELIUM, FabricBlockSettings.copy(Blocks.WATER));
    }

    private static final SecureRandom random = new SecureRandom();
    @Override
    public void onEntityCollision(final BlockState state, final World world, final BlockPos pos, final Entity entity) {
        if (entity instanceof final LivingEntity livingEntity) {

            livingEntity.handSwingProgress = 0;
            livingEntity.inPowderSnow = true;
            livingEntity.damage(entity.getWorld().getDamageSources().freeze(), random.nextInt(3));
            if (livingEntity instanceof final PlayerEntity player) {
                if (player.isCreative()) {
                    player.inPowderSnow = false;
                }
            }

        }
    }


    @Override
    public void onBlockAdded(final BlockState state, final World worldIn, final BlockPos pos, final BlockState oldState, final boolean notify) {
        if (worldIn.getBlockState(
                new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())) == Blocks.WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()),
                    Blocks.BLUE_ICE.getDefaultState());
        }
        if (worldIn.getBlockState(
                new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())) == Blocks.WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()),
                    Blocks.BLUE_ICE.getDefaultState());
        }
        if (worldIn.getFluidState(
                new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())) == Fluids.FLOWING_WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()),
                    Blocks.BLUE_ICE.getDefaultState());
        }
        if (worldIn.getBlockState(
                new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())) == Blocks.LAVA.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()),
                    Blocks.DIAMOND_BLOCK.getDefaultState());
        }
        if (worldIn.getBlockState(
                new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())) == Blocks.LAVA.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()),
                    Blocks.DIAMOND_BLOCK.getDefaultState());
        }
        if (worldIn.getFluidState(
                new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())) == Fluids.FLOWING_LAVA.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()),
                    Blocks.OBSIDIAN.getDefaultState());
        }
        if (worldIn.getBlockState(
                new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1)) == Blocks.WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1),
                    Blocks.BLUE_ICE.getDefaultState());
        }
        if (worldIn.getBlockState(
                new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1)) == Blocks.WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1),
                    Blocks.BLUE_ICE.getDefaultState());
        }
        if (worldIn.getBlockState(
                new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1)) == Blocks.WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1),
                    Blocks.BLUE_ICE.getDefaultState());
        }
        if (worldIn.getBlockState(
                new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ())) == Blocks.WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()),
                    Blocks.BLUE_ICE.getDefaultState());
        }
        if (worldIn.getBlockState(
                new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ())) == Blocks.WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()),
                    Blocks.BLUE_ICE.getDefaultState());
        }
        if (worldIn.getBlockState(
                new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1)) == Blocks.WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1),
                    Blocks.BLUE_ICE.getDefaultState());
        }
        if (worldIn.getBlockState(
                new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1)) == Blocks.LAVA.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1),
                    Blocks.BLUE_ICE.getDefaultState());
        }
        if (worldIn.getBlockState(
                new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1)) == Blocks.LAVA.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1),
                    Blocks.BLUE_ICE.getDefaultState());
        }
        if (worldIn.getBlockState(
                new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1)) == Blocks.LAVA.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1),
                    Blocks.BLUE_ICE.getDefaultState());
        }
        if (worldIn.getBlockState(
                new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ())) == Blocks.LAVA.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()),
                    Blocks.BLUE_ICE.getDefaultState());
        }
        if (worldIn.getBlockState(
                new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ())) == Blocks.LAVA.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()),
                    Blocks.BLUE_ICE.getDefaultState());
        }
        if (worldIn.getBlockState(
                new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1)) == Blocks.LAVA.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1),
                    Blocks.BLUE_ICE.getDefaultState());
        }
        if (worldIn.getFluidState(
                new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1)) == Fluids.FLOWING_WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1),
                    Blocks.BLUE_ICE.getDefaultState());
        }
        if (worldIn.getFluidState(
                new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1)) == Fluids.FLOWING_WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1),
                    Blocks.BLUE_ICE.getDefaultState());
        }
        if (worldIn.getFluidState(
                new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1)) == Fluids.FLOWING_WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1),
                    Blocks.BLUE_ICE.getDefaultState());
        }
        if (worldIn.getFluidState(
                new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ())) == Fluids.FLOWING_WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()),
                    Blocks.BLUE_ICE.getDefaultState());
        }
        if (worldIn.getFluidState(
                new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ())) == Fluids.FLOWING_WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()),
                    Blocks.BLUE_ICE.getDefaultState());
        }
        if (worldIn.getFluidState(
                new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1)) == Fluids.FLOWING_WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1),
                    Blocks.BLUE_ICE.getDefaultState());
        }
        //snow
        if (worldIn.getBlockState(
                new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1)) == Blocks.AIR.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1),
                    Blocks.SNOW.getDefaultState());
        }
        if (worldIn.getBlockState(
                new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1)) == Blocks.AIR.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1),
                    Blocks.SNOW.getDefaultState());
        }
        if (worldIn.getBlockState(
                new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1)) == Blocks.AIR.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1), Blocks.SNOW.getDefaultState());
        }
        if (worldIn.getBlockState(
                new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ())) == Blocks.AIR.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()), Blocks.SNOW.getDefaultState());
        }
        if (worldIn.getBlockState(
                new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ())) == Blocks.AIR.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()), Blocks.SNOW.getDefaultState());
        }
        if (worldIn.getBlockState(
                new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1)) == Blocks.AIR.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1), Blocks.SNOW.getDefaultState());
        }
        super.onBlockAdded(state, worldIn, pos, oldState, notify);
    }


}
