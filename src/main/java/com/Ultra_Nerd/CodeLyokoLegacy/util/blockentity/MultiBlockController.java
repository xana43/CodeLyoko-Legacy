package com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModParticles;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MultiBlock.MasterEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public abstract class MultiBlockController extends BlockEntity implements MasterEntity {
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

            if (currentPattern.searchAround(world, this.pos) != null) {
                if(world.getBlockState(pos).get(HorizontalFacingBlock.FACING) == Direction.NORTH) {
                    for (int x = -2; x < currentPattern.getWidth() - 1; ++x) {
                        for (int y = 0; y < currentPattern.getHeight(); ++y) {
                            for (int z = 0; z < currentPattern.getDepth(); ++z) {
                                final BlockPos posOffset = new BlockPos(this.pos.getX() + x, this.pos.getY() + y,
                                        this.pos.getZ() + z);
                                final BlockState checkedState = world.getBlockState(posOffset);
                                if (checkedState.contains(this.thisProperty)) {
                                    world.setBlockState(posOffset, checkedState.with(this.thisProperty, true));

                                }
                                world.addParticle(ModParticles.TOWER_PARTICLE, true, posOffset.getX(),
                                        posOffset.getY(),
                                        posOffset.getZ(), 0, 0, 0);
                                this.checkSuccessful = true;
                            }
                        }
                    }
                }
                else if (world.getBlockState(this.pos).get(HorizontalFacingBlock.FACING) == Direction.SOUTH) {
                    CodeLyokoMain.LOG.info("Facing south");
                    for (int x = -2; x < currentPattern.getWidth() - 1; ++x) {
                        for (int y = 0; y < currentPattern.getHeight(); ++y) {
                            for (int z = 0; z < currentPattern.getDepth(); ++z) {
                                final BlockPos posOffset = new BlockPos(this.pos.getX() + x,this. pos.getY() + y,
                                        this.pos.getZ() - z);
                                final BlockState checkedState = world.getBlockState(posOffset);
                                if (checkedState.contains(this.thisProperty)) {
                                    world.setBlockState(posOffset, checkedState.with(this.thisProperty, true));

                                }
                                world.addParticle(ModParticles.TOWER_PARTICLE, true, posOffset.getX(),
                                        posOffset.getY(),
                                        posOffset.getZ(), 0, 0, 0);
                                this.checkSuccessful = true;
                            }
                        }
                    }
                }
                else if (world.getBlockState(this.pos).get(HorizontalFacingBlock.FACING) == Direction.WEST) {
                    CodeLyokoMain.LOG.info("Facing south");
                    for (int x = -2; x < currentPattern.getDepth() - 1; ++x) {
                        for (int y = 0; y < currentPattern.getHeight(); ++y) {
                            for (int z = 0; z < currentPattern.getWidth(); ++z) {
                                final BlockPos posOffset = new BlockPos(this.pos.getX() + x,this. pos.getY() + y,
                                        this.pos.getZ() + z);
                                final BlockState checkedState = world.getBlockState(posOffset);
                                if (checkedState.contains(this.thisProperty)) {
                                    world.setBlockState(posOffset, checkedState.with(this.thisProperty, true));
                                }
                                world.addParticle(ModParticles.TOWER_PARTICLE, true, posOffset.getX(),
                                        posOffset.getY(),
                                        posOffset.getZ(), 0, 0, 0);
                                this.checkSuccessful = true;
                            }
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
    private static final String CHECK_KEY = "is_check_successful";
    @Override
    protected void writeNbt(final NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putBoolean(CHECK_KEY,checkSuccessful);
    }

    @Override
    public void readNbt(final NbtCompound nbt) {
        super.readNbt(nbt);
        checkSuccessful = nbt.getBoolean(CHECK_KEY);
    }
}
