package com.Ultra_Nerd.CodeLyokoLegacy.Entity.DecorationEntities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.decoration.AbstractDecorationEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public final class XanaSymbolEntity extends AbstractDecorationEntity {
    public XanaSymbolEntity(final EntityType<? extends AbstractDecorationEntity> entityType,final World world) {
        super(entityType, world);
    }

    @Override
    protected Box calculateBoundingBox(BlockPos pos, Direction side) {
        return null;
    }

    @Override
    public void onBreak(@Nullable Entity entity) {

    }

    @Override
    public void onPlace() {

    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {

    }
}
