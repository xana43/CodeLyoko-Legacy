package com.Ultra_Nerd.CodeLyokoLegacy.Entity.HostileEntities;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.ProjectileEntities.EntityLaser;
import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModSounds;
import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;




public final class EntityBlok extends SkeletonEntity implements GeoAnimatable {


    public EntityBlok(final EntityType<? extends EntityBlok> entityType, final World world) {
        super(entityType, world);


    }

    @Nullable
    private static SoundEvent getStepSound() {
        return null;
    }

    public static DefaultAttributeContainer.Builder createMonsterAttributes() {
        return AbstractSkeletonEntity.createAbstractSkeletonAttributes()
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 10D)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 90D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10D)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 4D)
                .add(EntityAttributes.GENERIC_ARMOR, 10D)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20D);

    }

    public static boolean canSpawn(final EntityType<EntityBlok> entityBlokEntityType, final ServerWorldAccess serverWorldAccess, final SpawnReason spawnReason, final BlockPos pos, final Random random) {
        return serverWorldAccess.getBiome(pos).isIn(ModTags.Biomes.LYOKO_BIOMES) && serverWorldAccess.getBlockState(
                pos.offset(Direction.Axis.Y, -1)).isIn(ModTags.Blocks.LYOKO_BLOCKS);
    }

    @Override
    public void shootAt(final LivingEntity target, final float pullProgress) {
        final ArrowEntity abstractArrow = new EntityLaser(this.getWorld(), this, 20);

        final double d0 = target.getX() - this.getX();
        final double d1 = target.getBodyY(0.3333333333333333D) - abstractArrow.getY();
        final double d2 = target.getZ() - this.getZ();
        final double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        abstractArrow.setVelocity(d0, d1 + d3 * 0.2D, d2, 4F, (float) (14 - this.getWorld().getDifficulty().getId() << 2));
        //this.playSound(ModSounds.LASERARROW.get(), 1.0F, 1.0F / (this.getRandom().nextFloat() * 1.2f));
        this.getWorld().spawnEntity(abstractArrow);
    }

    @SuppressWarnings("MethodMayBeStatic")
    private <E extends EntityBlok> @NotNull PlayState pred(AnimationState<E> event) {
        return PlayState.STOP;
    }

    @Override
    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController<>(this, "blokcontroller", 20, this::pred));
    }

    @Override
    protected boolean canAddPassenger(final Entity passenger) {
        return false;
    }

    @Override
    protected void playStepSound(final BlockPos pos, final BlockState state) {
        //super.playStepSound(pos, state);
        //this.playSound(getStepSound(),0.15f,1);
    }

    @Override
    protected @NotNull SoundEvent getHurtSound(final DamageSource damageSourceIn) {
        // TODO Auto-generated method stub
        return ModSounds.BLOK_HURT;
    }

    @Override
    protected float getSoundVolume() {
        return MinecraftClient.getInstance().options.getSoundVolume(SoundCategory.HOSTILE);
    }

    @Override
    protected @NotNull SoundEvent getAmbientSound() {
        // TODO Auto-generated method stub
        return ModSounds.BLOK_AMBIENT;
    }

    @Override
    protected boolean isAffectedByDaylight() {
        return false;
    }

    @Override
    protected SoundEvent getDeathSound() {
        // TODO Auto-generated method stub
        return null;//super.getDeathSound();
    }

    @Override
    protected void initGoals() {
        //super.registerGoals();
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new ProjectileAttackGoal(this, 1, 10, 6));
        this.goalSelector.add(3, new WanderAroundGoal(this, 1D));
        this.goalSelector.add(4, new LookAroundGoal(this));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    public boolean canSpawn(final WorldAccess world, final SpawnReason spawnReason) {
        return true;
    }



    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return GeckoLibUtil.createInstanceCache(this);
    }

    @Override
    public double getTick(final Object o) {
        return 0;
    }




}




