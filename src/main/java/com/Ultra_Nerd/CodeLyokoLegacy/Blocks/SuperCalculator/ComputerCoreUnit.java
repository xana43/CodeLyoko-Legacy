package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.SuperCalculator;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities.SuperComputerCoreBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlockEntities;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public final class ComputerCoreUnit extends BlockWithEntity {
    public ComputerCoreUnit(final Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return createCodec(ComputerCoreUnit::new);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return ModBlockEntities.SUPERCOMPUTER_CORE_BLOCK_ENTITY_TYPE.instantiate(pos, state);
    }


    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(final World world, final BlockState state, final BlockEntityType<T> type) {
        return (world1, pos, state1, blockEntity) -> {
            if (blockEntity instanceof SuperComputerCoreBlockEntity computerCoreTile) {
                computerCoreTile.tick();
            }
        };
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if(!world.isClient()) {
            if (world.getBlockEntity(pos) instanceof SuperComputerCoreBlockEntity computerCoreTile) {
                player.sendMessage(Text.of(String.valueOf(computerCoreTile.getStoredEnergy())),false);
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.FAIL;
    }


}
