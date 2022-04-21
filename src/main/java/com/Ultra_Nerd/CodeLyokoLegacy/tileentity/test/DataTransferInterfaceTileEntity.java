package com.Ultra_Nerd.CodeLyokoLegacy.tileentity.test;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public final class DataTransferInterfaceTileEntity extends BlockEntity /*implements MenuProvider*/ {
    public DataTransferInterfaceTileEntity(final BlockEntityType<?> type, final BlockPos pos, final BlockState state) {
        super(type, pos, state);
    }
/*
    public DataTransferInterfaceTileEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        super(ModTileEntities.DATA_TRANSFER_INTERFACE_TILE_ENTITY.get(),pos,state);
    }



    @Nonnull
    @Override
    public Component getDisplayName() {
        return new TranslatableComponent(ModBlocks.DATA_TRANSFER_INTERFACE.get().getName().toString());
    }


    @Override
    public AbstractContainerMenu createMenu(int windowIn, @Nonnull Inventory playerInventory, @Nonnull Player playerEntity) {
        return new DataTransferInterfaceContainer(windowIn, playerInventory, this);
    }

    @Override
    public boolean triggerEvent(int pId, int pType) {
        return true;
    }

 */
}
