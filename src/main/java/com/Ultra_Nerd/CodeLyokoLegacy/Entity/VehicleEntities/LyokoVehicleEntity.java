package com.Ultra_Nerd.CodeLyokoLegacy.Entity.VehicleEntities;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.MethodUtil;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class LyokoVehicleEntity extends BoatEntity {



    public LyokoVehicleEntity(final EntityType<? extends BoatEntity> entityType, final World world, final Supplier<Item> itemSupplier) {
        super(entityType, world,itemSupplier);
        if (!MethodUtil.DimensionCheck.isEntityInLyoko(this)) {
            this.remove(RemovalReason.DISCARDED);
        }
    }

    @Override
    public void slowMovement(final BlockState state, final Vec3d multiplier) {

    }

    @Override
    protected @Nullable SoundEvent getPaddleSound() {
        return null;
    }

    @Override
    public float lerpPaddlePhase(int paddle, float tickProgress) {
        return 0;
    }

    @Override
    public void setPaddlesMoving(boolean left, boolean right) {
        super.setPaddlesMoving(false, false);
    }





    @Override
    public boolean shouldDismountUnderwater() {
        return true;
    }

    @Nullable
    @Override
    protected SoundEvent getSwimSound() {
        return null;
    }



    @Override
    protected void fall(final double heightDifference, final boolean onGround, final BlockState state, final BlockPos landedPosition) {

    }


    @Override
    protected void addPassenger(final Entity passenger) {
        super.addPassenger(passenger);
        passenger.setPose(EntityPose.STANDING);
    }
    public void toggleHover() {
        setNoGravity(!hasNoGravity());
        setVelocity(getVelocity().x, 0, getVelocity().z);
    }
    @Override
    public float getNearbySlipperiness() {
        return 0.90f;
    }

    public void moveUp() {
        this.addVelocity(getVelocity().x, getVelocity().y + 1, getVelocity().z);
    }
    public void moveDown() {
        this.addVelocity(getVelocity().x, getVelocity().y - 1, getVelocity().z);
    }


    @Override
    public void tick() {
        super.tick();

    }


}
