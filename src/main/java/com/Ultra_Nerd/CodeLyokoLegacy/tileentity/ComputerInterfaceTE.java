package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.util.MultiBlock.MasterEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public final class ComputerInterfaceTE extends BlockEntity implements MasterEntity {
    //public ComputerInterfaceTestTE(BlockEntityType<?> tileEntityTypeIn) {
    //  super(tileEntityTypeIn);
    //}


    public ComputerInterfaceTE(@NotNull BlockEntityType<?> p_155228_, @NotNull BlockPos p_155229_, @NotNull BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
    }
    /*
    public ComputerInterfaceTestTE() {
        this(ModBlockEntities.COMPUTER_INTERFACE_TILE_ENTITY.get());
    }

     */

    @Override
    public void check() {

    }

    @Override
    public void invalidateEntity() {

    }
}
