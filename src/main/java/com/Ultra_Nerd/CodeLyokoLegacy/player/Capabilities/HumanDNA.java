package com.Ultra_Nerd.CodeLyokoLegacy.player.Capabilities;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModDimensions;
import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.entity.PlayerComponent;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public final class HumanDNA implements AutoSyncedComponent, PlayerComponent<HumanDNA> {
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

    private static boolean searchForValidRespawnPositions(final World world, final BlockPos blockPos) {
        return (world.getBlockState(blockPos).isOf(ModBlocks.TOWER_INTERFACE))
                && !world.getBlockState(blockPos).isOf(ModBlocks.DIGITAL_LAVA_BLOCK)
                && !world.getBlockState(blockPos).isOf(ModBlocks.DIGITAL_OCEAN_BLOCK)
                && world.getBlockState(blockPos.offset(Direction.UP, 1)).isOf(Blocks.AIR)
                && world.getBlockState(blockPos.offset(Direction.UP, 2)).isOf(Blocks.AIR);
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
    public void calculateValidSpawns()
    {
        if (!hasDNA && !player.getWorld().isClient()) {
            final ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity) player;
            if (MethodUtil.DimensionCheck.worldIsVanilla(serverPlayerEntity.getSpawnPointDimension())) {
                final BlockPos worldOrigin = new BlockPos(BlockPos.ORIGIN);
                for (int x = 0; x < (32 * 16); x++) {
                    for (int y = 20; y < 384; y++) {
                        for (int z = 0; z < (32 * 16); z++) {
                            final BlockPos checkedPosition = worldOrigin.add(x,y,z);
                            if (serverPlayerEntity.getWorld().getRegistryKey() == ModDimensions.digitalOceanWorld) {
                                final int DimensionChooser = ThreadLocalRandom.current().nextInt(0, 7);
                                switch (DimensionChooser) {
                                    case 0 -> {
                                        if (searchForValidRespawnPositions(serverPlayerEntity.getServer()
                                                .getWorld(ModDimensions.forestSectorWorld), checkedPosition)) {
                                            final BlockPos towerSpawnPosition = checkedPosition
                                                    .offset(Direction.NORTH, 1);
                                            serverPlayerEntity.setSpawnPoint(ModDimensions.forestSectorWorld,
                                                    towerSpawnPosition, 0, true, true);
                                            return;
                                        }
                                    }
                                    case 1 -> {
                                        if (searchForValidRespawnPositions(serverPlayerEntity.getServer()
                                                .getWorld(ModDimensions.desertSectorWorld), checkedPosition)) {
                                            final BlockPos towerSpawnPosition = checkedPosition
                                                    .offset(Direction.NORTH, 1);
                                            serverPlayerEntity.setSpawnPoint(ModDimensions.desertSectorWorld,
                                                    towerSpawnPosition, 0, true, true);
                                            return;
                                        }
                                    }
                                    case 2 -> {
                                        if (searchForValidRespawnPositions(
                                                serverPlayerEntity.getServer().getWorld(ModDimensions.iceSectorWorld),
                                                checkedPosition)) {
                                            final BlockPos towerSpawnPosition = checkedPosition
                                                    .offset(Direction.NORTH, 1);
                                            serverPlayerEntity.setSpawnPoint(ModDimensions.iceSectorWorld,
                                                    towerSpawnPosition, 0, true, true);
                                            return;
                                        }
                                    }
                                    case 3 -> {
                                        if (searchForValidRespawnPositions(serverPlayerEntity.getServer()
                                                        .getWorld(ModDimensions.mountainSectorWorld),
                                                checkedPosition)) {
                                            final BlockPos towerSpawnPosition = checkedPosition
                                                    .offset(Direction.NORTH, 1);
                                            serverPlayerEntity.setSpawnPoint(ModDimensions.mountainSectorWorld,
                                                    towerSpawnPosition, 0, true, true);
                                            return;
                                        }
                                    }
                                    case 4 -> {
                                        if (searchForValidRespawnPositions(
                                                serverPlayerEntity.getServer().getWorld(ModDimensions.carthage),
                                                checkedPosition)) {
                                            final BlockPos towerSpawnPosition = checkedPosition
                                                    .offset(Direction.NORTH, 1);
                                            serverPlayerEntity.setSpawnPoint(ModDimensions.carthage,
                                                    towerSpawnPosition, 0, true, true);
                                            return;
                                        }
                                    }
                                    case 5 -> {
                                        if (searchForValidRespawnPositions(
                                                serverPlayerEntity.getServer().getWorld(ModDimensions.frontierWorld),
                                                checkedPosition)) {
                                            final BlockPos towerSpawnPosition = checkedPosition
                                                    .offset(Direction.NORTH, 1);
                                            serverPlayerEntity.setSpawnPoint(ModDimensions.frontierWorld,
                                                    towerSpawnPosition, 0, true, true);
                                            return;
                                        }
                                    }
                                    case 6 -> {
                                        if (searchForValidRespawnPositions(
                                                serverPlayerEntity.getServer().getWorld(ModDimensions.volcanoWorld),
                                                checkedPosition)) {
                                            final BlockPos towerSpawnPosition = checkedPosition
                                                    .offset(Direction.NORTH, 1);
                                            serverPlayerEntity.setSpawnPoint(ModDimensions.volcanoWorld,
                                                    towerSpawnPosition, 0, true, false);
                                            return;
                                        }
                                    }

                                }
                            } else {
                                if (searchForValidRespawnPositions(serverPlayerEntity.getWorld(),
                                        checkedPosition)) {
                                    final BlockPos towerSpawnPosition = checkedPosition
                                            .offset(Direction.NORTH, 1);
                                    serverPlayerEntity.setSpawnPoint(player.getWorld().getRegistryKey(),
                                            towerSpawnPosition, 0, true, false);

                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public boolean getHasDna() {
        return hasDNA;
    }

    @Override
    public void readFromNbt(final NbtCompound tag) {
        final String DNAsurrogate = tag.getString(DNA_KEY);
        if (Objects.equals(DNAsurrogate, "")) {
            createDNA();
        } else {
            DNA = DNAsurrogate;
        }
        hasDNA = tag.getBoolean(HAS_DNA);
    }

    @Override
    public void writeToNbt(final NbtCompound tag) {
        tag.putString(DNA_KEY, DNA);
        tag.putBoolean(HAS_DNA, hasDNA);
    }
}
