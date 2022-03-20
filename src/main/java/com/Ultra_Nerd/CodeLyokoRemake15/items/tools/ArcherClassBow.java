package com.Ultra_Nerd.CodeLyokoRemake15.items.tools;

import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntityLaser;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nonnull;
import java.util.function.Predicate;

public class ArcherClassBow extends BowItem {
    private static final Predicate<ItemStack> AMMO = (item) -> item.equals(ItemStack.EMPTY, false);

    public ArcherClassBow(Properties builder) {
        super(builder);
    }

    @Override
    public int getUseDuration(@Nonnull ItemStack stack) {
        return 9000;
    }

    public static float getArrowVelocity(int charge) {
        float f = (float) charge / 5.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }


    public static Predicate<ItemStack> getAMMO() {
        return AMMO;
    }


    @Override
    public void releaseUsing(ItemStack stack, Level worldIn, LivingEntity entityLiving, int timeLeft) {
        super.releaseUsing(stack, worldIn, entityLiving, timeLeft);
        if (entityLiving instanceof Player && stack.getDamageValue() < stack.getMaxDamage()) {
            Player playerentity = (Player) entityLiving;

            int i = this.getUseDuration(stack) - timeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, playerentity, i, true);
            if (i < 0) {
                return;
            }


            float f = getArrowVelocity(i);
            if (!((double) f < 0.1D)) {
                boolean flag1 = playerentity.abilities.isCreativeMode;
                if (worldIn.isClientSide) {
                    EntityLaser las = new EntityLaser(worldIn, 1.0D, 1.0D, 1.0D);

                    las.setDamage(20);
                    las.setPosition(playerentity.getPosX(), playerentity.getPosYEye(), playerentity.getPosZ());

                    AbstractArrowEntity abstractarrowentity;
                    abstractarrowentity = customeArrow(las);
                    abstractarrowentity.shoot(playerentity, playerentity.rotationPitch, playerentity.rotationYaw, 0.0F, f * 3.0F, 0.0F);
                    if (f == 1.0F) {
                        abstractarrowentity.setIsCritical(true);
                    }
                    worldIn.addEntity(abstractarrowentity);
                }

                worldIn.playSound((PlayerEntity) null, playerentity.getPosX(), playerentity.getPosY(), playerentity.getPosZ(), ModSounds.LASERARROW.get(), SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

                playerentity.addStat(Stats.ITEM_USED.get(this));
            }

        }
    }



    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(@Nonnull World worldIn, PlayerEntity playerIn, @Nonnull Hand handIn) {
        ItemStack heldItem = playerIn.getHeldItem(handIn);
        if (playerIn.inventory.armorItemInSlot(EquipmentSlotType.CHEST.getIndex()).getItem() != ModItems.JEREMY_CHESTPLATE.get() &&
                playerIn.inventory.armorItemInSlot(EquipmentSlotType.LEGS.getIndex()).getItem() != ModItems.JEREMY_LEGGINGS.get() &&
                playerIn.inventory.armorItemInSlot(EquipmentSlotType.FEET.getIndex()).getItem() != ModItems.JEREMY_BOOTS.get()
                && heldItem.getDamage() >= heldItem.getMaxDamage()) {


            return ActionResult.resultFail(heldItem);
        }


        ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(heldItem, worldIn, playerIn, handIn, true);
        if (ret != null) return ret;

        playerIn.setActiveHand(handIn);
        return ActionResult.resultSuccess(heldItem);

    }
}
