package net.codelyoko.fabric;

import net.codelyoko.fabriclike.ExampleModFabricLike;
import net.fabricmc.api.ModInitializer;

public class ExampleModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ExampleModFabricLike.init();
    }
}
