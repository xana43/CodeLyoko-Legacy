package com.Ultra_Nerd.CodeLyokoLegacy.Entity;

import net.minecraft.client.render.entity.ArrowEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;


public final class EntityLaser extends ArrowEntity
{
    @Override
    protected float getDragInWater() {
        return 0;
    }

    @Override
    public void tick() {
        super.tick();
        this.setVelocity(this.getVelocity());
    }

    public EntityLaser(final World world, final double x, final double y, final double z) {
        super(world, x, y, z);
        this.shake = 0;

    }



    public EntityLaser(final EntityType<? extends ArrowEntity> entityType, final World world) {
        super(entityType, world);
        this.shake = 0;
    }

     public EntityLaser(final World world,final LivingEntity owner)
     {
         super(world,owner);
         this.shake = 0;
     }



    @Override
    protected void onEntityHit(final EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        entityHitResult.getEntity().damage(DamageSource.arrow(this,this.getOwner()),0);

    }

    @Override
    protected void onBlockHit(final BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        if(!world.isClient) {
            this.kill();
        }
    }

    @Override
    protected void onCollision(final HitResult hitResult) {
        super.onCollision(hitResult);


    }
}