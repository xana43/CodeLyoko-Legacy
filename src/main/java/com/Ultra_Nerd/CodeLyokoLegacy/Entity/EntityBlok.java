package com.Ultra_Nerd.CodeLyokoLegacy.Entity;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.model.ModelBlok;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nonnull;
import java.util.Random;

public final class EntityBlok extends Skeleton implements IAnimatable, RangedAttackMob {

    private final AnimationFactory manager = new AnimationFactory(this);
    private final AnimationController controller = new AnimationController(this, "blokcontroller", 20, this::pred);
/*
    public EntityBlok(Level world) {
        super(ModEntities.BLOK.get(), world);


    }

 */
public EntityBlok(EntityType<? extends Skeleton> type, @NotNull Level world) {
    super(ModEntities.BLOK.get(), world);
    this.setAggressive(true);
    AnimationController.addModelFetcher((AnimationController.ModelFetcher<EntityBlok>) iAnimatable -> new ModelBlok());
}



    private <E extends EntityBlok> @NotNull PlayState pred(AnimationEvent<E> event) {
        return PlayState.STOP;
    }


    @Override
    public void registerControllers(@NotNull AnimationData data) {
        data.addAnimationController(controller);
    }

    @Override
    protected boolean isSunBurnTick() {
        return false;
    }



    @Override
    public boolean isOnFire() {
        return false;
    }

    @Override
    public void setAggressive(boolean p_21562_) {
        super.setAggressive(true);
    }







    @Override
    protected boolean canRide(@NotNull Entity p_20339_) {
        return false;
    }

    @Override
    public void clearFire() {
        super.clearFire();
    }

    @Override
    public boolean curePotionEffects(@NotNull ItemStack curativeItem) {
        return true;
    }

    @Override
    public boolean isAggressive() {
        // TODO Auto-generated method stub
        return true;
    }



    @Override
    protected @NotNull SoundEvent getHurtSound(@Nonnull DamageSource damageSourceIn) {
        // TODO Auto-generated method stub
        return ModSounds.BLOKHURT.get();
    }



    @Override
    protected @NotNull SoundEvent getAmbientSound() {
        // TODO Auto-generated method stub
        return ModSounds.BLOKAMBIENT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        // TODO Auto-generated method stub
        return super.getDeathSound();
    }






    @Override
    protected void registerGoals() {
        //super.registerGoals();
        this.goalSelector.addGoal(1,new FloatGoal(this));
        this.goalSelector.addGoal(2,new RangedAttackGoal(this,1,10,6));
        this.goalSelector.addGoal(3,new WaterAvoidingRandomStrollGoal(this,1D));
        this.goalSelector.addGoal(4,new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1,new NearestAttackableTargetGoal<>(this, Player.class,true));
    }

    public static AttributeSupplier.@NotNull Builder createMonsterAttributes(){
        return Skeleton.createMobAttributes()
                .add(Attributes.KNOCKBACK_RESISTANCE, 10D)
                .add(Attributes.MAX_HEALTH,90D)
                .add(Attributes.MOVEMENT_SPEED,0.5D)
                .add(Attributes.ATTACK_DAMAGE,10D)
                .add(Attributes.ATTACK_SPEED,4D)
                .add(Attributes.ARMOR,10D)
                .add(Attributes.FOLLOW_RANGE, 20D);

    }
    public static boolean canSpawn(@NotNull EntityType<? extends EntityBlok> type, @NotNull LevelAccessor world, @NotNull MobSpawnType reason, @NotNull BlockPos pos, @NotNull Random rand) {
       /* if( Mob.checkMobSpawnRules(type, world, reason, pos, rand) && (world.getBlockState(pos.below()).getBlock() == ModBlocks.DIGITAL_ROCK.get() || world.getBlockState(pos.below()).getBlock() == ModBlocks.DIGITAL_GRASS.get()
                || world.getBlockState(pos.below()).getBlock() == ModBlocks.DIGITAL_ICE.get() || world.getBlockState(pos.below()).getBlock() == ModBlocks.VOLCANO_GROUND.get()))
        {
            CodeLyokoMain.Log.info("spawned");
        }

        */
        return Mob.checkMobSpawnRules(type, world, reason, pos, rand)/* && (world.getBlockState(pos.below()).getBlock() == ModBlocks.DIGITAL_ROCK.get() || world.getBlockState(pos.below()).getBlock() == ModBlocks.DIGITAL_GRASS.get()
                || world.getBlockState(pos.below()).getBlock() == ModBlocks.DIGITAL_ICE.get() || world.getBlockState(pos.below()).getBlock() == ModBlocks.VOLCANO_GROUND.get())*/;
    }

    @Override
    public boolean canRiderInteract() {
        return false;
    }

    @Override
    public @NotNull AnimationFactory getFactory() {
        return manager;
    }


    @Override
    public void performRangedAttack(@NotNull LivingEntity pTarget, float pDistanceFactor) {

        AbstractArrow abstractarrow = this.getArrow(ItemStack.EMPTY,pDistanceFactor);

        double d0 = pTarget.getX() - this.getX();
        double d1 = pTarget.getY(0.3333333333333333D) - abstractarrow.getY();
        double d2 = pTarget.getZ() - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        abstractarrow.shoot(d0, d1 + d3 * (double)0.2F, d2, 4F, (float)(14 - this.level.getDifficulty().getId() << 2));
        this.playSound(ModSounds.LASERARROW.get(), 1.0F, 1.0F / (this.getRandom().nextFloat() * 1.2f));
        this.level.addFreshEntity(abstractarrow);
    }


}