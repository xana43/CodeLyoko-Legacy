package com.Ultra_Nerd.CodeLyokoLegacy.tileentity.test;

import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.TestHandler.ProfileDebugScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlockEntities;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PlayerDataStorage extends BlockEntity implements ExtendedScreenHandlerFactory {
    public PlayerDataStorage(final BlockPos pos, final BlockState state) {
        super(ModBlockEntities.PLAYER_DATA_STORAGE_BLOCK_ENTITY_TYPE, pos, state);
    }

    @Override
    public void writeScreenOpeningData(final ServerPlayerEntity player, final PacketByteBuf buf) {

    }

    @Override
    public Text getDisplayName() {
        return Text.empty();
    }

    @Override
    public @NotNull ScreenHandler createMenu(final int syncId, final PlayerInventory inv, final PlayerEntity player) {
        return new ProfileDebugScreenHandler(syncId,player,player.getWorld().getLevelProperties());
    }
}
