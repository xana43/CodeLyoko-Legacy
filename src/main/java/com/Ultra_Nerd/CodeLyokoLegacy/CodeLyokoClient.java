package com.Ultra_Nerd.CodeLyokoLegacy;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.rend.RendBlok;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.tileentity.Renderer.CoreOfLyoko;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

@Environment(EnvType.CLIENT)
public record CodeLyokoClient() implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        //Renderers
        BlockEntityRendererRegistry.register(ModTileEntities.LYOKO_CORE, context -> new CoreOfLyoko<>());
        EntityRendererRegistry.register(ModEntities.BLOK, RendBlok::new);

    }


}
