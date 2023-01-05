package com.Ultra_Nerd.CodeLyokoLegacy.Entity;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.model.ModelHornet;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModSounds;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.biome.source.BiomeAccess;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nonnull;

public final class HornetEntity extends HostileEntity implements IAnimatable, RangedAttackMob {






    public HornetEntity(@NotNull EntityType<? extends HostileEntity> hornetEntityEntityType, @NotNull World world) {
        super(hornetEntityEntityType, world);
        AnimationController.addModelFetcher((AnimationController.ModelFetcher<HornetEntity>) animated -> new ModelHornet());


    }

    @Override
    protected boolean hasWings() {
        return true;
    }

    @Override
    protected void fall(final double heightDifference, final boolean onGround, final BlockState landedState, final BlockPos landedPosition) {

    }

    @Override
    public void tickMovement() {
        super.tickMovement();
    }



    @Override
    protected boolean canAddPassenger(final Entity passenger) {
        return false;
    }



    @Override
    public boolean handleFallDamage(final float fallDistance, final float damageMultiplier, final DamageSource damageSource) {
        return false;
    }

    @Override
    protected boolean isAffectedByDaylight() {
        return false;
    }

    @Override
    protected boolean isDisallowedInPeaceful() {
        return true;
    }

    @Override
    public void tick() {
        super.tick();


        if (this.isAlive()) {
            this.world.playSound(null,this.getX(), this.getY(), this.getZ(), ModSounds.HORNETFLY, SoundCategory.HOSTILE, 0.95F + this.random.nextFloat() * 0.05F, 0.95F + this.random.nextFloat() * 0.05F);
        }


    }


    @Override
    protected void initGoals() {
        super.initGoals();

        this.goalSelector.add(2,new ProjectileAttackGoal(this,6,6,10){
            @Override
            public void start() {
                super.start();
                HornetEntity.this.setAttacking(true);
            }

            @Override
            public void stop() {
                super.stop();
                HornetEntity.this.setAttacking(false);
            }
        });
        this.goalSelector.add(1,new FlyGoal(this,3));
        this.goalSelector.add(3,new LookAroundGoal(this));
        this.goalSelector.add(2,new LookAtEntityGoal(this,PlayerEntity.class,10,100,true));
        this.targetSelector.add(1,new ActiveTargetGoal<>(this,PlayerEntity.class,true));
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
    public boolean canSpawn(final WorldAccess world, final SpawnReason spawnReason) {
        return true;
    }

    public static boolean isValidSpawn(final BiomeAccess biomeAccess, final BlockPos pos, final ServerWorldAccess worldAccess)
    {
        return biomeAccess.getBiome(pos).isIn(ModTags.Biomes.LYOKO_BIOME) && worldAccess.getBlockState(pos.offset(Direction.Axis.Y, -1)) == Blocks.AIR.getDefaultState();
    }

    public static DefaultAttributeContainer.Builder registerAttributes()
    {
        return HostileEntity.createMobAttributes().add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,1D)
                .add(EntityAttributes.GENERIC_MAX_HEALTH,10D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.2D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,10D)
                .add(EntityAttributes.GENERIC_ARMOR, 10D)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE,20D)
                .add(EntityAttributes.GENERIC_FLYING_SPEED,0.10);
    }
    private final AnimationController<?> controller = new AnimationController<>(this,"hornet_controller",0,this::attackPredicate);
    private final AnimationController<?> controllerMove = new AnimationController<>(this,"hornet_move_controller",0,this::movePredicate);
    @Override
    public void registerControllers(@NotNull AnimationData data) {

        data.addAnimationController(controller);
        data.addAnimationController(controllerMove);

    }
    @Override
    public @NotNull AnimationFactory getFactory() {
        return new AnimationFactory(this);
    }

    private <E extends HornetEntity> PlayState movePredicate(AnimationEvent<E> event)
    {

            controllerMove.setAnimation(new AnimationBuilder().addAnimation("animation.hornet.fly", true));

        return PlayState.CONTINUE;
    }

    private <E extends HornetEntity> @NotNull PlayState attackPredicate(@NotNull AnimationEvent<E> event) {



        if(event.getAnimatable().isAttacking())
        {

            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.hornet.attack", true));

        }
        return PlayState.CONTINUE;


    }


    @Override
    public void attack(@NotNull LivingEntity target, final float distanceFactor) {

        final EntityLaser laser = new EntityLaser(this.world,this,40);
        final double d0 = target.getX() - this.getX();
        final double d1 = target.getBodyY(0.3333333333333333D) - laser.getY();
        final double d2 = target.getZ() - this.getZ();
        final double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        laser.setVelocity(d0, d1 + d3 * (double) 0.2F, d2, 6F, (float) (14 - this.world.getDifficulty().getId() << 2));
        this.playSound(ModSounds.LASERARROW, 1.0F, 1.0F / (this.getRandom().nextFloat() * 1.2f));
        this.world.spawnEntity(laser);
    }




}