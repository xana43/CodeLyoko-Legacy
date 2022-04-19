package com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public final class HoverboardEntity extends LyokoVehicleEntity  {

    public HoverboardEntity(EntityType<? extends LyokoVehicleEntity> p_38290_, Level p_38291_) {
        super(ModEntities.HOVERBOARD.get(), p_38291_);
    }

}