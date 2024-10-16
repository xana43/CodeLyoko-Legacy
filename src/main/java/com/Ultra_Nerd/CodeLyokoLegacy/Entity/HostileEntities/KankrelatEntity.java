package com.Ultra_Nerd.CodeLyokoLegacy.Entity.HostileEntities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

public final class KankrelatEntity extends HostileEntity implements GeoAnimatable {

    private final AnimatableInstanceCache manager = GeckoLibUtil.createInstanceCache(this);

    public KankrelatEntity(final EntityType<? extends HostileEntity> entityType, final World world) {
        super(entityType, world);
    }

    private <E extends KankrelatEntity> @NotNull PlayState animationPred(@NotNull AnimationState<E> event) {
        if (event.isMoving()) {
            controller.setAnimation(RawAnimation.begin().thenLoop("animation.ModelKankrelat.walk"));
            return PlayState.CONTINUE;
        } else {
            return PlayState.STOP;
        }
    }

    @Override
    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar data) {
        data.add(controller);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return manager;
    }

    @Override
    public double getTick(final Object o) {
        return 0;
    }
    private final AnimationController<?> controller = new AnimationController<>(this, "kankrelatcontroller", 20,
            this::animationPred);








/*
    public KankrelatEntity(@NotNull EntityType<? extends KankrelatEntity> type, @NotNull Level world) {
        super(type, world);
    }

 */









/*
    @Nonnull
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

 */


}
