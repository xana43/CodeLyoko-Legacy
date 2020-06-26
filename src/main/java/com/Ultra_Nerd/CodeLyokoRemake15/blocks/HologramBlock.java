package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class HologramBlock extends Block {

    public static final DirectionProperty DIRHOLO = HorizontalBlock.HORIZONTAL_FACING;

    public HologramBlock()
    {
        super(Block.Properties.create(Material.ROCK)

                .hardnessAndResistance(-1, 10)
                .sound(SoundType.METAL)
                .lightValue(0)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
        );
        //this.setDefaultState(this.stateContainer.getBaseState().with(DIRHOLO, Direction.NORTH));
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        // TODO Auto-generated method stub
        return this.getDefaultState().with(DIRHOLO, context.getPlacementHorizontalFacing().getOpposite());
    }
    //mod compatiability
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(DIRHOLO,rot.rotate(state.get(DIRHOLO)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(DIRHOLO)));
    }
    //

    @Override
    public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean isTransparent(BlockState state) {
        // TODO Auto-generated method stub
        return true;
    }
}
