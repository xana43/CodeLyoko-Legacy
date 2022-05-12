package com.Ultra_Nerd.CodeLyokoLegacy;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.DimensionCheck;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import io.github.ladysnake.locki.DefaultInventoryNodes;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.ServerMetadata;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateManager;
@Environment(EnvType.SERVER)
public record CodeLyokoServer() implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {

    }
}
