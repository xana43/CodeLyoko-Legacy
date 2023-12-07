package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity;

import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.SuperCalculator.ComputerKeyboard;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.MultiBlock.BlockPatternRegistry;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.blockentity.MultiBlockController;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public final class KeyBoardInterface extends MultiBlockController {
    public KeyBoardInterface(final BlockPos pos, final BlockState state) {
        super(ModBlockEntities.KEYBOARD_BLOCK_ENTITY, pos, state, BlockPatternRegistry.SCREEN_FRAME.getThisBlockPattern(),
                ComputerKeyboard.IS_SCREEN_FORMED);
    }

}
