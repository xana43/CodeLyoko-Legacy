package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.blockentity.SyncedBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

/**
 * @author Ultra_Nerd
 * @desc <br/>
 * @since 2025-04-07
 */
public final class LaptopBlockEntity extends SyncedBlockEntity implements GeoBlockEntity {
    private static final RawAnimation openAnimation = RawAnimation.begin().thenPlay("animation.open").thenPlay("animation.startup");
    private static final RawAnimation closeAnimation = RawAnimation.begin().thenPlayAndHold("animation.close");
    private final AnimatableInstanceCache animatableInstanceCache = GeckoLibUtil.createInstanceCache(this);
    public LaptopBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.LAPTOP_BLOCK_ENTITY, pos, state);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
        mainController.tryTriggerAnimation("close");
    }
    private boolean laptopOpen = false;
    public void openLaptop() {
        laptopOpen = true;
        assert world != null;
        if(!world.isClient())
        {
            return;
        }
        if(mainController.getAnimationState() == AnimationController.State.RUNNING)
        {
            return;
        }

        mainController.tryTriggerAnimation("open");
        update();
    }
    public void closeLaptop() {
        laptopOpen = false;
        assert world != null;
        if(!world.isClient())
        {
            return;
        }
        if(mainController.getAnimationState() == AnimationController.State.RUNNING)
        {
            return;
        }
        mainController.tryTriggerAnimation("close");
        update();
    }
    public boolean isLaptopOpen() {
        return laptopOpen;
    }
    private static final String isOpen = "is_open";
    @Override
    protected void writeNbt(final NbtCompound nbt,final RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        nbt.putBoolean(isOpen, laptopOpen);
    }

    @Override
    protected void readNbt(final NbtCompound nbt, final RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        laptopOpen = nbt.getBoolean(isOpen);
        mainController.tryTriggerAnimation(nbt.getBoolean(isOpen)? "open" : "close");
    }
    private final AnimationController<LaptopBlockEntity> mainController = new AnimationController<>(this, animationState -> PlayState.STOP).triggerableAnim("open", openAnimation).triggerableAnim("close", closeAnimation);
    @Override
    public void registerControllers(final AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(mainController);
    }
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return animatableInstanceCache;
    }
}
