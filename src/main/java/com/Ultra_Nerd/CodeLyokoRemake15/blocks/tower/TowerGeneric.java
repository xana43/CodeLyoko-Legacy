package com.Ultra_Nerd.CodeLyokoRemake15.blocks.tower;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolType;

public class TowerGeneric extends Block {
    public TowerGeneric() {
        super(Block.Properties.create(Material.IRON).hardnessAndResistance(-1, -1).sound(SoundType.GLASS).lightValue(10).harvestLevel(20).harvestTool(ToolType.SHOVEL));
    }



    @Override
    public boolean isValidSpawn(BlockState state, BlockGetter level, BlockPos pos, SpawnPlacements.Type type, EntityType<?> entityType) {
        return false;
    }
}
