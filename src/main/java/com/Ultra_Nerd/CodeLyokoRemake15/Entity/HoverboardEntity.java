package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Util.KeyBoardAccess;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.server.SEntityPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeEntity;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class HoverboardEntity extends Entity implements IForgeEntity {
    private float Vel = 0;
    private float WDown = 0;
    private float QDown = 0;
    private float ZDown = 0;
    private PlayerEntity rider;
    private final AxisAlignedBB axisAlignedBB = this.getBoundingBox();
    public HoverboardEntity(EntityType<? extends HoverboardEntity> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
        this.setBoundingBox(new AxisAlignedBB(axisAlignedBB.minX,axisAlignedBB.minY,axisAlignedBB.minZ,axisAlignedBB.maxX,axisAlignedBB.maxY,axisAlignedBB.maxZ));
        if(this.getRidingEntity() instanceof PlayerEntity && rider == null) {
            rider = (PlayerEntity) this.getRidingEntity();
        }
        recalculateSize();
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox() {
        return this.getCollisionBox(this);
    }



    @Override
    public void tick() {
        super.tick();

        Base.Log.info(Vel);
        if(this.isBeingRidden()) {
            if(KeyBoardAccess.Q())
            {
                QDown += 0.0000001f;

                this.move(MoverType.PLAYER, new Vec3d(this.getForward().x,this.getPosY() - QDown,this.getForward().z));
            }
            else if(KeyBoardAccess.Z())
            {

                    ZDown += 0.0000001f;
                    this.move(MoverType.PLAYER, new Vec3d(this.getForward().x,this.getPosY() + ZDown,this.getForward().z));

            }
            if(!KeyBoardAccess.Z())
            {
                ZDown = 0;
            }
            if(!KeyBoardAccess.Q())
            {
                QDown = 0;
            }


           // rotateTowards(this.rider.cameraYaw,this.rider.rotationPitch);
            if(KeyBoardAccess.w()) {
                WDown += 0.00001f;
                if(Vel < 5) {
                    Vel += Math.pow(0.0001f,WDown);

                }
                else if(Vel >= 5)
                {
                    Vel = 5;
                }

                this.move(MoverType.PLAYER, new Vec3d(this.getForward().x,this.getForward().y,this.getForward().z + Vel));
            }
            else if(Vel != 0 && (!KeyBoardAccess.w() || !KeyBoardAccess.S()))
            {
                if(Vel > 0) {
                    Vel -= 0.001f;
                }
                else if(Vel < 0)
                {
                    Vel += 0.001f;
                }
                WDown = 0;
                this.move(MoverType.PLAYER, new Vec3d(this.getForward().x,this.getForward().y,this.getForward().z + Vel));
            }
            if(KeyBoardAccess.S())
            {
                if(Vel > -3)
                {
                    Vel -= Math.pow(0.0001f,WDown);
                }
                if(Vel < -3)
                {
                    Vel = -3;
                }

            }



        }
        else if(!this.isBeingRidden())
        {
            if(Vel > 0) {
                Vel -= 0.001f;
            }
            else if(Vel < 0)
            {
                Vel += 0.001f;
            }
            /*
            if(Vel != 0) {
                Vel -= 0.5f;
            }
            //this.move(MoverType.PLAYER, new Vec3d(this.getForward().x,this.getForward().y,this.getForward().z - Vel));
            */
        }
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
    public AxisAlignedBB getCollisionBox(@Nonnull Entity entityIn) {
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

    @Override
    public void setPacketCoordinates(double p_213312_1_, double p_213312_3_, double p_213312_5_) {
        super.setPacketCoordinates(p_213312_1_, p_213312_3_, p_213312_5_);
        this.serverPosX = SEntityPacket.func_218743_a(p_213312_1_);
        this.serverPosY = SEntityPacket.func_218743_a(p_213312_3_);
        this.serverPosZ = SEntityPacket.func_218743_a(p_213312_5_);

    }
}
