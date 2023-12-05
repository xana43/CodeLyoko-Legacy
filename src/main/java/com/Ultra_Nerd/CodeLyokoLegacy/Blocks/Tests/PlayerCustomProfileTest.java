package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Tests;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.common.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public final class PlayerCustomProfileTest extends BlockWithEntity {
    public PlayerCustomProfileTest(final Settings settings) {
        super(settings);
    }

    @Override
    public BlockRenderType getRenderType(final BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public ActionResult onUse(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final Hand hand, final BlockHitResult hit) {



        final NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);
        if(!world.isClient() && screenHandlerFactory != null) {
            player.openHandledScreen(screenHandlerFactory);
            CardinalData.PlayerSavedProfile.saveProfile(world.getLevelProperties(),(ServerPlayerEntity) player);
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }


    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return ModBlockEntities.PLAYER_DATA_STORAGE_BLOCK_ENTITY_TYPE.instantiate(pos, state);
    }
}
