package com.Ultra_Nerd.CodeLyokoLegacy.blocks.tests;

import com.Ultra_Nerd.CodeLyokoLegacy.containers.DataTransferInterfaceContainer;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTileEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.tileentity.test.DataTransferInterfaceTileEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public final class DataTransferInterface extends BlockWithEntity {
    public DataTransferInterface(final Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return null;
    }

    public DataTransferInterface() {
        super(FabricBlockSettings.of(Material.METAL)

                .strength(-1, -1)
                .sounds(BlockSoundGroup.METAL));
    }

    @Override
    public BlockRenderType getRenderType(final BlockState state) {
        return BlockRenderType.MODEL;
    }


/*
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
