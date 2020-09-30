package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModEntities;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.monster.PhantomEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

import javax.annotation.Nonnull;

public class HornetEntity extends PhantomEntity implements IAnimatedEntity, IRangedAttackMob {

    private final EntityAnimationManager manager = new EntityAnimationManager();
    private final EntityAnimationController controller2 = new EntityAnimationController(this, "attackcontroller", 20, this::animationPred);
    private final EntityAnimationController controller = new EntityAnimationController(this, "movecontroller", 20, this::animationPred);
    private RangedAttackGoal rangedAttackGoal;

    public HornetEntity(EntityType<HornetEntity> hornetEntityEntityType, World world) {
        super(hornetEntityEntityType, world);
        manager.addAnimationController(controller);
        manager.addAnimationController(controller2);
    }

    public HornetEntity(World world) {
        super(ModEntities.HORNET.get(), world);

    }

    @Override
    public void tick() {
        super.tick();


        if (this.isAlive()) {
            this.world.playSound(this.getPosX(), this.getPosY(), this.getPosZ(), ModSounds.HORNETFLY.get(), this.getSoundCategory(), 0.95F + this.rand.nextFloat() * 0.05F, 0.95F + this.rand.nextFloat() * 0.05F, true);
        }


    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.rangedAttackGoal = new RangedAttackGoal(this, 1, 1, 1);
        this.goalSelector.addGoal(4, rangedAttackGoal);
    }

    @Nonnull
    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected boolean isInDaylight() {
        return false;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return super.getAmbientSound();
    }

    @Override
    protected SoundEvent getHurtSound(@Nonnull DamageSource damageSourceIn) {
        return super.getHurtSound(damageSourceIn);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return super.getDeathSound();
    }

    @Override
    public boolean isAggressive() {
        return true;
    }

    @Override
    protected boolean canBeRidden(@Nonnull Entity entityIn) {
        return false;
    }


    @Override
    public boolean canSpawn(@Nonnull IWorld worldIn, @Nonnull SpawnReason spawnReasonIn) {
        return true;
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1D);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10D);
        this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(10D);
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20D);
    }


    @Override
    public EntityAnimationManager getAnimationManager() {
        return manager;
    }

    private <E extends HornetEntity> boolean animationPred(AnimationTestEvent<E> event) {
        if (event.isWalking()) {
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.hornet.fly", true));

            return true;
        }
        if (event.getEntity().getAttackTarget() instanceof PlayerEntity) {
            controller2.setAnimation(new AnimationBuilder().addAnimation("animation.hornet.attack", false));
            return true;
        } else {
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.hornet.fly", true));
            return true;
        }
    }


    @Override
    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {

        EntityLaser laser = new EntityLaser(this.world, 1.0D, 1.0D, 1.0D);
        double d0 = target.getPosX() - this.getPosX();
        double d1 = target.getPosYHeight(0.3333333333333333D) - laser.getPosY();
        double d2 = target.getPosZ() - this.getPosZ();
        double d3 = MathHelper.sqrt(d0 * d0 + d2 * d2);
        laser.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, (float) (14 - this.world.getDifficulty().getId() * 4));
        this.playSound(ModSounds.LASERARROW.get(), 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.world.addEntity(laser);
    }
}
