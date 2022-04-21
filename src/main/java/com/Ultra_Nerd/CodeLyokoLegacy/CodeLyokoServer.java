package com.Ultra_Nerd.CodeLyokoLegacy;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.ServerMetadata;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateManager;

public class CodeLyokoServer implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        final String nbtcheck = "first_join";
        ServerWorldEvents.LOAD.register((server, world) -> {



        });
    }
}
