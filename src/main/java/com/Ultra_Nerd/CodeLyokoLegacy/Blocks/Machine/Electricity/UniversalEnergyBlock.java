package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Machine.Electricity;


import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Eletricity.UniversalEnergyStorageTileEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlockEntities;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;


public final class UniversalEnergyBlock extends BlockWithEntity {

    public UniversalEnergyBlock(final Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return ModBlockEntities.UNIVERSAL_ENERGY_STORAGE.instantiate(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(final BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        final BlockEntity be = world.getBlockEntity(pos);
        if (be instanceof final UniversalEnergyStorageTileEntity universalEnergyStorageTile && world.isClient()) {
            player.sendMessage(Text.of("Energy Amount: " + universalEnergyStorageTile.getCurrentAmount()), false);
        }
        return ActionResult.SUCCESS;
    }



    @Override
    public void randomDisplayTick(final BlockState state, final World world, final BlockPos pos, final Random random) {
        super.randomDisplayTick(state, world, pos, random);
    }

    @Override
    public void onStateReplaced(final BlockState state, final World world, final BlockPos pos, final BlockState newState, final boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            final BlockEntity be = world.getBlockEntity(pos);
            if (be instanceof UniversalEnergyStorageTileEntity universalEnergyStorageTile) {
                universalEnergyStorageTile.setEnergyAmount(0);
            }
        }
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        final BlockEntity be = world.getBlockEntity(pos);
        if (be instanceof final UniversalEnergyStorageTileEntity universalEnergyStorageTile) {
            universalEnergyStorageTile.setEnergyAmount(0);
        }
        super.onBroken(world, pos, state);
    }



}
