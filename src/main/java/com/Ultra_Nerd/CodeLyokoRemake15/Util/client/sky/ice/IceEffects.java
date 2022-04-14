package com.Ultra_Nerd.CodeLyokoRemake15.Util.client.sky.ice;

import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.ICloudRenderHandler;
import net.minecraftforge.client.ISkyRenderHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IceEffects extends DimensionSpecialEffects {
    public IceEffects() {
        super(Float.NaN, false, SkyType.NONE, true, true);
    }

    @Override
    public @NotNull Vec3 getBrightnessDependentFogColor(Vec3 pFogColor, float pBrightness) {
        return pFogColor;
    }

    @Override
    public boolean isFoggyAt(int pX, int pY) {
        return false;
    }

    @Nullable
    @Override
    public ICloudRenderHandler getCloudRenderHandler() {
        return null;
    }

    @Override
    public @NotNull ISkyRenderHandler getSkyRenderHandler() {
        return new CustomIceSky();
    }
}
