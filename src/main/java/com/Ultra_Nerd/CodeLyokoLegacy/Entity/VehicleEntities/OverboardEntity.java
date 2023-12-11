package com.Ultra_Nerd.CodeLyokoLegacy.Entity.VehicleEntities;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public final class OverboardEntity extends LyokoVehicleEntity {


    public OverboardEntity(final EntityType<? extends BoatEntity> entityType, final World world) {
        super(entityType, world);
        setNoGravity(true);
    }

    @Override
    public Item asItem() {
        return ModItems.OVERBOARD_SPAWN_ITEM;
    }

    @Override
    protected void addPassenger(final Entity passenger) {
        passenger.setPos(this.getX(), this.getY() + 0.5f, this.getZ());
        super.addPassenger(passenger);
    }
}
