package com.Ultra_Nerd.CodeLyokoLegacy.Items;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.manager.AnimatableManager;
import software.bernie.geckolib.animatable.processing.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;
import team.reborn.energy.api.base.SimpleEnergyItem;



public final class LaptopClass extends Item implements SimpleEnergyItem, GeoItem {
    private static final RawAnimation STARTUP_ANIMATION = RawAnimation.begin().thenPlay("animation.startup");
    private final long capacity,maxInput,maxOutput;
    public LaptopClass(@NotNull Settings properties,final long capacity,final long maxInput,final long maxOutput) {
        super(properties);
        this.capacity = capacity;
        this.maxInput = maxInput;
        this.maxOutput = maxOutput;
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        super.inventoryTick(stack, world, entity, slot);
        if (stack.getDamage() == 1) {
            tryUseEnergy(stack,1);
        }

        if (getStoredEnergy(stack) <= 0) {
            stack.setDamage(0);
        }
    }




    @Override
    public ActionResult use(@NotNull World worldIn, final PlayerEntity playerIn, final Hand handIn) {
        final ItemStack item = playerIn.getStackInHand(handIn);
        final long currentlyStoredEnergy = getStoredEnergy(item);

        if(playerIn.isSneaking()) {
            if(worldIn.isClient) {
                playerIn.sendMessage(Text.of("energy is " + currentlyStoredEnergy), false);
            }
            return super.use(worldIn, playerIn, handIn);
        }
        if(currentlyStoredEnergy <= 0 && !playerIn.isCreative())
        {
            if(worldIn.isClient) {
                playerIn.sendMessage(Text.translatable("laptop.battery.dead"), false);
            }
            return ActionResult.FAIL;

        }
        if(!worldIn.isClient) {
            triggerAnim(playerIn,GeoItem.getOrAssignId(item,(ServerWorld) worldIn),startupAnimationController,startupAnimationString);
        }
        return super.use(worldIn, playerIn, handIn);
    }

    @Override
    public ActionResult useOnBlock(final ItemUsageContext context) {
        final World world = context.getWorld();
        final BlockPos retrievedBlockPosition = context.getBlockPos().up();
       // if(!world.canSetBlock(retrievedBlockPosition)) {
        //    return ActionResult.FAIL;
        //}
        final ItemPlacementContext placementContext = new ItemPlacementContext(context);
        final BlockState blockStateToPlace = ModBlocks.LAPTOP_BLOCK.getPlacementState(placementContext);
        world.setBlockState(retrievedBlockPosition, blockStateToPlace);
        world.playSound(null,retrievedBlockPosition, SoundEvents.BLOCK_METAL_PLACE, SoundCategory.BLOCKS);
        context.getStack().decrement(1);
        return ActionResult.SUCCESS;
    }

    @Override
    public long getEnergyCapacity(final ItemStack stack) {
        return capacity;
    }

    @Override
    public long getEnergyMaxInput(final ItemStack stack) {
        return maxInput;
    }

    @Override
    public long getEnergyMaxOutput(final ItemStack stack) {
        return maxOutput;
    }
    private static final String startupAnimationString = "startup";
    private static final String startupAnimationController = "active_controller";
    AnimatableInstanceCache thisInstanceCache = GeckoLibUtil.createInstanceCache(this);

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(startupAnimationController, animationState -> PlayState.STOP)
                .triggerableAnim(startupAnimationString, STARTUP_ANIMATION));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return thisInstanceCache;
    }
}
