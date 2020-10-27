package com.Ultra_Nerd.CodeLyokoRemake15.tileentity.test;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nonnull;

public class DataTransferInterfaceTileEntity extends TileEntity implements INamedContainerProvider {

    public DataTransferInterfaceTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public DataTransferInterfaceTileEntity() {
        this(ModTileEntities.DATA_TRANSFER_INTERFACE_TILE_ENTITY.get());
    }

    @Nonnull
    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent(ModBlocks.DATA_TRANSFER_INTERFACE.get().getTranslationKey());
    }

    @Override
    public Container createMenu(int windowIn, @Nonnull PlayerInventory playerInventory, @Nonnull PlayerEntity playerEntity) {
        return null;
    }
}
