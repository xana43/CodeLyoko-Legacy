package com.Ultra_Nerd.CodeLyokoLegacy.blocks.machine.Electricity;


import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Eletricity.UniversalEnergyStorageTileEntity;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public final class UniversalEnergyBlock extends BlockWithEntity {

    public UniversalEnergyBlock(final Settings settings) {
        super(settings);
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
    public ActionResult onUse(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final Hand hand, final BlockHitResult hit) {

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
    public void onBreak(final World world, final BlockPos pos, final BlockState state, final PlayerEntity player) {


        final BlockEntity be = world.getBlockEntity(pos);
        if (be instanceof final UniversalEnergyStorageTileEntity universalEnergyStorageTile) {
            universalEnergyStorageTile.setEnergyAmount(0);
        }

        super.onBreak(world, pos, state, player);

    }

}
