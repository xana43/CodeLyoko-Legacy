package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModEntities;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nonnull;

public class EntityLaser extends Arrow {

    public EntityLaser(EntityType<? extends Arrow> Laser, Level world) {
        super(Laser, world);
        // TODO Auto-generated constructor stub
    }

    public EntityLaser(Level worldIn, LivingEntity throwerIn) {
        super(worldIn, throwerIn);
        // TODO Auto-generated constructor stub
    }

    public EntityLaser(Level worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
        // TODO Auto-generated constructor stub
    }

    public EntityLaser(Level world) {
        super(ModEntities.LASER, world);
    }

    @Nonnull
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }





    @Override
    public void setBaseDamage(double damageIn) {
        // TODO Auto-generated method stub
        super.setBaseDamage(damageIn);
    }

    @Override
    protected void onHitEntity(EntityHitResult live) {
        super.onHitEntity(live);
        if (this.level.isClientSide) {
            super.onHitEntity(live);
        }
    }




}
