package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.Input;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

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

    private static final Input PlayerInput = new Input();
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


        if (this.hasPassenger(Objects.requireNonNull(this.getFirstPassenger()))) {
            if (this.getFirstPassenger() != null) {
                assert Minecraft.getInstance().player != null;
                setRot(Minecraft.getInstance().player.getXRot(), 0);
            }
            if (PlayerInput.up) {
                QDown += 0.0000001f;

                this.move(MoverType.PLAYER, new Vec3(0, this.getUpVector(10).y + QDown, 0));
            } else if (PlayerInput.down) {

                ZDown += 0.0000001f;
                this.move(MoverType.PLAYER, new Vec3(0, -(this.getUpVector(10).y + ZDown), 0));

            }
            if (!PlayerInput.down) {
                ZDown = 0;
            }
            if (!PlayerInput.up) {
                QDown = 0;
            }


            // rotateTowards(this.rider.cameraYaw,this.rider.rotationPitch);
            if (PlayerInput.hasForwardImpulse()) {
                WDown += 0.00001f;
                if (this.getFirstPassenger() != null) {
                    if (Vel < 5 && !this.getFirstPassenger().isSprinting()) {
                        Vel += Math.pow(0.0001f, WDown);

                    } else if (Vel < 7 && this.getFirstPassenger().isSprinting()) {
                        Vel += Math.pow(0.001f, WDown);
                    } else if (Vel >= 5) {
                        Vel = 5;
                    }
                }

                this.move(MoverType.PLAYER, new Vec3(this.getForward().x, this.getForward().y, this.getForward().z + Vel));
            } else if (Vel != 0 && (!PlayerInput.hasForwardImpulse() || PlayerInput.forwardImpulse == 0)) {
                if (Vel > 0) {
                    Vel -= 0.0001f;
                } else if (Vel < 0) {
                    Vel += 0.0001f;
                }
                WDown = 0;
                this.move(MoverType.PLAYER, new Vec3(this.getForward().x, this.getForward().y, this.getForward().z + Vel));
            }
            if (PlayerInput.down) {
                if (Vel > -3) {
                    Vel -= Math.pow(0.0001f, WDown);
                }
                if (Vel < -3) {
                    Vel = -3;
                }

            }


        } else if (!this.hasPassenger(Entity::isAlive)) {
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
    public InteractionResult interact(Player player, InteractionHand hand) {
        if(super.interact(player, hand).consumesAction())
        {
            return InteractionResult.SUCCESS;
        }
        if(player.isSecondaryUseActive())
        {
            return InteractionResult.PASS;
        }
        else if(this.hasPassenger(Objects.requireNonNull(this.getFirstPassenger())))
        {
            return InteractionResult.PASS;
        }
        else
        {
            if(this.level.isClientSide)
            {
                player.startRiding(this);
            }

                return InteractionResult.SUCCESS;

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
