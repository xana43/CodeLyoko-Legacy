package com.Ultra_Nerd.CodeLyokoLegacy.Entity;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModSounds;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public final class MantaEntity extends Guardian implements IAnimatable, RangedAttackMob {
    private final AnimationFactory manager = new AnimationFactory(this);
    private final AnimationController<?> controller = new AnimationController<>(this, "mantamovecontroller", 20, this::animationPred);

    public MantaEntity(@NotNull EntityType<? extends Guardian> type, @NotNull Level worldIn) {
        super(type, worldIn);

    }

    @Override
    public void tick() {
        super.tick();
        if(!this.isUnderWater())
        {
            this.hurt(DamageSource.DROWN,Float.MAX_VALUE);
        }
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1,new RangedAttackGoal(this,2,3,6));
        this.targetSelector.addGoal(1,new NearestAttackableTargetGoal<>(this, Player.class,true));
        this.goalSelector.addGoal(2,new LookAtPlayerGoal(this,Player.class,4));
        this.goalSelector.addGoal(3,new RandomLookAroundGoal(this));

    }


    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public boolean isOnFire() {
        return false;
    }

    @Override
    protected boolean isSunBurnTick() {
        return false;
    }

    @Override
    public @NotNull Packet<?> getAddEntityPacket() {
        return  NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public void performRangedAttack(@NotNull LivingEntity target, float distanceFactor) {

        EntityLaser laser = new EntityLaser(this.level, 1.0D, 1.0D, 1.0D);
        double d0 = target.getX() - this.getX();
        double d1 = target.getY(0.3333333333333333D) - laser.getY();
        double d2 = target.getZ() - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        laser.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, (float) (14 - this.level.getDifficulty().getId() << 2));
        this.playSound(ModSounds.LASERARROW.get(), 1.0F, 1.0F / (this.random.nextFloat() * 1.2f));
        this.level.addFreshEntity(laser);
    }

    @Override
    public @NotNull AnimationFactory getFactory() {
        return manager;
    }

    @Override
    public void registerControllers(@NotNull AnimationData data) {
    data.addAnimationController(controller);
    }

    private <E extends MantaEntity> @NotNull PlayState animationPred(AnimationEvent<E> event) {
        return PlayState.STOP;
    }

}

