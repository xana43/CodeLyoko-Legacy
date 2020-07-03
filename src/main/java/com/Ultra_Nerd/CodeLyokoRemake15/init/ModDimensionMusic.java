package com.Ultra_Nerd.CodeLyokoRemake15.init;

import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
@OnlyIn(Dist.CLIENT)
public enum ModDimensionMusic  {



        FORESTSECTOR(ModSounds.FOREST.get(),1200,3600);
        private final SoundEvent sound;
        private final int minDelay;
        private final int maxDelay;




    ModDimensionMusic(SoundEvent Mus, int minDelayIn, int maxDelayIn) {
        this.sound = Mus;
        this.minDelay = minDelayIn;
        this.maxDelay = maxDelayIn;
    }

    /**
         * Gets the {@link SoundEvent} containing the current music track's location
         */
        public SoundEvent getSound() {
            return this.sound;
        }

        /**
         * Returns the minimum delay between playing music of this type.
         */
        public int getMinDelay() {
            return this.minDelay;
        }

        /**
         * Returns the maximum delay between playing music of this type.
         */
        public int getMaxDelay() {
            return this.maxDelay;
        }

}
