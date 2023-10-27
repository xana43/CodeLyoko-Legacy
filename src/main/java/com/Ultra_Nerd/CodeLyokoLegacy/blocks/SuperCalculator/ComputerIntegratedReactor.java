package com.Ultra_Nerd.CodeLyokoLegacy.blocks.SuperCalculator;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities.ComputerReactorBlockEntityInventory;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlockEntities;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public final class ComputerIntegratedReactor extends AbstractFurnaceBlock implements BlockEntityProvider {
    public ComputerIntegratedReactor() {
        super(FabricBlockSettings.copy(Blocks.IRON_BLOCK).strength(6, 10).sounds(BlockSoundGroup.METAL));
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return ModBlockEntities.COMPUTER_REACTOR_TILE_ENTITY.instantiate(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(final BlockState state) {
        return BlockRenderType.MODEL;
    }



    @Override
    protected void openScreen(final World world, final BlockPos pos, final PlayerEntity player) {
       final BlockEntity blockEntity = world.getBlockEntity(pos);
       if(blockEntity instanceof ComputerReactorBlockEntityInventory)
       {
           player.openHandledScreen((NamedScreenHandlerFactory) blockEntity);

       }
    }

    @Nullable
    @Override
    public NamedScreenHandlerFactory createScreenHandlerFactory(final BlockState state, final World world, final BlockPos pos) {
        final BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity instanceof NamedScreenHandlerFactory ? (NamedScreenHandlerFactory)blockEntity : null;
    }
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(final World world, final BlockState state, final BlockEntityType<T> type) {
        return (world1, pos, state1, blockEntity) -> {
            if (blockEntity instanceof final ComputerReactorBlockEntityInventory computerReactorBlockEntityInventory) {
                computerReactorBlockEntityInventory.tick();
            }
        };
    }

    @Override
    public void onStateReplaced(final BlockState state, final World world, final BlockPos pos, final BlockState newState, final boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            final BlockEntity BE = world.getBlockEntity(pos);
            if (BE instanceof final ComputerReactorBlockEntityInventory reactorTile) {
                ItemScatterer.spawn(world, pos, reactorTile);
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public boolean hasComparatorOutput(final BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(final BlockState state, final World world, final BlockPos pos) {
        return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    }
}
