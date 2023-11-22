package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.SuperCalculator;

import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModBlockEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public final class BaseComputerPipe extends Block implements BlockEntityProvider {


    public BaseComputerPipe(final Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return ModBlockEntities.CIRCULATOR_PIPE_BLOCK_ENTITY_TYPE.instantiate(pos, state);
    }
}
