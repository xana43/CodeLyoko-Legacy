package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nonnull;

public class KankrelatEntity extends Skeleton implements IAnimatable {

    private final AnimationController<?> controller = new AnimationController<>(this, "kankrelatcontroller", 20, this::animationPred);
    private final AnimationFactory manager = new AnimationFactory(this);

    public KankrelatEntity(EntityType<? extends KankrelatEntity> type, Level world) {
        super(type, world);
    }

    private <E extends KankrelatEntity> PlayState animationPred(AnimationEvent<E> event) {
        if (event.isMoving()) {
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.ModelKankrelat.walk"));
            return PlayState.CONTINUE;
        } else {
            return PlayState.STOP;
        }
    }



    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(controller);
    }

    @Override
    public AnimationFactory getFactory() {
        return manager;
    }

    @Nonnull
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }


}
