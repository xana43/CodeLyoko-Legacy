package com.Ultra_Nerd.CodeLyokoLegacy.blocks.tests;

import net.minecraft.block.Block;

public final class TestBlockPortal extends Block {
    public TestBlockPortal(final Settings settings) {
        super(settings);
    }
/*
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

 */


}
