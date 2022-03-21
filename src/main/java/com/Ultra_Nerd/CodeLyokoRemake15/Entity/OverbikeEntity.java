package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.IPacket;
import net.minecraft.network.protocol.Packet;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.World;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class OverbikeEntity extends Entity {


    public OverbikeEntity(EntityType<? extends Entity> entityTypeIn, Level worldIn) {
        super(entityTypeIn, worldIn);


        this.canBeCollidedWith();



    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected boolean canRide(Entity p_20339_) {
        return true;
    }

    @Override
    public void tick() {
        super.tick();

        Vec3 vec3d = this.getDeltaMovement();
        double d0 = this.getX() + vec3d.x;
        double d1 = this.getY() + vec3d.y;
        double d2 = this.getZ() + vec3d.z;
        Vec3 motion = this.getDeltaMovement();
        if (!this.onGround) {
            this.setDeltaMovement(motion.x, motion.y - this.getGravity(), motion.z);
            this.setPos(d0, d1, d2);
        }
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag p_20052_) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag p_20139_) {

    }

    private double getGravity() {
        return 0.05D;
    }




    @Override
    public InteractionResult interact(@Nonnull Player player, @Nonnull InteractionHand hand) {
        super.interact(player, hand);
        if (player.isSecondaryUseActive()) {
            return InteractionResult.FAIL;
        } else if (this.getFirstPassenger() != null) {
            return InteractionResult.PASS;
        } else {
            if (this.level.isClientSide) {
                player.startRiding(this);
            }

            return InteractionResult.PASS;
        }
    }





    @Nonnull
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
