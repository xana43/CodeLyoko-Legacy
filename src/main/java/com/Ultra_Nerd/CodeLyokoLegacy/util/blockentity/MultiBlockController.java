package com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MultiBlock.MasterEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;

public class MultiBlockController extends BlockEntity implements MasterEntity {
    private final BlockPattern currentPattern;
    private final BooleanProperty thisProperty;
    protected boolean checkSuccessful;

    public MultiBlockController(final BlockEntityType<?> type, final BlockPos pos, final BlockState state,
            final BlockPattern pattern, final BooleanProperty stateProperty) {
        super(type, pos, state);
        currentPattern = pattern;
        this.thisProperty = stateProperty;
    }

    public boolean getCheckSuccessful() {
        return this.checkSuccessful;
    }

    @Override
    public void check() {
        if (world != null) {

            if (currentPattern.searchAround(world, pos) != null) {
                for (int x = 0; x < currentPattern.getWidth(); ++x) {
                    for (int y = 0; y < currentPattern.getHeight(); ++y) {
                        for (int z = 0; z < currentPattern.getDepth(); ++z) {
                            final BlockPos posOffset = new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z);
                            final BlockState checkedState = world.getBlockState(posOffset);
                            if (checkedState.contains(thisProperty)) {
                                world.setBlockState(posOffset, checkedState.with(thisProperty, true));

                            }
                            checkSuccessful = true;
                        }
                    }
                }

            } else {

                invalidateEntity();
            }
        }
    }

    @Override
    public void invalidateEntity() {
        if (world != null) {
            //if (currentPattern.searchAround(world, pos) != null) {
                for (int x = -currentPattern.getWidth(); x < currentPattern.getWidth(); ++x) {
                    for (int y = -currentPattern.getHeight(); y < currentPattern.getHeight(); ++y) {
                        for (int z = -currentPattern.getDepth(); z < currentPattern.getDepth(); ++z) {
                            final BlockPos posOffset = new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z);
                            final BlockState checkedState = world.getBlockState(posOffset);
                            if (checkedState.contains(thisProperty)) {
                                world.setBlockState(posOffset, checkedState.with(thisProperty, false));

                            }
                            checkSuccessful = false;
                        }
                    }
                //}

            }
        }
    }
}
