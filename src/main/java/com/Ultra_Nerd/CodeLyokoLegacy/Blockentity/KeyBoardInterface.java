package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity;

import com.Ultra_Nerd.CodeLyokoLegacy.blocks.SuperCalculator.ComputerKeyboard;
import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MultiBlock.BlockPatternRegistry;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.MultiBlockController;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public final class KeyBoardInterface extends MultiBlockController {
    public KeyBoardInterface(final BlockPos pos, final BlockState state) {
        super(ModBlockEntities.KEYBOARD_BLOCK_ENTITY, pos, state, BlockPatternRegistry.SCREEN_FRAME.getThisBlockPattern(),
                ComputerKeyboard.IS_SCREEN_FORMED);
    }

}
