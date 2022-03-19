package com.Ultra_Nerd.CodeLyokoRemake15.blocks.tests;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.test.DataTransferInterfaceTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nonnull;

public class DataTransferInterface extends Block {

    public DataTransferInterface() {
        super(Block.Properties.create(Material.ROCK)

                .hardnessAndResistance(-1, -1)
                .sound(SoundType.METAL)
                .lightValue(5));
    }

    public DataTransferInterface(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasTileEntity(BlockState blockState) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.DATA_TRANSFER_INTERFACE_TILE_ENTITY.get().create();
    }

    @Nonnull
    @Override
    public ActionResultType onBlockActivated(@Nonnull BlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos,
                                             @Nonnull PlayerEntity player, @Nonnull Hand handIn, @Nonnull BlockRayTraceResult hit) {
        if (!worldIn.isRemote) {
            TileEntity dataTransfInterface = worldIn.getTileEntity(pos);
            if (dataTransfInterface instanceof DataTransferInterfaceTileEntity) {
                NetworkHooks.openGui((ServerPlayerEntity) player, (DataTransferInterfaceTileEntity) dataTransfInterface, pos);
                return ActionResultType.SUCCESS;
            }
        }

        return ActionResultType.FAIL;
    }
}
