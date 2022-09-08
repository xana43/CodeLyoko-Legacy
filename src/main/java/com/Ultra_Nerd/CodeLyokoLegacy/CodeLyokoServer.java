package com.Ultra_Nerd.CodeLyokoLegacy;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;

@Environment(EnvType.SERVER)
public record CodeLyokoServer() implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {

    }
}
