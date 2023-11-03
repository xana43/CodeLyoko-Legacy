package com.Ultra_Nerd.CodeLyokoLegacy.blocks.Sector;

import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.PacketHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModDimensions;
import it.unimi.dsi.fastutil.objects.ObjectImmutableList;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public final class SectorEntrance extends Block {
    public enum SELECTORS {
        FOREST,
        DESERT,
        ICE,
        MOUNTAIN,
        CARTHAGE,
        DIGITAL_OCEAN,
        VOLCANO
    }
    private static final ObjectImmutableList<RegistryKey<World>> SECTOR_KEYS = ObjectImmutableList.of(
            ModDimensions.forestSectorWorld,
            ModDimensions.desertSectorWorld,
            ModDimensions.iceSectorWorld,
            ModDimensions.mountainSectorWorld,
            ModDimensions.carthage,
            ModDimensions.digitalOceanWorld,
            ModDimensions.volcanoWorld);
    private final int sectorSelector;
    private final PacketByteBuf SectorPacket = PacketByteBufs.create();
    public SectorEntrance(final Settings settings,final SELECTORS selectors) {
        super(settings);
        sectorSelector = selectors.ordinal();
    }



    @Override
    public void onEntityLand(final BlockView world, final Entity entity) {
        super.onEntityLand(world, entity);

        if (entity instanceof PlayerEntity ) {
               SectorPacket.clear();
               SectorPacket.resetReaderIndex();
               SectorPacket.writeRegistryKey(SECTOR_KEYS.get(sectorSelector));
            ClientPlayNetworking.send(PacketHandler.REPLIKA_ENTRY,SectorPacket);
        }

    }

}
