package com.Ultra_Nerd.CodeLyokoLegacy.Entity.HostileEntities;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.ProjectileEntities.LaserEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModSounds;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.ProjectileAttackGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.biome.source.BiomeAccess;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;



@SuppressWarnings("MethodMayBeStatic")
public final class HornetEntity extends PhantomEntity implements GeoAnimatable, RangedAttackMob {


    private final AnimationController<?> controller = new AnimationController<>(this, "hornet_controller", 0,
            this::attackPredicate);

    public HornetEntity(@NotNull EntityType<? extends PhantomEntity> hornetEntityEntityType, @NotNull World world) {
        super(hornetEntityEntityType, world);


    }

    public static boolean isValidSpawn(final BiomeAccess biomeAccess, final BlockPos pos, final ServerWorldAccess worldAccess) {
        return biomeAccess.getBiome(pos).isIn(ModTags.Biomes.LYOKO_BIOMES) && worldAccess.getBlockState(
                pos.offset(Direction.Axis.Y, -1)) == Blocks.AIR.getDefaultState();
    }

    public static DefaultAttributeContainer.Builder registerAttributes() {
        return HostileEntity.createMobAttributes().add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1D)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10D)
                .add(EntityAttributes.GENERIC_ARMOR, 10D)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20D)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.10);
    }


    @Override
    protected void fall(final double heightDifference, final boolean onGround, final BlockState landedState, final BlockPos landedPosition) {

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
            this.getWorld().playSound(null, this.getX(), this.getY(), this.getZ(), ModSounds.HORNETFLY,
                    SoundCategory.HOSTILE, 0.95F + this.random.nextFloat() * 0.05F,
                    0.95F + this.random.nextFloat() * 0.05F);
        }


    }


    @Override
    protected float getSoundVolume() {

        return 1;
    }

    @Override
    protected void initGoals() {
        super.initGoals();

        this.goalSelector.add(2, new ProjectileAttackGoal(this, 6, 6, 10) {
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
        //this.goalSelector.add(1, new FlyGoal(this, 3));
        this.goalSelector.add(3, new LookAroundGoal(this));
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 10, 100, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }



    @Override
    protected SoundEvent getHurtSound(final DamageSource damageSourceIn) {
        return super.getHurtSound(damageSourceIn);
    }



    @Override
    public boolean canSpawn(final WorldAccess world, final SpawnReason spawnReason) {
        return true;
    }

    @Override
    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar data) {

        data.add(controller);
        data.add(controllerMove);

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return GeckoLibUtil.createInstanceCache(this);
    }

    @Override
    public double getTick(final Object o) {
        return 0;
    }

    private <E extends HornetEntity> PlayState movePredicate(AnimationState<E> event) {

        controllerMove.setAnimation(RawAnimation.begin().thenLoop("animation.hornet.fly"));

        return PlayState.CONTINUE;
    }

    private <E extends HornetEntity> @NotNull PlayState attackPredicate(@NotNull AnimationState<E> event) {


        if (event.getAnimatable().isAttacking()) {

            event.getController().setAnimation(RawAnimation.begin().thenLoop("animation.hornet.attack"));

        }
        return PlayState.CONTINUE;


    }    private final AnimationController<?> controllerMove = new AnimationController<>(this, "hornet_move_controller", 0,
            this::movePredicate);

    @Override
    public void shootAt(@NotNull LivingEntity target, final float distanceFactor) {

        final LaserEntity laser = new LaserEntity(this.getWorld(), this, 40);
        final double d0 = target.getX() - this.getX();
        final double d1 = target.getBodyY(0.3333333333333333D) - laser.getY();
        final double d2 = target.getZ() - this.getZ();
        final double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        laser.setVelocity(d0, d1 + d3 * (double) 0.2F, d2, 6F, (float) (14 - this.getWorld().getDifficulty().getId() << 2));
        this.playSound(ModSounds.LASERARROW, getSoundVolume(),
                1.0F / (this.getRandom().nextFloat() * 1.2f));
        this.getWorld().spawnEntity(laser);
    }

    //@Override
    //public @NotNull AnimationFactory getFactory() {
    //   return new AnimationFactory(this);
    //}




}
