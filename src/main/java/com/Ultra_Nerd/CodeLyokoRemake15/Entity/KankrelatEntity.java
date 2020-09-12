package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

import javax.annotation.Nonnull;

public class KankrelatEntity extends SkeletonEntity implements IAnimatedEntity {

    private final EntityAnimationController controller = new EntityAnimationController(this,"kankrelatcontroller",20,this::animationPred);
    private final EntityAnimationManager manager = new EntityAnimationManager();
    public KankrelatEntity(EntityType<? extends KankrelatEntity> type, World world) {
        super(type, world);
        manager.addAnimationController(controller);
    }

    private <E extends KankrelatEntity> boolean animationPred(AnimationTestEvent<E> event)
    {
        if(event.isWalking())
        {
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.ModelKnaKrelat.walk"));
            return true;
        }
        else {
            return false;
        }
    }


    @Nonnull
    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public EntityAnimationManager getAnimationManager() {
        return manager;
    }
}
