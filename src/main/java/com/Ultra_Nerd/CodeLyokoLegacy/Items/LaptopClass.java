package com.Ultra_Nerd.CodeLyokoLegacy.Items;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModSounds;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import team.reborn.energy.api.base.SimpleEnergyItem;



public final class LaptopClass extends Item implements SimpleEnergyItem{

    private final long capacity,maxInput,maxOutput;
    public LaptopClass(@NotNull Settings properties,final long capacity,final long maxInput,final long maxOutput) {
        super(properties);
        this.capacity = capacity;
        this.maxInput = maxInput;
        this.maxOutput = maxOutput;
    }

    @Override
    public void inventoryTick(final ItemStack stack, final World world, final Entity entity, final int slot, final boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (stack.getDamage() == 1) {
            tryUseEnergy(stack,1);
        }
        if (getStoredEnergy(stack) <= 0) {
            stack.setDamage(0);
        }

    }


    @Override
    public TypedActionResult<ItemStack> use(@NotNull World worldIn, final PlayerEntity playerIn, final Hand handIn) {
        final PacketByteBuf buf = PacketByteBufs.create();
        final ItemStack item = playerIn.getStackInHand(handIn);
        if (getStoredEnergy(item) > 0 || playerIn.isCreative() && !playerIn.isSneaking()) {
            if (item.getItem() == this && item.getDamage() == 0) {
                item.setDamage(1);
                if (!worldIn.isClient) {
                    buf.clear();
                    buf.writeBoolean(true);
                    //ServerPlayNetworking.send((ServerPlayerEntity) playerIn, PacketHandler.OPEN_LAPTOP_ON_CLIENT,buf);
                }
                worldIn.playSound(playerIn, playerIn.getBlockPos(), ModSounds.OPENTOWERGUISOUND, SoundCategory.BLOCKS,
                        1, 1);
            } else if (item.getItem() == this && item.getDamage() == 1) {
                item.setDamage(0);


            }
        } else if (playerIn.isSneaking() && worldIn.isClient()) {
            playerIn.sendMessage(Text.of("energy is " + getStoredEnergy(item)), false);
        } else {
            if(!worldIn.isClient) {
                buf.clear();
                buf.writeBoolean(false);
                //ServerPlayNetworking.send((ServerPlayerEntity) playerIn, PacketHandler.OPEN_LAPTOP_ON_CLIENT, buf);
            }
            item.setDamage(0);
            playerIn.sendMessage(Text.translatable("laptop.battery.dead"), false);
        }


        return super.use(worldIn, playerIn, handIn);
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


}
