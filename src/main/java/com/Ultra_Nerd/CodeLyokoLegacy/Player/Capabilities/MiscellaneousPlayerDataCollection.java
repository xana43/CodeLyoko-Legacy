package com.Ultra_Nerd.CodeLyokoLegacy.Player.Capabilities;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.CardinalData;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldProperties;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;

public record MiscellaneousPlayerDataCollection() {

    public static final class XanaRaidSpawnData implements AutoSyncedComponent
    {

        private static final int CHECK_RADIUS = 16;
        private static final ObjectArrayList<BlockPos> SUPER_CALCULATOR_LOCATIONS = new ObjectArrayList<>();
        private final WorldProperties properties;
        public XanaRaidSpawnData(final WorldProperties properties)
        {
            this.properties = properties;
        }
        @SuppressWarnings("MethodMayBeStatic")
        public void catalogSuperCalculatorPositions(final BlockPos pos, final MinecraftServer server)
        {
            if(!SUPER_CALCULATOR_LOCATIONS.contains(pos))
            {
                SUPER_CALCULATOR_LOCATIONS.add(pos);
                CardinalData.XanaCalculator.setActiveFactoryPosition(server,properties,pos);
            }
        }
        @SuppressWarnings("MethodMayBeStatic")
        public void removeFromCalculatorPositions(final BlockPos pos)
        {
            SUPER_CALCULATOR_LOCATIONS.remove(pos);
        }

        public static ObjectArrayList<BlockPos> getSuperCalculatorLocations()
        {
            return SUPER_CALCULATOR_LOCATIONS;
        }
        @Override
        public void readFromNbt(final NbtCompound tag, RegistryWrapper.WrapperLookup registryLookup) {
            SUPER_CALCULATOR_LOCATIONS.clear();
            for(final String tagKey : tag.getKeys())
            {
                SUPER_CALCULATOR_LOCATIONS.add(BlockPos.fromLong(tag.getLong(tagKey)));
            }
        }
        private static final String CALCULATOR_POSITIONS = "calculator_position0";
        private static final StringBuilder LOOP_STRING_BUILDER = new StringBuilder(CALCULATOR_POSITIONS);
        @Override
        public void writeToNbt(final NbtCompound tag,RegistryWrapper.WrapperLookup registryLookup) {
            int index = 0;

            for(final BlockPos pos : SUPER_CALCULATOR_LOCATIONS)
            {

                LOOP_STRING_BUILDER.delete(20,LOOP_STRING_BUILDER.toString().length());
                LOOP_STRING_BUILDER.append(index);
                tag.putLong(LOOP_STRING_BUILDER.toString(), pos.asLong());
                ++index;
            }
        }
    }

}
