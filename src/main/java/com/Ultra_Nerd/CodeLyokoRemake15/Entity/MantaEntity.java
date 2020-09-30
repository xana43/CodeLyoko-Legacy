package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.PhantomEntity;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

import javax.annotation.Nonnull;

public class MantaEntity extends PhantomEntity implements IAnimatedEntity, IRangedAttackMob {
    private final EntityAnimationManager manager = new EntityAnimationManager();
    private final EntityAnimationController controller = new EntityAnimationController(this,"mantamovecontroller",20,this::animationPred);
    public MantaEntity(EntityType<? extends MantaEntity> type, World worldIn) {
        super(type, worldIn);
        manager.addAnimationController(controller);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();

    }

    @Override
    protected boolean isInDaylight() {
        return false;
    }

    @Nonnull
    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
    @Override
    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {

        EntityLaser laser = new EntityLaser(this.world, 1.0D, 1.0D, 1.0D);
        double d0 = target.getPosX() - this.getPosX();
        double d1 = target.getPosYHeight(0.3333333333333333D) - laser.getPosY();
        double d2 = target.getPosZ() - this.getPosZ();
        double d3 = (double) MathHelper.sqrt(d0 * d0 + d2 * d2);
        laser.shoot(d0, d1 + d3 * (double)0.2F, d2, 1.6F, (float)(14 - this.world.getDifficulty().getId() * 4));
        this.playSound(ModSounds.LASERARROW.get(), 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.world.addEntity(laser);
    }
    @Override
    public EntityAnimationManager getAnimationManager() {
        return manager;
    }


    private <E extends MantaEntity> boolean animationPred(AnimationTestEvent<E> event) {
       return false;
    }

}


