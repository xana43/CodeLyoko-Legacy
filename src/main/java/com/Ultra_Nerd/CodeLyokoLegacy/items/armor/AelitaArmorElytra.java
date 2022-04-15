package com.Ultra_Nerd.CodeLyokoLegacy.items.armor;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.client.DimensionCheck;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;


public final class AelitaArmorElytra extends ArmorItem {
    public AelitaArmorElytra(@NotNull ArmorMaterial materialIn, @NotNull EquipmentSlot slot, @NotNull Properties builder) {
        super(materialIn, slot, builder);
    }


    /*public static void EnergyBall(PlayerEntity playerIn, World worldIn) {
        Vec3d aim = playerIn.getLookVec();
        if (playerIn.getInventory().getArmor(EquipmentSlot.CHEST.getIndex()).getItem() == ModItems.AELITA_CHESTPLATE.get()) {
            worldIn.playSound(playerIn, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), ModSounds.LASERARROW.get(), SoundCategory.NEUTRAL, 1f, 1f);
            EntityLaser las = new EntityLaser(worldIn, 1.0D, 1.0D, 1.0D);

            las.setPosition(playerIn.getPosX() + aim.x * 1.5D, playerIn.getPosY() + aim.y * 1.9D, playerIn.getPosZ() + aim.z * 1.5D);
            las.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0f, 10f, 0f);
            if (!worldIn.isRemote) {
                worldIn.addEntity(las);
            }
        }
    }*/





