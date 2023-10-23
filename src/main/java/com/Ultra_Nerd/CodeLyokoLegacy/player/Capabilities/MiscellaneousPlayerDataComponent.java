package com.Ultra_Nerd.CodeLyokoLegacy.player.Capabilities;

import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.entity.PlayerComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;

public final class MiscellaneousPlayerDataComponent implements PlayerComponent<MiscellaneousPlayerDataComponent>, AutoSyncedComponent {
    private final PlayerEntity player;
    private int[] hasSecondaryAbility = new int[]{0,0,0,0};
    private static final String SECONDARY_ABILITY_ARRAY_KEY = "has_secondary_ability";
    public MiscellaneousPlayerDataComponent(final PlayerEntity player)
    {
        this.player = player;
    }
    public boolean getHasSecondaryAbility()
    {
        return hasSecondaryAbility[CardinalData.LyokoClass.getLyokoClass(player)] != 0;
    }
    public void setHasSecondaryAbility()
    {
        switch (CardinalData.LyokoClass.getLyokoClass(player))
        {
            case 0 -> {}
            case 1 -> hasSecondaryAbility[1] = 1;
            case 2 -> {}
            case 3 -> {}
        }
    }

    @Override
    public void readFromNbt(final NbtCompound tag) {
        hasSecondaryAbility = tag.getIntArray(SECONDARY_ABILITY_ARRAY_KEY);
    }

    @Override
    public void writeToNbt(final NbtCompound tag) {
        tag.putIntArray(SECONDARY_ABILITY_ARRAY_KEY,hasSecondaryAbility);
    }
}
