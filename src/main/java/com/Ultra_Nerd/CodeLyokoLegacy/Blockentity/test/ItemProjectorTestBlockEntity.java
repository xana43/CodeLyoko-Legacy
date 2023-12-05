package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.test;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.common.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.InventoryTickingBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public final class ItemProjectorTestBlockEntity extends InventoryTickingBlockEntity implements NamedScreenHandlerFactory {
    public ItemProjectorTestBlockEntity(final BlockPos pos,final BlockState state) {
        super(ModBlockEntities.ITEM_PROJECTOR_TEST_BLOCK_ENTITY, pos, state,54);
    }

    @Override
    public void tick() {

    }

    @Override
    public Text getDisplayName() {
        return Text.literal("test projector");
    }
    @Override
    public ScreenHandler createMenu(final int syncId,final PlayerInventory playerInventory,final PlayerEntity player) {
        return GenericContainerScreenHandler.createGeneric9x6(syncId,playerInventory,this);
    }
}
