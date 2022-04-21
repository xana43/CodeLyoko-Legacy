package com.Ultra_Nerd.CodeLyokoLegacy.blocks.tower;

import com.Ultra_Nerd.CodeLyokoLegacy.containers.TowerInterfaceContainer;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModSounds;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.tileentity.TowerInterfaceTileEntity;
import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.predicate.block.BlockStatePredicate;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.World;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;
import java.util.function.Function;

public final class TowerInterface extends Block implements BlockEntityProvider {

    public static final DirectionProperty DIRINTERFACE = HorizontalFacingBlock.FACING;
    private static final VoxelShape SHAPE_N = Block.box(1, 1, 9, 15, 15, 9.1);
    private static final VoxelShape SHAPE_S = Block.box(1, 1, 9, 15, 15, 9.1);
    private static final VoxelShape SHAPE_E = Block.box(9, 1, 1, 9.1, 15, 15);
    private static final VoxelShape SHAPE_W = Block.box(9, 1, 1, 9.1, 15, 15);



    public TowerInterface() {
        super(FabricBlockSettings.of(Material.BARRIER).strength(-1,-1).sounds(BlockSoundGroup.AMETHYST_CLUSTER)
        );
        this.registerDefaultState(this.defaultBlockState().setValue(DIRINTERFACE, Direction.NORTH));


    }


    @Override
    public VoxelShape getCollisionShape(final BlockState state, final BlockGetter pLevel, final BlockPos pPos, final CollisionContext pContext) {
        return switch (state.getValue(DIRINTERFACE)) {
            case NORTH -> SHAPE_N;
            case SOUTH -> SHAPE_S;
            case EAST -> SHAPE_E;
            case WEST -> SHAPE_W;
            default -> SHAPE_N;
        };
    }

    @Override
    public @NotNull VoxelShape getVisualShape(@NotNull BlockState state, @NotNull BlockGetter p_60480_, @NotNull BlockPos p_60481_, @NotNull CollisionContext p_60482_) {
        return switch (state.getValue(DIRINTERFACE)) {
            case NORTH -> SHAPE_N;
            case SOUTH -> SHAPE_S;
            case EAST -> SHAPE_E;
            case WEST -> SHAPE_W;
            default -> SHAPE_N;
        };
    }

    @Override
    public BlockRenderType getRenderType(final BlockState state) {
        return BlockRenderType.MODEL;
    }



    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return 5;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {

        builder.add(DIRINTERFACE);
    }

    @Override
    public boolean isValidSpawn(BlockState state, BlockGetter level, BlockPos pos, SpawnPlacements.Type type, EntityType<?> entityType) {
        return false;
    }


    @Override
    protected ImmutableMap<BlockState, VoxelShape> getShapesForStates(final Function<BlockState, VoxelShape> stateToShape) {
        switch (this.stateManager.getDefaultState().get(DIRINTERFACE))
        {
            case NORTH -> ImmutableMap.builder().put(this.stateManager.getDefaultState(),SHAPE_N).build();
            case SOUTH -> ImmutableMap.builder().put(this.stateManager.getDefaultState(),SHAPE_S).build();
            case EAST ->  ImmutableMap.builder().put(this.stateManager.getDefaultState(),SHAPE_E).build();
            case WEST ->  ImmutableMap.builder().put(this.stateManager.getDefaultState(),SHAPE_W).build();
        }


        return super.getShapesForStates(stateToShape);
    }



    @org.jetbrains.annotations.Nullable
    @Override
    public BlockState getPlacementState(final ItemPlacementContext ctx) {
        return Objects.requireNonNull(super.getPlacementState(ctx)).with(DIRINTERFACE,ctx.getPlayerFacing().getOpposite());
    }









    //


    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, BlockState state) {
        return ModTileEntities.TOWER_INTERFACE_TILE_ENTITY.get().create(pos, state);
    }

    /*@Override
    public ActionResult onUse(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final Hand hand, final BlockHitResult hit) {
        if(!world.isClient()) {
            final BlockEntity Tower = world.getBlockEntity(pos);
            if (Tower instanceof TowerInterfaceTileEntity) {
                Menu thisMenuProvider = new MenuProvider() {
                    @Override
                    public @NotNull Component getDisplayName() {
                        return new TranslatableComponent("screen.tower.gui");
                    }

                    @Override
                    public @NotNull AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory, @NotNull Player player1) {
                        return new TowerInterfaceContainer(id, pos, inventory, player1);
                    }
                };
                NetworkHooks.openGui((ServerPlayer) player, thisMenuProvider, Tower.getBlockPos());

            } else {
                throw new IllegalStateException("out provider isn't here");
            }
        }
        player.playSound(ModSounds.OPENTOWERGUISOUND.get(), 1,1);
        return InteractionResult.SUCCESS;
    }

    @Nonnull
    @Override
    public InteractionResult use(@Nonnull BlockState state, @NotNull Level worldIn, @Nonnull BlockPos pos, @Nonnull Player player,
                                 @Nonnull InteractionHand handIn, @Nonnull BlockHitResult result)
    {

    }


    @org.jetbrains.annotations.Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return null;
    }

     */
}
