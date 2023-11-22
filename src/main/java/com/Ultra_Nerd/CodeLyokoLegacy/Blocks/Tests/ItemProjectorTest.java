package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Tests;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.test.ItemProjectorTestBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModBlockEntities;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public final class ItemProjectorTest extends Block implements BlockEntityProvider {

    public ItemProjectorTest() {
        super(FabricBlockSettings.copyOf(Blocks.BARRIER));
    }



    @Override
    public ActionResult onUse(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final Hand hand, final BlockHitResult hit) {
        if(!world.isClient()) {
            final BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof ItemProjectorTestBlockEntity) {
                player.openHandledScreen((NamedScreenHandlerFactory) blockEntity);

            }
        }
        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public NamedScreenHandlerFactory createScreenHandlerFactory(final BlockState state, final World world, final BlockPos pos) {
        final BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity instanceof NamedScreenHandlerFactory ? (NamedScreenHandlerFactory)blockEntity : null;
    }
    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return ModBlockEntities.ITEM_PROJECTOR_TEST_BLOCK_ENTITY.instantiate(pos,state);
    }
}
