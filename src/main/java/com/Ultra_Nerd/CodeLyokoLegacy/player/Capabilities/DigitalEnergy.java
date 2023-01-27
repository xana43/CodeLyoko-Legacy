package com.Ultra_Nerd.CodeLyokoLegacy.player.Capabilities;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.entity.PlayerComponent;
import net.minecraft.nbt.NbtCompound;

import java.util.concurrent.ThreadLocalRandom;

public final class DigitalEnergy implements AutoSyncedComponent, PlayerComponent<DigitalEnergy> {


    private static final int MAX_ENERGY = 128;
    private static final String DIGITAL_ENERGY_KEY = "digital_energy";
    private int currentEnergy = MAX_ENERGY;
    private boolean isUsingEnergy = false;
    public boolean useEnergy(final int energyUsage) {
        if (currentEnergy > 0 && currentEnergy >= energyUsage) {
            currentEnergy -= energyUsage;
            isUsingEnergy = true;
            return true;
        }
        isUsingEnergy = false;
        return false;
    }
    public void setUsingEnergy(final boolean isUsingEnergy)
    {
        this.isUsingEnergy = isUsingEnergy;
    }
    public boolean isUsingEnergy() {
        return isUsingEnergy;
    }

    public int getCurrentEnergy()
    {
        return currentEnergy;
    }
    public void regenerateEnergy() {
        if (currentEnergy < MAX_ENERGY) {
            currentEnergy += ThreadLocalRandom.current().nextInt(1, 2);
        } else if (currentEnergy > MAX_ENERGY) {
            currentEnergy = MAX_ENERGY;
        }
    }

    @Override
    public void readFromNbt(final NbtCompound tag) {
        currentEnergy = tag.getInt(DIGITAL_ENERGY_KEY);
    }

    @Override
    public void writeToNbt(final NbtCompound tag) {

        tag.putInt(DIGITAL_ENERGY_KEY, currentEnergy);
    }
}
