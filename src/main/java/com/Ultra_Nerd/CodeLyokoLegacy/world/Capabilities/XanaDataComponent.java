package com.Ultra_Nerd.CodeLyokoLegacy.world.Capabilities;

import com.Ultra_Nerd.CodeLyokoLegacy.util.enums.Capabilities.XanaAttackTypes;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("MethodMayBeStatic")
public final class XanaDataComponent implements AutoSyncedComponent {
    private int dangerLevel;
    private static final String DANGER_LEVEL_KEY = "xana_danger_level";
    private static final String FACTORY_POSITION_KEY = "active_factory_position";
    private static final String ATTACK_TYPE_KEY = "attack_type";
    private static final String ATTACK_POSITION_KEY = "attack_position";
    private static BlockPos activeFactoryPosition = BlockPos.ORIGIN;
    private static XanaAttackTypes attackType;
    public int getDangerLevel() {
        return dangerLevel;
    }
    private static final List<Long> validAttackPositions = new ArrayList<>();
    public void setDangerLevel(final int level) {
        dangerLevel = level;
    }
    public void setActiveFactoryPosition(final BlockPos activeFactoryPosition)
    {
        XanaDataComponent.activeFactoryPosition = activeFactoryPosition;
    }
    private static int RADIUS = 10;

    public void setRadius(final int radius)
    {
        XanaDataComponent.RADIUS = radius;
    }
    public int getRadius()
    {
       return XanaDataComponent.RADIUS;
    }
    public void addValidAttackPositions(final BlockPos attackPosition)
    {
        XanaDataComponent.validAttackPositions.add(attackPosition.asLong());
    }
    public void removeValidAttackPosition(final BlockPos attackPosition)
    {
        XanaDataComponent.validAttackPositions.remove(attackPosition.asLong());
    }

    public void clearAllAttackPositions()
    {
        XanaDataComponent.validAttackPositions.clear();
    }
    public BlockPos getActiveFactoryPosition()
    {
        return activeFactoryPosition;
    }
    public void setAttackType(final XanaAttackTypes attackType)
    {
        XanaDataComponent.attackType = attackType;
    }
    public XanaAttackTypes getAttackType()
    {
        return XanaDataComponent.attackType;
    }
    public void increaseDangerLevel(final int dangerLevelIncrease)
    {
        dangerLevel += dangerLevelIncrease;
    }
    public void decreaseDangerLevel(final int dangerLevelDecrease)
    {
        dangerLevel -= dangerLevelDecrease;
    }
    @Override
    public void readFromNbt(final @NotNull NbtCompound tag) {
        dangerLevel = tag.getInt(DANGER_LEVEL_KEY);
        activeFactoryPosition = BlockPos.fromLong(tag.getLong(FACTORY_POSITION_KEY));
        attackType = XanaAttackTypes.values()[tag.getInt(ATTACK_TYPE_KEY)];
        for(final long longValue : tag.getLongArray(ATTACK_POSITION_KEY)) {XanaDataComponent.validAttackPositions.add(longValue);}
    }

    @Override
    public void writeToNbt(final @NotNull NbtCompound tag) {
        tag.putInt(DANGER_LEVEL_KEY, dangerLevel);
        if(attackType == null)
        {
            attackType = XanaAttackTypes.DUMMY;
        }
        tag.putInt(ATTACK_TYPE_KEY,attackType.ordinal());
        tag.putLong(FACTORY_POSITION_KEY,activeFactoryPosition.asLong());
        tag.putLongArray(ATTACK_POSITION_KEY,XanaDataComponent.validAttackPositions);
    }
}
