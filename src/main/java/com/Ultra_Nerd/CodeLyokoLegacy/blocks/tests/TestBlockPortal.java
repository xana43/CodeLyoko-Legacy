package com.Ultra_Nerd.CodeLyokoLegacy.blocks.tests;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.handlers.DimensionTeleporter;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.ITeleporter;
import org.jetbrains.annotations.NotNull;

public final class TestBlockPortal extends Block implements ITeleporter {

    public TestBlockPortal(@NotNull Properties properties) {
        super(properties);

    }

    @Override
    public void entityInside(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull Entity pEntity) {
        if (pEntity instanceof ServerPlayer player)
        {
            if(pLevel.dimension().equals(ModDimensions.SECTOR5))
            {
                teleportTo(player,pPos.north(),Level.OVERWORLD);
            }
            else
            {
                teleportTo(player,new BlockPos(0,128,0).north(),ModDimensions.SECTOR5);
            }
        }
    }

    private void teleportTo(@NotNull ServerPlayer player, @NotNull BlockPos pos, @NotNull ResourceKey<Level> levelResourceKey)
    {

        DimensionTeleporter.teleportPlayerToWorld(player,player.getServer().getLevel(levelResourceKey),new BlockPos(pos.getX(),pos.getY(),pos.getZ()),false);
    }


}
