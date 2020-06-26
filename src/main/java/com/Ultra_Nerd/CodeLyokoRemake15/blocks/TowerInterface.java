package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class TowerInterface extends HorizontalBlock {

    public static final DirectionProperty DIRINTERFACE = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Block.makeCuboidShape(1, 9, 3, 15, 9.1, 12);
    private static  final VoxelShape SHAPE_S = Block.makeCuboidShape(1, 9, 3, 15, 9.1, 12);
    private static  final VoxelShape SHAPE_E = Block.makeCuboidShape(4, 9, 1, 13, 9.1, 15);
    private static  final  VoxelShape SHAPE_W = Block.makeCuboidShape(4, 9, 1, 13, 9.1, 15);


    public TowerInterface()
    {
        super(Block.Properties.create(Material.ROCK)

                .hardnessAndResistance(-1, 10)
                .sound(SoundType.METAL)
                .lightValue(0)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
        );
        this.setDefaultState(this.stateContainer.getBaseState().with(DIRINTERFACE, Direction.NORTH));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(DIRINTERFACE);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.get(DIRINTERFACE))
        {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return  SHAPE_E;
            case WEST:
                return SHAPE_W;
            default:
                return  SHAPE_N;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        // TODO Auto-generated method stub
        return this.getDefaultState().with(DIRINTERFACE, context.getPlacementHorizontalFacing().getOpposite());
    }

    //mod compatiability
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(DIRINTERFACE,rot.rotate(state.get(DIRINTERFACE)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(DIRINTERFACE)));
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
