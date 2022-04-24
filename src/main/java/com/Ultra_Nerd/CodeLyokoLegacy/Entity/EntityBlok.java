package com.Ultra_Nerd.CodeLyokoLegacy.Entity;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.model.ModelBlok;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModSounds;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nonnull;
import java.util.Random;

public final class EntityBlok extends SkeletonEntity implements IAnimatable, RangedAttackMob {


    public EntityBlok(final EntityType<? extends SkeletonEntity> entityType, final World world) {
        super(ModEntities.BLOK, world);
        this.setAttacking(true);
        AnimationController.addModelFetcher((AnimationController.ModelFetcher<EntityBlok>) iAnimatable -> new ModelBlok());
    }

    @Override
    public void attack(final LivingEntity target, final float pullProgress) {
        ArrowEntity abstractarrow = new EntityLaser(this.world,this);

        double d0 = target.getX() - this.getX();
        double d1 = target.getBodyY(0.3333333333333333D) - abstractarrow.getY();
        double d2 = target.getZ() - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        abstractarrow.setVelocity(d0, d1 + d3 * (double)0.2F, d2, 4F, (float)(14 - this.world.getDifficulty().getId() << 2));
        //this.playSound(ModSounds.LASERARROW.get(), 1.0F, 1.0F / (this.getRandom().nextFloat() * 1.2f));
        this.world.spawnEntity(abstractarrow);
    }



    private final AnimationFactory manager = new AnimationFactory(this);
    private final AnimationController<EntityBlok> controller = new AnimationController<>(this, "blokcontroller", 20, this::pred);





    private <E extends EntityBlok> @NotNull PlayState pred(AnimationEvent<E> event) {
        return PlayState.STOP;
    }


    @Override
    public void registerControllers(@NotNull AnimationData data) {
        data.addAnimationController(controller);
    }


    @Override
    public boolean isOnFire() {
        return false;
    }



    @Override
    protected boolean canAddPassenger(final Entity passenger) {
        return false;
    }

    @Override
    public boolean isFireImmune() {
        return true;
    }

    @Override
    protected void playStepSound(final BlockPos pos, final BlockState state) {
        //super.playStepSound(pos, state);

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

    public static boolean canSpawn(@NotNull EntityType<? extends EntityBlok> type, @NotNull WorldAccess world, @NotNull SpawnReason reason, @NotNull BlockPos pos, @NotNull Random rand) {
       /* if( Mob.checkMobSpawnRules(type, world, reason, pos, rand) && (world.getBlockState(pos.below()).getBlock() == ModBlocks.DIGITAL_ROCK.get() || world.getBlockState(pos.below()).getBlock() == ModBlocks.DIGITAL_GRASS.get()
                || world.getBlockState(pos.below()).getBlock() == ModBlocks.DIGITAL_ICE.get() || world.getBlockState(pos.below()).getBlock() == ModBlocks.VOLCANO_GROUND.get()))
        {
            CodeLyokoMain.Log.info("spawned");
        }

        */
        //     return Mob.checkMobSpawnRules(type, world, reason, pos, rand)/* && (world.getBlockState(pos.below()).getBlock() == ModBlocks.DIGITAL_ROCK.get() || world.getBlockState(pos.below()).getBlock() == ModBlocks.DIGITAL_GRASS.get()
        //           || world.getBlockState(pos.below()).getBlock() == ModBlocks.DIGITAL_ICE.get() || world.getBlockState(pos.below()).getBlock() == ModBlocks.VOLCANO_GROUND.get())*/;
        return MobEntity.canMobSpawn(type,world,reason,pos,rand);
    }



    @Override
    public @NotNull AnimationFactory getFactory() {
        return manager;
    }





    }




