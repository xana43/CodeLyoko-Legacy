package com.Ultra_Nerd.CodeLyokoLegacy.Entity.ProjectileEntities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.manager.AnimatableManager;
import software.bernie.geckolib.animatable.processing.AnimationController;
import software.bernie.geckolib.animatable.processing.AnimationTest;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public final class FanEntity extends TridentEntity implements GeoAnimatable {
    private final AnimatableInstanceCache manager = GeckoLibUtil.createInstanceCache(this);
    private final AnimationController<?> controller = new AnimationController<>("fancontroller", 20,
            this::animationpred);

    public FanEntity(final World world, final LivingEntity owner, final ItemStack stack) {
        super(world, owner, stack);
    }

    public FanEntity(final EntityType<? extends TridentEntity> entityType, final World world) {
        super(entityType, world);
    }




    @Override
    public void tick() {
        this.setNoGravity(true);
        super.tick();
    }

    private <E extends GeoAnimatable> @NotNull PlayState animationpred(AnimationTest<E> event) {

        controller.setAnimation(RawAnimation.begin().thenLoop("animation.fan.spin"));
        return PlayState.CONTINUE;


    }

    @Override
    public void registerControllers(final AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(controller);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return manager;
    }

    @Override
    public double getTick(final Object o) {
        return 0;
    }




}
