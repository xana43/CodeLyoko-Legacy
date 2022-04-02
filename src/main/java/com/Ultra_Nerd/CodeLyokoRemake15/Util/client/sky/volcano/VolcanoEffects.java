package com.Ultra_Nerd.CodeLyokoRemake15.Util.client.sky.volcano;

import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.ICloudRenderHandler;
import net.minecraftforge.client.ISkyRenderHandler;
import org.jetbrains.annotations.Nullable;

public class VolcanoEffects extends DimensionSpecialEffects {
    public VolcanoEffects() {
        super(Float.NaN, false, SkyType.NONE, true, true);
    }

    @Override
    public Vec3 getBrightnessDependentFogColor(Vec3 pFogColor, float pBrightness) {
        return pFogColor;
    }

    @Override
    public boolean isFoggyAt(int pX, int pY) {
        return false;
    }


    @Nullable
    @Override
    public ISkyRenderHandler getSkyRenderHandler() {
        return new CustomVolcanoSky();
    }

    @Nullable
    @Override
    public ICloudRenderHandler getCloudRenderHandler() {
        return null;
    }
}
