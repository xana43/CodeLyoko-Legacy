package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Fluids.definition;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModFluids;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public final class UraniumWaste extends FluidBlock {
    public UraniumWaste(final Settings settings) {
        super(ModFluids.STILL_URANIUM, settings);
    }


    @Override
    public void onPlaced(final World world, final BlockPos pos, final BlockState state, @Nullable final LivingEntity placer, final ItemStack itemStack) {
        for(final Direction dir : Direction.values())
        {
            final BlockPos offsetPos = pos.offset(dir);
            if(world.getBlockState(offsetPos) == Blocks.WATER.getDefaultState())
            {
                world.setBlockState(offsetPos,ModFluids.STILL_URANIUM.getDefaultState().getBlockState());
            }
        }
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler) {
        super.onEntityCollision(state, world, pos, entity, handler);
        if (entity instanceof final LivingEntity livingEntity) {
            if (livingEntity.isInvulnerable()) {
                return;
            }
            if(livingEntity instanceof final PlayerEntity player)
            {
                if(player.isCreative())
                {
                    return;
                }
            }
            livingEntity.addStatusEffect(
                    new StatusEffectInstance(StatusEffects.POISON, 10, 3, false, false, false));
            livingEntity.addStatusEffect(
                    new StatusEffectInstance(StatusEffects.NAUSEA, 255, 255, false, false, false));
        }
    }
}
