package io.github.elsopeen.lyokomod.blocks;

import io.github.elsopeen.lyokomod.init.ModTileEntityTypes;
import io.github.elsopeen.lyokomod.tileentity.InterfaceTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nonnull;


/**
 * Interface Block for tower or 5th territory interfaces
 */
public class InterfaceBlock extends HorizontalBlock {
    protected static final VoxelShape SHAPE_NORMAL_Z = Block.makeCuboidShape(0.0D, 2.0D, 8.0D, 16.0D, 14.0D, 9.0D);
    protected static final VoxelShape SHAPE_NORMAL_X = Block.makeCuboidShape(8.0D, 2.0D, 0.0D, 9.0D, 14.0D, 16.0D);
    protected static final VoxelShape SHAPE_COLLISION = Block.makeCuboidShape(0.0D, 2.0D, 8.D, 16.D, 14.0D, 8.D);

    /**
     * Constructor with default orientation (NORTH)
     * @param properties default properties passed to super
     */
    public InterfaceBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.getDefaultState().with(HORIZONTAL_FACING, Direction.NORTH));
    }

    /**
     * Checks if the block has/is a tile entity
     * @param state BlockState when update
     * @return boolean
     */
    @Override
    public boolean hasTileEntity(final BlockState state) {
        return true;
    }

    /**
     * Create and returns an interface tile entity
     * @param state BlockState when block update
     * @param world world in which the block is
     * @return TileEntity (InterfaceTileEntity)
     */
    @Override
    public TileEntity createTileEntity(final BlockState state, final IBlockReader world) {
        return ModTileEntityTypes.INTERFACE.get().create();
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

    /*
     * Function used to "rotate" block on command setblock
     * @param state BlockState on block update
     * @param rot Current orientation of block
     * @return new rotated block state
     *
    @Nonnull
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(HORIZONTAL_FACING, rot.rotate(state.get(HORIZONTAL_FACING)));
    }*/

    /**
     * Function to add parameters to the blockState
     * @param builder add the HORIZONTAL_FACING BlockState.Property to our block
     */
    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING);
    }

    /**
     * Function to tell if block is transparent of not
     * @param state blockState on block update
     * @param reader block reader
     * @param pos pos of current block
     * @return that light can go through
     */
    public boolean propagatesSkylightDown(@Nonnull BlockState state, @Nonnull IBlockReader reader, @Nonnull BlockPos pos) {
        return true;
    }

    /**
     * Visual hitbox (rotate depending on interface orientation)
     * @param state state of current block
     * @param worldIn world in which the block is
     * @param pos pos of current block
     * @param context how was the block selected
     * @return a hitbox depending on orientation
     */
    @Nonnull
    @Override
    public VoxelShape getShape(BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos, @Nonnull ISelectionContext context) {
        VoxelShape voxelshape = (state.get(HORIZONTAL_FACING)==Direction.NORTH || state.get(HORIZONTAL_FACING)==Direction.SOUTH) ?
                SHAPE_NORMAL_Z : SHAPE_NORMAL_X;
        Vec3d vec3d = state.getOffset(worldIn, pos);
        return voxelshape.withOffset(vec3d.x, vec3d.y, vec3d.z);
    }

    /**
     * Don't know what that thing does
     * Kinda hoped its name was true, but no
     * @param state Current block state
     * @param worldIn world in which the block is
     * @param pos position of current block
     * @param type type of path
     * @return that the block allows movement
     */
    @Override
    public boolean allowsMovement(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos, @Nonnull PathType type) {
        return true;
    }

    /**
     * Returns collision hitbox, defined as 0 depth so you can walk through
     * @param state current state of block
     * @param worldIn world in which the block is
     * @param pos position of current block
     * @param context context of how the block is used
     * @return a thin hitbox so people can go through
     */
    @Nonnull
    @Override
    public VoxelShape getCollisionShape(BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos, @Nonnull ISelectionContext context) {
        Vec3d vec3d = state.getOffset(worldIn, pos);
        return SHAPE_COLLISION.withOffset(vec3d.x, vec3d.y, vec3d.z);
    }


    /**
     * Called when a player right clicks our block.
     * We use this method to open our gui.
     * @param state current state of block
     * @param world world in which the block is
     * @param pos position of current block
     * @param player player using the interface
     * @param hand hand using the interface
     * @param hit what kind of hit it was
     * @return returns the kind of action triggered
     */
    @Nonnull
    @Override
    public ActionResultType onBlockActivated(@Nonnull BlockState state, World world, @Nonnull BlockPos pos, @Nonnull PlayerEntity player, @Nonnull Hand hand, @Nonnull BlockRayTraceResult hit) {
        if (!world.isRemote) {
            final TileEntity tileEntity = world.getTileEntity(pos);
            if (tileEntity instanceof InterfaceTileEntity) {
                NetworkHooks.openGui((ServerPlayerEntity) player, (InterfaceTileEntity) tileEntity, pos);
            }
        }
        return ActionResultType.SUCCESS;
    }

    /*public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> () -> openGui(player, worldIn, pos));
        return true;
    }*/


    /*
     * @OnlyIn(Dist.CLIENT) Makes it so this method will be removed from the class on the PHYSICAL SERVER
     * This is because we only want to handle opening the GUI on the physical client.
     *
     * Opens GUI for client
     * @param worldIn world in which the block is
     * @param pos position of current block
     *
    private void openGui(final PlayerEntity player, final World worldIn, final BlockPos pos) {
        // Only handle opening the Gui screen on the logical client
        if (worldIn.isRemote) {
            final TileEntity tileEntity = worldIn.getTileEntity(pos);
            if (tileEntity instanceof InterfaceTileEntity) {
                NetworkHooks.openGui((ServerPlayerEntity) player, (InterfaceTileEntity) tileEntity, pos);
            }
        }
    }*/
}

