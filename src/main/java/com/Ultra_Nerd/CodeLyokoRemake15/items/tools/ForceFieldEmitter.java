package com.Ultra_Nerd.CodeLyokoRemake15.items.tools;

import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntityLaser;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.ForgeEventFactory;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Random;
import java.util.function.Predicate;

public final class ForceFieldEmitter extends BowItem {


    public ForceFieldEmitter(@NotNull Properties builder) {
        super(builder);
    }

    @Override
    public int getUseDuration(@Nonnull ItemStack stack) {
        return 18000;
    }

    public static float getArrowVelocity(int charge) {
        float f = (float) charge / 5.0F;
        f = (float) ((StrictMath.pow(f,2) + f * 2.0F) / 3.0F);
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }


    @Override
    public @NotNull Predicate<ItemStack> getAllSupportedProjectiles() {
        return (item) -> item.equals(ItemStack.EMPTY,false);
    }





    @Override
    public void releaseUsing(@Nonnull ItemStack stack, @Nonnull Level worldIn, @Nonnull LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof Player playerentity) {

            int i = this.getUseDuration(stack) - timeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, playerentity, i, true);
            if (i < 0) {
                return;
            }


            final float f = getArrowVelocity(i);
            if (!((double) f < 0.1D)) {
                boolean flag1 = playerentity.isCreative();
                if (worldIn.isClientSide) {
                    final EntityLaser las = new EntityLaser(worldIn, 1.0D, 1.0D, 1.0D);

                    las.setBaseDamage(40);
                    las.setPos(playerentity.position().x, playerentity.getEyeY(), playerentity.position().z);
                    las.setNoGravity(true);

                    las.shootFromRotation(playerentity, playerentity.getRotationVector().x, playerentity.getRotationVector().y, 0.0F, f * 3.0F, 0.1F);
                    if (f == 1.0F) {
                        las.setCritArrow(true);
                    }
                    worldIn.addFreshEntity(las);
                }

                worldIn.playSound( playerentity, playerentity.blockPosition(), ModSounds.LASERARROW.get(), SoundSource.PLAYERS, 1.0F, 1.0F / (new Random().nextFloat() * 0.4F + 1.2F) + f * 0.5F);

                playerentity.awardStat(Stats.ITEM_USED.get(this));
            }

        }
    }


    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@Nonnull Level worldIn, @NotNull Player playerIn, @Nonnull InteractionHand handIn) {
        ItemStack heldItem = playerIn.getItemInHand(handIn);
        if (playerIn.getInventory().getArmor(EquipmentSlot.CHEST.getIndex()).getItem() != ModItems.AELITA_CHESTPLATE.get() &&
                playerIn.getInventory().getArmor(EquipmentSlot.LEGS.getIndex()).getItem() != ModItems.AELITA_LEGGINGS.get() &&
                playerIn.getInventory().getArmor(EquipmentSlot.FEET.getIndex()).getItem() != ModItems.AELITA_BOOTS.get()) {
            return InteractionResultHolder.fail(heldItem);
        }
        //boolean flag = !playerIn.findAmmo(itemstack).isEmpty();

        InteractionResultHolder<ItemStack> ret = ForgeEventFactory.onArrowNock(heldItem, worldIn, playerIn, handIn, true);
        if (ret != null) {
            return ret;
        }

        playerIn.setMainArm(HumanoidArm.RIGHT);
        return InteractionResultHolder.success(heldItem);

    }
}
