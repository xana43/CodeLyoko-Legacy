package com.Ultra_Nerd.CodeLyokoLegacy.player.Capabilities;

import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldProperties;

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
        public void readFromNbt(final NbtCompound tag) {
            SUPER_CALCULATOR_LOCATIONS.clear();
            for(final String tagKey : tag.getKeys())
            {
                SUPER_CALCULATOR_LOCATIONS.add(BlockPos.fromLong(tag.getLong(tagKey)));
            }
        }
        private static final String CALCULATOR_POSITIONS = "calculator_position0";
        private static final StringBuilder LOOP_STRING_BUILDER = new StringBuilder(CALCULATOR_POSITIONS);
        @Override
        public void writeToNbt(final NbtCompound tag) {
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