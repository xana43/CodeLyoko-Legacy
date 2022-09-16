package net.codelyoko.fabric;

import net.codelyoko.fabriclike.ExampleModFabricLike;
import net.fabricmc.api.ModInitializer;

public class CodeLyokoFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ExampleModFabricLike.init();
    }
}
