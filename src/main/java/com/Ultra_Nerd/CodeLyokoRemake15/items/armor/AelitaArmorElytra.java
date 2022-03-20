package com.Ultra_Nerd.CodeLyokoRemake15.items.armor;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModDimensionTypes;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.Carthage.Sector5Dimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.DesertSector.DesertDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.DigitalOcean.OceanDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.IceSector.IceDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.MountainSector.MountainDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.VolcanoSector.VolcanoDimension;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nonnull;


public class AelitaArmorElytra extends ArmorItem {
    public AelitaArmorElytra(ArmorMaterial materialIn, EquipmentSlot slot, Properties builder) {
        super(materialIn, slot, builder);
    }


    /*public static void EnergyBall(PlayerEntity playerIn, World worldIn) {
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
    }*/


    private boolean checkDim(Player player) {
        return player.level.dimension().registry() == ModDimensionTypes.DimensionTypeForest || player.world.dimension instanceof IceDimension ||
                player.world.dimension instanceof DesertDimension || player.world.dimension instanceof MountainDimension
                || player.world.dimension instanceof Sector5Dimension || player.world.dimension instanceof OceanDimension || player.world.dimension
                instanceof VolcanoDimension;
    }


    @Override
    public void inventoryTick(@Nonnull ItemStack stack, @Nonnull World worldIn, @Nonnull Entity entityIn, int itemSlot, boolean isSelected) {
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
        if (entityIn instanceof PlayerEntity || !worldIn.isRemote) {
            PlayerEntity player = (PlayerEntity) entityIn;

            if (!checkDim(player)) {
                if (player.inventory.armorItemInSlot(EquipmentSlotType.CHEST.getIndex()).getItem() == ModItems.AELITA_CHESTPLATE.get()) {
                    player.inventory.armorItemInSlot(EquipmentSlotType.CHEST.getIndex()).setCount(0);
                }
                if (player.inventory.armorItemInSlot(EquipmentSlotType.HEAD.getIndex()).getItem() == ModItems.BLANKHELMET.get()) {
                    player.inventory.armorItemInSlot(EquipmentSlotType.HEAD.getIndex()).setCount(0);
                }
                if (player.inventory.armorItemInSlot(EquipmentSlotType.LEGS.getIndex()).getItem() == ModItems.AELITA_LEGGINGS.get()) {
                    player.inventory.armorItemInSlot(EquipmentSlotType.LEGS.getIndex()).setCount(0);
                }
                if (player.inventory.armorItemInSlot(EquipmentSlotType.FEET.getIndex()).getItem() == ModItems.AELITA_BOOTS.get()) {
                    player.inventory.armorItemInSlot(EquipmentSlotType.FEET.getIndex()).setCount(0);
                }
                for (int I = 0; I < player.inventory.getSizeInventory(); I++) {
                    if (player.inventory.getStackInSlot(I).getItem() == ModItems.FORCE_FIELD_EMITTER.get()) {
                        player.inventory.setInventorySlotContents(I, ItemStack.EMPTY);
                    }
                }
            }
        }
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!checkDim(player)) {
            if (player.getInventory().getArmor(EquipmentSlot.CHEST.getIndex()).getItem() == ModItems.AELITA_CHESTPLATE.get()) {
                player.getInventory().getArmor(EquipmentSlot.CHEST.getIndex()).setCount(0);
            }
            if (player.inventory.armorItemInSlot(EquipmentSlotType.HEAD.getIndex()).getItem() == ModItems.BLANKHELMET.get()) {
                player.inventory.armorItemInSlot(EquipmentSlotType.HEAD.getIndex()).setCount(0);
            }
            if (player.inventory.armorItemInSlot(EquipmentSlotType.LEGS.getIndex()).getItem() == ModItems.AELITA_LEGGINGS.get()) {
                player.inventory.armorItemInSlot(EquipmentSlotType.LEGS.getIndex()).setCount(0);
            }
            if (player.inventory.armorItemInSlot(EquipmentSlotType.FEET.getIndex()).getItem() == ModItems.AELITA_BOOTS.get()) {
                player.inventory.armorItemInSlot(EquipmentSlotType.FEET.getIndex()).setCount(0);
            }
            for (int I = 0; I < player.inventory.getSizeInventory(); I++) {
                if (player.inventory.getStackInSlot(I).getItem() == ModItems.FORCE_FIELD_EMITTER.get()) {
                    player.inventory.setInventorySlotContents(I, ItemStack.EMPTY);
                }
            }
        } else {
            if (player.inventory.armorItemInSlot(EquipmentSlotType.CHEST.getIndex()).getItem() == ModItems.AELITA_CHESTPLATE.get() &&
                    player.inventory.armorItemInSlot(EquipmentSlotType.LEGS.getIndex()).getItem() == ModItems.AELITA_LEGGINGS.get() &&
                    player.inventory.armorItemInSlot(EquipmentSlotType.FEET.getIndex()).getItem() == ModItems.AELITA_BOOTS.get()) {
                if (player.inventory.getStackInSlot(EquipmentSlotType.MAINHAND.getIndex()).getItem() != ModItems.FORCE_FIELD_EMITTER.get()) {
                    player.inventory.add(EquipmentSlotType.MAINHAND.getSlotIndex(), new ItemStack(ModItems.FORCE_FIELD_EMITTER.get(), 1));
                }
            }
        }


