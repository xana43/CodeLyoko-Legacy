package com.Ultra_Nerd.CodeLyokoLegacy.Player.Capabilities;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;

import java.util.concurrent.ThreadLocalRandom;

public final class CellularDegeneration implements AutoSyncedComponent {
    private static final int maxCellHealth = 1024;
    private static final String CELL_HEALTH = "cell_health";
    private static final String HEALTHY = "is_healthy";
    private final PlayerEntity player;
    private int cellHealth = 1024;
    private boolean healthy = true;

    public CellularDegeneration(final PlayerEntity player) {
        this.player = player;
    }

    public boolean isHealthy() {
        return healthy;
    }

    public void deteriorateHealth() {
        cellHealth-=4;
        if (cellHealth < 100 && healthy) {
            healthy = false;
        }
        if(cellHealth < 50)
        {
            player.damage(player.getWorld().getDamageSources().magic(), ThreadLocalRandom.current()
                    .nextFloat(4,8));
        }
    }
    public void regenerateHealth() {
        if (cellHealth < maxCellHealth) {
            cellHealth++;
            if (cellHealth > 100 && !healthy) {
                healthy = true;
            }
        }
    }

    @Override
    public void readFromNbt(final NbtCompound tag, RegistryWrapper.WrapperLookup registryLookup) {
        healthy = tag.getBoolean(HEALTHY);
        cellHealth = tag.getInt(CELL_HEALTH);
    }

    @Override
    public void writeToNbt(final NbtCompound tag,RegistryWrapper.WrapperLookup registryLookup) {
        tag.putInt(CELL_HEALTH, cellHealth);
        tag.putBoolean(HEALTHY, healthy);
    }
}
