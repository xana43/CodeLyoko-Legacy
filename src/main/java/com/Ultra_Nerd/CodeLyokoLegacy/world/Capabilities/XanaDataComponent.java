package com.Ultra_Nerd.CodeLyokoLegacy.world.Capabilities;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.TowerInterfaceTileEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModDimensions;
import com.Ultra_Nerd.CodeLyokoLegacy.util.ThreadUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.util.enums.Capabilities.XanaAttackTypes;
import com.Ultra_Nerd.CodeLyokoLegacy.util.handlers.XanaHandler;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

@SuppressWarnings("MethodMayBeStatic")
public final class XanaDataComponent implements AutoSyncedComponent {
    private static final EntityType<?>[] entitiesToSpawn = {};
    private int dangerLevel;
    private static final String DANGER_LEVEL_KEY = "xana_danger_level";
    private static final String FACTORY_POSITION_KEY = "active_factory_position";
    private static final String ATTACK_TYPE_KEY = "attack_type";
    private static final String ATTACK_POSITION_KEY = "attack_position";
    private static final String TOWER_POSITION = "tower_position";
    private static BlockPos activeFactoryPosition = BlockPos.ORIGIN,towerPosition = BlockPos.ORIGIN;
    private static XanaAttackTypes attackType;
    public int getDangerLevel() {
        return dangerLevel;
    }
    private static final ObjectArrayList<Entity> entityList = new ObjectArrayList<>();
    private static final List<Long> validAttackPositions = new LongArrayList();
    private static int RADIUS = 10;
    public void setDangerLevel(final int level) {
        if(level <= 0)
        {
            towerPosition = BlockPos.ORIGIN;
            for(final Entity entity : entityList)
            {
                entity.kill();
            }
        }
        dangerLevel = level;
    }
    public void setActiveFactoryPosition(final BlockPos activeFactoryPosition)
    {
        XanaDataComponent.activeFactoryPosition = activeFactoryPosition;
    }


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
    public boolean hasActivatedTower()
    {
        return towerPosition != BlockPos.ORIGIN;
    }
    private static final ObjectArrayList<RegistryKey<World>> worldsToActivate = ObjectArrayList.of(ModDimensions.desertSectorWorld);
    public synchronized void activateTower(final MinecraftServer server)
    {
        ThreadUtil.LARGE_TASK_THREAD_EXECUTOR.submit(() -> {
            final ServerWorld world = server.getWorld(worldsToActivate.get(XanaHandler.getRandom().nextInt(worldsToActivate.size() - 1)));
            for(int x = 0; x < XanaHandler.getRandom().nextInt(300); ++x)
            {
                for(int y = 0; y < world.getTopY(); ++y)
                {
                    for(int z = 0; z < XanaHandler.getRandom().nextInt(300); ++z)
                    {
                        final BlockPos checkedPosition = new BlockPos(x,y,z);
                        final BlockState checkedState = world.getBlockState(checkedPosition);
                        if(checkedState.isOf(ModBlocks.TOWER_INTERFACE))
                        {
                            final TowerInterfaceTileEntity towerInterfaceTileEntity = (TowerInterfaceTileEntity) world.getBlockEntity(checkedPosition);
                            towerInterfaceTileEntity.calculateTowerActivation(1);
                            towerPosition = checkedPosition;
                        }
                    }
                }
            }
        });

    }
    public void spawnMobs(final World world)
    {
        int spawnIndex = 0;
        attackType = XanaAttackTypes.values()[world.getRandom().nextInt(XanaAttackTypes.values().length)];
        for(final Long pos : validAttackPositions)
        {
            final BlockPos blockPos = BlockPos.fromLong(pos);
            final Entity entity = entitiesToSpawn[spawnIndex].create(world);
            entityList.add(entity);
            Objects.requireNonNull(entity).setPos(blockPos.getX(),blockPos.getY(),blockPos.getZ());
            CodeLyokoMain.LOG.debug(String.valueOf(world.spawnEntity(entity)));
            spawnIndex++;
            if(spawnIndex > entitiesToSpawn.length - 1)
            {
                spawnIndex = 0;
            }

        }
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
        towerPosition = BlockPos.fromLong(tag.getLong(TOWER_POSITION));
        for(final long longValue : tag.getLongArray(ATTACK_POSITION_KEY)) {XanaDataComponent.validAttackPositions.add(longValue);}
    }

    @Override
    public void writeToNbt(final @NotNull NbtCompound tag) {
        tag.putInt(DANGER_LEVEL_KEY, dangerLevel);
        if(attackType == null)
        {
            attackType = XanaAttackTypes.DUMMY;
        }
        tag.putLong(TOWER_POSITION,towerPosition.asLong());
        tag.putInt(ATTACK_TYPE_KEY,attackType.ordinal());
        tag.putLong(FACTORY_POSITION_KEY,activeFactoryPosition.asLong());
        tag.putLongArray(ATTACK_POSITION_KEY,XanaDataComponent.validAttackPositions);
    }
}
