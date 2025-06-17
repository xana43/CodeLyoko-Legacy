package com.Ultra_Nerd.CodeLyokoLegacy.Entity.ProjectileEntities;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.MethodUtil;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


public final class LaserEntity extends ArrowEntity {


    private int lifetime;

    public LaserEntity(final World world, final double x, final double y, final double z, final int lifetime) {
        super(world, x, y, z, ItemStack.EMPTY,ItemStack.EMPTY);
        this.shake = 0;
        setLifetime(lifetime);

    }

    public LaserEntity(final EntityType<? extends ArrowEntity> entityType, final World world) {
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
    public LaserEntity(final World world, final LivingEntity owner, final int lifetime) {
        super(world, owner,ItemStack.EMPTY,ItemStack.EMPTY);
        this.shake = 0;
        this.setLifetime(lifetime);
    }

    @Override
    protected float getDragInWater() {
        return 0;
    }
    private int calculateHitDamage() {
        final int velocityDamageScale = MathHelper.ceil(MathHelper.clamp(this.getVelocity().length() * getVelocityMultiplier(),0.0,2.147483647E9));
        if(isCritical()) {
            final long randomLong = this.random.nextInt(velocityDamageScale / 2 + 2);
            return (int) Math.min(randomLong +(long) velocityDamageScale,2147483647L);
        }
        return velocityDamageScale;

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

    private void destroyAtTheEndOfLife() {
        lifetime--;
        if (lifetime <= 0) {
            if (!getWorld().isClient) {
                this.kill((ServerWorld) getWorld());
            }
        }
    }

    @Override
    protected void onEntityHit(final EntityHitResult entityHitResult) {
        final Entity ownerEntity = getOwner();
        final Entity entityHit = entityHitResult.getEntity();
        if(ownerEntity instanceof final LivingEntity livingEntity) {
            livingEntity.onAttacking(entityHit);
        }
        final DamageSource laserArrowDamageSource = this.getDamageSources().arrow(this, ownerEntity != null ? ownerEntity : this);
        if(entityHit.damage((ServerWorld) getWorld(),laserArrowDamageSource,calculateHitDamage())){

        }
        if (!getWorld().isClient) {
            this.kill((ServerWorld)  getWorld());
        }
    }

    @Override
    protected void onBlockHit(final BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);

        if (!getWorld().isClient) {
            this.kill((ServerWorld) getWorld());
        }
    }


}