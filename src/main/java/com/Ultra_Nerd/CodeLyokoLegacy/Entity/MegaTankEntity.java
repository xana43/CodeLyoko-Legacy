package com.Ultra_Nerd.CodeLyokoLegacy.Entity;

import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.rmi.Remote;
import java.rmi.server.Operation;
import java.rmi.server.RemoteCall;
import java.rmi.server.Skeleton;

public final class MegaTankEntity implements IAnimatable, Skeleton {

   private final AnimationFactory TankManager = new AnimationFactory(this);
    //private final AnimationController<?> Tankcontroller = new AnimationController<>(this, "movecontroller", 20, this::animationPred);
/*
    public MegaTankEntity(EntityType<? extends Skeleton> type, @NotNull Level world) {
        super(ModEntities.MEGATANK.get(), world);

    }
/*
    public MegaTankEntity(Level world) {
        super(ModEntities.MEGATANK.get(), world);


    }*/



/*

    @Override
    protected void dropExperience() {
        super.dropExperience();
    }


    @Override
    protected boolean canRide(@Nonnull Entity entityIn) {
        return false;
    }





    @Nonnull
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }






    public static AttributeSupplier.@NotNull Builder registerAttributes() {
        // TODO Auto-generated method stub
        return Skeleton.createAttributes().add(Attributes.KNOCKBACK_RESISTANCE,1D)
                .add(Attributes.MAX_HEALTH,200D)
                .add(Attributes.MOVEMENT_SPEED,0.5D)
                .add(Attributes.ATTACK_SPEED,10D)
                .add(Attributes.ARMOR,20D)
                .add(Attributes.FOLLOW_RANGE, 20D);



    }

    @Override
    public boolean isSprinting() {
        return true;
    }



    @Override
    protected @NotNull SoundEvent getDeathSound() {
        return ModSounds.MEGATANKDIE.get();
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return null;
    }




    @Nonnull
    @Override
    public Fallsounds getFallSounds() {
        return  new Fallsounds(ModSounds.MEGATANKSMALLFALL.get(),ModSounds.MEGATANKBIGFALL.get());
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1,new FloatGoal(this));
        this.goalSelector.addGoal(2,new RangedAttackGoal(this,1,10,6));
        this.goalSelector.addGoal(3,new WaterAvoidingRandomStrollGoal(this,1D));
        this.goalSelector.addGoal(4,new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1,new NearestAttackableTargetGoal<>(this, Player.class,true));
    }

    @Override
    public void reassessWeaponGoal() {

    }

    @Override
    protected @NotNull SoundEvent getHurtSound(@Nonnull DamageSource damageSourceIn) {
        boolean random = new Random().nextBoolean();
        if (random) {
            return ModSounds.MEGATANKHURT1.get();
        } else {
            return ModSounds.MEGATANKHURT2.get();
        }
    }
    public static boolean canSpawn(@NotNull EntityType<? extends MegaTankEntity> type, @NotNull LevelAccessor world, @NotNull MobSpawnType reason, @NotNull BlockPos pos, @NotNull Random rand) {
        return Skeleton.checkAnyLightMonsterSpawnRules(type,world,reason,pos,rand) && (world.getBlockState(pos).getBlock() == ModBlocks.DIGITAL_ROCK.get() || world.getBlockState(pos).getBlock() == ModBlocks.DIGITAL_GRASS.get()
                || world.getBlockState(pos).getBlock() == ModBlocks.DIGITAL_ICE.get() || world.getBlockState(pos).getBlock() == ModBlocks.VOLCANO_GROUND.get());
    }
    @Nonnull
    @Override
    protected SoundEvent getStepSound() {


        return ModSounds.MEGATANKROLL.get();

    }
*/
    @Override
    public void registerControllers(@NotNull AnimationData data) {
   // data.addAnimationController(Tankcontroller);
    }

    @Override
    public AnimationFactory getFactory() {
        return null;
    }

    @Override
    public void dispatch(final Remote obj, final RemoteCall theCall, final int opnum, final long hash) throws Exception {

    }

    @Override
    public Operation[] getOperations() {
        return new Operation[0];
    }

/*
    @Override
    public void performRangedAttack(@NotNull LivingEntity pTarget, float pDistanceFactor) {

        AbstractArrow abstractarrow = getArrow(ItemStack.EMPTY,pDistanceFactor);

        double d0 = pTarget.getX() - this.getX();
        double d1 = pTarget.getY(0.3333333333333333D) - abstractarrow.getY();
        double d2 = pTarget.getZ() - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        abstractarrow.shoot(d0, d1 + d3 * (double)0.2F, d2, 4F, (float)(14 - this.level.getDifficulty().getId() << 2));
        this.playSound(ModSounds.LASERARROW.get(), 1.0F, 1.0F / (this.getRandom().nextFloat() * 1.2f));
        this.level.addFreshEntity(abstractarrow);
    }

 */
    /*
    private <E extends MegaTankEntity> @NotNull PlayState animationPred(@NotNull AnimationEvent<E> event) {

        if ((event.isMoving() || event.getAnimatable().isSwimming()) && !event.getAnimatable().ag) {
            Tankcontroller.setAnimation(new AnimationBuilder().addAnimation("animation.MegaTank.move", true));

            return PlayState.CONTINUE;
        } else if (event.getAnimatable().isAggressive()) {
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

     */


}
