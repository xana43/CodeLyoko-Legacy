package com.Ultra_Nerd.CodeLyokoLegacy.tileentity.test;

import com.Ultra_Nerd.CodeLyokoLegacy.containers.DataTransferInterfaceContainer;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class DataTransferInterfaceTileEntity extends BlockEntity implements MenuProvider {

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
}
