package com.Ultra_Nerd.CodeLyokoLegacy.Util.client.sky.carthage;

import net.minecraft.client.render.DimensionEffects;
import net.minecraft.util.math.Vec3d;

public final class CarthageEffects extends DimensionEffects/*extends DimensionSpecialEffects*/ {
    public CarthageEffects() {
        super(Float.NaN, false, SkyType.NONE, true, false);
    }

    @Override
    public Vec3d adjustFogColor(final Vec3d color, final float sunHeight) {
        return null;
    }

    @Override
    public boolean useThickFog(final int camX, final int camY) {
        return false;
    }
    /*

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

     */
}
