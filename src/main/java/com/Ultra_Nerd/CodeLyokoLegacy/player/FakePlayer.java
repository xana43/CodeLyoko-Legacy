package com.Ultra_Nerd.CodeLyokoLegacy.player;

import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

import java.util.Objects;
import java.util.UUID;
import java.util.WeakHashMap;

public class FakePlayer extends ServerPlayerEntity {
    private static final WeakHashMap<World,FakePlayer> FAKE_PLAYERS = new WeakHashMap<>();
    private static final GameProfile PROFILE =
            new GameProfile(UUID.fromString("ac77d636-cd3e-4fb3-9463-5a8f57560ba7"),"[CodeLyoko]");
    private FakePlayer(final ServerWorld world) {
        super(world.getServer(), world, PROFILE);
    }
    static FakePlayer getOrCreate(final ServerWorld serverWorld)
    {
        Objects.requireNonNull(serverWorld);
        final FakePlayer fakePlayer = FAKE_PLAYERS.get(serverWorld);
        if(fakePlayer != null)
        {
            return fakePlayer;
        }
        FakePlayer player = new FakePlayer(serverWorld);
        FAKE_PLAYERS.put(serverWorld,player);
        return player;
    }
    public static boolean isFakePlayer(final PlayerEntity player)
    {
        return player instanceof ServerPlayerEntity && player.getClass() != ServerPlayerEntity.class;
    }
}
