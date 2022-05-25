package com.Ultra_Nerd.CodeLyokoLegacy.blocks.SuperCalculator;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.tileentity.ComputerControlPanelTileEntity;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerLoginNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.impl.networking.server.ServerPlayNetworkAddon;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ServerPlayPacketListener;
import net.minecraft.network.packet.s2c.play.CustomPayloadS2CPacket;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ServerNetworkIo;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

public final class ControlPanel extends BlockWithEntity {


    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return ModTileEntities.COMPUTER_CONTROL_PANEL.instantiate(pos, state);
    }

    public static final DirectionProperty PANEL = HorizontalFacingBlock.FACING;
    public static final BooleanProperty ScreenOn = BooleanProperty.of("screen_on");
    private static final VoxelShape shapeN = Stream.of(
            Block.createCuboidShape(0.09999999999999964, -4, 2.2226819720551028, 1.1000000000000014, 0.025, 3.2226819720551028),
            Block.createCuboidShape(0.09999999999999964, 6.598148784203678, 12.919292458096445, 15.125000000000002, 7.548148784203677, 21.919292458096443),
            Block.createCuboidShape(0.07500000000000107, 6.59814878420368, 12.085408981613261, 16.1, 7.548148784203679, 12.935408981613262),
            Block.createCuboidShape(0.09999999999999964, 6.5908264537333405, 21.91116023151728, 16.1, 7.540826453733343, 22.811160231517285),
            Block.createCuboidShape(-0.9000000000000004, 6.593826453733341, 12.093519544397996, 0.09999999999999964, 7.551826453733339, 22.818519544397994),
            Block.createCuboidShape(15.100000000000001, 6.593826453733341, 12.093519544397996, 16.1, 7.551826453733339, 22.818519544397994),
            Block.createCuboidShape(6.100000000000001, 5.8410420030171295, 12.212185676909897, 10.100000000000001, 6.8410420030171295, 18.212185676909897),
            Block.createCuboidShape(6.100000000000001, 1, 12.222681972055103, 10.100000000000001, 11, 13.222681972055103),
            Block.createCuboidShape(5.100000000000001, 0, 12.222681972055103, 11.100000000000001, 1, 13.222681972055103),
            Block.createCuboidShape(11.100000000000001, -4, 11.222681972055103, 12.100000000000001, 0.9, 12.222681972055103),
            Block.createCuboidShape(4.100000000000001, -4, 11.222681972055103, 5.100000000000001, 0.9, 12.222681972055103),
            Block.createCuboidShape(12.100000000000001, 0, 10.222681972055103, 13.100000000000001, 0.8, 11.222681972055103),
            Block.createCuboidShape(2.1000000000000014, -4, 10.222681972055103, 3.1000000000000014, 0.7, 11.222681972055103),
            Block.createCuboidShape(13.100000000000001, -4, 10.222681972055103, 14.100000000000001, 0.7, 11.222681972055103),
            Block.createCuboidShape(3.1000000000000014, 0, 10.222681972055103, 4.100000000000001, 0.8, 11.222681972055103),
            Block.createCuboidShape(13.100000000000001, 0, 9.222681972055103, 14.100000000000001, 0.6, 10.222681972055103),
            Block.createCuboidShape(2.1000000000000014, 0, 9.222681972055103, 3.1000000000000014, 0.6, 10.222681972055103),
            Block.createCuboidShape(14.100000000000001, 0, 8.222681972055103, 15.100000000000001, 0.5, 9.222681972055103),
            Block.createCuboidShape(1.1000000000000014, 0, 8.222681972055103, 2.1000000000000014, 0.5, 9.222681972055103),
            Block.createCuboidShape(15.100000000000001, 0, 7.222681972055103, 16.1, 0.4, 8.222681972055103),
            Block.createCuboidShape(15.100000000000001, 0, 6.222681972055103, 16.1, 0.3, 7.222681972055103),
            Block.createCuboidShape(15.100000000000001, -5, 5.222681972055103, 16.1, 0.2, 6.222681972055103),
            Block.createCuboidShape(15.100000000000001, 0, 4.222681972055103, 16.1, 0.1, 5.222681972055103),
            Block.createCuboidShape(15.100000000000001, 0, 3.2226819720551028, 16.1, 0.05, 4.222681972055103),
            Block.createCuboidShape(15.100000000000001, -4, 2.2226819720551028, 16.1, 0.025, 3.2226819720551028),
            Block.createCuboidShape(0.09999999999999964, 0, 7.222681972055103, 1.1000000000000014, 0.4, 8.222681972055103),
            Block.createCuboidShape(0.09999999999999964, 0, 6.222681972055103, 1.1000000000000014, 0.3, 7.222681972055103),
            Block.createCuboidShape(0.09999999999999964, -5, 5.222681972055103, 1.1000000000000014, 0.2, 6.222681972055103),
            Block.createCuboidShape(0.09999999999999964, 0, 4.222681972055103, 1.1000000000000014, 0.1, 5.222681972055103),
            Block.createCuboidShape(0.09999999999999964, 0, 3.2226819720551028, 1.1000000000000014, 0.05, 4.222681972055103)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape shapeS = Stream.of(
            Block.createCuboidShape(15, -4, 14, 16, 0.025, 15),
            Block.createCuboidShape(0.9749999999999996, 6.598148784203678, -4.69661048604134, 16, 7.548148784203677, 4.303389513958658),
            Block.createCuboidShape(-1.7763568394002505e-15, 6.59814878420368, 4.28727299044184, 16.025, 7.548148784203679, 5.137272990441842),
            Block.createCuboidShape(-1.7763568394002505e-15, 6.5908264537333405, -5.588478259462182, 16, 7.540826453733343, -4.688478259462176),
            Block.createCuboidShape(16, 6.593826453733341, -5.595837572342891, 17, 7.551826453733339, 5.129162427657107),
            Block.createCuboidShape(-1.7763568394002505e-15, 6.593826453733341, -5.595837572342891, 1, 7.551826453733339, 5.129162427657107),
            Block.createCuboidShape(6, 5.8410420030171295, -0.9895037048547941, 10, 6.8410420030171295, 5.010496295145206),
            Block.createCuboidShape(6, 1, 4, 10, 11, 5),
            Block.createCuboidShape(5, 0, 4, 11, 1, 5),
            Block.createCuboidShape(4, -4, 5, 5, 0.9, 6),
            Block.createCuboidShape(11, -4, 5, 12, 0.9, 6),
            Block.createCuboidShape(3, 0, 6, 4, 0.8, 7),
            Block.createCuboidShape(13, -4, 6, 14, 0.7, 7),
            Block.createCuboidShape(2, -4, 6, 3, 0.7, 7),
            Block.createCuboidShape(12, 0, 6, 13, 0.8, 7),
            Block.createCuboidShape(2, 0, 7, 3, 0.6, 8),
            Block.createCuboidShape(13, 0, 7, 14, 0.6, 8),
            Block.createCuboidShape(1, 0, 8, 2, 0.5, 9),
            Block.createCuboidShape(14, 0, 8, 15, 0.5, 9),
            Block.createCuboidShape(-1.7763568394002505e-15, 0, 9, 1, 0.4, 10),
            Block.createCuboidShape(-1.7763568394002505e-15, 0, 10, 1, 0.3, 11),
            Block.createCuboidShape(-1.7763568394002505e-15, -5, 11, 1, 0.2, 12),
            Block.createCuboidShape(-1.7763568394002505e-15, 0, 12, 1, 0.1, 13),
            Block.createCuboidShape(-1.7763568394002505e-15, 0, 13, 1, 0.05, 14),
            Block.createCuboidShape(-1.7763568394002505e-15, -4, 14, 1, 0.025, 15),
            Block.createCuboidShape(15, 0, 9, 16, 0.4, 10),
            Block.createCuboidShape(15, 0, 10, 16, 0.3, 11),
            Block.createCuboidShape(15, -5, 11, 16, 0.2, 12),
            Block.createCuboidShape(15, 0, 12, 16, 0.1, 13),
            Block.createCuboidShape(15, 0, 13, 16, 0.05, 14)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape shapeE = Stream.of(
            Block.createCuboidShape(13.43865901397245, -4, 0.6613409860275503, 14.43865901397245, 0.025, 1.661340986027552),
            Block.createCuboidShape(-5.257951472068891, 6.598148784203678, 0.6613409860275503, 3.7420485279311073, 7.548148784203677, 15.686340986027552),
            Block.createCuboidShape(3.7259320044142896, 6.59814878420368, 0.6363409860275517, 4.575932004414291, 7.548148784203679, 16.661340986027554),
            Block.createCuboidShape(-6.1498192454897325, 6.5908264537333405, 0.6613409860275503, -5.249819245489727, 7.540826453733343, 16.661340986027554),
            Block.createCuboidShape(-6.1571785583704415, 6.593826453733341, -0.3386590139724497, 4.567821441629556, 7.551826453733339, 0.6613409860275503),
            Block.createCuboidShape(-6.1571785583704415, 6.593826453733341, 15.661340986027552, 4.567821441629556, 7.551826453733339, 16.661340986027554),
            Block.createCuboidShape(-1.5508446908823448, 5.8410420030171295, 6.661340986027552, 4.449155309117655, 6.8410420030171295, 10.661340986027552),
            Block.createCuboidShape(3.4386590139724493, 1, 6.661340986027552, 4.438659013972449, 11, 10.661340986027552),
            Block.createCuboidShape(3.4386590139724493, 0, 5.661340986027552, 4.438659013972449, 1, 11.661340986027552),
            Block.createCuboidShape(4.438659013972449, -4, 11.661340986027552, 5.438659013972449, 0.9, 12.661340986027552),
            Block.createCuboidShape(4.438659013972449, -4, 4.661340986027552, 5.438659013972449, 0.9, 5.661340986027552),
            Block.createCuboidShape(5.438659013972449, 0, 12.661340986027552, 6.438659013972449, 0.8, 13.661340986027552),
            Block.createCuboidShape(5.438659013972449, -4, 2.661340986027552, 6.438659013972449, 0.7, 3.661340986027552),
            Block.createCuboidShape(5.438659013972449, -4, 13.661340986027552, 6.438659013972449, 0.7, 14.661340986027552),
            Block.createCuboidShape(5.438659013972449, 0, 3.661340986027552, 6.438659013972449, 0.8, 4.661340986027552),
            Block.createCuboidShape(6.438659013972449, 0, 13.661340986027552, 7.438659013972449, 0.6, 14.661340986027552),
            Block.createCuboidShape(6.438659013972449, 0, 2.661340986027552, 7.438659013972449, 0.6, 3.661340986027552),
            Block.createCuboidShape(7.438659013972449, 0, 14.661340986027552, 8.43865901397245, 0.5, 15.661340986027552),
            Block.createCuboidShape(7.438659013972449, 0, 1.661340986027552, 8.43865901397245, 0.5, 2.661340986027552),
            Block.createCuboidShape(8.43865901397245, 0, 15.661340986027552, 9.43865901397245, 0.4, 16.661340986027554),
            Block.createCuboidShape(9.43865901397245, 0, 15.661340986027552, 10.43865901397245, 0.3, 16.661340986027554),
            Block.createCuboidShape(10.43865901397245, -5, 15.661340986027552, 11.43865901397245, 0.2, 16.661340986027554),
            Block.createCuboidShape(11.43865901397245, 0, 15.661340986027552, 12.43865901397245, 0.1, 16.661340986027554),
            Block.createCuboidShape(12.43865901397245, 0, 15.661340986027552, 13.43865901397245, 0.05, 16.661340986027554),
            Block.createCuboidShape(13.43865901397245, -4, 15.661340986027552, 14.43865901397245, 0.025, 16.661340986027554),
            Block.createCuboidShape(8.43865901397245, 0, 0.6613409860275503, 9.43865901397245, 0.4, 1.661340986027552),
            Block.createCuboidShape(9.43865901397245, 0, 0.6613409860275503, 10.43865901397245, 0.3, 1.661340986027552),
            Block.createCuboidShape(10.43865901397245, -5, 0.6613409860275503, 11.43865901397245, 0.2, 1.661340986027552),
            Block.createCuboidShape(11.43865901397245, 0, 0.6613409860275503, 12.43865901397245, 0.1, 1.661340986027552),
            Block.createCuboidShape(12.43865901397245, 0, 0.6613409860275503, 13.43865901397245, 0.05, 1.661340986027552)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape shapeW = Stream.of(
            Block.createCuboidShape(1.661340986027552, -4, 15.56134098602755, 2.661340986027552, 0.025, 16.561340986027552),
            Block.createCuboidShape(12.357951472068894, 6.598148784203678, 1.5363409860275503, 21.35795147206889, 7.548148784203677, 16.561340986027552),
            Block.createCuboidShape(11.52406799558571, 6.59814878420368, 0.5613409860275489, 12.374067995585712, 7.548148784203679, 16.58634098602755),
            Block.createCuboidShape(21.349819245489726, 6.5908264537333405, 0.5613409860275489, 22.249819245489732, 7.540826453733343, 16.561340986027552),
            Block.createCuboidShape(11.532178558370445, 6.593826453733341, 16.561340986027552, 22.25717855837044, 7.551826453733339, 17.561340986027552),
            Block.createCuboidShape(11.532178558370445, 6.593826453733341, 0.5613409860275489, 22.25717855837044, 7.551826453733339, 1.5613409860275507),
            Block.createCuboidShape(11.650844690882346, 5.8410420030171295, 6.561340986027551, 17.650844690882344, 6.8410420030171295, 10.56134098602755),
            Block.createCuboidShape(11.661340986027552, 1, 6.561340986027551, 12.661340986027552, 11, 10.56134098602755),
            Block.createCuboidShape(11.661340986027552, 0, 5.561340986027551, 12.661340986027552, 1, 11.56134098602755),
            Block.createCuboidShape(10.661340986027552, -4, 4.561340986027551, 11.661340986027552, 0.9, 5.561340986027551),
            Block.createCuboidShape(10.661340986027552, -4, 11.56134098602755, 11.661340986027552, 0.9, 12.56134098602755),
            Block.createCuboidShape(9.661340986027552, 0, 3.5613409860275507, 10.661340986027552, 0.8, 4.561340986027551),
            Block.createCuboidShape(9.661340986027552, -4, 13.56134098602755, 10.661340986027552, 0.7, 14.56134098602755),
            Block.createCuboidShape(9.661340986027552, -4, 2.5613409860275507, 10.661340986027552, 0.7, 3.5613409860275507),
            Block.createCuboidShape(9.661340986027552, 0, 12.56134098602755, 10.661340986027552, 0.8, 13.56134098602755),
            Block.createCuboidShape(8.661340986027552, 0, 2.5613409860275507, 9.661340986027552, 0.6, 3.5613409860275507),
            Block.createCuboidShape(8.661340986027552, 0, 13.56134098602755, 9.661340986027552, 0.6, 14.56134098602755),
            Block.createCuboidShape(7.661340986027552, 0, 1.5613409860275507, 8.661340986027552, 0.5, 2.5613409860275507),
            Block.createCuboidShape(7.661340986027552, 0, 14.56134098602755, 8.661340986027552, 0.5, 15.56134098602755),
            Block.createCuboidShape(6.661340986027552, 0, 0.5613409860275489, 7.661340986027552, 0.4, 1.5613409860275507),
            Block.createCuboidShape(5.661340986027552, 0, 0.5613409860275489, 6.661340986027552, 0.3, 1.5613409860275507),
            Block.createCuboidShape(4.661340986027552, -5, 0.5613409860275489, 5.661340986027552, 0.2, 1.5613409860275507),
            Block.createCuboidShape(3.661340986027552, 0, 0.5613409860275489, 4.661340986027552, 0.1, 1.5613409860275507),
            Block.createCuboidShape(2.661340986027552, 0, 0.5613409860275489, 3.661340986027552, 0.05, 1.5613409860275507),
            Block.createCuboidShape(1.661340986027552, -4, 0.5613409860275489, 2.661340986027552, 0.025, 1.5613409860275507),
            Block.createCuboidShape(6.661340986027552, 0, 15.56134098602755, 7.661340986027552, 0.4, 16.561340986027552),
            Block.createCuboidShape(5.661340986027552, 0, 15.56134098602755, 6.661340986027552, 0.3, 16.561340986027552),
            Block.createCuboidShape(4.661340986027552, -5, 15.56134098602755, 5.661340986027552, 0.2, 16.561340986027552),
            Block.createCuboidShape(3.661340986027552, 0, 15.56134098602755, 4.661340986027552, 0.1, 16.561340986027552),
            Block.createCuboidShape(2.661340986027552, 0, 15.56134098602755, 3.661340986027552, 0.05, 16.561340986027552)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public ControlPanel() {
        super(FabricBlockSettings.of(Material.METAL)

                .strength(10, 10)
                .sounds(BlockSoundGroup.METAL)

        );
        this.setDefaultState(this.getDefaultState().with(PANEL, Direction.NORTH).with(ScreenOn, false));


    }




    @Override
    protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(PANEL).add(ScreenOn));
    }

    @Override
    public BlockRenderType getRenderType(final BlockState state) {
        return BlockRenderType.MODEL;
    }



    @Override
    public VoxelShape getOutlineShape(final BlockState state, final BlockView world, final BlockPos pos, final ShapeContext context) {
        return switch (state.get(PANEL)) {
            case NORTH -> shapeN;
            case SOUTH -> shapeS;
            case EAST -> shapeE;
            case WEST -> shapeW;
            default -> shapeN;
        };
    }



    @Nullable
    @Override
    public BlockState getPlacementState(final ItemPlacementContext ctx) {
        return this.getDefaultState().with(PANEL,ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public ActionResult onUse(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final Hand hand, final BlockHitResult hit) {
        if(!world.isClient)
        {
            final NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);
            if(screenHandlerFactory != null)
            {
                player.openHandledScreen(screenHandlerFactory);



            }


        }



        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(final World world, final BlockState state, final BlockEntityType<T> type) {

        return checkType(type,ModTileEntities.COMPUTER_CONTROL_PANEL,ComputerControlPanelTileEntity::tick);

    }

    @Override
    public void onBroken(final WorldAccess world, final BlockPos pos, final BlockState state) {
        super.onBroken(world, pos, state);
        if(world.getBlockEntity(pos) instanceof  ComputerControlPanelTileEntity tileEntity)
        {
            tileEntity.setActivebool(false);
            tileEntity.markRemoved();

        }
        ClientPlayNetworking.unregisterReceiver(CodeLyokoMain.COMPUTER_PANEL_TAG);
    }

    @Override
    public void onBreak(final World world, final BlockPos pos, final BlockState state, final PlayerEntity player) {
        if(world.getBlockEntity(pos) instanceof  ComputerControlPanelTileEntity tileEntity)
        {
            tileEntity.setActivebool(false);
            tileEntity.markRemoved();

        }
        ClientPlayNetworking.unregisterReceiver(CodeLyokoMain.COMPUTER_PANEL_TAG);

        super.onBreak(world, pos, state, player);
    }

    @Override
    public void onPlaced(final World world, final BlockPos pos, final BlockState state, @Nullable final LivingEntity placer, final ItemStack itemStack) {




        super.onPlaced(world, pos, state, placer, itemStack);
    }

    //




/*

    @Nonnull
    @Override
    public InteractionResult use(@Nonnull BlockState state, @NotNull Level worldIn, @Nonnull BlockPos pos, @Nonnull Player player,
                                 @Nonnull InteractionHand handIn, @Nonnull BlockHitResult result) {
        if (!worldIn.isClientSide) {
            //if (this.newBlockEntity(pos, state).getBlockState().getValue(ScreenOn)) {
                BlockEntity panel = worldIn.getBlockEntity(pos);
                if (panel instanceof ComputerControlPanelTileEntity) {

                    NetworkHooks.openGui((ServerPlayer) player, (MenuProvider) panel, panel.getBlockPos());
                    return InteractionResult.SUCCESS;
                }
           // }
        }
        return InteractionResult.SUCCESS;
    }

 */


}
