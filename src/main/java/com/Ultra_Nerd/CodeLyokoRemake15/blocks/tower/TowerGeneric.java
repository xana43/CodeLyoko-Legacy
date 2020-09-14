package com.Ultra_Nerd.CodeLyokoRemake15.blocks.tower;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class TowerGeneric extends Block {
    public TowerGeneric() {
        super(Block.Properties.create(Material.IRON).hardnessAndResistance(-1, -1).sound(SoundType.GLASS).lightValue(10).harvestLevel(20).harvestTool(ToolType.SHOVEL));
    }

    @Override
    public boolean canCreatureSpawn(BlockState state, IBlockReader world, BlockPos pos, EntitySpawnPlacementRegistry.PlacementType type, @Nullable EntityType<?> entityType) {
        return false;
    }
}
