package com.Ultra_Nerd.CodeLyokoLegacy.Player.Capabilities;


import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;

public final class MindHelmStressComponent implements AutoSyncedComponent {

    private static final String stressKey = "stress_level";
    private int StressLevel = 0;

    public void addToStressLevel(final int stressor) {
        StressLevel += stressor;
    }

    public void decreaseStressLevel() {

        if (StressLevel > 0) {
            StressLevel -= 1;
        }
    }

    public int getStressLevel() {
        return StressLevel;
    }



    @Override
    public void readFromNbt(NbtCompound tag, RegistryWrapper.WrapperLookup registryLookup) {
        StressLevel = tag.getInt(stressKey);
    }

    @Override
    public void writeToNbt(NbtCompound tag, RegistryWrapper.WrapperLookup registryLookup) {
        tag.putInt(stressKey, StressLevel);
    }

}
