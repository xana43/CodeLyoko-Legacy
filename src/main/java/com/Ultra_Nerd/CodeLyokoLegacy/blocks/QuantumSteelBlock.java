package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.MultiBlock.MultiBlockPartCallback;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.NotNull;

public final class QuantumSteelBlock extends Block implements MultiBlockPartCallback {

    public static final BooleanProperty formed = BooleanProperty.create("formed");

    public QuantumSteelBlock(@NotNull Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(formed, false));
    }

    @Override
    public void onPlace(final BlockState pState, final Level pLevel, final BlockPos pPos, final BlockState pOldState, final boolean pIsMoving) {
        super.onPlace(pState, pLevel, pPos, pOldState, pIsMoving);
        if(this.checkArea(pLevel,4,4,4,pPos))
        {
            CodeLyokoMain.Log.info("Valid Master");
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(formed);
    }












}
