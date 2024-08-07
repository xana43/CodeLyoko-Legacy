package com.Ultra_Nerd.CodeLyokoLegacy.Player.Capabilities;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.CardinalData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;

public final class MiscellaneousPlayerClassDataComponent implements AutoSyncedComponent {
    private final PlayerEntity player;
    private int[] hasSecondaryAbility = new int[]{0,0,0,0};
    private static final String SECONDARY_ABILITY_ARRAY_KEY = "has_secondary_ability";
    public MiscellaneousPlayerClassDataComponent(final PlayerEntity player)
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
    public void readFromNbt(final NbtCompound tag,final RegistryWrapper.WrapperLookup registryLookup) {
        hasSecondaryAbility = tag.getIntArray(SECONDARY_ABILITY_ARRAY_KEY);
    }

    @Override
    public void writeToNbt(final NbtCompound tag,final RegistryWrapper.WrapperLookup registryLookup) {
        tag.putIntArray(SECONDARY_ABILITY_ARRAY_KEY,hasSecondaryAbility);
    }
}
