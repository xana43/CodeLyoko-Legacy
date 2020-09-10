package com.Ultra_Nerd.CodeLyokoRemake15.Entity;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModEntities;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

import javax.annotation.Nonnull;

public class EntityFan extends TridentEntity implements IAnimatedEntity {
    private boolean dealtDamage;
    private ItemStack thrownStack = new ItemStack(ModItems.YUMI_TRADITONAL_FANS.get());
    private EntityAnimationManager manager = new EntityAnimationManager();
    private EntityAnimationController controller = new EntityAnimationController(this,"fancontroller",20,this::animationpred);
    public EntityFan(EntityType<? extends TridentEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public EntityFan(World world, LivingEntity thrower, ItemStack thrownStackIn) {
        super(ModEntities.FAN.get(), world);
        this.thrownStack = thrownStackIn.copy();
        manager.addAnimationController(controller);
    }


    @Nonnull
    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public void tick() {
        if (this.timeInGround > 4) {
            this.dealtDamage = true;
        }

        Entity entity = this.getShooter();
        if ((this.dealtDamage || this.getNoClip()) && entity != null) {
            this.setNoClip(true);
            Vec3d vec3d = new Vec3d(entity.getPosX() - this.getPosX(), entity.getPosYEye() - this.getPosY(), entity.getPosZ() - this.getPosZ());
            this.setRawPosition(this.getPosX(), this.getPosY() + vec3d.y * 0.015D * 1, this.getPosZ());
            if (this.world.isRemote) {
                this.lastTickPosY = this.getPosY();
            }


            this.setMotion(this.getMotion().scale(0.95D).add(vec3d.normalize().scale(1)));
            if (this.returningTicks == 0) {
                this.playSound(SoundEvents.ITEM_TRIDENT_RETURN, 10.0F, 1.0F);
            }

            ++this.returningTicks;
        }


        super.tick();
    }

    private <E extends EntityFan> boolean animationpred(AnimationTestEvent<E> event) {

           controller.setAnimation(new AnimationBuilder().addAnimation("animation.fan.spin",true));
           return true;


    }
    @Override
    public EntityAnimationManager getAnimationManager() {
        return manager;
    }


}
