package com.Ultra_Nerd.CodeLyokoRemake15.items.tools;

import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntityLaser;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nonnull;

import static com.Ultra_Nerd.CodeLyokoRemake15.Util.client.DimensionCheck.playerNotInVanillaWorld;


public class LaserArrowShooter extends BowItem {
    private byte Count = 100;


    @Override
    public void inventoryTick(@Nonnull ItemStack stack, Level worldIn, @Nonnull Entity entityIn, int itemSlot, boolean isSelected) {
        if (worldIn.isClientSide) {
            Count -= 1;
            if (Count == 0) {
                if (stack.getDamageValue() != 0) {
                    stack.getItem().damageItem(stack,-1, (Player) entityIn, null);
                }
                Count = 100;
            }
        }
    }

    public LaserArrowShooter(Properties builder) {
        super(builder);
        // TODO Auto-generated constructor stub
    }




    @Nonnull
    @Override
    public InteractionResultHolder<ItemStack> use(@Nonnull Level worldIn, Player playerIn, @Nonnull InteractionHand handIn) {
        ItemStack item = playerIn.getItemInHand(handIn);
        Count = 100;

        Vec3 aim = playerIn.getLookAngle();
        if (item.getDamageValue() < 40 && playerIn.getInventory().getArmor(EquipmentSlot.CHEST.getIndex()).getItem() == ModItems.ODD_CHESTPLATE.get() && playerNotInVanillaWorld(playerIn)) {
            //worldIn.playSound(null,playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), ModItems.BIT.get(), SoundCategory.NEUTRAL, 1f, 1f);


            worldIn.playSound(playerIn, playerIn.getX(), playerIn.getY(), playerIn.getZ(), ModSounds.LASERARROW.get(), SoundSource.NEUTRAL, 1f, 1f);


            EntityLaser las = new EntityLaser(worldIn, 1.0D, 1.0D, 1.0D);

            las.setBaseDamage(10);
            las.isNoGravity();
            las.setPos(playerIn.getX(), playerIn.getEyeY(), playerIn.getZ());
            las.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot(), 0f, 10f, 0f);
            if (worldIn.isClientSide) {
                worldIn.addFreshEntity(las);
            }

            item.getItem().damageItem(item,1, playerIn, null);
            return new InteractionResultHolder<>(InteractionResult.PASS, item);
        } else {
            return new InteractionResultHolder<>(InteractionResult.FAIL, item);
        }
    }


}
