package com.Ultra_Nerd.CodeLyokoRemake15.tileentity.test;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class DataTransferInterfaceTileEntity extends BlockEntity implements MenuProvider {
    public DataTransferInterfaceTileEntity(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
    }

    @Override
    public Component getDisplayName() {
        return null;
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int p_39954_, Inventory p_39955_, Player p_39956_) {
        return null;
    }
/*
    public DataTransferInterfaceTileEntity(BlockEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    //ublic DataTransferInterfaceTileEntity() {
  //      this(ModTileEntities.DATA_TRANSFER_INTERFACE_TILE_ENTITY.get());
   // }

    @Nonnull
    @Override
    public Component getDisplayName() {
        return new TranslatableComponent(ModBlocks.DATA_TRANSFER_INTERFACE.get().getName().toString());
    }


    @Override
    public AbstractContainerMenu createMenu(int windowIn, @Nonnull Inventory playerInventory, @Nonnull Player playerEntity) {
        return null; // new DataTransferInterfaceContainer(windowIn, playerInventory, this);
    }

 */
}
