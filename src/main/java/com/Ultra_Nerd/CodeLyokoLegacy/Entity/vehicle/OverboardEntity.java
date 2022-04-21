package com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.world.World;

public final class OverboardEntity extends LyokoVehicleEntity  {
    public OverboardEntity(final EntityType<? extends BoatEntity> entityType, final World world) {
        super(entityType, world);
    }

/*
    public OverboardEntity(EntityType<?> p_38290_, Level p_38291_) {
        super(ModEntities.OVERBOARD.get(), p_38291_);



    }



    @Override
    protected float getBlockSpeedFactor() {
        return super.getBlockSpeedFactor();

    }

    @Override
    public boolean isNoGravity() {
        return true;
    }

    @Override
    public boolean showVehicleHealth() {
        return true;
    }




    @Override
    public void positionRider(@NotNull Entity pPassenger) {
        super.positionRider(pPassenger);
        pPassenger.setPos(this.getX(),this.getY() + 0.5f,this.getZ());
    }

 */


}
