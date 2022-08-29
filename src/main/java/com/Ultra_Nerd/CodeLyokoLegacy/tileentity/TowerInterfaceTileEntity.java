package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.TowerInterfaceScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public final class TowerInterfaceTileEntity extends BlockEntity implements NamedScreenHandlerFactory
 {
     public TowerInterfaceTileEntity(final BlockPos pos, final BlockState state) {
         super(ModTileEntities.TOWER_INTERFACE_TILE_ENTITY, pos, state);
     }

     @Override
     public Text getDisplayName() {
         return Text.empty();
     }

     @Override
     public @NotNull ScreenHandler createMenu(final int syncId, final PlayerInventory inv, final PlayerEntity player) {
         return new TowerInterfaceScreenHandler(syncId);
     }



}
