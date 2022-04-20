package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public final class LyokoCoreBE extends BlockEntity {
    public LyokoCoreBE(final BlockPos pWorldPosition, final BlockState pBlockState) {
        super(ModTileEntities.LYOKO_CORE.get(), pWorldPosition, pBlockState);
    }


}
