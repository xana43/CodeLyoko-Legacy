package com.Ultra_Nerd.CodeLyokoLegacy.blocks.tests;

import com.Ultra_Nerd.CodeLyokoLegacy.screens.TestScreens.PlayerProfileDebug;
import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PlayerCustomProfileTest extends Block {
    public PlayerCustomProfileTest(final Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final Hand hand, final BlockHitResult hit) {
        final MinecraftClient client = MinecraftClient.getInstance();
        CardinalData.PlayerSavedProfile.saveProfile(world.getLevelProperties(), player);
        if(world.isClient()) {
            client.setScreen(new PlayerProfileDebug(Text.empty(), player, world.getLevelProperties()));
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }


}
