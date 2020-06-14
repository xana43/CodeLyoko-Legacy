package elsopeen.lyokomod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.RedstoneLampBlock;

/**
 * Tower body block for all towers on LYOKO
 */
public class TowerBodyBlock extends HorizontalBlock {

    private static final VoxelShape VISUAL_SHAPE = Block.makeCuboidShape(0.0,0.0,0.0,16.0,16.0,16.0);

    private static final VoxelShape COLLISION_SHAPE = Block.makeCuboidShape(0.0,0.0,0.0,16.0,16.0,16.0);

    /**
     * Constructor with default orientation (NORTH)
     * @param builder default properties passed to super
     */
    public TowerBodyBlock(Properties builder) {
        super(builder);
        this.setDefaultState(this.getDefaultState().with(HORIZONTAL_FACING, Direction.NORTH));
    }

    /**
     * Function to add parameters to the blockState
     * @param builder add the HORIZONTAL_FACING BlockState.Property to our block
     */
    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING);
    }

    /**
     * Function used to "rotate" block on placement
     * @param context Context of placement
     * @return BlockState
     */
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing());
    }

    /**
     * Function used to "rotate" block on command setblock
     * @param state BlockState on block update
     * @param rot Current orientation of block
     * @return
     */
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(HORIZONTAL_FACING, rot.rotate(state.get(HORIZONTAL_FACING)));
    }

    @Override
    public int getLightValue(BlockState state) {
        return 15;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        VoxelShape voxelshape = VISUAL_SHAPE;
        Vec3d vec3d = state.getOffset(worldIn, pos);
        return voxelshape.withOffset(vec3d.x, vec3d.y, vec3d.z);
    }

    /**
     * Function to tell if block is transparent of not
     * @param state blockState on block update
     * @param reader
     * @param pos
     * @return that light can go through
     */
    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
        return true;
    }

    /**
     * Don't know what that thing does
     * Kinda hoped its name was true, but no
     * @param state
     * @param worldIn
     * @param pos
     * @param type
     * @return that the block allows movement
     */
    @Override
    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return false;
    }

    /**
     * Returns collision hitbox
     * @param state
     * @param worldIn
     * @param pos
     * @param context
     * @return a hitbox
     */
    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Vec3d vec3d = state.getOffset(worldIn, pos);
        return COLLISION_SHAPE.withOffset(vec3d.x, vec3d.y, vec3d.z);
    }
}
