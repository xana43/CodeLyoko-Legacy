package com.Ultra_Nerd.CodeLyokoLegacy.Util.handlers;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.CardinalData;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.MethodUtil;
import net.minecraft.world.WorldProperties;

import java.util.Random;

public record XanaHandler() {

    private static final Random random = new Random();
    private static int ticksToNextCalculation;
    private static int dangerLevel;
    private static WorldProperties properties;

    private static void setDangerLevelFromSave()
    {
        dangerLevel = CardinalData.XanaCalculator.getDangerLevel(properties);
    }

    public static void setProperties(final WorldProperties wproperties)
    {
        properties = wproperties;
        setDangerLevelFromSave();
    }
    public static int getDangerLevel()
    {
        return dangerLevel;
    }
    public static void resetDangerLevel()
    {
        dangerLevel = 0;
    }
    public static void setTicksToNextCalculation(final int seconds)
    {
        ticksToNextCalculation = MethodUtil.TickConversion.secondsToTicks(seconds);
        setTicksTillCalculation();
    }
    private static int ticksTillCalculation;
    private static void setTicksTillCalculation()
    {
        ticksTillCalculation = random.nextInt(ticksToNextCalculation, (ticksToNextCalculation + 1) << 2);
    }
    public static boolean calculateAttackProbability()
    {
        final int attackCallID = random.nextInt(0,200);
        CardinalData.XanaCalculator.setDangerLevel(dangerLevel,properties);
        ticksTillCalculation--;
        if(ticksTillCalculation <= 0)
        {
            if(attackCallID == 69)
            {
                dangerLevel++;

                return true;
            }
            else
            {

                setTicksTillCalculation();
                return false;
            }
        }
        return false;
    }

}
