package com.Ultra_Nerd.CodeLyokoLegacy.Util.MultiBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
@NotNull
public interface MultiBlockPartCallback extends MultiBlockBase {
    default boolean checkArea(final @NotNull  Level level, final int xvLength, final int yvLength, final int zvLength , final @NotNull  BlockPos origin)
    {
        //this variable denotes a full block, xLength = 1 equals an offset of 0 blocks(or the current block) and xLength = 2 is an offset of 1 block
        final int i = Math.max(Math.max(xvLength,yvLength),zvLength);


        for(BlockPos pos: BlockPos.betweenClosed(origin,origin.offset(i - 1, i - 1, i- 1)))
        {

            //CodeLyokoMain.Log.info("pos checked = " + pos);
            if(level.getBlockEntity(pos) instanceof MasterEntity masterEntity)
            {
                //CodeLyokoMain.Log.info("is a valid master");
                if(masterEntity != null) {
                    masterEntity.check();
                    return true;
                }
            }
        }
        return false;

    }
    default boolean checkAreaNegative(final@NotNull Level level, final int xvLength, final int yvLength, final int zvLength , final @NotNull BlockPos origin)
    {
        //this variable denotes a full block, xLength = 1 equals an offset of 0 blocks(or the current block) and xLength = 2 is an offset of 1 block
        final int i = -Math.max(Math.max(xvLength,yvLength),zvLength);


        for(BlockPos pos: BlockPos.betweenClosed(origin,origin.offset(i + 1, i + 1, i + 1)))
        {

            //CodeLyokoMain.Log.info("pos checked = " + pos);
            if(level.getBlockEntity(pos) instanceof MasterEntity masterEntity)
            {
                //CodeLyokoMain.Log.info("is a valid master");
                if(masterEntity != null) {
                    masterEntity.check();
                    return true;
                }
            }
        }
        return false;

    }

    //default void checkArea(Level level, int xvLength, int yvLength, int zvLength, BlockPos origin) {}


}
