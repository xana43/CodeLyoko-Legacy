package com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public abstract class TickingBlockEntity extends BlockEntity {
    public TickingBlockEntity(final BlockEntityType<?> type, final BlockPos pos, final BlockState state) {
        super(type, pos, state);
    }
    public abstract void tick();
    public void update()
    {
        this.markDirty();
        if(this.world != null)
        {
            this.world.setBlockState(this.pos,getCachedState());
        }
    }
}
