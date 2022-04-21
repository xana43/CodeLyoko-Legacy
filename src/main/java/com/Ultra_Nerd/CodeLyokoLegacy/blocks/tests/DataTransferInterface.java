package com.Ultra_Nerd.CodeLyokoLegacy.blocks.tests;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public final class DataTransferInterface extends Block implements BlockEntityProvider {
    public DataTransferInterface(final Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return null;
    }
/*
    public DataTransferInterface() {
        super(Block.Properties.of(Material.METAL)

                .strength(-1, -1)
                .sound(SoundType.METAL));
    }

    @Override
    public @NotNull RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Nonnull
    @Override
    public InteractionResult use(@Nonnull BlockState state, @NotNull Level worldIn, @Nonnull BlockPos pos, @Nonnull Player player,
                                 @Nonnull InteractionHand handIn, @Nonnull BlockHitResult result) {
        if (!worldIn.isClientSide) {
            final BlockEntity Data = worldIn.getBlockEntity(pos);
            if (Data instanceof DataTransferInterfaceTileEntity) {
                final MenuProvider thisMenuProvider = new MenuProvider() {
                    @Override
                    public @NotNull Component getDisplayName() {
                        return new TranslatableComponent("screen.transfer.gui");
                    }

                    @Override
                    public @NotNull AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory, @NotNull Player player1) {
                        return new DataTransferInterfaceContainer(id,pos,inventory, player1);
                    }
                };
                NetworkHooks.openGui((ServerPlayer) player, thisMenuProvider, Data.getBlockPos());

            }
            else
            {
                throw new IllegalStateException("out provider isn't here");
            }

        }
        return InteractionResult.SUCCESS;
    }


    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return ModTileEntities.DATA_TRANSFER_INTERFACE_TILE_ENTITY.get().create(pos, state);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return null;
    }

 */
}
