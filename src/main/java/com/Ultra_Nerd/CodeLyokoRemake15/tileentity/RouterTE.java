package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class RouterTE extends BlockEntity implements BlockEntityTicker<RouterTE> {
    public RouterTE(BlockEntityType<?> tileEntityTypeIn, BlockPos pos, BlockState state) {
        super(tileEntityTypeIn,pos,state);
    }

    /*public RouterTE() {
        this(ModTileEntities.ROUTER_TILE_ENTITY.get());
    }
     */


    @Override
    public void tick(Level p_155253_, BlockPos p_155254_, BlockState p_155255_, RouterTE p_155256_) {

    }
}
