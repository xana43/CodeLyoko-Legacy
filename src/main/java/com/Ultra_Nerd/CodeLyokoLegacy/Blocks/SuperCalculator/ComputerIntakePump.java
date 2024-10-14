package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.SuperCalculator;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.blockentity.TickingBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ComputerIntakePump extends Block implements BlockEntityProvider {
    public ComputerIntakePump(final Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return ModBlockEntities.COMPUTER_FLUID_INTAKE_BLOCK_ENTITY.instantiate(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(final BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public <T extends BlockEntity> @NotNull BlockEntityTicker<T> getTicker(final World world, final BlockState state, final BlockEntityType<T> type) {
        return (world1, pos, state1, blockEntity) -> {
            if(blockEntity instanceof final TickingBlockEntity ticker)
            {

                ticker.tick();

            }
        };
    }
}
