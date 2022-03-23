package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModEntities;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import net.minecraft.network.protocol.Packet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nonnull;

public class EntityFan extends ThrownTrident implements IAnimatable {
    private boolean dealtDamage;
    private final AnimationFactory manager = new AnimationFactory(this);
    private final AnimationController controller = new AnimationController(this, "fancontroller", 20, this::animationpred);
    private ItemStack thrownstack;
    public EntityFan(EntityType<? extends ThrownTrident> type, Level worldIn) {
        super(type,worldIn);
    }

    public EntityFan(Level world, LivingEntity thrower, ItemStack thrownStackIn) {
        super(ModEntities.FAN.get(), world);
        this.thrownstack = new ItemStack(ModItems.YUMI_TRADITONAL_FANS.get());

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

    private <E extends EntityFan> PlayState animationpred(AnimationEvent<E> event) {

        controller.setAnimation(new AnimationBuilder().addAnimation("animation.fan.spin", true));
        return PlayState.CONTINUE;


    }

    @Override
    public AnimationFactory getFactory() {
        return manager;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(controller);
    }
}
