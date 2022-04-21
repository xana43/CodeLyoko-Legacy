package com.Ultra_Nerd.CodeLyokoLegacy.Entity;

public final class EntityFan /*extends ThrownTrident implements IAnimatable*/ {
    /*private boolean dealtDamage;
    private final AnimationFactory manager = new AnimationFactory(this);
    private final AnimationController<?> controller = new AnimationController<>(this, "fancontroller", 20, this::animationpred);
    private ItemStack thrownstack;
    public EntityFan(@NotNull EntityType<? extends ThrownTrident> type, @NotNull Level worldIn) {
        super(type,worldIn);
    }

    public EntityFan(@NotNull Level world, LivingEntity thrower, ItemStack thrownStackIn) {
        super(ModEntities.FAN.get(), world);
        this.thrownstack = new ItemStack(ModItems.YUMI_TRADITONAL_FANS.get());

    }



    @Nonnull
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public void tick() {
        if (this.inGroundTime > 4) {
            this.dealtDamage = true;
        }

        Entity entity = this.getOwner();
        if ((this.dealtDamage || this.noPhysics) && entity != null) {
            this.setNoPhysics(true);
            Vec3 vec3d = new Vec3(entity.getX() - this.getY(), entity.getEyeY() - this.getY(), entity.getZ() - this.getZ());
            this.setPosRaw(this.getX(), this.getY() + vec3d.y * 0.015D * 1, this.getZ());
            if (!this.level.isClientSide) {
                this.yOld = this.getY();
            }


            this.setDeltaMovement(this.getDeltaMovement().scale(0.95D).add(vec3d.normalize().scale(1)));
            if (this.clientSideReturnTridentTickCount == 0) {
                this.playSound(SoundEvents.TRIDENT_RETURN, 10.0F, 1.0F);
            }

            ++this.clientSideReturnTridentTickCount;
        }


        super.tick();
    }

    private <E extends EntityFan> @NotNull PlayState animationpred(AnimationEvent<E> event) {

        controller.setAnimation(new AnimationBuilder().addAnimation("animation.fan.spin", true));
        return PlayState.CONTINUE;


    }

    @Override
    public @NotNull AnimationFactory getFactory() {
        return manager;
    }

    @Override
    public void registerControllers(@NotNull AnimationData data) {
        data.addAnimationController(controller);
    }

     */
}
