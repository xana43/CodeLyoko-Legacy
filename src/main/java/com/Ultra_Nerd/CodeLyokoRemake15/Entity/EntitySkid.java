package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nonnull;

public class EntitySkid extends BoatEntity {


    public EntitySkid(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);

    }

    public EntitySkid(EntityType<EntitySkid> entitySkidEntityType, World world) {
        super(entitySkidEntityType, world);
    }

    @Nonnull
    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }


    @Override
    public void setDamageTaken(float damageTaken) {

        super.setDamageTaken(0);
    }


}
