package com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public final class OverbikeEntity extends LyokoVehicleEntity {


    public OverbikeEntity(EntityType<? extends LyokoVehicleEntity> p_38290_, Level p_38291_) {
        super(ModEntities.OVERBIKE.get(), p_38291_);
    }
}