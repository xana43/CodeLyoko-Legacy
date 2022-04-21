package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import net.minecraft.block.Block;

public final class UraniumCanister extends Block {
    public UraniumCanister(final Settings settings) {
        super(settings);
    }
/*
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

 */


}