        if (player.inventory.armorItemInSlot(EquipmentSlotType.CHEST.getIndex()).getItem() == ModItems.AELITA_CHESTPLATE.get() &&
                player.inventory.armorItemInSlot(EquipmentSlotType.LEGS.getIndex()).getItem() == ModItems.AELITA_LEGGINGS.get() &&
                player.inventory.armorItemInSlot(EquipmentSlotType.FEET.getIndex()).getItem() == ModItems.AELITA_BOOTS.get()) {

            player.onLivingFall(2, 1);
            if (player.isAirBorne && player.isCrouching() && player.isSprinting() && !player.onGround) {

                if (!player.isElytraFlying()) {
                    player.startFallFlying();

                }
                player.onLivingFall(0, 0);
                player.fallDistance = 0;
            } else if (player.isFallFlying()) {

                player.fallDistance = 0;
                player.causeFallDamage(0, 0,null);
                player.stopFallFlying();
            }

        }

    }


    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(@Nonnull World worldIn, @Nonnull PlayerEntity playerIn, @Nonnull Hand handIn) {
        ActionResult<ItemStack> result = super.onItemRightClick(worldIn, playerIn, handIn);
        if (!checkDim(playerIn)) {
            if (playerIn.inventory.armorItemInSlot(EquipmentSlotType.CHEST.getIndex()).getItem() == ModItems.AELITA_CHESTPLATE.get()) {
                playerIn.inventory.armorItemInSlot(EquipmentSlotType.CHEST.getIndex()).setCount(0);
            }
            if (playerIn.inventory.armorItemInSlot(EquipmentSlotType.HEAD.getIndex()).getItem() == ModItems.BLANKHELMET.get()) {
                playerIn.inventory.armorItemInSlot(EquipmentSlotType.HEAD.getIndex()).setCount(0);
            }
            if (playerIn.inventory.armorItemInSlot(EquipmentSlotType.LEGS.getIndex()).getItem() == ModItems.AELITA_LEGGINGS.get()) {
                playerIn.inventory.armorItemInSlot(EquipmentSlotType.LEGS.getIndex()).setCount(0);
            }
            if (playerIn.inventory.armorItemInSlot(EquipmentSlotType.FEET.getIndex()).getItem() == ModItems.AELITA_BOOTS.get()) {
                playerIn.inventory.armorItemInSlot(EquipmentSlotType.FEET.getIndex()).setCount(0);
            }
        } else {
            if (playerIn.inventory.armorItemInSlot(EquipmentSlotType.CHEST.getIndex()).getItem() == ModItems.AELITA_CHESTPLATE.get() &&
                    playerIn.inventory.armorItemInSlot(EquipmentSlotType.LEGS.getIndex()).getItem() == ModItems.AELITA_LEGGINGS.get() &&
                    playerIn.inventory.armorItemInSlot(EquipmentSlotType.FEET.getIndex()).getItem() == ModItems.AELITA_BOOTS.get()) {
                playerIn.inventory.add(EquipmentSlotType.MAINHAND.getSlotIndex(), new ItemStack(ModItems.FORCE_FIELD_EMITTER.get(), 1));
            }
        }
        return result;
    }


}
