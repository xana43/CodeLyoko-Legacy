package com.Ultra_Nerd.CodeLyokoRemake15.items.tools;

import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntityLaser;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.Carthage.Sector5Dimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.DesertSector.DesertDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.DigitalOcean.OceanDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.ForestSector.ForestDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.IceSector.IceDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.MountainSector.MountainDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.VolcanoSector.VolcanoDimension;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nonnull;


public class LaserArrowShooter extends BowItem {
    private byte Count = 100;


    @Override
    public void inventoryTick(@Nonnull ItemStack stack, Level worldIn, @Nonnull Entity entityIn, int itemSlot, boolean isSelected) {
        if (worldIn.isClientSide) {
            Count -= 1;
            if (Count == 0) {
                if (stack.getDamageValue() != 0) {
                    stack.getItem().damageItem(-1, (Player) entityIn, null);
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
        if (item.getDamage() < 40 && playerIn.inventory.armorItemInSlot(EquipmentSlotType.CHEST.getIndex()).getItem() == ModItems.ODD_CHESTPLATE.get() && checkDim(playerIn)) {
            //worldIn.playSound(null,playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), ModItems.BIT.get(), SoundCategory.NEUTRAL, 1f, 1f);


            worldIn.playSound(playerIn, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), ModSounds.LASERARROW.get(), SoundCategory.NEUTRAL, 1f, 1f);


            EntityLaser las = new EntityLaser(worldIn, 1.0D, 1.0D, 1.0D);

            las.setDamage(10);
            las.hasNoGravity();
            las.setPosition(playerIn.getPosX(), playerIn.getPosYEye(), playerIn.getPosZ());
            las.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0f, 10f, 0f);
            if (!worldIn.isRemote) {
                worldIn.addEntity(las);
            }

            item.damageItem(1, playerIn, null);
            return new ActionResult<>(ActionResultType.PASS, item);
        } else {
            return new ActionResult<>(ActionResultType.FAIL, item);
        }
    }


}
