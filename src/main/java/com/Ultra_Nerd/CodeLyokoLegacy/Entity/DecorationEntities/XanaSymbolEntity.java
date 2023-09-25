package com.Ultra_Nerd.CodeLyokoLegacy.Entity.DecorationEntities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.AbstractDecorationEntity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public final class XanaSymbolEntity extends AbstractDecorationEntity {
    public XanaSymbolEntity(final EntityType<? extends AbstractDecorationEntity> entityType,final World world) {
        super(entityType, world);
    }

    @Override
    public int getWidthPixels() {
        return 0;
    }

    @Override
    public int getHeightPixels() {
        return 0;
    }

    @Override
    public void onBreak(@Nullable Entity entity) {

    }

    @Override
    public void onPlace() {

    }
}
