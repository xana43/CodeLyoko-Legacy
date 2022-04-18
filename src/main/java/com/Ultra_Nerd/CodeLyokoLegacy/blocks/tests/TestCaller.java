package com.Ultra_Nerd.CodeLyokoLegacy.blocks.tests;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.MultiBlock.MultiBlockPartCallback;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class TestCaller extends Block implements MultiBlockPartCallback {

    public TestCaller(final Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public void onPlace(final @NotNull BlockState pState, final @NotNull Level pLevel, final @NotNull BlockPos pPos, final @NotNull BlockState pOldState, final boolean pIsMoving) {
        super.onPlace(pState, pLevel, pPos, pOldState, pIsMoving);
        this.checkArea(pLevel,3,3,4,pPos);
        CodeLyokoMain.Log.info("placed");
    }




}
