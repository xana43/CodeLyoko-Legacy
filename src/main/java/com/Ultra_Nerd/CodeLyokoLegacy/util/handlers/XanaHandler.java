package com.Ultra_Nerd.CodeLyokoLegacy.util.handlers;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.util.enums.Capabilities.XanaAttackTypes;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldProperties;

import java.util.Random;

public record XanaHandler() {

    private static final Random random = new Random();
    private static int ticksToNextCalculation;
    private static WorldProperties properties;
    private static int ticksTillCalculation;
    private static MinecraftServer internalServer = null;
    public static Random getRandom()
    {
        return random;
    }

    public static void setProperties(final MinecraftServer server ,final WorldProperties wproperties) {
        properties = wproperties;
        internalServer = server;
        calculateValidAttackPositions();
    }

    private static void calculateValidAttackPositions()
    {
        final ServerWorld world = internalServer.getOverworld();

        final int radius = CardinalData.XanaCalculator.getRadius(properties);
        final BlockPos factoryPosition = CardinalData.XanaCalculator.getActiveFactoryPosition(properties);
        final XanaAttackTypes attackTypes = CardinalData.XanaCalculator.getAttackTypes(properties);
        int maxEntityHeight = 0;
        for(final Entity entity : attackTypes.getAttackers())
        {
            final float retrievedEntityHeight = entity.getHeight();
            if(retrievedEntityHeight > maxEntityHeight)
            {
                maxEntityHeight = Math.round(retrievedEntityHeight);
            }
        }
        for(int i = -(radius >> 1); i < radius; i++)
        {
            for(final Direction direction : Direction.values())
            {
                if(world.getBlockState(factoryPosition.offset(direction,i)) == Blocks.AIR.getDefaultState())
                {
                    for(int h = 0; h < maxEntityHeight; h++)
                    {
                        if(world.getBlockState(factoryPosition.offset(direction,i+h)) == Blocks.AIR.getDefaultState())
                        {
                            CardinalData.XanaCalculator.addValidAttackPosition(internalServer,properties,factoryPosition.offset(direction,i));
                        }
                    }
                }
            }
        }
    }

    public static void setTicksToNextCalculation(final int seconds) {
        ticksToNextCalculation = MethodUtil.TickConversion.secondsToTicks(seconds);
        setTicksTillCalculation();
    }

    private static void setTicksTillCalculation() {
        ticksTillCalculation = random.nextInt(ticksToNextCalculation, (ticksToNextCalculation + 1) << 2);
    }

    public static boolean calculateAttackProbability() {

        final int attackCallID = random.nextInt(69, 70);
        ticksTillCalculation--;
        if (ticksTillCalculation <= 0) {
            CodeLyokoMain.LOG.error("attack ID ="+attackCallID);
            if (attackCallID == 69) {
                if(CardinalData.XanaCalculator.getDangerLevel(properties) > 3)
                {
                    CodeLyokoMain.LOG.error("xana is attacking");
                    CardinalData.XanaCalculator.spawnEntities(internalServer,properties,internalServer.getOverworld());
                    CardinalData.XanaCalculator.activateTower(internalServer,properties);
                } else {
                    CodeLyokoMain.LOG.error("adding to danger level");
                    CardinalData.XanaCalculator.increaseDangerLevel(internalServer, properties, 1);
                }
                return true;
            } else {
                setTicksTillCalculation();
                return false;
            }
        }
        return false;
    }

}
