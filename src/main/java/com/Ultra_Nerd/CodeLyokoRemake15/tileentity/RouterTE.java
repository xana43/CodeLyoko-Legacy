package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class RouterTE extends BlockEntity implements BlockEntityTicker<RouterTE> {
    public RouterTE(BlockEntityType<?> tileEntityTypeIn, BlockPos pos, BlockState state) {
        super(tileEntityTypeIn,pos,state);
    }

    /*public RouterTE() {
        this(ModTileEntities.ROUTER_TILE_ENTITY.get());
    }
     */


    @Override
    public void tick(@NotNull Level p_155253_, @NotNull BlockPos p_155254_, @NotNull BlockState p_155255_, @NotNull RouterTE p_155256_) {

    }
}
