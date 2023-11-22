package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Machine.electroplate;

import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public final class ElectroplatingMachine extends BlockWithEntity {
    public ElectroplatingMachine(final Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return null;
    }

}
