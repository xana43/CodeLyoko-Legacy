package com.Ultra_Nerd.CodeLyokoLegacy.Entity.ProjectileEntities;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.MethodUtil;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


public final class EntityLaser extends ArrowEntity {


    private int lifetime;
    private int calculatedDamage;

    public EntityLaser(final World world, final double x, final double y, final double z, final int lifetime) {
        super(world, x, y, z);
        this.shake = 0;
        setLifetime(lifetime);

    }

    public EntityLaser(final EntityType<? extends ArrowEntity> entityType, final World world) {
        super(entityType, world);
        this.shake = 0;

    }

    /**
     * Instantiates a new laser entity with just the world and the owner USE WITH A CALL SITE VELOCITY AND DIRECTION IMPLEMENTATION
     *
     * @param world    the world this entity is being instantiated in
     * @param owner    the entity that spawned this entity
     * @param lifetime the lifetime of the entity IN SECONDS (used to clean up when the entity is just floating in the air due to drag)
     */
    public EntityLaser(final World world, final LivingEntity owner, final int lifetime) {
        super(world, owner);
        this.shake = 0;
        this.setLifetime(lifetime);
    }

    @Override
    protected float getDragInWater() {
        return 0;
    }
    private void calculateHitDamage() {
        final int velocityDamageScale = MathHelper.ceil(MathHelper.clamp(this.getVelocity().length() * this.getDamage(),0.0,2.147483647E9));
        if(isCritical()) {
            final long randomLong = this.random.nextInt(velocityDamageScale / 2 + 2);
            calculatedDamage = (int) Math.min(randomLong +(long) velocityDamageScale,2147483647L);
        } else {
            calculatedDamage = velocityDamageScale;
        }
    }
    @Override
    public void tick() {
        super.tick();
        this.setVelocity(this.getVelocity());
        this.shake = 0;
        destroyAtTheEndOfLife();

    }

    @Override
    public void slowMovement(final BlockState state, final Vec3d multiplier) {

    }

    @Override
    public void setShotFromCrossbow(final boolean shotFromCrossbow) {
        super.setShotFromCrossbow(true);
    }

    public void setLifetime(final int seconds) {
        this.lifetime = MethodUtil.TickConversion.secondsToTicks(seconds);
    }

    public int getLifetime(final boolean ticks) {
        if (ticks) {
            return lifetime;
        } else {
            return MethodUtil.TickConversion.tickToSeconds(lifetime);
        }
    }

    public int getCalculatedDamage() {
        return calculatedDamage;
    }

    private void destroyAtTheEndOfLife() {
        lifetime--;
        if (lifetime <= 0) {
            if (!getWorld().isClient) {
                this.kill();
            }
        }
    }

    @Override
    protected void onEntityHit(final EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        if (!getWorld().isClient) {
            this.kill();
        }
    }

    @Override
    protected void onBlockHit(final BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        calculateHitDamage();
        if (!getWorld().isClient) {
            this.kill();
        }
    }


}