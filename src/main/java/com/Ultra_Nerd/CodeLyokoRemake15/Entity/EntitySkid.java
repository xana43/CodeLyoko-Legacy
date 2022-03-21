package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.network.IPacket;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.World;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nonnull;

public class EntitySkid extends Boat {


    public EntitySkid(Level worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);

    }

    public EntitySkid(EntityType<EntitySkid> entitySkidEntityType, Level world) {
        super(entitySkidEntityType, world);
    }

    @Nonnull
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }


    @Override
    public float getDamage() {
        return 0;
    }
}
