package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import com.google.common.graph.Network;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.PhantomEntity;
import net.minecraft.network.IPacket;
import net.minecraft.network.protocol.Packet;
import net.minecraft.util.Mth;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

import javax.annotation.Nonnull;

public class MantaEntity extends Phantom implements IAnimatedEntity, RangedAttackMob {
    private final EntityAnimationManager manager = new EntityAnimationManager();
    private final EntityAnimationController controller = new EntityAnimationController(this, "mantamovecontroller", 20, this::animationPred);

    public MantaEntity(EntityType<? extends Phantom> type, Level worldIn) {
        super(type, worldIn);
        manager.addAnimationController(controller);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();

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
    public void performRangedAttack(LivingEntity target, float distanceFactor) {

        EntityLaser laser = new EntityLaser(this.level, 1.0D, 1.0D, 1.0D);
        double d0 = target.getX() - this.getX();
        double d1 = target.getY(0.3333333333333333D) - laser.getY();
        double d2 = target.getZ() - this.getZ();
        double d3 = (double) Math.sqrt(d0 * d0 + d2 * d2);
        laser.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, (float) (14 - this.level.getDifficulty().getId() * 4));
        this.playSound(ModSounds.LASERARROW.get(), 1.0F, 1.0F / (this.random.nextFloat() * 0.4F + 0.8F));
        this.level.addFreshEntity(laser);
    }

    @Override
    public EntityAnimationManager getAnimationManager() {
        return manager;
    }


    private <E extends MantaEntity> boolean animationPred(AnimationTestEvent<E> event) {
        return false;
    }

}


