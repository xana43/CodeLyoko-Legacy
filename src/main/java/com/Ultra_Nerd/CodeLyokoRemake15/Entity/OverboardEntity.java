package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.extensions.IForgeEntity;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nonnull;
import java.util.Objects;

public class OverboardEntity extends Entity implements IForgeEntity {

    private float Vel = 0;
    private float WDown = 0;
    private float QDown = 0;
    private float ZDown = 0;
    private final AABB axisAlignedBB = this.getBoundingBox();

    public OverboardEntity(EntityType<? extends OverboardEntity> entityTypeIn, Level worldIn) {
        super(entityTypeIn, worldIn);
        this.setBoundingBox(new AABB(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ));


    }




    @Override
    protected void defineSynchedData() {

    }

    @Override
    public void tick() {
        super.tick();


        if (this.hasPassenger(Objects.requireNonNull(this.getFirstPassenger()))) {
            if (this.getFirstPassenger() != null) {
                assert Minecraft.getInstance().player != null;
                setRot(Minecraft.getInstance().player.getXRot(), 0);
            }
            if (isShiftKeyDown()) {
                QDown += 0.0000001f;

                this.move(MoverType.PLAYER, new Vec3(0, this.getUpVector(10).y + QDown, 0));
            } else if (!isShiftKeyDown()) {

                ZDown += 0.0000001f;
                this.move(MoverType.PLAYER, new Vec3(0, -(this.getUpVector(10).y + ZDown), 0));

            }
            /*
            if (!KeyBoardAccess.Z()) {
                ZDown = 0;
            }
            if (!KeyBoardAccess.Q()) {
                QDown = 0;
            }


            // rotateTowards(this.rider.cameraYaw,this.rider.rotationPitch);
            if (KeyBoardAccess.w()) {
                WDown += 0.00001f;
                if (this.getRidingEntity() != null) {
                    if (Vel < 5 && !this.getRidingEntity().isSprinting()) {
                        Vel += Math.pow(0.0001f, WDown);

                    } else if (Vel < 7 && this.getRidingEntity().isSprinting()) {
                        Vel += Math.pow(0.001f, WDown);
                    } else if (Vel >= 5) {
                        Vel = 5;
                    }
                }

                this.move(MoverType.PLAYER, new Vec3d(this.getForward().x, this.getForward().y, this.getForward().z + Vel));
            } else if (Vel != 0 && (!KeyBoardAccess.w() || !KeyBoardAccess.S())) {
                if (Vel > 0) {
                    Vel -= 0.0001f;
                } else if (Vel < 0) {
                    Vel += 0.0001f;
                }
                WDown = 0;
                this.move(MoverType.PLAYER, new Vec3d(this.getForward().x, this.getForward().y, this.getForward().z + Vel));
            }
            if (KeyBoardAccess.S()) {
                if (Vel > -3) {
                    Vel -= Math.pow(0.0001f, WDown);
                }
                if (Vel < -3) {
                    Vel = -3;
                }

            }


        } else if (!this.isBeingRidden()) {
            Vel = 0;
            /*
            if(Vel != 0) {
                Vel -= 0.5f;
            }


*/
        }

    }


    @Override
    public boolean hasExactlyOnePlayerPassenger() {
        return false;
    }

    @Override
    protected boolean canAddPassenger(Entity p_20354_) {
        return true;
    }




/*
    @Override
    public boolean processInitialInteract(@Nonnull Player player, @Nonnull Hand hand) {
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

 */

    @Override
    public boolean isNoGravity() {
        return false;
    }

    @Override
    public void setNoGravity(boolean noGravity) {
        super.setNoGravity(false);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag p_20052_) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag p_20139_) {

    }

    @Override
    public float rotate(Rotation p_20004_) {
        return super.rotate(p_20004_);
    }

    @Override
    protected AABB makeBoundingBox() {
        return axisAlignedBB;
    }

    @Override
    public boolean canCollideWith(Entity p_20303_) {
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
    protected boolean canRide(@Nonnull Entity entityIn) {
        return true;
    }



    @Nonnull
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}
