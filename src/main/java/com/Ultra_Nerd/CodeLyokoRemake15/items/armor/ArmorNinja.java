package com.Ultra_Nerd.CodeLyokoRemake15.items.armor;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.BlockHitResult;

public class ArmorNinja extends ArmorItem {
    public ArmorNinja(ArmorMaterial materialIn, EquipmentSlot slot, Properties builder) {
        super(materialIn, slot, builder);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {


        BlockHitResult trace = new BlockHitResult(player.getLookAngle(), player.getDirection(),player.eyeBlockPosition(),false);
        BlockPos pos = new BlockPos(trace.getBlockPos().getX(), trace.getBlockPos().getY(), trace.getBlockPos().getZ());
        Block test = world.getBlockState(pos).getBlock();


    }
}
