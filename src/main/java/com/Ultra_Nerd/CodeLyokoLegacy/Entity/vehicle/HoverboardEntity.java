package com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle;

import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public final class HoverboardEntity extends LyokoVehicleEntity {

    @Override
    public void setNoGravity(final boolean noGravity) {
        super.setNoGravity(true);
    }
    public HoverboardEntity(final EntityType<? extends LyokoVehicleEntity> entityType, final World world) {
        super(entityType, world);
    }
}
