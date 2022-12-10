package com.Ultra_Nerd.CodeLyokoLegacy.Entity;

import dev.onyxstudios.cca.api.v3.component.ComponentContainer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public final class KankrelatEntity extends HostileEntity implements IAnimatable {

    private final AnimationController<?> controller = new AnimationController<>(this, "kankrelatcontroller", 20, this::animationPred);
    private final AnimationFactory manager = GeckoLibUtil.createFactory(this);

    public KankrelatEntity(final EntityType<? extends HostileEntity> entityType, final World world) {
        super(entityType, world);
    }
/*
    public KankrelatEntity(@NotNull EntityType<? extends KankrelatEntity> type, @NotNull Level world) {
        super(type, world);
    }

 */

    private <E extends KankrelatEntity> @NotNull PlayState animationPred(@NotNull AnimationEvent<E> event) {
        if (event.isMoving()) {
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.ModelKankrelat.walk",
                    ILoopType.EDefaultLoopTypes.LOOP));
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



/*
    @Nonnull
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

 */


}
