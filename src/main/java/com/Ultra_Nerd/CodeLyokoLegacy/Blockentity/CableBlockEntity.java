package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.SyncedBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtLong;
import net.minecraft.nbt.NbtOps;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public final class CableBlockEntity extends SyncedBlockEntity {
    private static final SecureRandom random = new SecureRandom();
    private static final String positionsKey = "connected_positions";
    private static final String isMasterKey = "is_master";
    private static final String isEndKey = "is_end";
    private static final String currentMasterKey = "current_master";
    public static final List<BlockPos> connectedPositions = new ArrayList<>();
    public static BlockPos currentMaster = BlockPos.ORIGIN;
    private boolean isMaster = false;
    private boolean isEnd = false;

    public CableBlockEntity(final BlockPos pos, final BlockState state) {
        super(ModBlockEntities.CABLE_TILE_ENTITY_BLOCK_ENTITY_TYPE, pos, state);
    }

    public static void appendToMaster(final BlockPos appendPosition, final BlockPos masterPos, final World world) {
        if (world.getBlockEntity(masterPos) instanceof final CableBlockEntity cableBlockEntity) {
            if (cableBlockEntity.isMaster && !connectedPositions.contains(appendPosition)) {
                connectedPositions.add(appendPosition);
            }
        }
    }

    public static void removeFromMaster(final BlockPos appendPosition, final BlockPos masterPos, final World world) {
        if (world.getBlockEntity(masterPos) instanceof final CableBlockEntity cableBlockEntity) {
            connectedPositions.remove(appendPosition);
        }
    }

    private boolean initialCheck() {
        for (final Direction dir : Direction.values()) {
            if (world.getBlockState(pos.offset(dir, 1)).isOf(ModBlocks.CABLE_BLOCK)) {
                return false;
            }
        }
        return true;
    }

    public void checkIfEnd() {
        int count = 0;
        for (final Direction dir : Direction.values()) {
            final BlockPos checkPos = pos.offset(dir, 1);
            if (world.getBlockState(checkPos).isOf(ModBlocks.CABLE_BLOCK)) {
                count++;
            }
        }
        isEnd = count <= 1;
    }

    public boolean getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(final Boolean isEnd) {
        this.isEnd = isEnd.booleanValue();
    }

    public boolean getIsMaster() {
        return isMaster;
    }

    public void propogateCheck(final int offset) {

        for (final Direction dir : Direction.values()) {

            final BlockPos checkedPos = pos.offset(dir, offset);
            if (world.getBlockState(checkedPos).isOf(ModBlocks.CABLE_BLOCK)) {
                if (world.getBlockEntity(checkedPos) instanceof final CableBlockEntity cableTile) {
                    if (cableTile.isMaster) {
                        currentMaster = checkedPos;
                        appendToMaster(pos, checkedPos, world);
                        return;
                    }
                    propogateCheck(offset + 1);
                }
            }


        }


    }

    public void calculateConnected() {
        isMaster = initialCheck();
        if (!this.isMaster) {
            propogateCheck(1);
        }
        for (final Direction dir : Direction.values()) {
            final BlockPos nextPosition = pos.offset(dir, 1);
            if (world.getBlockState(nextPosition).isOf(ModBlocks.CABLE_BLOCK)) {
                if (world.getBlockEntity(pos) instanceof final CableBlockEntity tileEntity) {
                    if (tileEntity.isMaster && this.isMaster) {
                        final int chose = random.nextInt(0, 1);
                        if (chose == 1) {
                            tileEntity.isMaster = false;
                        } else {
                            this.isMaster = false;
                        }
                    }
                }
            }
        }

    }

    @Override
    public boolean isRemoved() {


        return super.isRemoved();
    }

    @Override
    protected void writeNbt(final NbtCompound nbt) {
        super.writeNbt(nbt);
        final NbtList nbtList = new NbtList();
        for (final BlockPos blockPos : connectedPositions) {
            nbtList.add(NbtOps.INSTANCE.createLong(blockPos.asLong()));
        }
        nbt.put(positionsKey, nbtList);
        nbt.putBoolean(isMasterKey, isMaster);
        nbt.putBoolean(isEndKey, isEnd);
        if (currentMaster != BlockPos.ORIGIN) {
            nbt.put(currentMasterKey, NbtOps.INSTANCE.createLong(currentMaster.asLong()));
        }
    }

    @Override
    public void readNbt(final NbtCompound nbt) {
        super.readNbt(nbt);
        final NbtList nbtList = (NbtList) nbt.get(positionsKey);
        for (int i = 0; i < nbtList.size(); ++i) {
            final NbtLong nbtLong = (NbtLong) nbtList.get(i);
            connectedPositions.add(BlockPos.fromLong(nbtLong.longValue()));
        }
        isMaster = nbt.getBoolean(isMasterKey);
        isEnd = nbt.getBoolean(isEndKey);
        currentMaster = BlockPos.fromLong(((NbtLong) nbt.get(currentMasterKey)).longValue());

    }


}
