package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public final class RouterTE extends BlockEntity implements BlockEntityTicker<RouterTE> {
    public RouterTE(@NotNull BlockEntityType<?> tileEntityTypeIn, @NotNull BlockPos pos, @NotNull BlockState state) {
        super(tileEntityTypeIn,pos,state);
    }

    /*public RouterTE() {
        this(ModTileEntities.ROUTER_TILE_ENTITY.get());
    }
     */




    @Override
    public void tick(final World world, final BlockPos pos, final BlockState state, final RouterTE blockEntity) {

    }
}
