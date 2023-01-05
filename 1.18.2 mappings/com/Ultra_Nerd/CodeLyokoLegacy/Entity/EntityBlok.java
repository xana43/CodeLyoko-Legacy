package com.Ultra_Nerd.CodeLyokoLegacy.Entity;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.model.ModelBlok;
import com.Ultra_Nerd.CodeLyokoLegacy.init.*;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.biome.source.BiomeAccess;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nonnull;
import java.util.Random;

public final class EntityBlok extends SkeletonEntity implements IAnimatable {


    public EntityBlok(final EntityType<? extends EntityBlok> entityType,final World world) {
        super(entityType, world);

        AnimationController.addModelFetcher((AnimationController.ModelFetcher<EntityBlok>) iAnimatable -> new ModelBlok());
    }



    @Override
    public void attack(final LivingEntity target, final float pullProgress) {
        final ArrowEntity abstractarrow = new EntityLaser(this.world,this,20);

        final double d0 = target.getX() - this.getX();
        final double d1 = target.getBodyY(0.3333333333333333D) - abstractarrow.getY();
        final double d2 = target.getZ() - this.getZ();
        final double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        abstractarrow.setVelocity(d0, d1 + d3 * 0.2D, d2, 4F, (float)(14 - this.world.getDifficulty().getId() << 2));
        //this.playSound(ModSounds.LASERARROW.get(), 1.0F, 1.0F / (this.getRandom().nextFloat() * 1.2f));
        this.world.spawnEntity(abstractarrow);
    }









    private <E extends EntityBlok> @NotNull PlayState pred(AnimationEvent<E> event) {
        return PlayState.STOP;
    }


    @Override
    public void registerControllers(@NotNull AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "blokcontroller", 20, this::pred));
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
    @Nullable
private static SoundEvent getStepSound()
{
    return null;
}
    @Override
    protected @NotNull SoundEvent getHurtSound(@Nonnull DamageSource damageSourceIn) {
        // TODO Auto-generated method stub
        return ModSounds.BLOKHURT;
    }


    @Override
    protected @NotNull SoundEvent getAmbientSound() {
        // TODO Auto-generated method stub
        return ModSounds.BLOKAMBIENT;
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



    @Override
    public boolean canSpawn(final WorldAccess world, final SpawnReason spawnReason) {
        return true;
    }

    @Override
    public @NotNull AnimationFactory getFactory() {
        return new AnimationFactory(this);
    }

    @Override
    public void checkDespawn() {
        super.checkDespawn();
    }

    public static boolean canSpawn(final EntityType<EntityBlok> entityBlokEntityType, final ServerWorldAccess serverWorldAccess, final SpawnReason spawnReason, final BlockPos pos, final Random random) {
        return serverWorldAccess.getBiome(pos).isIn(ModTags.Biomes.LYOKO_BIOME) && serverWorldAccess.getBlockState(pos.offset(Direction.Axis.Y, -1)).isIn(ModTags.Blocks.LYOKO_BLOCKS);
    }
}



