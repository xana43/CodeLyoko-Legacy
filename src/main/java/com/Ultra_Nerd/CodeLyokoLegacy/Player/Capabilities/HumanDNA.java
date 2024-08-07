package com.Ultra_Nerd.CodeLyokoLegacy.Player.Capabilities;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.CardinalData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.network.ServerPlayerEntity;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;

import java.util.Objects;

public final class HumanDNA implements AutoSyncedComponent{
    private static final char[] DNACoding = {'A', 'T', 'G', 'C'};

    private static final String DNA_KEY = "dna_key";
    private static final String HAS_DNA = "has_dna";
    private final PlayerEntity player;
    private String DNA = "";
    private boolean hasDNA = true;

    @Override
    public boolean shouldSyncWith(final ServerPlayerEntity player) {
        return player == this.player;
    }



    public HumanDNA(final PlayerEntity player) {
        this.player = player;
    }



    private void createDNA() {
        final StringBuilder DNASequence = new StringBuilder();
        final StringBuilder DNASequenceHelix2 = new StringBuilder();
        for (int i = 0; i < 100; i++)
        {

            DNASequence.append(DNACoding[player.getRandom().nextInt(DNACoding.length)]);
            switch (DNASequence.toString().charAt(i))
            {
                case 'A' -> DNASequenceHelix2.append('T');
                case 'T' -> DNASequenceHelix2.append('A');
                case 'C' -> DNASequenceHelix2.append('G');
                case 'G' -> DNASequenceHelix2.append('C');
            }
        }
        DNASequence.append('\n').append(DNASequenceHelix2);
        DNA = DNASequence.toString();
        CardinalData.HumanDNAAttribute.getHumanDnaComponentKey().sync(player);
    }

    public String getDNA() {
        if(DNA.isEmpty())
        {
            createDNA();
        }
        return DNA;
    }

    public void setHasDNA(final boolean hasDNA) {
        this.hasDNA = hasDNA;
        CardinalData.HumanDNAAttribute.getHumanDnaComponentKey().sync(player);
    }

    public boolean getHasDna() {
        return hasDNA;
    }

    @Override
    public void readFromNbt(final NbtCompound tag,final RegistryWrapper.WrapperLookup registryLookup) {
        final String DNAsurrogate = tag.getString(DNA_KEY);
        if (Objects.equals(DNAsurrogate, "")) {
            createDNA();
        } else {
            DNA = DNAsurrogate;
        }
        hasDNA = tag.getBoolean(HAS_DNA);
    }

    @Override
    public void writeToNbt(final NbtCompound tag,final RegistryWrapper.WrapperLookup registryLookup) {
        tag.putString(DNA_KEY, DNA);
        tag.putBoolean(HAS_DNA, hasDNA);
    }
}
