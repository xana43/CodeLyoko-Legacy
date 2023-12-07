package com.Ultra_Nerd.CodeLyokoLegacy.Entity.VehicleEntities;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public final class HoverboardEntity extends LyokoVehicleEntity {


    public HoverboardEntity(final EntityType<? extends LyokoVehicleEntity> entityType, final World world) {
        super(entityType, world);
        setNoGravity(true);
    }



    @Override
    public Item asItem() {
        return ModItems.HOVERBOARD_SPAWN_ITEM;
    }
}
