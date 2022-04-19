package com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModDimensions;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public final class EntitySkid extends LyokoVehicleEntity{



    public EntitySkid(@NotNull EntityType<? extends LyokoVehicleEntity> entitySkidEntityType, @NotNull Level world) {
        super(entitySkidEntityType, world);


    }

    @Override
    public boolean shouldRiderSit() {
        return true;
    }

    @Override
    public void dismountTo(double pX, double pY, double pZ) {
        if(level.dimension() != ModDimensions.DIGITAL_OCEAN)
        {
            super.dismountTo(pX,pY,pZ);
        }

    }

    @Override
    public void setDeltaMovement(final Vec3 pMotion) {
        super.setDeltaMovement(pMotion.add(16,16,16));
    }

    @Override
    public boolean canRiderInteract() {
        return true;
    }



    @Override
    public boolean showVehicleHealth() {
        return true;
    }

    @Override
    public boolean rideableUnderWater() {
        return true;
    }

    @Override
    public boolean canBeRiddenInWater(Entity rider) {
        return true;
    }








    @Nonnull
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public void positionRider(@NotNull Entity pPassenger) {
        super.positionRider(pPassenger);
        pPassenger.setPos(this.getX(),this.getY() + 7, this.getZ());
    }

    @Override
    public void ejectPassengers() {
        //super.ejectPassengers();
    }



    @Override
    public void tick() {
        super.tick();
        this.setNoGravity(this.isUnderWater());
          for (int i = 0; i < getPassengers().size(); i++)
          {
              getPassengers().get(i).setAirSupply(getPassengers().get(i).getMaxAirSupply());
          }

    }






}
