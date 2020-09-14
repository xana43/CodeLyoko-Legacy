package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeEntity;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class OverboardEntity extends Entity implements IForgeEntity {
    private float i = 0;

    private final AxisAlignedBB axisAlignedBB = this.getBoundingBox();
    public OverboardEntity(EntityType<? extends OverboardEntity> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
        this.setBoundingBox(new AxisAlignedBB(axisAlignedBB.minX,axisAlignedBB.minY,axisAlignedBB.minZ,axisAlignedBB.maxX,axisAlignedBB.maxY,axisAlignedBB.maxZ));

        recalculateSize();
    }



    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox() {
        return this.getCollisionBox(this);
    }

    @Override
    public void tick() {
        super.tick();
        i+= 0.0000000000001f;
        Vec3d motion = this.getMotion();
        this.setMotion(motion.add(0,0,this.getMotion().getZ() + i));
        if(this.isBeingRidden()) {
            this.moveForced(this.getMotion().x, this.getPosY(), this.getMotion().z);
        }
        else if(!this.isBeingRidden())
        {
            i = 0;
        }
        }

    @Override
    public void move(@Nonnull MoverType typeIn, @Nonnull Vec3d pos) {
        super.move(typeIn, pos);
    }

    @Override
    public boolean isLiving() {
        return false;
    }

    @Override
    public void applyEntityCollision(@Nonnull Entity entityIn) {
        super.applyEntityCollision(this);
    }

    @Override
    public void setVelocity(double x, double y, double z) {
        super.setVelocity(x, y, z);
        this.setMotion(x,y,z);
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
    public boolean hasNoGravity() {
        return false;
    }

    @Override
    public void setNoGravity(boolean noGravity) {
        super.setNoGravity(false);
    }

    @Override
    protected void recenterBoundingBox() {
        super.recenterBoundingBox();
        this.setPosition(this.getPosX(),this.getPosY(),this.getPosZ());
    }

    @Nullable
    @Override
    public AxisAlignedBB getCollisionBox(Entity entityIn) {
        return axisAlignedBB;
    }

    @Override
    public boolean canBePushed() {
        return true;
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public boolean canRiderInteract() {
        return true;
    }

    @Override
    public boolean shouldRiderSit() {
        return false;
    }

    @Override
    protected boolean canBeRidden(Entity entityIn) {
        return true;
    }

    @Override
    protected void registerData() {

    }

    @Override
    protected void readAdditional(CompoundNBT compound) {

    }

    @Override
    protected void writeAdditional(CompoundNBT compound) {

    }

    @Nonnull
    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}
