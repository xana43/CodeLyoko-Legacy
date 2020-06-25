package io.github.elsopeen.lyokomod.blocks;

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

import javax.annotation.Nonnull;

public class TowerPlatformStraightBlock extends HorizontalBlock {
    private static final VoxelShape VISUAL_SHAPE = Block.makeCuboidShape(0.0,0.0,0.0,16.0,16.0,16.0);

    private static final VoxelShape COLLISION_SHAPE = Block.makeCuboidShape(0.0,0.0,0.0,16.0,16.0,16.0);

    /**
     * Constructor with default orientation (NORTH)
     * @param builder default properties passed to super
     */
    public TowerPlatformStraightBlock(Block.Properties builder) {
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
     * @return new rotated state
     */
    @Nonnull
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(HORIZONTAL_FACING, rot.rotate(state.get(HORIZONTAL_FACING)));
    }

    @Override
    public int getLightValue(@Nonnull BlockState state) {
        return 15;
    }

    @Nonnull
    @Override
    public VoxelShape getShape(BlockState state, @Nonnull IBlockReader worldIn,
                               @Nonnull BlockPos pos, @Nonnull ISelectionContext context) {
        Vec3d vec3d = state.getOffset(worldIn, pos);
        return VISUAL_SHAPE.withOffset(vec3d.x, vec3d.y, vec3d.z);
    }

    /**
     * Function to tell if block is transparent of not
     * @param state blockState on block update
     * @param reader block reader
     * @param pos position of current block
     * @return that light can go through
     */
    public boolean propagatesSkylightDown(@Nonnull BlockState state,
                                          @Nonnull IBlockReader reader,
                                          @Nonnull BlockPos pos) {
        return true;
    }

    /**
     * Don't know what that thing does
     * Kinda hoped its name was true, but no
     * @param state current state of block
     * @param worldIn world in which the block is
     * @param pos position of block
     * @param type type of path
     * @return that the block allows movement
     */
    @Override
    public boolean allowsMovement(@Nonnull BlockState state,
                                  @Nonnull IBlockReader worldIn,
                                  @Nonnull BlockPos pos, @Nonnull PathType type) {
        return false;
    }

    /**
     * Returns collision hitbox
     * @param state current state of block
     * @param worldIn world in which the block is
     * @param pos current position of block
     * @param context context of usage
     * @return a hitbox
     */
    @Nonnull
    @Override
    public VoxelShape getCollisionShape(BlockState state,
                                        @Nonnull IBlockReader worldIn,
                                        @Nonnull BlockPos pos, @Nonnull ISelectionContext context) {
        Vec3d vec3d = state.getOffset(worldIn, pos);
        return COLLISION_SHAPE.withOffset(vec3d.x, vec3d.y, vec3d.z);
    }
}
