package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class CentralControlUnitTileEntity extends BlockEntity implements BlockEntityTicker<CentralControlUnitTileEntity> {

    public CentralControlUnitTileEntity(BlockEntityType<?> tileEntityTypeIn, BlockPos pos, BlockState state) {
        super(tileEntityTypeIn,pos,state);
    }

    /*public CentralControlUnitTileEntity() {
        this(ModTileEntities.CENTRAL_CONTROL_UNIT_TILE_ENTITY.get());
    }*/





    @Override
    public void tick(Level p_155253_, BlockPos p_155254_, BlockState p_155255_, CentralControlUnitTileEntity p_155256_) {

    }
}
