package com.Ultra_Nerd.CodeLyokoLegacy.Entity.HostileEntities;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.ProjectileEntities.LaserEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public final class LyokoCreeperEntity extends SpiderEntity implements RangedAttackMob, GeoAnimatable {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private final AnimationController<LyokoCreeperEntity> creeperController = new AnimationController<>(this, "creeper_controller", 20, this::pred);
    public LyokoCreeperEntity(final EntityType<? extends SpiderEntity> entityType, final World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(3, new PounceAtTargetGoal(this, 0.4F));
        this.goalSelector.add(4, new ProjectileAttackGoal(this,2,2,8));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 0.8));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class,true));

    }

    @Override
    public void shootAt(final LivingEntity target, final float pullProgress) {
        final LaserEntity laserProjectile = new LaserEntity(this.getWorld(), this, 20);
        final double d0 = target.getX() - this.getX();
        final double d1 = target.getBodyY(0.3333333333333333D) - laserProjectile.getY();
        final double d2 = target.getZ() - this.getZ();
        final double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        laserProjectile.setVelocity(d0, d1 + d3 * 0.2D, d2, 4F, (float) (14 - this.getWorld().getDifficulty().getId() << 2));
        this.playSound(ModSounds.LASERARROW, 1.0F, 1.0F / (this.getRandom().nextFloat() * 1.2f));
        this.getWorld().spawnEntity(laserProjectile);
    }

    @Override
    public void registerControllers(final AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(creeperController);
    }
    private <E extends LyokoCreeperEntity> @NotNull PlayState pred(AnimationState<E> event) {
        return PlayState.STOP;
    }
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public double getTick(final Object object) {
        return 0;
    }
}
