package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.MultiBlock.MasterEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public final class ComputerInterfaceTE extends BlockEntity implements MasterEntity {
    //public ComputerInterfaceTE(BlockEntityType<?> tileEntityTypeIn) {
      //  super(tileEntityTypeIn);
    //}
    boolean screen = false;

    private boolean once = false;

    public ComputerInterfaceTE(@NotNull BlockEntityType<?> p_155228_, @NotNull BlockPos p_155229_, @NotNull BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
    }
    /*
    public ComputerInterfaceTE() {
        this(ModTileEntities.COMPUTER_INTERFACE_TILE_ENTITY.get());
    }

     */

    @Override
    public void check() {

    }

    @Override
    public void invalidateEntity() {

    }
}
