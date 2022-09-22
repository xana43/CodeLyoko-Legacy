package com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle;

import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class LyokoVehicleEntity extends BoatEntity {
    public boolean movingUp = false;
    public boolean movingDown = false;

    public LyokoVehicleEntity(final EntityType<? extends BoatEntity> entityType, final World world) {
        super(entityType, world);
        if (!MethodUtil.DimensionCheck.EntityNotInVanillaWorld(this)) {
            this.remove(RemovalReason.DISCARDED);
        }

    }


    @Override
    public void slowMovement(final BlockState state, final Vec3d multiplier) {

    }

    @Nullable
    @Override
    protected SoundEvent getPaddleSoundEvent() {
        return null;
    }


    @Override
    public float interpolatePaddlePhase(final int paddle, final float tickDelta) {
        return 0;
    }


    @Override
    public void setPaddleMovings(final boolean leftMoving, final boolean rightMoving) {
        super.setPaddleMovings(false, false);
    }


    @Override
    public boolean canBeRiddenInWater() {
        return false;
    }

    @Nullable
    @Override
    protected SoundEvent getSwimSound() {
        return null;
    }


    @Override
    public Item asItem() {
        return null;
    }

    @Override
    public void updatePassengerPosition(final Entity passenger) {
        passenger.setPose(EntityPose.STANDING);
        super.updatePassengerPosition(passenger);
    }

    @Override
    public float getNearbySlipperiness() {
        return 0.90f;
    }

    protected void movement() {

        if (movingDown) {

            this.addVelocity(getVelocity().x, getVelocity().y - 1, getVelocity().z);
        }
        if (movingUp) {
            this.addVelocity(getVelocity().x, getVelocity().y + 1, getVelocity().z);

        }

    }


    @Override
    public void tick() {
        super.tick();
        this.movement();

    }


}
