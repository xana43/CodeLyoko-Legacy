package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.MultiBlock.MasterEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.blockentity.SyncedBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public final class ComputerInterfaceTE extends SyncedBlockEntity implements MasterEntity {



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
