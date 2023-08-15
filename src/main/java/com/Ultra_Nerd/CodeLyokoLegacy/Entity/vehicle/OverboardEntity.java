package com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.world.World;

public final class OverboardEntity extends LyokoVehicleEntity {


    public OverboardEntity(EntityType<? extends LyokoVehicleEntity> p_38290_, World p_38291_) {
        super(p_38290_, p_38291_);

        this.setPaddleMovings(false, false);
        setNoGravity(true);

    }

    @Override
    public boolean handleFallDamage(final float fallDistance, final float damageMultiplier, final DamageSource damageSource) {
        return false;
    }

    @Override
    protected void addPassenger(final Entity passenger) {
        passenger.setPos(this.getX(), this.getY() + 0.5f, this.getZ());
        super.addPassenger(passenger);
    }
}
