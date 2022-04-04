package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.vehicle.LyokoVehicleEntity;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nonnull;

public class EntitySkid extends LyokoVehicleEntity {



    public EntitySkid(EntityType<? extends LyokoVehicleEntity> entitySkidEntityType, Level world) {
        super(entitySkidEntityType, world);



    }

    @Override
    public boolean isNoGravity() {
        return false;
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

    @Override
    public float getWaterLevelAbove() {
        return super.getWaterLevelAbove();
    }

    @Nonnull
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }


    @Override
    public void baseTick() {
        super.baseTick();

            getPassengers().forEach(passenger -> {

                if(passenger instanceof Player)
                {
                    passenger.isInvulnerableTo(CodeLyokoMain.RegistryEventHandler.DigitaloceanDamageSource);
                    passenger.isInvulnerableTo(DamageSource.DROWN);

                }
            });

    }






}
