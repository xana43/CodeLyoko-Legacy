package com.Ultra_Nerd.CodeLyokoLegacy.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.world.World;

public final class EntityLaser extends ArrowEntity {
    public EntityLaser(final EntityType<? extends ArrowEntity> entityType, final World world) {
        super(entityType, world);
    }
/*
    public EntityLaser(@NotNull EntityType<? extends Arrow> Laser, @NotNull Level world) {
        super(Laser, world);
        // TODO Auto-generated constructor stub
    }

    public EntityLaser(@NotNull Level worldIn, @NotNull LivingEntity throwerIn) {
        super(worldIn, throwerIn);
        // TODO Auto-generated constructor stub
    }

    public EntityLaser(@NotNull Level worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
        // TODO Auto-generated constructor stub
    }

    public EntityLaser(@NotNull Level world) {
        this(ModEntities.LASER.get(), world);
    }

    @Nonnull
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }


    @Override
    public boolean isNoGravity() {
        return true;
    }

    @Override
    public void setBaseDamage(double damageIn) {
        // TODO Auto-generated method stub
        super.setBaseDamage(damageIn);
    }

    @Override
    protected void onHitEntity(EntityHitResult live) {
        super.onHitEntity(live);
        this.remove(RemovalReason.DISCARDED);
    }

    @Override
    protected @NotNull ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }

 */


}
