package com.Ultra_Nerd.CodeLyokoLegacy.Entity.DecorationEntities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.decoration.AbstractDecorationEntity;
import net.minecraft.entity.decoration.ItemFrameEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public final class XanaSymbolEntity extends AbstractDecorationEntity {
    public XanaSymbolEntity(final EntityType<? extends AbstractDecorationEntity> entityType,final World world) {
        super(entityType, world);
    }
    public XanaSymbolEntity(World world, BlockPos pos, Direction facing) {
        this(EntityType.ITEM_FRAME, world, pos, facing);
    }

    public XanaSymbolEntity(EntityType<? extends ItemFrameEntity> type, World world, BlockPos pos, Direction facing) {
        super(type, world, pos);
        setFacing(facing);
    }
    @Override
    protected Box calculateBoundingBox(BlockPos pos, Direction side) {
        return null;
    }



    @Override
    public void onPlace() {

    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {

    }

    @Override
    public void onBreak(ServerWorld world, @Nullable Entity breaker) {

    }
}
