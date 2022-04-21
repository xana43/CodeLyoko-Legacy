package com.Ultra_Nerd.CodeLyokoLegacy.Entity;

import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.rmi.Remote;
import java.rmi.server.Operation;
import java.rmi.server.RemoteCall;
import java.rmi.server.Skeleton;

public final class KankrelatEntity implements IAnimatable, Skeleton {

    private final AnimationController<?> controller = new AnimationController<>(this, "kankrelatcontroller", 20, this::animationPred);
    private final AnimationFactory manager = new AnimationFactory(this);
/*
    public KankrelatEntity(@NotNull EntityType<? extends KankrelatEntity> type, @NotNull Level world) {
        super(type, world);
    }

 */

    private <E extends KankrelatEntity> @NotNull PlayState animationPred(@NotNull AnimationEvent<E> event) {
        if (event.isMoving()) {
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.ModelKankrelat.walk"));
            return PlayState.CONTINUE;
        } else {
            return PlayState.STOP;
        }
    }



    @Override
    public void registerControllers(@NotNull AnimationData data) {
        data.addAnimationController(controller);
    }

    @Override
    public @NotNull AnimationFactory getFactory() {
        return manager;
    }

    @Override
    public void dispatch(final Remote obj, final RemoteCall theCall, final int opnum, final long hash) throws Exception {

    }

    @Override
    public Operation[] getOperations() {
        return new Operation[0];
    }
/*
    @Nonnull
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

 */


}
