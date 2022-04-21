package com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.world.World;

public class LyokoVehicleEntity extends BoatEntity {
    public boolean movingUp = false;
    public boolean movingDown = false;

    public LyokoVehicleEntity(final EntityType<? extends BoatEntity> entityType, final World world) {
        super(entityType, world);
    }

/*
    @Nullable
    @Override
    protected SoundEvent getPaddleSound() {
        return null;
    }

    @Override
    public void setPaddleState(boolean pLeft, boolean pRight) {
        super.setPaddleState(false, false);
    }


    @Override
    public float getGroundFriction() {
        return -10;
    }

    @Override
    protected @NotNull SoundEvent getSwimSound() {
        return null;
    }

    @Override
    public boolean isVehicle() {
        return true;
    }

    @Override
    public boolean canBeRiddenInWater(Entity rider) {
        return false;
    }

    @Override
    public @NotNull Item getDropItem() {
        return ItemStack.EMPTY.getItem();
    }

    @Override
    public boolean shouldRiderSit() {
        return false;
    }

    protected void movement()
    {
        if(movingDown)
        {

            this.setDeltaMovement(getDeltaMovement().subtract(0,1,0));
        }
        if(movingUp)
        {
            this.setDeltaMovement(getDeltaMovement().add(0,1,0));

        }

    }

    @Override
    public void tick() {
        super.tick();
        if(!DimensionCheck.EntityNotInVanillaWorld(this))
        {
            this.remove(RemovalReason.DISCARDED);
        }
        this.movement();

    }

 */



}
