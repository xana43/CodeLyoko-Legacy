package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.blocks.SuperCalculator.ComputerKeyboard;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MultiBlock.BlockPatternRegistry;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.MultiBlockController;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public final class KeyBoardInterface extends MultiBlockController {
    public KeyBoardInterface(final BlockPos pos, final BlockState state) {
        super(ModTileEntities.KEYBOARD_BLOCK_ENTITY, pos, state, BlockPatternRegistry.SCREEN_FRAME.getThisBlockPatttern(),
                ComputerKeyboard.IS_SCREEN_FORMED);
    }

}
