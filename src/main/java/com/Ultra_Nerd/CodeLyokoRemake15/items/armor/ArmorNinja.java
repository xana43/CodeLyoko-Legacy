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
import org.jetbrains.annotations.NotNull;

public final class ArmorNinja extends ArmorItem {
    public ArmorNinja(@NotNull ArmorMaterial materialIn, @NotNull EquipmentSlot slot, @NotNull Properties builder) {
        super(materialIn, slot, builder);
    }

    @Override
    public void onArmorTick(ItemStack stack, @NotNull Level world, @NotNull Player player) {


        final BlockHitResult trace = new BlockHitResult(player.getLookAngle(), player.getDirection(),player.eyeBlockPosition(),false);
        final BlockPos pos = new BlockPos(trace.getBlockPos().getX(), trace.getBlockPos().getY(), trace.getBlockPos().getZ());
        final Block test = world.getBlockState(pos).getBlock();


    }
}
