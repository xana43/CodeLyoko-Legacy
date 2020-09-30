package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class OverbikeEntity extends Entity  {
    private final AxisAlignedBB axisAlignedBB = new AxisAlignedBB(this.getPosX() - this.getWidth(),this.getPosY() - this.getHeight(),
            this.getPosZ() - this.getWidth(),this.getPosX() + getWidth(),this.getPosY() + this.getHeight(),this.getPosZ() + this.getWidth());

    public OverbikeEntity(EntityType<?> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);

        this.doBlockCollisions();
        this.canBeCollidedWith();
        this.canBePushed();
        this.canPassengerSteer();
        this.recalculateSize();
        this.setBoundingBox(axisAlignedBB);
    }


    @Nullable
    @Override
    public AxisAlignedBB getCollisionBox(@Nonnull Entity entityIn) {
        return axisAlignedBB;
    }

    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox() {
        return axisAlignedBB;
    }

    @Override
    protected void doBlockCollisions() {
        super.doBlockCollisions();
    }



    @Override
    public float getCollisionBorderSize() {
        return 4;
    }

    @Override
    public void tick() {
        super.tick();

        Vec3d vec3d = this.getMotion();
        double d0 = this.getPosX() + vec3d.x;
        double d1 = this.getPosY() + vec3d.y;
        double d2 = this.getPosZ() + vec3d.z;
            Vec3d motion = this.getMotion();
            this.setMotion(motion.x, motion.y - this.getGravity(),motion.z);
        this.setPosition(d0, d1, d2);
    }
    private double getGravity()
    {
        return 0.5D;
    }
    @Override
    public boolean processInitialInteract(@Nonnull PlayerEntity player, @Nonnull Hand hand) {
        if (super.processInitialInteract(player, hand)) {
            return true;
        }
        if (player.isSecondaryUseActive()) {
            return false;
        } else if (this.isBeingRidden()) {
            return true;
        } else {
            if (!this.world.isRemote) {
                player.startRiding(this);
            }

            return true;
        }
    }





    @Override
    protected boolean canBeRidden(@Nonnull Entity entityIn) {
        return true;
    }

    @Override
    protected void registerData() {

    }

    @Override
    protected void readAdditional(@Nonnull CompoundNBT compound) {

    }

    @Override
    protected void writeAdditional(@Nonnull CompoundNBT compound) {

    }



    @Nonnull
    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
