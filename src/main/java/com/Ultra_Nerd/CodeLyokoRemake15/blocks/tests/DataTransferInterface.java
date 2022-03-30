package com.Ultra_Nerd.CodeLyokoRemake15.blocks.tests;

import com.Ultra_Nerd.CodeLyokoRemake15.containers.DataTransferInterfaceContainer;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.test.DataTransferInterfaceTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class DataTransferInterface extends BaseEntityBlock {

    public DataTransferInterface() {
        super(Block.Properties.of(Material.METAL)

                .strength(-1, -1)
                .sound(SoundType.METAL));
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Nonnull
    @Override
    public InteractionResult use(@Nonnull BlockState state, Level worldIn, @Nonnull BlockPos pos, @Nonnull Player player,
                                 @Nonnull InteractionHand handIn, @Nonnull BlockHitResult result) {
        if (!worldIn.isClientSide) {
            BlockEntity Data = worldIn.getBlockEntity(pos);
            if (Data instanceof DataTransferInterfaceTileEntity) {
                MenuProvider thisMenuProvider = new MenuProvider() {
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
}
