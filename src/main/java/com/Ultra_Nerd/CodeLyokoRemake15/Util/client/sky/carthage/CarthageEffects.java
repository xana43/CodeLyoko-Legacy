package com.Ultra_Nerd.CodeLyokoRemake15.Util.client.sky.carthage;

import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.ISkyRenderHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CarthageEffects extends DimensionSpecialEffects {
    public ISkyRenderHandler skyRenderHandler;
    public CarthageEffects() {
        super(-2, false, SkyType.NONE, true, true);
    }

    @Override
    public @NotNull Vec3 getBrightnessDependentFogColor(@NotNull Vec3 pFogColor, float pBrightness) {
        return pFogColor;
    }

    @Override
    public float[] getSunriseColor(float pTimeOfDay, float pPartialTicks) {
        return null;
    }

    @Override
    public boolean isFoggyAt(int pX, int pY) {
        return false;
    }


    @Nullable
    @Override
    public ISkyRenderHandler getSkyRenderHandler() {

        if(skyRenderHandler == null) {
            skyRenderHandler = new CustomCarthadgeSky();
        }
        return skyRenderHandler;
    }
}
