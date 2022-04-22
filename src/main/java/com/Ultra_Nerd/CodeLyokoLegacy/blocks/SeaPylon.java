package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;


public final class SeaPylon extends Block {


    public static final DirectionProperty DIRPYLON = HorizontalFacingBlock.FACING;

    public SeaPylon() {
        super(FabricBlockSettings.of(new Material.Builder(MapColor.GRAY).build())

                .strength(-1, -1)
                .sounds(BlockSoundGroup.GLASS)
                .nonOpaque()



        );

    }

    @Override
    protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(DIRPYLON));
    }



    @Override
    public float getAmbientOcclusionLightLevel(final BlockState state, final BlockView world, final BlockPos pos) {
        return 5;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(final ItemPlacementContext ctx) {
        return this.getDefaultState().with(DIRPYLON,ctx.getPlayerLookDirection().getOpposite());
    }











}