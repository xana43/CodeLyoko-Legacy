package com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public final class OverboardEntity extends LyokoVehicleEntity  {



    public OverboardEntity(EntityType<? extends LyokoVehicleEntity> p_38290_, World p_38291_) {
        super(/*ModEntities.OVERBOARD*/ p_38290_, p_38291_);
        this.setNoGravity(true);


    }




    @Override
    public void updatePassengerPosition(final Entity passenger) {
        super.updatePassengerPosition(passenger);
        passenger.setPos(this.getX(),this.getY() + 0.5f,this.getZ());
    }
}
