package com.Ultra_Nerd.CodeLyokoLegacy.player.Capabilities;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.entity.PlayerComponent;
import net.minecraft.nbt.NbtCompound;

public final class MindHelmStressComponent implements AutoSyncedComponent, PlayerComponent<MindHelmStressComponent> {

    private static final String stressKey = " stress_level";
    private int StressLevel = 0;

    public void addToStressLevel(final int stressor) {
        StressLevel += stressor;
        CodeLyokoMain.LOG.info("increasing stress");
    }

    public void decreaseStressLevel() {

        if (StressLevel > 0) {
            CodeLyokoMain.LOG.info("decreasing stress");
            StressLevel -= 1;
        }
    }

    public int getStressLevel() {
        return StressLevel;
    }

    @Override
    public void readFromNbt(final NbtCompound tag) {
        StressLevel = tag.getInt(stressKey);
    }

    @Override
    public void writeToNbt(final NbtCompound tag) {
        tag.putInt(stressKey, StressLevel);
    }
}
