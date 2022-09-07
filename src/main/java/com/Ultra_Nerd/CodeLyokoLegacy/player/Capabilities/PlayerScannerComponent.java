package com.Ultra_Nerd.CodeLyokoLegacy.player.Capabilities;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.entity.PlayerComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public final class PlayerScannerComponent implements AutoSyncedComponent, PlayerComponent<PlayerScannerComponent> {

    private final PlayerEntity player;
    private BlockPos blockPos = BlockPos.ORIGIN;

    public PlayerScannerComponent(final PlayerEntity player) {
        this.player = player;
    }


    public void savePosition() {
        blockPos = player.getBlockPos();
    }

    public void setPosition() {
        player.setPosition(blockPos.getX(), blockPos.getY(), blockPos.getZ());
    }

    @Override
    public void readFromNbt(final @NotNull NbtCompound tag) {
        blockPos = new BlockPos(tag.getIntArray("player_pos")[0], tag.getIntArray("player_pos")[1], tag.getIntArray("player_pos")[2]);
    }

    @Override
    public void writeToNbt(final @NotNull NbtCompound tag) {
        tag.putIntArray("player_pos", new int[]{blockPos.getX(), blockPos.getY(), blockPos.getZ()});
    }
}
