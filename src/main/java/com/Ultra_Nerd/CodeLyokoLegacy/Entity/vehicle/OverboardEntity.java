package com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public final class OverboardEntity extends LyokoVehicleEntity  {


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


}
