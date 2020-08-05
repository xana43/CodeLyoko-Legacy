package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Scanner extends Block {
    public static BooleanProperty Scanner = BooleanProperty.create("scanner_formed");

    public Scanner() {
        super(Block.Properties.create(Material.ROCK)

                .hardnessAndResistance(10, 10)
                .sound(SoundType.METAL)
                .lightValue(0)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
        );
        this.setDefaultState(this.getDefaultState().with(Scanner,false));
    }


    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(Scanner);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.SCANNER_TILE_ENTITY.get().create();
    }

    @Override
    public boolean isNormalCube(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos) {
        return false;
    }

    @Override
    public boolean isSideInvisible(@Nonnull BlockState state, @Nonnull BlockState adjacentBlockState, @Nonnull Direction side) {
        return false;
    }

    @Override
    public boolean isTransparent(@Nonnull BlockState state) {
        return false;
    }
}
