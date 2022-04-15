package com.Ultra_Nerd.CodeLyokoLegacy.Util.client.sky.carthage;

import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.ICloudRenderHandler;
import net.minecraftforge.client.ISkyRenderHandler;
import net.minecraftforge.client.IWeatherParticleRenderHandler;
import net.minecraftforge.client.IWeatherRenderHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CarthageEffects extends DimensionSpecialEffects {

    public CarthageEffects() {
        super(Float.NaN, false, SkyType.NONE, true, true);
    }

    @Override
    public void setCloudRenderHandler(ICloudRenderHandler cloudRenderHandler) {
    }

    @Nullable
    @Override
    public IWeatherRenderHandler getWeatherRenderHandler() {
        return null;
    }

    @Override
    public void setWeatherRenderHandler(IWeatherRenderHandler weatherRenderHandler) {

    }

    @Nullable
    @Override
    public IWeatherParticleRenderHandler getWeatherParticleRenderHandler() {
        return null;
    }

    @Override
    public void setWeatherParticleRenderHandler(IWeatherParticleRenderHandler weatherParticleRenderHandler) {

    }

    @Nullable
    @Override
    public ICloudRenderHandler getCloudRenderHandler() {
        return null;
    }

    @Override
    public float getCloudHeight() {
        return Float.NaN;
    }

    @Override
    public @NotNull Vec3 getBrightnessDependentFogColor(@NotNull Vec3 pFogColor, float pBrightness) {
        return pFogColor;
    }

    @Override
    public float @Nullable [] getSunriseColor(float pTimeOfDay, float pPartialTicks) {
        return null;
    }

    @Override
    public boolean isFoggyAt(int pX, int pY) {
        return false;
    }


    @Override
    public @NotNull ISkyRenderHandler getSkyRenderHandler() {


        return new CustomCarthadgeSky();
    }
}
