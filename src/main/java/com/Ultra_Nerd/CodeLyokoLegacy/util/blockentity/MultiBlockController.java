package com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModParticles;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MultiBlock.MasterEntity;
import net.minecraft.block.BeaconBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BeaconBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.LecternBlockEntity;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;

public abstract class MultiBlockController extends BlockEntity implements MasterEntity {
    private static final String CHECK_KEY = "is_check_successful";
    private final BlockPattern currentPattern;
    private final BooleanProperty thisProperty;
    protected boolean checkSuccessful;

    public MultiBlockController(final BlockEntityType<?> type, final BlockPos pos, final BlockState state, final BlockPattern pattern, final BooleanProperty stateProperty) {
        super(type, pos, state);
        currentPattern = pattern;
        this.thisProperty = stateProperty;
    }

    public boolean getCheckSuccessful() {
        return this.checkSuccessful;
    }

    //TODO: get this working properly
    @Override
    public void check() {
        if (world != null) {
            if (currentPattern.searchAround(world, pos) != null) {
                for (int x = -2; x < currentPattern.getWidth() - 1; ++x) {
                    for (int y = 0; y < currentPattern.getHeight(); ++y) {
                        for (int z = 0; z < currentPattern.getDepth(); ++z) {
                            final BlockPos posOffset = new BlockPos(this.pos.getX() + x, this.pos.getY() + y,
                                    this.pos.getZ() + z);
                            final BlockState checkedState = world.getBlockState(posOffset);
                            if (checkedState.contains(this.thisProperty)) {
                                world.setBlockState(posOffset, checkedState.with(this.thisProperty, true));

                            }
                            world.addParticle(ModParticles.TOWER_PARTICLE, true, posOffset.getX(), posOffset.getY(),
                                    posOffset.getZ(), 0, 0, 0);
                            this.checkSuccessful = true;
                        }
                    }
                }

            } else {

                invalidateEntity();
            }
            world.updateListeners(pos, getCachedState(), getCachedState(), Block.NOTIFY_LISTENERS);

        }
    }

    @Override
    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return this.createNbt();
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

    @Override
    protected void writeNbt(final NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putBoolean(CHECK_KEY, checkSuccessful);
    }

    @Override
    public void readNbt(final NbtCompound nbt) {
        super.readNbt(nbt);
        checkSuccessful = nbt.getBoolean(CHECK_KEY);
    }
}
