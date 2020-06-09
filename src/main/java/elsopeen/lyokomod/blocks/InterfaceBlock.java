package elsopeen.lyokomod.blocks;

import elsopeen.lyokomod.client.gui.InterfaceScreen;
import elsopeen.lyokomod.init.ModTileEntityTypes;
import elsopeen.lyokomod.tileentity.InterfaceTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BambooLeaves;
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

public class InterfaceBlock extends HorizontalBlock {
    protected static final VoxelShape SHAPE_NORMAL = Block.makeCuboidShape(0.0D, 2.0D, 8.0D, 16.0D, 14.0D, 9.0D);
    protected static final VoxelShape SHAPE_COLLISION = Block.makeCuboidShape(0.0D, 2.0D, 8.D, 16.D, 14.0D, 8.D);

    public InterfaceBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.getDefaultState().with(HORIZONTAL_FACING, Direction.NORTH));
    }

    /*@Override
    public boolean hasTileEntity(final BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(final BlockState state, final IBlockReader world) {
        return ModTileEntityTypes.INTERFACE.get().create();
    }*/

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing());
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING);
    }

    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
        return true;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        VoxelShape voxelshape = SHAPE_NORMAL;
        Vec3d vec3d = state.getOffset(worldIn, pos);
        return voxelshape.withOffset(vec3d.x, vec3d.y, vec3d.z);
    }

    @Override
    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return true;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Vec3d vec3d = state.getOffset(worldIn, pos);
        return SHAPE_COLLISION.withOffset(vec3d.x, vec3d.y, vec3d.z);
    }

    /**
     * Called when a player right clicks our block.
     * We use this method to open our gui.
     *
     * @deprecated Call via {@link BlockState#onBlockActivated(World, PlayerEntity, Hand, BlockRayTraceResult)} whenever possible.
     * Implementing/overriding is fine.
     */
    //@Override
    public ActionResultType onBlockActivated(final BlockState state, final World worldIn, final BlockPos pos, final PlayerEntity player, final Hand handIn, final BlockRayTraceResult hit) {
        // Only open the gui on the physical client
        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> openGui(worldIn, pos));
        return ActionResultType.SUCCESS;
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(HORIZONTAL_FACING, rot.rotate(state.get(HORIZONTAL_FACING)));
    }

    // @OnlyIn(Dist.CLIENT) Makes it so this method will be removed from the class on the PHYSICAL SERVER
    // This is because we only want to handle opening the GUI on the physical client.
    @OnlyIn(Dist.CLIENT)
    private void openGui(final World worldIn, final BlockPos pos) {
        // Only handle opening the Gui screen on the logical client
        if (worldIn.isRemote) {
            final TileEntity tileEntity = worldIn.getTileEntity(pos);
            if (tileEntity instanceof InterfaceTileEntity) {
                Minecraft.getInstance().displayGuiScreen(new InterfaceScreen(((InterfaceTileEntity) tileEntity)));
            }
        }
    }
}

