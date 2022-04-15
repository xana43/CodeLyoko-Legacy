package com.Ultra_Nerd.CodeLyokoLegacy.Entity;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModEntities;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public final class EntityLaser extends Arrow {

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


}
