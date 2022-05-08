package com.Ultra_Nerd.CodeLyokoLegacy.Entity;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.model.ModelMegaTank;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModSounds;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
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
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Interface;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nonnull;
import java.rmi.Remote;
import java.rmi.server.Operation;
import java.rmi.server.RemoteCall;
import java.rmi.server.Skeleton;
import java.util.Random;

public final class MegaTankEntity extends SkeletonEntity implements IAnimatable {

   private final AnimationFactory TankManager = new AnimationFactory(this);
    private final AnimationController<?> Tankcontroller = new AnimationController<>(this, "movecontroller", 20, this::animationPred);

    public MegaTankEntity(EntityType<? extends AbstractSkeletonEntity> type, @NotNull World world) {
        super(ModEntities.MEGATANK, world);
        this.setAttacking(true);
        AnimationController.addModelFetcher((AnimationController.ModelFetcher<MegaTankEntity>) animated -> new ModelMegaTank());

    }


   // abstract SoundEvent getStepSound();






    public static DefaultAttributeContainer.@NotNull Builder registerAttributes() {
        // TODO Auto-generated method stub
        return SkeletonEntity.createAbstractSkeletonAttributes()
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,1D)
                .add(EntityAttributes.GENERIC_MAX_HEALTH,200D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.5D)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED,10D)
                .add(EntityAttributes.GENERIC_ARMOR,20D)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20D);



    }

    @Override
    public boolean isSprinting() {
        return true;
    }

    @Override
    protected void spawnSprintingParticles() {
    }

    @Override
    protected @NotNull SoundEvent getDeathSound() {
        return ModSounds.MEGATANKDIE;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return null;
    }




    @Nonnull
    @Override
    public  FallSounds getFallSounds() {
        return  new FallSounds(ModSounds.MEGATANKSMALLFALL,ModSounds.MEGATANKBIGFALL);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1,new SwimGoal(this));
        this.goalSelector.add(2,new ProjectileAttackGoal(this,1,10,6));
        this.goalSelector.add(3,new WanderAroundGoal(this,1D));
        this.goalSelector.add(4,new LookAroundGoal(this));
        this.targetSelector.add(1,new ActiveTargetGoal<>(this, PlayerEntity.class,true));
    }



    @Override
    protected @NotNull SoundEvent getHurtSound(@Nonnull DamageSource damageSourceIn) {
        final boolean random = new Random().nextBoolean();
        if (random) {
            return ModSounds.MEGATANKHURT1;
        } else {
            return ModSounds.MEGATANKHURT2;
        }
    }
    public static boolean canSpawn(@NotNull WorldAccess world, @NotNull SpawnReason reason, @NotNull BlockPos pos, @NotNull Random rand) {
        return (world.getBlockState(pos).getBlock() == ModBlocks.DIGITAL_ROCK || world.getBlockState(pos).getBlock() == ModBlocks.DIGITAL_GRASS
                || world.getBlockState(pos).getBlock() == ModBlocks.DIGITAL_ICE || world.getBlockState(pos).getBlock() == ModBlocks.VOLCANO_GROUND);
    }




    @Override
    public void registerControllers(@NotNull AnimationData data) {
   data.addAnimationController(Tankcontroller);
    }

    @Override
    public void attack(final LivingEntity target, final float pullProgress) {
        //super.attack(target, pullProgress);
        final EntityLaser abstractarrow = new EntityLaser(this.world,this);

        double d0 = target.getX() - this.getX();
        double d1 = target.getBodyY(0.3333333333333333D) - abstractarrow.getY();
        double d2 = target.getZ() - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        abstractarrow.setVelocity(d0, d1 + d3 * (double)0.2F, d2, 4F, (float)(14 - this.world.getDifficulty().getId() << 2));
        this.playSound(ModSounds.LASERARROW, 1.0F, 1.0F / (this.getRandom().nextFloat() * 1.2f));
        if(!this.world.isClient) {
            this.world.spawnEntity(abstractarrow);
        }
    }





    private <E extends MegaTankEntity> @NotNull PlayState animationPred(@NotNull AnimationEvent<E> event) {

        if ((event.isMoving() || event.getAnimatable().isSwimming()) && !event.getAnimatable().isAttacking()) {
            Tankcontroller.setAnimation(new AnimationBuilder().addAnimation("animation.MegaTank.move", true));

            return PlayState.CONTINUE;
        } else if (event.getAnimatable().isAttacking()) {
            Tankcontroller.setAnimation(new AnimationBuilder().addAnimation("animation.MegaTank.open", true));

            return PlayState.CONTINUE;
        } else {
            Tankcontroller.setAnimation(new AnimationBuilder().addAnimation("animation.MegaTank.idle", true));
            return PlayState.CONTINUE;
        }


    }

    @Override
    public @NotNull AnimationFactory getFactory() {
        return TankManager;
    }




}
