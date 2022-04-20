package com.Ultra_Nerd.CodeLyokoLegacy.items.tools;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityLaser;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModSounds;
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
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.function.Predicate;

public final class ArcherClassBow extends BowItem {

    public ArcherClassBow(@NotNull Properties builder) {
        super(builder);
    }

    @Override
    public int getUseDuration(@Nonnull ItemStack stack) {
        return 9000;
    }

    public static float getArrowVelocity(int charge) {
        float f = (float) charge / 5.0F;
        f = (float) ((StrictMath.pow(f,2) + f * 2) / 3.0F);
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    @Override
    public @NotNull Predicate<ItemStack> getAllSupportedProjectiles() {
        return (item) -> item.equals(ItemStack.EMPTY, false);
    }




    @Override
    public void releaseUsing(@NotNull ItemStack stack, @NotNull Level worldIn, @NotNull LivingEntity entityLiving, int timeLeft) {
        super.releaseUsing(stack, worldIn, entityLiving, timeLeft);
        if (entityLiving instanceof Player playerentity && stack.getDamageValue() < stack.getMaxDamage()) {

            int i = this.getUseDuration(stack) - timeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, playerentity, i, true);
            if (i < 0) {
                return;
            }


            float f = getArrowVelocity(i);
            if (!((double) f < 0.1D)) {
                boolean flag1 = playerentity.isCreative();
                if (worldIn.isClientSide) {
                    EntityLaser las = new EntityLaser(worldIn, 1.0D, 1.0D, 1.0D);

                    las.setBaseDamage(20);
                    las.setPos(playerentity.getX(), playerentity.getEyeY(), playerentity.getZ());


                    las.shootFromRotation(playerentity, playerentity.getXRot(), playerentity.getYRot(), 0.0F, f * 3.0F, 0.0F);
                    if (f == 1.0F) {
                        las.setCritArrow(true);
                    }
                    worldIn.addFreshEntity(las);
                }

                worldIn.playSound(null, playerentity.getX(), playerentity.getY(), playerentity.getZ(), ModSounds.LASERARROW.get(), SoundSource.PLAYERS, 1.0F, 1.0F / ((float)Math.random() * 0.4F + 1.2F) + f * 0.5F);

                playerentity.awardStat(Stats.ITEM_USED.get(this));
            }

        }
    }



    @Nonnull
    @Override
    public InteractionResultHolder<ItemStack> use(@Nonnull Level worldIn, @NotNull Player playerIn, @Nonnull InteractionHand handIn) {
        ItemStack heldItem = playerIn.getItemInHand(handIn);
        if (playerIn.getInventory().getArmor(EquipmentSlot.CHEST.getIndex()).getItem() != ModItems.JEREMY_CHESTPLATE.get() &&
                playerIn.getInventory().getArmor(EquipmentSlot.LEGS.getIndex()).getItem() != ModItems.JEREMY_LEGGINGS.get() &&
                playerIn.getInventory().getArmor(EquipmentSlot.FEET.getIndex()).getItem() != ModItems.JEREMY_BOOTS.get()
                && heldItem.getDamageValue() >= heldItem.getMaxDamage()) {


            return InteractionResultHolder.fail(heldItem);
        }


        InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(heldItem, worldIn, playerIn, handIn, true);
        if (ret != null) {
            return ret;
        }

        playerIn.setMainArm(HumanoidArm.RIGHT);
        return InteractionResultHolder.success(heldItem);

    }
}
