// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityModels;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.HostileEntities.MegaTankEntity;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;


public final class ModelMegaTank extends DefaultedEntityGeoModel<MegaTankEntity> {
    public ModelMegaTank() {
        super(CodeLyokoMain.codeLyokoPrefix("megatank"));
    }


    @Override
    public @NotNull Identifier getModelResource(GeoRenderState renderState) {
        return CodeLyokoMain.codeLyokoPrefix("geo/megatank.geo.json");
    }

    @Override
    public @NotNull Identifier getTextureResource(GeoRenderState renderState) {
        return CodeLyokoMain.codeLyokoPrefix("textures/entity/megatank/megatank.png");
    }

    @Override
    public Identifier getAnimationResource(MegaTankEntity animatable) {
        return CodeLyokoMain.codeLyokoPrefix("animations/entity/megatank.json");
    }


}