    @Override
    public void inventoryTick(@Nonnull ItemStack stack, @Nonnull Level worldIn, @Nonnull Entity entityIn, int itemSlot, boolean isSelected) {
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
        if (entityIn instanceof Player player) {

            if (!DimensionCheck.playerNotInVanillaWorld(player)) {
                if (player.getInventory().getArmor(EquipmentSlot.CHEST.getIndex()).getItem() == ModItems.AELITA_CHESTPLATE.get()) {
                    player.getInventory().getArmor(EquipmentSlot.CHEST.getIndex()).setCount(0);
                }
                if (player.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).getItem() == ModItems.BLANKHELMET.get()) {
                    player.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).setCount(0);
                }
                if (player.getInventory().getArmor(EquipmentSlot.LEGS.getIndex()).getItem() == ModItems.AELITA_LEGGINGS.get()) {
                    player.getInventory().getArmor(EquipmentSlot.LEGS.getIndex()).setCount(0);
                }
                if (player.getInventory().getArmor(EquipmentSlot.FEET.getIndex()).getItem() == ModItems.AELITA_BOOTS.get()) {
                    player.getInventory().getArmor(EquipmentSlot.FEET.getIndex()).setCount(0);
                }
                for (int I = 0; I < player.getInventory().getContainerSize(); I++) {
                    if (player.getInventory().getItem(I).getItem() == ModItems.FORCE_FIELD_EMITTER.get()) {
                        player.getInventory().setItem(I, ItemStack.EMPTY);
                    }
                }
            }
        }
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, @NotNull Player player) {
        if (!DimensionCheck.playerNotInVanillaWorld(player)) {



            if (player.getInventory().getArmor(EquipmentSlot.CHEST.getIndex()).getItem() == ModItems.AELITA_CHESTPLATE.get()) {
                player.getInventory().getArmor(EquipmentSlot.CHEST.getIndex()).setCount(0);
            }
            if (player.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).getItem() == ModItems.BLANKHELMET.get()) {
                player.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).setCount(0);
            }
            if (player.getInventory().getArmor(EquipmentSlot.LEGS.getIndex()).getItem() == ModItems.AELITA_LEGGINGS.get()) {
                player.getInventory().getArmor(EquipmentSlot.LEGS.getIndex()).setCount(0);
            }
            if (player.getInventory().getArmor(EquipmentSlot.FEET.getIndex()).getItem() == ModItems.AELITA_BOOTS.get()) {
                player.getInventory().getArmor(EquipmentSlot.FEET.getIndex()).setCount(0);
            }
            for (int I = 0; I < player.getInventory().getContainerSize(); I++) {
                if (player.getInventory().getItem(I).getItem() == ModItems.FORCE_FIELD_EMITTER.get()) {
                    player.getInventory().setItem(I, ItemStack.EMPTY);
                }
            }
        } else {
            if (player.getInventory().getArmor(EquipmentSlot.CHEST.getIndex()).getItem() == ModItems.AELITA_CHESTPLATE.get() &&
                    player.getInventory().getArmor(EquipmentSlot.LEGS.getIndex()).getItem() == ModItems.AELITA_LEGGINGS.get() &&
                    player.getInventory().getArmor(EquipmentSlot.FEET.getIndex()).getItem() == ModItems.AELITA_BOOTS.get()) {
                if (player.getInventory().getItem(EquipmentSlot.MAINHAND.getIndex()).getItem() != ModItems.FORCE_FIELD_EMITTER.get()) {
                    player.getInventory().setItem(EquipmentSlot.MAINHAND.getIndex(), new ItemStack(ModItems.FORCE_FIELD_EMITTER.get(), 1));
                }
            }
        }


        if (player.getInventory().getArmor(EquipmentSlot.CHEST.getIndex()).getItem() == ModItems.AELITA_CHESTPLATE.get() &&
                player.getInventory().getArmor(EquipmentSlot.LEGS.getIndex()).getItem() == ModItems.AELITA_LEGGINGS.get() &&
                player.getInventory().getArmor(EquipmentSlot.FEET.getIndex()).getItem() == ModItems.AELITA_BOOTS.get()) {


            if (player.isCrouching() && player.isSprinting() && !player.isOnGround()) {

                if (!player.isFallFlying()) {
                    player.startFallFlying();

                }


            } else if (player.isFallFlying()) {

                player.fallDistance = 0;
                player.stopFallFlying();
            }

        }

    }


    @Nonnull
    @Override
    public InteractionResultHolder<ItemStack> use(@Nonnull Level worldIn, @Nonnull Player playerIn, @Nonnull InteractionHand handIn) {
        InteractionResultHolder<ItemStack> result = super.use(worldIn, playerIn, handIn);
        if (!DimensionCheck.playerNotInVanillaWorld(playerIn)) {
            if (playerIn.getInventory().getArmor(EquipmentSlot.CHEST.getIndex()).getItem() == ModItems.AELITA_CHESTPLATE.get()) {
                playerIn.getInventory().getArmor(EquipmentSlot.CHEST.getIndex()).setCount(0);
            }
            if (playerIn.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).getItem() == ModItems.BLANKHELMET.get()) {
                playerIn.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).setCount(0);
            }
            if (playerIn.getInventory().getArmor(EquipmentSlot.LEGS.getIndex()).getItem() == ModItems.AELITA_LEGGINGS.get()) {
                playerIn.getInventory().getArmor(EquipmentSlot.LEGS.getIndex()).setCount(0);
            }
            if (playerIn.getInventory().getArmor(EquipmentSlot.FEET.getIndex()).getItem() == ModItems.AELITA_BOOTS.get()) {
                playerIn.getInventory().getArmor(EquipmentSlot.FEET.getIndex()).setCount(0);
            }
        } else {
            if (playerIn.getInventory().getArmor(EquipmentSlot.CHEST.getIndex()).getItem() == ModItems.AELITA_CHESTPLATE.get() &&
                    playerIn.getInventory().getArmor(EquipmentSlot.LEGS.getIndex()).getItem() == ModItems.AELITA_LEGGINGS.get() &&
                    playerIn.getInventory().getArmor(EquipmentSlot.FEET.getIndex()).getItem() == ModItems.AELITA_BOOTS.get()) {
                playerIn.getInventory().setItem(EquipmentSlot.MAINHAND.getIndex(), new ItemStack(ModItems.FORCE_FIELD_EMITTER.get(), 1));
            }
        }
        return result;
    }


}
