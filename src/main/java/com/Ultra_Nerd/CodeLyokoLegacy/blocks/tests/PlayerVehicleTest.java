package com.Ultra_Nerd.CodeLyokoLegacy.blocks.tests;

import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.PacketHandlerCommon;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.TestScreens.VehicleMaterializationTest;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PlayerVehicleTest extends BlockWithEntity {
    public PlayerVehicleTest(final Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final Hand hand, final BlockHitResult hit) {
        final NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);
        if(!world.isClient()) {
            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return ModBlockEntities.VEHICLE_BE_BLOCK_ENTITY_TYPE.instantiate(pos, state);
    }
}
