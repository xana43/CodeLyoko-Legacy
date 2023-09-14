package com.Ultra_Nerd.CodeLyokoLegacy.tileentity.SuperCalculatorEntities;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public final class CentralControlUnitTileEntity extends BlockEntity {

    public CentralControlUnitTileEntity(@NotNull BlockEntityType<?> tileEntityTypeIn, @NotNull BlockPos pos, @NotNull BlockState state) {
        super(tileEntityTypeIn, pos, state);
    }

    /*public CentralControlUnitTileEntity() {
        this(ModBlockEntities.CENTRAL_CONTROL_UNIT_TILE_ENTITY.get());
    }*/


}
