package com.Ultra_Nerd.CodeLyokoLegacy.tileentity.test;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public class PlayerDataStorage extends BlockEntity {
    public PlayerDataStorage(final BlockEntityType<?> type, final BlockPos pos, final BlockState state) {
        super(type, pos, state);
    }
}
