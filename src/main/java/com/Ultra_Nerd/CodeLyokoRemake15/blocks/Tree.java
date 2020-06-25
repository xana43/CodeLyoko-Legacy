package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Tree extends Block {

    public Tree() {
        super(Block.Properties.create(Material.WOOD)
                .hardnessAndResistance(-1, -1)
                .sound(SoundType.WOOD)
        );
    }
}
