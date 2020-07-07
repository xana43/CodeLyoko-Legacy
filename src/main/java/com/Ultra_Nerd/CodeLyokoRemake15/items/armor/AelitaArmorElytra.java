package com.Ultra_Nerd.CodeLyokoRemake15.items.armor;

import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntityLaser;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.ForestSector.ForestDimension;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


public class AelitaArmorElytra extends ArmorItem {

    public AelitaArmorElytra(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
        super(materialIn, slot, builder);
    }


    public static void EnergyBall(PlayerEntity playerIn,World worldIn)
    {



        Vec3d aim = playerIn.getLookVec();
        if (playerIn.inventory.armorItemInSlot(EquipmentSlotType.CHEST.getIndex()).getItem() == ModItems.AELITA_CHESTPLATE.get()) {
            worldIn.playSound(playerIn, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), ModSounds.LASERARROW.get(), SoundCategory.NEUTRAL, 1f, 1f);
            EntityLaser las = new EntityLaser(worldIn, 1.0D, 1.0D, 1.0D);

            las.setPosition(playerIn.getPosX() + aim.x * 1.5D, playerIn.getPosY() + aim.y * 1.9D, playerIn.getPosZ() + aim.z * 1.5D);
            las.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0f, 10f, 0f);
            if (!worldIn.isRemote) {
                worldIn.addEntity(las);
            }
        }
    }
    
    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if(!(player.world.dimension instanceof ForestDimension)) {
            if(player.inventory.armorItemInSlot(EquipmentSlotType.CHEST.getIndex()).getItem() == ModItems.AELITA_CHESTPLATE.get())
            {
                player.inventory.armorItemInSlot(EquipmentSlotType.CHEST.getIndex()).setCount(0);

                if(player.inventory.armorItemInSlot(EquipmentSlotType.HEAD.getIndex()).getItem() == ModItems.BLANKHELMET.get()) {
                    player.inventory.armorItemInSlot(EquipmentSlotType.HEAD.getIndex()).setCount(0);
                }
            }

        }
        else {
            if (player.inventory.armorItemInSlot(EquipmentSlotType.CHEST.getIndex()).getItem() == ModItems.AELITA_CHESTPLATE.get() && player.inventory.armorItemInSlot(EquipmentSlotType.LEGS.getIndex()).getItem() == ModItems.AELITA_LEGGINGS.get() && player.inventory.armorItemInSlot(EquipmentSlotType.FEET.getIndex()).getItem() == ModItems.AELITA_BOOTS.get()) {

                player.onLivingFall(2, 1);
                if (player.isAirBorne && player.isCrouching() && !player.onGround) {

                    if (!player.isElytraFlying()) {
                        player.startFallFlying();

                    }
                    player.onLivingFall(4, 1);
                    player.fallDistance = 4;
                } else if (player.isElytraFlying() && player.onGround) {
                    player.stopFallFlying();
                    player.fallDistance = 4;
                    player.onLivingFall(4, 1);
                }

            }
        }
    }



}
