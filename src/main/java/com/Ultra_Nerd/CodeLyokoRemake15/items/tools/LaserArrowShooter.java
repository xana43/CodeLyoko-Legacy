package com.Ultra_Nerd.CodeLyokoRemake15.items.tools;

import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntityLaser;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.ForestSector.ForestDimension;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import javax.annotation.Nonnull;


public class LaserArrowShooter extends BowItem {
    private byte Count = 100;


    @Override
    public void inventoryTick(@Nonnull ItemStack stack, World worldIn, @Nonnull Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isRemote()) {
            Count -= 1;
            if (Count == 0) {
                if (stack.getDamage() != 0) {
                    stack.damageItem(-1, (PlayerEntity) entityIn, null);
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
    public ActionResult<ItemStack> onItemRightClick(@Nonnull World worldIn, PlayerEntity playerIn, @Nonnull Hand handIn) {
        ItemStack item = playerIn.getHeldItem(handIn);
        Count = 100;

        Vec3d aim = playerIn.getLookVec();
        if (item.getDamage() < 40 && playerIn.inventory.armorItemInSlot(EquipmentSlotType.CHEST.getIndex()).getItem() == ModItems.ODD_CHESTPLATE.get() && playerIn.world.dimension instanceof ForestDimension) {
            //worldIn.playSound(null,playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), ModItems.BIT.get(), SoundCategory.NEUTRAL, 1f, 1f);


            worldIn.playSound(playerIn, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), ModSounds.LASERARROW.get(), SoundCategory.NEUTRAL, 1f, 1f);


            EntityLaser las = new EntityLaser(worldIn, 1.0D, 1.0D, 1.0D);

            las.setDamage(10);
            las.setPosition(playerIn.getPosX() + aim.x * 1.5D, playerIn.getPosY() + aim.y * 1.9D, playerIn.getPosZ() + aim.z * 1.5D);
            las.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0f, 10f, 0f);
            if (!worldIn.isRemote) {
                worldIn.addEntity(las);
            }

            item.damageItem(1, playerIn, null);
            return new ActionResult<>(ActionResultType.SUCCESS, item);
        } else {
            return new ActionResult<>(ActionResultType.FAIL, item);
        }
    }


}
