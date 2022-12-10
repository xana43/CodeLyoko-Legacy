package com.Ultra_Nerd.CodeLyokoLegacy.blocks.tower;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public final class TowerInterface extends BlockWithEntity {

    public static final DirectionProperty DIRINTERFACE = HorizontalFacingBlock.FACING;
    private static final VoxelShape SHAPE_N = Block.createCuboidShape(1, 1, 9, 15, 15, 9.1);
    private static final VoxelShape SHAPE_S = Block.createCuboidShape(1, 1, 9, 15, 15, 9.1);
    private static final VoxelShape SHAPE_E = Block.createCuboidShape(9, 1, 1, 9.1, 15, 15);
    private static final VoxelShape SHAPE_W = Block.createCuboidShape(9, 1, 1, 9.1, 15, 15);

    @Override
    public VoxelShape getOutlineShape(final BlockState state, final BlockView world, final BlockPos pos, final ShapeContext context) {
        return switch (state.get(DIRINTERFACE)) {
            case SOUTH -> SHAPE_S;
            case EAST -> SHAPE_E;
            case WEST -> SHAPE_W;
            default -> SHAPE_N;
        };
    }

    public TowerInterface() {
        super(FabricBlockSettings.of(Material.BARRIER).strength(-1, -1).sounds(BlockSoundGroup.AMETHYST_CLUSTER).luminance(80));
        this.setDefaultState(this.getStateManager().getDefaultState().with(DIRINTERFACE, Direction.NORTH));
    }

    @Override
    protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(DIRINTERFACE));
    }

    @Override
    public BlockRenderType getRenderType(final BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(final ItemPlacementContext ctx) {
        return this.getDefaultState().with(DIRINTERFACE, ctx.getPlayerFacing().getOpposite());
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return ModTileEntities.TOWER_INTERFACE_TILE_ENTITY.instantiate(pos, state);
    }

    @Override
    public ActionResult onUse(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final Hand hand, final BlockHitResult hit) {
        if (!world.isClient) {
            final NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);
            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
        }
        return ActionResult.SUCCESS;
    }


}
