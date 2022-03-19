package com.Ultra_Nerd.CodeLyokoRemake15.items.armor;

import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.Carthage.Sector5Dimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.DesertSector.DesertDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.DigitalOcean.OceanDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.ForestSector.ForestDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.IceSector.IceDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.MountainSector.MountainDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.VolcanoSector.VolcanoDimension;
import net.minecraft.block.Block;
import net.minecraft.core.BlockPos;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
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
