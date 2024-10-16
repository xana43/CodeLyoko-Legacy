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

public class LyokoVehicleEntity extends BoatEntity {



    public LyokoVehicleEntity(final EntityType<? extends BoatEntity> entityType, final World world) {
        super(entityType, world);
        if (!MethodUtil.DimensionCheck.isEntityInLyoko(this)) {
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
    public boolean shouldDismountUnderwater() {
        return true;
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
