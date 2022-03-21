package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.IPacket;
import net.minecraft.network.protocol.Packet;
import net.minecraft.util.Hand;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.World;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class HoverboardEntity extends Entity  {
    private float Vel = 0;
    private float WDown = 0;
    private float QDown = 0;
    private float ZDown = 0;
    private final AABB axisAlignedBB = this.getBoundingBox();

    public HoverboardEntity(EntityType<? extends HoverboardEntity> entityTypeIn, Level worldIn) {
        super(entityTypeIn, worldIn);
        this.setBoundingBox(new AABB(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ));


    }


    @Override
    public void onPassengerTurned(Entity p_20320_) {
        super.onPassengerTurned(p_20320_);
    }

    @Override
    protected boolean canRide(Entity p_20339_) {
        return true;
    }

    @Override
    public boolean showVehicleHealth() {
        return true;
    }

    @Override
    public boolean isVehicle() {
        return true;
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    public void tick() {
        super.tick();


        if (this.isBeingRidden()) {
            if (this.getFirstPassenger() != null) {
                assert Minecraft.getInstance().player != null;
                setRot(Minecraft.getInstance().player.getXRot(), 0);
            }
            if (KeyBoardAccess.Q()) {
                QDown += 0.0000001f;

                this.move(MoverType.PLAYER, new Vec3(0, this.getUpVector(10).y + QDown, 0));
            } else if (KeyBoardAccess.Z()) {

                ZDown += 0.0000001f;
                this.move(MoverType.PLAYER, new Vec3(0, -(this.getUpVector(10).y + ZDown), 0));

            }
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
    public boolean isAlive() {
        return false;
    }

    @Override
    public boolean canCollideWith(Entity p_20303_) {
        return super.canCollideWith(this);
    }



    @Override
    public boolean processInitialInteract(@Nonnull Player player, @Nonnull InteractionHand hand) {
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
    public boolean isNoGravity() {
        return true;
    }



    @Override
    public void setNoGravity(boolean noGravity) {
        super.setNoGravity(true);
    }

    @Override
    protected @NotNull AABB getBoundingBoxForPose(Pose p_20218_) {
        return axisAlignedBB;
    }

    @Override
    public boolean isPushable() {
        return true;
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag p_20052_) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag p_20139_) {

    }

    @Override
    public boolean canBeRiddenInWater(Entity rider) {
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
    public @NotNull Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }



    @Override
    public void setPacketCoordinates(double p_213312_1_, double p_213312_3_, double p_213312_5_) {
        super.setPacketCoordinates(p_213312_1_, p_213312_3_, p_213312_5_);


    }
}
