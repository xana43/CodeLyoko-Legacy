package com.Ultra_Nerd.CodeLyokoRemake15.blocks.tests;

import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.test.DataTransferInterfaceTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class DataTransferInterface extends BaseEntityBlock {

    public DataTransferInterface() {
        super(Block.Properties.of(Material.METAL)

                .strength(-1, -1)
                .sound(SoundType.METAL));
    }

    public DataTransferInterface(Properties properties) {
        super(properties);
    }



    @Nonnull
    @Override
    public InteractionResult use(@Nonnull BlockState state, @Nonnull Level worldIn, @Nonnull BlockPos pos,
                                 @Nonnull Player player, @Nonnull InteractionHand handIn, @Nonnull BlockHitResult hit) {
        if (worldIn.isClientSide) {
            BlockEntity dataTransfInterface = worldIn.getBlockEntity(pos);
            if (dataTransfInterface instanceof DataTransferInterfaceTileEntity) {
                NetworkHooks.openGui((ServerPlayer) player, (DataTransferInterfaceTileEntity) dataTransfInterface, pos);
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.FAIL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return null; //ModTileEntities.DATA_TRANSFER_INTERFACE_TILE_ENTITY.get().create(pos, state);
    }
}
