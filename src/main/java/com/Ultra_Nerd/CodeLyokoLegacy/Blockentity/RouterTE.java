package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.common.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.common.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public final class RouterTE extends BlockEntity {

    public RouterTE(@NotNull BlockPos pos, @NotNull BlockState state) {
        super(ModBlockEntities.ROUTER_BLOCK_ENTITY_TYPE, pos, state);
    }
    private static final String connectedBlocksKey = "connected_blocks";
    private BlockPos cableSystemMasterPosition = BlockPos.ORIGIN;
    @Override
    protected void writeNbt(final NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putLong(connectedBlocksKey,cableSystemMasterPosition.asLong());
    }
    public void connectToRouter(final BlockPos positionToAdd)
    {
        if(hasWorld()) {
            assert world != null;
            if (world.isClient()) return;
            if (world.getBlockState(positionToAdd).isOf(ModBlocks.CABLE_BLOCK) ) {
                cableSystemMasterPosition = positionToAdd;
            }

        }

    }
    @Override
    public void readNbt(final NbtCompound nbt) {
        super.readNbt(nbt);
        cableSystemMasterPosition = BlockPos.fromLong(nbt.getLong(connectedBlocksKey));
    }
}
