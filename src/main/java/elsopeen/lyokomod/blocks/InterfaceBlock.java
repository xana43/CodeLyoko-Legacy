package elsopeen.lyokomod.blocks;

import elsopeen.lyokomod.client.gui.InterfaceScreen;
import elsopeen.lyokomod.init.ModTileEntityTypes;
import elsopeen.lyokomod.tileentity.InterfaceTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.network.NetworkHooks;


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
     * @param reader
     * @param pos
     * @return that light can go through
     */
    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
        return true;
    }

    /**
     * Visual hitbox (rotate depending on interface orientation)
     * @param state
     * @param worldIn
     * @param pos
     * @param context
     * @return a hitbox depending on orientation
     */
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        VoxelShape voxelshape = (state.get(HORIZONTAL_FACING)==Direction.NORTH || state.get(HORIZONTAL_FACING)==Direction.SOUTH) ?
                SHAPE_NORMAL_Z : SHAPE_NORMAL_X;
        Vec3d vec3d = state.getOffset(worldIn, pos);
        return voxelshape.withOffset(vec3d.x, vec3d.y, vec3d.z);
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
        return true;
    }

    /**
     * Returns collision hitbox, defined as 0 depth so you can walk through
     * @param state
     * @param worldIn
     * @param pos
     * @param context
     * @return a thin hitbox so people can go through
     */
    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Vec3d vec3d = state.getOffset(worldIn, pos);
        return SHAPE_COLLISION.withOffset(vec3d.x, vec3d.y, vec3d.z);
    }

    /**
     * Called when a player right clicks our block.
     * We use this method to open our gui.
     * @param state
     * @param world
     * @param pos
     * @param player
     * @param hand
     * @param hit
     * @return
     */
    @Override
    public ActionResultType func_225533_a_(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        if (!world.isRemote) {
            final TileEntity tileEntity = world.getTileEntity(pos);
            if (tileEntity instanceof InterfaceTileEntity) {
                NetworkHooks.openGui((ServerPlayerEntity) player, (InterfaceTileEntity) tileEntity, pos);
            }
        }
        return ActionResultType.SUCCESS;
    }

    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> () -> openGui(player, worldIn, pos));
        return true;
    }


    /**
     * @OnlyIn(Dist.CLIENT) Makes it so this method will be removed from the class on the PHYSICAL SERVER
     * This is because we only want to handle opening the GUI on the physical client.
     *
     * Opens GUI for client
     * @param worldIn
     * @param pos
     */
    private void openGui(final PlayerEntity player, final World worldIn, final BlockPos pos) {
        // Only handle opening the Gui screen on the logical client
        if (worldIn.isRemote) {
            final TileEntity tileEntity = worldIn.getTileEntity(pos);
            if (tileEntity instanceof InterfaceTileEntity) {
                NetworkHooks.openGui((ServerPlayerEntity) player, (InterfaceTileEntity) tileEntity, pos);
            }
        }
    }
}

