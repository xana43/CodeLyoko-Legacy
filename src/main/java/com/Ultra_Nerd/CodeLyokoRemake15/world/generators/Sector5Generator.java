package com.Ultra_Nerd.CodeLyokoRemake15.world.generators;

import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.Carthadge.Sector5GenSettings;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.NoiseChunkGenerator;

public class Sector5Generator extends NoiseChunkGenerator<Sector5GenSettings> {


    public Sector5Generator(IWorld worldIn, BiomeProvider biomeProvidein, Sector5GenSettings settingsIn) {
        super(worldIn, biomeProvidein, 8, 4, 128, settingsIn, true);
    }


    @Override
    protected void fillNoiseColumn(double[] noiseColumn, int noiseX, int noiseZ) {
        double d0 = 12.824D;
        double d1 = 4.412D;
        double d2 = 7.110300000000002D;
        double d3 = 4.277575000000001D;
        int i = 64;
        int j = -3000;
        this.calcNoiseColumn(noiseColumn, noiseX, noiseZ, 12.824D, 4.412D, 17.110300000000002D, 4.277575000000001D, 64, -3000);
    }

    protected double[] getBiomeNoiseColumn(int noiseX, int noiseZ) {
        return new double[]{(double)this.biomeProvider.func_222365_c(noiseX, noiseZ), 0.0D};
    }

    protected double func_222545_a(double p_222545_1_, double p_222545_3_, int p_222545_5_) {
        return 8.0D - p_222545_1_;
    }

    protected double func_222551_g() {
        return (double)((int)super.func_222551_g() / 2);
    }

    protected double func_222553_h() {
        return 8.0D;
    }



    @Override
    public int getGroundHeight() {
        return 50;
    }

    @Override
    public int getSeaLevel() {
        return 1;
    }
}
