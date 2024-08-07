package com.Ultra_Nerd.CodeLyokoLegacy.Blocks;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class UraniumCanister extends Block {

    private static final VoxelShape shape = Block.createCuboidShape(3.5D, 0.0D, 3.5D, 12.0D, 15.0D, 12.0D);

    public UraniumCanister(@NotNull Settings properties) {
        super(properties);
    }


    @Override
    public VoxelShape getOutlineShape(final BlockState state, final BlockView world, final BlockPos pos, final ShapeContext context) {
        return shape;
    }

    @Override
    public void afterBreak(final World world, final PlayerEntity player, final BlockPos pos, final BlockState state, @Nullable final BlockEntity blockEntity, final ItemStack stack) {
        super.afterBreak(world, player, pos, state, blockEntity, stack);
        world.setBlockState(pos, ModBlocks.URANIUM_WASTE_BLOCK.getDefaultState());
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!player.isCreative()) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 100, 2, false, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 255, 255, false, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 1, false, true, false));
        }
        return ActionResult.SUCCESS;
    }




}
