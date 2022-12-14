package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtLong;
import net.minecraft.nbt.NbtOps;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public final class RouterTE extends BlockEntity {
    private final List<BlockPos> connectedBlocks = new ArrayList<>();
    public RouterTE(@NotNull BlockPos pos, @NotNull BlockState state) {
        super(ModTileEntities.ROUTER_BLOCK_ENTITY_TYPE, pos, state);
    }
    private static final String connectedBlocksKey = "connected_blocks";
    @Override
    protected void writeNbt(final NbtCompound nbt) {
        super.writeNbt(nbt);
        final NbtList validConnectedPositions = new NbtList();

        for(BlockPos pos : connectedBlocks)
        {
            validConnectedPositions.add(NbtOps.INSTANCE.createLong(pos.asLong()));
        }
        nbt.put(connectedBlocksKey,validConnectedPositions);
    }
    public void connectToRouter(final BlockPos positionToAdd)
    {
        if(hasWorld()) {
            assert world != null;
            if (world.isClient()) return;
            if (world.getBlockState(positionToAdd).isOf(ModBlocks.CABLE_BLOCK)) {
                connectedBlocks.add(positionToAdd);
            }
            else
            {
                CodeLyokoMain.LOG.error("cannot be connected: Not a valid connectable block");
            }
        }

    }
    @Override
    public void readNbt(final NbtCompound nbt) {
        super.readNbt(nbt);
        final NbtList positions = (NbtList) nbt.get(connectedBlocksKey);
        if(positions != null) {
            for (int i = 0; i < positions.size(); i++) {
                final NbtLong position = (NbtLong) positions.get(i);
                connectedBlocks.set(i,BlockPos.fromLong(position.longValue()));
            }
        }
        else
        {
            CodeLyokoMain.LOG.error("failed to load connected blocks");
        }
    }
}
