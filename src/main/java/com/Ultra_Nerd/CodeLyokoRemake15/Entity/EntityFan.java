package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModEntities;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.network.protocol.Packet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.network.NetworkHooks;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class EntityFan extends ThrownTrident implements IAnimatedEntity {
    private boolean dealtDamage;
    private final EntityAnimationManager manager = new EntityAnimationManager();
    private final EntityAnimationController controller = new EntityAnimationController(this, "fancontroller", 20, this::animationpred);

    public EntityFan(EntityType<? extends ThrownTrident> type, Level worldIn) {
        super(type,worldIn)
    }

    public EntityFan(Level world, LivingEntity thrower, ItemStack thrownStackIn) {
        super(ModEntities.FAN.get(), world);
        this.thrownStack = new ItemStack(ModItems.YUMI_TRADITONAL_FANS.get());
        manager.addAnimationController(controller);
    }



    @Nonnull
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public void tick() {
        if (this.inGroundTime > 4) {
            this.dealtDamage = true;
        }

        Entity entity = this.getOwner();
        if ((this.dealtDamage || this.noPhysics) && entity != null) {
            this.setNoPhysics(true);
            Vec3 vec3d = new Vec3(entity.getX() - this.getY(), entity.getEyeY() - this.getY(), entity.getZ() - this.getZ());
            this.setPosRaw(this.getX(), this.getY() + vec3d.y * 0.015D * 1, this.getZ());
            if (!this.level.isClientSide) {
                this.yOld = this.getY();
            }


            this.setDeltaMovement(this.getDeltaMovement().scale(0.95D).add(vec3d.normalize().scale(1)));
            if (this.clientSideReturnTridentTickCount == 0) {
                this.playSound(SoundEvents.TRIDENT_RETURN, 10.0F, 1.0F);
            }

            ++this.clientSideReturnTridentTickCount;
        }


        super.tick();
    }

    private <E extends EntityFan> boolean animationpred(AnimationTestEvent<E> event) {

        controller.setAnimation(new AnimationBuilder().addAnimation("animation.fan.spin", true));
        return true;


    }








}
