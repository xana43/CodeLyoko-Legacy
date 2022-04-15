package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public final class UraniumCanister extends Block {

    private static final VoxelShape shape = Block.box(3.5D, 0.0D, 3.5D, 12.0D, 15.0D, 12.0D);

    public UraniumCanister(@NotNull Properties properties) {
        super(properties);
    }

    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull BlockGetter worldIn, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        return shape;
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, @NotNull Level level, @NotNull BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {

        return level.setBlockAndUpdate(pos, ModFluids.URANIUM.get().defaultBlockState());
    }



    @Nonnull
    @Override
    public InteractionResult use(@Nonnull BlockState state, @Nonnull Level worldIn, @Nonnull BlockPos pos, @NotNull Player player, @Nonnull InteractionHand handIn, @Nonnull BlockHitResult hit) {


        if (!player.isCreative()) {
            player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 100, 2, false, false, false));
            player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 4000, 255, false, false, false));
            player.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 1, false, true, false));
        }

        return InteractionResult.SUCCESS;
    }


}
