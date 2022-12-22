package com.Ultra_Nerd.CodeLyokoLegacy.blocks.tests;

import com.Ultra_Nerd.CodeLyokoLegacy.screens.ComputerInterfaceUi;
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

public final class TestComputerUI extends Block {
    public TestComputerUI(final Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final Hand hand, final BlockHitResult hit) {
        if(world.isClient())
        {
            MinecraftClient.getInstance().setScreen(new ComputerInterfaceUi(Text.of("test screen"),pos));
        }
        CardinalData.HumanDNAAttribute.setHasDna(player,false);
        return super.onUse(state, world, pos, player, hand, hit);
    }
}
