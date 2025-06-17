package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Fluids.definition;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModFluids;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.security.SecureRandom;

public final class LiquidHelium extends FluidBlock {
    public LiquidHelium(final Settings settings) {
        super(ModFluids.STILL_LIQUID_HELIUM, settings);
    }

    private static final SecureRandom random = new SecureRandom();

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler) {
        super.onEntityCollision(state, world, pos, entity, handler);
        if (entity instanceof final LivingEntity livingEntity) {

            if(livingEntity.isInvulnerable()) {
                return;
            }
            if(livingEntity instanceof PlayerEntity player)
            {
                if(player.isCreative())
                {
                    return;
                }
            }
            livingEntity.handSwingProgress = 0;
            livingEntity.setInPowderSnow(true);
            livingEntity.setOnFire(false);
            livingEntity.slowMovement(state, new Vec3d(0.8999999761581421, 1.5, 0.8999999761581421));
            livingEntity.damage((ServerWorld) world,entity.getWorld().getDamageSources().freeze(), random.nextInt(4));

        }
    }

    @Override
    public void onBlockAdded(final BlockState state, final World worldIn, final BlockPos pos, final BlockState oldState, final boolean notify) {
        for(final Direction direction : Direction.values())
        {
            final BlockPos offsetPos = pos.offset(direction);
            if(worldIn.getBlockState(offsetPos) == Blocks.WATER.getDefaultState())
            {
                worldIn.setBlockState(offsetPos,Blocks.BLUE_ICE.getDefaultState());
            }
            if(worldIn.getBlockState(offsetPos) == Blocks.LAVA.getDefaultState())
            {
                worldIn.setBlockState(offsetPos,Blocks.DIAMOND_BLOCK.getDefaultState());
            }
            if(worldIn.getFluidState(offsetPos) == Fluids.FLOWING_WATER.getDefaultState())
            {
                worldIn.setBlockState(offsetPos,Blocks.BLUE_ICE.getDefaultState());
            }
            if(worldIn.getFluidState(offsetPos) == Fluids.FLOWING_LAVA.getDefaultState())
            {
                worldIn.setBlockState(offsetPos, Blocks.OBSIDIAN.getDefaultState());
            }
            if(worldIn.getBlockState(offsetPos) == Blocks.AIR.getDefaultState())
            {
                worldIn.setBlockState(offsetPos,Blocks.SNOW.getDefaultState());
            }
        }
        super.onBlockAdded(state, worldIn, pos, oldState, notify);
    }


}
