package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import com.Ultra_Nerd.CodeLyokoRemake15.Entity.vehicle.LyokoVehicleEntity;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class EntitySkid extends LyokoVehicleEntity{



    public EntitySkid(EntityType<? extends LyokoVehicleEntity> entitySkidEntityType, Level world) {
        super(entitySkidEntityType, world);


    }

    @Override
    public boolean shouldRiderSit() {
        return true;
    }

    @Override
    public void dismountTo(double pX, double pY, double pZ) {

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
            getPassengers().forEach(passenger -> {

                if(passenger instanceof Player player)
                {
                    player.setAirSupply(passenger.getMaxAirSupply());






                }
            });

    }






}
